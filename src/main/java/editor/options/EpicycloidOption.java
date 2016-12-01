package editor.options;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class EpicycloidOption implements EditorOption {
    @Override
    public void exec(float x, float y) {
        System.out.println(this.getClass());
    }
}
