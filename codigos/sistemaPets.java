
//modelo dos animais 
public class sistemaPets {
    private String tipo;
    private int id;
    private String nome;
    private int idade;
    private String raça;
    private String sexo;
    private String alergias;
    private String queixas;


    public void pet(String tipo, int id, String nome, int idade, String raça, String sexo, String alergias, String queixas) {
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.raça = raça;
        this.sexo = sexo;
        this.alergias = alergias;
        this.queixas = queixas;
    }
    
    public String getTipo() { return tipo; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getAlergias() { return alergias; }
    public String getRaça() { return raça; }
    public String getSexo() { return sexo; }
    public String getQueixas() { return queixas; }

    public void setId(int id) { this.id = id; }

}

