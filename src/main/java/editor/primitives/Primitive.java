package editor.primitives;

import com.sun.javafx.geom.*;
import com.sun.javafx.geom.Point2D;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by svuatoslav on 11/14/16.
 */
public interface Primitive {

    void draw(Graphics2D g);

    void move(Vec2f vector);

    boolean contains(Point2D point);

    void change(Object placeholder);

    void enlarge(Float scale);

    void reflect(Point2D point);

    void sendMsg(float x, float y);

    boolean step(float x, float y);

    void select(boolean select);

    boolean isSelected();

    List<Primitive> collapse();

    default String getName()
    {
        return null;
    }

    default void setName(String str)
    {}

    default boolean isGroup()
    {
        return false;
    }
}
