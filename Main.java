
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Room> rooms;
    private List<User> users;
    private List<Reservation> reservations;
    private int nextReservationId = 1;
    private int nextPaymentId = 1;

    public Main() {
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayAvailableRooms() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(int userId, int roomId, LocalDate startDate, LocalDate endDate, String paymentMethod) {
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomId() == roomId && room.isAvailable()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room is not available.");
            return;
        }

        selectedRoom.setAvailable(false);

        Reservation reservation = new Reservation(nextReservationId++, userId, roomId, startDate, endDate);
        reservations.add(reservation);

        for (User user : users) {
            if (user.getUserId() == userId) {
                user.addReservation(reservation);
                break;
            }
        }

        Payment payment = new Payment(nextPaymentId++, reservation.getReservationId(), selectedRoom.getPrice(), paymentMethod);
        payment.processPayment();

        System.out.println("Reservation made successfully!");
    }

    public void viewUserReservations(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                user.viewReservations();
                return;
            }
        }
        System.out.println("No reservations found for user ID: " + userId);
    }

    public static void main(String[] args) {
        Main system = new Main();

        system.addRoom(new Room(1, "Single", 100.0));
        system.addRoom(new Room(2, "Double", 150.0));
        system.addRoom(new Room(3, "Suite", 250.0));

        User user = new User(1, "John Doe", "john@example.com");
        system.addUser(user);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View my reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    system.displayAvailableRooms();
                    break;
                case 2:
                    int userId = 0;
                    int roomId = 0;
                    String startDateInput = "";
                    String endDateInput = "";
                    String paymentMethod = "";

                    try {
                        System.out.print("Enter user ID: ");
                        userId = scanner.nextInt();
                        System.out.print("Enter room ID: ");
                        roomId = scanner.nextInt();
                        System.out.print("Enter start date (yyyy-mm-dd): ");
                        startDateInput = scanner.next();
                        System.out.print("Enter end date (yyyy-mm-dd): ");
                        endDateInput = scanner.next();
                        System.out.print("Enter payment method (Credit Card, PayPal, etc.): ");
                        paymentMethod = scanner.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter correct values.");
                        scanner.next();
                        continue;
                    }

                    try {
                        system.makeReservation(userId, roomId, LocalDate.parse(startDateInput), LocalDate.parse(endDateInput), paymentMethod);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter user ID: ");
                        int userIdForViewing = scanner.nextInt();
                        system.viewUserReservations(userIdForViewing);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}