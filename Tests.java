import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class Tests {
  BinaryTree english = new BinaryTree();
  ArrayList<String> lista_ing = new ArrayList();
 
  @Test
  public void testInsert() {
    lista_ing.add("perro");
    lista_ing.add("chien");
    english.insert("Dog", lista_ing);
    boolean resultado =english.containsKey("Dog");
    assertEquals(true, resultado);
  }

  @Test
  public void testSearch() {
    lista_ing.add("perro");
    lista_ing.add("chien");
    english.insert("Dog", lista_ing);
    ArrayList<String> resultado =english.search("Dog");
    assertEquals(lista_ing, resultado);
  }

}