import java.util.Scanner;

public class AplicaçãodosPets {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        PetDAO dao = new PetDAO();

        while (true) {
            System.out.println("\n--- SISTEMA DE CADASTRO DE PETS ---");
            System.out.println("1- Cadastrar novo pet");
            System.out.println("2- Exibir ficha médica do pet");
            System.out.println("3- Sair");
            System.out.println("Escolha uma opçãao: ");
            int opção = sc.nextInt();
            sc.nextLine();  

            if (opção == 1) {
               System.out.print("Tipo do animal (Cachorro/Gato/Outro) : ");
                String tipo = sc.nextLine();

               System.out.print("Nome do pet : ");
                String nome = sc.nextLine();

               System.out.print("Idade : ");
               int idade = sc.nextInt();
               sc.nextLine();

                System.out.print("Raça : ");
               String raca = sc.nextLine();

                System.out.print("Sexo : ");
                String sexo = sc.nextLine();

                System.out.print("Alergias (se houver) : ");
                String alergias = sc.nextLine();
        
                System.out.print("Queixas do problema : ");
                  String queixas = sc.nextLine();

             Pets pets = new Pets (tipo, nome, idade, raca, sexo, alergias, queixas);

             
                if (dao.cadastrarPet(pets)) {
                    System.out.println(" Usuário cadastrado com sucesso!");
                } else {
                    System.out.println(" Erro ao cadastrar usuário.");
                }


             }else if (opção == 2) {
             System.out.print("Digite o nome do pet para exibir a ficha médica: ");
             String nomePet = sc.nextLine();
             dao.exibirFichaMedica(nomePet);

             

               }else if(opção == 0 ){
                System.out.print("Encerrando o sistema...");
                break;
              }else {
                System.out.print("Opção inválida, tente novamente.");
        
       
            }
        }
    }
}
