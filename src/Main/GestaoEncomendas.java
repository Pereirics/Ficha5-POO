package Main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {

    // Variáveis de instância
    private Map<Integer, Encomenda> encomendas;

    // Construtor por omissão
    public GestaoEncomendas() {
        this.encomendas = new HashMap<>();
    }

    // Construtor parametrizado
    public GestaoEncomendas(Map<Integer, Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    // Construtor cópia
    public GestaoEncomendas(GestaoEncomendas a) {
        this.encomendas = a.getEncomendas();
    }

    public Map<Integer, Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Map<Integer, Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<Integer> todosCodigosEnc() {
        Set<Integer> res = new HashSet<>();
        for (Encomenda linhaEcomenda: this.encomendas.values()) {
            res.add(linhaEcomenda.getNumeroEncomenda());
        }
        return res;
    }

    public void addEncomenda(Encomenda enc) {
        this.encomendas.put(enc.getNumeroEncomenda(), enc);
    }

    public Encomenda getEncomenda(Integer codEnc) {
        if (this.encomendas.containsKey(codEnc)) {
            for (Encomenda encomenda: this.encomendas.values()) {
                if (encomenda.getNumeroEncomenda() == codEnc) return encomenda;
            }
        }
        return new Encomenda();
    }

    public void removeEncomenda(Integer codEnc) {
        this.encomendas.remove(codEnc);
    }

    public Integer encomendaComMaisProdutos() {
        int maior = 0;
        Encomenda maiorEncomenda = new Encomenda();
        for (Encomenda encomenda: this.encomendas.values()) {
            if (encomenda.getLinhasEncomenda().size() > maior) {
                maior = encomenda.getLinhasEncomenda().size();
                maiorEncomenda = encomenda;
            }
        }
        return maiorEncomenda.getNumeroEncomenda();
    }

    public Set<Integer> encomendasComProduto(String codProd) {
        Set<Integer> res = new HashSet<>();
        for (Encomenda encomenda: this.encomendas.values()) {
            for (LinhaEncomenda linhaEncomenda: encomenda.getLinhasEncomenda()) {
                if (linhaEncomenda.getReferencia().equals(codProd)) {
                    res.add(encomenda.getNumeroEncomenda());
                    break;
                }
            }
        }
        return res;
    }

    public Set<Integer> encomendasAposData(LocalDateTime d) {
        Set<Integer> res = new HashSet<>();
        for (Encomenda encomenda: this.encomendas.values()) {
            if (encomenda.getDataEncomenda().isAfter(d)) {
                res.add(encomenda.getNumeroEncomenda());
                break;
            }
        }
        return res;
    }

    public Set<Encomenda> encomendasValorDecrescente() {
        Comparator<Encomenda> c = (a1, a2) -> Double.compare(a1.calculaValorTotal(), a2.calculaValorTotal());
        Set<Encomenda> set = new HashSet<>(this.encomendas.values());
        return set.stream().sorted(c).collect(Collectors.toSet());
    }

    public Map<String, List<Integer>> encomendasDeProduto() {
        Map<String, List<Integer>> map = new HashMap<>();
        for (Encomenda encomenda: this.encomendas.values()) {
            for (LinhaEncomenda linhaEncomenda: encomenda.getLinhasEncomenda()) {
                List<Integer> nova;
                if (map.containsKey(linhaEncomenda.getReferencia())) {
                    nova = map.get(linhaEncomenda.getReferencia());
                }
                else {
                    nova = new ArrayList<>();
                }
                nova.add(encomenda.getNumeroEncomenda());
                map.put(linhaEncomenda.getReferencia(), nova);
            }
        }
        return map;
    }
}
