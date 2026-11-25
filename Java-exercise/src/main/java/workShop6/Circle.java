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

        Turtle turtle = getTurtle();

        turtle.penUp();
        turtle.setColor(getColor());
        turtle.setPenWidth(getBorder());

        double centerX = getLocation().getX();
        double centerY = getLocation().getY();

        turtle.goTo(centerX + radius, centerY);
        turtle.penDown();

        for (int i = 1; i <= 360; i++) {

            double angle = Math.toRadians(i);

            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);

            turtle.goTo(x, y);
        }

        turtle.penUp();
    }
}
