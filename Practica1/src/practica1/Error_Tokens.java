
package practica1;


public class Error_Tokens {
    public int fila,columna;
    public String caracter,descripcion;
    
    
    public Error_Tokens(String _caracter,String _descripcion,int _fila, int _columna){
        this.fila=_fila;
        this.columna=_columna;
        this.caracter=_caracter;
        this.descripcion=_descripcion;
    }
}
