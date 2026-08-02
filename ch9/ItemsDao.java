import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsDao {
    public ItemsDao() {

    }

    public static List<Item> findByMinimumPrice(int price) {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to load driver");
        }

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:h2:~/hogedb", "id", "password");

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ITEMS WHERE price >= ?");
            pstmt.setInt(1, price);

            ResultSet rs = pstmt.executeQuery();

            List<Item> items = new ArrayList<Item>();
            while (rs.next()) {
                String itemName = rs.getString("name");
                int itemPrice = rs.getInt("price");
                int itemWeight = rs.getInt("weight");
                Item item = new Item(itemName, itemPrice, itemWeight);

                items.add(item);
            }
            rs.close();
            pstmt.close();
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
