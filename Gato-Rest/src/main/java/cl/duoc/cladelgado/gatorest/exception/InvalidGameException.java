package cl.duoc.cladelgado.gatorest.exception;

public class InvalidGameException extends Exception {
    private String mensaje;

    public InvalidGameException(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return mensaje;
    }
}
