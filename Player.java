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
    
    public Player(double x, double y, double width, double height) {
    	super(x, y, width, height, Color.GREEN);   	
    	setUpdate(true);
    }
    
    public void update() {
        if (getY() <= 0) {
			setY(0);
			yVel = 0;

            if (xVel > 0) {
	  	 	    xVel += Constants.PLAYER_MASS * Constants.GRAVITY * Constants.FRIC;
                if (xVel < 0) xVel = 0;
            }

            if (xVel < 0) {
	  	 	    xVel -= Constants.PLAYER_MASS * Constants.GRAVITY * Constants.FRIC;
                if (xVel > 0) xVel = 0;
            }
	    } else {
    		yVel += Constants.GRAVITY;
    	}
       
    	updatePos(xVel, yVel);
    }
    
    public void move(String action) {
		if (action.equals("move left") || movingLeft) {
		    movingLeft = true;	
		    
            // Smooth Turning in mid-air
            if (getY() != 0 && xVel > 0) {
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

        if (action.equals("jump")) {	
            if (getY() != 0) return;
			yVel += Constants.PLAYER_JUMP_SPEED;
            setY(getY() + 1);
		}
		
		if (action.equals("move left released")) movingLeft = false;
		if (action.equals("move right released")) movingRight = false;
		
		if (action.equals("grapple")) grapple();
	}
	
	public void grapple() {
	
	}
	
    public void updatePos(double xVel, double yVel) {
        //System.out.println(getX() + " " + getY() + " " + xVel + " " + yVel);
        setX(getX() + xVel);
        setY(getY() + yVel);
    }
}
