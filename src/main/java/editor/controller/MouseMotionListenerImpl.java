package editor.controller;

import editor.Editor;
import editor.Main;
import editor.view.EditorCanvas;
import editor.view.EditorFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class MouseMotionListenerImpl implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(Editor.tempPrimitive!=null) {
            Editor.tempPrimitive.sendMsg(e.getXOnScreen(), e.getYOnScreen());
            Main.update();
        }
    }
}
