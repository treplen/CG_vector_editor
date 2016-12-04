package editor;

import editor.options.SelectOption;
import editor.view.ColorFrame;
import editor.view.EditorFrame;
import editor.view.ListFrame;
import editor.view.OptionsFrame;

import javax.swing.*;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.text.html.Option;
import java.awt.*;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class Main {
    public static EditorFrame frame;
    public static OptionsFrame optionsFrame;
    public static ColorFrame colorFrame;
    public static ListFrame listFrame;

    public static void main(String[] args) throws ClassNotFoundException {
        new Editor();
        frame=new EditorFrame();
        optionsFrame=new OptionsFrame();
        colorFrame=new ColorFrame();
        listFrame=new ListFrame();
        update();
    }

    public static void update()
    {
        frame.render();
        listFrame.update();
    }

    public static void kill()
    {
        frame.dispose();
        optionsFrame.dispose();
        colorFrame.dispose();
        listFrame.dispose();
    }
}
