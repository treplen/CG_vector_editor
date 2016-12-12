package editor.primitives;

import com.sun.javafx.geom.*;
import editor.view.dialogues.ChangeEpicycloid;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.reflect.generics.tree.DoubleSignature;
import sun.reflect.generics.tree.FloatSignature;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Epicycloid extends Primitive {

    private Point2D center;
    private float inradius, angle;
    int loops, rotations;

    public Epicycloid(Point2D center, float inradius, int loops, int rotations,float angle, Color color)
    {
        super("Epicycloid",color);
        this.center=center;
        this.inradius=inradius;
        this.loops=loops;
        this.rotations=rotations;
        Double d =angle*3.14159265358979/180;
        this.angle=d.floatValue();
    }

    public void draw(Graphics2D g)
    {
        g.setColor(getColor());
        float r = inradius*rotations/loops;
        double d = 0.785398163397448 - Math.atan((inradius+r-1)/(inradius+r));
        for(double f = 0; f<6.28318530717959*rotations;f+=d)
        {
            Double x = (inradius + r)*Math.cos(f)-r*Math.cos(angle+((inradius+r)/r)*f)+center.x;
            Double y = (inradius + r)*Math.sin(f)-r*Math.sin(angle+((inradius+r)/r)*f)+center.y;
            g.drawLine(x.intValue(),y.intValue(),x.intValue(),y.intValue());
        }
    }

    public void move(Vec2f vector)
    {
        center.setLocation(center.x+vector.x,center.y+vector.y);
    }

    public boolean contains(Point2D point)
    {
        return center.distance(point)<inradius+2*(inradius*rotations/loops);
    }

    public void change()
    {
        ChangeEpicycloid.change(this);
    }

    public void enlarge(Float scale)
    {
        float add = (scale-1)*(inradius+2*(inradius*rotations/loops));
        center.setLocation(center.x+add,center.y-add);
        inradius=inradius*scale;
    }

    @Override
    public void enlarge(Float scale, float leftBottomX, float leftBottomY) {

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
    public Point2D getLeftBottom() {
        return new Point2D(center.x-inradius-2*(inradius*rotations/loops),center.y+inradius+2*(inradius*rotations/loops));
    }

    public Point2D getCenter()
    {
        return center;
    }

    public float getRadius()
    {
        return inradius;
    }

    public int getAngle()
    {
        Long l = Math.round(angle*(180/3.14159265358979));
        return l.intValue();
    }

    public int getLoops()
    {
        return loops;
    }

    public int getRotations()
    {
        return rotations;
    }

    public void setCenter(Point2D center)
    {
        this.center=center;
    }

    public void setRadius(float radius)
    {
        inradius=radius;
    }

    public void setAngle(float angle)
    {
        Double d =angle*3.14159265358979/180;
        this.angle=d.floatValue();
    }

    public void setLoops(int loops)
    {
        this.loops=loops;
    }

    public void setRotations(int rotations)
    {
        this.rotations=rotations;
    }

}