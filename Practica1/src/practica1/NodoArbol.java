
package practica1;


public class NodoArbol {
    
    //--------------------atributos -------------------------
    public NodoArbol iquierda;
    public NodoArbol derecha;
    public String dato;
    
    
    //---------------------constructor--------------------
    public NodoArbol(String _dato){
        this.iquierda=null;
        this.derecha=null;
        this.dato=_dato;
    }
    
}
