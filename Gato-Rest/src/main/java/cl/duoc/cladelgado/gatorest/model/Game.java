package cl.duoc.cladelgado.gatorest.model;

import lombok.Data;

@Data
public class Game {

    private String juegoId;
    private Player jugador1;
    private Player jugador2;
    private GameStatus estado;
    private int [][] tablero;
    private Gato ganador;

}
