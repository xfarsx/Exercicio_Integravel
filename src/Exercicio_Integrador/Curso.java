package Exercicio_Integrador;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nome;
    private Integer codigoDoCurso;
    private ProfessorAdjunto profAdj;
    private ProfessorTitular profTit;
    List<Aluno> listaDeAlunos;
    private Integer vagas;

    public Curso() {
    }

    public Curso(String nome, Integer codigoDoCurso, ProfessorAdjunto profAdj, ProfessorTitular profTit, List<Aluno> listaDeAlunos) {
        this.nome = nome;
        this.codigoDoCurso = codigoDoCurso;
        this.profAdj = profAdj;
        this.profTit = profTit;
        this.listaDeAlunos = listaDeAlunos;
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

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public boolean adicionarUmAluno (Aluno umAluno)
    {
        if(this.listaDeAlunos.size() < vagas){
            this.listaDeAlunos.add(umAluno);}
        return true;
    }
    public void excluirUmAluno (Aluno umAluno)
    {
     this.listaDeAlunos.remove(umAluno);
    }

}
