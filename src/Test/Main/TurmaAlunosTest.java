package Main;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TurmaAlunosTest {

    @Test
    void todosOsCodigos() {
        Aluno aluno1 = new Aluno("aluno1", 15);
        Aluno aluno2 = new Aluno("aluno2", 12);
        Map<String, Aluno> turma = new HashMap<>();
        TurmaAlunos turmaAlunos = new TurmaAlunos("turma", "1", turma);
        turmaAlunos.insereAluno(aluno1);
        turmaAlunos.insereAluno(aluno2);
        Set<String> res = new HashSet<>();
        res.add(aluno1.getNumero());
        res.add(aluno2.getNumero());
        assertEquals(res, turmaAlunos.todosOsCodigos(), "Errado");
    }

    @Test
    void qtsAlunos() {
        Aluno aluno1 = new Aluno("aluno1", 15);
        Aluno aluno2 = new Aluno("aluno2", 12);
        Map<String, Aluno> turma = new HashMap<>();
        TurmaAlunos turmaAlunos = new TurmaAlunos("turma", "1", turma);
        turmaAlunos.insereAluno(aluno1);
        turmaAlunos.insereAluno(aluno2);
        assertEquals(2, turmaAlunos.qtsAlunos(), "Errado");
    }
}