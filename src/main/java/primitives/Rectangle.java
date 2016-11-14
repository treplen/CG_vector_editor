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
        fixPosition();
        this.color=color;
    }

    void setStart(Point2D start)
    {
        this.start=start;
        fixPosition();
    }

    private void fixPosition()
    {
        if(start.x>end.x)
        {
            float buf = start.x;
            start.x=end.x;
            end.x=buf;
        }
        if(start.y>end.y)
        {
            float buf = start.y;
            start.y=end.y;
            end.y=buf;
        }
    }

    void setEnd(Point2D end)
    {
        this.end=end;
        fixPosition();
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
        return point.x>=start.x&&point.x<=end.x&&point.y>=start.y&&point.y<=end.y;
    }

    public void change(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void enlarge(Float scale)
    {
        float multiplier = scale-1;
        end.x=end.x+(end.x-start.x)*multiplier;
        end.y=end.y+(end.y-start.y)*multiplier;
    }

    public void reflect(Point2D point)
    {
        start.setLocation(2*point.x-start.x,2*point.y-start.y);
        end.setLocation(2*point.x-end.x,2*point.y-end.y);
        fixPosition();
    }

}