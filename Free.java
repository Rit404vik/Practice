import java.util.ArrayList;
import java.util.Scanner;

public class Free {

    static {
        System.out.println("Enter the elements in the ArrayList ");
    }
    public static boolean multipleOfThree(int val){
        return val % 3 != 0 && val % 7 != 0;
    }
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        int min = 2;
        int max = 10;
        final double random = Math.random() * (max - min) + min;
        Scanner sc = new Scanner(System.in);
        double counter = random;

        for(int i = 1; i<=random; i++) {
            try {
                System.out.print("Enter element " + i + ": ");
                    list.add(sc.nextInt());

                    if(list.get(0) >= 100) {
                        list.remove(0);
                        System.out.println("remaining indexes : " + (int)--counter);
                        continue;
                    } else if(list.get(list.size() - 1) >= 100) {
                        list.remove(list.size() - 1);
                        System.out.println("remaining indexes : " + (int)--counter);
                        throw new IllegalArgumentException("Integers equal to or greater than 100 are invalid");
                    }

                    int j = list.get(list.size() - 1);
                    if(!multipleOfThree(j)){
                        list.remove(list.size() - 1);
                        System.out.println("Multiples 3 and 5 will be removed");
                    }

                    System.out.println("-------------------");
                    System.out.println("remaining indexes : " + (int)--counter);
                    System.out.println("-------------------");

                } catch (IllegalArgumentException e) {
                    System.out.println("Message from console : " + e.getMessage() + ". Enter valid Integers only.");
            }
        }

        System.out.println(list);
        sc.close();

    }
}
