
package P2202111232508;


public class Cuenta {
    //Atributos 
    private static String sempresa = "Banco Nacional";
    private final int ecuenta;
    private final String Stitular;
    private float rsaldo = 0;
    
    //Metodos
    public Cuenta(int ecuenta, String Stitular) {
        this.ecuenta = ecuenta;
        this.Stitular = Stitular;
    }
    public int getEcuenta() {
        return ecuenta;
    }

    public float getRsaldo() {
        return rsaldo;
    }
    public void setrsaldoD(float rsaldo) {
        this.rsaldo = this.rsaldo + rsaldo;
    }
    public void setrsaldoR(float rsaldo){
        this.rsaldo = this.rsaldo - rsaldo;
    }
    public String Mostrar(){
        String salida;
        salida = "Compañia: " + sempresa + "\nNumero de cuenta: "+ ecuenta + 
                "\nCedula del titular: " + Stitular+ "\nSaldo de la cuenta: " + rsaldo;
        return salida;
    }
}
