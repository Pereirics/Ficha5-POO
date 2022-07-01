package Main;

import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {

    // Variáveis de instância
    private String nomeTurma;
    private String codUC;
    private Map<String, Aluno> turmaAlunos;

    // Construtor por omissão
    public TurmaAlunos() {
        this.nomeTurma = "";
        this.codUC = "";
        this.turmaAlunos = new HashMap<>();
    }

    // Construtor parametrizado
    public TurmaAlunos(String nomeTurma, String codUC, Map<String, Aluno> turmaAlunos) {
        this.nomeTurma = nomeTurma;
        this.codUC = codUC;
        this.turmaAlunos = turmaAlunos;
    }

    // Construtor cópia
    public TurmaAlunos(TurmaAlunos turmaAlunos) {
        this.nomeTurma = turmaAlunos.getNomeTurma();
        this.codUC = turmaAlunos.getCodUC();
        this.turmaAlunos = turmaAlunos.getTurmaAlunos();
    }

    // Métodos de instância
    public String getNomeTurma() {
        return this.nomeTurma;
    }

    public String getCodUC() {
        return this.codUC;
    }

    public Map<String, Aluno> getTurmaAlunos() {
        return this.turmaAlunos;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public void setCodUC(String codUC) {
        this.codUC = codUC;
    }

    public void setTurmaAlunos(Map<String, Aluno> turmaAlunos) {
        this.turmaAlunos = turmaAlunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        TurmaAlunos that = (TurmaAlunos) o;
        return Objects.equals(getNomeTurma(), that.getNomeTurma()) && Objects.equals(getCodUC(), that.getCodUC()) && Objects.equals(getTurmaAlunos(), that.getTurmaAlunos());
    }

    public void insereAluno(Aluno a) {
        this.turmaAlunos.put(a.getNumero(), a);
    }

    public Aluno getAluno(String codAluno) {
        if (this.turmaAlunos.containsKey(codAluno)) {
            for (Aluno aluno : this.turmaAlunos.values()) {
                if (aluno.getNumero().equals(codAluno)) return aluno;
            }
        }
        return new Aluno();
    }

    public void removeAluno(String codAluno) {
        this.turmaAlunos.remove(codAluno);
    }

    public Set<String> todosOsCodigos() {
        Set<String> res = new HashSet<>();
        for (String aluno: this.turmaAlunos.keySet()) {
            res.add(aluno);
        }
        return res;
    }

    public int qtsAlunos() {
        return this.turmaAlunos.values().size();
    }

    //public Collection<Aluno> alunosOrdemAlfabetica() {
        //return this.turmaAlunos.values().stream().collect()
    //}

    //public Set<Aluno> alunosOrdemDecrescenteNumero() {
      //  this.turmaAlunos.
    //}
































}
