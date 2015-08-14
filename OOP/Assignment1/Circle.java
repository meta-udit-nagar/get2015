public class Circle implements Shape {
	private int radius;
	public Circle(int radius) {
	this.radius = radius;
	}
	public void draw() {
		System.out.println("this is draw of circle");
	}
	public double getArea() {
		double area = 3.14 * (radius * radius);
		return area;
	}
}