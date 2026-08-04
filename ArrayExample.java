public class ArrayExample {
    public static void main(String[] args) {
        
        // Declare and initialize array
        int[] numbers = {10, 20, 30, 40, 50};
        
        int sum = 0;
        
        // Loop through array
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        
        // Calculate average
        double average = (double) sum / numbers.length;
        
        // Print results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
