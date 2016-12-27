package editor.buttons;

import editor.Editor;
import editor.options.MirrorOption;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class MirrorButton extends EditorButton {
    public MirrorButton() throws IOException {
        super(ImageIO.read(MirrorButton.class.getResourceAsStream("/mirror.bmp")), Editor.options.get(MirrorOption.class));
    }
}
