package com.cibertec.assessment.service.imp;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.assessment.beans.PolygonBean;

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
	
	@Override
    public Square create(Square s) {
        List<Integer> intersectedPolygonIds = findIntersectedPolygonIds(s);

        String polygons = convertListToFormattedString(intersectedPolygonIds);

        s.setPolygons(polygons);

        return squareRepo.save(s);
    }

    @Override
    public List<Square> list() {
        return squareRepo.findAll();
    }

    private List<Integer> findIntersectedPolygonIds(Square square) {
        List<PolygonBean> polygons = polygonService.list();

        List<Integer> intersectedPolygonIds = new ArrayList<>();

        for (PolygonBean polygon : polygons) {
            if (intersects(square, polygon)) {
                intersectedPolygonIds.add(polygon.getId());
            }
        }

        return intersectedPolygonIds;
    }

    private boolean intersects(Square square, PolygonBean polygon) {
    	Integer[] xArr = square.obtenerXPoints();
    	Integer[] yArr = square.obtenerYPoints();
        for (int i = 0; i < xArr.length; i++) { 
        	int x = xArr[i];
            int y = yArr[i];
            if (isPointInsidePolygon(x, y, polygon)) {
                return true;
            }
        }
        return false; 
    }
         
    
    private boolean isPointInsidePolygon(int x, int y, PolygonBean polygon) {
        Integer[] xPoints = polygon.obtenerxPoints();
        Integer[] yPoints = polygon.obteneryPoints();
        int npoints = xPoints.length;
        
        boolean inside = false;
        for (int i = 0, j = npoints - 1; i < npoints; j = i++) {
            if ((yPoints[i] > y) != (yPoints[j] > y) &&
                (x < (xPoints[j] - xPoints[i]) * (y - yPoints[i]) / (yPoints[j] - yPoints[i]) + xPoints[i])) {
                inside = !inside;
            }
        }
        return inside;
    }
    
     

    private String convertListToFormattedString(List<Integer> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(" ").append(list.get(i)).append(" ");
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

		
	
}
