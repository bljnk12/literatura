package com.aluracursos.screenmatch;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.aluracursos.screenmatch.model.Autor;
import com.aluracursos.screenmatch.model.Libro;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoAPI = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LRepository repositorio;
    private Scanner teclado = new Scanner(System.in);
    
    
    public Principal(LRepository repository) {
        this.repositorio = repository;
    }
    
    public void muestraElMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json,Datos.class);
      
        
            var opcion = -1;
            while (opcion != 0) {
                var menu = """
                		Elija la opcion deseada:
                		
                        1 - Buscar libro por titulo
                        2 - Listar libros registrados
                        3 - Listar autores registrados
                        4 - Listar autores vivos
                        5 - Listar libros por idioma
                                      
                        6 - Salir
                        """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                    	buscarLibro();
                        break;
                    case 2:
                    	System.out.println(datos);
                        break;
                    case 3:
                    	listarAutores();
                        break;
                    case 4:
                    	autoresVivos();
                        break;
                    case 5:
                    	buscarLibroPorIdioma();
                        break;
                    
                    
                    case 6:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            }
    }
    
    
	private DatosLibros buscarLibroPorTitulo() {
		var json = consumoAPI.obtenerDatos(URL_BASE);
		System.out.println("Ingrese el titulo del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE+"?search=" + tituloLibro.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }
        return libroBuscado.get();
	}
	
	
	 private void buscarLibro() {
	        DatosLibros datos = buscarLibroPorTitulo();
	        Libro librow = new Libro(datos);
	        repositorio.save(librow);
	        //datosLibros.add(datos);
	        //System.out.println(datos);
	    }
	 
	
	private void listarAutores() {
		var json = consumoAPI.obtenerDatos(URL_BASE);
		var autores = conversor.obtenerDatos(json, Autores.class);
		System.out.println(autores);
	}
	
	
	private void autoresVivos() {
		System.out.println("Digite el año que desea buscar:");
        var fecha = teclado.nextLine();
        List<Autor> autorvivo = repositorio.autorVivo(fecha);
        System.out.println(autorvivo);
	}


	private void buscarLibroPorIdioma() {
		var json = consumoAPI.obtenerDatos(URL_BASE);
		System.out.println("Ingrese el idioma en el que desee los libros en=ingles, es=español, fr=frances");
        var lenguaje = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE+"?languages=" + lenguaje.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        datosBusqueda.resultados().stream()
        	.map(l -> l.titulo().toUpperCase())
        	.forEach(System.out::println);
		
	}
}
