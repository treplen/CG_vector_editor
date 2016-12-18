package editor.primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;
import editor.view.dialogues.ChangeRectangle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Rectangle extends Primitive {

    private Point2D start, end;
    boolean fix;

    public Rectangle(Point2D start, Point2D end, Color color)
    {
        super("Rectangle",color);
        this.start=start;
        this.end=end;
        fix=true;
    }

    public Rectangle(Point2D start, Color color)
    {
        super("Rectangle",color);
        this.start=start;
        this.end=start;
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

    @Override
    public void draw(Graphics2D g) {
        if(!viewable())
            return;
        float maxX,maxY,minX,minY;
        maxX=Float.max(start.x,end.x);
        minX=Float.min(start.x,end.x);
        maxY=Float.max(start.y,end.y);
        minY=Float.min(start.y,end.y);
        g.setColor(getColor());
        for(int i = Math.round(minY);i<maxY;i++)
            for(int j = Math.round(minX);j<maxX;j++)
                if(clips(j,i))
                    g.drawLine(j,i,j,i);
        drawAdditions(g);
    }

    public void move(Vec2f vector)
    {
        start.setLocation(start.x+vector.x,start.y+vector.y);
        end.setLocation(end.x+vector.x,end.y+vector.y);
        moveClip(vector);
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

    public void change()
    {
        ChangeRectangle.exec(this);
    }

    public void enlarge(Float scale)
    {
        float minX=Float.min(start.x,end.x);
        float maxY=Float.max(start.y,end.y);
        float multiplier = scale-1;
        start.x=start.x + (start.x-minX)*multiplier;
        start.y=start.y + (start.y-maxY)*multiplier;
        end.x=end.x+(end.x-minX)*multiplier;
        end.y=end.y+(end.y-maxY)*multiplier;
    }

    @Override
    public void enlarge(Float scale, float leftBottomX, float leftBottomY) {
        float multiplier = scale-1;
        start.x=start.x + (start.x-leftBottomX)*multiplier;
        start.y=start.y + (start.y-leftBottomY)*multiplier;
        end.x=end.x+(end.x-leftBottomX)*multiplier;
        end.y=end.y+(end.y-leftBottomY)*multiplier;
    }

    public void reflect(Point2D point)
    {
        start.setLocation(2*point.x-start.x,2*point.y-start.y);
        end.setLocation(2*point.x-end.x,2*point.y-end.y);
        reflectClip(point);
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
        if(start.distance(end)>5)
        fix=true;
        return fix;
    }

    @Override
    public Point2D getLeftBottom() {
        return new Point2D(Float.min(start.x,end.x),Float.max(start.y,end.y));
    }

    @Override
    public boolean collides(float left, float up, float right, float down) {
        float leftC=Float.min(start.x,end.x);
        float rightC=Float.max(start.x,end.x);
        float upC=Float.min(start.y,end.y);
        float downC=Float.max(start.y,end.y);
        return ((left>leftC&&left<rightC&&down<downC&&down>upC)||(right>leftC&&right<rightC&&up<downC&&up>upC)||
                (leftC>left&&leftC<right&&upC<down&&upC>up)||(rightC>left&&rightC<right&&downC<down&&downC>up))||
                (leftC>left&&rightC<right&&upC<up&&downC>down)||(leftC<left&&rightC>right&&upC>up&&downC<down);
    }

    public Point2D getStart()
    {
        return start;
    }

    public Point2D getEnd()
    {
        return end;
    }

}
