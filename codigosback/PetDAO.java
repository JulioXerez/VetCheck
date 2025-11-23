
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PetDAO {

    // Cadastrar novo animal
    public boolean cadastrarPet(Pets pets) {
        String sql = "INSERT INTO pets (tipo, nome, idade, alergias, raca, sexo, queixa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
                stmt = classeconexao.getConnection().prepareStatement(sql);
                stmt.setString(1, pets.getTipo());
                stmt.setString(2, pets.getNome());
                stmt.setInt(3, pets.getIdade());
                stmt.setString(4, pets.getAlergias());
                stmt.setString(5, pets.getRaca());
                stmt.setString(6, pets.getSexo());
                stmt.setString(7, pets.getQueixas());
                stmt.executeUpdate();
            System.out.println(" Pet cadastrado com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pet: " + e.getMessage());
            return false;
        }
    }

    // Buscar ficha médica do pet pelo nome
    public void exibirFichaMedica(String nomePet) {
        String sql = "SELECT * FROM pets WHERE id = ?";
        PreparedStatement stmt = null;
        try{
                stmt = classeconexao.getConnection().prepareStatement(sql);
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
