package editor.options;

import editor.Editor;
import editor.primitives.Primitive;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class RemoveAdditionsOption implements EditorOption {
    @Override
    public void exec(float x, float y) {
        for(Primitive primitive: Editor.selected)
            primitive.clearAdditions();
    }
}
