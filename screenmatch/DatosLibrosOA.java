package com.aluracursos.screenmatch;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibrosOA(
        @JsonAlias("authors") List<DatosAutor> autores
) {
	@Override
    public String toString() {

        return 
        		"Autor: "+autores+"\n\n";
        		
        		
    }
}
