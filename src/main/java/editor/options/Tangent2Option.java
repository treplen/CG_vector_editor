package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Circle;
import editor.primitives.Primitive;
import editor.primitives.Tangent1;
import editor.primitives.Tangent2;

import javax.swing.*;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class Tangent2Option implements EditorOption {
    @Override
    public void exec(float x, float y) {
        Circle circle1 = null,circle2=null;
        if(Editor.selected.size()!=2)
        {
            JOptionPane.showMessageDialog(null,"Please select two object","More or less than two objects selected",JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(Primitive primitive: Editor.selected)
        {
            if(primitive.getClass()==Circle.class)
            {
                if(circle1==null)
                    circle1=(Circle) primitive;
                else
                    circle2=(Circle) primitive;
            }
            else {
                JOptionPane.showMessageDialog(null,"Please select two circles","Not circle object selected",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        Tangent2 tangent = new Tangent2(circle1,circle2,new Point2D(x,y),Editor.chooser.getColor());
    }
}
