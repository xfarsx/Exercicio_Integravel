package Exercicio_Integrador;

public class Professor {

    private String nome;
    private String sobrenome;
    private Integer tempoDeCasa;
    private Integer codigoDoProf;

    public Professor() {
    }

    public Professor(String nome, String sobrenome, Integer tempoDeCasa, Integer codigoDoProf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tempoDeCasa = tempoDeCasa;
        this.codigoDoProf = codigoDoProf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getTempoDeCasa() {
        return tempoDeCasa;
    }

    public void setTempoDeCasa(Integer tempoDeCasa) {
        this.tempoDeCasa = tempoDeCasa;
    }

    public Integer getCodigoDoProf() {
        return codigoDoProf;
    }

    public void setCodigoDoProf(Integer codigoDoProf) {
        this.codigoDoProf = codigoDoProf;
    }
}
