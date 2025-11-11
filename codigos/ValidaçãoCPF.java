public class ValidaçãoCPF{
    public  static boolean validarCPF(String cpf) { 
        cpf = cpf.replaceAll(("[^0-9]"),"");
    if (cpf.length() != 11 || cpf.matches("\\d\\1{10}")) return false;

    int soma = 0, resto;
    for (int i = 1; i <= 9; i++)
            soma += Integer.parseInt(cpf.substring(i - 1, i)) * (11 - i);
    return false;
    }
}
     