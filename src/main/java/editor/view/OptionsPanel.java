package editor.view;

import editor.Editor;
import editor.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class OptionsPanel extends JPanel {
    public OptionsPanel()
    {

        setLayout(new GridLayout(5,1));
        try {
            JButton button = new SelectButton();
            add(button);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JButton button = new LineButton();
            add(button);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JButton button = new RectangleButton();
            add(button);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JButton button = new CircleButton();
            add(button);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JButton button = new EpicycloidButton();
            add(button);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
