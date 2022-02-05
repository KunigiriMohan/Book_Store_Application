import javafx.scene.transform.Scale;

import java.util.Scanner;

public class ConditionStatements {
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        if (value==1){
            System.out.println("One");
        }
        else if (value==2){
            System.out.println("Two");
        }
        else {
            System.out.println("Wrong Number");
        }

        System.out.println("Enter number for Switch Cases");
        int number = scanner.nextInt();
        switch (number){
            case 1 :
                System.out.println("One from Switch Case");
            case 2 :
                System.out.println("Two from Switch Case");
            default:
                System.out.println("Wrong Number");
        }

    }
}
