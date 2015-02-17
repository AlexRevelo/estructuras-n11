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
	 * Ra�z del �rbol de categor�as de la Biblioteca
	 */
	private Categoria categoriaRaiz; 
	
	/**
     * Ruta del archivo donde se guardar� la informaci�n
     */
    private String archivoBiblioteca;
		
	//-------------------------------------------------------------
	// M�todo Constructor
	//-------------------------------------------------------------
	
    /**
     * Constructor de la Biblioteca.</br>
     * <b>post: </b> La categor�a ra�z ha sido inicializada.
     * @param archivo El archivo donde se carga el estado de la Biblioteca
     * @throws BibliotecaException En caso de no poder abrir o leer el archivo con el estado de la Biblioteca
     */
	public Biblioteca(String archivo) throws BibliotecaException
	{
		archivoBiblioteca = archivo;

		File file = new File( archivoBiblioteca );

        // Si el archivo existe: se debe recuperar de all� el estado
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
	// M�todos
	//-------------------------------------------------------------
	
	/**
	 * Retorna la categor�a ra�z de la biblioteca
	 * @return La categor�a ra�z
	 */
	public Categoria darCategoriaRaiz()
	{
		return categoriaRaiz;
	}
	
	/**
	 * Agrega una nueva categor�a a la biblioteca de acuerdo 
	 * del sistema de clasificaci�n decimal de Dewey.
	 * La categor�a debe ser insertada en orden ascendente de acuerdo a su c�digo
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * <b> pos: </b> Se ha agregado una nueva categor�a a la biblioteca
	 * @param codigo C�digo de la categor�a. Cadena num�rica positiva
	 * @param nombre Nombre de la categor�a. nombre != null y nombre != ""
	 * @param descripcion Descripci�n de la categor�a. descripcion != null y descripcion != ""
	 * @param codigoCompuesto C�digo compuesto de la categor�a. Cadena num�rica positiva
	 * @throws BibliotecaException Se lanza una excepci�n si la categor�a ya existe, 
	 * si no puede ser agregada pues su categor�a padre no existe o la categor�a padre tiene libro registrados
	 */
	public void agregarCategoria(String codigo, String nombre, String descripcion, String codigoCompuesto) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}
	
	/**
	 * Elimina una categor�a a la biblioteca 
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * <b> pos: </b> Se ha eliminado la categor�a de la biblioteca
	 * @param codigoCateg C�digo de la categor�a. Cadena num�rica positiva
	 * @throws BibliotecaException Se lanza si la categor�a no existe
	 */
	public void eliminarCategoria(String codigoCateg) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}
	
	/**
	 * Agrega un libro a una categor�a de la biblioteca
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * <b> pos: </b> Se ha agregado un nuevo libro a una categor�a de la biblioteca
	 * @param codigo C�digo de la categor�a. Cadena num�rica positiva
	 * @param isbn C�digo ISBN del libro. isbn != null y isbn != ""
	 * @param nombre Nombre del libro. nombre != null y nombre != ""
	 * @param autores Autores del libro. autores != null y autores != ""
	 * @param anioPublicacion A�o de publicaci�n del libro. anioPublicacion > 0
	 * @param editorial Editorial del libro. editorial != null y editorial != ""
	 * @param numPaginas N�mero de p�ginas del libro. numPaginas > 0
	 * @throws BibliotecaException Se lanza una excepci�n si la categor�a del libro no existe, 
	 * si la categor�a del libro no es hoja o si ya existe un libro con el mismo ISBN
	 */
	public void agregarLibro(String codigo, String isbn, String nombre, String autores, 
			int anioPublicacion, String editorial, int numPaginas) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}
	
	/**
	 * Elimina un libro de una categor�a de la biblioteca
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * <b> pos: </b> Se ha eliminado el libro de una categor�a de la biblioteca
	 * @param codigo C�digo de la categor�a. Cadena num�rica positiva
	 * @param isbn C�digo ISBN del libro. isbn != null y isbn != ""
	 * @throws BibliotecaException Se lanza una excepci�n si la categor�a 
	 * del libro no existe o si el libro no existe
	 */
	public void eliminarLibro(String codigo, String isbn) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}
	
	/**
	 * Retorna el n�mero de categor�as de la biblioteca
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * @return N�mero de categor�as de la biblioteca
	 */
	public int darNumCategorias()
	{
        //TODO Completar seg�n la documentaci�n del m�todo
	}
	
	/**
	 * Retorna el n�mero de libros de la biblioteca
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * @return N�mero de libros de la biblioteca
	 */
	public int darNumLibros()
	{
        //TODO Completar seg�n la documentaci�n del m�todo
	}
	
	/**
	 * Retorna la lista de libros en una categor�a dada
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada y la categor�a con los libros existe
	 * @param codigo C�digo de la categor�a. Cadena num�rica positiva
	 * @return La lista de libros de la categor�a dada.
	 */
	public ArrayList buscarLibros( String codigo )
    {
		ArrayList libros = new ArrayList();
		categoriaRaiz.buscarLibros(codigo, libros);
		return libros;
    }
	    
	/**
	 * Retorna la lista categor�as de la biblioteca
	 * Las categor�as se agregan en preorden
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * @return La lista de categor�as de la biblioteca
	 */
	public ArrayList buscarCategoriasPreorden( )
    {
        //TODO Completar seg�n la documentaci�n del m�todo

    }
	
	/**
	 * Retorna la lista categor�as de la biblioteca
	 * Las categor�as se agregan en postorden
	 * <b> pre: </b> La categor�a ra�z ha sido inicializada
	 * @return La lista de categor�as de la biblioteca
	 */
	public ArrayList buscarCategoriasPostorden( )
    {
        //TODO Completar seg�n la documentaci�n del m�todo

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
		assert categoriaRaiz != null: "La categor�a ra�z debe se diferente de null";
	}
	
    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }	
}