package GeomAbstract;

class Circle extends GeometricObject{

	protected int radius;
	
	Circle(int initX, int initY, int initR) {
		super(initX, initY);
		radius= initR;
	}
	
	public void setRadius(int newR)
	{
		radius = newR;
	}

	void draw()
	{
		// drawing implemenation...
	}


}


