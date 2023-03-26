import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map;

public class Controlador {
    public static void main(String[] args)
    {
        String[] values;
        String key;
        String value;
        Scanner in = new Scanner(System.in);
        archivos file =new archivos();
        ArrayList<String> lineas= file.read_file("diccionario.txt");
        //Creación de los 3 arboles
        BinaryTree english = new BinaryTree();
        BinaryTree spanish = new BinaryTree();
        BinaryTree french = new BinaryTree();
        for (String str : lineas) //para agregar los significados provenientes del archivo a cada arbol de cada idioma
        {
            //lista de valores
            ArrayList<String> lista_ing = new ArrayList();
            ArrayList<String> lista_esp = new ArrayList();
            ArrayList<String> lista_fra = new ArrayList();
            values = str.split(",");
            lista_ing.add(values[1]);
            lista_ing.add(values[2]);
            lista_esp.add(values[0]);
            lista_esp.add(values[2]);
            lista_fra.add(values[0]);
            lista_fra.add(values[1]);
            english.insert(values[0], lista_ing);
            spanish.insert(values[1], lista_esp);
            french.insert(values[2], lista_fra);
        } //ya está el arbol binario creado de cada uno en in order
        int e=0;
        while (e!=5)
        {
            System.out.println("Bienvenido al traductor \n Escoge una opcion\n 1.Traducir\n 2.Mostrar Arbol Ingles\n 3.Mostrar Arbol Español\n 4.Mostrar Arbol Frances\n 5.Salir");
            e=in.nextInt();
            switch (e)
            {
                case 1:
                    System.out.println("La traducción es: ");
                    archivos archivito =new archivos();
                    ArrayList<String> lineas_lectura= archivito.read_file("texto.txt"); //lee las lineas para traducir
                    System.out.println(lineas_lectura);
                    break;
                case 2:
                    System.out.println("El arbol de ingles es: ");
                    english.printInorder();
                    break;
                case 3:
                    System.out.println("El arbol de español es: ");
                    spanish.printInorder();
                    break;
                case 4:
                    System.out.println("El arbol de ingles es: ");
                    french.printInorder();
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion ingresada invalida");
                    break;
            }
        }
    }
}