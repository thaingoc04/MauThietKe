import java.util.HashMap;
import java.util.Map;
public class Prototype {


    // Prototype interface
    interface Shape {
        Shape clone();
        void draw();
    }

    // Concrete prototype: Circle
    static class Circle implements Shape {
        private String color;
        private int radius;

        public Circle(String color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        public Shape clone() {
            return new Circle(this.color, this.radius);
        }

        public void draw() {
            System.out.println("Circle: Color " + color + ", Radius " + radius);
        }
    }

    // Concrete prototype: Square
    static class Square implements Shape {
        private String color;
        private int side;

        public Square(String color, int side) {
            this.color = color;
            this.side = side;
        }

        public Shape clone() {
            return new Square(this.color, this.side);
        }

        public void draw() {
            System.out.println("Square: Color " + color + ", Side " + side);
        }
    }

    // Prototype manager
    static class ShapeManager {
        private Map<String, Shape> shapeCache = new HashMap<>();

        public void addShape(String key, Shape shape) {
            shapeCache.put(key, shape);
        }

        public Shape getShape(String key) {
            Shape shape = shapeCache.get(key);
            if (shape != null) {
                return shape.clone();
            }
            return null;
        }
    }


    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();

        // Add prototype shapes to the manager
        manager.addShape("Circle", new Circle("Red", 10));
        manager.addShape("Square", new Square("Blue", 5));

        // Clone and draw shapes
        Shape clonedCircle = manager.getShape("Circle");
        if (clonedCircle != null) {
            clonedCircle.draw();
        }

        Shape clonedSquare = manager.getShape("Square");
        if (clonedSquare != null) {
            clonedSquare.draw();
        }
    }


}