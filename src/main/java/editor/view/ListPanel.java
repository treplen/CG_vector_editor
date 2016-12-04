package editor.view;

import editor.Editor;
import editor.primitives.Primitive;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by svuatoslav on 12/4/16.
 */
public class ListPanel extends JList<Primitive> {

    public ListPanel()
    {
        setMinimumSize(new Dimension(100,500));
        setMaximumSize(new Dimension(100,500));
        setLayoutOrientation(JList.VERTICAL);

    }

    public void update()
    {
        Vector<Primitive> names=new Vector<>();
        for(Primitive primitive: Editor.primitives)
            names.add(primitive);
        setListData(names);
    }
}
