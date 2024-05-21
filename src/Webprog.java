import static javax.swing.JOptionPane.showInputDialog;

public class Webprog {
    public static void main(String[] args) {


        String beispielName = "Max";
        String username = showInputDialog("Bitte geben Sie den Benutzernamen ein: ");
        String email = showInputDialog("Bitte geben Sie die Email ein: ");
        String password = showInputDialog("Bitte geben Sie das Passwort ein: ");
        
        User user1 = new User(username,email,password);

        System.out.println();
        System.out.println(" Name 1 ist: " + beispielName);
        System.out.println();
        System.out.println(" Name 2 ist: " +"\t"+username + "\n Email ist: "+"\t"+email+ "\n Passwort ist: " +"\t"+password);


    }
}