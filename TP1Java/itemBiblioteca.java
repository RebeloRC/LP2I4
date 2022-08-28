/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

public interface itemBiblioteca {
  public static final int diasemprestimo = 7;

  public boolean getEmprestado();

  public String getLocalizacao();

  public void Empresta();

  public void Devolve();
}
