package Exercicio_Integrador;

import br.com.digitalhouse.DigitalException;
import br.com.digitalhouse.Estudioso;
import jdk.swing.interop.SwingInterOpUtils;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.Instant;
import java.util.*;

public class DigitalManager{

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

        try{System.out.println("===============================\nBem vindo a Digital House!\n===============================" +
                "\nEscolha as opções abaixo:\n\n(1) Registrar\n(2) Consultar\n(3) Excluir \n(4) Sair do programa");
            digitarN = sc.nextInt();
            while (digitarN<1 || digitarN>4)
            {
                System.out.println("======================\nErro!!\n======================\nDigite uma opção válida!\n" +
                        "\n(1) Registrar\n(2) Consultar\n(3) Excluir \n(4) Sair do programa\n");
                digitarN = sc.nextInt();
            }}catch (Exception e){System.out.println("===============================\nErro!! Digite uma opção válida!\n===============================");digitarN = 0;}

        if (digitarN == 0)
        {
            Menu();
        }
        if (digitarN == 1) {
            menuRegistro();
        }
        if (digitarN == 2) {

            menuConsultar();
        }
        if (digitarN == 3)
        {
            menuExcluir();
        }
        if (digitarN == 4) {
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
        try{System.out.println("Digitar quantidade de vagas do curso: ");
        digitarC = sc.nextInt();}catch (InputMismatchException e){
            System.out.println("Erro! Digite Novamente");
            registrarCurso(); digitarC = sc.nextInt();
        }
        curso.setNome(digitarN);
        curso.setVagas(digitarC);
        curso.setCodigoDoCurso(gerarCodigoCurso());
        System.out.println("Código Gerado: " + curso.getCodigoDoCurso());
        listaDeCursos.add(curso);
        voltarMenuRegistrarSair();
    }


    public void registrarAluno() {
        Aluno aluno = new Aluno();
        String digitarNome, digitarS;
        Scanner sc = new Scanner(System.in);
        //Estudioso es
        //DigitalException.matriculaDH(estudioso);

        System.out.println("=====================\nRegistrar Aluno\n=====================");
        System.out.println("Digitar nome: ");
        digitarNome = sc.next();
        System.out.println("Digitar sobrenome: ");
        digitarS = sc.next();
        aluno.estudioso();
        aluno.setNome(digitarNome);
        aluno.setSobrenome(digitarS);
        aluno.setCodigoDoAluno(gerarCodigoAluno());
        System.out.println("Código gerado: " + aluno.getCodigoDoAluno());
        listaDeAlunos.add(aluno);
        voltarMenuRegistrarSair();
    }

    public void matricularAluno() {
        int codigoDoAluno, codigoDoCurso;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("Código do Curso:");
        codigoDoCurso = sc.nextInt();} catch (Exception e)
        {
            System.out.println("Código inválido! Digite novamente");
            codigoDoCurso = sc.nextInt(); matricularAluno();
        }

        for (int i = 0; i < listaDeCursos.size(); i++) {
            if (listaDeCursos.get(i).getCodigoDoCurso() == codigoDoCurso) {
                try{System.out.println("Código do Aluno: ");
                codigoDoAluno = sc.nextInt();}catch (Exception e)
                {
                    System.out.println("Código Inválido! Digite Novamente");
                    codigoDoAluno = sc.nextInt(); matricularAluno();
                }

                for (int x = 0; x < listaDeCursos.get(i).getVagas(); x++) {

                    if(listaDeCursos.get(i).listadeAlunos.size() >= listaDeCursos.get(i).getVagas()) {
                        System.out.println("Não foi possível realizar a matrícula pois não há mais vagas para este curso.");break;}
                    if (listaDeAlunos.get(x).getCodigoDoAluno() == codigoDoAluno && listaDeCursos.get(i).getVagas() > listaDeCursos.get(i).
                            listadeAlunos.size()) {

                        Date data = new Date();
                        data.setTime(data.getTime());
                        listaDeCursos.get(i).listadeAlunos.add(listaDeAlunos.get(x));
                        listaDeMatriculas.add(new Matricula(data, listaDeAlunos.get(x), listaDeCursos.get(i)));
                        System.out.println("Aluno matriculado!\nData: " + data);

                    } else if (listaDeAlunos.size() == x && listaDeAlunos.get(x).getCodigoDoAluno() != codigoDoAluno) {
                        System.out.println("Aluno não encontrado.");
                    }
                }
            } else if (listaDeCursos.size() == i && listaDeCursos.get(i).getCodigoDoCurso() != codigoDoCurso)
                {
                System.out.println("Curso não encontrado.");
            }
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

        System.out.println("======================\nRegistrando Professor Adjunto\n======================");
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
        System.out.println("Tempo de casa: " + professor.getTempoDeCasa() + " horas");
        listaDeProfessores.add(professor);
        voltarMenuRegistrarSair();
    }

