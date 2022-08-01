public abstract class Conta implements InterfaceConta {

    protected static int QNT_CONTAS = 0;
    protected static int AGENCIA = 001;
    protected Cliente cliente;
    protected int agencia;
    protected int numeroConta;
    protected double saldo;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA;
        this.numeroConta = Conta.QNT_CONTAS++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    ////////////////////////////////////// metodos

    public void depositar(double valor) {
        if(valor < 0){
            System.out.println("Valor ilegal");
        }this.saldo += valor;
    }

    public void sacar(double valor) {
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente");
        }this.saldo -= valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente");
        }else{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInformacoes(){
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numeroConta);
        System.out.println("Saldo: " + this.saldo);
    }
}
