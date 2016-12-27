package editor.buttons;

import editor.Editor;
import editor.options.CircleOption;
import editor.options.EditorOption;
import editor.options.SelectOption;
import editor.primitives.Circle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class CircleButton extends EditorButton {
    public CircleButton() throws IOException {
        super(ImageIO.read(CircleButton.class.getResourceAsStream("/circle.bmp")), Editor.options.get(CircleOption.class));
    }
}
