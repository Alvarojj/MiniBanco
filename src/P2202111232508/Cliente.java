
package P2202111232508;


public class Cliente {
    //Atributos 
    private final String Scedula;
    private String Snombre;
    
    
    //Metodos

    public Cliente(String Scedula, String Snombre) {
        this.Scedula = Scedula;
        this.Snombre = Snombre;
    }

    public String getScedula() {
        return Scedula;
    }
    public String Mostrar(){
        String salida;
        salida= "Nombre: "+ Snombre+"\nCedula: "+ Scedula;
        return salida;
    }
}
