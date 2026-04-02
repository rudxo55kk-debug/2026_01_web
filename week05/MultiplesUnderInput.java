import java.util.Scanner;

public class MultiplesUnderInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: ");
        int limit = scanner.nextInt();

        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("[" + dan + "의 배수]");
            for (int multiple = dan; multiple < limit; multiple += dan) {
                System.out.print(multiple + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
