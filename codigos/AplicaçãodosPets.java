
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

                System.out.print("Raça : ");
             String raca = sc.nextLine();

                System.out.print("Sexo (M/F) : ");
                String sexo = sc.nextLine();

                System.out.print("Alergias (se houver) : ");
                String alergias = sc.nextLine();
        
                System.out.print("Queixas do problema : ");
             String queixas = sc.nextLine();

                Pet pet = new Pet (tipo, nome, idade, raca, sexo, alergias, queixas);
                dao.cadastrarPet(pet);

            } else if (opção == 2) {
                System.out.print("Digite o nome do pet para exibir a ficha médica: ");      
                String nomePet = sc.nextLine();
                dao.exibirFichaMedica(nomePet);     
            } else if (opção == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }   
        }
        sc.close();
    }
}
