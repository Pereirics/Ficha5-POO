package Main;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GestaoEncomendasTest {

    @Test
    void encomendasDeProduto() {
        LinhaEncomenda linha1 = new LinhaEncomenda("123", "Comando", 0, 0, 0, 0);
        LinhaEncomenda linha2 = new LinhaEncomenda("456", "Fones", 0, 0, 0, 0);
        LinhaEncomenda linha3 = new LinhaEncomenda("789", "Monitor", 0, 0, 0, 0);
        ArrayList<LinhaEncomenda> lista = new ArrayList<>();
        lista.add(linha1);
        Encomenda encomenda1 = new Encomenda("Joao", 123, "", 123, LocalDateTime.now(), lista);
        ArrayList<LinhaEncomenda> lista1 = new ArrayList<>();
        lista1.add(linha1);
        lista1.add(linha2);
        lista1.add(linha3);
        Encomenda encomenda2 = new Encomenda("Carina", 456, "", 456, LocalDateTime.now(), lista1);

        GestaoEncomendas gestaoEncomendas = new GestaoEncomendas();
        Map<Integer, Encomenda> map = new HashMap<>();
        map.put(1, encomenda1);
        map.put(2, encomenda2);
        gestaoEncomendas.setEncomendas(map);

        Map<String, List<Integer>> res = gestaoEncomendas.encomendasDeProduto();
        System.out.println(res);


    }

    @Test
    void encomendasValorDecrescente() {
        LinhaEncomenda linha1 = new LinhaEncomenda("123", "Comando", 10, 1, 0, 0);
        LinhaEncomenda linha2 = new LinhaEncomenda("456", "Fones", 20, 1, 0, 0);
        LinhaEncomenda linha3 = new LinhaEncomenda("789", "Monitor", 30, 1, 0, 0);
        ArrayList<LinhaEncomenda> lista = new ArrayList<>();
        lista.add(linha1);
        lista.add(linha2);
        lista.add(linha3);
        Encomenda encomenda1 = new Encomenda("Joao", 123, "", 123, LocalDateTime.now(), lista);
        ArrayList<LinhaEncomenda> lista1 = new ArrayList<>();
        lista1.add(linha1);

        Encomenda encomenda2 = new Encomenda("Carina", 456, "", 456, LocalDateTime.now(), lista1);

        GestaoEncomendas gestaoEncomendas = new GestaoEncomendas();
        Map<Integer, Encomenda> map = new HashMap<>();
        map.put(1, encomenda1);
        map.put(2, encomenda2);
        gestaoEncomendas.setEncomendas(map);

        System.out.println(gestaoEncomendas.encomendasValorDecrescente());

    }
}