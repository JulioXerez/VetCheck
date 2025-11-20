
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PetDAO {

    // Cadastrar novo animal
    public void cadastrarPet(Pet pet) {
        String sql = "INSERT INTO pets (tipo, nome, idade, alergias, raca, sexo, queixa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Statement Conexao = null;
        try (Connection conn = Conexao.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pet.getTipo());
            stmt.setString(2, pet.getNome());
            stmt.setInt(3, pet.getIdade());
            stmt.setString(4, pet.getAlergias());
            stmt.setString(5, pet.getRaca());
            stmt.setString(6, pet.getSexo());
            stmt.setString(7, pet.getQueixa());
            stmt.executeUpdate();
            System.out.println(" Pet cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pet: " + e.getMessage());
        }
    }

    // Buscar ficha médica do pet pelo nome
    public void exibirFichaMedica(String nomePet) {
        String sql = "SELECT * FROM pets WHERE nome = ?";
        Statement Conexao = null;
        try (Connection conn = Conexao.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomePet);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n --- FICHA MÉDICA DO PET --- ");
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getInt("idade"));
                System.out.println("Raça: " + rs.getString("raca"));
                System.out.println("Sexo: " + rs.getString("sexo"));
                System.out.println("Alergias: " + rs.getString("alergias"));
                System.out.println("Queixa do problema: " + rs.getString("queixa"));
                System.out.println("--------------------------------------\n");
            } else {
                System.out.println(" Pet não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar ficha médica: " + e.getMessage());
        }
    }
}
