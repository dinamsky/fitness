package app.model;

import app.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
    String url;
    String login ;
    String password;
    String driver;

    public Connect(String url, String login, String password, String driver) {
        this.url = url;
        this.login = login;
        this.password = password;
        this.driver = driver;
    }

    public List<String> listDatabase() {

        try {
            Class.forName(driver);
            java.sql.Connection con = DriverManager.getConnection(url, login, password);
            List<String> result = new ArrayList<>();

            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM FITNESS");
                while (rs.next()) {
                    result.add(rs.getString(2));
                }
                rs.close();
                stmt.close();

                return result;
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     return null;
    }
    public void addDatabase(User user) {

        try {
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, login, password);
            String query = "INSERT INTO fitness ("
                    + " name,"
                    + " surname,"
                    + " birthdate,"
                    + " regdate,"
                    + " fitplan) VALUES ("
                    + " ?, ?, ?, ?, ?)";

            try {
                PreparedStatement stmt =  con.prepareStatement(query);
                stmt.setString(1, user.getName());
                stmt.setString(3, user.getSurname());
               // stmt.setString(4, user.getbYear());
                stmt.setString(5, user.getRegDate());
       //         stmt.setString(6, user.getFitPlan());

                int i = stmt.executeUpdate();

            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
