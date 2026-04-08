import java.util.*;

/**
 * FINAL COMBINED APPLICATION
 *
 * UC1  - Program Start
 * UC2  - ArrayList
 * UC3  - HashSet
 * UC4A - LinkedList
 * UC5  - LinkedHashSet
 * UC6  - HashMap
 * UC7  - Comparator Sorting
 * UC4B - Hotel Room Search
 */

public class FinalCombinedApp {

    // ===== UC7: Bogie Class =====
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String toString() {
            return name + " → Capacity: " + capacity;
        }
    }

    // ===== HOTEL SYSTEM =====
    static class Room {
        String type;
        double price;
        String amenities;

        Room(String type, double price, String amenities) {
            this.type = type;
            this.price = price;
            this.amenities = amenities;
        }

        void display() {
            System.out.println("Room Type: " + type);
            System.out.println("Price: ₹" + price);
            System.out.println("Amenities: " + amenities);
        }
    }

    static class Inventory {
        private Map<String, Integer> data = new HashMap<>();

        void addRoom(String type, int count) {
            data.put(type, count);
        }

        int getAvailability(String type) {
            return data.getOrDefault(type, 0);
        }

        Map<String, Integer> getAll() {
            return data;
        }
    }

    static class SearchService {
        static void search(Inventory inv, Map<String, Room> rooms) {
            System.out.println("\n===== Available Rooms =====");

            for (String type : inv.getAll().keySet()) {
                int count = inv.getAvailability(type);

                if (count > 0) {
                    System.out.println("\n-------------------");
                    rooms.get(type).display();
                    System.out.println("Available: " + count);
                }
            }

            System.out.println("\n(Read-only search completed)");
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        // ===== UC1 =====
        System.out.println("==============================================");
        System.out.println("   Welcome to Train Consist Management App    ");
        System.out.println("              Version 1.0                    ");
        System.out.println("==============================================\n");


        // ===== UC2 =====
        ArrayList<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger Bogies:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter Removal:");
        System.out.println(passengerBogies);

        System.out.println("\nContains Sleeper? " + passengerBogies.contains("Sleeper"));


        // ===== UC3 =====
        HashSet<String> ids = new HashSet<>();
        ids.add("BG101");
        ids.add("BG102");
        ids.add("BG103");
        ids.add("BG101");

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(ids);


        // ===== UC4A =====
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        train.add(2, "Pantry");
        train.removeFirst();
        train.removeLast();

        System.out.println("\nOrdered Train Consist:");
        System.out.println(train);


        // ===== UC5 =====
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("\nLinkedHashSet Formation:");
        System.out.println(formation);


        // ===== UC6 =====
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacity Mapping:");
        for (Map.Entry<String, Integer> e : bogieCapacity.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }


        // ===== UC7: Comparator Sorting =====
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 54));
        bogieList.add(new Bogie("First Class", 24));

        // Sort by capacity
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nBogies Sorted by Capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }


        // ===== HOTEL UC4 =====
        Inventory inv = new Inventory();
        inv.addRoom("Deluxe", 5);
        inv.addRoom("Suite", 0);
        inv.addRoom("Standard", 3);

        Map<String, Room> rooms = new HashMap<>();
        rooms.put("Deluxe", new Room("Deluxe", 3500, "WiFi, AC"));
        rooms.put("Suite", new Room("Suite", 7000, "WiFi, Jacuzzi"));
        rooms.put("Standard", new Room("Standard", 2000, "Fan"));

        SearchService.search(inv, rooms);
    }
}