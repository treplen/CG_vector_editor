package editor.options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class SelectOption implements EditorOption {
    public SelectOption()
    {

    }

    public void exec() {
        System.out.println(this.getClass());
    }
}
