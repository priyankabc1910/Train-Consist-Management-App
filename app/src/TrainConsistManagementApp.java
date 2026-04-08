import java.util.ArrayList;
import java.util.HashSet;

/**
 * TrainConsistManagementApp
 *
 * UC1 + UC2 + UC3 Combined
 * Demonstrates:
 * - UC1: Program execution
 * - UC2: ArrayList operations (Passenger Bogies)
 * - UC3: HashSet (Unique Bogie IDs)
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


        // ===== UC3: HashSet Operations (Unique Bogie IDs) =====

        // Create HashSet for bogie IDs
        HashSet<String> bogieIDs = new HashSet<>();

        // Add bogie IDs (including duplicates)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs (duplicates removed automatically):");
        System.out.println(bogieIDs);
    }
}