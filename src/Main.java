/*Universidad del Valle de Guatemala
 * Estructura de datos
 * Hoja de trabajo 7
 * Autores:
 *      Erick Hernández 13197
 *      Maria Isabel Fernandez 13024
 *      Ana Bartra 13643
 * Archivo Main
 * Crea el arbol binario, lo llena con los datos leidos del archvio, lee el e texto y luego
 * traduce las palabras encontradas en el diccionario
 * 
 */
import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) {

        ArrayList<Association> Dicc = new ArrayList();
        File archivo = new File( "src/diccionario.txt" );
        BufferedReader Lec1;
        File texto = new File( "src/texto.txt" );
        BufferedReader Lec2;
        int c=0;
        String[] palabras=null;
        try {
            Lec2 = new BufferedReader( new FileReader( texto ) );
            String linea1;
            linea1 = Lec2.readLine();
            palabras= linea1.split(" ");
            c=palabras.length;
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
        Lec1 = new BufferedReader( new FileReader( archivo ) );
        String linea;
        linea = Lec1.readLine();       
            while(Lec1.ready()){
                linea = Lec1.readLine();
                String vector[] = linea.split(",");
                Association separado = new Association();
                separado.addAsociation( vector[0].substring(1), vector[1].substring(0,vector[1].length()-1));
                Dicc.add(separado);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        BinaryTree diccionario = new BinaryTree();
        int co=Dicc.size();
        String[][] pe = new String[co][2];
        for (int x = 0; x <co ; x++){
            pe[x][0]=Dicc.get(x).getKey().toString();
            pe[x][1]=Dicc.get(x).getValor().toString();
        }
        
        //Se trabaja el arbol binario de manera "in order"
        diccionario.inOrderTraverseTree(diccionario.root);
        String traduc="";
        boolean t=false;
        int p=0;
        for (int x =0; x <c; x++){
            for(int y =0; y<co;y++){
                if(palabras[x].equalsIgnoreCase(pe[y][0])){
                    p=y;
                    t=true;
                    break;
                }else{
                    t=false;
                }
            }
            if(t==true){
                traduc=traduc+pe[p][1]+" ";
            }else{
                traduc=traduc+palabras[x]+" ";
            }
         }
         System.out.println(traduc);
    }
    
    
}