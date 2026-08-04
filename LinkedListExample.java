import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        
        // Create LinkedList
        LinkedList<String> cities = new LinkedList<>();
        
        // Add elements
        cities.add("New York");
        cities.add("Chicago");
        cities.add("Houston");
        cities.add("Boston");
        
        // Add first and last
        cities.addFirst("Los Angeles");
        cities.addLast("Miami");
        
        // Print LinkedList
        System.out.println("Cities List:");
        for (String city : cities) {
            System.out.println(city);
        }
        
        // Access first and last
        System.out.println("First City: " + cities.getFirst());
        System.out.println("Last City: " + cities.getLast());
        
        // Remove element
        cities.remove("Chicago");
        
        // Size of LinkedList
        System.out.println("Total Cities: " + cities.size());
    }
}
