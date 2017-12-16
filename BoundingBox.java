public class BoundingBox {
    public static boolean intersects(Element left, Element right) {
    	return ( ( (left.getX() < right.getX() && left.getX() + left.getWidth() > right.getX()) || (left.getX() < right.getX() + right.getWidth() && left.getX() + left.getWidth() > right.getX() + right.getWidth()) ) && ( (left.getY() < right.getY() + right.getHeight() && left.getY() > right.getY()) || (left.getY() + left.getHeight() < right.getY() + right.getHeight() && left.getY() + left.getHeight() > right.getY()) ));
    }

    public static boolean isAbove(Element left, Element right, int buffer) {
	return right.getY() + right.getHeight() - left.getY() <= buffer && right.getY() + right.getHeight() - left.getY() >= 0;
    }

    public static boolean hitRoof(Element left, Element right, int buffer) {
	return left.getY() + left.getHeight() - right.getY() >= 0 && left.getY() + left.getHeight() - right.getY() <= buffer && (!hitRight(left, right, buffer) && !hitLeft(left, right, buffer));
    }

    public static boolean hitLeft(Element left, Element right, int buffer) {
	return left.getX() + left.getWidth() - right.getX() >= 0 && left.getX() + left.getWidth() - right.getX() <= buffer;
    }

    public static boolean hitRight(Element left, Element right, int buffer) {
	return right.getX() + right.getWidth() - left.getX() <= buffer && right.getX() + right.getWidth() - left.getX() >= 0;
    }
}
