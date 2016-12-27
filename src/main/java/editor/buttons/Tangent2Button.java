package editor.buttons;

import editor.Editor;
import editor.options.Tangent2Option;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class Tangent2Button extends EditorButton {
    public Tangent2Button() throws IOException {
        super(ImageIO.read(Tangent2Button.class.getResourceAsStream("/tangent2.bmp")), Editor.options.get(Tangent2Option.class));
    }
}
