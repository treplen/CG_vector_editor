package editor.view;

import editor.Editor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svuatoslav on 12/4/16.
 */
public class ColorFrame extends JFrame{
    public static Dimension size = new Dimension(50, 300);

    public ColorFrame()
    {
        add(Editor.chooser);
        setResizable(false);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Color select");
        pack();
        setVisible(false);
    }
}
