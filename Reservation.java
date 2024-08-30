

import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private int userId;
    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(int reservationId, int userId, int roomId, LocalDate startDate, LocalDate endDate) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void viewReservation() {
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("User ID: " + userId);
        System.out.println("Room ID: " + roomId);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
