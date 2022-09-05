public class Calculator {
    private float op1;
//    private float op2;
//    private String operator;
//
//    public Calculator() {
//    }
//    public Calculator(float op1, float op2, String operator) {
//        this.op1 = op1;
//        this.op2 = op2;
//        this.operator = operator;
//    }
//
//    public float getOp1() {
//        return op1;
//    }
//
//    public void setOp1(float op1) {
//        this.op1 = op1;
//    }
//
//    public float getOp2() {
//        return op2;
//    }
//
//    public void setOp2(float op2) {
//        this.op2 = op2;
//    }
//
//    public String getOperator() {
//        return operator;
//    }
//
//    public void setOperator(String operator) {
//        this.operator = operator;
//    }

    public float calculate(float op1, float op2, String operator) {
        switch (operator) {
            case "+":
                return op1+op2;
            case "-":
                return op1-op2;
            case "x":
                return op1*op2;
            case ":":
                if(op2!=0) {
                    return op1/op2;
                }else {
                    throw new ArithmeticException();
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
