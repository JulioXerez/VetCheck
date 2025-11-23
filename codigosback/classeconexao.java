import java.sql.Connection;
import java.sql.DriverManager;


public class classeconexao {
    private static final String URL = "jdbc:mysql://nozomi.proxy.rlwy.net:11272/railway ";
    private static final String USER = "root"; //usuario do mySQL
    private static final String PASSWORD = "hzYupDFgGQmKEmphULjVibEpcNuIaftG"; //senha so mySQL

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException ("Erro na coexão: " + e.getMessage());
        }

    }
        
}   


