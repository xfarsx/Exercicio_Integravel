package Exercicio_Integrador;

import br.com.digitalhouse.DHException;
import br.com.digitalhouse.DigitalException;
import br.com.digitalhouse.Estudioso;
import br.com.digitalhouse.OtherException;
import com.sun.jdi.event.ExceptionEvent;
import jdk.swing.interop.SwingInterOpUtils;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.Instant;
import java.util.*;

public class DigitalManager {

    List<Aluno> listaDeAlunos = new ArrayList<>();
    List<Professor> listaDeProfessores = new ArrayList<>();
    List<Matricula> listaDeMatriculas = new ArrayList<>();
    List<Curso> listaDeCursos = new ArrayList<>();
    private Integer gerarCodigoA = 999;
    private Integer gerarCodigoP = 99;
    private Integer gerarCodigoC = 19999;

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

    public Integer gerarCodigoCurso() {
        gerarCodigoC = gerarCodigoC + 1;
        return gerarCodigoC;
    }

    //
    // ******************************* MENU GERAL (REGISTRAR / CONSULTAR / SAIR) ***********************
    //

    public void Menu() {
        Scanner sc = new Scanner(System.in);
        int digitarN;

        try {
            System.out.println("===============================\nBem vindo a Digital House!\n===============================" +
                    "\nEscolha as opções abaixo:\n\n(1) Registrar\n(2) Consultar\n(3) Editar \n(4) Excluir\n(5) Sair do programa");
            digitarN = sc.nextInt();
            while (digitarN < 1 || digitarN > 4) {
                System.out.println("======================\nErro!!\n======================\nDigite uma opção válida!\n" +
                        "\n(1) Registrar\n(2) Consultar\n(3) Editar \n(4) Excluir\n(5) Sair do programa\n");
                digitarN = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("===============================\nErro!! Digite uma opção válida!\n===============================");
            digitarN = 0;
        }

        if (digitarN == 0) {
            Menu();
        }
        if (digitarN == 1) {
            menuRegistro();
        }
        if (digitarN == 2) {

            menuConsultar();
        }
        if (digitarN == 3) {
            menuEditar();
        }

        if (digitarN == 4) {
            menuExcluir();
        }
        if (digitarN == 5) {
            System.out.println("Saindo do Programa...");
            System.exit(0);
        }
    }

    //
    // ************************ MENU E MÉTODOS PARA REGISTRAR *************************
    //

    public void registrarCurso() {

        Curso curso = new Curso();
        String digitarN;
        int digitarC;
        Scanner sc = new Scanner(System.in);

        System.out.println("===================\nRegistrando Curso\n====================");
        System.out.println("Digitar nome do curso: ");
        digitarN = sc.next();
        curso.setNome(digitarN);
        try {
            System.out.println("Digitar quantidade de vagas do curso: ");
            digitarC = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro! Digite Novamente");
            registrarCurso();
            digitarC = sc.nextInt();
        }
        curso.setNome(digitarN);
        curso.setVagas(digitarC);
        curso.setCodigoDoCurso(gerarCodigoCurso());
        System.out.println("Código Gerado: " + curso.getCodigoDoCurso() + "\n==============================\n");
        listaDeCursos.add(curso);
        voltarMenuRegistrarSair();
    }


    public void registrarAluno() {
        Aluno aluno = new Aluno();
        String digitarNome, digitarS;
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================\nRegistrar Aluno(a)\n=====================");
        System.out.println("Digitar nome: ");
        digitarNome = sc.next();
        System.out.println("Digitar sobrenome: ");
        digitarS = sc.next();
        aluno.estudioso();
        aluno.setNome(digitarNome);
        aluno.setSobrenome(digitarS);
        aluno.setCodigoDoAluno(gerarCodigoAluno());
        System.out.println("Código gerado: " + aluno.getCodigoDoAluno() + "\n==============================\n");
        listaDeAlunos.add(aluno);
        voltarMenuRegistrarSair();
    }

    public void matricularAluno() {
        int codigoDoAluno, codigoDoCurso, nA = 0, nC = 0;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Código do Curso:");
            codigoDoCurso = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Código inválido! Digite novamente");
            codigoDoCurso = sc.nextInt();
            matricularAluno();
        }

        for (int i = 0; i < listaDeCursos.size(); i++) {
            if (listaDeCursos.get(i).getCodigoDoCurso() == codigoDoCurso) {
                nC = nC + 1;
            }
        }

        if (nC > 0) {
            for (int i = 0; i < listaDeCursos.size(); i++) {
                try {
                    System.out.println("Código do Aluno(a): ");
                    codigoDoAluno = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Código Inválido! Digite Novamente");
                    codigoDoAluno = sc.nextInt();
                    matricularAluno();
                }
                for (int o = 0; o < listaDeAlunos.size(); o++) {
                    if (listaDeAlunos.get(o).getCodigoDoAluno() == codigoDoAluno) {
                        nA = nA + 1;
                    }
                }

                if (nA > 0) {
                    for (int x = 0; x < listaDeCursos.get(i).getVagas(); x++) {

                        if (listaDeCursos.get(i).listadeAlunos.size() >= listaDeCursos.get(i).getVagas()) {
                            System.out.println("Não foi possível realizar a matrícula pois não há mais vagas para este curso.");
                            break;
                        }
                        if (listaDeAlunos.get(x).getCodigoDoAluno() == codigoDoAluno && listaDeCursos.get(i).getVagas() > listaDeCursos.get(i).
                                listadeAlunos.size()) {

                            Date data = new Date();
                            data.setTime(data.getTime());
                            listaDeCursos.get(i).listadeAlunos.add(listaDeAlunos.get(x));
                            listaDeMatriculas.add(new Matricula(data, listaDeAlunos.get(x), listaDeCursos.get(i)));
                            System.out.println("Aluno(a) matriculado!\nData: " + data);

                        } else if (listaDeAlunos.size() == x && listaDeAlunos.get(x).getCodigoDoAluno() != codigoDoAluno) {
                            System.out.println("==============================\nAluno(a) não encontrado.\n==============================\n");
                        }
                    }
                } else {
                    System.out.println("Aluno(a) não encotrado!");
                }
            }
        } else{
            System.out.println("==============================\nCurso não encontrado.\n==============================\n");

        }

        voltarMenuRegistrarSair();
    }

