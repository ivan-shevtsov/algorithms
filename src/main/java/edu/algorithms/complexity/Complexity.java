package edu.algorithms.complexity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Complexity {

    ComplexityLevel level;
    Double koof;

    @Override
    public String toString() {
        return String.format("%s %s", Math.round(koof * 1000.0) / 1000.0, level.name());
    }

}
