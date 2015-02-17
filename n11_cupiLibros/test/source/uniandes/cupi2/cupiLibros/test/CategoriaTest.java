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
package uniandes.cupi2.cupiLibros.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.cupiLibros.mundo.BibliotecaException;
import uniandes.cupi2.cupiLibros.mundo.Categoria;
import uniandes.cupi2.cupiLibros.mundo.Libro;

/**
 * Clase usada para verificar la correcta implementaci�n de la clase Categor�a
 */
public class CategoriaTest  extends TestCase  {
	
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
	/**
	 * La Categor�a de pruebas
	 */
	private Categoria categoria; 
		
	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------
	
	/**
	 * Crea una nueva categor�a sin sub-categor�as y libros
	 */
	public void setupEscenario1()
	{
		categoria = new Categoria('1', "Categoria", "Descripcion", "1");
	}
	
	/**
	 * Crea una nueva categor�a con sub-categor�as
	 */
	public void setupEscenario2()
	{
		categoria = new Categoria('1', "Categoria Papa", "Descripcion", "1");
		try 
		{
			categoria.agregarCategoria("1", "Hijo 1", "Hijo", "11");
			categoria.agregarCategoria("5", "Hijo 2", "Hijo", "15");
			categoria.agregarCategoria("4", "Hijo 3", "Hijo", "14");
			categoria.agregarCategoria("2", "Hijo 4", "Hijo", "12");
			categoria.agregarCategoria("3", "Hijo 5", "Hijo", "13");
			
			categoria.agregarCategoria("32", "Nieto 1", "Nieto", "132");
		}
		catch (BibliotecaException e)
		{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
	}
	
	/**
	 * Crea una nueva categor�a con libros
	 */
	public void setupEscenario3()
	{
		categoria = new Categoria('1', "Categoria Hoja", "Descripcion", "1");
		try
		{
			categoria.agregarLibro("", "1.A", "Libro 1", "Autores", 2011, "Editorial", 10);
			categoria.agregarLibro("", "1.B", "Libro 2", "Autores", 2011, "Editorial", 10);
			categoria.agregarLibro("", "1.C", "Libro 3", "Autores", 2011, "Editorial", 10);
		} 
		catch (BibliotecaException e) 
		{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
	}
	
	/**
     * Prueba 1 - Prueba el m�todo constructor de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * Categoria, darCodigo, darNombre, darDescripcion, darCodigoCompuesto, darSubCategorias, darLibros. <br>
     * <b> Objetivo: </b> Probar que el m�todo constructor inicialice correctamente los atributos de la categor�a. <br>
     */
    public void testCategoria( )
    {
    	setupEscenario1();
    	
    	assertEquals("El c�digo de la categor�a no fue inicializado correctamente", '1' , categoria.darCodigo());
    	assertNotNull("El nombre de la categor�a no fue inicializado", categoria.darNombre());
    	assertEquals("El nombre de la categor�a no fue inicializado correctamente", "Categoria" , categoria.darNombre());
    	assertNotNull("La descripci�n de la categor�a no fue inicializada", categoria.darDescripcion());
    	assertEquals("La descripci�n de la categor�a no fue inicializada correctamente", "Descripcion", categoria.darDescripcion());
    	assertNotNull("El c�digo compuesto de la categor�a no fue inicializado", categoria.darCodigoCompuesto());
    	assertEquals("El c�digo compuesto de la categor�a no fue inicializado correctamente", "1", categoria.darCodigoCompuesto());
    	assertNotNull("La lista de sub-categor�as no fue inicializada", categoria.darSubCategorias());
    	assertNotNull("La lista de libros no fue inicializada", categoria.darLibros());
    }
		
    /**
     * Prueba 2 - Prueba el m�todo agregarCategoriaOrdenada. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarCategoriaOrdenada <br>
     * <b> Objetivo: </b> Probar que el m�todo agrega sub-categor�as ordenadas por c�digo ascendentemente
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a no tiene sub-categor�as
     * 2. La categor�a tiene 1 sub-categor�a, y se debe agregar una sub-categor�a anterior a la existente
     * 3. La categor�a tiene 2 sub-categor�as, y se debe agregar una sub-categor�a entre las existentes
     * 4. La categor�a tiene 3 sub-categor�a, y se debe agregar una sub-categor�a siguiente a la existentes
    */
    public void testAgregarCategoriaOrdenada()
	{
		setupEscenario1();
		
		categoria.agregarCategoriaOrdenada('2', "Hija 1", "Descripcion 1", "12");
		assertEquals("No se agrego la categor�a", 1, categoria.darSubCategorias().size());
		Categoria c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("El c�digo de la categor�a no es correcto", '2' , c.darCodigo());
    	assertEquals("El nombre de la categor�a no es correcto", "Hija 1" , c.darNombre());
    	assertEquals("La descripci�n de la categor�a no es correcta", "Descripcion 1", c.darDescripcion());
    	assertEquals("El c�digo compuesto de la categor�a no es correcto", "12", c.darCodigoCompuesto());
		
		categoria.agregarCategoriaOrdenada('0', "Hija 2", "Descripcion 2", "10");
		assertEquals("No se agrego la categor�a", 2, categoria.darSubCategorias().size());
		c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '0', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(1);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '2', c.darCodigo());
		
		categoria.agregarCategoriaOrdenada('1', "Hija 3", "Descripcion 3", "11");
		assertEquals("No se agrego la categor�a", 3, categoria.darSubCategorias().size());
		c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '0', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(1);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '1', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(2);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '2', c.darCodigo());
		
		categoria.agregarCategoriaOrdenada('3', "Hija 4", "Descripcion 4", "13");
		assertEquals("No se agrego la categor�a", 4, categoria.darSubCategorias().size());
		c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '0', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(1);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '1', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(2);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '2', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(3);
		assertEquals("La categor�a se agreg� en una posici�n incorrecta", '3', c.darCodigo());
	}
    
