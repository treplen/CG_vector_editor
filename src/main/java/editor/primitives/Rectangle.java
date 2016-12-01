package editor.primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Rectangle implements Primitive {

    private Color color,selectColor;
    private Point2D start, end;
    boolean fix;
    boolean selected=false;

    public Rectangle(Point2D start, Point2D end, Color color)
    {
        this.start=start;
        this.end=end;
        this.color=color;
        selectColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),127);
        fix=true;
    }

    public Rectangle(Point2D start, Color color)
    {
        this.start=start;
        this.end=start;
        this.color=color;
        selectColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),127);
        fix=false;
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
        float maxX,maxY,minX,minY;
        maxX=Float.max(start.x,end.x);
        minX=Float.min(start.x,end.x);
        maxY=Float.max(start.y,end.y);
        minY=Float.min(start.y,end.y);
        if(selected)
            g.setColor(selectColor);
        else
            g.setColor(color);
        g.fillRect(Math.round(minX),Math.round(minY),Math.round(maxX-minX),Math.round(maxY-minY));
    }

    public void move(Vec2f vector)
    {
        start.setLocation(start.x+vector.x,start.y+vector.y);
        end.setLocation(end.x+vector.x,end.y+vector.y);
    }

    public boolean contains(Point2D point)
    {
        float maxX,maxY,minX,minY;
        maxX=Float.max(start.x,end.x);
        minX=Float.min(start.x,end.x);
        maxY=Float.max(start.y,end.y);
        minY=Float.min(start.y,end.y);
        return point.x>=minX&&point.x<=maxX&&point.y>=minY&&point.y<=maxY;
    }

    public void change(Object placeholder)
    {
        throw new NotImplementedException();
    }

    public void enlarge(Float scale)
    {
        float minX=Float.min(start.x,end.x);
        float minY=Float.min(start.y,end.y);
        float multiplier = scale-1;
        start.x=start.x + (start.x-minX)*multiplier;
        start.y=start.y + (start.y-minY)*multiplier;
        end.x=end.x+(end.x-minX)*multiplier;
        end.y=end.y+(end.y-minY)*multiplier;
    }

    public void reflect(Point2D point)
    {
        start.setLocation(2*point.x-start.x,2*point.y-start.y);
        end.setLocation(2*point.x-end.x,2*point.y-end.y);
    }

    @Override
    public void sendMsg(float x, float y) {
        if(!fix)
            end=new Point2D(x,y);
    }

    @Override
    public boolean step(float x, float y) {
        if(!fix)
            end=new Point2D(x,y);
        fix=true;
        return fix;
    }

    @Override
    public void select(boolean select) {
        selected=select;
    }

}