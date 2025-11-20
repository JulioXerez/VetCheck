import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    //sistema do cadastro
    public boolean cadastrar(String username, String senha)  {
        String sql = "INSERT INTO usuarios (username, senha) VALUES (?, ?)";

            PreparedStatement stmt = null;
            
        try{
                stmt = classeconexão.getConnection().prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, senha);

             System.out.println("Usuário cadastrado com sucesso!");
             return true; // agora retorna true se deu certo

            }catch (SQLException e) {

            e.printStackTrace();
            return false; // retorna false em caso de erro
            }
    }
        //sistema para autenticar
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
