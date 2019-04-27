package Exercicio_Integrador;

public class ProfessorTitular extends Professor {

    private String especialidade;

    public ProfessorTitular() {
    }

    public ProfessorTitular(String especialidade) {
        this.especialidade = especialidade;
    }

    public ProfessorTitular(String nome, String sobrenome, Integer tempoDeCasa, Integer codigoDoProf, String especialidade) {
        super(nome, sobrenome, tempoDeCasa, codigoDoProf);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
