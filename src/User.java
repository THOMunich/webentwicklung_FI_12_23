/**
 * Speichert die Daten eines Nutzers
 */

public class User {

    String username;
    String email;
    String password;
    int alter;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    //Konstruktor mit freiwilliger Altersangabe
    public User(String username, String password, String email, int alter) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.alter = alter;
    }
}
