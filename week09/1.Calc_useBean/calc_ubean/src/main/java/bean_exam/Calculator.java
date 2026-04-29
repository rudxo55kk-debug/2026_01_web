package bean_exam;

public class Calculator {
    private double n1;
    private double n2;
    private String op;
    
    public Calculator() {
        // 기본 생성자
    }

    public double calc() {
        double result = 0;
        
        switch(op) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    result = 0; // 0으로 나누기 방지
                }
                break;
        }
        
        return result;
    }
    
    public void setN1(double n1) {
        this.n1 = n1;
    }
    
    public void setN2(double n2) {
        this.n2 = n2;
    }
    
    public void setOp(String op) {
        this.op = op;
    }
    
    public double getN1() {
        return n1;
    }
    
    public double getN2() {
        return n2;
    }
    
    public String getOp() {
        return op;
    }
}
