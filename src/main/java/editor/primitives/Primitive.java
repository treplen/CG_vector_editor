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
    public abstract void draw(Graphics2D g,Rectangle clip);
    public abstract void move(Vec2f vector);
    public abstract boolean contains(Point2D point);
    public abstract void change();
    public abstract void enlarge(Float scale);
    public abstract void enlarge(Float scale, float leftBottomX, float leftBottomY);
    public abstract void reflect(Point2D point);
    public abstract void sendMsg(float x, float y);
    public abstract boolean step(float x, float y);
    public abstract Point2D getLeftBottom();
    public abstract boolean collides(float left, float up, float right, float down);

    private List<Addition> additions = new ArrayList<>();

    private boolean selected=false;
    private String name;
    private Color color;
    private Color selectColor;

    public void addAddition(Addition addition)
    {
        additions.add(addition);
    }

    public void removeAddition(Addition addition)
    {
        additions.remove(addition);
    }

    public boolean isAddition()
    {
        return false;
    }

    public void clearAdditions()
    {
        for (Addition addition:new ArrayList<>(additions))
            addition.delete();
    }

    public void drawAdditions(Graphics2D g)
    {
        for(Addition addition:additions)
            addition.draw(g);
    }
    public void drawAdditions(Graphics2D g, Rectangle clip)
    {
        for(Addition addition:additions)
            addition.draw(g,clip);
    }

    public List<Primitive> collapse()
    {
        for(Addition addition:new ArrayList<>(additions))
            addition.delete();
        return null;
    }

    public Primitive(String name,Color color)
    {
        this.name=name;
        this.color=color;
        selectColor=new Color(127-color.getRed()/2,127-color.getGreen()/2,127-color.getBlue()/2);
    }

    public Color getColor()
    {
        if(selected)
            return selectColor;
        else
            return color;
    }

    public Color getRealColor()
    {
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
