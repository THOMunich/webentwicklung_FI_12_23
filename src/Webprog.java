
import java.sql.*;

import javax.swing.JOptionPane;


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

        // Benutzer anlegen/eingeben
        String sqlEingabe = "INSERT INTO userdata (username, passwordcol, email) VALUES (?, ?, ?)";
        PreparedStatement insertStatement = conn.prepareStatement(sqlEingabe);
        insertStatement.setString(1, JOptionPane.showInputDialog("Bitte neuen Benutzernamen eingeben"));
        insertStatement.setString(2, JOptionPane.showInputDialog("Bitte neues Passwort eingeben"));
        insertStatement.setString(3, JOptionPane.showInputDialog("Bitte neue E-Mail eingeben"));
        int rowsInserted = insertStatement.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "==> Ein neuer Benutzer wurde erfolgreich eingefügt!");
            System.out.println();
            System.out.println("==> Ein neuer Benutzer wurde erfolgreich eingefügt!");
        }

        // Abfrage SQL
        String sqlAbfrage = "SELECT * FROM userdata WHERE username = ?"; // and passwordcol = ?";
        // Eingabe
        PreparedStatement statement = conn.prepareStatement(sqlAbfrage);
        statement.setString(1, JOptionPane.showInputDialog("Bitte gesuchten Namen eingeben"));
        statement.setString(2, JOptionPane.showInputDialog("Bitte gesuchtes Passwort eingeben"));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            JOptionPane.showMessageDialog(null,"++ Die Daten wurden gefunden ++");
            System.out.println();
            System.out.println("===============================");
            System.out.println("== Die Daten wurden gefunden ==");
            System.out.println("===============================");
        } else {
            JOptionPane.showMessageDialog(null,"!! Die Daten wurden nicht gefunden !!");
            System.out.println();
            System.out.println("=====================================");
            System.out.println("== Die Daten wurden nicht gefunden ==");
            System.out.println("=====================================");
        }
        conn.close();

    }
}