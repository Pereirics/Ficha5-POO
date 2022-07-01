package Main;

import java.util.Objects;

public class Aluno {

    double nota;
    String numero;

    public Aluno(Aluno a) {
        numero = a.numero;
        nota = a.nota;
    }

    public Aluno() {
        this.numero = "";
        this.nota = 0;
    }

    public Aluno(String numero, double nota) {
        this.numero = numero;
        this.nota = nota;
    }

    public Aluno clone() {
        return new Aluno(this);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nota=" + nota +
                ", numero='" + numero + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Aluno aluno = (Aluno) o;
        return Double.compare(aluno.getNota(), getNota()) == 0 && Objects.equals(getNumero(), aluno.getNumero());
    }
}
