/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiLibros
 * Autor: Catalina M. Rodríguez U - 02-sep-2011
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiLibros.test;

import junit.framework.TestCase;
import uniandes.cupi2.cupiLibros.mundo.Libro;

/**
 * Clase usada para verificar que los métodos de la clase Libro estén correctamente implementados
 */
public class LibroTest  extends TestCase  
{
	
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
	/**
	 * El libro de las pruebas
	 */
	private Libro libro; 
		
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
		
	/**
     * Crear un Libro
     */
    private void setupEscenario1( )
    {
        libro = new Libro("1.A0", "nombre", "autores", 2011, "editorial", 100);
    }
    
    /**
     * Prueba el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Libro, darIsbn darNombre, darAutores, darAnioPublicacion, darEditorial, darNumPaginas. <br>
     * <b> Objetivo: </b> Probar que el método constructor inicialice correctamente los atributos del libro. <br>
     */
    public void testLibro()
    {
    	setupEscenario1();
    	
    	assertNotNull("El ISBN del libro no fue inicializado", libro.darIsbn());
    	assertEquals("El ISBN del libro no fue inicializado correctamente", "1.A0", libro.darIsbn());
    	assertNotNull("El nombre del libro no fue inicializado", libro.darNombre());
    	assertEquals("El nombre del libro no fue inicializado correctamente", "nombre", libro.darNombre());
    	assertNotNull("Los autores del libro no fueron inicializados", libro.darAutores());
    	assertEquals("Los autores del libro no fueron inicializados correctamente", "autores", libro.darAutores());
    	assertEquals("El año de publicación del libro no fue inicializado correctamente", 2011, libro.darAnioPublicacion());
    	assertNotNull("El editorial del libro no fue inicializado", libro.darEditorial());
    	assertEquals("El editorial del libro no fue inicializado correctamente", "editorial", libro.darEditorial());
    	assertEquals("El número de páginas del libro no fue inicializado correctamente", 100, libro.darNumPaginas());
    }
}