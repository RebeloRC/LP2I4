/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

public class Demo {
  public static void main(String[] args) {

    LivroDeBiblioteca L1 = new LivroDeBiblioteca("Introdução à POO usando JAVA", "Prof. Rafael Santos", "Campus/SBC",
        (short) 2003, "g11p17");
    {

      System.out.println(L1.getDados());
      if (!L1.getEmprestado()) {
        L1.Empresta();
        System.out.println("O livro Introducao a POO usando JAVA foi emprestado com sucesso! Devera ser devolvido em "
            + LivroDeBiblioteca.diasemprestimo + " dias.");
      } else {
        System.out.println("O livro solicitado já está emprestado e devera estar disponivel em no máximo "
            + LivroDeBiblioteca.diasemprestimo + " dias.");
      }

      System.out.println("-----------------------------");

      if (!L1.getEmprestado()) {
        L1.Empresta();
        System.out.println("O livro Introducao a POO usando JAVA foi emprestado com sucesso! Devera ser devolvido em "
            + LivroDeBiblioteca.diasemprestimo + " dias.");
      } else {
        System.out.println("O livro solicitado já está emprestado e devera estar disponivel em no máximo "
            + LivroDeBiblioteca.diasemprestimo + " dias.");
      }
    }
  }
}
