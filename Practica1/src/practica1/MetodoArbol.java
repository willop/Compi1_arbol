
package practica1;

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
        NodoArbol nuevonodo= new NodoArbol(_dato);
        //validar si el arbol esta vacio
        if(raiz==null){
            raiz=nuevonodo;
        }
        //si el arbol ya tiene uno o mas nodos
        //crear un nodo auxiliar para ir moviendose en el arbol
        NodoArbol aux =raiz;
        //la direccion viene en un string, necesito separar cada caracter para ir segun la direccion
        char ruta[]=_direccion.toCharArray();
        //recorrer la ruta para moverse en el arbol segun la ruta[]
        //empieza en uno por que la r ya esta creada cuando el arbol esta vacio y un length ya que los espacios de memoria empiezan en uno
        for(int i =1;i<ruta.length;i++){
           //aca depende de la direccion avanzamos en el arbol
            if(ruta[i]=='i'){
                //muevo el auxiliar a la izquierda
                aux=aux.iquierda;
            } 
            else{
                aux = aux.derecha;
            }
            //ya en la posicion, el auxiliar apunta a un nulo y en esa posicion se agrega el dato para que ya no sea nulo
            aux=nuevonodo;
        }
    
    }
}
