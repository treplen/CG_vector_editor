package editor.view;

import editor.controller.KeyboardListener;
import editor.controller.MouseListenerImpl;
import editor.controller.MouseMotionListenerImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class EditorFrame extends JFrame {
    public EditorCanvas canvas;
    public static double mouseX, mouseY;
    public static Dimension size = new Dimension(1100, 700);

    public EditorFrame() {
        setSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        addKeyListener(new KeyboardListener());
        addMouseListener(new MouseListenerImpl());
        addMouseMotionListener(new MouseMotionListenerImpl());
        canvas = new EditorCanvas();
        getContentPane().add(canvas);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vector editor");
        pack();
        setVisible(true);

    }

    public void render() {
        canvas.render();
    }

    private Point getMouseLocation() {
        int x = (MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x);
        int y = (MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y - 24);
        return new Point(x, y);
    }
}
