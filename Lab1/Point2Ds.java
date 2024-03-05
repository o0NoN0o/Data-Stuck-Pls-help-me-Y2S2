import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Point2Ds {
	private Point2D[] points;
	
	public Point2D getPoint(int i) {
		// Return the point object at index i 
		
		// Put your code here 
		
		
		
		
		
		return points[i];
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points 
	
		// Put your code here 
		points = new Point2D[20];
		filename = "C:\\Users\\picha\\eclipse-workspace\\Lab1\\src\\" + filename;
		try(Scanner reader = new Scanner(new File(filename))) {
			for(int i = 0;i < 20;i++) {
				double x = reader.nextDouble();
				double y = reader.nextDouble();
				points[i] = new Point2D(x,y);
			}
		}	
		
		
		
		
	}
	
	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin 
		
		// Put your code here 
		Point2D origin = new Point2D(0,0);
		double min = Double.MAX_VALUE;
		int index = 0;
		for(int i = 0;i < points.length;i++) {
			double dis = points[i].distance(origin);
			if(dis < min) {
				min = dis;
				index = i;
			}
		}
		return points[index];
	}

	public Point2D getClosestPoint(double x,double y) {
		// Return the point that is closest to x,y 

		// Put your code here 
		Point2D point2 = new Point2D(x,y);
		double min = Double.MAX_VALUE;
		int index = 0;
		for(int i = 0;i < points.length;i++) {
			double dis = points[i].distance(point2);
			if(dis < min) {
				min = dis;
				index = i;
			}
		}
		return points[index];
	}
}
