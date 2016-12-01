package editor.primitives;

import com.sun.javafx.geom.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Epicycloid implements Primitive {

    private Color color;
    private Point2D center;
    private float inradius, outradius, angle;

    public Epicycloid(Point2D center, float inradius, float outradius, float angle, Color color)
    {
        this.center=center;
        this.inradius=inradius;
        this.outradius=outradius;
        this.angle=angle;
        this.color=color;
    }

    public void draw(Graphics2D g)
    {
        throw new NotImplementedException();
    }

    public void move(Vec2f vector)
    {
        center.setLocation(center.x+vector.x,center.y+vector.y);
    }

    public boolean contains(Point2D point)
    {
        throw new NotImplementedException();
    }

    public void change(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void enlarge(Float scale)
    {
        float add = (scale-1)*(inradius+outradius);
        center.setLocation(center.x+add,center.y+add);
        inradius=inradius*scale;
        outradius=outradius*scale;
    }

    public void reflect(Point2D point)
    {
        center.setLocation(2*point.x-center.x,2*point.y-center.y);
        angle=(angle+180)%360;
    }

    @Override
    public void sendMsg(float x, float y) {

    }

    @Override
    public boolean step(float x, float y) {
        return false;
    }

    @Override
    public void select(boolean select) {

    }

}