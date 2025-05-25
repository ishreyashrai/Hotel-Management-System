import javax.swing.*;

public class DashboardFrame extends JFrame {
    JButton bookRoom, orderFood, checkout, payment;

    public DashboardFrame(String username) {
        setTitle("Dashboard - " + username);
        setSize(400, 300);
        setLayout(null);

        bookRoom = new JButton("Book Room");
        orderFood = new JButton("Order Food");
        checkout = new JButton("Checkout");
        payment = new JButton("Make Payment");

        bookRoom.setBounds(50, 50, 140, 40);
        orderFood.setBounds(200, 50, 140, 40);
        checkout.setBounds(50, 120, 140, 40);
        payment.setBounds(200, 120, 140, 40);

        add(bookRoom);
        add(orderFood);
        add(checkout);
        add(payment);

        bookRoom.addActionListener(e -> new RoomBookingFrame(username));
        orderFood.addActionListener(e -> new FoodOrderFrame(username));
        checkout.addActionListener(e -> Database.checkout(username));
        payment.addActionListener(e -> Database.makePayment(username));

        setVisible(true);
    }
}