    public Integer gerarCodigoAluno() {
        gerarCodigoA = gerarCodigoA + 1;
        return gerarCodigoA;
    }

    public void registrarProfessorAdj() {
        int digitarN;
        String digitarNome, digitarS;
        Random random = new Random();
        ProfessorAdjunto professor = new ProfessorAdjunto();
        Scanner sc = new Scanner(System.in);

        System.out.println("======================\nRegistrando Professor(a) Adjunto\n======================");
        System.out.println("Digitar nome: ");
        digitarNome = sc.next();
        System.out.println("Digitar sobrenome: ");
        digitarS = sc.next();
        digitarN = random.nextInt(1000);
        professor.setNome(digitarNome);
        professor.setSobrenome(digitarS);
        professor.setCodigoDoProf(gerarCodigoProfessor());
        System.out.println("Código gerado: " + professor.getCodigoDoProf());
        professor.setTempoDeCasa(digitarN);
        System.out.println("Tempo de casa: " + professor.getTempoDeCasa() + " horas\n==============================\n");
        listaDeProfessores.add(professor);
        voltarMenuRegistrarSair();
    }

    public void registrarProfessorTit() {
        ProfessorTitular professor = new ProfessorTitular();
        String digitarNome, digitarS, digitarEsp;
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================\nRegistrar Professor(a) Titular\n=====================");
        System.out.println("Digitar nome: ");
        digitarNome = sc.next();
        System.out.println("Digitar sobrenome: ");
        digitarS = sc.next();
        System.out.println("Digitar especialidade: ");
        digitarEsp = sc.next();
        professor.setEspecialidade(digitarEsp);
        professor.setNome(digitarNome);
        professor.setSobrenome(digitarS);
        professor.setCodigoDoProf(gerarCodigoProfessor());
        System.out.println("Código gerado: " + professor.getCodigoDoProf() + "\n==============================\n");
        listaDeProfessores.add(professor);
        voltarMenuRegistrarSair();
    }

    public Integer gerarCodigoProfessor() {
        gerarCodigoP = gerarCodigoP + 1;
        return gerarCodigoP;
    }

    public void alocarProfessores () throws InputMismatchException {
        int codigoProfessorT, codigoProfessorA, codigoCurso, n = 0 , n2 = 0, nc = 0;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("Código do Curso:");
        codigoCurso = sc.nextInt();} catch (InputMismatchException e)
        {
            System.out.println("==============================\nErro !!!\n==============================\n" + e.getCause());
            codigoCurso = 0; alocarProfessores();
        }

