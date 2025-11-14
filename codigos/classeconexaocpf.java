
import java.sql.Connection;
import java.sql.DriverManager;

public class classeconexaocpf {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
