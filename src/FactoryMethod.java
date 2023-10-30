public class FactoryMethod {
    // Interface cho các đối tượng hình học
    interface Shape {
        void draw();
    }

    // Lớp cụ thể cho hình vuông
    static class Square implements Shape {
        public void draw() {
            System.out.println("Draw Square");
        }
    }

    // Lớp cụ thể cho hình tròn
    static class Circle implements Shape {
        public void draw() {
            System.out.println("Draw Circle");
        }
    }

    // Factory Method
    interface ShapeFactory {
        Shape createShape();
    }

    // Factory Method cụ thể cho hình vuông
    static class SquareFactory implements ShapeFactory {
        public Shape createShape() {
            return new Square();
        }
    }

    // Factory Method cụ thể cho hình tròn
    static class CircleFactory implements ShapeFactory {
        public Shape createShape() {
            return new Circle();
        }
    }


    public static void main(String[] args) {
        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();

        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();
    }


}