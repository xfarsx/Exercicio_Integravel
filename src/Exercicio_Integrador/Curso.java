package Exercicio_Integrador;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nome;
    private Integer codigoDoCurso;
    private ProfessorAdjunto profAdj = new ProfessorAdjunto();
    private ProfessorTitular profTit = new ProfessorTitular();
    List<Aluno> listadeAlunos = new ArrayList<>(0);
    private Integer vagas;

    public Curso() {
    }

    public  Curso (String nome, Integer vagas, Integer codigoDoCurso)
    {
        this.nome = nome;
        this.vagas = vagas;
        this.codigoDoCurso = codigoDoCurso;
    }
    public Curso(String nome, Integer codigoDoCurso, ProfessorAdjunto profAdj, ProfessorTitular profTit, List<Aluno> listadeAlunos) {
        this.nome = nome;
        this.codigoDoCurso = codigoDoCurso;
        this.profAdj = profAdj;
        this.profTit = profTit;
        this.listadeAlunos = listadeAlunos;
    }
    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public void setCodigoDoCurso(Integer codigoDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
    }

    public ProfessorAdjunto getProfAdj() {
        return profAdj;
    }

    public void setProfAdj(ProfessorAdjunto profAdj) {
        this.profAdj = profAdj;
    }

    public ProfessorTitular getProfTit() {
        return profTit;
    }

    public void setProfTit(ProfessorTitular profTit) {
        this.profTit = profTit;
    }

    public List<Aluno> getlistadeAlunos() {
        return listadeAlunos;
    }

    public void setlistadeAlunos(List<Aluno> listadeAlunos) {
        this.listadeAlunos = listadeAlunos;
    }

}
