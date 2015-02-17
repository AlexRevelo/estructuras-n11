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
import uniandes.cupi2.cupiLibros.mundo.Biblioteca;
import uniandes.cupi2.cupiLibros.mundo.BibliotecaException;
import uniandes.cupi2.cupiLibros.mundo.Categoria;

/**
 * Clase usada para verificar la correcta implementación de la clase Biblioteca
 */
public class BibliotecaTest  extends TestCase  
{	
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
	/**
	 * La biblioteca de BibliotecaTest
	 */
	private Biblioteca biblioteca; 
		
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
	
	/**
	 * Crea una biblioteca vacía
	 */
	public void setupEscenario1()
	{
		try 
		{
			biblioteca = new Biblioteca("");
		} 
		catch (BibliotecaException e) 
		{
			fail("No se debería generar el error " + e.getMessage());
		}
	}
	
	/**
	 * Crea una biblioteca con categorías
	 */
	public void setupEscenario2()
	{
		try 
		{
			biblioteca = new Biblioteca("");
			biblioteca.agregarCategoria("1", "Categoria 1", "Descripcion", "1");
			biblioteca.agregarCategoria("2", "Categoria 2", "Descripcion", "2");
			biblioteca.agregarCategoria("3", "Categoria 3", "Descripcion", "3");
			biblioteca.agregarCategoria("8", "Categoria 8", "Descripcion", "8");
			biblioteca.agregarCategoria("32", "Categoria 32", "Descripcion", "32");
			biblioteca.agregarCategoria("38", "Categoria 38", "Descripcion", "38");
		} 
		catch (BibliotecaException e) 
		{
			fail("No se debería generar el error " + e.getMessage());
		}
	}
	
	/**
	 * Crea una biblioteca con categorías y libros
	 */
	public void setupEscenario3()
	{
		try 
		{
			biblioteca = new Biblioteca("");
			
			biblioteca.agregarCategoria("1", "Categoria 1", "Descripcion", "1");
			biblioteca.agregarCategoria("2", "Categoria 2", "Descripcion", "2");
			biblioteca.agregarCategoria("3", "Categoria 3", "Descripcion", "3");
			biblioteca.agregarCategoria("8", "Categoria 8", "Descripcion", "8");
			biblioteca.agregarCategoria("32", "Categoria 32", "Descripcion", "32");
			biblioteca.agregarCategoria("38", "Categoria 38", "Descripcion", "38");
			biblioteca.agregarLibro("1", "1.A", "Libro", "Autores", 2011, "Editorial", 100);
			biblioteca.agregarLibro("8", "8.A", "Libro", "Autores", 2011, "Editorial", 500);
			biblioteca.agregarLibro("38", "38.A", "Libro", "Autores", 2011, "Editorial", 600);
			 
		} 
		catch (BibliotecaException e) 
		{
			fail("No se debería generar el error " + e.getMessage());
		}
	}
	
	
	/**
     * Prueba 1 - Prueba el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Biblioteca, darCategoriaRaiz. <br>
     * <b> Objetivo: </b> Probar que el método constructor inicialice correctamente la categoría raíz. <br>
     */
    public void testBiblioteca( )
    {
    	setupEscenario1();
    	assertNotNull("El nombre de la categoría no fue inicializado", biblioteca.darCategoriaRaiz());
    }
		    
