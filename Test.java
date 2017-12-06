import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

import java.lang.Math.*;

import java.util.ArrayList;
public class Test extends JFrame {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String MOVE_UP = "move up";
    private static final String MOVE_DOWN = "move down";
    private static final String FIRE = "move fire";

    static JLabel obj1 = new JLabel();
    static JLabel obj2 = new JLabel();

    public Test() {

//      Do all the layout management and what not...

        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
//      ...
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("control CONTROL"), FIRE);
        obj2.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
        obj2.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
//      ...
        obj2.getInputMap(IFW).put(KeyStroke.getKeyStroke("T"), FIRE);

        obj1.getActionMap().put(MOVE_UP, new MoveAction(1, 1));
        obj1.getActionMap().put(MOVE_DOWN, new MoveAction(2, 1));
//      ...
        obj1.getActionMap().put(FIRE, new FireAction(1));
        obj2.getActionMap().put(MOVE_UP, new MoveAction(1, 2));
        obj2.getActionMap().put(MOVE_DOWN, new MoveAction(2, 2));
//      ...
        obj2.getActionMap().put(FIRE, new FireAction(2));

//      In practice you would probably create your own objects instead of the JLabels.
//      Then you can create a convenience method obj.inputMapPut(String ks, String a)
//      equivalent to obj.getInputMap(IFW).put(KeyStroke.getKeyStroke(ks), a);
//      and something similar for the action map.

        add(obj1);
        add(obj2);
//      Do other GUI things...
setVisible(true);
    }

    static void rebindKey(KeyEvent ke, String oldKey) {

//      Depends on your GUI implementation.
//      Detecting the new key by a KeyListener is the way to go this time.
        obj1.getInputMap(IFW).remove(KeyStroke.getKeyStroke(oldKey));
//      Removing can also be done by assigning the action name "none".
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStrokeForEvent(ke),
                 obj1.getInputMap(IFW).get(KeyStroke.getKeyStroke(oldKey)));
//      You can drop the remove action if you want a secondary key for the action.
    }

    public static void main(String[] args) {

        new Test();
    }

    private class MoveAction extends AbstractAction {

        int direction;
        int player;

        MoveAction(int direction, int player) {

            this.direction = direction;
            this.player = player;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Same as the move method in the question code.
            // Player can be detected by e.getSource() instead and call its own move method.
        }
    }

    private class FireAction extends AbstractAction {

        int player;

        FireAction(int player) {

            this.player = player;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // Same as the fire method in the question code.
            // Player can be detected by e.getSource() instead, and call its own fire method.
            // If so then remove the constructor.
        }
    }
}
