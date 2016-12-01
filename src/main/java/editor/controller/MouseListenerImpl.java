package editor.controller;

import editor.Editor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class MouseListenerImpl implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        Editor.currentOption.exec();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
