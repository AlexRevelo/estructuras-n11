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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.cupiLibros.mundo.BibliotecaException;
import uniandes.cupi2.cupiLibros.mundo.Categoria;
import uniandes.cupi2.cupiLibros.mundo.Libro;

/**
 * Clase usada para verificar la correcta implementación de la clase Categoría
 */
public class CategoriaTest  extends TestCase  {
	
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
	/**
	 * La Categoría de pruebas
	 */
	private Categoria categoria; 
		
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
	
	/**
	 * Crea una nueva categoría sin sub-categorías y libros
	 */
	public void setupEscenario1()
	{
		categoria = new Categoria('1', "Categoria", "Descripcion", "1");
	}
	
	/**
	 * Crea una nueva categoría con sub-categorías
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
			fail("No se debería generar el error: " + e.getMessage());
		}
	}
	
	/**
	 * Crea una nueva categoría con libros
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
			fail("No se debería generar el error: " + e.getMessage());
		}
	}
	
	/**
     * Prueba 1 - Prueba el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Categoria, darCodigo, darNombre, darDescripcion, darCodigoCompuesto, darSubCategorias, darLibros. <br>
     * <b> Objetivo: </b> Probar que el método constructor inicialice correctamente los atributos de la categoría. <br>
     */
    public void testCategoria( )
    {
    	setupEscenario1();
    	
    	assertEquals("El código de la categoría no fue inicializado correctamente", '1' , categoria.darCodigo());
    	assertNotNull("El nombre de la categoría no fue inicializado", categoria.darNombre());
    	assertEquals("El nombre de la categoría no fue inicializado correctamente", "Categoria" , categoria.darNombre());
    	assertNotNull("La descripción de la categoría no fue inicializada", categoria.darDescripcion());
    	assertEquals("La descripción de la categoría no fue inicializada correctamente", "Descripcion", categoria.darDescripcion());
    	assertNotNull("El código compuesto de la categoría no fue inicializado", categoria.darCodigoCompuesto());
    	assertEquals("El código compuesto de la categoría no fue inicializado correctamente", "1", categoria.darCodigoCompuesto());
    	assertNotNull("La lista de sub-categorías no fue inicializada", categoria.darSubCategorias());
    	assertNotNull("La lista de libros no fue inicializada", categoria.darLibros());
    }
		
