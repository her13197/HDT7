

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList> dicc = new ArrayList();
        File f = new File("src/diccionario.txt" );
        BufferedReader lector;
        try {
        lector = new BufferedReader(new FileReader(f));
        String linea;

        linea = lector.readLine();

            while(lector.ready()){
                linea = lector.readLine();

                String vector[] = linea.split(",");
                ArrayList separado = new ArrayList();
                separado.add(0, vector[0].substring(1));
                separado.add(1, vector[1].substring(0,vector[1].length()-1));

                dicc.add(separado);

            }

        }catch (IOException e) {
        e.printStackTrace();
        }
        
        System.out.println(dicc.size());
        System.out.println(dicc);
        BinaryTree<ArrayList> a1 = new BinaryTree<>(dicc.get(7)) ;
        BinaryTree<ArrayList> a2 = new BinaryTree<>(dicc.get(6),a1,null);
        BinaryTree<ArrayList> a3 = new BinaryTree<>(dicc.get(5)) ;
        BinaryTree<ArrayList> a4 = new BinaryTree<>(dicc.get(4),a2,a3); 
        BinaryTree<ArrayList> a5 = new BinaryTree<>(dicc.get(3)) ;
        BinaryTree<ArrayList> a6 = new BinaryTree<>(dicc.get(2)) ;
        BinaryTree<ArrayList> a7 = new BinaryTree<>(dicc.get(1),a5,a6) ;
        BinaryTree<ArrayList> afinal = new BinaryTree<>(dicc.get(0),a4,a7);
        
        System.out.println(afinal);   
      
        List<ArrayList> inList = new LinkedList<>();
		afinal.inorder(inList);
		System.out.println("INORDER" + inList);
        
        //ArrayList lista = [];
        //inList.toArray();
        Iterator i = inList.iterator();
        while(i.hasNext()){
            System.out.println("Elemento" + i.next());
        }      
    }
    
    
}

