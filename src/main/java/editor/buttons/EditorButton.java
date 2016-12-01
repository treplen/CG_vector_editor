package editor.buttons;

import editor.Editor;
import editor.options.EditorOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class EditorButton extends JButton {

    public EditorButton(Image image, final EditorOption option)
    {
        setIcon(new ImageIcon(image));
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Editor.currentOption=option;
                Editor.tempPrimitive=null;
            }
        });
        setBackground(Color.WHITE);
        setForeground(Color.WHITE);
    }

}
