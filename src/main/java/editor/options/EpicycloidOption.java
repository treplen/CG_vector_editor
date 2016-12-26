package editor.options;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.primitives.Circle;
import editor.primitives.Epicycloid;
import editor.view.dialogues.InputEpicycloid;

import java.awt.*;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class EpicycloidOption implements EditorOption {
    @Override
    public void exec(float x, float y) {

        Epicycloid epicycloid = InputEpicycloid.exec(x,y, Editor.chooser.getColor());
        if(epicycloid!=null)
            Editor.primitives.add(epicycloid);
    }
}
