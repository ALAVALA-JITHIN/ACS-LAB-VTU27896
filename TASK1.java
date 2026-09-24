import java.util.*;

public class TASK1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int sum = 0;

        // Sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        // Sliding window
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];

            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);

        sc.close();
    }
}