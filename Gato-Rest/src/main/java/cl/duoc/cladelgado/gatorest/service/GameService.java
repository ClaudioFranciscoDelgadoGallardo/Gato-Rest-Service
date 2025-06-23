package cl.duoc.cladelgado.gatorest.service;

import cl.duoc.cladelgado.gatorest.exception.InvalidGameException;
import cl.duoc.cladelgado.gatorest.model.Game;
import cl.duoc.cladelgado.gatorest.model.GameStatus;
import cl.duoc.cladelgado.gatorest.model.Player;
import cl.duoc.cladelgado.gatorest.storage.GameStorage;
import cl.duoc.cladelgado.gatorest.exception.InvalidParamException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static cl.duoc.cladelgado.gatorest.model.GameStatus.EN_PROGESO;
import static cl.duoc.cladelgado.gatorest.model.GameStatus.NUEVO;

@Service
@AllArgsConstructor
public class GameService {

    public Game crearJuego(Player jugador) {
        Game game = new Game();
        game.setTablero(new int [3][3]);
        game.setJuegoId(UUID.randomUUID().toString());
        game.setJugador1(jugador);
        game.setEstado(NUEVO);
        GameStorage.getInstance().setGames(game);
        return game;
    }

    public Game connectarAlJuego(Player jugador2, String juegoId) throws InvalidParamException, InvalidGameException {
        if (!GameStorage.getInstance().getGames().containsKey(juegoId)) {
            throw new InvalidParamException("Los juegos con la identificación proporcionada no existen. ");
        }
        Game game = GameStorage.getInstance().getGames().get(juegoId);

        if(game.getJugador2() != null) {
            throw new InvalidGameException("El juego ya no es válido");
        }
        game.setJugador2(jugador2);
        game.setEstado(EN_PROGESO);
        GameStorage.getInstance().setGames(game);
        return game;
    }
}
