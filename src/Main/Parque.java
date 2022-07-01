package Main;

import java.security.AlgorithmConstraints;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Parque {

    // Variáveis de instância
    private String nomeParque;
    private Map<String, Lugar> lugares;

    // Construtor por omissão
    public Parque() {
        this.lugares = new HashMap<>();
    }

    // Construtor parametrizado
    public Parque(String nomeParque, Map<String, Lugar> lugaresMap) {
        this.nomeParque = nomeParque;
        this.lugares = lugaresMap;
    }

    // Construtor cópia
    public Parque(Parque p) {
        this.nomeParque = p.getNomeParque();
        this.lugares = p.getLugares();
    }

    // Métodos de instância
    public String getNomeParque() {
        return this.nomeParque;
    }

    public Map<String, Lugar> getLugares() {
        return this.lugares;
    }

    public void setNomeParque(String nomeParque) {
        this.nomeParque = nomeParque;
    }

    public void setLugares(Map<String, Lugar> lugares) {
        this.lugares = lugares;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        Parque parque = (Parque) o;
        return Objects.equals(this.getNomeParque(), parque.getNomeParque()) &&
               Objects.equals(this.getLugares(), parque.getLugares());
    }

    public String toString() {
        return "Parque{" +
                "nomeParque='" + nomeParque + '\'' +
                ", lugares=" + lugares +
                '}';
    }

    public Parque clone() {
        return new Parque(this);
    }

    public List<String> getMatriculas() {
        List<String> matriculas = new ArrayList<>();
        for (Lugar lugar: this.lugares.values()) {
            matriculas.add(lugar.getMatricula());
        }
        return matriculas;
    }

    public void addLugar(String nome, Lugar lugar) {
        this.lugares.put(nome, lugar);
    }

    public void removeLugar(String matricula) {
        for (Map.Entry<String, Lugar> lugar: this.lugares.entrySet()) {
            if (lugar.getValue().getMatricula().equals(matricula)) this.lugares.remove(lugar.getKey());
        }
    }

    public void alteraTempo(String matricula, int minutos) {
        for (Lugar lugar: this.lugares.values()) {
            if (lugar.getMatricula().equals(matricula)) lugar.setMinutos(minutos);
        }
    }

    public int totalMinutosE() {
        int total = 0;
        for (Lugar lugar: this.lugares.values()) {
            total += lugar.getMinutos();
        }
        return total;
    }

    public int totalMinutosI() {
        return this.lugares.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

    public boolean existeMatricula(String matricula) {
        return this.lugares.containsKey(matricula);
    }

    public List<String> matriculasTempoPermanenteE(int tempo) {
        List<String> matriculas = new ArrayList<>();
        for (Lugar lugar: this.lugares.values()) {
            if (lugar.getPermanente() && lugar.getMinutos() > tempo) matriculas.add(lugar.getMatricula());
        }
        return matriculas;
    }

    //public List<String> matriculasTempoPermanenteI(int tempo) {   NÃO SEI FAZER COM ITERADOR INTERNO
       // return this.lugares.values().stream().filter(lugar -> lugar.getPermanente() && lugar.getMinutos() > tempo).collect(Collectors.toMap(Lugar::getMatricula, Lugar::getMatricula)).toList();
    //}

    public Map<String, Lugar> copiaLugares() {
        Map<String, Lugar> novo = new HashMap<>();
        for (Map.Entry<String, Lugar> l: this.lugares.entrySet()) {
            String n = l.getKey();
            Lugar l1 = l.getValue();
            novo.put(n, l1.clone());
        }
        return novo;
    }

    public String infLugar(String matricula) {
        for (Lugar lugar: this.lugares.values()) {
            if (lugar.getMatricula().equals(matricula)) return lugar.toString();
        }
        return "";
    }

}
