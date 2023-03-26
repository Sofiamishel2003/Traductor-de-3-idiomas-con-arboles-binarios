
import java.util.ArrayList; //Import Arraylist
public class Find_idioma {
    private String traduccion1;
    private String traduccion2;
    private String name1;
    private String name2;
    private String valores[];
    private String  Respuesta[];

    private BinaryTree arbol;
    public Find_idioma()
    {
    }
    public String Find(String oracion, BinaryTree arbolI,BinaryTree arbolE,BinaryTree arbolF)
    {

        valores= oracion.split(" ");
        String Respuesta= "";
        for (String i : valores)
        {
            if (arbolI.containsKey(i))
            {
                Respuesta= "Ingles";
            }
            else if(arbolE.containsKey(i))
            {
                Respuesta= "Español";

            }
            else if(arbolF.containsKey(i))
            {
                Respuesta= "Frances";
            }
        }
        return Respuesta;
    }
    
}

