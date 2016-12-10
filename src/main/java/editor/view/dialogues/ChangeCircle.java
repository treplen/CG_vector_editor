package editor.view.dialogues;

import com.sun.javafx.geom.Point2D;
import editor.primitives.Circle;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

/**
 * Created by svuatoslav on 12/10/16.
 */
public class ChangeCircle {
    private static JTextField radius = new JTextField(20);
    private static JTextField x = new JTextField(20);
    private static JTextField y = new JTextField(20);
    private static JLabel radiusLabel = new JLabel("Input radius:");
    private static JLabel xLabel = new JLabel("Input x position of center:");
    private static JLabel yLabel = new JLabel("Input y position of center:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[6];

    static {
        AbstractDocument document = (AbstractDocument) radius.getDocument();
        final int maxCharacters = 20;
        document.setDocumentFilter(new FloatFilter());
        document = (AbstractDocument) x.getDocument();
        document.setDocumentFilter(new FloatFilter());
        document = (AbstractDocument) y.getDocument();
        document.setDocumentFilter(new FloatFilter());
        components[0]=radiusLabel;
        components[1]=radius;
        components[2]=xLabel;
        components[3]=x;
        components[4]=yLabel;
        components[5]=y;
    }

    public static void exec(Circle circle)
    {
        radius.setText(Float.toString(circle.getRadius()));
        x.setText(Float.toString(circle.getX()));
        y.setText(Float.toString(circle.getY()));
        result=JOptionPane.showConfirmDialog(null, components , "Input new parameters", JOptionPane.PLAIN_MESSAGE);
        if(result==JOptionPane.OK_OPTION)
        {
            circle.setRadius(Float.parseFloat(radius.getText()));
            circle.setCenter(new Point2D((Float.parseFloat(x.getText())),Float.parseFloat(y.getText())));
        }
    }
}
