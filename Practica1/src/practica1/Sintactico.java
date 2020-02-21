
package practica1;

import java.util.ArrayList;
import java.util.List;


public class Sintactico {
  
    boolean primeravez=true;
    int cantidaddeerroressintacticos=0;
    int fila=0;
    int columna=0;
    int contador;
    Token tokenactual;
    List<Token>Listatokensparser;
    int globalresultado=0;
    ArrayList<Error_Tokens> Listaerroressintacticos;
    
    
    //inicia el analizador sintactico
    public int parser(List<Token> Listatokens){
        Listatokensparser=Listatokens;
        contador=0;
        tokenactual= Listatokensparser.get(contador);  
        inicio();
        return cantidaddeerroressintacticos;
    }
    
    public void inicio(){
        if(tokenactual.id_token.equals("TK_{"))
        {
            System.out.print("entro al inicio y reconocio {");
            match("TK_{");
            cuerpo();
            System.out.print("llego al final");
            match("TK_}");
            
        }
        else{
            Listaerroressintacticos.add(new Error_Tokens(tokenactual.id_token, "Error sintactico", fila, columna));
            //System.err.print("errror en el analizadooooor sintactico");
        }
    }//fin de inicio
    
    ////para  no terminal  <cuerpo>
    public void cuerpo (){
        conjunto();
        Expresion();
        //validacion();
        
    }//fin de cuerpo
    
    
    //para terminar <conjunto>
    public void conjunto(){
        if(tokenactual.id_token.equals("TK_conj")){
            //System.out.print("si entro a conj en sintactico");
            match("TK_conj");
            match("TK_:");
            match("TK_id");
            match("TK_apuntado");
            //System.out.print("antes de entrar a definicion");
            definicion();
            //System.out.print("LLego a p y cma");
            match("TK_pcoma");
            conjunto();
        }
        else{
            //epsilon
        }
    }//fin de conjunto
    
    public void definicion(){
        if(tokenactual.id_token.equals("TK_id")){
            match("TK_id");
            alcance();
        }
        if(tokenactual.id_token.equals("TK_num")){
            match("TK_num");
            alcance();
        }
        else{
            //error por que se necesita un id o un numero
        }
        
    }//fin de definicion
    
    public void alcance(){
        if(tokenactual.id_token.equals("TK_coma")){
            match("TK_coma");
            alcance2();
        }
        if(tokenactual.id_token.equals("TK_~")){
            match("TK_~");
            alcance2();
        }
        else{
            //epsilon
        }
    }//fin del no terminal <alcance>
    
    public void alcance2(){
        definicion();
    }
    
    public void difer(){
        if(tokenactual.id_token.equals("TK_:")){
            match("TK_:");
            validacion();
        }
        if(tokenactual.id_token.equals("TK_apuntado")){
            match("TK_apuntado");
            ER();
        }
        
    }
    
    public void Expresion(){
        if(tokenactual.id_token.equals("TK_id")){
            match("TK_id");
            difer();
            match("TK_pcoma");
            Expresion();
        }
        else{
            //epsilon
        }
    }//fin del no terminal <Expresion>
    
    public void ER(){
        if(tokenactual.id_token.equals("TK_punto")){
            match("TK_punto");
            valI();
            ValD();
        }
        else if(tokenactual.id_token.equals("TK_|")){
            match("TK_|");
            valI();
            ValD();
        }
        else if(tokenactual.id_token.equals("TK_*")){
            match("TK_*");
            valI();
            
        }
        else if(tokenactual.id_token.equals("TK_+")){
            match("TK_+");
            valI();
            
        }
        else if(tokenactual.id_token.equals("TK_?")){
            match("TK_?");
            valI();
            
        }
        else{
            //error en expresion
        }
        
    }
    
    public void valI(){
        if(tokenactual.id_token.equals("TK_num")){
            match("TK_num");
        }
        if(tokenactual.id_token.equals("TK_cadena")){
            match("TK_cadena");
        }
        if(tokenactual.id_token.equals("TK_{")){
            match("TK_{");
            match("TK_id");
            match("TK_}");
        }
        else{
            ER();
        }
    }//termina el valor 1
    
    public void ValD(){
        if(tokenactual.id_token.equals("TK_num")){
            match("TK_num");
        }
        if(tokenactual.id_token.equals("TK_cadena")){
            match("TK_cadena");
        }
        if(tokenactual.id_token.equals("TK_{")){
            match("TK_{");
            match("TK_id");
            match("TK_}");
        }
        else{
            ER();
        }
    }//fin del no terminal ValD
    
    
    public void validacion(){
        if(tokenactual.id_token.equals("TK_cadena")){
            match("TK_cadena");
            //match("TK_pcoma");
            validacion();
        }
        else{
            
        }
    }//fin del no terminal validacion
    
    
    
    
    
    public void match(String token_enviado){
        
        if(token_enviado !=tokenactual.id_token){
        //si se encuetra un erro lo va a obviar y va a pasar el siguiente token
        
            Listaerroressintacticos.add(new Error_Tokens(tokenactual.id_token, "Se esperaba "+token_enviado, fila, columna));
            contador++;
            cantidaddeerroressintacticos++;
            tokenactual = Listatokensparser.get(contador);
        }
        else if(token_enviado!="fin"){
            //no hay error
            
            contador++;
            tokenactual= Listatokensparser.get(contador);          
        }
    }
    
    
    public ArrayList<Error_Tokens> errorsintactico(){
        return Listaerroressintacticos;
    }
    
}
