package editor.buttons;

import editor.Editor;
import editor.options.EditorOption;
import editor.options.EpicycloidOption;
import editor.options.SelectOption;
import editor.primitives.Epicycloid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class EpicycloidButton extends EditorButton {
    public EpicycloidButton() throws IOException {
        super(ImageIO.read(new File("src/main/resources/epicycloid.bmp")), Editor.options.get(EpicycloidOption.class));
    }
}
