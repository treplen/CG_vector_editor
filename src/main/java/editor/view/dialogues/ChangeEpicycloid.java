package editor.view.dialogues;

import com.sun.javafx.geom.Point2D;
import editor.primitives.Epicycloid;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

/**
 * Created by svuatoslav on 12/12/16.
 */
public class ChangeEpicycloid {
    private static NumberFormat format = NumberFormat.getInstance();
    private static NumberFormatter formatter = new NumberFormatter(format);
    private static NumberFormatter angleFormatter = new NumberFormatter(format);

    private static JTextField x = new JTextField(20);
    private static JTextField y = new JTextField(20);

    private static JTextField radius = new JTextField(20);
    private static JFormattedTextField rotations;
    private static JFormattedTextField loops;
    private static JFormattedTextField angle;
    private static JLabel xLabel = new JLabel("Input x position of center:");
    private static JLabel yLabel = new JLabel("Input y position of center:");
    private static JLabel radiusLabel = new JLabel("Input radius:");
    private static JLabel rotationsLabel = new JLabel("Input amount of rotations:");
    private static JLabel loopsLabel = new JLabel("Input amount of loops:");
    private static JLabel angleLabel = new JLabel("Input initial angle:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[12];

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
        document = (AbstractDocument) x.getDocument();
        document.setDocumentFilter(new FloatFilter());
        document = (AbstractDocument) y.getDocument();
        document.setDocumentFilter(new FloatFilter());
        components[0]=xLabel;
        components[1]=x;
        components[2]=yLabel;
        components[3]=y;
        components[4]=radiusLabel;
        components[5]=radius;
        components[6]=rotationsLabel;
        components[7]=rotations;
        components[8]=loopsLabel;
        components[9]=loops;
        components[10]=angleLabel;
        components[11]=angle;
    }

    public static void change(Epicycloid epicycloid)
    {
        x.setText(Float.toString(epicycloid.getCenter().x));
        y.setText(Float.toString(epicycloid.getCenter().y));
        radius.setText(Float.toString(epicycloid.getRadius()));
        rotations.setValue(epicycloid.getRotations());
        loops.setValue(epicycloid.getLoops());
        angle.setValue(Math.round(epicycloid.getAngle()));
        result=JOptionPane.showConfirmDialog(null, components , "Input new parameters", JOptionPane.PLAIN_MESSAGE);
        if(result==JOptionPane.OK_OPTION)
        {
            epicycloid.setCenter(new Point2D(Float.parseFloat(x.getText()),Float.parseFloat(y.getText())));
            epicycloid.setRadius(Float.parseFloat(radius.getText()));
            epicycloid.setRotations(Integer.parseInt(rotations.getText()));
            epicycloid.setLoops(Integer.parseInt(loops.getText()));
            epicycloid.setAngle(Float.parseFloat(angle.getText()));
        }
    }
}
