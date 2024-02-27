package com.cibertec.assessment.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.assessment.model.Square;
import com.cibertec.assessment.repo.SquareRepo;
import com.cibertec.assessment.service.PolygonService;
import com.cibertec.assessment.service.SquareService;

@Service
public class SquareServiceImpl implements SquareService{

	@Autowired 
	SquareRepo squareRepo;
	
	@Autowired
	PolygonService polygonService;
	
	//Al momento de crear se debe validar si 
	//alguno de parte del cuadrado se encuentra dentro de algun
	//poligono y de ser asi se debe capturar el id de los poligonos y 
	//guardar como un string pero con formato de array
	//Ejemplo polygons = "["1","2"]"
	//Se guardan los ids correspondites
	//usar los metodos ya existentes para listar polygonos
	@Override
	public Square create(Square s) {
		return null;
	}

	@Override
	public List<Square> list() {
		return null;
	}
	

}
