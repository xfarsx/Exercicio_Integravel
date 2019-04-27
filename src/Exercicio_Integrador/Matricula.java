package Exercicio_Integrador;
import java.util.Date;

public class Matricula {

    Date dataDoDia = new Date();
    private Aluno aluno;
    private Curso curso;
    private Date getDataDoDia;

    public Matricula() {


    }

    public Matricula(Date dataDoDia, Aluno aluno, Curso curso, Date getDataDoDia) {
        this.dataDoDia = dataDoDia;
        this.aluno = aluno;
        this.curso = curso;
        this.getDataDoDia = getDataDoDia;
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

    public Date getGetDataDoDia() {
        return getDataDoDia;
    }

    public void setGetDataDoDia(Date getDataDoDia) {
        this.getDataDoDia = getDataDoDia;
    }
}
