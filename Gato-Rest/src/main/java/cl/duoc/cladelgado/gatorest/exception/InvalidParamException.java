package cl.duoc.cladelgado.gatorest.exception;

public class InvalidParamException extends Exception{

    private String mensaje;

    public InvalidParamException(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return mensaje;
    }
}
