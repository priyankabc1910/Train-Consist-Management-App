import java.util.*;

/**
 * Combined Application:
 * - UC1: Welcome Message
 * - UC2: ArrayList (Passenger Bogies)
 * - UC3: HashSet (Unique Bogie IDs)
 * - UC4: Room Search (Read-only Inventory)
 *
 * @author Sanjay
 * @version 1.0
 */
public class CombinedApp {

    // ===== UC4: Room Domain Model =====
    static class Room {
        String type;
        double price;
        String amenities;

        Room(String type, double price, String amenities) {
            this.type = type;
            this.price = price;
            this.amenities = amenities;
        }

        void displayDetails() {
            System.out.println("Room Type: " + type);
            System.out.println("Price: ₹" + price);
            System.out.println("Amenities: " + amenities);
        }
    }

    // ===== UC4: Inventory =====
    static class Inventory {
        private Map<String, Integer> availability = new HashMap<>();

        public void addRoom(String type, int count) {
            availability.put(type, count);
        }

        public int getAvailability(String type) {
            return availability.getOrDefault(type, 0);
        }

        public Map<String, Integer> getAll() {
            return availability;
        }
    }

    // ===== UC4: Search Service =====
    static class SearchService {
        public static void search(Inventory inventory, Map<String, Room> roomDetails) {
            System.out.println("\n===== Available Rooms =====");

            for (String type : inventory.getAll().keySet()) {
                int count = inventory.getAvailability(type);

                // Only show available rooms
                if (count > 0) {
                    Room room = roomDetails.get(type);

                    System.out.println("\n-------------------------");
                    room.displayDetails();
                    System.out.println("Available Rooms: " + count);
                }
            }

            System.out.println("\n(Search completed without modifying inventory)");
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        // ===== UC1 =====
        System.out.println("==============================================");
        System.out.println("   Welcome to Train Consist Management App    ");
        System.out.println("              Version 1.0                    ");
        System.out.println("==============================================");
        System.out.println("Application started successfully.\n");


        // ===== UC2: ArrayList =====
        ArrayList<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger Bogies after addition:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nIs 'Sleeper' present? " + exists);

        System.out.println("\nFinal Passenger Bogies List:");
        System.out.println(passengerBogies);


        // ===== UC3: HashSet =====
        HashSet<String> bogieIDs = new HashSet<>();

        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG102"); // duplicate

        System.out.println("\nUnique Bogie IDs (duplicates removed):");
        System.out.println(bogieIDs);


        // ===== UC4: Room Search =====
        Inventory inventory = new Inventory();

        inventory.addRoom("Deluxe", 5);
        inventory.addRoom("Suite", 0);
        inventory.addRoom("Standard", 3);

        Map<String, Room> roomDetails = new HashMap<>();

        roomDetails.put("Deluxe", new Room("Deluxe", 3500, "WiFi, TV, AC"));
        roomDetails.put("Suite", new Room("Suite", 7000, "WiFi, TV, AC, Jacuzzi"));
        roomDetails.put("Standard", new Room("Standard", 2000, "WiFi, Fan"));

        SearchService.search(inventory, roomDetails);
    }
}