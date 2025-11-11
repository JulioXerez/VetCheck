import java.sql.Connection;
import java.sql.DriverManager;


public class classeconexão {
    private static final String URL = "jdbc:mysql://licalhost:3306/sistema_login";
    private static final String USER = "root"; //usuario do mySQL
    private static final String PASSWORD = "senha"; //senha so mySQL

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException ("Erro na coexão: " + e.getMessage());
        }

    }
        
}   


