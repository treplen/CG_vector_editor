package editor.view;

import editor.Editor;
import editor.primitives.Primitive;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by svuatoslav on 12/1/16.
 */
public class EditorCanvas extends JPanel {
    private BufferedImage screen;

    public EditorCanvas() {
        screen = new BufferedImage(EditorFrame.size.width, EditorFrame.size.height, BufferedImage.TYPE_INT_ARGB);
        setSize(EditorFrame.size);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render();
    }

    public void render() {
        Graphics ggg = screen.getGraphics();
        Graphics2D g = ((Graphics2D) ggg);
        g.setColor(getBackground());
        g.fillRect(0, 0, EditorFrame.size.width, EditorFrame.size.height);

        if(Editor.clip==null) {
            for (Primitive primitive : Editor.primitives)
                primitive.draw(g);
        }
        else {
            float left = Float.min(Editor.clip.getStart().x,Editor.clip.getEnd().x);
            float right = Float.max(Editor.clip.getStart().x,Editor.clip.getEnd().x);
            float up = Float.min(Editor.clip.getStart().y,Editor.clip.getEnd().y);
            float down = Float.max(Editor.clip.getStart().y,Editor.clip.getEnd().y);
            for (Primitive primitive : Editor.primitives)
                if(primitive.collides(left, up,right,down))
                    primitive.draw(g,Editor.clip);
        }
        if (Editor.tempPrimitive != null)
            Editor.tempPrimitive.draw(g);

        g.dispose();

        Graphics gg = this.getGraphics();
        gg.drawImage(screen, 0, 0, null);
        gg.dispose();
    }

    private int getStringWidth(Graphics2D g, String string) {
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        FontMetrics fm = img.getGraphics().getFontMetrics(g.getFont());

        return fm.stringWidth(string);
    }
}
