package com.aluracursos.screenmatch;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluracursos.screenmatch.model.Autor;
import com.aluracursos.screenmatch.model.Libro;

public interface LRepository extends JpaRepository<Libro,Long> {
	
	@Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fecha AND a.fechaDeFallecimiento >= :fecha")
	public List<Autor> autorVivo(String fecha);
	
}