    /**
     * Prueba 3 - Prueba el m�todo agregarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarCategoria <br>
     * <b> Objetivo: </b> Probar que el m�todo agrega nuevas categor�as
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a no tiene sub-categor�as
     * 2. La categor�a tiene 1 sub-categor�a, en la que se va a agregar una categor�a
    */
    public void testAgregarCategoria()
    {
    	setupEscenario1();
    	
    	try 
    	{
			categoria.agregarCategoria("2", "Hija 1", "Descripcion 1", "12");
			assertEquals("No se agrego la categor�a", 1, categoria.darSubCategorias().size());
			Categoria c = (Categoria) categoria.darSubCategorias().get(0);
			assertEquals("El c�digo de la categor�a no es correcto", '2' , c.darCodigo());
	    	assertEquals("El nombre de la categor�a no es correcto", "Hija 1" , c.darNombre());
	    	assertEquals("La descripci�n de la categor�a no es correcta", "Descripcion 1", c.darDescripcion());
	    	assertEquals("El c�digo compuesto de la categor�a no es correcto", "12", c.darCodigoCompuesto());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
    	
    	try 
    	{
			categoria.agregarCategoria("21", "Nieta 1", "Descripcion 2", "121");
			assertEquals("La categor�a no se agrego correctamente", 1, categoria.darSubCategorias().size());
			Categoria c = (Categoria) categoria.darSubCategorias().get(0);
			assertEquals("No se agrego la categor�a", 1, c.darSubCategorias().size());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 4 - Prueba el m�todo agregarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarCategoria <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agregar una categor�a existente
     * 2. Se intenta agregar una categor�a cuya categor�a padre no existe
     */
    public void testAgregarCategoriaError()
    {
    	setupEscenario2();
    	
    	try
    	{
			categoria.agregarCategoria("1", "Hijo", "Hijo", "11");
			fail("No deber�a agregar la categor�a pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    	
    	try
    	{
			categoria.agregarCategoria("61", "Hijo", "Hijo", "11");
			fail("No deber�a agregar la categor�a pues su categor�a padre no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    }
    
    /**
     * Prueba 5 - Prueba el m�todo agregarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarCategoria <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agregar una sub-categor�a a una categor�a con libros registrados
     */
    public void testAgregarCategoriaError2()
    {
    	setupEscenario3();
    	
    	try
    	{
			categoria.agregarCategoria("61", "Hijo", "Hijo", "11");
			fail("No deber�a agregar la categor�a pues su categor�a padre tiene libros registrados");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    }	
    
    /**
     * Prueba 6 - Prueba el m�todo eliminarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCategoria <br>
     * <b> Objetivo: </b> Probar que el m�todo elimina categor�as
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a tiene sub-categor�as, una de ellas va a ser eliminada
     * 2. Se va a eliminar una categor�a de una sub-categor�a
     */
    public void testEliminarCategoria()
    {
    	setupEscenario2();
    	
    	try 
    	{
			categoria.eliminarCategoria("1");
			assertEquals("La categor�a no fue eliminada", 4, categoria.darSubCategorias().size());
			Categoria c = categoria.buscarCategoria('1');
			assertNull("La categor�a no fue eliminada", c);
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se deber�a generar el error: " + e.getMessage());
		}
    	
    	try 
    	{
			categoria.eliminarCategoria("32");
			assertEquals("La categor�a no fue eliminada correctamente", 4, categoria.darSubCategorias().size());
			Categoria c = categoria.buscarCategoria('3');
			assertEquals("La categor�a no fue eliminada", 0, c.darSubCategorias().size());
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 7 - Prueba el m�todo eliminarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCategoria <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar una categor�a que no existe
     */
	public void testEliminarCategoriaError()
	{
		setupEscenario2();
    	
    	try
    	{
			categoria.eliminarCategoria("6");
			fail("No deber�a eliminar la categor�a por que no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 8 - Prueba el m�todo agregarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo agrega libros
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a no tiene sub-categor�as
     */
	public void testAgregarLibro()
	{
		setupEscenario1();
    	
    	try 
    	{
			categoria.agregarLibro("", "1.A0", "nombre", "autores", 2011, "editorial", 100);
			assertEquals("No se agrego el libro a la categor�a", 1, categoria.darLibros().size());
			Libro libro = (Libro) categoria.darLibros().get(0);
			assertEquals("El ISBN del libro no es correcto", "1.A0", libro.darIsbn());
	    	assertEquals("El nombre del libro no es correcto", "nombre", libro.darNombre());

		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
	}
	
	/**
     * Prueba 9 - Prueba el m�todo agregarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo agrega libros
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a no tiene sub-categor�as y se agrega el libro a una sub-categor�a
     */
	public void testAgregarLibro2()
	{
    	setupEscenario2();
    	
    	try 
    	{
    		categoria.agregarLibro("1", "11.A0", "nombre", "autores", 2011, "editorial", 100);
    		Categoria c = categoria.buscarCategoria('1');
    		assertEquals("No se agrego el libro a la categor�a", 1, c.darLibros().size());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
	}
	
	/**
     * Prueba 10 - Prueba el m�todo agregarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a del libro no existe
     * 2. La categor�a del libro no es una hoja
     */
	public void testAgregarLibroError()
	{
		setupEscenario2();
    	
    	try
    	{
    		categoria.agregarLibro("35", "135.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No deber�a agregar el libro pues su categor�a no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    	
    	try
    	{
    		categoria.agregarLibro("", "1.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No deber�a agregar el libro pues su categor�a no es hoja");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 11 - Prueba el m�todo agregarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agrega un libro que ya existe
     */
	public void testAgregarLibroError2()
	{
		setupEscenario3();
    	
    	try
    	{
    		categoria.agregarLibro("", "1.A", "nombre", "autores", 2011, "editorial", 100);
			fail("No deber�a agregar el libro pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 12 - Prueba el m�todo eliminarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo elimina libros
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a tiene libros, uno de ellos va a ser eliminado
     */
	public void testEliminarLibro()
    {
    	setupEscenario3();
    	
    	try 
    	{
			categoria.eliminarLibro("", "1.A");
			assertEquals("El libro no fue eliminado", 2, categoria.darLibros().size());
			Libro libro = categoria.buscarLibro("1.A");
			assertNull("El libro no fue eliminado", libro);
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
	
	/**
     * Prueba 13 - Prueba el m�todo eliminarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibro, agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo elimina libros
     * <b> Casos de prueba: </b> <br>
     * 1. Se va a eliminar un libro de una sub-categor�a
     */
    public void testEliminarLibro2()
    {
    	setupEscenario2();
    	
    	try 
    	{
    		categoria.agregarLibro("2", "12.A", "nombre", "autores", 2011, "editorial", 100);
    		categoria.eliminarLibro("2", "12.A");
    		Categoria c = categoria.buscarCategoria('2');
    		assertEquals("El libro no fue eliminado", 0, c.darLibros().size());
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 14 - Prueba el m�todo eliminarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. La categor�a del libro no existe
     */
    public void testEliminarLibroError()
	{
		setupEscenario2();
    	
    	try
    	{
			categoria.eliminarLibro("12", "12.A");
			fail("No deber�a eliminar el libro pues su categor�a no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
    /**
     * Prueba 15 - Prueba el m�todo eliminarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar un libro que no existe
     */
	public void testEliminarLibroError2()
	{
		setupEscenario3();
    	
    	try
    	{
    		categoria.eliminarLibro("", "1.Aa");
			fail("No deber�a eliminar el libro pues no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 16 - Prueba el m�todo buscarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarCategoria <br>
     * <b> Objetivo: </b> Probar que el m�todo busque correctamente la categor�a
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca una categor�a existente
     * 2. Se busca una categor�a que no existe
     */
	public void testBuscarCategoria()
	{
		setupEscenario2();
		
		Categoria c = categoria.buscarCategoria('3');
		assertNotNull("La categor�a no deber�a ser nula", c);
		assertEquals("La categor�a no es correcta", '3', c.darCodigo());
		
		c = categoria.buscarCategoria('7');
		assertNull("La categor�a deber�a ser nula", c);
	}

	/**
     * Prueba 17 - Prueba el m�todo buscarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo busque correctamente los libros
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca un libro existente
     * 2. Se busca un libro que no existe
     */
	public void testBuscarLibro()
	{
		setupEscenario3();
		
		Libro l = categoria.buscarLibro("1.A");
		assertNotNull("El libro no deber�a ser nulo", l);
		assertEquals("El libro no es correcto", "1.A", l.darIsbn());
		
		l = categoria.buscarLibro("1.Z");
		assertNull("El libro deber�a ser nulo", l);
	}

	/**
     * Prueba 18 - Prueba el m�todo darNumCategorias. <br>
     * <b> M�todos a probar: </b> <br>
     * darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el m�todo calcula correctamente el n�mero de categor�as
     */
	public void testDarNumCategorias()
	{
		setupEscenario2();
		int numCategorias = categoria.darNumCategorias();
		assertEquals("El n�mero de categor�as no es calculado correctamente", 6, numCategorias);
	}
	
	/**
     * Prueba 19 - Prueba el m�todo darNumLibros. <br>
     * <b> M�todos a probar: </b> <br>
     * darNumLibros <br>
     * <b> Objetivo: </b> Probar que el m�todo calcula correctamente el n�mero de libros
     */
	public void testDarNumLibros()
	{
		setupEscenario3();
		int numLibros = categoria.darNumLibros();
		assertEquals("El n�mero de libros no es calculado correctamente", 3, numLibros);
	}
	
	/**
     * Prueba 20 - Prueba el m�todo darNumLibros. <br>
     * <b> M�todos a probar: </b> <br>
     * darNumLibros, agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo calcula correctamente el n�mero de libros
     */
	public void testDarNumLibros2()
	{
		setupEscenario2();
		try 
		{
			categoria.agregarLibro("1", "11.A0", "nombre", "autores", 2011, "editorial", 100);
			categoria.agregarLibro("1", "11.A1", "nombre", "autores", 2011, "editorial", 100);
		} 
		catch (BibliotecaException e) 
		{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
		
		int numLibros = categoria.darNumLibros();
		assertEquals("El n�mero de libros no es calculado correctamente", 2, numLibros);
	}
	
	/**
     * Prueba 21 - Prueba el m�todo buscarLibros. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarLibros <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de libros en una categor�a
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca la lista de libros de una categor�a hoja
     */
	public void testBuscarLibros()
	{
		setupEscenario3();
		
		ArrayList listaLibros = new ArrayList();
		categoria.buscarLibros("", listaLibros);
		assertEquals("El n�mero de libros encontrados no es correcto", 3, listaLibros.size());
	}
	
	/**
     * Prueba 22 - Prueba el m�todo buscarLibros. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarLibros, agregarLibro <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de libros en una categor�a
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca la lista de libros de una categor�a con sub-categor�as
     */
	public void testBuscarLibros2()
	{
		setupEscenario2();
		try 
		{
			categoria.agregarLibro("1", "11.A0", "nombre", "autores", 2011, "editorial", 100);
			categoria.agregarLibro("32", "132.A0", "nombre", "autores", 2011, "editorial", 100);
		} 
		catch (BibliotecaException e) 
		{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
		
		ArrayList listaLibros = new ArrayList();
		categoria.buscarLibros("", listaLibros);
		assertEquals("El n�mero de libros encontrados no es correcto", 2, listaLibros.size());
	}
	
	/**
     * Prueba 23 - Prueba el m�todo buscarCategoriasPreorden. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarCategoriasPreorden <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de categor�as organizadas en preorden
     */
	public void testBuscarCategoriasPreorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = new ArrayList();
		categoria.buscarCategoriasPreorden( listaCategorias );
		
		assertEquals("El n�mero de categor�as encontradas no es correcto", 7, listaCategorias.size());
		
		for (int i = 0; i < listaCategorias.size(); i++) 
		{
			Categoria c1 = (Categoria) listaCategorias.get(i);
			for (int j = i+1; j < listaCategorias.size(); j++) 
			{
				Categoria c2 = (Categoria) listaCategorias.get(j);
				assertTrue("Las categor�as no fueron ordenadas correctamente", c1.darCodigoCompuesto().compareTo(c2.darCodigoCompuesto()) < 0);
			}
		}
    }
	
	/**
     * Prueba 24 - Prueba el m�todo buscarCategoriasPostorden. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarCategoriasPostorden <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de categor�as organizadas en postorden
     */
	public void testBuscarCategoriasPostorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = new ArrayList();
		categoria.buscarCategoriasPostorden( listaCategorias );
		
		assertEquals("El n�mero de categor�as encontradas no es correcto", 7, listaCategorias.size());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "11", ((Categoria)listaCategorias.get(0)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "12", ((Categoria)listaCategorias.get(1)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "132", ((Categoria)listaCategorias.get(2)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "13", ((Categoria)listaCategorias.get(3)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "14", ((Categoria)listaCategorias.get(4)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "15", ((Categoria)listaCategorias.get(5)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "1", ((Categoria)listaCategorias.get(6)).darCodigoCompuesto());
    }
	
		
	/**
     * Prueba 25 - Prueba el m�todo toString. <br>
     * <b> M�todos a probar: </b> <br>
     * toString <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne el c�digo compuesto - nombre de la categor�a
     */
	public void testToString()
	{
		setupEscenario1();
		assertEquals("La representa String de la categor�a no es correcta", "1 - Categoria", categoria.toString());
	}
}