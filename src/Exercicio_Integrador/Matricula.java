package Exercicio_Integrador;
import java.util.Date;

public class Matricula {

    Date dataDoDia = new Date();
    private Aluno aluno;
    private Curso curso;

    public Matricula() {


    }

    public Matricula(Date dataDoDia, Aluno aluno, Curso curso) {
        this.dataDoDia = dataDoDia;
        this.aluno = aluno;
        this.curso = curso;
    }

    public Date getDataDoDia() {
        return dataDoDia;
    }

    public void setDataDoDia(Date dataDoDia) {
        this.dataDoDia = dataDoDia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
