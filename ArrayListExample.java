import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        
        // Create ArrayList
        ArrayList<String> students = new ArrayList<>();
        
        // Add elements
        students.add("Ali");
        students.add("John");
        students.add("Sara");
        students.add("Mike");
        
        // Print all elements
        System.out.println("Students List:");
        for (String name : students) {
            System.out.println(name);
        }
        
        // Access element
        System.out.println("First Student: " + students.get(0));
        
        // Remove element
        students.remove("John");
        
        // Size of ArrayList
        System.out.println("Total Students: " + students.size());
    }
}
