package editor.controller;

import editor.Editor;
import editor.Main;
import editor.options.SelectOption;
import editor.primitives.Primitive;
import editor.view.ListFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

public class KeyboardListener implements KeyListener {

  public void keyPressed(KeyEvent e) {
    if(e==null)
      return;
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
    }
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      Editor.tempPrimitive=null;
      Main.update();
    }
    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
      List<Primitive> toRemove=new LinkedList<>();
      for(Primitive primitive: Editor.selected)
      {
        toRemove.add(primitive);
      }
      for(Primitive primitive:toRemove) {
        Editor.primitives.remove(primitive);
        Editor.selected.remove(primitive);
        List<Primitive> collapsed=primitive.collapse();
        if(collapsed!=null)
          for(Primitive primitive1:collapsed)
            Editor.primitives.add(primitive1);
      }
      Main.update();
    }
    if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
      Editor.select=true;
    }
  }

  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
      Editor.select=false;
    }
  }

  public void keyTyped(KeyEvent e) {
  }
}
