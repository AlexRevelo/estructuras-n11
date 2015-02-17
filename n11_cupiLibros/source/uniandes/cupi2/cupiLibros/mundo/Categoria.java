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
import java.util.ArrayList;

/**
 * Clase que representa una Categor�a de la biblioteca
 * <b> inv: </b>
 * subCategorias != null
 * libros != null
 * Si la categor�a tiene sub-categor�as no puede tener libros
 * No existen libros con el mismo c�digo ISBN
 * Las sub-categor�as se encuentran ordenadas de acuerdo a su c�digo de manera ascendente
 */
public class Categoria implements Serializable
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
	
	/**
	 * Constante de serializaci�n
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * El c�digo de la Categor�a
	 */
	private char codigo; 

	/**
	 * El c�digo compuesto de la Categor�a
	 */
	private String codigoCompuesto;
	
	/**
	 * El nombre de la Categor�a
	 */
	private String nombre; 
	
	/**
	 * La descripci�n de Categor�a
	 */
	private String descripcion; 
		
	/**
	 * Lista de las sub-categor�as de la Categor�a
	 */
	private ArrayList subCategorias; 
	
	/**
	 * Lista con los libros de la Categor�a
	 */
	private ArrayList libros; 
	
	//-------------------------------------------------------------
	// M�todo Constructor
	//-------------------------------------------------------------
	
	/**
     * Construye una categor�a vac�a. 
     * <b> post: </b> Se inicializa el c�digo en 0, 
     * el nombre, la descripci�n en null y el codigoCompuesto vac�o
     * y las listas de sub-categor�as y libros se inicializan vac�as.
     */
    public Categoria( )
    {
        codigo = 0;
        nombre = null;
        descripcion = null;
        codigoCompuesto = "";

        subCategorias = new ArrayList();
		libros = new ArrayList();
		
        verificarInvariante( );
    }
	
	/**
	 * Construye una Categor�a. Inicializa sus atributos con los par�metros dados.
	 * Las listas de sub-categor�as y libros se inicializan vac�as. 
	 * @param codigoP C�digo de la categor�a. 9 >= codigoP >= 0
	 * @param nombreP Nombre de la categor�a. nombreP != null y nombreP!= ""
	 * @param descripcionP Descripci�n de la categor�a. descripcionP != null y descripcionP != ""
	 * @param codigoCompuestoP C�digo compuesto de la categor�a. Cadena num�rica positiva
	 */
	public Categoria(char codigoP, String nombreP, String descripcionP, String codigoCompuestoP)
	{
		codigo = codigoP;
		nombre = nombreP;
		descripcion = descripcionP;
		codigoCompuesto = codigoCompuestoP;
		
		subCategorias = new ArrayList();
		libros = new ArrayList();
		
		verificarInvariante( );
	}
		
	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------
	
	/**
	 * Devuelve el nombre de la Categor�a
	 * @return Nombre de la Categor�a
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * Devuelve el c�digo de la Categor�a
	 * @return C�digo de la Categor�a
	 */
	public char darCodigo()
	{
		return codigo;
	}
	
	/**
	 * Devuelve la descripci�n de la Categor�a
	 * @return Descripci�n de la Categor�a
	 */
	public String darDescripcion()
	{
		return descripcion;
	}
	
	/**
	 * Devuelve el c�digo compuesto de la Categor�a
	 * @return C�digo compuesto de la Categor�a
	 */
	public String darCodigoCompuesto()
	{
		return codigoCompuesto;
	}
	
	/**
	 * Devuelve la lista de sub-categor�as de la Categor�a
	 * @return Lista de sub-categor�as de la Categor�a
	 */
	public ArrayList darSubCategorias()
	{
		return subCategorias;
	}
	
	/**
	 * Devuelve la lista de libros de la Categor�a
	 * @return Lista de libros de la Categor�a
	 */
	public ArrayList darLibros()
	{
		return libros;
	}
	   
    /**
     * Indica si la categor�a es hoja
     * Una categor�a es hoja si no tiene sub-categor�as
     * <b> pre: </b> La lista de sub-categor�as ha sido inicializada
     * @return True si es hoja, false en caso contrario
     */
    private boolean esHoja()
    {
        return subCategorias.isEmpty();
    }
	
	/**
     * Busca una categor�a con el c�digo dado en la lista de sub-categor�as de la categor�a actual 
     * <b> pre: </b> La lista de sub-categor�as ha sido inicializada
     * @param codigo C�digo de la categor�a a buscar. 9 >= codigo >= 0
     * @return La categor�a con el c�digo dado o null en caso de que no exista
     */
    public Categoria buscarCategoria(char codigo)
    {
        //TODO Completar seg�n la documentaci�n del m�todo
        //AYUDA: Solo realiza la b�squeda en la lista de las sub categor�as inmediatas (Hijas), no realiza recursi�n
    	for ( int i = 0; i <subCategorias.size(); i++)
    	{
    		Categoria hijo = (Categoria)subCategorias.get(i);
    		Categoria temp = hijo.buscarCategoria(codigo);
    		if(temp != null)
    		{
    			return temp;
    		}
    	}
    	return null;    	
    }
	
	/**
     * Crea una categor�a y la agrega a la lista de sub-categor�as de la categor�a actual
     * La categor�a debe ser insertada en orden ascendente de acuerdo a su c�digo
     * <b> pre: </b> Las listas de sub-categor�as ha sido inicializada
     * <b> pos: </b> Se ha agregado una nueva categor�a a la categor�a actual
     * @param codigoCateg C�digo de la categor�a. 9 >= codigoCateg >= 0
     * @param nombre Nombre de la categor�a. nombre != null y nombre != ""
     * @param descripcion Descripci�n de la categor�a. descripcion != null y descripcion != ""
     * @param codigoCompuesto C�digo compuesto de la categor�a. Cadena num�rica positiva
     */
    public void agregarCategoriaOrdenada(char codigoCateg, String nombre, String descripcion, String codigoCompuesto)
    {
        //TODO Completar seg�n la documentaci�n del m�todo
    	
    	Categoria nueva = new Categoria(codigoCateg, nombre, descripcion, codigoCompuesto);
    	subCategorias.add(nueva);
    }
	/**
	 * Agrega una nueva categor�a a la biblioteca de acuerdo 
	 * del sistema de clasificaci�n decimal de Dewey (Ver documento de descripci�n)
	 * La categor�a debe ser insertada en orden ascendente de acuerdo a su c�digo
	 * <b> pre: </b> Las listas de sub-categor�as y de libros han sido inicializadas
	 * <b> pos: </b> Se ha agregado una nueva categor�a a la biblioteca
	 * @param codigoCateg C�digo de la categor�a. Cadena num�rica positiva
	 * @param nombre Nombre de la categor�a. nombre != null y nombre != ""
	 * @param descripcion Descripci�n de la categor�a. descripcion != null y descripcion != ""
	 * @param codigoCompuesto C�digo compuesto de la categor�a. Cadena num�rica positiva
	 * @throws BibliotecaException Se lanza una excepci�n si la categor�a ya existe, 
	 *         si no puede ser agregada pues su categor�a padre no existe o la categor�a padre tiene libro registrados
	 */
	public void agregarCategoria(String codigoCateg, String nombre, String descripcion, String codigoCompuesto) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo
	    //AYUDA: utilice el m�todo substring de la clase String, para eliminar un car�cter del par�metro codigoCateg y poder llamar la recursi�n 
	}
	
	/**
	 * Elimina una categor�a a la biblioteca 
	 * <b> pre: </b> La lista de sub-categor�as ha sido inicializada
	 * <b> pos: </b> Se ha eliminado la categor�a de la biblioteca
	 * @param codigoCateg C�digo de la categor�a. Cadena num�rica positiva
	 * @throws BibliotecaException Se lanza si la categor�a no existe
	 */
	public void eliminarCategoria(String codigoCateg) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo
		for ( int i = 0; i <subCategorias.size(); i++)
    	{
    		Categoria hijo = (Categoria)subCategorias.get(i);
    		if(hijo.codigoCompuesto.equalsIgnoreCase(codigoCateg))
    		{
    			if(hijo.esHoja() && hijo.tieneLibrosRepetidos())
    			{
    				subCategorias.remove(i);
    				return;
    			}
    			else
    				throw new BibliotecaException("Categoria no existe");
    		}
    	}
	}
	
	/**
     * Busca un libro con el ISBN dado en la lista de libros de la categor�a actual 
     * <b> pre: </b> La lista de libros ha sido inicializada
     * @param isbn C�digo ISBN del libro a buscar. isbn != null y isbn != ""
     * @return El libro con el c�digo ISBN dado o null en caso de que no exista
     */
    public Libro buscarLibro(String isbn)
    {
        for (int i = 0; i < libros.size(); i++) 
        {
            Libro l = (Libro) libros.get(i);
            if(l.darIsbn().equalsIgnoreCase(isbn))
            {
                return l;
            }
        }
        return null;
    }
    
	/**
	 * Agrega un libro a una categor�a de la biblioteca
	 * <b> pre: </b> Las listas de sub-categor�as y de libros han sido inicializadas
	 * <b> pos: </b> Se ha agregado un nuevo libro a una categor�a de la biblioteca
	 * @param codigoCateg C�digo de la categor�a. Cadena num�rica positiva
	 * @param isbn C�digo ISBN del libro. isbn != null y isbn != ""
	 * @param nombre Nombre del libro. nombre != null y nombre != ""
	 * @param autores Autores del libro. autores != null y autores != ""
	 * @param anioPublicacion A�o de publicaci�n del libro. anioPublicacion > 0
	 * @param editorial Editorial del libro. editorial != null y editorial != ""
	 * @param numPaginas N�mero de p�ginas del libro. numPaginas > 0
	 * @throws BibliotecaException Se lanza una excepci�n si la categor�a del libro no existe, 
	 * si la categor�a del libro no es hoja o si ya existe un libro con el mismo ISBN
	 */
	public void agregarLibro(String codigoCateg, String isbn, String nombre, String autores, 
			int anioPublicacion, String editorial, int numPaginas) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo
		
		for (int i = 0;i<libros.size();i++)
		{
			Categoria hijo = (Categoria)subCategorias.get(i);
			if(buscarLibro(isbn)!=null || hijo.esHoja()==false)
			{
				throw new BibliotecaException("Categoria no existe");
			}
			else 
			{
				Libro nuevo = new Libro(isbn, nombre, autores, anioPublicacion, editorial, numPaginas);
				libros.add(nuevo);
			}
		}
	}
	
	
    
	/**
	 * Elimina un libro de una categor�a de la biblioteca
	 * <b> pre: </b> Las listas de sub-categor�as y de libros han sido inicializadas
	 * <b> pos: </b> Se ha eliminado el libro de una categor�a de la biblioteca
	 * @param codigoCateg C�digo de la categor�a. Cadena num�rica positiva
	 * @param isbn C�digo ISBN del libro. isbn != null y isbn != ""
	 * @throws BibliotecaException Se lanza una excepci�n si la categor�a 
	 * del libro no existe o si el libro no existe
	 */
	public void eliminarLibro(String codigoCateg, String isbn) throws BibliotecaException
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}	
	
	/**
	 * Retorna el n�mero de categor�as de la biblioteca
	 * <b> pre: </b> La lista de sub-categor�as ha sido inicializada
	 * @return N�mero de categor�as de la biblioteca
	 */
	public int darNumCategorias()
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}
	
	/**
	 * Retorna el n�mero de libros de la biblioteca
	 * <b> pre: </b> Las listas de sub-categor�as y de libros han sido inicializadas
	 * @return N�mero de libros de la biblioteca
	 */
	public int darNumLibros()
	{
        //TODO Completar seg�n la documentaci�n del m�todo

	}
	
	/**
     * Agrega los libros de la categor�a � de sus sub-categor�as a la lista dada
     * @param listaLibros La lista de libros donde se agregan los libros. listaLibros != null
     */
    private void agregarLibros( ArrayList listaLibros )
    {
        if( !libros.isEmpty() )
        {
            listaLibros.addAll( libros );
        }
        else
        {
            for( int i = 0; i < subCategorias.size( ); i++ )
            {
                Categoria c = ( Categoria ) subCategorias.get( i );
                c.agregarLibros( listaLibros );
            }
        }
    }
    
	/**
	 * Retorna la lista de libros en una categor�a dada
	 * <b> pre: </b> La lista de libros ha sido inicializada y la categor�a con los libros existe
	 * @param codigoCateg C�digo de la categor�a. Cadena num�rica positiva
	 * @param listaLibros La lista de libros donde se acumula la respuesta. listaLibros != null
	 */
	public void buscarLibros( String codigoCateg, ArrayList listaLibros )
    {
		if(codigoCateg.isEmpty())
		{
			agregarLibros(listaLibros);
		}
		else
		{
			Categoria c = buscarCategoria(codigoCateg.charAt(0));
			c.buscarLibros(codigoCateg.substring(1), listaLibros);
		}
    }
	
    
	/**
	 * Retorna una lista con la categor�a actual y sus sub-categor�as
	 * Las categor�as se agregan en preorden
	 * <b> pre: </b> La lista de sub-categor�as ha sido inicializada 
	 * @param listaCategorias La lista de categor�as donde se acumula la respuesta. listaCategorias != null
	*/
	public void buscarCategoriasPreorden( ArrayList listaCategorias )
    {
        //TODO Completar seg�n la documentaci�n del m�todo

    }
	
	/**
	 * Retorna una lista con la categor�a actual y sus sub-categor�as
	 * Las categor�as se agregan en postorden
	 * <b> pre: </b> La lista de sub-categor�as ha sido inicializada 
	 * @param listaCategorias La lista de categor�as donde se acumula la respuesta. listaCategorias != null
	*/
	public void buscarCategoriasPostorden( ArrayList listaCategorias )
    {
        //TODO Completar seg�n la documentaci�n del m�todo

    }
	
	/**
     * Retorna una cadena con el c�digo compuesto y el nombre de la categor�a
     * @return La representaci�n de la categor�a en String, 
     * si la categor�a no tiene un nombre retorna "Todas las categor�as"
     */
	public String toString()
	{
		return (nombre != null) ? codigoCompuesto + " - " + nombre : "Todas las categor�as";
	}
	
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica la invariante de la clase <br> 
     * <b> inv: </b>
     * subCategorias != null <br>
     * libros != null <br> 
     * Si la categor�a tiene sub-categor�as no puede tener libros <br>
     * No existen libros con el mismo c�digo ISBN <br>
     * Las sub-categor�as se encuentran ordenadas de acuerdo a su c�digo de manera ascendente <br>
     */
    private void verificarInvariante( )
    {
        assert subCategorias != null : "La lista de sub-categor�as debe estar inicializada";
        assert libros != null : "La lista de libros debe estar inicializada";
        if(subCategorias.size() > 0)
        {
        	assert libros.isEmpty() : "La categor�a no deber�a tener libros";
        }
        assert !tieneLibrosRepetidos( ) : "No pueden existir dos libro con el mismo c�digo ISBN";
        
        for (int i = 0; i < subCategorias.size(); i++) 
        {
        	Categoria c1 = (Categoria) subCategorias.get(i);
        	for (int j	= i+1; j < subCategorias.size(); j++) 
            {
        		Categoria c2 = (Categoria) subCategorias.get(j);
        		assert c1.darCodigo() < c2.darCodigo() : "La lista de sub-categor�as no se encuentra ordenada";
    		}
		}
    }

    /**
     * Revisa si la lista de libros tiene libros con el mismo c�digo ISBN <br> 
     * <b>pre:</b> La lista de libros se ha inicializado <br>
     * @return true en caso de encontrar libros con el mismo c�digo ISBN, false en caso contrario.
     */
    private boolean tieneLibrosRepetidos( )
    {
        for( int i = 0; i < libros.size( ); i++ )
        {
            Libro libro1 = ( Libro ) libros.get( i );
            for( int j = i + 1; j < libros.size( ); j++ )
            {
                Libro libro2 = ( Libro ) libros.get( j );
                if( libro1.darIsbn().equals( libro2.darIsbn() ) )
                {
                    return true;
                }
            }
        }
        return false;
    }
}