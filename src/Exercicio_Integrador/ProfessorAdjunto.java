package Exercicio_Integrador;

public class ProfessorAdjunto extends Professor{

    private Integer horasDeMonitoria;

    public ProfessorAdjunto() {
    }

    public ProfessorAdjunto(Integer horasDeMonitoria) {
        this.horasDeMonitoria = horasDeMonitoria;
    }

    public ProfessorAdjunto(String nome, String sobrenome, Integer tempoDeCasa, Integer codigoDoProf, Integer horasDeMonitoria) {
        super(nome, sobrenome, tempoDeCasa, codigoDoProf);
        this.horasDeMonitoria = horasDeMonitoria;
    }

    public Integer getHorasDeMonitoria() {
        return horasDeMonitoria;
    }

    public void setHorasDeMonitoria(Integer horasDeMonitoria) {
        this.horasDeMonitoria = horasDeMonitoria;
    }
}
