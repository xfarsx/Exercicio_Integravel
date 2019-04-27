package Exercicio_Integrador;

import java.util.List;
import java.util.Scanner;

public class DigitalManager {

    List<Aluno> listaDeAlunos;
    List<Professor> listaDeProfessores;
    List<Matricula> listaDeMatriculas;
    List<Curso> listaDeCursos;

    public DigitalManager() {
    }

    public DigitalManager(List<Aluno> listaDeAlunos, List<Professor> listaDeProfessores, List<Matricula> listaDeMatriculas, List<Curso> listaDeCursos) {
        this.listaDeAlunos = listaDeAlunos;
        this.listaDeProfessores = listaDeProfessores;
        this.listaDeMatriculas = listaDeMatriculas;
        this.listaDeCursos = listaDeCursos;
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public List<Professor> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<Professor> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public List<Matricula> getListaDeMatriculas() {
        return listaDeMatriculas;
    }

    public void setListaDeMatriculas(List<Matricula> listaDeMatriculas) {
        this.listaDeMatriculas = listaDeMatriculas;
    }

    public List<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }
    public void registrarCurso(Curso curso)
    {
        String digitarN;
        int digitarC;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digitar nome do curso: ");
        digitarN = sc.next();
        curso.setNome(digitarN);
        System.out.println("Digitar capacidade de curso: ");
        digitarC = sc.nextInt();
        curso.setVagas(digitarC);
        System.out.println("Digitar código: ");
        digitarC = sc.nextInt();
        curso.setCodigoDoCurso(digitarC);

    }

}
