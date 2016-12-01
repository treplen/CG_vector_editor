package editor.buttons;

import editor.Editor;
import editor.options.EditorOption;
import editor.options.LineOption;
import editor.options.SelectOption;
import editor.primitives.Line;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class LineButton extends EditorButton {
    public LineButton() throws IOException {
        super(ImageIO.read(new File("src/main/resources/line.bmp")), Editor.options.get(LineOption.class));
    }
}
