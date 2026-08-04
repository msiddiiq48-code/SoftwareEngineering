import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to store country information
class Country {
    String name;
    long population;
    double size; // in square kilometers
    double gdp;  // in trillion USD

    public Country(String name, long population, double size, double gdp) {
        this.name = name;
        this.population = population;
        this.size = size;
        this.gdp = gdp;
    }

    public void displayInfo() {
        System.out.println("\nCountry Information");
        System.out.println("-------------------");
        System.out.println("Country Name : " + name);
        System.out.println("Population   : " + population);
        System.out.println("Country Size : " + size + " sq km");
        System.out.println("GDP          : $" + gdp + " trillion");
    }
}

public class CountryInfoApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Store countries in a HashMap
        Map<String, Country> countries = new HashMap<>();

        countries.put("USA",
                new Country("USA", 339000000, 9834000, 27.36));

        countries.put("Canada",
                new Country("Canada", 40000000, 9985000, 2.14));

        countries.put("India",
                new Country("India", 1428000000, 3287000, 3.57));

        countries.put("Japan",
                new Country("Japan", 125000000, 377975, 4.21));

        countries.put("Germany",
                new Country("Germany", 84000000, 357022, 4.46));

        // Display country list
        System.out.println("Available Countries:");
        for (String countryName : countries.keySet()) {
            System.out.println("- " + countryName);
        }

        // Ask user to choose a country
        System.out.print("\nEnter a country name: ");
        String userChoice = scanner.nextLine();

        // Check if country exists
        if (countries.containsKey(userChoice)) {
            countries.get(userChoice).displayInfo();
        } else {
            System.out.println("Country not found in the list.");
        }

        scanner.close();
    }
}
