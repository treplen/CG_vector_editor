package editor.view.dialogues;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.CSS;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by svuatoslav on 12/10/16.
 */
public class ScaleDialog {

    private static JTextField scale = new JTextField(20);
    private static JLabel label = new JLabel("Input scale:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[2];

    static {
        AbstractDocument document = (AbstractDocument) scale.getDocument();
        final int maxCharacters = 20;
        document.setDocumentFilter(new FloatFilter());
        components[0]=label;
        components[1]=scale;
    }

    public static void show()
    {
        scale.setText("1");
        result=JOptionPane.showConfirmDialog(null, components , "Input scale", JOptionPane.PLAIN_MESSAGE);
    }

    public static boolean success()
    {
        return result==JOptionPane.OK_OPTION;
    }

    public static float getScale()
    {
            return Float.parseFloat(scale.getText());
    }
}