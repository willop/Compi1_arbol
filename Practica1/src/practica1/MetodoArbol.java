
package practica1;

import javax.swing.SpringLayout;

public class MetodoArbol {
    //-------------------atributo--------------------------
    NodoArbol raiz;
    
    //-------------------constructor------------------------
    public MetodoArbol(){
        this.raiz=null;
    }
    
    //---------------------------METODOS------------------------------
    //Metodo de ingresar
    
    public void ingresarnodo(String _dato,String _direccion){
        //crear el nodo
        System.out.print("la ruta es: "+_direccion);
        NodoArbol nuevonodo= new NodoArbol(_dato);
        //validar si el arbol esta vacio
        if(_direccion.compareTo("r")==0){
            
            raiz=nuevonodo;
            System.out.print("se crea la raiz:  "+ raiz.dato);
        }
        //si el arbol ya tiene uno o mas nodos
        //crear un nodo auxiliar para ir moviendose en el arbol
        NodoArbol aux =raiz;
        //la direccion viene en un string, necesito separar cada caracter para ir segun la direccion
        char ruta[]=_direccion.toCharArray();
        //recorrer la ruta para moverse en el arbol segun la ruta[]
        //empieza en uno por que la r ya esta creada cuando el arbol esta vacio y un length ya que los espacios de memoria empiezan en uno
        for(int i =1;i<ruta.length-1;i++){
           //aca depende de la direccion avanzamos en el arbol
            if(ruta[i]=='i'){
                //muevo el auxiliar a la izquierda
                aux= aux.iquierda;
            } 
            else{
                aux= aux.derecha;
            }
            //ya en la posicion, el auxiliar apunta a un nulo y en esa posicion se agrega el dato para que ya no sea nulo
            aux=nuevonodo;
        }
        
        //mostrararbol(raiz, 0);
    }
    
    
    
    
    //aca recorre la lista
    public void mostra(){
        //mostrararbol(raiz, 0);
    }
//metod para imprimir el arbol
    
    
    public void mostrararbol(){
        int cont=0;
        if(raiz==null){
            System.out.print("****************arbol vacio***************");
            
        }
        else{
            mostrararbol();
            for(int i=0;i<cont;i++){
                System.out.print("    ");
            }
            System.out.println(raiz.dato);
            
        }
        
    }
}
