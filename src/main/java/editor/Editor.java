package editor;

import editor.options.*;
import editor.primitives.Circle;
import editor.primitives.Group;
import editor.primitives.Primitive;
import editor.primitives.Rectangle;
import editor.view.ListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class Editor {
    public static HashMap<Class<? extends EditorOption>,EditorOption> options = new HashMap<>();
    public static EditorOption currentOption;

    public final static List<Primitive> primitives=new LinkedList<>();
    public static Primitive tempPrimitive;
    public static JColorChooser chooser;
    public static ListPanel selectPanel;

    public static boolean select=false;

    static {
        options.put(SelectOption.class,new SelectOption());
        options.put(CircleOption.class,new CircleOption());
        options.put(EpicycloidOption.class,new EpicycloidOption());
        options.put(LineOption.class,new LineOption());
        options.put(RectangleOption.class,new RectangleOption());
        currentOption=options.get(SelectOption.class);
        tempPrimitive=null;
        chooser=new JColorChooser();
        chooser.setColor(Color.black);
        selectPanel=new ListPanel();
    }
}
