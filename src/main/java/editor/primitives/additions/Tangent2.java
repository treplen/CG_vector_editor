package editor.primitives.additions;

import com.sun.javafx.geom.Point2D;
import editor.primitives.Circle;
import editor.primitives.additions.Addition;
import editor.view.EditorFrame;

import java.awt.*;

/**
 * Created by svuatoslav on 12/18/16.
 */
public class Tangent2 extends Addition {
    Circle circle1, circle2;
    Point2D point;
    float x1,y1;
    float x2,y2;

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());

        set();
        int x0=Math.round(this.x1),x1=Math.round(this.x2),y0=Math.round(this.y1),y1=Math.round(this.y2);
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
            if(clips(x0,y0))
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
                    if(clips(x,y))
                    g.drawLine(x,y,x,y);
                } while (x != x1 || y != y1);
            } else {
                do {
                    f += B * signb;
                    if (f > 0) {
                        f -= A * signa;
                        x -= signb;
                    }
                    y += signa;
                    if(clips(x,y))
                    g.drawLine(x, y, x, y);
                } while (x != x1 || y != y1);
            }
        }
    }

    public Tangent2(Circle circle1, Circle circle2, Point2D point, Color color) {
        super("TangentTwo", color);
        this.circle1 = circle1;
        this.circle2 = circle2;
        this.point=point;
        circle1.addAddition(this);
        circle2.addAddition(this);
    }

    private void set()
    {
        double r = circle1.getRadius() + circle2.getRadius();
        double z = Math.pow(circle1.getX()-circle2.getX(),2) + Math.pow(circle1.getY()-circle2.getY(),2);
        double d = Math.sqrt (Math.abs (z - r*r));
        double a = ((circle1.getX()-circle2.getX()) * r + (circle1.getY()-circle2.getY()) * d) / z;
        double b = ((circle1.getY()-circle2.getY()) * r - (circle1.getX()-circle2.getX()) * d) / z;
        double c = circle1.getRadius() - a * circle1.getX() - b * circle1.getY();
        x1=0;
        y1= (float) (-c/b);
        x2= EditorFrame.size.width;
        y2= (float) ((-c-a*x2)/b);
        double d0 = Math.abs(a*point.x+b*point.y+c)/Math.sqrt(a*a+b*b);
        double d1;
        r = circle1.getRadius() - circle2.getRadius();
        z = Math.pow(circle1.getX()-circle2.getX(),2) + Math.pow(circle1.getY()-circle2.getY(),2);
        d = Math.sqrt (Math.abs (z - r*r));
        a = ((circle1.getX()-circle2.getX()) * r + (circle1.getY()-circle2.getY()) * d) / z;
        b = ((circle1.getY()-circle2.getY()) * r - (circle1.getX()-circle2.getX()) * d) / z;
        c = circle1.getRadius() - a * circle1.getX() - b * circle1.getY();
        if(d0>(d1=Math.abs(a*point.x+b*point.y+c)/Math.sqrt(a*a+b*b))) {
            d0 = d1;
            x1=0;
            y1= (float) (-c/b);
            x2= EditorFrame.size.width;
            y2= (float) ((-c-a*x2)/b);
        }
        r = -circle1.getRadius() + circle2.getRadius();
        z = Math.pow(circle1.getX()-circle2.getX(),2) + Math.pow(circle1.getY()-circle2.getY(),2);
        d = Math.sqrt (Math.abs (z - r*r));
        a = ((circle1.getX()-circle2.getX()) * r + (circle1.getY()-circle2.getY()) * d) / z;
        b = ((circle1.getY()-circle2.getY()) * r - (circle1.getX()-circle2.getX()) * d) / z;
        c = -circle1.getRadius() - a * circle1.getX() - b * circle1.getY();
        if(d0>(d1=Math.abs(a*point.x+b*point.y+c)/Math.sqrt(a*a+b*b))) {
            d0 = d1;
            x1=0;
            y1= (float) (-c/b);
            x2= EditorFrame.size.width;
            y2= (float) ((-c-a*x2)/b);
        }
        r = -circle1.getRadius() - circle2.getRadius();
        z = Math.pow(circle1.getX()-circle2.getX(),2) + Math.pow(circle1.getY()-circle2.getY(),2);
        d = Math.sqrt (Math.abs (z - r*r));
        a = ((circle1.getX()-circle2.getX()) * r + (circle1.getY()-circle2.getY()) * d) / z;
        b = ((circle1.getY()-circle2.getY()) * r - (circle1.getX()-circle2.getX()) * d) / z;
        c = -circle1.getRadius() - a * circle1.getX() - b * circle1.getY();
        if(d0>(Math.abs(a*point.x+b*point.y+c)/Math.sqrt(a*a+b*b))) {
            x1=0;
            y1= (float) (-c/b);
            x2= EditorFrame.size.width;
            y2= (float) ((-c-a*x2)/b);
        }
        }

    @Override
    public void delete() {
            circle1.removeAddition(this);
            circle2.removeAddition(this);
    }
}
