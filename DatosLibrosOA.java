package com.aluracursos.screenmatch;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibrosOA(
        @JsonAlias("authors") List<DatosAutor> autor
) {
	@Override
    public String toString() {

        return 
        		"Autor: "+autor+"\n\n";
        		
        		
    }
}
