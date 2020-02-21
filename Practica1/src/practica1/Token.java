
package practica1;

public class Token {
    String id_token;
    String lexema;
    int fila;
    int columna;
    String tipo;
    
    public Token(String _token,String _lexema,String _tipo,int _fila, int _columna){
        this.lexema=_lexema;
        this.tipo = _tipo;
        this.fila = fila;
        this.columna=columna;
        this.id_token=_token;
        
    }
}
