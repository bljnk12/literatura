package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import java.util.List;
import com.aluracursos.screenmatch.DatosLibros;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;
    
    private List<String> idiomas;
    private Double numeroDeDescargas;
    

    public Libro(){}

    public Libro(DatosLibros datoLibro){
        this.titulo = datoLibro.titulo();
        this.idiomas = datoLibro.idiomas();
        this.numeroDeDescargas = datoLibro.numeroDeDescargas();
    }

    @Override
    public String toString() {
    	return "* Libro Encontrado *"+"\n"
        		+"Titulo: "+titulo+"\n"
        		+"Autor: "+autores+"\n"
        		+"Idiomas :"+idiomas+"\n"
        		+"Numero de descargas: "+numeroDeDescargas+"\n\n";
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
    	autores.forEach(a -> a.setLibro(this));
        this.autores = autores;
    }
    
    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }
    
    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
    
}
