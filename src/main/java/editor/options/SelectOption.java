package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Primitive;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class SelectOption implements EditorOption {
    public SelectOption()
    {

    }

    public void exec(float x, float y) {
        for(Primitive primitive : Editor.primitives)
        {
            if(primitive.contains(new Point2D(x,y)))
                primitive.select(true);
            else
                primitive.select(false);
        }
    }
}
