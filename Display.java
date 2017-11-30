import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

import java.lang.Math.*;
public class Display extends JPanel implements ActionListener {
   private final Font font         = new Font("Roboto", Font.BOLD, 48);
   private final int width         = 1200;
   private final int height        = 800;

   private static Level level;
   public Display() {
      setSize(new Dimension(width, height)); 
      setPreferredSize(new Dimension(width, height));
      setLayout(null);
      setVisible(true); 
   }

   public void paint(Graphics g) {
      level.buildLevel(g);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      //this.repaint();
   }

   public static void main(String[] args) {
      Display disp = new Display();

      JFrame frame = new JFrame();
      frame.setTitle("Pickaxe");
      frame.add(disp);
      frame.pack();
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      Element[][] data = {{new Element(0, 0, 100, 100, Color.RED), new Element(0, 100, 100, 100, Color.BLUE)} , {new Element(100, 0, 100, 100, Color.BLUE), new Element(100, 100, 100, 100, Color.RED)}};

      level = new Level(200, 200, data);
   }
}
