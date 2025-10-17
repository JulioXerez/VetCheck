import java.util.Scanner;

public class Sistemalogin {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      ususarioDAO dao = new ususarioDAO();

      while (true) { 
          System.out.println("\n--- SISTEMA DE LOGIN ---");
          System.out.println("1 - cadastrar novo usuário");
          System.out.println("2 - fazer login");
          System.out.println("0 - Sair");
          int opcao = sc.nextInt();
          sc.nextLine();

          if (opcao ==1) {
            System.out.print("digite o ususaráario:");
            String user = sc.nextLine();

            System.out.print("Digite a senha: ");
            String pass = sc.nextLine();

            if (dao.cadastrar(user,pass))  {
              System.out.println("Usuário cadastrado com sucesso!");
            } else {
              System.out.println("Erro ao cadastrar usuário. ");
            }

          } else if (opcao == 2) {
            System.out.println("Usuario: ");
            String user = sc.nextLine();

            System.out.print("Senha: ");
            String pass = sc.nextLine();

            if (dao.autenticar(user, pass)) {
              System.out.println("Login bem sucessido seja bem vindo, " + user);
            } else{
              System.out.println("usuário ou senha incorretas. ");  
            }
          } else if (opcao == 0) {
            System.out.println("saindo...");
            break;
          } else {
            System.out.println("opção inválida, tente novamente.");
            }
            sc.close();
         }
          
          
          
          }
      }

  

    