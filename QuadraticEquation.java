import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Quadratic Equation Solver");
        System.out.println("Equation format: ax^2 + bx + c = 0");

        System.out.print("Enter the value of a: ");
        double a = input.nextDouble();

        System.out.print("Enter the value of b: ");
        double b = input.nextDouble();

        System.out.print("Enter the value of c: ");
        double c = input.nextDouble();

        if (a == 0) {
            System.out.println("The value of a cannot be 0.");
            System.out.println("This is not a quadratic equation.");
        } else {
            double discriminant = (b * b) - (4 * a * c);

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                System.out.println("\nThe equation has two real solutions:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);

            } else if (discriminant == 0) {
                double x = -b / (2 * a);

                System.out.println("\nThe equation has one real solution:");
                System.out.println("x = " + x);

            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart =
                        Math.sqrt(-discriminant) / Math.abs(2 * a);

                System.out.println("\nThe equation has two complex solutions:");
                System.out.println("x1 = " + realPart + " + "
                        + imaginaryPart + "i");
                System.out.println("x2 = " + realPart + " - "
                        + imaginaryPart + "i");
            }
        }

        input.close();
    }
}
