import java.util.Scanner;

public class Sistemalogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        while (true) {
            System.out.println("\n--- SISTEMA DE LOGIN ---");
            System.out.println("1 - Cadastrar novo usuário");
            System.out.println("2 - Fazer login");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o usuário: ");
                String user = sc.nextLine();
                System.out.print("Digite a senha: ");
                String pass = sc.nextLine();
                System.out.print("Digite o cpf: ");
                String cpf = sc.nextLine();
                System.out.print("Digite a idade: ");
                int idade = sc.nextInt();
                sc.nextLine();
                System.out.print("Digite o email: ");
                String email = sc.nextLine();
        

                if (dao.cadastrar(user, pass, cpf, idade, email)) {
                    System.out.println(" Usuário cadastrado com sucesso!");
                } else {
                    System.out.println(" Erro ao cadastrar usuário.");
                }

            } else if (opcao == 2) {
                System.out.print("Usuário: ");
                String user = sc.nextLine();

                System.out.print("Senha: ");
                String pass = sc.nextLine();

                System.out.println("cpf: ");
                String cpf = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Email: ");
                String email = sc.nextLine();


                if (dao.autenticar(user, pass, cpf, idade, email)) {
                    System.out.println(" Login bem-sucedido! Bem-vindo, " + user);
                } else {
                    System.out.println(" Usuário ou senha incorretos.");
                }

            } else if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println(" Opção inválida, tente novamente.");
            }
        }

        sc.close(); 
    }
}
