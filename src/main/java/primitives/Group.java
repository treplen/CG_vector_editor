package primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public class Group implements Primitive {

    List<Primitive> contains;

    public Group() {
        contains = new ArrayList<Primitive>();
    }

    public void add(Primitive primitive)
    {
        contains.add(primitive);
    }

    public List<Primitive> Collapse()
    {
        List<Primitive> res = new ArrayList<Primitive>(contains);
        contains.clear();
        return res;
    }

    public void draw(final Object placeholder)
    {
        for(Iterator<Primitive> i = contains.listIterator();i.hasNext();)
            i.next().draw(placeholder);
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
}