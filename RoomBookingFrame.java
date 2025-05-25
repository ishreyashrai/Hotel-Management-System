import javax.swing.*;

public class RoomBookingFrame extends JFrame {
    JComboBox<String> roomType;
    JButton confirm;

    public RoomBookingFrame(String username) {
        setTitle("Book Room");
        setSize(300, 200);
        setLayout(null);

        roomType = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        confirm = new JButton("Confirm");

        roomType.setBounds(100, 40, 120, 30);
        confirm.setBounds(100, 100, 120, 30);

        add(new JLabel("Room Type:")).setBounds(20, 40, 80, 30);
        add(roomType);
        add(confirm);

        confirm.addActionListener(e -> {
            String room = (String) roomType.getSelectedItem();
            Database.bookRoom(username, room);
            dispose();
        });

        setVisible(true);
    }
}
