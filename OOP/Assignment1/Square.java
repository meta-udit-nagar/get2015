public class Square implements Shape {
	private int side;
	public Square(int side) {
	this.side = side;
	}
	public void draw() {
		System.out.println("This is draw of square");
	}
	public double getArea() {
		double area = side * side;
		return area;
	}
}