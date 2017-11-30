import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;
import java.awt.Color;

import java.lang.Math.*;

public class Level {
    private int width;
    private int height;
    private Element[][] data;

    public Level(int width, int height, Element[][] data) {
    	this.width  = width;
    	this.height = height;
    	this.data   = data;
    }

    public void buildLevel(Graphics g) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
                Element temp = data[i][j];
                g.setColor(temp.getColor());
				g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());			
			}
		}
    }

    public void updateLevel() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
					
			}
		}
    }
}
