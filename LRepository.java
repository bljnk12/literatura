package com.aluracursos.screenmatch;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluracursos.screenmatch.model.Autor;

public interface LRepository extends JpaRepository<Autor,Long> {
	
	@Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento LIKE CONCAT('%',:fecha,'%')")
	public List<Autor> autorVivo(String fecha);
   
}
