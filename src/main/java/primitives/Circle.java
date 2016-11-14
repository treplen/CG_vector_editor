package primitives;

import com.sun.javafx.geom.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Circle implements Primitive {

    private Color color;
    private float radius;
    private Point2D center;

    public Circle(Point2D center, float radius, Color color)
    {
        this.center=center;
        this.radius=radius;
        this.color=color;
    }

    public void setRadius(float radius)
    {
        this.radius=radius;
    }

    public void setRadius(Point2D point)
    {
        this.radius=center.distance(point);
    }

    public void setCenter(Point2D center)
    {
        this.center=center;
    }

    public void draw(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void move(Vec2f vector)
    {
        center.setLocation(center.x+vector.x,center.y+vector.y);
    }

    public boolean contains(Point2D point)
    {
        return center.distance(point)<=radius;
    }

    public void change(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void enlarge(Float scale)
    {
        float add = (scale-1)*radius;
        center.setLocation(center.x+add,center.y+add);
        radius=radius*scale;
    }

    public void reflect(Point2D point)
    {
        center.setLocation(2*point.x-center.x,2*point.y-center.y);
    }

}