        for (int i = 0; i < listaDeCursos.size(); i++) {

            if (listaDeCursos.get(i).getCodigoDoCurso() == codigoCurso) {
                nc = nc + 1;
            }
        }
            if (nc > 0) {
                for (int r = 0 ; r < listaDeCursos.size();r++){
                    if (listaDeCursos.get(r).getCodigoDoCurso() == codigoCurso) {

                        try {
                            System.out.println("Código do Professor(a) Titular: ");
                            codigoProfessorT = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("==============================\nErro !!!\n==============================\n");
                            alocarProfessores();
                            codigoProfessorT = 0;
                        }

                        try {
                            System.out.println("Código do Professor(a) Adjunto: ");
                            codigoProfessorA = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("==============================\nErro Fatal! Digite novamente!\n==============================\n");
                            alocarProfessores();
                            codigoProfessorA = 0;
                        }
                        for (int z = 0; z < listaDeProfessores.size(); z++) {
                            if (codigoProfessorT == listaDeProfessores.get(z).getCodigoDoProf()) {
                                n = n + 1;
                            }
                            if (codigoProfessorA == listaDeProfessores.get(z).getCodigoDoProf()) {
                                n2 = n2 + 1;
                            }
                        }
                        if (n > 0) {

                            for (int x = 0; x < listaDeProfessores.size(); x++) {
                                if (listaDeProfessores.get(x).getCodigoDoProf() == codigoProfessorT) {
                                    listaDeCursos.get(r).setProfTit((ProfessorTitular) listaDeProfessores.get(x));
                                    System.out.println("==============================\nProfessor(a) Titular Alocado!\n==============================\n");
                                }
                            }
                        } else {
                            System.out.println("==============================\nProfessor(a) titular não encontrado!\n==============================\n");
                        }

                        if (n2 > 0) {
                            for (int y = 0; y < listaDeProfessores.size(); y++) {
                                if (listaDeProfessores.get(y).getCodigoDoProf() == codigoProfessorA) {
                                    listaDeCursos.get(r).setProfAdj((ProfessorAdjunto) listaDeProfessores.get(y));
                                    System.out.println("==============================\nProfessor(a) Ajunto Alocado!\n==============================\n");
                                }
                            }
                        } else {
                            System.out.println("==============================\nProfessor(a) Adjunto não Encontrado.\n==============================\n");
                        }
                    }}
            }else{
                System.out.println("==============================\nCurso não encontrado.\n==============================\n");
            }

