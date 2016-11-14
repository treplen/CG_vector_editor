package primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.geom.Arc2D;

import static java.lang.StrictMath.atan;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Line implements Primitive {

    private Color color;
    private Point2D start, end;
    private boolean segment;

    public Line(Point2D start, Point2D end, Color color, boolean segment)
    {
        this.start=start;
        this.end=end;
        this.color=color;
        this.segment=segment;
    }

    void setStart(Point2D start)
    {
        this.start=start;
    }

    void setEnd(Point2D end)
    {
        this.end=end;
    }

    public void draw(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void move(Vec2f vector)
    {
        start.setLocation(start.x+vector.x,start.y+vector.y);
        end.setLocation(end.x+vector.x,end.y+vector.y);
    }

    public boolean contains(Point2D point)
    {
        if(segment)
            if (point.x<start.x&&point.x<end.x||point.x>start.x&&point.x>end.x)
                return false;
        return (point.x-start.x)/(point.y-start.y)==(end.x-start.x)/(end.y-start.y);//Возможно слишком точно
    }

    public void change(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void enlarge(Float scale)
    {
        float multiplier = scale-1;
        if(end.x>start.x)
            end.x=end.x+(end.x-start.x)*multiplier;
        else
            start.x=start.x+(start.x-end.x)*multiplier;
        if(end.y>start.y)
            end.y=end.y+(end.y-start.y)*multiplier;
        else
            start.y=start.y+(start.y-end.y)*multiplier;
    }

    public void reflect(Point2D point)
    {
        start.setLocation(2*point.x-start.x,2*point.y-start.y);
        end.setLocation(2*point.x-end.x,2*point.y-end.y);
    }

}