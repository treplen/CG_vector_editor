package editor.primitives;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2f;

import java.awt.*;

/**
 * Created by svuatoslav on 12/18/16.
 */
public abstract class Addition extends Primitive {

    @Override
    public void move(Vec2f vector) {
    }

    public abstract void delete();

    @Override
    public boolean contains(Point2D point) {
        return false;
    }

    @Override
    public void change() {
    }

    @Override
    public void enlarge(Float scale) {
    }

    @Override
    public void enlarge(Float scale, float leftBottomX, float leftBottomY) {
    }

    @Override
    public void reflect(Point2D point) {
    }

    @Override
    public void sendMsg(float x, float y) {
    }

    @Override
    public boolean step(float x, float y) {
        return true;
    }

    @Override
    public Point2D getLeftBottom() {
        return null;
    }

    @Override
    public boolean isAddition()
    {return true;}

    @Override
    public boolean collides(float left, float up, float right, float down) {
        return true;
    }

    public Addition(String name, Color color) {
        super(name, color);
    }
}
