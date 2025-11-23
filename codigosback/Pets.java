//modelo dos animais 
public class Pets {
    private String tipo;
    private String nome;
    private int idade;
    private String raca;
    private String sexo;
    private String alergias;
    private String queixas;


    public Pets(String tipo, String nome, int idade, String raca, String sexo, String alergias, String queixas) {
        this.tipo = tipo;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
        this.alergias = alergias;
        this.queixas = queixas;
    }
    
    public String getTipo() {return tipo;}
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getAlergias() { return alergias; }
    public String getRaca() { return raca; }
    public String getSexo() { return sexo; }
    public String getQueixas() { return queixas; }
}
