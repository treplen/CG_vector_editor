package editor.buttons;

import editor.Editor;
import editor.options.RemoveAdditionsOption;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class RemoveAdditionsButton extends EditorButton {
    public RemoveAdditionsButton() throws IOException {
        super(ImageIO.read(new File("src/main/resources/clearAdditions.bmp")), Editor.options.get(RemoveAdditionsOption.class));
    }
}
