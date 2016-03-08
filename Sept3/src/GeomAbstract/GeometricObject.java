package GeomAbstract;

abstract class GeometricObject {

protected int x, y;

GeometricObject() {
	x  = 0 ;
	y = 0;
}

GeometricObject(int initX, int initY) {
	x = initX;
	y = initY;
}


void moveTo(int newX, int newY) {
	x = newX;
	y = newY;
}

abstract void draw();

}




