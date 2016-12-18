package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Primitive;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class MirrorOption implements EditorOption {
    @Override
    public void exec(float x, float y) {
        for(Primitive primitive : Editor.selected)
            primitive.reflect(new Point2D(x,y));
    }
}
