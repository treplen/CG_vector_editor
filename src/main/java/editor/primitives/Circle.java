package editor.primitives;

import com.sun.javafx.geom.*;
import editor.view.dialogues.ChangeCircle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Circle extends Primitive {

    private float radius;
    private Point2D center;
    private boolean fix;


    public Circle(Point2D center, float radius, Color color) {
        super("Circle", color);
        this.center = center;
        this.radius = radius;
        fix = true;
    }

    public Circle(Point2D center, Color color) {
        super("Circle", color);
        this.center = center;
        this.radius = 0;
        fix = false;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setRadius(Point2D point) {
        this.radius = center.distance(point);
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void draw(Graphics2D g) {
        g.setColor(getColor());

        int x0=Math.round(center.x),y0=Math.round(center.y);
        int x = 0, y = Math.round(radius), sigma = 0, delta = 2 - 2 * Math.round(radius);
        while (y >= 0) {
            for (int i = x0 - x; i < x0 + x; i++)
            {
                g.drawLine(i, y0 - y, i, y0 - y);
                g.drawLine(i, y0 + y, i, y0 + y);
            }
            do {
                sigma = 2 * (delta + y) - 1;
                if (delta < 0 && sigma <= 0) {          //перемещение по горизонтали
                    x++;
                    delta += x + 1;
                } else if (delta > 0 && sigma > 0) {    //перемещение по вертикали
                    y--;
                    delta -= y + 1;
                } else {                                //перемещение по диагонали
                    x++;
                    delta += x - y;
                    y--;
                }
            }while (delta < 0 && sigma <= 0);
        }
    }

    public void move(Vec2f vector) {
        center.setLocation(center.x + vector.x, center.y + vector.y);
    }

    public boolean contains(Point2D point) {
        return center.distance(point) <= radius;
    }

    public void change() {
        ChangeCircle.exec(this);
    }

    public void enlarge(Float scale) {
        float add = (scale - 1) * radius;
        center.setLocation(center.x + add, center.y - add);
        radius = radius * scale;
    }

    @Override
    public void enlarge(Float scale, float leftBottomX, float leftBottomY) {
        center.setLocation(center.x + (scale - 1) * (center.x - leftBottomX), center.y + (scale - 1) * (center.y - leftBottomY));
        radius = radius * scale;
    }

    public void reflect(Point2D point) {
        center.setLocation(2 * point.x - center.x, 2 * point.y - center.y);
    }

    @Override
    public void sendMsg(float x, float y) {
        if (!fix)
            radius = center.distance(x, y);
    }

    @Override
    public boolean step(float x, float y) {
        if (!fix)
            radius = center.distance(x, y);
        if (radius > 5)
            fix = true;
        return fix;
    }

    @Override
    public Point2D getLeftBottom() {
        return new Point2D(center.x - radius, center.y + radius);
    }

    public float getRadius()
    {
        return radius;
    }

    public float getX()
    {
        return center.x;
    }

    public float getY()
    {
        return center.y;
    }

}
