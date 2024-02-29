package com.cibertec.assessment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Square {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private int npoints;

	private String xPoints;// se debe guardar un array de 4 puntos como string

	private String yPoints; // se debe guardar un array de 4 puntos como string

	private String polygons; // se debe guardar un array con los poligonos que intercepte
	
	

//------------------------------------------------------------------------------------
	public Integer[] obtenerXPoints() {
		if (this.xPoints != null && !this.xPoints.isEmpty()) {
			String[] parts = this.xPoints.substring(1, this.xPoints.length() - 1).split(", ");
			Integer[] xPointsArray = new Integer[parts.length];
			for (int i = 0; i < parts.length; i++) {
				xPointsArray[i] = Integer.parseInt(parts[i]);
			}
			return xPointsArray;
		} else {
			throw new IllegalStateException("Los puntos x no pueden estar vacíos en un cuadrado.");
		}
	}

	public Integer[] obtenerYPoints() {
		if (this.yPoints != null && !this.yPoints.isEmpty()) {
			String[] parts = this.yPoints.substring(1, this.yPoints.length() - 1).split(", ");
			Integer[] yPointsArray = new Integer[parts.length];
			for (int i = 0; i < parts.length; i++) {
				yPointsArray[i] = Integer.parseInt(parts[i]);
			}
			return yPointsArray;
		} else {
			throw new IllegalStateException("Los puntos y no pueden estar vacíos en un cuadrado.");
		}
	}
	
	public String getPolygons() {
		return polygons;
	}
	
	public void setPolygons(String polygons) {
		this.polygons = polygons;
	}

	public void obtenerPolygons(String polygonsArray) {
		this.polygons = polygonsArray;
	}

	public String getxPoints() {
		return xPoints;
	}

	public void setxPoints(String xPoints) {
		this.xPoints = xPoints;
	}

	public String getyPoints() {
		return yPoints;
	}

	public void setyPoints(String yPoints) {
		this.yPoints = yPoints;
	}

}
