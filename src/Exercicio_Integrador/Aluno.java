package Exercicio_Integrador;

public class Aluno {

    private String nome;
    private String sobrenome;
    private Integer codigoDoAluno;

    public Aluno() {
    }

    public Aluno(String nome, String sobrenome, Integer codigoDoAluno) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codigoDoAluno = codigoDoAluno;
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

    public Integer getCodigoDoAluno() {
        return codigoDoAluno;
    }

    public void setCodigoDoAluno(Integer codigoDoAluno) {
        this.codigoDoAluno = codigoDoAluno;
    }
    
}
