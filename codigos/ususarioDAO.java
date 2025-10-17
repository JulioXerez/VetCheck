import java.sql.Connection;
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

        if (truw) {
            System.out.println("Usuário cadastrado com sucesso! ");
            return true;
        } else {
            System.out.println("Erro ao cadastrar usuário.");
            return false;
        }

    }


    

}

