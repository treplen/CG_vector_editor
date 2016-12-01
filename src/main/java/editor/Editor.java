package editor;

import editor.options.*;
import editor.primitives.Circle;
import editor.primitives.Primitive;
import editor.primitives.Rectangle;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class Editor {
    public final static HashMap<Class<? extends EditorOption>,EditorOption> options = new HashMap<>();
    public static EditorOption currentOption;

    public final static List<Primitive> primitives=new LinkedList<>();
    public static Primitive tempPrimitive;

    {
        options.put(SelectOption.class,new SelectOption());
        options.put(CircleOption.class,new CircleOption());
        options.put(EpicycloidOption.class,new EpicycloidOption());
        options.put(LineOption.class,new LineOption());
        options.put(RectangleOption.class,new RectangleOption());
        currentOption=options.get(SelectOption.class);
        tempPrimitive=null;
    }
}
