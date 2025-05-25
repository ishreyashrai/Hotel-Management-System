import javax.swing.*;

public class FoodOrderFrame extends JFrame {
    JCheckBox pizza, burger, tea;
    JButton order;

    public FoodOrderFrame(String username) {
        setTitle("Order Food");
        setSize(300, 250);
        setLayout(null);

        pizza = new JCheckBox("Pizza - ₹150");
        burger = new JCheckBox("Burger - ₹100");
        tea = new JCheckBox("Tea - ₹50");
        order = new JButton("Order Now");

        pizza.setBounds(50, 30, 200, 30);
        burger.setBounds(50, 70, 200, 30);
        tea.setBounds(50, 110, 200, 30);
        order.setBounds(80, 160, 120, 30);

        add(pizza);
        add(burger);
        add(tea);
        add(order);

        order.addActionListener(e -> {
            int total = 0;
            if (pizza.isSelected()) total += 150;
            if (burger.isSelected()) total += 100;
            if (tea.isSelected()) total += 50;
            Database.orderFood(username, total);
            dispose();
        });

        setVisible(true);
    }
}
