package editor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class OptionsFrame extends JFrame {
    public OptionsPanel options;
    public static Dimension size = new Dimension(50, 300);

    public OptionsFrame(){
        setSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        options = new OptionsPanel();
        add(options);
        setResizable(false);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tools");
        pack();
        setVisible(true);
    }
}
