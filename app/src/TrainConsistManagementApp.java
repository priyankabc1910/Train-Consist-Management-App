import java.util.ArrayList;

/**
 * TrainConsistManagementApp
 *
 * UC1 + UC2 Combined
 * Demonstrates:
 * - Program execution (UC1)
 * - ArrayList operations for managing passenger bogies (UC2)
 *
 * @author Sanjay
 * @version 1.0
 */
public class TrainConsistManagementApp {

    /**
     * Main method – JVM starts execution from here
     */
    public static void main(String[] args) {

        // ===== UC1: Welcome Message =====
        System.out.println("==============================================");
        System.out.println("   Welcome to Train Consist Management App    ");
        System.out.println("              Version 1.0                    ");
        System.out.println("==============================================");
        System.out.println("Application started successfully.\n");

        // ===== UC2: ArrayList Operations =====

        // Create ArrayList for passenger bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display list after insertion
        System.out.println("Passenger Bogies after addition:");
        System.out.println(passengerBogies);

        // Remove one bogie
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(passengerBogies);

        // Check existence
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nIs 'Sleeper' present? " + exists);

        // Final list state
        System.out.println("\nFinal Passenger Bogies List:");
        System.out.println(passengerBogies);
    }
}
