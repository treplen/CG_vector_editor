package editor.buttons;

import editor.Editor;
import editor.options.EditorOption;
import editor.options.RectangleOption;
import editor.options.SelectOption;
import editor.primitives.*;
import editor.primitives.Rectangle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class RectangleButton extends EditorButton {
    public RectangleButton() throws IOException {
        super(ImageIO.read(new File("src/main/resources/rectangle.bmp")), Editor.options.get(RectangleOption.class));
    }
}
