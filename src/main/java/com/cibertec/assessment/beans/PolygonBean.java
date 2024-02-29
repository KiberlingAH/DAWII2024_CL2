package com.cibertec.assessment.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolygonBean {
	
    private Integer id;

    private String name;

	private int npoints;
	
	private Integer[] xPoints;
	
	private Integer[] yPoints;
	
	//===============================
	
	public Integer[] obtenerxPoints() {
		return xPoints;
	}

	public void settxPoints(Integer[] xPoints) {
		this.xPoints = xPoints;
	}

	public Integer[] obteneryPoints() {
		return yPoints;
	}

	public void settyPoints(Integer[] yPoints) {
		this.yPoints = yPoints;
	}
	
	public int obtenernPoints() {
		return npoints;
	}

	public void settnPoints(int npoints) {
		this.npoints = npoints;
	}
	
	
}
