package modelo;

public class Financiamento {

    private float valorFinanciado;
    private float taxaJuros;
    private float custoMensal;
    private float prazoTotal;

    public Financiamento() {
    }
    
    public Financiamento(float valorFinanciado, float taxaJuros, float custoMensal, float prazoTotal) {
        this.valorFinanciado = valorFinanciado;
        this.taxaJuros = taxaJuros;
        this.custoMensal = custoMensal;
        this.prazoTotal = prazoTotal;
    }

    public float getValorFinanciado() {
        return valorFinanciado;
    }

    public void setValorFinanciado(float valorFinanciado) {
        this.valorFinanciado = valorFinanciado;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public float getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(float custoMensal) {
        this.custoMensal = custoMensal;
    }

    public float getPrazoTotal() {
        return prazoTotal;
    }

    public void setPrazoTotal(float prazoTotal) {
        this.prazoTotal = prazoTotal;
    }
}
