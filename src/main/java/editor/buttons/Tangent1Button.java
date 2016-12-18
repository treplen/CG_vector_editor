package editor.buttons;

import editor.Editor;
import editor.options.Tangent1Option;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class Tangent1Button extends EditorButton {
    public Tangent1Button() throws IOException {
        super(ImageIO.read(new File("src/main/resources/tangent1.bmp")), Editor.options.get(Tangent1Option.class));
    }
}
