public class ShapeAnonymous {
    public static void main(String[] args) {
        ShapeDemo.Shape anonymousShape = new ShapeDemo.Shape() {
            private double x = 10;
            private double y = 20;
            private double size = 15;
            private double angle = 0;

            @Override
            public void move(double newX, double newY) {
                x = Math.max(0, Math.min(100, newX));
                y = Math.max(0, Math.min(100, newY));
            }

            @Override
            public void translate(double dx, double dy) {
                x = Math.max(0, Math.min(100, x + dx));
                y = Math.max(0, Math.min(100, y + dy));
            }

            @Override
            public void rotate(double degree) {
                angle = (angle + degree) % 360;
                if (angle < 0) {
                    angle += 360;
                }
            }

            @Override
            public void printInfo() {
                System.out.printf(
                    "익명도형A - 위치(%.2f, %.2f), 크기 %.2f, 회전각 %.1f도%n",
                    x, y, size, angle
                );
            }
        };

        ShapeDemo.Shape anonymousShape2 = new ShapeDemo.Shape() {
            private double x = 60;
            private double y = 30;
            private double radius = 8;
            private double angle = 0;

            @Override
            public void move(double newX, double newY) {
                x = Math.max(0, Math.min(100, newX));
                y = Math.max(0, Math.min(100, newY));
            }

            @Override
            public void translate(double dx, double dy) {
                double ratio = radius / 30.0;
                x = Math.max(0, Math.min(100, x + dx * ratio));
                y = Math.max(0, Math.min(100, y + dy * ratio));
            }

            @Override
            public void rotate(double degree) {
                angle = (angle + degree) % 360;
                if (angle < 0) {
                    angle += 360;
                }
            }

            @Override
            public void printInfo() {
                System.out.printf(
                    "익명도형B - 중심(%.2f, %.2f), 반지름 %.2f, 회전각 %.1f도%n",
                    x, y, radius, angle
                );
            }
        };

        System.out.println("=== Shape 익명 클래스 예제 ===");
        anonymousShape.printInfo();
        anonymousShape.move(25, 35);
        anonymousShape.translate(5, -10);
        anonymousShape.rotate(30);
        anonymousShape.printInfo();

        System.out.println();

        anonymousShape2.printInfo();
        anonymousShape2.move(80, 50);
        anonymousShape2.translate(12, -6);
        anonymousShape2.rotate(120);
        anonymousShape2.printInfo();
    }
}
