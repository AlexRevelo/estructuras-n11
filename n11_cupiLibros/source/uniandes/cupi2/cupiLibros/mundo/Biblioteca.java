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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase que representa la Biblioteca
 * <b> inv: </b>
 * categoriaRaiz != null
 */
public class Biblioteca  
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
	
	/**
	 * Raíz del árbol de categorías de la Biblioteca
	 */
	private Categoria categoriaRaiz; 
	
	/**
     * Ruta del archivo donde se guardará la información
     */
    private String archivoBiblioteca;
		
	//-------------------------------------------------------------
	// Método Constructor
	//-------------------------------------------------------------
	
    /**
     * Constructor de la Biblioteca.</br>
     * <b>post: </b> La categoría raíz ha sido inicializada.
     * @param archivo El archivo donde se carga el estado de la Biblioteca
     * @throws BibliotecaException En caso de no poder abrir o leer el archivo con el estado de la Biblioteca
     */
	public Biblioteca(String archivo) throws BibliotecaException
	{
		archivoBiblioteca = archivo;

		File file = new File( archivoBiblioteca );

        // Si el archivo existe: se debe recuperar de allí el estado
        if( file.exists( ) )
        {
            try
            {
                ObjectInputStream ois = new ObjectInputStream( new FileInputStream( archivoBiblioteca ) );
                categoriaRaiz = ( Categoria )ois.readObject( );
                ois.close( );
                verificarInvariante( );
            }
            catch( Exception e )
            {
                throw new BibliotecaException( "Error fatal: imposible restaurar el estado del programa \n(" + e.getMessage( ) + ")" );
            }
        }
        else
        {
        	categoriaRaiz = new Categoria();
            verificarInvariante( );
        }
    }
	
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
	
	/**
	 * Retorna la categoría raíz de la biblioteca
	 * @return La categoría raíz
	 */
	public Categoria darCategoriaRaiz()
	{
		return categoriaRaiz;
	}
	
	/**
	 * Agrega una nueva categoría a la biblioteca de acuerdo 
	 * del sistema de clasificación decimal de Dewey.
	 * La categoría debe ser insertada en orden ascendente de acuerdo a su código
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * <b> pos: </b> Se ha agregado una nueva categoría a la biblioteca
	 * @param codigo Código de la categoría. Cadena numérica positiva
	 * @param nombre Nombre de la categoría. nombre != null y nombre != ""
	 * @param descripcion Descripción de la categoría. descripcion != null y descripcion != ""
	 * @param codigoCompuesto Código compuesto de la categoría. Cadena numérica positiva
	 * @throws BibliotecaException Se lanza una excepción si la categoría ya existe, 
	 * si no puede ser agregada pues su categoría padre no existe o la categoría padre tiene libro registrados
	 */
	public void agregarCategoria(String codigo, String nombre, String descripcion, String codigoCompuesto) throws BibliotecaException
	{
        //TODO Completar según la documentación del método

	}
	
	/**
	 * Elimina una categoría a la biblioteca 
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * <b> pos: </b> Se ha eliminado la categoría de la biblioteca
	 * @param codigoCateg Código de la categoría. Cadena numérica positiva
	 * @throws BibliotecaException Se lanza si la categoría no existe
	 */
	public void eliminarCategoria(String codigoCateg) throws BibliotecaException
	{
        //TODO Completar según la documentación del método

	}
	
	/**
	 * Agrega un libro a una categoría de la biblioteca
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * <b> pos: </b> Se ha agregado un nuevo libro a una categoría de la biblioteca
	 * @param codigo Código de la categoría. Cadena numérica positiva
	 * @param isbn Código ISBN del libro. isbn != null y isbn != ""
	 * @param nombre Nombre del libro. nombre != null y nombre != ""
	 * @param autores Autores del libro. autores != null y autores != ""
	 * @param anioPublicacion Año de publicación del libro. anioPublicacion > 0
	 * @param editorial Editorial del libro. editorial != null y editorial != ""
	 * @param numPaginas Número de páginas del libro. numPaginas > 0
	 * @throws BibliotecaException Se lanza una excepción si la categoría del libro no existe, 
	 * si la categoría del libro no es hoja o si ya existe un libro con el mismo ISBN
	 */
	public void agregarLibro(String codigo, String isbn, String nombre, String autores, 
			int anioPublicacion, String editorial, int numPaginas) throws BibliotecaException
	{
        //TODO Completar según la documentación del método

	}
	
	/**
	 * Elimina un libro de una categoría de la biblioteca
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * <b> pos: </b> Se ha eliminado el libro de una categoría de la biblioteca
	 * @param codigo Código de la categoría. Cadena numérica positiva
	 * @param isbn Código ISBN del libro. isbn != null y isbn != ""
	 * @throws BibliotecaException Se lanza una excepción si la categoría 
	 * del libro no existe o si el libro no existe
	 */
	public void eliminarLibro(String codigo, String isbn) throws BibliotecaException
	{
        //TODO Completar según la documentación del método

	}
	
	/**
	 * Retorna el número de categorías de la biblioteca
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * @return Número de categorías de la biblioteca
	 */
	public int darNumCategorias()
	{
        //TODO Completar según la documentación del método
	}
	
	/**
	 * Retorna el número de libros de la biblioteca
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * @return Número de libros de la biblioteca
	 */
	public int darNumLibros()
	{
        //TODO Completar según la documentación del método
	}
	
	/**
	 * Retorna la lista de libros en una categoría dada
	 * <b> pre: </b> La categoría raíz ha sido inicializada y la categoría con los libros existe
	 * @param codigo Código de la categoría. Cadena numérica positiva
	 * @return La lista de libros de la categoría dada.
	 */
	public ArrayList buscarLibros( String codigo )
    {
		ArrayList libros = new ArrayList();
		categoriaRaiz.buscarLibros(codigo, libros);
		return libros;
    }
	    
	/**
	 * Retorna la lista categorías de la biblioteca
	 * Las categorías se agregan en preorden
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * @return La lista de categorías de la biblioteca
	 */
	public ArrayList buscarCategoriasPreorden( )
    {
        //TODO Completar según la documentación del método

    }
	
	/**
	 * Retorna la lista categorías de la biblioteca
	 * Las categorías se agregan en postorden
	 * <b> pre: </b> La categoría raíz ha sido inicializada
	 * @return La lista de categorías de la biblioteca
	 */
	public ArrayList buscarCategoriasPostorden( )
    {
        //TODO Completar según la documentación del método

    }
	
    /**
     * Guarda el estado actual de la biblioteca
     * @throws BibliotecaException Si hay problemas al tratar de guardar el estado de la biblioteca
     */
    public void guardar( ) throws BibliotecaException
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( archivoBiblioteca ) );
            oos.writeObject( categoriaRaiz );
            oos.close( );
        }
        catch( IOException e )
        {
            throw new BibliotecaException( "Error al salvar: " + e.getMessage( ) );
        }
    }
    
	//-----------------------------------------------------------------
    // Invariante
    //-----------------------------------------------------------------
    
    /**
	 * Verifica la invariante de la clase <br>
	 * <b> inv: </b>
	 * categoriaRaiz != null <br>
	 */
	private void verificarInvariante()
	{
		assert categoriaRaiz != null: "La categoría raíz debe se diferente de null";
	}
	
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }	
}