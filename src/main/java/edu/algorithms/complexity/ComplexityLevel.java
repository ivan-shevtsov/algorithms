package edu.algorithms.complexity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.IntFunction;

@AllArgsConstructor
@Getter
public enum ComplexityLevel {

    O_C (n -> 1.0),
    O_LOG_N (n -> Math.log(n)),
    O_N (n -> (double) n),
    O_N_LOG_N (n -> Math.log(n) * n),
    O_N2 (n -> (double) n * n),
    O_N3 (n -> (double) n * n * n);

    IntFunction<Double> baseFunction;
}
