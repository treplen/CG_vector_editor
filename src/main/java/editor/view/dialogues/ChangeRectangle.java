package editor.view.dialogues;

import editor.primitives.Line;
import editor.primitives.Rectangle;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

/**
 * Created by svuatoslav on 12/10/16.
 */
public class ChangeRectangle {
    private static JTextField xS = new JTextField(20);
    private static JTextField yS = new JTextField(20);
    private static JTextField xE = new JTextField(20);
    private static JTextField yE = new JTextField(20);
    private static JLabel xSLabel = new JLabel("Input x position of start:");
    private static JLabel ySLabel = new JLabel("Input y position of start:");
    private static JLabel xELabel = new JLabel("Input x position of end:");
    private static JLabel yELabel = new JLabel("Input y position of end:");
    private static int result = JOptionPane.NO_OPTION;

    private static JComponent[] components = new JComponent[8];

    static {
        AbstractDocument document = (AbstractDocument) xS.getDocument();
        final int maxCharacters = 20;
        document.setDocumentFilter(new FloatFilter());
        document = (AbstractDocument) xE.getDocument();
        document.setDocumentFilter(new FloatFilter());
        document = (AbstractDocument) yS.getDocument();
        document.setDocumentFilter(new FloatFilter());
        document = (AbstractDocument) yE.getDocument();
        document.setDocumentFilter(new FloatFilter());
        components[0]=xSLabel;
        components[1]=xS;
        components[2]=ySLabel;
        components[3]=yS;
        components[4]=xELabel;
        components[5]=xE;
        components[6]=yELabel;
        components[7]=yE;
    }

    public static void exec(Rectangle rectangle)
    {
        xS.setText(Float.toString(rectangle.getStart().x));
        yS.setText(Float.toString(rectangle.getStart().y));
        xE.setText(Float.toString(rectangle.getEnd().x));
        yE.setText(Float.toString(rectangle.getEnd().y));
        result=JOptionPane.showConfirmDialog(null, components , "Input new parameters", JOptionPane.PLAIN_MESSAGE);
        if(result==JOptionPane.OK_OPTION)
        {
            rectangle.getStart().x=Float.parseFloat(xS.getText());
            rectangle.getStart().y=Float.parseFloat(yS.getText());
            rectangle.getEnd().x=Float.parseFloat(xE.getText());
            rectangle.getEnd().y=Float.parseFloat(yE.getText());
        }
    }
}
