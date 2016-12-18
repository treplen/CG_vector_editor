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
    public EditorToolBar toolBar;
    public static double mouseX, mouseY;
    public static Dimension size = new Dimension(2200, 1400);
    public static Dimension screenSize = new Dimension(1100,700);
    public static JScrollPane scrollPane;

    public EditorFrame() {
        setSize(screenSize);
        setMinimumSize(screenSize);
        setMaximumSize(screenSize);
        setPreferredSize(screenSize);
        canvas = new EditorCanvas();
        scrollPane = new JScrollPane(canvas);
        scrollPane.setSize(screenSize);
        scrollPane.setMinimumSize(screenSize);
        scrollPane.setMaximumSize(screenSize);
        scrollPane.setPreferredSize(screenSize);
        addKeyListener(new KeyboardListener());
        scrollPane.addMouseListener(new MouseListenerImpl());
        scrollPane.addMouseMotionListener(new MouseMotionListenerImpl());
        getContentPane().add(scrollPane);
        toolBar=new EditorToolBar();
        setJMenuBar(toolBar);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vector editor");
        pack();
        setVisible(true);

    }

    public void setCanvasBackground(Color color)
    {
        canvas.setBackground(color);
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
