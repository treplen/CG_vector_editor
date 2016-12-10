package editor.view.dialogues;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

/**
 * Created by svuatoslav on 12/10/16.
 */
public class MoveDialog {
    private static NumberFormat format = NumberFormat.getInstance();
    private static NumberFormatter formatter = new NumberFormatter(format);

    private static JFormattedTextField dX;
    private static JFormattedTextField dY;
    private static JLabel xLabel = new JLabel("dX:");
    private static JLabel yLabel = new JLabel("dY:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[4];

    static {
        formatter.setValueClass(Float.class);
        formatter.setMinimum(Float.MIN_VALUE);
        formatter.setMaximum(Float.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        dX=new JFormattedTextField(formatter);
        dY=new JFormattedTextField(formatter);
        components[0]=xLabel;
        components[1]=dX;
        components[2]=yLabel;
        components[3]=dY;
    }

    public static void show()
    {
        dX.setValue(0);
        dY.setValue(0);
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

