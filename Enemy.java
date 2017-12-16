import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

import java.lang.Math.*;

public class Enemy extends Element {
    private double xVel = Constants.ENEMY_MOVE_SPEED;
    private double yVel = 0;
    
    private boolean movingLeft  = false;
    private boolean movingRight = false;
    
    private boolean enablePhysics = true;
    private boolean enableGravity = true;

    public Enemy(double x, double y, double width, double height) {
    	super(x, y, width, height, Color.RED);   	
    	setUpdate(true);
    }
    
    public void update() {
        if (getY() <= 0) {
			setY(0);
			yVel = 0;
	    } else if (enableGravity) {
    		yVel += Constants.GRAVITY;
    	}
       
    	updatePos(xVel, yVel);
    }

    public Element[][] move(String action, Element[][] data) {/*
        double oldXVel = xVel;
        double oldYVel = yVel;
        double oldX = getX();
        double oldY = getY();

		updatePos(xVel, yVel);
          
        int j = 0;
		for (int i = 0; data[j][i] != null; i++) {

            if (getY() - oldY > 1) yVel = 1;
			if (BoundingBox.intersects(this, data[j][i]) || BoundingBox.intersects(data[2][i], this)) {
                if (j == 0 && i == 0) ((Player)data[j][i]).getHurt();
				if (!BoundingBox.isAbove(this, data[j][i])) {
					//setX(oldX - (getX() - oldX));
    				yVel += Constants.GRAVITY;
			    }

                if (BoundingBox.hitRoof(this, data[j][i])) {
System.out.println("ASDJIFAKSDFADSF");
                    yVel = Constants.GRAVITY;		
                    updatePos(0, yVel);
                } else {
					setY(oldY - (getY() - oldY));
                    yVel = 0;
				}
//System.out.println(BoundingBox.isAbove(this, data[j][i]));
                if (((BoundingBox.hitLeft(this, data[j][i])) || (BoundingBox.hitRight(this, data[j][i]))) && (!BoundingBox.hitRoof(this, data[j][i]) && !(BoundingBox.isAbove(this, data[j][i])))) { xVel *= -1; //System.out.println("HIT: " + getX() + " " + getY() + " " + data[j][i].getY() + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
}

				enablePhysics = false;
			    i = 0;

		    } else {
		        enablePhysics = true;
		    }
         
            if (j == 0) {
				j = 2;
                i--;
            }
	    }

		return data;*/ return null;
	}
	
    public void updatePos(double xVel, double yVel) {
        System.out.println(getX() + " " + getY() + " " + xVel + " " + yVel);
        setX(getX() + xVel);
        setY(getY() + yVel);
    }
}



