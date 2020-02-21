
package practica1;
import java.util.*;


public class IgresarNodo {
    //----------------------------atributos----------------------
    ArrayList<Token>lista= new ArrayList<Token>();
    int contador;
    MetodoArbol arbol;
    //-----------------------------constructor-------------------
    public IgresarNodo(){
        this.arbol=new MetodoArbol();
        this.contador=0;
        this.lista=new ArrayList<>();
    }
    
    //---------------------------------Metodos -----------------------------
    public void IniciarMetodoArbol(ArrayList<Token> _lista){
        this.lista=_lista;
        
    }
    //metoo para agregar simbolos .|*+?
    public void estadoSimbolo(String _ruta){
        //obteiene el priemer valor de la lista d la expresion
        String caracter = lista.get(contador++).id_token;
        
        //si es un . o un | tiene dos hijos
        if(caracter.equals("TK_punto")||caracter.equals("TK_|")){
            arbol.ingresarnodo(lista.get(contador).lexema, _ruta);
            estadoCaracteres(_ruta+"i");//primer lado del nodo <-
            estadoCaracteres(_ruta +"d");//segundo lado del nodo ->
        }
        //si no solo tienen un hijo, como ? * +
        else if(caracter.equals("TK_*")||caracter.equals("TK_?")||caracter.equals("TK_+")){
            arbol.ingresarnodo(lista.get(contador).lexema, _ruta);
            estadoCaracteres(_ruta+"i");
            
        }
        
        
        
    }
    
    //agraga el nodo de las hojas 
    public void estadoCaracteres(String _ruta){
        String caracter = lista.get(contador++).id_token;
        
        //si viene una raiz despues de agreaga una raiz
        if(caracter.endsWith("TK_punto")||caracter.equals("TK_|")||caracter.equals("TK_*")||caracter.equals("TK_?")||caracter.equals("TK_+")){
            contador--;
            estadoSimbolo(_ruta);
            
        }
        //si viene una hoja 
        else{
            arbol.ingresarnodo(lista.get(contador).lexema, caracter);
        }
    }
    
}
