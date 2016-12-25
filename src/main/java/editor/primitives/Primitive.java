package editor.primitives;

import com.sun.javafx.geom.*;
import com.sun.javafx.geom.Point2D;
import editor.primitives.additions.Addition;

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
    public abstract boolean collides(float left, float up, float right, float down);

    private List<Addition> additions = new ArrayList<>();

    private boolean selected=false;
    private String name;
    private Color color;
    private Color selectColor;
    private Rectangle clip=null;

    public void setClip(Rectangle clip)
    {
        if(clip==null||this.clip==null)
            this.clip=clip;
        else
        {
            this.clip.setStart(new Point2D(Float.max(Float.min(this.clip.getStart().x,this.clip.getEnd().x),Float.min(clip.getStart().x,clip.getEnd().x)),Float.max(Float.min(this.clip.getStart().y,this.clip.getEnd().y),Float.min(clip.getStart().y,clip.getEnd().y))));
            this.clip.setEnd(new Point2D(Float.min(Float.max(this.clip.getStart().x,this.clip.getEnd().x),Float.max(clip.getStart().x,clip.getEnd().x)),Float.min(Float.max(this.clip.getStart().y,this.clip.getEnd().y),Float.max(clip.getStart().y,clip.getEnd().y))));
        }
    }

    public void moveClip(Vec2f vector)
    {
        if(clip!=null) {
            this.clip.setStart(new Point2D(clip.getStart().x + vector.x, clip.getStart().y + vector.y));
            this.clip.setEnd(new Point2D(clip.getEnd().x + vector.x, clip.getEnd().y + vector.y));
        }
    }

    public void reflectClip(Point2D point)
    {
        if(clip!=null)
            clip.reflect(point);
    }

    public boolean viewable()
    {
        if(clip==null)
            return true;
        float leftC=Float.min(clip.getStart().x,clip.getEnd().x);
        float rightC=Float.max(clip.getStart().x,clip.getEnd().x);
        float upC=Float.min(clip.getStart().y,clip.getEnd().y);
        float downC=Float.max(clip.getStart().y,clip.getEnd().y);
        return collides(leftC,upC,rightC,downC);
    }

    public boolean clips(float x,  float y)
    {
        if(clip==null)
            return true;
        return clip.contains(new Point2D(x,y));
    }

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