    public void registrarProfessorTit() {
        ProfessorTitular professor = new ProfessorTitular();
        String digitarNome, digitarS, digitarEsp;
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================\nRegistrar Professor Titular\n=====================");
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
        System.out.println("Código gerado: " + professor.getCodigoDoProf());
        listaDeProfessores.add(professor);
        voltarMenuRegistrarSair();
    }

    public Integer gerarCodigoProfessor() {
        gerarCodigoP = gerarCodigoP + 1;
        return gerarCodigoP;
    }

    public void alocarProfessores () throws InputMismatchException {
        int codigoProfessorT, codigoProfessorA, codigoCurso, n = 0 , n2 = 0;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("Código do Curso:");
        codigoCurso = sc.nextInt();} catch (InputMismatchException e)
        {
            System.out.println("Erro !!!" + e.getCause());
            codigoCurso = 0; alocarProfessores();
        }

        for (int i = 0; i < listaDeCursos.size(); i++) {
            if (listaDeCursos.get(i).getCodigoDoCurso() == codigoCurso) {

                try{System.out.println("Código do Professor Titular: ");
                codigoProfessorT = sc.nextInt();}catch(Exception e)
                {
                    System.out.println("Erro !!!"); alocarProfessores(); codigoProfessorT = 0;
                }

                try{System.out.println("Código do Professor Adjunto: ");
                codigoProfessorA = sc.nextInt(); }catch (Exception e)
                {
                    System.out.println("Erro Fatal! Digite novamente!"); alocarProfessores(); codigoProfessorA = 0;
                }
                for (int z = 0;z<listaDeProfessores.size();z++)
                {
                    if (codigoProfessorT == listaDeProfessores.get(z).getCodigoDoProf())
                    {
                        n = n +1;
                    }
                    if (codigoProfessorA == listaDeProfessores.get(z).getCodigoDoProf())
                    {
                        n2 = n2 + 1;
                    }
                }
                if (n > 0) {

                    for (int x = 0; x < listaDeProfessores.size(); x++) {
                        if (listaDeProfessores.get(x).getCodigoDoProf() == codigoProfessorT) {
                            listaDeCursos.get(i).setProfTit((ProfessorTitular) listaDeProfessores.get(x));
                            System.out.println("Professor Titular Alocado!");
                        }
                    }
                }else {
                    System.out.println("Professor titular não encontrado!");}

                if (n2 > 0){
                    for (int y = 0 ; y < listaDeProfessores.size(); y++){
                    if (listaDeProfessores.get(y).getCodigoDoProf() == codigoProfessorA) {
                        listaDeCursos.get(i).setProfAdj((ProfessorAdjunto) listaDeProfessores.get(y));
                        System.out.println("Professor Ajunto Alocado!");
                        }
                    }
                }else {
                    System.out.println("Professor Adjunto não Encontrado.");}

            }else {
                System.out.println("Curso não encontrado.");
            }
        }
        voltarMenuRegistrarSair();
    }

    public void menuRegistro() {
        Scanner sc = new Scanner(System.in);
        int digitarN;

        try{System.out.println("==============================\nMenu de Registros\n==============================\n(1) Registrar Curso\n(2) Registrar Professor Titular\n(3) Registrar Professor Adjunto" +
                "\n(4) Registrar Aluno\n(5) Alocar Professor\n(6) Matricular Aluno\n(7) Voltar ao Menu\n(9) Sair do Programa");
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
        if (digitarN == 8)
        {

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
            System.out.println("==============================\nAluno\n==============================\n" +
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
                    "\nAluno: " + listaDeMatriculas.get(i).getAluno().getNome() + "\nCurso: " + listaDeMatriculas.get(i).getCurso().getNome() + "\nData: " +
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
                "(5) Menu Principal\n(6) Sair do Programa\n==============================\n");
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
        //
        // **************** MENU E METHOS PARA EXCLUIR *****************
        //
    }
    public void menuExcluir ()
    {
        int digitar;
        Scanner sc = new Scanner(System.in);

        try{System.out.println("==============================\nMenu de Exclusão\n==============================\n" +
                "(1) Excluir Curso\n(2) Excluir Professor\n(3) Excluir Aluno\n" +
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
            }
            System.out.println("Aluno exlcuído!");
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
            }
        }
        System.out.println("Curso Excluído");
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
            }
        }
        System.out.println("Professor Excluído!");
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
}