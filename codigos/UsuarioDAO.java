import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    public boolean cadastrar(String username, String senha)  {
        String sql = "INSERT INTO usuarios (username, senha) VALUES (?, ?)";

        try (Connection conn = classeConexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, senha);
            stmt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");
            return true; // agora retorna true se deu certo

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    // Mantive apenas 1 autenticar
    public boolean autenticar(String user, String pass) {
        throw new UnsupportedOperationException("Método ainda não implementado");
    }

    // Classe de conexão corrigida
    public static class classeConexao {
        private static final String URL = "jdbc:mysql://nozomi.proxy.rlwy.net:11272/railway ";
        private static final String USER = "root";
        private static final String PASSWORD = "hzYupDFgGQmKEmphULjVibEpcNuIaftG";

        public static Connection getConnection(){
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                throw new RuntimeException("Erro na conexão: " + e.getMessage());
            }
        }
    }
}
