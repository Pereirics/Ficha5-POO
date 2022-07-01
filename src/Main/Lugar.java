package Main;

import java.util.Objects;

public class Lugar {

    // Variáveis de instância
    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente;

    // Construtor por omissão
    public Lugar() {
        this.matricula = "";
        this.nome = "";
        this.minutos = 0;
        this.permanente = false;
    }

    // Construtor parametrizado
    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    // Construtor cópia
    public Lugar(Lugar l) {
        this.matricula = l.getMatricula();
        this.nome = l.getNome();
        this.minutos = l.getMinutos();
        this.permanente = l.getPermanente();
    }

    // Métodos de instância
    public String getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public boolean getPermanente() {
        return this.permanente;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        Lugar lugar = (Lugar) o;
        return Objects.equals(this.matricula, lugar.getMatricula()) &&
               Objects.equals(this.nome, lugar.getNome()) &&
               this.minutos == lugar.getMinutos() &&
               this.permanente == lugar.getPermanente();
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", minutos=" + minutos +
                ", permanente=" + permanente +
                '}';
    }

    public Lugar clone() {
        return new Lugar(this);
    }
}
