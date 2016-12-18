package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Circle;
import editor.primitives.Primitive;
import editor.primitives.Tangent1;

import javax.swing.*;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class Tangent1Option implements EditorOption {
    @Override
    public void exec(float x, float y) {
        Circle circle = null;
        if(Editor.selected.size()!=1)
        {
            JOptionPane.showMessageDialog(null,"Please select one object","Multiple or zero objects selected",JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(Primitive primitive: Editor.selected)
        {
            if(primitive.getClass()==Circle.class)
            {
                circle=(Circle) primitive;
            }
            else {
                JOptionPane.showMessageDialog(null,"Please select a circle","Not circle object selected",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        Tangent1 tangent = new Tangent1(circle,new Point2D(x,y),circle.getRealColor());
    }
}
