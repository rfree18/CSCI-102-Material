package GeomInterface;

class Circle implements GeometricObject{

	protected int x,y;
	protected int radius;
	
	Circle(int initX, int initY, int initR) {
		x = initX;
		y = initY;
		radius= initR;
	}
	
	public void moveTo(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void draw()
	{
		// drawing implemenation...
	}

	public void setRadius(int newR)
	{
		radius = newR;
	}


	public void setRadius(double newR)
	{
		radius = (int) newR;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getRadius()
	{
		return radius;
	}


	public static void main(String[] args) {
		Circle c = new Circle(1, 2, 4);
		System.out.println("the coordinates are (" + c.getX() + ","  + c.getY() + ")");
		System.out.println("c.radius = " + c.getRadius());
		c.setRadius(8.7);
		System.out.println("c.radius = " + c.getRadius());
	}
}


