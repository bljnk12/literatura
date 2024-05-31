package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import com.aluracursos.screenmatch.DatosAutor;

@Entity
@Table(name = "autores")
public class Autor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private String fechaDeNacimiento;
    private String fechaDeFallecimiento;
    @ManyToOne
    private Libro libro;
    

    public Autor(){}

    public Autor(DatosAutor datoAutor){
        this.nombre = datoAutor.nombre();
        this.fechaDeNacimiento = datoAutor.fechaDeNacimiento();
        this.fechaDeFallecimiento = datoAutor.fechaDeFallecimiento();
    }

    @Override
    public String toString() {

        return 
        		"\n"
        		+"	Nombre: "+nombre+"\n"
        		+"	Fecha de nacimiento: "+fechaDeNacimiento+"\n"
        		+"	Fecha de fallecimiento: "+fechaDeFallecimiento
        		+"\n";
    }
    
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public String getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(String fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

}
