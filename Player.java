import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

import java.lang.Math.*;

public class Player extends Element {
    private double xVel = 0;
    private double yVel = 0;
    
    private boolean movingLeft  = false;
    private boolean movingRight = false;
    
    private boolean enablePhysics = true;
    private boolean enableJump    = true;
    private boolean enableGravity = true;
	private boolean onGround      = false;

    public Player(double x, double y, double width, double height) {
    	super(x, y, width, height, Color.GREEN);   	
    	setUpdate(true);
    }
    
    public void update() {

        if (enablePhysics) {
	    	if (xVel > 0) {
		    	xVel += Constants.PLAYER_MASS * Constants.GRAVITY * Constants.FRIC;
		        if (xVel < 0) xVel = 0;
		    }

		    if (xVel < 0) {
		  	 	xVel -= Constants.PLAYER_MASS * Constants.GRAVITY * Constants.FRIC;
		        if (xVel > 0) xVel = 0;
		    }
	    }

        if (getY() <= 0) {
			setY(0);
			yVel = 0;      
	    } else if (enableGravity) {
    		yVel += Constants.GRAVITY;
    	}

    	updatePos(xVel, yVel);
    }
    
    public Element[][] move(String action, Element[][] data) {
        double oldXVel = xVel;
        double oldYVel = yVel;
        double oldX = getX();
        double oldY = getY();

		if (action.equals("move left") || movingLeft) {
		    movingLeft = true;	
		    
            // Smooth Turning in mid-air
            if ((getY() != 0 && !enablePhysics) && xVel > 0) {
			    xVel -= Constants.PLAYER_ACC;
		    }
		    
			xVel -= Constants.PLAYER_ACC;
            if (-xVel > Constants.PLAYER_MOVE_SPEED) xVel = -Constants.PLAYER_MOVE_SPEED; 
		}

        if (action.equals("move right") || movingRight) {	
            movingRight = true;
            
            // Smooth Turning in mid-air
            if (getY() != 0 && xVel < 0) {
			    xVel += Constants.PLAYER_ACC;
		    }
		    
			xVel += Constants.PLAYER_ACC;
            if (xVel > Constants.PLAYER_MOVE_SPEED) xVel = Constants.PLAYER_MOVE_SPEED;
		}

        if (action.equals("jump") && (getY() == 0 || enableJump)) {
			if (yVel < 0) yVel = 0;
			yVel += Constants.PLAYER_JUMP_SPEED;
            setY(getY() + 1);
            enableJump = false;
		}
		
		if (action.equals("move left released")) movingLeft = false;
		if (action.equals("move right released")) movingRight = false;
		
		if (action.equals("grapple")) {
		   data[1][0] = new Grapple(getX(), getY(), Constants.GRAPPLE_SIZE, Constants.GRAPPLE_SIZE, Constants.GRAPPLE_SPEED);
		}

		updatePos(xVel, yVel);

		onGround = false;
		for (int i = 0; data[2][i] != null; i++) {
			if (BoundingBox.intersects(this, data[2][i]) || BoundingBox.intersects(data[2][i], this)) {
				if (BoundingBox.isAbove(this, data[2][i])) {
					yVel = 0;
					setY(data[2][i].getY() + data[2][i].getHeight());
					enableJump = true;
					//enablePhysics = true;
					onGround = true;
				} 
				
				if (BoundingBox.hitRoof(this, data[2][i])) {
System.out.println("Whoah there big guy");
					yVel = Constants.GRAVITY;
					updatePos(0, yVel);
					enableJump = false;
				} 
				
				if (BoundingBox.hitLeft(this, data[2][i]) && !onGround) {
					setX(data[2][i].getX() - this.getWidth());
					//yVel += Constants.GRAVITY;
					enableJump = true;
				}
				
				if (BoundingBox.hitRight(this, data[2][i]) && !onGround) {
					setX(data[2][i].getX() + data[2][i].getWidth());
					//yVel += Constants.GRAVITY;
					enableJump = true;
				}

				//enablePhysics = false;
				i = 0;
			}
		}

		return data;
	}
	
    public void updatePos(double xVel, double yVel) {
        //System.out.println(getX() + " " + getY() + " " + xVel + " " + yVel);
        setX(getX() + xVel);
        setY(getY() + yVel);
    }

    public void getHurt() {
	    System.out.println("YEEEEOWCH!!!!");
    }
}



