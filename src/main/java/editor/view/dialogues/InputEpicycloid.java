package editor.view.dialogues;

import com.sun.javafx.geom.Point2D;
import editor.primitives.Epicycloid;
import editor.primitives.Rectangle;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by svuatoslav on 12/12/16.
 */
public class InputEpicycloid {
    private static NumberFormat format = NumberFormat.getInstance();
    private static NumberFormatter formatter = new NumberFormatter(format);
    private static NumberFormatter angleFormatter = new NumberFormatter(format);

    private static JTextField radius = new JTextField(20);
    private static JFormattedTextField rotations;
    private static JFormattedTextField loops;
    private static JFormattedTextField angle;
    private static JLabel radiusLabel = new JLabel("Input radius:");
    private static JLabel rotationsLabel = new JLabel("Input amount of rotations:");
    private static JLabel loopsLabel = new JLabel("Input amount of loops:");
    private static JLabel angleLabel = new JLabel("Input initial angle:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[8];

    static {
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        rotations = new JFormattedTextField(formatter);
        loops = new JFormattedTextField(formatter);

        angleFormatter.setValueClass(Integer.class);
        angleFormatter.setMinimum(0);
        angleFormatter.setMaximum(360);
        angleFormatter.setAllowsInvalid(false);
        angleFormatter.setCommitsOnValidEdit(true);

        angle = new JFormattedTextField(angleFormatter);

        AbstractDocument document = (AbstractDocument) rotations.getDocument();
        document.setDocumentFilter(new FloatFilter());

        components[0]=radiusLabel;
        components[1]=radius;
        components[2]=rotationsLabel;
        components[3]=rotations;
        components[4]=loopsLabel;
        components[5]=loops;
        components[6]=angleLabel;
        components[7]=angle;
    }

    public static Epicycloid exec(float x, float y, Color color)
    {
        radius.setText("10");
        loops.setValue(1);
        rotations.setValue(1);
        angle.setValue(0);
        result=JOptionPane.showConfirmDialog(null, components , "Input new parameters", JOptionPane.PLAIN_MESSAGE);
        if(result==JOptionPane.OK_OPTION)
        {
            return new Epicycloid(new Point2D(x,y),Float.parseFloat(radius.getText()),Integer.parseInt(loops.getText()),Integer.parseInt(rotations.getText()),Float.parseFloat(angle.getText()),color);
        }
        else
            return null;
    }
}
