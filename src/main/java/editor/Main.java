package editor;

import editor.options.SelectOption;
import editor.view.EditorFrame;
import editor.view.OptionsFrame;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class Main {
    public static EditorFrame frame;
    public static OptionsFrame optionsFrame;

    public static void main(String[] args) throws ClassNotFoundException {
        new Editor();
        frame=new EditorFrame();
        optionsFrame=new OptionsFrame();
        update();
    }

    public static void update()
    {
        frame.render();
    }
}
