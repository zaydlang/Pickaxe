public class BoundingBox {
    /*public double width;
    public double height;
    
    public BoundingBox(double width, double height) {
    	this.width  = width;
    	this.height = height;
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }*/
    
    public static boolean intersects(Element left, Element right) {
    	return ( ( (left.getX() < right.getX() && left.getX() + left.getWidth() > right.getX()) || (left.getX() < right.getX() + right.getWidth() && left.getX() + left.getWidth() > right.getX() + right.getWidth()) ) && ( (left.getY() < right.getY() + right.getHeight() && left.getY() > right.getY()) || (left.getY() + left.getHeight() < right.getY() + right.getHeight() && left.getY() + left.getHeight() > right.getY()) ));
    }

    public static boolean isAbove(Element left, Element right) {
	return right.getY() + right.getHeight() - left.getY() <= 1 && right.getY() + right.getHeight() - left.getY() >= 0;
    }

    public static boolean hitRoof(Element left, Element right) {
	return left.getY() + left.getHeight() - right.getY() >= 0 && left.getY() + left.getHeight() - right.getY() <= (right.getHeight() / 2) && (!hitRight(left, right) && !hitLeft(left, right));
    }

    public static boolean hitLeft(Element left, Element right) {
	return left.getX() + left.getWidth() - right.getX() >= 0 && left.getX() + left.getWidth() - right.getX() <= (right.getWidth() / 2);
    }

    public static boolean hitRight(Element left, Element right) {
	return right.getX() + right.getWidth() - left.getX() <= (right.getWidth() / 2) && right.getX() + right.getWidth() - left.getX() >= 0;
    }
}
