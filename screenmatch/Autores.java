package com.aluracursos.screenmatch;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autores(
	       @JsonAlias("results") List<DatosLibrosOA> resultados
) {
}
