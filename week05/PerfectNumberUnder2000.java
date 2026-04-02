public class PerfectNumberUnder2000 {
    public static void main(String[] args) {
        int limit = 2000;

        System.out.println("2000 이하의 완전수:");
        for (int number = 2; number <= limit; number++) {
            if (isPerfectNumber(number)) {
                System.out.print(number + "의 약수: ");
                printDivisors(number);
            }
        }
    }

    private static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPerfectNumber(int n) {
        int sum = 1;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return n > 1 && sum == n;
    }
}