        voltarMenuRegistrarSair();
    }

    public void menuRegistro() {
        Scanner sc = new Scanner(System.in);
        int digitarN;

        try{System.out.println("==============================\nMenu de Registros\n==============================\n(1) Registrar Curso\n(2) Registrar Professor(a) Titular\n(3) Registrar Professor(a) Adjunto" +
                "\n(4) Registrar Aluno(a)\n(5) Alocar Professor(a)\n(6) Matricular Aluno(a)\n(7) Voltar ao Menu\n(8) Sair do Programa");
        digitarN = sc.nextInt();
        while (digitarN < 1 || digitarN >7)
        {
            System.out.println("Digite uma opção válida!");
            digitarN = sc.nextInt();
        }}catch (Exception e){
            System.out.println("==============================\nErro Fatal! Voltando ao Menu Registrar\n==============================")
            ; digitarN = 0;
        }

        if (digitarN == 0)
        {
            menuRegistro();
        }
        if (digitarN == 1) {
            registrarCurso();
        }
        if (digitarN == 2) {
            registrarProfessorTit();
        }
        if (digitarN == 3) {
            registrarProfessorAdj();
        }
        if (digitarN == 4) {
            registrarAluno();
        }
        if (digitarN == 5) {
            alocarProfessores();
        }
        if (digitarN == 6) {
            matricularAluno();
        }
        if (digitarN == 7)
        {
            Menu();
        }
        if (digitarN == 8){
            System.out.println("Saindo do programa! ");
            System.exit(0);
        }
    }

    public void voltarMenuRegistrarSair ()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite as opções abaixo:\n(1) Menu Principal.\n(2) Menu Registrar\n(3) Sair do programa");
             digitar = sc.nextInt();
             while (digitar<1 || digitar >3){
                 System.out.println("Digite uma opção válida!");
                 digitar = sc.nextInt();
             }
        }catch (Exception e){
            System.out.println("==============================\nErro!! Voltando ao menu!!\n=============================="); digitar = 1; }

        if(digitar == 1)
        {
            Menu();
        }
        if(digitar == 2 )
        {
            menuRegistro();
        }
        if (digitar == 3 )
        {
            System.out.println("Saindo do programa...");
            System.exit(0);
        }

    }

    //
    //******************** MENU E MÉTODOS PARA CONSULTAR ***********************
    //

    public void consultarListaAluno()
    {
        System.out.println("==============================\nLista de Alunos Registrados\n==============================\n");
        for (int i = 0;i<listaDeAlunos.size();i++)
        {
            System.out.println("==============================\nAluno(a)\n==============================\n" +
                    "Nome: " + listaDeAlunos.get(i).getNome() + "\nSobrenome: " + listaDeAlunos.get(i).getSobrenome() + "\nCódigo: " +
                    listaDeAlunos.get(i).getCodigoDoAluno() + "\n==============================");
        }
        voltarMenuConsultarSair();
    }
    public void consultarListaCursos ()
    {
        System.out.println("==============================\nLista de Cursos Registrados\n==============================\n");
        for (int i = 0;i<listaDeCursos.size();i++)
        {
            System.out.println("==============================\nCurso\n==============================\n" +
                    "Nome: " + listaDeCursos.get(i).getNome() + "\nCódigo: " + listaDeCursos.get(i).getCodigoDoCurso() +
                    "\nProfessor(a) Titular: " + listaDeCursos.get(i).getProfTit().getNome() + " " + listaDeCursos.get(i).getProfTit().getSobrenome() +
                    "\nProfessor(a) Adjunto: " + listaDeCursos.get(i).getProfAdj().getNome() + " "
                    + listaDeCursos.get(i).getProfAdj().getSobrenome() +
                    "\nVagas: " + listaDeCursos.get(i).getVagas() + "\n==============================");
        }
        voltarMenuConsultarSair();
    }
    public void consultarListaProfessores ()
    {
        System.out.println("==============================\nLista de Professores Registrados\n==============================\n");
        for (int i = 0;i<listaDeProfessores.size();i++)
        {
            System.out.println("==============================\nProfessor(a)\n==============================\n" +
                    "Nome: " + listaDeProfessores.get(i).getNome() + "\nSobrenome: " + listaDeProfessores.get(i).getSobrenome()
                    + "\nCódigo: " + listaDeProfessores.get(i).getCodigoDoProf() + "\n==============================");
        }
        voltarMenuConsultarSair();
    }
    public void consultarListaMatriculas ()
    {
        System.out.println("==============================\nLista de Matrículas\n==============================\n");
        for (int i = 0;i<listaDeMatriculas.size();i++)
        {
            System.out.println("==============================\nMatrícula\n==============================\n" +
                    "\nAluno(a): " + listaDeMatriculas.get(i).getAluno().getNome() + "\nCurso: " + listaDeMatriculas.get(i).getCurso().getNome() + "\nData: " +
                    listaDeMatriculas.get(i).getDataDoDia() + "\n==============================");
        }
        voltarMenuConsultarSair();

    }
    public void menuConsultar()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("==============================\nMenu de Consultas\n==============================\n" +
                "(1) Consultar Cursos\n(2) Consultar Professores\n(3) Consultar Alunos\n(4) Consultar Matrículas\n" +
                "(5) Consultar Aluno(a) Matriculado\n(6) Menu Principal\n(7) Sair do Programa\n==============================\n");
        digitar = sc.nextInt();
        while (digitar < 1 || digitar > 6)
        {
            System.out.println("Opção inválida! Digite novamente!");
            digitar = sc.nextInt();
        }}catch (Exception e){
            System.out.println("\n==============================\nErro Fatal! Voltando ao Menu de Consultas\n==============================\n"); digitar = 0;}
        if (digitar == 0)
        {
            menuConsultar();
        }
        if (digitar == 1)
        {
            consultarListaCursos();
        }
        if (digitar == 2)
        {
            consultarListaProfessores();
        }
        if (digitar == 3)
        {
            consultarListaAluno();
        }
        if (digitar == 4)
        {
            consultarListaMatriculas();
        }
        if(digitar == 5)
        {
            consultarAlunoMatriculado();
        }
        if (digitar == 6)
        {
            Menu();
        }
        if (digitar == 7)
        {
            System.out.println("Saindo do Programa...");
            System.exit(0);
        }

    }
    public void voltarMenuConsultarSair()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite as opções abaixo:\n(1) Menu Principal.\n(2) Menu de Consultas\n(3) Sair do programa");
            digitar = sc.nextInt();
            while (digitar<1 || digitar >3){
                System.out.println("Digite uma opção válida!");
                digitar = sc.nextInt();
            }
        }catch (Exception e){
            System.out.println("==============================\nErro!! Voltando ao menu!!\n=============================="); digitar = 1; }

        if(digitar == 1)
        {
            Menu();
        }
        if(digitar == 2 )
        {
            menuConsultar();
        }
        if (digitar == 3 )
        {
            System.out.println("Saindo do programa...");
            System.exit(0);
        }

    }
    public void consultarAlunoMatriculado()
    {
        int codigo, nA = 0;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("Código do Aluno(a):");
            codigo = sc.nextInt();} catch (InputMismatchException e)
        {
            System.out.println("==============================\nErro Fatal !!!\n==============================\n" + e.getCause());
            codigo = 0; consultarAlunoMatriculado();}

            for (int i = 0; i<listaDeMatriculas.size(); i++)
        {
            if (listaDeMatriculas.get(i).getAluno().getCodigoDoAluno() == codigo)
            {
                nA = nA + 1;
            }
            if(nA > 0)
            {
                if(listaDeMatriculas.get(i).getAluno().getCodigoDoAluno() == codigo)
                {
                    System.out.println("==============================\nMatrícula\n==============================\nNome:" + listaDeMatriculas.get(i).getAluno().getNome()
                    + "\nCodigo: " + listaDeMatriculas.get(i).getAluno().getCodigoDoAluno() + "\nCurso matriculado:" + listaDeMatriculas.get(i).getCurso().getNome() +
                            "\nData da Matrícula: " + listaDeMatriculas.get(i).getDataDoDia() + "\n===================================\n");
                }
            }else {
                System.out.println("==============================\nAluno(a) não encontrado!\n==============================\n");
            }
        }voltarMenuConsultarSair();
    }
    //
    // **************** MENU E METHOS PARA EXCLUIR *****************
    //

    public void menuExcluir ()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("==============================\nMenu de Exclusão\n==============================\n" +
                "(1) Excluir Curso\n(2) Excluir Professor(a)\n(3) Excluir Aluno(a)\n" +
                "(4) Menu Principal\n(5) Sair do Programa\n==============================\n");
            digitar = sc.nextInt();
            while (digitar < 1 || digitar > 5)
            {
                System.out.println("Opção inválida! Digite novamente!");
                digitar = sc.nextInt();
            }}catch (Exception e){
            System.out.println("\n==============================\nErro Fatal! Voltando ao Menu de Exclusão\n==============================\n"); digitar = 0;}
        if (digitar == 0)
        {
            menuExcluir();
        }
        if (digitar == 1)
        {
            excluirCurso();
        }
        if (digitar == 2)
        {
            excluirProfessor();
        }
        if (digitar == 3)
        {
            excluirAluno();
        }
        if (digitar == 4)
        {
            Menu();
        }
        if (digitar == 5)
        {
            System.out.println("Saindo do Programa...");
            System.exit(0);
        }
    }

    public void excluirAluno() {
        int codigo;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Digite código do aluno:");
            codigo = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Código Inválido! Digite Novamente");
            codigo = sc.nextInt();
        }

        for (int i = 0; i < listaDeAlunos.size(); i++) {
            if (listaDeAlunos.get(i).getCodigoDoAluno() == codigo) {
                listaDeAlunos.remove(i);
                System.out.println("==============================\nAluno(a) exlcuído!\n==============================\n");
            }
        }

        voltarMenuExcluirSair();
    }
    public void excluirCurso() {
        int codigo;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("Digite código do curso");
            codigo = sc.nextInt();} catch(Exception e)
        {
            System.out.println("Código Inválido! Digite Novamente");
            codigo = sc.nextInt();
        }

        for (int i = 0; i < listaDeCursos.size(); i++) {
            if (listaDeCursos.get(i).getCodigoDoCurso() == codigo) {
                listaDeCursos.remove(i);
                System.out.println("==============================\nCurso Excluído\n==============================\n");
            }
        }

        voltarMenuExcluirSair();
    }
    public void excluirProfessor() {
        int codigo;
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite o código: ");
            codigo = sc.nextInt();}catch (Exception e)
        {
            System.out.println("Código Inválido! Digite novamente");
            codigo = sc.nextInt();
        }

        for (int i = 0; i < listaDeProfessores.size(); i++) {
            if (codigo == listaDeProfessores.get(i).getCodigoDoProf()) {
                listaDeProfessores.remove(i);
                System.out.println("==============================\nProfessor(a) Excluído!\n==============================\n");
            }
        }

        voltarMenuExcluirSair();
    }
    public void voltarMenuExcluirSair ()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite as opções abaixo:\n(1) Menu Principal.\n(2) Menu de Excluir\n(3) Sair do programa");
            digitar = sc.nextInt();
            while (digitar<1 || digitar >3){
                System.out.println("Digite uma opção válida!");
                digitar = sc.nextInt();
            }
        }catch (Exception e){
            System.out.println("==============================\nErro!! Voltando ao menu!!\n=============================="); digitar = 1; }

        if(digitar == 1)
        {
            Menu();
        }
        if(digitar == 2 )
        {
            menuExcluir();
        }
        if (digitar == 3 )
        {
            System.out.println("Saindo do programa...");
            System.exit(0);
        }
    }

    //
    // ****************** MENU E MÉTODOS EDITAR *********************
    //

    public void menuEditar()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("==============================\nMenu de Edição\n==============================\n" +
                "(1) Editar parâmetros do Curso\n(2) Editar parâmetros do Professor(a)\n(3) Editar parâmetros do Aluno(a)\n" +
                "(4) Editar parâmetos da matrícula\n(5) Menu Principal\n(6) Sair do Programa\n==============================\n");
            digitar = sc.nextInt();
            while (digitar < 1 || digitar > 6)
            {
                System.out.println("Opção inválida! Digite novamente!");
                digitar = sc.nextInt();
            }}catch (Exception e){
            System.out.println("\n==============================\nErro Fatal! Voltando ao Menu de Exclusão\n==============================\n"); digitar = 0;}
        if (digitar == 0)
        {
            menuEditar();
        }
        if (digitar == 1)
        {
            editarCurso();
        }
        if (digitar == 2)
        {
            editarProfessor();
        }
        if (digitar == 3)
        {
            editarAluno();
        }
        if (digitar == 4)
        {
            editarMatricula();
        }
        if (digitar == 5)
        {
            Menu();
        }
        if (digitar == 6)
        {
            System.out.println("Saindo do Programa...");
            System.exit(0);
        }
    }

    public void editarCurso()
    {
        Scanner sc = new Scanner(System.in);
        int codigo , digitar , nC = 0;

        try{System.out.println("============================\nDigitar Código: ");
        codigo = sc.nextInt();}catch (Exception e){
            codigo = 0; editarCurso();
        }

        for (int i = 0 ; i < listaDeCursos.size() ; i++)
        {
            if(listaDeCursos.get(i).getCodigoDoCurso() == codigo)
            {
                nC = nC + 1;
            }

            if(nC > 0)
            {
                System.out.println("==============================\nEditar Parâmetros\n==============================\n" +
                        "(1) Editar Nome\n(2) Editar Vagas\n(3) Voltar ao Menu\n(4) Sair do Programa\n==============================\n");

                try{digitar = sc.nextInt();
                while (digitar <1 || digitar>3)
                {
                    System.out.println("==============================\nDigite um opação válida!\n==============================\n");
                    digitar = sc.nextInt();
                }}catch (Exception e)
                {
                    System.out.println("==============================\nErro Fatal!!!\n==============================\n");
                    digitar = 0;
                }

                if (digitar == 0)
                {
                    editarCurso();
                }
                if (digitar == 1)
                {

                    for (int x = 0; x < listaDeCursos.size() ; x++)
                    {
                        if (listaDeCursos.get(x).getCodigoDoCurso() == codigo)
                        {
                            String novoNome, nomeAntigo;
                            System.out.println("Novo nome: ");
                            novoNome = sc.next();
                            nomeAntigo = listaDeCursos.get(x).getNome();
                            listaDeCursos.get(x).setNome(novoNome);
                            System.out.println("\n==============================\nNome alterado de " + nomeAntigo +
                                    " para " + novoNome + "\n==============================");
                        }
                    }
                    voltarMenuEditarSair();
                }
                if (digitar == 2)
                {

                    for (int x = 0; x < listaDeCursos.size() ; x++)
                    {
                        if (listaDeCursos.get(x).getCodigoDoCurso() == codigo)
                        {
                            int novaVagas, vagasAntiga;
                            System.out.println("Nova Quantidade de Vagas: ");
                            novaVagas = sc.nextInt();
                            vagasAntiga = listaDeCursos.get(x).getVagas();
                            listaDeCursos.get(x).setVagas(novaVagas);
                            System.out.println("\n==============================\nQuantidade alterada de " + vagasAntiga +
                                    " para " + novaVagas + "\n==============================");
                        }
                    }
                }
                if (digitar == 3)
                {
                    menuEditar();
                }
                if (digitar == 4)
                {
                    System.exit(0);
                }

            }else {
                System.out.println("==============================\nCurso não encontrado!\n==============================\n");}

        }

        voltarMenuEditarSair();
    }

    //
    // ********************** MÉTODOS EDITAR PARÂMETROS PROFESSOR ************************
    //

    public void editarProfessor()
    {
        Scanner sc = new Scanner(System.in);
        int codigo , digitar , nC = 0;

        try{System.out.println("============================\nDigitar Código: ");
            codigo = sc.nextInt();}catch (Exception e){
            codigo = 0; editarProfessor();
        }

        for (int i = 0 ; i < listaDeProfessores.size() ; i++)
        {
            if(listaDeProfessores.get(i).getCodigoDoProf() == codigo)
            {
                nC = nC + 1;
            }

            if(nC > 0)
            {
                System.out.println("==============================\nEditar Parâmetros\n==============================\n");
                System.out.println("==============================r" +
                        "\n(1) Editar Nome\n(2) Editar Sobrenome\n(3) Voltar ao Menu\n(4) Sair do Programa\n==============================\n");

                try{digitar = sc.nextInt();
                    while (digitar <1 || digitar>3)
                    {
                        System.out.println("==============================\nDigite um opação válida!\n==============================\n");
                        digitar = sc.nextInt();
                    }}catch (Exception e)
                {
                    System.out.println("==============================\nErro Fatal!!!\n==============================\n");
                    digitar = 0;
                }

                if (digitar == 0)
                {
                    editarProfessor();
                }
                if (digitar == 1)
                {

                    for (int x = 0; x < listaDeProfessores.size() ; x++)
                    {
                        if (listaDeProfessores.get(x).getCodigoDoProf() == codigo)
                        {
                            String novoNome, nomeAntigo;
                            System.out.println("Novo nome: ");
                            novoNome = sc.next();
                            nomeAntigo = listaDeProfessores.get(x).getNome();
                            listaDeProfessores.get(x).setNome(novoNome);
                            System.out.println("\n==============================\nNome alterado de " + nomeAntigo +
                                    " para " + novoNome + "\n==============================");
                        }
                    }
                    voltarMenuEditarSair();
                }
                if (digitar == 2)
                {
                    for (int x = 0; x < listaDeProfessores.size() ; x++)
                    {
                        if (listaDeProfessores.get(x).getCodigoDoProf() == codigo)
                        {
                            String novoSobrenome, sobrenomeAntigo;
                            System.out.println("Novo Sobrenome: ");
                            novoSobrenome = sc.next();
                            sobrenomeAntigo = listaDeProfessores.get(x).getSobrenome();
                            listaDeProfessores.get(x).setSobrenome(novoSobrenome);
                            System.out.println("\n==============================\nSobrenome alterado de " + sobrenomeAntigo +
                                    " para " + novoSobrenome + "\n==============================");
                        }
                    }
                    voltarMenuEditarSair();

                }
                if (digitar == 3)
                {
                    menuEditar();
                }
                if (digitar == 4)
                {
                    System.exit(0);
                }

            }else {
                System.out.println("==============================\nProfessor(a) não encontrado(a)!\n==============================\n");}
        }
        voltarMenuEditarSair();

    }

    public void editarAluno()
    {
        Scanner sc = new Scanner(System.in);
        int codigo , digitar , nC = 0;

        try{System.out.println("============================\nDigitar Código: ");
            codigo = sc.nextInt();}catch (Exception e){
            codigo = 0; editarProfessor();
        }

        for (int i = 0 ; i < listaDeAlunos.size() ; i++)
        {
            if(listaDeAlunos.get(i).getCodigoDoAluno() == codigo)
            {
                nC = nC + 1;
            }

            if(nC > 0)
            {
                System.out.println("==============================\nEditar Parâmetros\n==============================\n");
                System.out.println("==============================r" +
                        "\n(1) Editar Nome\n(2) Editar Sobrenome\n(3) Voltar ao Menu\n(4) Sair do Programa\n==============================\n");

                try{digitar = sc.nextInt();
                    while (digitar <1 || digitar>4)
                    {
                        System.out.println("==============================\nDigite um opação válida!\n==============================\n");
                        digitar = sc.nextInt();
                    }}catch (Exception e)
                {
                    System.out.println("==============================\nErro Fatal!!!\n==============================\n");
                    digitar = 0;
                }

                if (digitar == 0)
                {
                    editarProfessor();
                }
                if (digitar == 1)
                {

                    for (int x = 0; x < listaDeAlunos.size() ; x++)
                    {
                        if (listaDeAlunos.get(x).getCodigoDoAluno() == codigo)
                        {
                            String novoNome, nomeAntigo;
                            System.out.println("Novo nome: ");
                            novoNome = sc.next();
                            nomeAntigo = listaDeAlunos.get(x).getNome();
                            listaDeAlunos.get(x).setNome(novoNome);
                            System.out.println("\n==============================\nNome alterado de " + nomeAntigo +
                                    " para " + novoNome + "\n==============================");
                        }
                    }
                    voltarMenuEditarSair();
                }
                if (digitar == 2)
                {
                    for (int x = 0; x < listaDeAlunos.size() ; x++)
                    {
                        if (listaDeAlunos.get(x).getCodigoDoAluno() == codigo)
                        {
                            String novoSobrenome, sobrenomeAntigo;
                            System.out.println("Novo Sobrenome: ");
                            novoSobrenome = sc.next();
                            sobrenomeAntigo = listaDeAlunos.get(x).getSobrenome();
                            listaDeAlunos.get(x).setSobrenome(novoSobrenome);
                            System.out.println("\n==============================\nSobrenome alterado de " + sobrenomeAntigo +
                                    " para " + novoSobrenome + "\n==============================");
                        }
                    }
                    voltarMenuEditarSair();

                }
            if (digitar == 3)
            {
                menuEditar();
            }
                if (digitar == 4)
                {
                    System.exit(0);
                }

            }else {
                System.out.println("==============================\nAluno(a) não encontrado(a)!\n==============================\n");}
        }
        voltarMenuEditarSair();

    }
    public void editarMatricula() {
        Scanner sc = new Scanner(System.in);
        int codigo, digitar, nC = 0, codigoCurso, nCurso = 0;
        String cursoAntigo = "";
        Curso novoCurso = new Curso();

        try {
            System.out.println("============================\nDigitar Código do Aluno(a): ");
            codigo = sc.nextInt();
        } catch (Exception e) {
            codigo = 0;
            editarCurso();
        }

        for (int i = 0; i < listaDeMatriculas.size(); i++) {
            if (listaDeMatriculas.get(i).getAluno().getCodigoDoAluno() == codigo) {
                nC = nC + 1;
            }

            if (nC > 0) {
                System.out.println("==============================\nEditar Parâmetros\n==============================\n");
                System.out.println("==============================" +
                        "\n(1) Editar Curso de Matrícula\n(2) Voltar ao Menu\n(3) Sair do Programa\n==============================\n");

                try {
                    digitar = sc.nextInt();
                    while (digitar < 1 || digitar > 3) {
                        System.out.println("==============================\nDigite um opação válida!\n==============================\n");
                        digitar = sc.nextInt();
                    }
                } catch (Exception e) {
                    System.out.println("==============================\nErro Fatal!!!\n==============================\n");
                    digitar = 0;
                }

                if (digitar == 0) {
                    editarMatricula();
                }
                if (digitar == 1) {

                    for (int x = 0; x < listaDeMatriculas.size(); x++) {
                        if (listaDeMatriculas.get(x).getAluno().getCodigoDoAluno() == codigo) {


                            System.out.println("Novo curso: ");
                            codigoCurso = sc.nextInt();

                            for (int z = 0; z < listaDeCursos.size(); z++) {
                                if (listaDeCursos.get(z).getCodigoDoCurso() == codigoCurso) {

                                    nCurso = nCurso + 1;
                                }
                                if (nCurso > 0) {
                                    for (int y = 0; y < listaDeCursos.size(); y++) {
                                        if (listaDeCursos.get(y).getCodigoDoCurso() == codigoCurso)
                                        novoCurso = listaDeCursos.get(y);
                                    }
                                } else {
                                    System.out.println("==============================\nCurso não encontrado!\n==============================\n");
                                }
                            }

                            cursoAntigo = listaDeMatriculas.get(x).getCurso().getNome();
                            listaDeMatriculas.get(x).setCurso(novoCurso);

                        }

                    }System.out.println("\n==============================\nNome alterado de " + cursoAntigo +
                            " para " + novoCurso.getNome() + "\n==============================");


                }
                if (digitar == 2)
                {
                    menuEditar();
                }
                if (digitar == 3)
                {
                    System.exit(0);
                }
            }
            else {
                System.out.println("==============================\nMatrícula não encontrada!\n==============================\n");

            }
            voltarMenuEditarSair();
        }
    }
    public void voltarMenuEditarSair ()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite as opções abaixo:\n(1) Menu Principal.\n(2) Menu de Edição\n(3) Sair do programa");
            digitar = sc.nextInt();
            while (digitar<1 || digitar >3){
                System.out.println("Digite uma opção válida!");
                digitar = sc.nextInt();
            }
        }catch (Exception e){
            System.out.println("==============================\nErro!! Voltando ao menu!!\n=============================="); digitar = 1; }

        if(digitar == 1)
        {
            Menu();
        }
        if(digitar == 2 )
        {
            menuEditar();
        }
        if (digitar == 3 )
        {
            System.out.println("Saindo do programa...");
            System.exit(0);
        }
    }

}