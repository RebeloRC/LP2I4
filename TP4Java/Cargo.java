/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

package tp04;

public class Cargo
{
    private int codigo;
    private String cargo;
   
    public Cargo(int codigo, String cargo){
        this.codigo = codigo;
        this.cargo = cargo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public String getCargo(){
        return this.cargo;
    }
}
