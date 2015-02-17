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
package uniandes.cupi2.cupiLibros.mundo;

import java.io.Serializable;

/**
 * Clase que representa un libro de la biblioteca
 */
public class Libro implements Serializable
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
	
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * El ISBN del Libro
	 */
	private String isbn; 
	
	/**
	 * El nombre del Libro
	 */
	private String nombre; 
	
	/**
	 * Los autores del Libro
	 */
	private String autores; 
	
	/**
	 * El año de publicación del Libro
	 */
	private int anioPublicacion; 
	
	/**
	 * La editorial del Libro
	 */
	private String editorial; 
	
	/**
	 * El número de páginas del Libro
	 */
	private int numPaginas; 
		
	//-------------------------------------------------------------
	// Método Constructor
	//-------------------------------------------------------------
	
	/**
	 * Construye un Libro. Inicializa sus atributos con los parámetros dados.
	 * @param isbnP Código ISBN del libro. isbnP != null y isbnP != ""
	 * @param nombreP Nombre del libro. nombreP != null y nombreP != ""
	 * @param autoresP Autores del libro. autoresP != null y autoresP != ""
	 * @param anioPublicacionP Año de publicación del libro. anioPublicacionP > 0
	 * @param editorialP Editorial del libro. editorialP != null y editorialP != ""
	 * @param numPaginasP Número de páginas del libro. numPaginasP > 0
	 */
	public Libro(String isbnP, String nombreP, String autoresP, int anioPublicacionP, String editorialP, int numPaginasP)
	{
		isbn = isbnP;
		nombre = nombreP;
		autores = autoresP;
		anioPublicacion = anioPublicacionP;
		editorial = editorialP;
		numPaginas = numPaginasP;
	}
	
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
	
	/**
	 * Método que retorna el código ISBN del libro
	 * @return Código ISBN
	 */
	public String darIsbn()
	{
		return isbn;
	}
	
	/**
	 * Método que retorna el nombre del libro
	 * @return Nombre del libro
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * Método que retorna los autores del libro
	 * @return Autores del libro
	 */
	public String darAutores()
	{
		return autores;
	}
	
	/**
	 * Método que retorna el año de publicación del libro
	 * @return Año de publicación
	 */
	public int darAnioPublicacion()
	{
		return anioPublicacion;
	}
	
	/**
	 * Método que retorna la editorial del libro
	 * @return Editorial del libro
	 */
	public String darEditorial()
	{
		return editorial;
	}
	
	/**
	 * Método que retorna el número de páginas del libro
	 * @return Número de páginas
	 */
	public int darNumPaginas()
	{
		return numPaginas;
	}
	
	/**
     * Retorna una cadena con el código ISBN y el nombre del libro
     * @return La representación del Libro en String: isbn - nombre
     */
	public String toString()
	{
		return isbn + " - " + nombre;
	}
}