import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean cadastrar(String username, String senha, String cpf, int idade, String email)  {
        String sql = "INSERT INTO usuarios (username, senha, cpf, idade, email) VALUES (?, ?, ?, ?, ? )";

        PreparedStatement stmt = null;
        try{
                stmt = classeconexao.getConnection().prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, senha); 
                stmt.setString(3, cpf);
                stmt.setInt(4, idade);
                stmt.setString(5, email);
                

                stmt.execute();
                stmt.close();
                

            System.out.println("Usuário cadastrado com sucesso!");
            return true; // agora retorna true se deu certo

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
   

        // autenticar
        public boolean autenticar(String username, String senha, String cpf, int idade, String email ) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ? AND cpf = ? AND idade = ? AND email = ?";

        PreparedStatement stmt = null;
        try{
                stmt = classeconexao.getConnection().prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, senha);
                stmt.setString(3, cpf);
                stmt.setInt(4, idade);
                stmt.setString(5, email);
        


                ResultSet rs =  stmt.executeQuery();
                
                return rs.next();
                } catch (Exception e) {
                System.out.println("Erro ao autenticar: " + e.getMessage());
                return false;
             }
        }
        public static boolean validarCPF (String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (CPF inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo dos dígitos verificadores
        try {
            int soma = 0;
            int peso = 10;

            // Primeiro dígito verificador
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso;
                peso--;
            }

            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) {
                primeiroDigito = 0;
            }

            // Segundo dígito verificador
            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso;
                peso--;
            }

            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) {
                segundoDigito = 0;
            }

            // Confirma se os dígitos calculados são iguais aos informados
            return cpf.charAt(9) - '0' == primeiroDigito &&
                   cpf.charAt(10) - '0' == segundoDigito;

        } catch (Exception e) {
            return false;
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

