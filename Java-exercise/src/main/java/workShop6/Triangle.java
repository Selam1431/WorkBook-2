package workShop6;

import java.awt.*;

public class Triangle extends Shape{
    private int  side;

    public Triangle(Turtle turtle, Point location, Color color, int border, int side) {
        super(turtle, location, color, border);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void paint() {

        Turtle turtle = getTurtle();

        turtle.penUp();
        turtle.goTo(getLocation());
        turtle.setColor(getColor());
        turtle.setPenWidth(getBorder());
        turtle.setHeading(0);
        turtle.penDown();

        for (int i = 0; i < 3; i++) {
            turtle.forward(side);
            turtle.turnRight(120);
        }

        turtle.penUp();
    }
}
