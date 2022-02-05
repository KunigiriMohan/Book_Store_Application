class MethodOverLoadingPractice {

    private int number1;
    private int number2;
    private int number3;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public int sum(int a, int b, int c){
        return a+b+c;
    }

    public float sum(float a, float b, float c){
        return a+b+c;
    }

    public long sum(long a,long b,long c){
        return a+b+c;
    }
}

public class Caluculation{
    public static void main(String[] args)
    {
        MethodOverLoadingPractice methodOverLoadingPractice = new MethodOverLoadingPractice();
        System.out.println(methodOverLoadingPractice.sum(1,2,3)+"  Sum of Int Numbers");
        System.out.println(methodOverLoadingPractice.sum(1f,2f,3f)+" Sum of float Numbers");
        System.out.println(methodOverLoadingPractice.sum(1L,2L,3L)+" Sum of Long Numbers");

        System.out.println("The Getters and Setters Implementation");
        methodOverLoadingPractice.setNumber1(1);
        System.out.println(methodOverLoadingPractice.getNumber1());
        methodOverLoadingPractice.setNumber2(2);
        System.out.println(methodOverLoadingPractice.getNumber2());
        methodOverLoadingPractice.setNumber3(3);
        System.out.println(methodOverLoadingPractice.getNumber3());
    }
}
