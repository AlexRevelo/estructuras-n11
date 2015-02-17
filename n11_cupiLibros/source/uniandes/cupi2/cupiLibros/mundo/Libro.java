/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiLibros
 * Autor: Catalina M. Rodr�guez U - 02-sep-2011
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
	 * Constante de serializaci�n
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
	 * El a�o de publicaci�n del Libro
	 */
	private int anioPublicacion; 
	
	/**
	 * La editorial del Libro
	 */
	private String editorial; 
	
	/**
	 * El n�mero de p�ginas del Libro
	 */
	private int numPaginas; 
		
	//-------------------------------------------------------------
	// M�todo Constructor
	//-------------------------------------------------------------
	
	/**
	 * Construye un Libro. Inicializa sus atributos con los par�metros dados.
	 * @param isbnP C�digo ISBN del libro. isbnP != null y isbnP != ""
	 * @param nombreP Nombre del libro. nombreP != null y nombreP != ""
	 * @param autoresP Autores del libro. autoresP != null y autoresP != ""
	 * @param anioPublicacionP A�o de publicaci�n del libro. anioPublicacionP > 0
	 * @param editorialP Editorial del libro. editorialP != null y editorialP != ""
	 * @param numPaginasP N�mero de p�ginas del libro. numPaginasP > 0
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
	// M�todos
	//-------------------------------------------------------------
	
	/**
	 * M�todo que retorna el c�digo ISBN del libro
	 * @return C�digo ISBN
	 */
	public String darIsbn()
	{
		return isbn;
	}
	
	/**
	 * M�todo que retorna el nombre del libro
	 * @return Nombre del libro
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * M�todo que retorna los autores del libro
	 * @return Autores del libro
	 */
	public String darAutores()
	{
		return autores;
	}
	
	/**
	 * M�todo que retorna el a�o de publicaci�n del libro
	 * @return A�o de publicaci�n
	 */
	public int darAnioPublicacion()
	{
		return anioPublicacion;
	}
	
	/**
	 * M�todo que retorna la editorial del libro
	 * @return Editorial del libro
	 */
	public String darEditorial()
	{
		return editorial;
	}
	
	/**
	 * M�todo que retorna el n�mero de p�ginas del libro
	 * @return N�mero de p�ginas
	 */
	public int darNumPaginas()
	{
		return numPaginas;
	}
	
	/**
     * Retorna una cadena con el c�digo ISBN y el nombre del libro
     * @return La representaci�n del Libro en String: isbn - nombre
     */
	public String toString()
	{
		return isbn + " - " + nombre;
	}
}