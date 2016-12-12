package editor.view.dialogues;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

/**
 * Created by svuatoslav on 12/10/16.
 */
public class MoveDialog {
    private static JTextField dX = new JTextField(20);
    private static JTextField dY = new JTextField(20);
    private static JLabel xLabel = new JLabel("dX:");
    private static JLabel yLabel = new JLabel("dY:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[4];

    static {
        AbstractDocument document = (AbstractDocument) dX.getDocument();
        document.setDocumentFilter(new FloatFilter());

        document = (AbstractDocument) dY.getDocument();
        document.setDocumentFilter(new FloatFilter());

        components[0]=xLabel;
        components[1]=dX;
        components[2]=yLabel;
        components[3]=dY;
    }

    public static void show()
    {
        dX.setText("0");
        dY.setText("0");
        result=JOptionPane.showConfirmDialog(null, components , "Input displacement", JOptionPane.PLAIN_MESSAGE);
    }

    public static boolean success()
    {
        return result==JOptionPane.OK_OPTION;
    }

    public static float getDX()
    {
        return Float.parseFloat(dX.getText());
    }

    public static float getDY()
    {
        return Float.parseFloat(dY.getText());
    }

}

