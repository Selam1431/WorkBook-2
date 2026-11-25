package workShop6;

import java.awt.*;

public class Circle extends  Shape{
    private int radius;

    public Circle (Turtle turtle, Point location, Color color, int border, int radius){
        super(turtle, location, color, border);
        this.radius = radius;

    }


    @Override
    public void paint() {

    }
}
