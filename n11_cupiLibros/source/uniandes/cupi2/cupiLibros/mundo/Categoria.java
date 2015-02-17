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
import java.util.ArrayList;

/**
 * Clase que representa una Categoría de la biblioteca
 * <b> inv: </b>
 * subCategorias != null
 * libros != null
 * Si la categoría tiene sub-categorías no puede tener libros
 * No existen libros con el mismo código ISBN
 * Las sub-categorías se encuentran ordenadas de acuerdo a su código de manera ascendente
 */
public class Categoria implements Serializable
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
	
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * El código de la Categoría
	 */
	private char codigo; 

	/**
	 * El código compuesto de la Categoría
	 */
	private String codigoCompuesto;
	
	/**
	 * El nombre de la Categoría
	 */
	private String nombre; 
	
	/**
	 * La descripción de Categoría
	 */
	private String descripcion; 
		
	/**
	 * Lista de las sub-categorías de la Categoría
	 */
	private ArrayList subCategorias; 
	
	/**
	 * Lista con los libros de la Categoría
	 */
	private ArrayList libros; 
	
	//-------------------------------------------------------------
	// Método Constructor
	//-------------------------------------------------------------
	
	/**
     * Construye una categoría vacía. 
     * <b> post: </b> Se inicializa el código en 0, 
     * el nombre, la descripción en null y el codigoCompuesto vacío
     * y las listas de sub-categorías y libros se inicializan vacías.
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
	 * Construye una Categoría. Inicializa sus atributos con los parámetros dados.
	 * Las listas de sub-categorías y libros se inicializan vacías. 
	 * @param codigoP Código de la categoría. 9 >= codigoP >= 0
	 * @param nombreP Nombre de la categoría. nombreP != null y nombreP!= ""
	 * @param descripcionP Descripción de la categoría. descripcionP != null y descripcionP != ""
	 * @param codigoCompuestoP Código compuesto de la categoría. Cadena numérica positiva
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
	// Métodos
	//-------------------------------------------------------------
	
	/**
	 * Devuelve el nombre de la Categoría
	 * @return Nombre de la Categoría
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * Devuelve el código de la Categoría
	 * @return Código de la Categoría
	 */
	public char darCodigo()
	{
		return codigo;
	}
	
	/**
	 * Devuelve la descripción de la Categoría
	 * @return Descripción de la Categoría
	 */
	public String darDescripcion()
	{
		return descripcion;
	}
	
	/**
	 * Devuelve el código compuesto de la Categoría
	 * @return Código compuesto de la Categoría
	 */
	public String darCodigoCompuesto()
	{
		return codigoCompuesto;
	}
	
	/**
	 * Devuelve la lista de sub-categorías de la Categoría
	 * @return Lista de sub-categorías de la Categoría
	 */
	public ArrayList darSubCategorias()
	{
		return subCategorias;
	}
	
	/**
	 * Devuelve la lista de libros de la Categoría
	 * @return Lista de libros de la Categoría
	 */
	public ArrayList darLibros()
	{
		return libros;
	}
	   
    /**
     * Indica si la categoría es hoja
     * Una categoría es hoja si no tiene sub-categorías
     * <b> pre: </b> La lista de sub-categorías ha sido inicializada
     * @return True si es hoja, false en caso contrario
     */
    private boolean esHoja()
    {
        return subCategorias.isEmpty();
    }
	
	/**
     * Busca una categoría con el código dado en la lista de sub-categorías de la categoría actual 
     * <b> pre: </b> La lista de sub-categorías ha sido inicializada
     * @param codigo Código de la categoría a buscar. 9 >= codigo >= 0
     * @return La categoría con el código dado o null en caso de que no exista
     */
    public Categoria buscarCategoria(char codigo)
    {
        //TODO Completar según la documentación del método
        //AYUDA: Solo realiza la búsqueda en la lista de las sub categorías inmediatas (Hijas), no realiza recursión
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
     * Crea una categoría y la agrega a la lista de sub-categorías de la categoría actual
     * La categoría debe ser insertada en orden ascendente de acuerdo a su código
     * <b> pre: </b> Las listas de sub-categorías ha sido inicializada
     * <b> pos: </b> Se ha agregado una nueva categoría a la categoría actual
     * @param codigoCateg Código de la categoría. 9 >= codigoCateg >= 0
     * @param nombre Nombre de la categoría. nombre != null y nombre != ""
     * @param descripcion Descripción de la categoría. descripcion != null y descripcion != ""
     * @param codigoCompuesto Código compuesto de la categoría. Cadena numérica positiva
     */
    public void agregarCategoriaOrdenada(char codigoCateg, String nombre, String descripcion, String codigoCompuesto)
    {
        //TODO Completar según la documentación del método
    	
    	Categoria nueva = new Categoria(codigoCateg, nombre, descripcion, codigoCompuesto);
    	subCategorias.add(nueva);
    }
	/**
	 * Agrega una nueva categoría a la biblioteca de acuerdo 
	 * del sistema de clasificación decimal de Dewey (Ver documento de descripción)
	 * La categoría debe ser insertada en orden ascendente de acuerdo a su código
	 * <b> pre: </b> Las listas de sub-categorías y de libros han sido inicializadas
	 * <b> pos: </b> Se ha agregado una nueva categoría a la biblioteca
	 * @param codigoCateg Código de la categoría. Cadena numérica positiva
	 * @param nombre Nombre de la categoría. nombre != null y nombre != ""
	 * @param descripcion Descripción de la categoría. descripcion != null y descripcion != ""
	 * @param codigoCompuesto Código compuesto de la categoría. Cadena numérica positiva
	 * @throws BibliotecaException Se lanza una excepción si la categoría ya existe, 
	 *         si no puede ser agregada pues su categoría padre no existe o la categoría padre tiene libro registrados
	 */
	public void agregarCategoria(String codigoCateg, String nombre, String descripcion, String codigoCompuesto) throws BibliotecaException
	{
        //TODO Completar según la documentación del método
	    //AYUDA: utilice el método substring de la clase String, para eliminar un carácter del parámetro codigoCateg y poder llamar la recursión 
	}
	
	/**
	 * Elimina una categoría a la biblioteca 
	 * <b> pre: </b> La lista de sub-categorías ha sido inicializada
	 * <b> pos: </b> Se ha eliminado la categoría de la biblioteca
	 * @param codigoCateg Código de la categoría. Cadena numérica positiva
	 * @throws BibliotecaException Se lanza si la categoría no existe
	 */
	public void eliminarCategoria(String codigoCateg) throws BibliotecaException
	{
        //TODO Completar según la documentación del método
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
     * Busca un libro con el ISBN dado en la lista de libros de la categoría actual 
     * <b> pre: </b> La lista de libros ha sido inicializada
     * @param isbn Código ISBN del libro a buscar. isbn != null y isbn != ""
     * @return El libro con el código ISBN dado o null en caso de que no exista
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
	 * Agrega un libro a una categoría de la biblioteca
	 * <b> pre: </b> Las listas de sub-categorías y de libros han sido inicializadas
	 * <b> pos: </b> Se ha agregado un nuevo libro a una categoría de la biblioteca
	 * @param codigoCateg Código de la categoría. Cadena numérica positiva
	 * @param isbn Código ISBN del libro. isbn != null y isbn != ""
	 * @param nombre Nombre del libro. nombre != null y nombre != ""
	 * @param autores Autores del libro. autores != null y autores != ""
	 * @param anioPublicacion Año de publicación del libro. anioPublicacion > 0
	 * @param editorial Editorial del libro. editorial != null y editorial != ""
	 * @param numPaginas Número de páginas del libro. numPaginas > 0
	 * @throws BibliotecaException Se lanza una excepción si la categoría del libro no existe, 
	 * si la categoría del libro no es hoja o si ya existe un libro con el mismo ISBN
	 */
	public void agregarLibro(String codigoCateg, String isbn, String nombre, String autores, 
			int anioPublicacion, String editorial, int numPaginas) throws BibliotecaException
	{
        //TODO Completar según la documentación del método
		
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
	 * Elimina un libro de una categoría de la biblioteca
	 * <b> pre: </b> Las listas de sub-categorías y de libros han sido inicializadas
	 * <b> pos: </b> Se ha eliminado el libro de una categoría de la biblioteca
	 * @param codigoCateg Código de la categoría. Cadena numérica positiva
	 * @param isbn Código ISBN del libro. isbn != null y isbn != ""
	 * @throws BibliotecaException Se lanza una excepción si la categoría 
	 * del libro no existe o si el libro no existe
	 */
	public void eliminarLibro(String codigoCateg, String isbn) throws BibliotecaException
	{
        //TODO Completar según la documentación del método

	}	
	
	/**
	 * Retorna el número de categorías de la biblioteca
	 * <b> pre: </b> La lista de sub-categorías ha sido inicializada
	 * @return Número de categorías de la biblioteca
	 */
	public int darNumCategorias()
	{
        //TODO Completar según la documentación del método

	}
	
	/**
	 * Retorna el número de libros de la biblioteca
	 * <b> pre: </b> Las listas de sub-categorías y de libros han sido inicializadas
	 * @return Número de libros de la biblioteca
	 */
	public int darNumLibros()
	{
        //TODO Completar según la documentación del método

	}
	
	/**
     * Agrega los libros de la categoría ó de sus sub-categorías a la lista dada
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
	 * Retorna la lista de libros en una categoría dada
	 * <b> pre: </b> La lista de libros ha sido inicializada y la categoría con los libros existe
	 * @param codigoCateg Código de la categoría. Cadena numérica positiva
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
	 * Retorna una lista con la categoría actual y sus sub-categorías
	 * Las categorías se agregan en preorden
	 * <b> pre: </b> La lista de sub-categorías ha sido inicializada 
	 * @param listaCategorias La lista de categorías donde se acumula la respuesta. listaCategorias != null
	*/
	public void buscarCategoriasPreorden( ArrayList listaCategorias )
    {
        //TODO Completar según la documentación del método

    }
	
	/**
	 * Retorna una lista con la categoría actual y sus sub-categorías
	 * Las categorías se agregan en postorden
	 * <b> pre: </b> La lista de sub-categorías ha sido inicializada 
	 * @param listaCategorias La lista de categorías donde se acumula la respuesta. listaCategorias != null
	*/
	public void buscarCategoriasPostorden( ArrayList listaCategorias )
    {
        //TODO Completar según la documentación del método

    }
	
	/**
     * Retorna una cadena con el código compuesto y el nombre de la categoría
     * @return La representación de la categoría en String, 
     * si la categoría no tiene un nombre retorna "Todas las categorías"
     */
	public String toString()
	{
		return (nombre != null) ? codigoCompuesto + " - " + nombre : "Todas las categorías";
	}
	
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica la invariante de la clase <br> 
     * <b> inv: </b>
     * subCategorias != null <br>
     * libros != null <br> 
     * Si la categoría tiene sub-categorías no puede tener libros <br>
     * No existen libros con el mismo código ISBN <br>
     * Las sub-categorías se encuentran ordenadas de acuerdo a su código de manera ascendente <br>
     */
    private void verificarInvariante( )
    {
        assert subCategorias != null : "La lista de sub-categorías debe estar inicializada";
        assert libros != null : "La lista de libros debe estar inicializada";
        if(subCategorias.size() > 0)
        {
        	assert libros.isEmpty() : "La categoría no debería tener libros";
        }
        assert !tieneLibrosRepetidos( ) : "No pueden existir dos libro con el mismo código ISBN";
        
        for (int i = 0; i < subCategorias.size(); i++) 
        {
        	Categoria c1 = (Categoria) subCategorias.get(i);
        	for (int j	= i+1; j < subCategorias.size(); j++) 
            {
        		Categoria c2 = (Categoria) subCategorias.get(j);
        		assert c1.darCodigo() < c2.darCodigo() : "La lista de sub-categorías no se encuentra ordenada";
    		}
		}
    }

    /**
     * Revisa si la lista de libros tiene libros con el mismo código ISBN <br> 
     * <b>pre:</b> La lista de libros se ha inicializado <br>
     * @return true en caso de encontrar libros con el mismo código ISBN, false en caso contrario.
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