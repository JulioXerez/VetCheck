

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usuarioDAOcpf {

    public void cadastrarUsuario(String nome, String cpf, int idade) {
     try (Connection conn = Conexao.getConnection()) {
            String sql = "INSERT INTO usuarios (nome, cpf, idade) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setInt(3, idade);
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verificarMaioridade(String cpf) {
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT nome, idade FROM usuarios WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");

                if (idade >= 18) {
                    System.out.println(nome + " é maior de idade.");
                } else {
                    System.out.println(nome + " é menor de idade.");
                }
            } else {
                System.out.println("Usuário não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Conexao {

        public Conexao() {
        }

        public static Connection getConnection() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
        }
    }
}
