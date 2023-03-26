
import java.util.ArrayList; //Import Arraylist
public class traductor {
    private String traduccion1;
    private String traduccion2;
    private String name1;
    private String name2;
    private String valores[];
    private ArrayList<String>  traducciones;
    private BinaryTree arbol;
    public traductor(BinaryTree arbol, String n1,String n2)
    {
        this.arbol=arbol;
        name1=n1;
        name2=n2;
    }
    public void traducir(String oracion)
    {
        traduccion1="";
        traduccion2="";
        valores= oracion.split("");
        for (String i : valores)
        {
            if (arbol.containsKey(i))
            {
                traducciones=arbol.search(i);
                traduccion1+=traducciones.get(0)+" ";
                traduccion2+=traducciones.get(1)+" ";

            }
            else
            {
                traduccion1+="*"+i+"* ";
                traduccion2+="*"+i+"* ";
            }
        }
        System.out.println("La traduccion en "+name1+" es:");
        System.out.println(traduccion1);
        System.out.println("La traduccion en "+name2+" es:");
        System.out.println(traduccion2);
    }
    
}
