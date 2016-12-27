package editor.buttons;

import editor.Editor;
import editor.options.EditorOption;
import editor.options.SelectOption;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class SelectButton extends EditorButton {
    public SelectButton() throws IOException {
        super(ImageIO.read(SelectButton.class.getResourceAsStream("/select.bmp")), Editor.options.get(SelectOption.class));
    }
}
