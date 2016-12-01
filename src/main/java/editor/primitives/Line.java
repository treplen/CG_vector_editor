package editor.primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Line implements Primitive {

    private Color color;
    private Point2D start, end;
    private boolean segment;
    boolean fixed;
    boolean selected=false;

    public Line(Point2D start, Point2D end, Color color, boolean segment)
    {
        this.start=start;
        this.end=end;
        this.color=color;
        this.segment=segment;
        fixed=true;
    }

    public Line(Point2D start, Color color)
    {
        this.start=start;
        this.end=start;
        this.color=color;
        this.segment=true;
        fixed=false;
    }

    void setStart(Point2D start)
    {
        this.start=start;
    }

    void setEnd(Point2D end)
    {
        this.end=end;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.drawLine(Math.round(start.x),Math.round(start.y),Math.round(end.x),Math.round(end.y));
        if(selected)
        {
            g.setColor(Color.black);
            g.drawRect(Math.round(start.x)-10,Math.round(start.y)-10,20,20);
            g.drawRect(Math.round(end.x)-10,Math.round(end.y)-10,20,20);
        }
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
        return Math.round(point.x-start.x)/Math.round(point.y-start.y)==Math.round(end.x-start.x)/Math.round(end.y-start.y);//Возможно слишком точно
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

    @Override
    public void sendMsg(float x, float y) {
        if(!fixed)
            end=new Point2D(x,y);
    }

    @Override
    public boolean step(float x, float y) {
        if(!fixed)
            end=new Point2D(x,y);
        fixed=true;
        return fixed;
    }

    @Override
    public void select(boolean select) {
        selected=select;
    }

}