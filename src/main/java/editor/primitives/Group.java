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
public class Group implements Primitive {

    private List<Primitive> contains;
    private String name;

    public Group(@NotNull String name) {
        this.name = name;
        contains = new ArrayList<Primitive>();
    }

    public void add(@NotNull Primitive primitive)
    {
        contains.add(primitive);
    }

    public List<Primitive> Collapse()
    {
        List<Primitive> res = new ArrayList<Primitive>(contains);
        contains.clear();
        return res;
    }

    public void draw(Graphics2D g)
    {
        for(Iterator<Primitive> i = contains.listIterator();i.hasNext();)
            i.next().draw(g);
    }

    public void move(final Vec2f vector)
    {
        for(Iterator<Primitive> i = contains.listIterator();i.hasNext();)
            i.next().move(vector);
    }

    public boolean contains(Point2D point)
    {
        for(Iterator<Primitive> i = contains.listIterator();i.hasNext();)
            if(i.next().contains(point))
                return true;
        return false;
    }

    public void change(Object placeholder)
    {
        //Нельзя изменить все примитивы по одному правилу
    }

    public void enlarge(Float scale)
    {
        for(Iterator<Primitive> i = contains.listIterator();i.hasNext();)
            i.next().enlarge(scale);
    }

    public void reflect(Point2D point)
    {
        for(Iterator<Primitive> i = contains.listIterator();i.hasNext();)
            i.next().reflect(point);
    }

    @Override
    public void sendMsg(float x, float y) {

    }
}
