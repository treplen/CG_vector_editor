package editor.primitives;

import com.sun.javafx.geom.Point2D;
import editor.Editor;
import editor.Main;
import editor.view.EditorFrame;

import java.awt.*;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class Tangent1 extends Addition {
    Circle circle;
    float x,y;
    float x1,y1;

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());

        if(circle.contains(new Point2D(x,y)))
            return;
        set();
        int x0=Math.round(this.x),x1=Math.round(this.x1),y0=Math.round(this.y),y1=Math.round(this.y1);
        if(x1!=x0||y1!=y0)
        {
            int A, B, sign;
            A = y1-y0;
            B = x0 - x1;
            if (Math.abs(A) > Math.abs(B)) sign = 1;
            else sign = -1;
            int signa, signb;
            if (A < 0) signa = -1;
            else signa = 1;
            if (B < 0) signb = -1;
            else signb = 1;
            int f = 0;
            g.drawLine(x0, y0 , x0, y0);
            int x = x0, y = y0;
            if (sign == -1) {
                do {
                    f += A*signa;
                    if (f > 0) {
                        f -= B*signb;
                        y+=signa;
                    }
                    x-=signb;
                    g.drawLine(x,y,x,y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            } else {
                do {
                    f += B * signb;
                    if (f > 0) {
                        f -= A * signa;
                        x -= signb;
                    }
                    y += signa;
                    g.drawLine(x, y, x, y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            }
            f = 0;
            x = x0;
            y = y0;
            if (sign == -1) {
                do {
                    f += A*signa;
                    if (f > 0) {
                        f -= B*signb;
                        y-=signa;
                    }
                    x+=signb;
                    g.drawLine(x,y,x,y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            } else {
                do {
                    f += B * signb;
                    if (f > 0) {
                        f -= A * signa;
                        x += signb;
                    }
                    y -= signa;
                    g.drawLine(x, y, x, y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            }
        }
    }

    @Override
    public void draw(Graphics2D g, Rectangle clip) {
        g.setColor(getColor());

        if(circle.contains(new Point2D(x,y)))
            return;
        set();
        int x0=Math.round(this.x),x1=Math.round(this.x1),y0=Math.round(this.y),y1=Math.round(this.y1);
        if(x1!=x0||y1!=y0)
        {
            int A, B, sign;
            A = y1-y0;
            B = x0 - x1;
            if (Math.abs(A) > Math.abs(B)) sign = 1;
            else sign = -1;
            int signa, signb;
            if (A < 0) signa = -1;
            else signa = 1;
            if (B < 0) signb = -1;
            else signb = 1;
            int f = 0;
            if(clip.contains(new Point2D(x0,y0)))
                g.drawLine(x0, y0 , x0, y0);
            int x = x0, y = y0;
            if (sign == -1) {
                do {
                    f += A*signa;
                    if (f > 0) {
                        f -= B*signb;
                        y+=signa;
                    }
                    x-=signb;
                    if(clip.contains(new Point2D(x,y)))
                        g.drawLine(x,y,x,y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            } else {
                do {
                    f += B * signb;
                    if (f > 0) {
                        f -= A * signa;
                        x -= signb;
                    }
                    y += signa;
                    if(clip.contains(new Point2D(x,y)))
                        g.drawLine(x, y, x, y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            }
            f = 0;
            x = x0;
            y = y0;
            if (sign == -1) {
                do {
                    f += A*signa;
                    if (f > 0) {
                        f -= B*signb;
                        y-=signa;
                    }
                    x+=signb;
                    if(clip.contains(new Point2D(x,y)))
                        g.drawLine(x,y,x,y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            } else {
                do {
                    f += B * signb;
                    if (f > 0) {
                        f -= A * signa;
                        x += signb;
                    }
                    y -= signa;
                    if(clip.contains(new Point2D(x,y)))
                        g.drawLine(x, y, x, y);
                } while (x < EditorFrame.size.width && x>0 && y >0 && y<EditorFrame.size.height);
            }
        }
    }

    public Tangent1(Circle circle, Point2D point, Color color) {
        super("TangentOne", color);
        this.circle=circle;
        x=point.x;
        y=point.y;
        circle.addAddition(this);
    }

    private void set()
    {
        float l = Point2D.distance(circle.getX(),circle.getY(),x,y);
        float h = (float) Math.sqrt(l*l-circle.getRadius()*circle.getRadius());
        float a = (float) Math.asin(circle.getRadius()/l);
        float f = (float) Math.asin(((y-circle.getY())/l)*(x>circle.getX()?1:-1));
        if(x>circle.getX()) {
            x1 = (float) (x - h * Math.cos(a + f));
            y1 = (float) (y - h * Math.sin(a + f));
        }
        else{
            x1 = (float) (x + h * Math.cos(a + f));
            y1 = (float) (y + h * Math.sin(a + f));
        }
    }

    @Override
    public void delete() {
        circle.removeAddition(this);
    }
}
