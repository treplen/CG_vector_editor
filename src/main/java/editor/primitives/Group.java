package editor.primitives;

import com.sun.istack.internal.NotNull;
import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Group extends Primitive {

    private List<Primitive> contains;
    private String name;

    public Group(@NotNull String name) {
        super(name,Color.black);
        this.name = name;
        contains = new ArrayList<>();
    }

    public void add(@NotNull Primitive primitive)
    {
        contains.add(primitive);
    }

    @Override
    public void setColor(Color color)
    {
        super.setColor(color);
        for(Primitive primitive:contains)
            primitive.setColor(color);
    }

    @Override
    public void select(boolean select)
    {
        super.select(select);
        for(Primitive primitive:contains)
            primitive.select(select);
    }

    @Override
    public List<Primitive> collapse()
    {
        List<Primitive> res = new ArrayList<>(contains);
        contains.clear();
        return res;
    }

    public void draw(Graphics2D g)
    {
        for (Primitive primitive : contains)
            primitive.draw(g);
    }

    @Override
    public void draw(Graphics2D g, Rectangle clip) {
        float right = Float.max(clip.getStart().x,clip.getEnd().x);
        float left = Float.min(clip.getStart().x,clip.getEnd().x);
        float down = Float.max(clip.getStart().y,clip.getEnd().y);
        float up = Float.min(clip.getStart().y,clip.getEnd().y);
        for (Primitive primitive : contains)
            if(primitive.collides(left,up,right,down))
                primitive.draw(g,clip);
    }

    public void move(final Vec2f vector)
    {
        for (Primitive primitive : contains)
            primitive.move(vector);
    }

    public boolean contains(Point2D point)
    {
        for(Primitive primitive:contains)
            if(primitive.contains(point))
                return true;
        return false;
    }

    public void change()
    {
        //Нельзя изменить все примитивы по одному правилу
    }

    public void enlarge(Float scale)
    {
        float leftBottomX=Float.MAX_VALUE;
        float leftBottomY=Float.MIN_VALUE;
        for (Primitive primitive:contains)
        {
            leftBottomX=Float.min(leftBottomX,primitive.getLeftBottom().x);
            leftBottomY=Float.max(leftBottomY,primitive.getLeftBottom().y);
        }
        for(Primitive primitive: contains)
        {
            primitive.enlarge(scale,leftBottomX,leftBottomY);
        }
    }

    @Override
    public void enlarge(Float scale, float leftBottomX, float leftBottomY) {
        for(Primitive primitive:contains)
            primitive.enlarge(scale,leftBottomX,leftBottomY);
    }

    public void reflect(Point2D point)
    {
        for (Primitive primitive : contains)
            primitive.reflect(point);
    }

    @Override
    public void sendMsg(float x, float y) {

    }

    @Override
    public boolean step(float x, float y) {
        return false;
    }

    @Override
    public boolean isGroup()
    {
        return true;
    }

    @Override
    public Point2D getLeftBottom() {
        float leftBottomX=Float.MAX_VALUE;
        float leftBottomY=Float.MIN_VALUE;
        for (Primitive primitive:contains)
        {
            leftBottomX=Float.min(leftBottomX,primitive.getLeftBottom().x);
            leftBottomY=Float.max(leftBottomY,primitive.getLeftBottom().y);
        }
        return new Point2D(leftBottomX,leftBottomY);
    }

    @Override
    public boolean collides(float left, float up, float right, float down) {
        for(Primitive primitive:contains)
            if(primitive.collides(left, up, right, down))
                return true;
        return false;
    }
}
