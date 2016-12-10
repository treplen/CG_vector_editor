package editor.view.dialogues;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

/**
 * Created by svuatoslav on 12/10/16.
 */
public class FloatFilter extends DocumentFilter {
    @Override
    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
        String text = fb.getDocument().getText(0,fb.getDocument().getLength());
        text+=str;
        if(text.matches("^\\d*\\.?\\d*$"))
            super.replace(fb,offs,length,str,a);
        else
            Toolkit.getDefaultToolkit().beep();
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException
    {
        String text = fb.getDocument().getText(0,fb.getDocument().getLength());
        text+=str;
        if(text.matches("^\\d*\\.?\\d*$"))
            super.insertString(fb,offs,str,a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}