    /**
     * Prueba 2 - Prueba el método agregarCategoriaOrdenada. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCategoriaOrdenada <br>
     * <b> Objetivo: </b> Probar que el método agrega sub-categorías ordenadas por código ascendentemente
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría no tiene sub-categorías
     * 2. La categoría tiene 1 sub-categoría, y se debe agregar una sub-categoría anterior a la existente
     * 3. La categoría tiene 2 sub-categorías, y se debe agregar una sub-categoría entre las existentes
     * 4. La categoría tiene 3 sub-categoría, y se debe agregar una sub-categoría siguiente a la existentes
    */
    public void testAgregarCategoriaOrdenada()
	{
		setupEscenario1();
		
		categoria.agregarCategoriaOrdenada('2', "Hija 1", "Descripcion 1", "12");
		assertEquals("No se agrego la categoría", 1, categoria.darSubCategorias().size());
		Categoria c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("El código de la categoría no es correcto", '2' , c.darCodigo());
    	assertEquals("El nombre de la categoría no es correcto", "Hija 1" , c.darNombre());
    	assertEquals("La descripción de la categoría no es correcta", "Descripcion 1", c.darDescripcion());
    	assertEquals("El código compuesto de la categoría no es correcto", "12", c.darCodigoCompuesto());
		
		categoria.agregarCategoriaOrdenada('0', "Hija 2", "Descripcion 2", "10");
		assertEquals("No se agrego la categoría", 2, categoria.darSubCategorias().size());
		c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("La categoría se agregó en una posición incorrecta", '0', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(1);
		assertEquals("La categoría se agregó en una posición incorrecta", '2', c.darCodigo());
		
		categoria.agregarCategoriaOrdenada('1', "Hija 3", "Descripcion 3", "11");
		assertEquals("No se agrego la categoría", 3, categoria.darSubCategorias().size());
		c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("La categoría se agregó en una posición incorrecta", '0', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(1);
		assertEquals("La categoría se agregó en una posición incorrecta", '1', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(2);
		assertEquals("La categoría se agregó en una posición incorrecta", '2', c.darCodigo());
		
		categoria.agregarCategoriaOrdenada('3', "Hija 4", "Descripcion 4", "13");
		assertEquals("No se agrego la categoría", 4, categoria.darSubCategorias().size());
		c = (Categoria) categoria.darSubCategorias().get(0);
		assertEquals("La categoría se agregó en una posición incorrecta", '0', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(1);
		assertEquals("La categoría se agregó en una posición incorrecta", '1', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(2);
		assertEquals("La categoría se agregó en una posición incorrecta", '2', c.darCodigo());
		c = (Categoria) categoria.darSubCategorias().get(3);
		assertEquals("La categoría se agregó en una posición incorrecta", '3', c.darCodigo());
	}
    
    /**
     * Prueba 3 - Prueba el método agregarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCategoria <br>
     * <b> Objetivo: </b> Probar que el método agrega nuevas categorías
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría no tiene sub-categorías
     * 2. La categoría tiene 1 sub-categoría, en la que se va a agregar una categoría
    */
    public void testAgregarCategoria()
    {
    	setupEscenario1();
    	
    	try 
    	{
			categoria.agregarCategoria("2", "Hija 1", "Descripcion 1", "12");
			assertEquals("No se agrego la categoría", 1, categoria.darSubCategorias().size());
			Categoria c = (Categoria) categoria.darSubCategorias().get(0);
			assertEquals("El código de la categoría no es correcto", '2' , c.darCodigo());
	    	assertEquals("El nombre de la categoría no es correcto", "Hija 1" , c.darNombre());
	    	assertEquals("La descripción de la categoría no es correcta", "Descripcion 1", c.darDescripcion());
	    	assertEquals("El código compuesto de la categoría no es correcto", "12", c.darCodigoCompuesto());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se debería generar el error: " + e.getMessage());
		}
    	
    	try 
    	{
			categoria.agregarCategoria("21", "Nieta 1", "Descripcion 2", "121");
			assertEquals("La categoría no se agrego correctamente", 1, categoria.darSubCategorias().size());
			Categoria c = (Categoria) categoria.darSubCategorias().get(0);
			assertEquals("No se agrego la categoría", 1, c.darSubCategorias().size());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se debería generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 4 - Prueba el método agregarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCategoria <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agregar una categoría existente
     * 2. Se intenta agregar una categoría cuya categoría padre no existe
     */
    public void testAgregarCategoriaError()
    {
    	setupEscenario2();
    	
    	try
    	{
			categoria.agregarCategoria("1", "Hijo", "Hijo", "11");
			fail("No debería agregar la categoría pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    	
    	try
    	{
			categoria.agregarCategoria("61", "Hijo", "Hijo", "11");
			fail("No debería agregar la categoría pues su categoría padre no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    }
    
    /**
     * Prueba 5 - Prueba el método agregarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCategoria <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agregar una sub-categoría a una categoría con libros registrados
     */
    public void testAgregarCategoriaError2()
    {
    	setupEscenario3();
    	
    	try
    	{
			categoria.agregarCategoria("61", "Hijo", "Hijo", "11");
			fail("No debería agregar la categoría pues su categoría padre tiene libros registrados");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    }	
    
    /**
     * Prueba 6 - Prueba el método eliminarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarCategoria <br>
     * <b> Objetivo: </b> Probar que el método elimina categorías
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría tiene sub-categorías, una de ellas va a ser eliminada
     * 2. Se va a eliminar una categoría de una sub-categoría
     */
    public void testEliminarCategoria()
    {
    	setupEscenario2();
    	
    	try 
    	{
			categoria.eliminarCategoria("1");
			assertEquals("La categoría no fue eliminada", 4, categoria.darSubCategorias().size());
			Categoria c = categoria.buscarCategoria('1');
			assertNull("La categoría no fue eliminada", c);
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se debería generar el error: " + e.getMessage());
		}
    	
    	try 
    	{
			categoria.eliminarCategoria("32");
			assertEquals("La categoría no fue eliminada correctamente", 4, categoria.darSubCategorias().size());
			Categoria c = categoria.buscarCategoria('3');
			assertEquals("La categoría no fue eliminada", 0, c.darSubCategorias().size());
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se debería generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 7 - Prueba el método eliminarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarCategoria <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar una categoría que no existe
     */
	public void testEliminarCategoriaError()
	{
		setupEscenario2();
    	
    	try
    	{
			categoria.eliminarCategoria("6");
			fail("No debería eliminar la categoría por que no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 8 - Prueba el método agregarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método agrega libros
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría no tiene sub-categorías
     */
	public void testAgregarLibro()
	{
		setupEscenario1();
    	
    	try 
    	{
			categoria.agregarLibro("", "1.A0", "nombre", "autores", 2011, "editorial", 100);
			assertEquals("No se agrego el libro a la categoría", 1, categoria.darLibros().size());
			Libro libro = (Libro) categoria.darLibros().get(0);
			assertEquals("El ISBN del libro no es correcto", "1.A0", libro.darIsbn());
	    	assertEquals("El nombre del libro no es correcto", "nombre", libro.darNombre());

		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se debería generar el error: " + e.getMessage());
		}
	}
	
	/**
     * Prueba 9 - Prueba el método agregarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método agrega libros
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría no tiene sub-categorías y se agrega el libro a una sub-categoría
     */
	public void testAgregarLibro2()
	{
    	setupEscenario2();
    	
    	try 
    	{
    		categoria.agregarLibro("1", "11.A0", "nombre", "autores", 2011, "editorial", 100);
    		Categoria c = categoria.buscarCategoria('1');
    		assertEquals("No se agrego el libro a la categoría", 1, c.darLibros().size());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se debería generar el error: " + e.getMessage());
		}
	}
	
	/**
     * Prueba 10 - Prueba el método agregarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría del libro no existe
     * 2. La categoría del libro no es una hoja
     */
	public void testAgregarLibroError()
	{
		setupEscenario2();
    	
    	try
    	{
    		categoria.agregarLibro("35", "135.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No debería agregar el libro pues su categoría no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    	
    	try
    	{
    		categoria.agregarLibro("", "1.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No debería agregar el libro pues su categoría no es hoja");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 11 - Prueba el método agregarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agrega un libro que ya existe
     */
	public void testAgregarLibroError2()
	{
		setupEscenario3();
    	
    	try
    	{
    		categoria.agregarLibro("", "1.A", "nombre", "autores", 2011, "editorial", 100);
			fail("No debería agregar el libro pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 12 - Prueba el método eliminarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarLibro <br>
     * <b> Objetivo: </b> Probar que el método elimina libros
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría tiene libros, uno de ellos va a ser eliminado
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
    		fail("No se debería generar el error: " + e.getMessage());
		}
    }
	
	/**
     * Prueba 13 - Prueba el método eliminarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarLibro, agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método elimina libros
     * <b> Casos de prueba: </b> <br>
     * 1. Se va a eliminar un libro de una sub-categoría
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
    		fail("No se debería generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 14 - Prueba el método eliminarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarLibro <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. La categoría del libro no existe
     */
    public void testEliminarLibroError()
	{
		setupEscenario2();
    	
    	try
    	{
			categoria.eliminarLibro("12", "12.A");
			fail("No debería eliminar el libro pues su categoría no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
    /**
     * Prueba 15 - Prueba el método eliminarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarLibro <br>
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar un libro que no existe
     */
	public void testEliminarLibroError2()
	{
		setupEscenario3();
    	
    	try
    	{
    		categoria.eliminarLibro("", "1.Aa");
			fail("No debería eliminar el libro pues no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 16 - Prueba el método buscarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarCategoria <br>
     * <b> Objetivo: </b> Probar que el método busque correctamente la categoría
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca una categoría existente
     * 2. Se busca una categoría que no existe
     */
	public void testBuscarCategoria()
	{
		setupEscenario2();
		
		Categoria c = categoria.buscarCategoria('3');
		assertNotNull("La categoría no debería ser nula", c);
		assertEquals("La categoría no es correcta", '3', c.darCodigo());
		
		c = categoria.buscarCategoria('7');
		assertNull("La categoría debería ser nula", c);
	}

	/**
     * Prueba 17 - Prueba el método buscarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarLibro <br>
     * <b> Objetivo: </b> Probar que el método busque correctamente los libros
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca un libro existente
     * 2. Se busca un libro que no existe
     */
	public void testBuscarLibro()
	{
		setupEscenario3();
		
		Libro l = categoria.buscarLibro("1.A");
		assertNotNull("El libro no debería ser nulo", l);
		assertEquals("El libro no es correcto", "1.A", l.darIsbn());
		
		l = categoria.buscarLibro("1.Z");
		assertNull("El libro debería ser nulo", l);
	}

	/**
     * Prueba 18 - Prueba el método darNumCategorias. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el método calcula correctamente el número de categorías
     */
	public void testDarNumCategorias()
	{
		setupEscenario2();
		int numCategorias = categoria.darNumCategorias();
		assertEquals("El número de categorías no es calculado correctamente", 6, numCategorias);
	}
	
	/**
     * Prueba 19 - Prueba el método darNumLibros. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumLibros <br>
     * <b> Objetivo: </b> Probar que el método calcula correctamente el número de libros
     */
	public void testDarNumLibros()
	{
		setupEscenario3();
		int numLibros = categoria.darNumLibros();
		assertEquals("El número de libros no es calculado correctamente", 3, numLibros);
	}
	
	/**
     * Prueba 20 - Prueba el método darNumLibros. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumLibros, agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método calcula correctamente el número de libros
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
			fail("No se debería generar el error: " + e.getMessage());
		}
		
		int numLibros = categoria.darNumLibros();
		assertEquals("El número de libros no es calculado correctamente", 2, numLibros);
	}
	
	/**
     * Prueba 21 - Prueba el método buscarLibros. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarLibros <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de libros en una categoría
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca la lista de libros de una categoría hoja
     */
	public void testBuscarLibros()
	{
		setupEscenario3();
		
		ArrayList listaLibros = new ArrayList();
		categoria.buscarLibros("", listaLibros);
		assertEquals("El número de libros encontrados no es correcto", 3, listaLibros.size());
	}
	
	/**
     * Prueba 22 - Prueba el método buscarLibros. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarLibros, agregarLibro <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de libros en una categoría
     * <b> Casos de prueba: </b> <br>
     * 1. Se busca la lista de libros de una categoría con sub-categorías
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
			fail("No se debería generar el error: " + e.getMessage());
		}
		
		ArrayList listaLibros = new ArrayList();
		categoria.buscarLibros("", listaLibros);
		assertEquals("El número de libros encontrados no es correcto", 2, listaLibros.size());
	}
	
	/**
     * Prueba 23 - Prueba el método buscarCategoriasPreorden. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarCategoriasPreorden <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de categorías organizadas en preorden
     */
	public void testBuscarCategoriasPreorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = new ArrayList();
		categoria.buscarCategoriasPreorden( listaCategorias );
		
		assertEquals("El número de categorías encontradas no es correcto", 7, listaCategorias.size());
		
		for (int i = 0; i < listaCategorias.size(); i++) 
		{
			Categoria c1 = (Categoria) listaCategorias.get(i);
			for (int j = i+1; j < listaCategorias.size(); j++) 
			{
				Categoria c2 = (Categoria) listaCategorias.get(j);
				assertTrue("Las categorías no fueron ordenadas correctamente", c1.darCodigoCompuesto().compareTo(c2.darCodigoCompuesto()) < 0);
			}
		}
    }
	
	/**
     * Prueba 24 - Prueba el método buscarCategoriasPostorden. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarCategoriasPostorden <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de categorías organizadas en postorden
     */
	public void testBuscarCategoriasPostorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = new ArrayList();
		categoria.buscarCategoriasPostorden( listaCategorias );
		
		assertEquals("El número de categorías encontradas no es correcto", 7, listaCategorias.size());
		assertEquals("Las categorías no fueron ordenadas correctamente", "11", ((Categoria)listaCategorias.get(0)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "12", ((Categoria)listaCategorias.get(1)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "132", ((Categoria)listaCategorias.get(2)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "13", ((Categoria)listaCategorias.get(3)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "14", ((Categoria)listaCategorias.get(4)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "15", ((Categoria)listaCategorias.get(5)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "1", ((Categoria)listaCategorias.get(6)).darCodigoCompuesto());
    }
	
		
	/**
     * Prueba 25 - Prueba el método toString. <br>
     * <b> Métodos a probar: </b> <br>
     * toString <br>
     * <b> Objetivo: </b> Probar que el método retorne el código compuesto - nombre de la categoría
     */
	public void testToString()
	{
		setupEscenario1();
		assertEquals("La representa String de la categoría no es correcta", "1 - Categoria", categoria.toString());
	}
}