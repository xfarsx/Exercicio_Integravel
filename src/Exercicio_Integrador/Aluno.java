package Exercicio_Integrador;
import br.com.digitalhouse.Estudioso;

import java.util.Scanner;

public class Aluno implements Estudioso {

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

    public void estudioso() {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("Digitar horas de estudo: ");
        digitar = sc.nextInt();
        while (digitar < 0)
        {
            System.out.println("digite uma opção válida!");
            digitar = sc.nextInt();
        }}catch (Exception e){
            System.out.println("Opção inválida! Digite novamente\n");
            digitar = sc.nextInt();
        }

        if (digitar >= 2)
        {
            System.out.println("\nAluno Estudioso.\n");
        }
        if (digitar > 0 && digitar < 2)
        {
            System.out.println("\nComparecer ao co-learning.\n");
        }

    }


    @Override
    public float getNivelDeEstudo() {
        return 0;
    }
}
