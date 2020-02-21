/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

public class ErrorToken {
    String tokenlexico;
    String descripcion;
    int fila,columna;
    
    public ErrorToken(String _token, String _descripcion, int _fila, int _columna){
        this.tokenlexico=_token;
        this.descripcion=_descripcion;
        this.fila=_fila;
        this.columna=_columna;
    }
    
}
