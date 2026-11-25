package workShop6;
import java.awt.Color;
import java.awt.Point;


public class Square extends  Shape{
    private int side;

    public Square(Turtle turtle, Point location, Color color, int border, int side) {
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


        for (int i = 0;  i < 4; i++) {
            turtle.forward(side);
            turtle.turnRight(90);
        }
        turtle.penUp();

    }
}
