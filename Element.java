import java.awt.Color;

public class Element {
   private int x;
   private int y;
   private int width;
   private int height;
   
   private Color c;
   
   public Element(int x, int y, int width, int height, Color c) {
      this.x      = x;
      this.y      = y;
      this.width  = width;
      this.height = height;
      this.c      = c;
   }
   
   public int getX()      { return x; }
   public int getY()      { return y; }
   public int getWidth()  { return width; }
   public int getHeight() { return height; }
   public Color getColor()  { return c; }
   
   public void setX(int x)           { this.x = x; }
   public void setY(int y)           { this.y = y; }
   public void setWidth(int width)   { this.width = width; }
   public void setHeight(int height) { this.height = height; }
}	
