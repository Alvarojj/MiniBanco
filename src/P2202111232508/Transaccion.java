
package P2202111232508;


public class Transaccion {
  //Atributos
    private int ecuenta;
    private char ctran;
    private float rvalor;
  //Metodos  

    public Transaccion(int ecuenta, char ctran, float rvalor) {
        this.ecuenta = ecuenta;
        this.ctran = ctran;
        this.rvalor = rvalor;
    }
    public String Mostrar(){
    String salida;
    salida ="Numero de cuenta: "+ ecuenta+"\nTipo de transacción: "+ ctran+"\nValor de la transacción: "+ rvalor;
    return salida;
    }
}
