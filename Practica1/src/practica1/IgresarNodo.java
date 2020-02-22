
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
        System.out.print("Ingesa a ingresaNodo");

        for(int i=0;i<=lista.size()-1;i++){           
            System.out.println(lista.get(i).lexema);
        }
        System.out.print("salio sin problema");
        this.contador=0;
        estadoSimbolo("r");
        
        //mostrararbol(r, contador);
        
    }
    
    
    //metoo para agregar simbolos .|*+?
    public void estadoSimbolo(String _ruta){
        //obteiene el priemer valor de la lista d la expresion
        String caracter = lista.get(contador).id_token;
        //System.out.print("\nEl caracter es: "+caracter);
        //si es un . o un | tiene dos hijos
        if(caracter.equals("TK_punto")||caracter.equals("TK_|")){
            
            arbol.ingresarnodo(lista.get(contador).lexema, _ruta);
            //System.out.println("lo que grafico es: "+lista.get(contador).lexema);
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
        if(caracter.equals("TK_punto")||caracter.equals("TK_|")||caracter.equals("TK_*")||caracter.equals("TK_?")||caracter.equals("TK_+")){
            //contador--
            //System.out.println("regesa a simbolos");
            estadoSimbolo(_ruta);
            
        }
        //si viene una hoja 
        else{
            arbol.ingresarnodo(lista.get(contador).lexema, _ruta);
            contador++;
        }
    }
    
  
}
