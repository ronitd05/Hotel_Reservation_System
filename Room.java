
import java.util.Objects;

public class Room {
    private int roomId;
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(int roomId, String roomType, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}