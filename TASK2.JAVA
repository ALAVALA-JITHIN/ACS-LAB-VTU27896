import java.util.*;

public class TASK2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfProducts = sc.nextInt();

        HashMap<Integer, Integer> productFrequency = new HashMap<>();

        // Read product IDs and count their frequency
        for (int i = 0; i < numberOfProducts; i++) {
            int productId = sc.nextInt();

            if (productFrequency.containsKey(productId)) {
                productFrequency.put(productId,
                        productFrequency.get(productId) + 1);
            } else {
                productFrequency.put(productId, 1);
            }
        }

        int maximumFrequency = 0;
        int selectedProductId = Integer.MAX_VALUE;

        // Find product with maximum frequency
        for (Map.Entry<Integer, Integer> product :
                productFrequency.entrySet()) {

            int productId = product.getKey();
            int frequency = product.getValue();

            if (frequency > maximumFrequency) {
                maximumFrequency = frequency;
                selectedProductId = productId;
            } 
            else if (frequency == maximumFrequency &&
                     productId < selectedProductId) {
                selectedProductId = productId;
            }
        }

        System.out.println(selectedProductId + " " + maximumFrequency);

        sc.close();
    }
}