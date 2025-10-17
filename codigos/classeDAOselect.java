import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class classeDAOselect {
    public boolean autenticar(String username, String senha) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";

        try (Connection conn = ConeXao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, username);
                stmt.setString(2, senha); 

                ResultSet rs =  stmt.executeQuery();
                
                return rs.next();
            } catch (Exception e) {
                System.out.println("Erro ao autenticar: " + e.getMessage());
                return false;

            }
    }
    
}
