

public class Payment {
    private int paymentId;
    private int reservationId;
    private double amount;
    private String paymentMethod;

    public Payment(int paymentId, int reservationId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
        System.out.println("Processing payment of $" + amount + " for Reservation ID: " + reservationId + " using " + paymentMethod);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", reservationId=" + reservationId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
