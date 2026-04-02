public class Example {
    public static void main(String[] args) {
        // 1) 기본 변수 선언
        int age = 20;
        double height = 175.5;
        char grade = 'A';
        boolean isStudent = true;

        // 2) 배열 생성 및 값 할당
        int[] scores = {90, 85, 100};
        String[] subjects = new String[3];
        subjects[0] = "Java";
        subjects[1] = "HTML";
        subjects[2] = "CSS";

        // 3) 문자열 생성 방법
        String name1 = "Kim";                  // 문자열 리터럴
        String name2 = new String("Kyungtae"); // new 키워드 사용
        String intro = name1 + " " + name2;

        StringBuilder builder = new StringBuilder();
        builder.append("안녕하세요, ")
               .append(intro)
               .append(" 님!");
        String greeting = builder.toString();

        // 결과 출력
        System.out.println("=== 기본 변수 출력 ===");
        System.out.println("age: " + age);
        System.out.println("height: " + height);
        System.out.println("grade: " + grade);
        System.out.println("isStudent: " + isStudent);

        System.out.println("\n=== 배열 출력 ===");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }

        for (int i = 0; i < subjects.length; i++) {
            System.out.println("subjects[" + i + "]: " + subjects[i]);
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }
        double average = (double) total / scores.length;
        System.out.println("총점: " + total);
        System.out.println("평균: " + average);

        System.out.println("\n=== 문자열 출력 ===");
        System.out.println("name1: " + name1);
        System.out.println("name2: " + name2);
        System.out.println("intro: " + intro);
        System.out.println("greeting: " + greeting);
    }
}
