package editor.buttons;

import editor.Editor;
import editor.options.ClipOption;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class ClipButton extends EditorButton {
    public ClipButton() throws IOException {
        super(ImageIO.read(new File("src/main/resources/clip.bmp")), Editor.options.get(ClipOption.class));
    }
}
