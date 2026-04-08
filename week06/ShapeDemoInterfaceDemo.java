import java.util.Random;

public class ShapeDemoInterfaceDemo {
    private static final int MAX_X = 100;
    private static final int MAX_Y = 100;
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 30;
    private static final Random RANDOM = new Random();

    private static int totalCount = 0;

    private static void increaseCount() {
        totalCount++;
    }

    private static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    private static double randomDouble(double min, double max) {
        return min + (max - min) * RANDOM.nextDouble();
    }

    private static double normalizeAngle(double degree) {
        double result = degree % 360;
        return result < 0 ? result + 360 : result;
    }

    interface InterShape {
        void move(double newX, double newY);

        void translate(double dx, double dy);

        void rotate(double degree);

        void printInfo();
    }

    static class InterRectangle implements InterShape {
        private double x;
        private double y;
        private double width;
        private double height;
        private double angle;

        InterRectangle(double x, double y, double width, double height) {
            this.x = clamp(x, 0, MAX_X);
            this.y = clamp(y, 0, MAX_Y);
            this.width = clamp(width, MIN_SIZE, MAX_SIZE);
            this.height = clamp(height, MIN_SIZE, MAX_SIZE);
            this.angle = 0;
            increaseCount();
        }

        InterRectangle() {
            this(
                randomDouble(0, MAX_X),
                randomDouble(0, MAX_Y),
                randomDouble(MIN_SIZE, MAX_SIZE),
                randomDouble(MIN_SIZE, MAX_SIZE)
            );
        }

        @Override
        public void move(double newX, double newY) {
            x = clamp(newX, 0, MAX_X);
            y = clamp(newY, 0, MAX_Y);
        }

        @Override
        public void translate(double dx, double dy) {
            x = clamp(x + dx, 0, MAX_X);
            y = clamp(y + dy, 0, MAX_Y);
        }

        @Override
        public void rotate(double degree) {
            angle = normalizeAngle(angle + degree);
        }

        @Override
        public void printInfo() {
            System.out.printf(
                "InterRectangle - 중심(%.2f, %.2f), 너비 %.2f, 높이 %.2f, 회전각 %.1f도%n",
                x, y, width, height, angle
            );
        }
    }

    static class InterTriangle implements InterShape {
        private double x;
        private double y;
        private double sideA;
        private double sideB;
        private double sideC;
        private double angle;

        InterTriangle(double x, double y, double sideA, double sideB, double sideC) {
            this.x = clamp(x, 0, MAX_X);
            this.y = clamp(y, 0, MAX_Y);
            this.sideA = clamp(sideA, MIN_SIZE, MAX_SIZE);
            this.sideB = clamp(sideB, MIN_SIZE, MAX_SIZE);
            this.sideC = clamp(sideC, MIN_SIZE, MAX_SIZE);
            this.angle = 0;
            increaseCount();
        }

        InterTriangle() {
            this(
                randomDouble(0, MAX_X),
                randomDouble(0, MAX_Y),
                randomDouble(MIN_SIZE, MAX_SIZE),
                randomDouble(MIN_SIZE, MAX_SIZE),
                randomDouble(MIN_SIZE, MAX_SIZE)
            );
        }

        @Override
        public void move(double newX, double newY) {
            x = clamp(newX + randomDouble(-0.5, 0.5), 0, MAX_X);
            y = clamp(newY + randomDouble(-0.5, 0.5), 0, MAX_Y);
        }

        @Override
        public void translate(double dx, double dy) {
            x = clamp(x + dx * 0.9, 0, MAX_X);
            y = clamp(y + dy * 0.9, 0, MAX_Y);
        }

        @Override
        public void rotate(double degree) {
            angle = normalizeAngle(angle + degree) % 120;
        }

        @Override
        public void printInfo() {
            System.out.printf(
                "InterTriangle - 기준점(%.2f, %.2f), 변(%.2f, %.2f, %.2f), 회전각 %.1f도%n",
                x, y, sideA, sideB, sideC, angle
            );
        }
    }

    static class InterCircle implements InterShape {
        private double x;
        private double y;
        private double radius;
        private double angle;

        InterCircle(double x, double y, double radius) {
            this.x = clamp(x, 0, MAX_X);
            this.y = clamp(y, 0, MAX_Y);
            this.radius = clamp(radius, MIN_SIZE, MAX_SIZE);
            this.angle = 0;
            increaseCount();
        }

        InterCircle() {
            this(
                randomDouble(0, MAX_X),
                randomDouble(0, MAX_Y),
                randomDouble(MIN_SIZE, MAX_SIZE)
            );
        }

        @Override
        public void move(double newX, double newY) {
            x = clamp(newX, 0, MAX_X);
            y = clamp(newY, 0, MAX_Y);
        }

        @Override
        public void translate(double dx, double dy) {
            double ratio = radius / MAX_SIZE;
            x = clamp(x + dx * ratio, 0, MAX_X);
            y = clamp(y + dy * ratio, 0, MAX_Y);
        }

        @Override
        public void rotate(double degree) {
            angle = normalizeAngle(angle + degree);
        }

        @Override
        public void printInfo() {
            System.out.printf(
                "InterCircle - 중심(%.2f, %.2f), 반지름 %.2f, 회전각 %.1f도%n",
                x, y, radius, angle
            );
        }
    }

    public static void main(String[] args) {
        InterShape[] shapes = {
            new InterRectangle(10, 20, 15, 8),
            new InterRectangle(),
            new InterTriangle(30, 10, 12, 10, 9),
            new InterTriangle(),
            new InterCircle(50, 50, 12),
            new InterCircle()
        };

        shapes[0].move(20, 30);
        shapes[1].translate(5, -3);
        shapes[2].rotate(50);
        shapes[3].translate(8, 4);
        shapes[4].move(90, 20);
        shapes[5].rotate(120);

        System.out.println("=== ShapeDemoInterfaceDemo: inter-prefix 도형 정보 ===");
        for (InterShape shape : shapes) {
            shape.printInfo();
        }

        System.out.println("전체 도형 수: " + totalCount);
    }
}
