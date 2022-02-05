public class LoopsPractice {
    int [] array = new int[9];

    public static void main(String[] args) {
        LoopsPractice loopsPractice = new LoopsPractice();

        System.out.println("Using For Loop");
        for (int i=0;i<=8;i++){
            loopsPractice.array[i]=i;
            System.out.print(loopsPractice.array[i]);
        }

        System.out.println("");

        System.out.println("Using For Each Loop");
        for(int value: loopsPractice.array){
            System.out.print(value);
        }
        System.out.println();


        System.out.println("Using While Loop");
        int k=0;
        while(k<=8){
            System.out.print(loopsPractice.array[k]);
            k++;
        }
    }
}
