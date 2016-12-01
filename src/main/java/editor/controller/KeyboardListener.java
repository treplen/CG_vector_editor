package editor.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

  public void keyPressed(KeyEvent e) {
    if(e==null)
      return;
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
    }
    if (e.getKeyCode() == KeyEvent.VK_T) {
    }
    if (e.getKeyCode() == KeyEvent.VK_R) {
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
  }
}