    /**
     * Prueba 2 - Prueba el método agregarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCategoria, darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el método agrega nuevas categorías
    */
    public void testAgregarCategoria()
    {
    	setupEscenario1();
    	
    	try 
    	{
			biblioteca.agregarCategoria("2", "Hija 1", "Descripcion 1", "12");
			assertEquals("No se agrego la categoría", 1, biblioteca.darNumCategorias());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se debería generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 3 - Prueba el método agregarCategoria. <br>
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
			biblioteca.agregarCategoria("1", "Hijo", "Hijo", "11");
			fail("No debería agregar la categoría pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    	
    	try
    	{
    		biblioteca.agregarCategoria("61", "Hijo", "Hijo", "11");
			fail("No debería agregar la categoría pues su categoría padre no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    }
    
    /**
     * Prueba 4 - Prueba el método agregarCategoria. <br>
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
    		biblioteca.agregarCategoria("1", "Hijo", "Hijo", "11");
			fail("No debería agregar la categoría pues su categoría padre tiene libros registrados");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    }	
    
    /**
     * Prueba 5 - Prueba el método eliminarCategoria. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarCategoria, darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el método elimina categorías
     * <b> Casos de prueba: </b> <br>
     */
    public void testEliminarCategoria()
    {
    	setupEscenario2();
    	
    	try 
    	{
    		biblioteca.eliminarCategoria("1");
			assertEquals("La categoría no fue eliminada", 5, biblioteca.darNumCategorias());
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se debería generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 6 - Prueba el método eliminarCategoria. <br>
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
    		biblioteca.eliminarCategoria("6");
			fail("No debería eliminar la categoría por que no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 7 - Prueba el método agregarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLibro, darNumLibros <br>
     * <b> Objetivo: </b> Probar que el método agrega libros
     */
	public void testAgregarLibro()
	{
		setupEscenario2();
    	
    	try 
    	{
    		biblioteca.agregarLibro("1", "1.A0", "nombre", "autores", 2011, "editorial", 100);
    		assertEquals("No se agrego el libro", 1, biblioteca.darNumLibros());

		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se debería generar el error: " + e.getMessage());
		}
	}
		
	/**
     * Prueba 8 - Prueba el método agregarLibro. <br>
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
    		biblioteca.agregarLibro("35", "35.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No debería agregar el libro pues su categoría no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
    	
    	try
    	{
    		biblioteca.agregarLibro("3", "3.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No debería agregar el libro pues su categoría no es hoja");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 9 - Prueba el método agregarLibro. <br>
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
    		biblioteca.agregarLibro("1", "1.A", "nombre", "autores", 2011, "editorial", 100);
			fail("No debería agregar el libro pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}
	
	/**
     * Prueba 10 - Prueba el método eliminarLibro. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarLibro, darNumLibros <br>
     * <b> Objetivo: </b> Probar que el método elimina libros
     */
	public void testEliminarLibro()
    {
    	setupEscenario3();
    	
    	try 
    	{
			biblioteca.eliminarLibro("1", "1.A");
			assertEquals("El libro no fue eliminado", 2, biblioteca.darNumLibros());
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se debería generar el error: " + e.getMessage());
		}
    }
	
    /**
     * Prueba 11 - Prueba el método eliminarLibro. <br>
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
			biblioteca.eliminarLibro("12", "12.A");
			fail("No debería eliminar el libro pues su categoría no existe");
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
     * <b> Objetivo: </b> Probar que el método maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar un libro que no existe
     */
	public void testEliminarLibroError2()
	{
		setupEscenario3();
    	
    	try
    	{
    		biblioteca.eliminarLibro("1", "1.Aa");
			fail("No debería eliminar el libro pues no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepción
		}
	}

	/**
     * Prueba 13 - Prueba el método darNumCategorias. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el método calcula correctamente el número de categorías
     */
	public void testDarNumCategorias()
	{
		setupEscenario2();
		int numCategorias = biblioteca.darNumCategorias();
		assertEquals("El número de categorías no es calculado correctamente", 6, numCategorias);
	}
	
	/**
     * Prueba 14 - Prueba el método darNumLibros. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumLibros <br>
     * <b> Objetivo: </b> Probar que el método calcula correctamente el número de libros
     */
	public void testDarNumLibros()
	{
		setupEscenario3();
		int numLibros = biblioteca.darNumLibros();
		assertEquals("El número de libros no es calculado correctamente", 3, numLibros);
	}
	
	/**
     * Prueba 15 - Prueba el método buscarLibros. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarLibros <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de libros en una categoría
     */
	public void testBuscarLibros()
	{
		setupEscenario3();
		
		ArrayList listaLibros = biblioteca.buscarLibros("3");
		assertEquals("El número de libros encontrados no es correcto", 1, listaLibros.size());
	}
	
	/**
     * Prueba 16 - Prueba el método buscarCategoriasPreorden. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarCategoriasPreorden <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de categorías organizadas en preorden
     */
	public void testBuscarCategoriasPreorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = biblioteca.buscarCategoriasPreorden();
		
		assertEquals("El número de categorías encontradas no es correcto", 7, listaCategorias.size());
		
		assertEquals("Las categorías no fueron ordenadas correctamente", "", ((Categoria) listaCategorias.get(0)).darCodigoCompuesto());
		for (int i = 1; i < listaCategorias.size(); i++) 
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
     * Prueba 17 - Prueba el método buscarCategoriasPostorden. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarCategoriasPostorden <br>
     * <b> Objetivo: </b> Probar que el método retorne la lista de categorías organizadas en postorden
     */
	public void testBuscarCategoriasPostorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = biblioteca.buscarCategoriasPostorden();
		
		assertEquals("El número de categorías encontradas no es correcto", 7, listaCategorias.size());
		assertEquals("Las categorías no fueron ordenadas correctamente", "1", ((Categoria)listaCategorias.get(0)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "2", ((Categoria)listaCategorias.get(1)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "32", ((Categoria)listaCategorias.get(2)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "38", ((Categoria)listaCategorias.get(3)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "3", ((Categoria)listaCategorias.get(4)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "8", ((Categoria)listaCategorias.get(5)).darCodigoCompuesto());
		assertEquals("Las categorías no fueron ordenadas correctamente", "", ((Categoria)listaCategorias.get(6)).darCodigoCompuesto());
    }
}