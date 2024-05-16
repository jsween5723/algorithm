import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int A,B,C;
        int[] result = new int[10];
        Scanner sc = new Scanner(System.in);
        A = Integer.parseInt(sc.nextLine());
        B = Integer.parseInt(sc.nextLine());
        C = Integer.parseInt(sc.nextLine());
        int target = A * B * C;
        while(target > 0) {
            result[target % 10]++;
            target /= 10;
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}