package editor.primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;
import editor.view.dialogues.ChangeLine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Line extends Primitive {

    private Point2D start, end;
    private boolean segment;
    boolean fixed;

    public Line(Point2D start, Point2D end, Color color, boolean segment)
    {
        super("Line",color);
        this.start=start;
        this.end=end;
        this.segment=segment;
        fixed=true;
    }

    public Line(Point2D start, Color color)
    {
        super("Line",color);
        this.start=start;
        this.end=start;
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
        g.setColor(getColor());

        int x0=Math.round(start.x),x1=Math.round(end.x),y0=Math.round(start.y),y1=Math.round(end.y);
        if(x1!=x0||y1!=y0)
        {
            int A, B, sign;
            A = y1-y0;
            B = x0 - x1;
            if (Math.abs(A) > Math.abs(B)) sign = 1;
            else sign = -1;
            int signa, signb;
            if (A < 0) signa = -1;
            else signa = 1;
            if (B < 0) signb = -1;
            else signb = 1;
            int f = 0;
            g.drawLine(x0, y0 , x0, y0);
            int x = x0, y = y0;
            if (sign == -1) {
                do {
                    f += A*signa;
                    if (f > 0) {
                        f -= B*signb;
                        y+=signa;
                    }
                    x-=signb;
                    g.drawLine(x,y,x,y);
                } while (x != x1 || y != y1);
            } else {
                do {
                    f += B * signb;
                    if (f > 0) {
                        f -= A * signa;
                        x -= signb;
                    }
                    y += signa;
                    g.drawLine(x, y, x, y);
                } while (x != x1 || y != y1);
            }
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
        float right=(point.x+5-start.x)/(end.x-start.x);
        float left=(point.x-5-start.x)/(end.x-start.x);
        float centerY=(point.y-start.y)/(end.y-start.y);
        float up=(point.y+5-start.y)/(end.y-start.y);
        float down=(point.y-5-start.y)/(end.y-start.y);
        float centerX=(point.x-start.x)/(end.x-start.x);
        return right>centerY&&left<centerY||right<centerY&&left>centerY||up>centerX&&down<centerX||up<centerX&&down>centerX;
    }

    public void change()
    {
        ChangeLine.exec(this);
    }

    public void enlarge(Float scale)
    {
        float multiplier = scale-1;
        if(end.x>start.x)
            end.x=end.x+(end.x-start.x)*multiplier;
        else
            start.x=start.x+(start.x-end.x)*multiplier;
        if(end.y<start.y)
            end.y=end.y+(end.y-start.y)*multiplier;
        else
            start.y=start.y+(start.y-end.y)*multiplier;
    }

    @Override
    public void enlarge(Float scale, float leftBottomX, float leftBottomY) {

        float multiplier = scale-1;
        end.x=end.x+(end.x-leftBottomX)*multiplier;
        start.x=start.x+(start.x-leftBottomX)*multiplier;
        end.y=end.y+(end.y-leftBottomY)*multiplier;
        start.y=start.y+(start.y-leftBottomY)*multiplier;
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
        if(start.distance(end)>5)
        fixed=true;
        return fixed;
    }

    @Override
    public Point2D getLeftBottom() {
        return new Point2D(Float.min(start.x,end.x),Float.max(start.y,end.y));
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