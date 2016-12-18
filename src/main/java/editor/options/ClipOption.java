package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Primitive;
import editor.primitives.Rectangle;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class ClipOption implements EditorOption {
    @Override
    public void exec(float x, float y) {
        if(Editor.tempPrimitive==null)
            Editor.tempPrimitive=new Rectangle(new Point2D(x,y),Editor.chooser.getColor());
        else {
            boolean done;
            done = Editor.tempPrimitive.step(x, y);
            if (done) {
                for(Primitive primitive:Editor.selected)
                    primitive.setClip((Rectangle) Editor.tempPrimitive);
                Editor.tempPrimitive = null;
            }
        }
    }
}
