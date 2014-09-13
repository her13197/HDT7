
import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) {

        ArrayList<Association> todoDiccionario = new ArrayList();
        File f = new File( "src/diccionario.txt" );
        BufferedReader entrada;
        File f1 = new File( "src/texto.txt" );
        BufferedReader entrada1;
        int c=0;
        String[] palabras=null;
        try {
            entrada1 = new BufferedReader( new FileReader( f1 ) );
            String linea1;
            linea1 = entrada1.readLine();
            palabras= linea1.split(" ");
            c=palabras.length;
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
        entrada = new BufferedReader( new FileReader( f ) );
        String linea;
        linea = entrada.readLine();       
            while(entrada.ready()){
                linea = entrada.readLine();
                String vector[] = linea.split(",");
                Association separado = new Association();
                separado.addAsociation( vector[0].substring(1), vector[1].substring(0,vector[1].length()-1));
                todoDiccionario.add(separado);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        BinaryTree diccionario = new BinaryTree();
        int co=todoDiccionario.size();
        String[][] pe = new String[co][2];
        for (int x = 0; x <co ; x++){
            pe[x][0]=todoDiccionario.get(x).getKey().toString();
            pe[x][1]=todoDiccionario.get(x).getValor().toString();
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