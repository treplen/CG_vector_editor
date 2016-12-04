package editor.primitives;

import com.sun.javafx.geom.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Circle implements Primitive {

    private Color color;
    private Color selectColor;
    private float radius;
    private Point2D center;
    private boolean fix;
    private boolean selected=false;

    public Circle(Point2D center, float radius, Color color)
    {
        this.center=center;
        this.radius=radius;
        this.color=color;
        selectColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),127);
        fix=true;
    }

    public Circle(Point2D center, Color color)
    {
        this.center=center;
        this.radius=0;
        this.color=color;
        selectColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),127);
        fix=false;
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

    public void draw(Graphics2D g)
    {
        if(selected)
            g.setColor(selectColor);
        else
            g.setColor(color);
        g.fillOval(Math.round(center.x-radius),Math.round(center.y-radius),Math.round(radius)*2,Math.round(radius)*2);
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

    @Override
    public void sendMsg(float x, float y) {
        if(!fix)
            radius=center.distance(x,y);
    }

    @Override
    public boolean step(float x, float y) {
        if(!fix)
            radius=center.distance(x,y);
        if(radius>5)
        fix=true;
        return fix;
    }

    @Override
    public void select(boolean select) {
        selected=select;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public List<Primitive> collapse() {
        return null;
    }

    @Override
    public String toString()
    {
        return "Circle";
    }

}
