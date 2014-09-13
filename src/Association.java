/*Universidad del Valle de Guatemala
 * Estructura de datos
 * Hoja de trabajo 7
 * Autores:
 *      Erick Hernández 13197
 *      Maria Isabel Fernandez 13024
 *      Ana Bartra 13643
 * Archivo Association
 * archivo que nos permite manejar las asociaciones entre los nodos
 * y cada uno de sus hijos
 */
public class Association<K, V> {
    K key;
    V valor;
    
    
    public void addAsociation(K key, V valor){
        this.key = key;
        this.valor = valor;
    }
    
    public K getKey(){
        return this.key;
    }
    
    public V getValor(){
        return this.valor;
    }
}