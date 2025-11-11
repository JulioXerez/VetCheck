import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ususarioDAO{
    public boolean cadastrar(String username, String senha)  {
         String sql = "INSERT INTO usuarios (username, senha) VALUES (?, ?)";
        
        try (Connection conn = classeconexão.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, senha);
            stmt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso! ");

        } catch (Exception e) {
            System.out.println("erro ao cadastrar: " + e.getMessage());
        }
        return false;

    }


    boolean autenticar(String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//classe de conexão
    public static class classeconexão {
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



    

}

