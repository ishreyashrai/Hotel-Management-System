import java.sql.*;
import javax.swing.*;

public class Database {
    static Connection connect() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost/hotel_db", "root", ""); //here the password is null,please changeit.
    }

    public static boolean authenticate(String user, String pass) {
        try (Connection con = connect()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public static void register(String user, String pass) {
        try (Connection con = connect()) {
            PreparedStatement st = con.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?)");
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "User already exists");
        }
    }

    public static void bookRoom(String user, String type) {
        try (Connection con = connect()) {
            PreparedStatement st = con.prepareStatement("INSERT INTO bookings(username, room_type) VALUES(?, ?)");
            st.setString(1, user);
            st.setString(2, type);
            st.executeUpdate();
        } catch (Exception e) {}
    }

    public static void orderFood(String user, int amount) {
        try (Connection con = connect()) {
            PreparedStatement st = con.prepareStatement("INSERT INTO food_orders(username, amount) VALUES(?, ?)");
            st.setString(1, user);
            st.setInt(2, amount);
            st.executeUpdate();
        } catch (Exception e) {}
    }

    public static void checkout(String user) {
        JOptionPane.showMessageDialog(null, "Checkout completed");
    }

    public static void makePayment(String user) {
        JOptionPane.showMessageDialog(null, "Payment successful");
    }
}
