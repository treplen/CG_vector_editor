package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Circle;
import editor.primitives.Line;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class LineOption implements EditorOption {
    @Override
    public void exec(float x, float y) {
        if(Editor.tempPrimitive==null)
            Editor.tempPrimitive=new Line(new Point2D(x,y),Editor.chooser.getColor());
        else {
            boolean done;
            done = Editor.tempPrimitive.step(x, y);
            if (done) {
                Editor.primitives.add(Editor.tempPrimitive);
                Editor.tempPrimitive = null;
            }
        }
    }
}
