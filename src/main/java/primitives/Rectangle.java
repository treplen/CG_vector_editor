package primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Rectangle implements Primitive {

    private Color color;
    private Point2D start, end;

    public Rectangle(Point2D start, Point2D end, Color color)
    {
        this.start=start;
        this.end=end;
        this.color=color;
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
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

}