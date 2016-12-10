package editor.primitives;

import com.sun.javafx.geom.*;
import com.sun.javafx.geom.Point2D;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public abstract class Primitive {

    public abstract void draw(Graphics2D g);
    public abstract void move(Vec2f vector);
    public abstract boolean contains(Point2D point);
    public abstract void change();
    public abstract void enlarge(Float scale);
    public abstract void enlarge(Float scale, float leftBottomX, float leftBottomY);
    public abstract void reflect(Point2D point);
    public abstract void sendMsg(float x, float y);
    public abstract boolean step(float x, float y);
    public abstract Point2D getLeftBottom();

    private boolean selected=false;
    private String name;
    private Color color;
    private Color selectColor;

    public List<Primitive> collapse()
    {
        return null;
    }

    public Primitive(String name,Color color)
    {
        this.name=name;
        this.color=color;
        selectColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),127);
    }

    public Color getColor()
    {
        if(selected)
            return selectColor;
        else
            return color;
    }

    public void select(boolean select)
    {selected=select;}

    public boolean isSelected()
    {return selected;}

    public String getName()
    {
        return name;
    }

    public void setName(String str)
    {name=str;}

    public boolean isGroup()
    {
        return false;
    }

    public void setColor(Color color)
    {
        this.color=color;
        selectColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),127);
    }

    @Override
    public String toString()
    {return name;}
}
