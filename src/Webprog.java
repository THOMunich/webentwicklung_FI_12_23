import java.sql.*;

import static javax.swing.JOptionPane.showInputDialog;


public class Webprog {
    public static void main(String[] args) throws SQLException {

/*
        //String beispielName = "Max";
        String username = showInputDialog("Bitte geben Sie den Benutzernamen ein: ");
        String email = showInputDialog("Bitte geben Sie die Email ein: ");
        String password = showInputDialog("Bitte geben Sie das Passwort ein: ");
        
        User user1 = new User(username,email,password);

        //System.out.println();
        //System.out.println(" Name 1 ist: " + beispielName);
        System.out.println();
        System.out.println(" Name 2 ist: " +"\t"+username + "\n Email ist: "+"\t"+email+ "\n Passwort ist: " +"\t"+password);
*/

        // Connection to MySQL
        Connection conn = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/userdb", "root", "rootpassword");
        // Abfrage SQL
        String sqlAbfrage = "SELECT * FROM userdata WHERE username = ? and passwordcol = ?";

        PreparedStatement statement = conn.prepareStatement(sqlAbfrage);
        statement.setString(1, showInputDialog("Bitte gesuchten Namen eingeben"));
        statement.setString(2, showInputDialog("Bitte gesuchtes Passwort eingeben"));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println();
            System.out.println("===========================");
            System.out.println("Die Daten wurden gefunden");
            System.out.println("===========================");
        } else {
            System.out.println();
            System.out.println("===============================");
            System.out.println("Die Daten wurden nicht gefunden");
            System.out.println("===============================");
        }
        conn.close();


    }
}