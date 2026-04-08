import java.util.Random;

public class RectangleDemo {
    static class Rectangle {
        private static final int MAX_X = 100;
        private static final int MAX_Y = 100;
        private static final int MIN_WIDTH = 1;
        private static final int MAX_WIDTH = 30;
        private static final int MIN_HEIGHT = 1;
        private static final int MAX_HEIGHT = 30;

        private static int totalCount = 0;
        private static final Random RANDOM = new Random();

        private final double x;
        private final double y;
        private final int width;
        private final int height;

        public Rectangle(double x, double y, int width, int height) {
            this.x = clamp(x, 0, MAX_X);
            this.y = clamp(y, 0, MAX_Y);
            this.width = clamp(width, MIN_WIDTH, MAX_WIDTH);
            this.height = clamp(height, MIN_HEIGHT, MAX_HEIGHT);
            totalCount++;
        }

        public Rectangle() {
            this(
                Math.random() * MAX_X,
                Math.random() * MAX_Y,
                RANDOM.nextInt(MAX_WIDTH - MIN_WIDTH + 1) + MIN_WIDTH,
                RANDOM.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT
            );
        }

        public static int getTotalCount() {
            return totalCount;
        }

        public void printInfo() {
            System.out.printf("좌표(%.2f, %.2f), 크기(%d x %d)%n", x, y, width, height);
        }

        private static int clamp(int value, int min, int max) {
            if (value < min) {
                return min;
            }
            if (value > max) {
                return max;
            }
            return value;
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
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 20, 15, 8);
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle();
        Rectangle r4 = new Rectangle(80, 90, 40, 50);

        System.out.println("=== 생성된 사각형 정보 ===");
        r1.printInfo();
        r2.printInfo();
        r3.printInfo();
        r4.printInfo();

        System.out.println("전체 사각형 수: " + Rectangle.getTotalCount());
    }
}
