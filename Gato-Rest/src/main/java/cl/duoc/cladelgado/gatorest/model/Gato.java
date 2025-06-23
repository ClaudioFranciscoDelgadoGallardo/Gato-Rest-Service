package cl.duoc.cladelgado.gatorest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Getter
public enum Gato {
    X(1), O(2);

    private Integer valor;
}
