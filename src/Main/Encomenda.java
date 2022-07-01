package Main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Encomenda {

    // Variáveis de instância
    private String nomeCliente;
    private int nifCliente;
    private String moradaCliente;
    private int numeroEncomenda;
    private LocalDateTime dataEncomenda;
    private ArrayList<LinhaEncomenda> linhasEncomenda;

    // Construtor por omissão
    public Encomenda() {
        this.nomeCliente = "";
        this.nifCliente = 0;
        this.moradaCliente = "";
        this.numeroEncomenda = 0;
        this.dataEncomenda = LocalDateTime.now();
        this.linhasEncomenda = new ArrayList<LinhaEncomenda>();
    }

    // Construtor parametrizado
    public Encomenda(String nomeCliente, int nifCliente, String moradaCliente, int numeroEncomenda, LocalDateTime dataEncomenda, ArrayList<LinhaEncomenda> linhasEncomenda) {
        this.nomeCliente = nomeCliente;
        this.nifCliente = nifCliente;
        this.moradaCliente = moradaCliente;
        this.numeroEncomenda = numeroEncomenda;
        this.dataEncomenda = dataEncomenda;
        this.linhasEncomenda = linhasEncomenda;
    }

    // Construtor cópia
    public Encomenda(Encomenda e) {
        this.nomeCliente = e.getNomeCliente();
        this.nifCliente = e.getNifCliente();
        this.moradaCliente = e.getMoradaCliente();
        this.numeroEncomenda = e.getNumeroEncomenda();
        this.dataEncomenda = e.getDataEncomenda();
        this.linhasEncomenda = e.getLinhasEncomenda();
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public int getNifCliente() {
        return this.nifCliente;
    }

    public String getMoradaCliente() {
        return this.moradaCliente;
    }

    public int getNumeroEncomenda() {
        return this.numeroEncomenda;
    }

    public LocalDateTime getDataEncomenda() {
        return this.dataEncomenda;
    }

    public ArrayList<LinhaEncomenda> getLinhasEncomenda() {
        return this.linhasEncomenda;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setNifCliente(int nifCliente) {
        this.nifCliente = nifCliente;
    }

    public void setMoradaCliente(String moradaCliente) {
        this.moradaCliente = moradaCliente;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    public void setDataEncomenda(LocalDateTime dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public void setLinhasEncomenda(ArrayList<LinhaEncomenda> linhasEncomenda) {
        this.linhasEncomenda = linhasEncomenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        Encomenda e = (Encomenda) o;
        return Objects.equals(e.nomeCliente, this.nomeCliente) &&
                Objects.equals(e.moradaCliente, this.moradaCliente) &&
                Objects.equals(e.linhasEncomenda, this.linhasEncomenda) &&
                Objects.equals(e.dataEncomenda, this.dataEncomenda) &&
                (e.nifCliente == this.nifCliente) &&
                (e.numeroEncomenda == this.numeroEncomenda);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "\nNome cliente: " + this.nomeCliente +
                "\nNIF cliente: " + this.nifCliente +
                "\nMorada cliente: " + this.moradaCliente +
                "\nNumero cliente: " + this.numeroEncomenda +
                "\nData encomenda: " + this.dataEncomenda +
                "\nLinhas encomenda: " + this.linhasEncomenda +
                "\n}";
    }

    @Override
    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nomeCliente, this.moradaCliente, this.nifCliente, this.numeroEncomenda, this.dataEncomenda, this.linhasEncomenda);
    }

    public double calculaValorTotal() {
        return this.linhasEncomenda.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    public double calculaValorDesconto() {
        return this.linhasEncomenda.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    public int numeroTotalProdutos() {
        return this.linhasEncomenda.stream().mapToInt(LinhaEncomenda::getQuantidadeEnc).sum();
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        return this.linhasEncomenda.stream().anyMatch(l -> l.getReferencia().equals(refProduto));
    }

    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhasEncomenda.add(linha);
    }

    public void removeProduto(String codProd) {
        Iterator<LinhaEncomenda> i = this.linhasEncomenda.iterator();
        boolean encontrado = false;
        while (i.hasNext() && !encontrado) {
            if (i.next().getReferencia().equals(codProd)) {
                i.remove();
                encontrado = true;
            }
        }
    }
}
