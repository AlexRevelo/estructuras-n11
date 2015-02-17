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
import uniandes.cupi2.cupiLibros.mundo.Biblioteca;
import uniandes.cupi2.cupiLibros.mundo.BibliotecaException;
import uniandes.cupi2.cupiLibros.mundo.Categoria;

/**
 * Clase usada para verificar la correcta implementaci�n de la clase Biblioteca
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
	// M�todos
	//-------------------------------------------------------------
	
	/**
	 * Crea una biblioteca vac�a
	 */
	public void setupEscenario1()
	{
		try 
		{
			biblioteca = new Biblioteca("");
		} 
		catch (BibliotecaException e) 
		{
			fail("No se deber�a generar el error " + e.getMessage());
		}
	}
	
	/**
	 * Crea una biblioteca con categor�as
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
			fail("No se deber�a generar el error " + e.getMessage());
		}
	}
	
	/**
	 * Crea una biblioteca con categor�as y libros
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
			fail("No se deber�a generar el error " + e.getMessage());
		}
	}
	
	
	/**
     * Prueba 1 - Prueba el m�todo constructor de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * Biblioteca, darCategoriaRaiz. <br>
     * <b> Objetivo: </b> Probar que el m�todo constructor inicialice correctamente la categor�a ra�z. <br>
     */
    public void testBiblioteca( )
    {
    	setupEscenario1();
    	assertNotNull("El nombre de la categor�a no fue inicializado", biblioteca.darCategoriaRaiz());
    }
		    
    /**
     * Prueba 2 - Prueba el m�todo agregarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarCategoria, darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el m�todo agrega nuevas categor�as
    */
    public void testAgregarCategoria()
    {
    	setupEscenario1();
    	
    	try 
    	{
			biblioteca.agregarCategoria("2", "Hija 1", "Descripcion 1", "12");
			assertEquals("No se agrego la categor�a", 1, biblioteca.darNumCategorias());
		} 
    	catch (BibliotecaException e) 
    	{
			fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 3 - Prueba el m�todo agregarCategoria. <br>
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
			biblioteca.agregarCategoria("1", "Hijo", "Hijo", "11");
			fail("No deber�a agregar la categor�a pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    	
    	try
    	{
    		biblioteca.agregarCategoria("61", "Hijo", "Hijo", "11");
			fail("No deber�a agregar la categor�a pues su categor�a padre no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    }
    
    /**
     * Prueba 4 - Prueba el m�todo agregarCategoria. <br>
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
    		biblioteca.agregarCategoria("1", "Hijo", "Hijo", "11");
			fail("No deber�a agregar la categor�a pues su categor�a padre tiene libros registrados");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    }	
    
    /**
     * Prueba 5 - Prueba el m�todo eliminarCategoria. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCategoria, darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el m�todo elimina categor�as
     * <b> Casos de prueba: </b> <br>
     */
    public void testEliminarCategoria()
    {
    	setupEscenario2();
    	
    	try 
    	{
    		biblioteca.eliminarCategoria("1");
			assertEquals("La categor�a no fue eliminada", 5, biblioteca.darNumCategorias());
		} 
    	catch (BibliotecaException e)
    	{
    		fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
    
    /**
     * Prueba 6 - Prueba el m�todo eliminarCategoria. <br>
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
    		biblioteca.eliminarCategoria("6");
			fail("No deber�a eliminar la categor�a por que no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 7 - Prueba el m�todo agregarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibro, darNumLibros <br>
     * <b> Objetivo: </b> Probar que el m�todo agrega libros
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
			fail("No se deber�a generar el error: " + e.getMessage());
		}
	}
		
	/**
     * Prueba 8 - Prueba el m�todo agregarLibro. <br>
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
    		biblioteca.agregarLibro("35", "35.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No deber�a agregar el libro pues su categor�a no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
    	
    	try
    	{
    		biblioteca.agregarLibro("3", "3.A0", "nombre", "autores", 2011, "editorial", 100);
			fail("No deber�a agregar el libro pues su categor�a no es hoja");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 9 - Prueba el m�todo agregarLibro. <br>
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
    		biblioteca.agregarLibro("1", "1.A", "nombre", "autores", 2011, "editorial", 100);
			fail("No deber�a agregar el libro pues ya existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}
	
	/**
     * Prueba 10 - Prueba el m�todo eliminarLibro. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibro, darNumLibros <br>
     * <b> Objetivo: </b> Probar que el m�todo elimina libros
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
    		fail("No se deber�a generar el error: " + e.getMessage());
		}
    }
	
    /**
     * Prueba 11 - Prueba el m�todo eliminarLibro. <br>
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
			biblioteca.eliminarLibro("12", "12.A");
			fail("No deber�a eliminar el libro pues su categor�a no existe");
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
     * <b> Objetivo: </b> Probar que el m�todo maneja correctamente los casos de error
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar un libro que no existe
     */
	public void testEliminarLibroError2()
	{
		setupEscenario3();
    	
    	try
    	{
    		biblioteca.eliminarLibro("1", "1.Aa");
			fail("No deber�a eliminar el libro pues no existe");
		}
    	catch (BibliotecaException e)
    	{
			//Debe generar excepci�n
		}
	}

	/**
     * Prueba 13 - Prueba el m�todo darNumCategorias. <br>
     * <b> M�todos a probar: </b> <br>
     * darNumCategorias <br>
     * <b> Objetivo: </b> Probar que el m�todo calcula correctamente el n�mero de categor�as
     */
	public void testDarNumCategorias()
	{
		setupEscenario2();
		int numCategorias = biblioteca.darNumCategorias();
		assertEquals("El n�mero de categor�as no es calculado correctamente", 6, numCategorias);
	}
	
	/**
     * Prueba 14 - Prueba el m�todo darNumLibros. <br>
     * <b> M�todos a probar: </b> <br>
     * darNumLibros <br>
     * <b> Objetivo: </b> Probar que el m�todo calcula correctamente el n�mero de libros
     */
	public void testDarNumLibros()
	{
		setupEscenario3();
		int numLibros = biblioteca.darNumLibros();
		assertEquals("El n�mero de libros no es calculado correctamente", 3, numLibros);
	}
	
	/**
     * Prueba 15 - Prueba el m�todo buscarLibros. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarLibros <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de libros en una categor�a
     */
	public void testBuscarLibros()
	{
		setupEscenario3();
		
		ArrayList listaLibros = biblioteca.buscarLibros("3");
		assertEquals("El n�mero de libros encontrados no es correcto", 1, listaLibros.size());
	}
	
	/**
     * Prueba 16 - Prueba el m�todo buscarCategoriasPreorden. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarCategoriasPreorden <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de categor�as organizadas en preorden
     */
	public void testBuscarCategoriasPreorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = biblioteca.buscarCategoriasPreorden();
		
		assertEquals("El n�mero de categor�as encontradas no es correcto", 7, listaCategorias.size());
		
		assertEquals("Las categor�as no fueron ordenadas correctamente", "", ((Categoria) listaCategorias.get(0)).darCodigoCompuesto());
		for (int i = 1; i < listaCategorias.size(); i++) 
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
     * Prueba 17 - Prueba el m�todo buscarCategoriasPostorden. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarCategoriasPostorden <br>
     * <b> Objetivo: </b> Probar que el m�todo retorne la lista de categor�as organizadas en postorden
     */
	public void testBuscarCategoriasPostorden( )
    {
		setupEscenario2();
		ArrayList listaCategorias = biblioteca.buscarCategoriasPostorden();
		
		assertEquals("El n�mero de categor�as encontradas no es correcto", 7, listaCategorias.size());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "1", ((Categoria)listaCategorias.get(0)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "2", ((Categoria)listaCategorias.get(1)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "32", ((Categoria)listaCategorias.get(2)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "38", ((Categoria)listaCategorias.get(3)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "3", ((Categoria)listaCategorias.get(4)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "8", ((Categoria)listaCategorias.get(5)).darCodigoCompuesto());
		assertEquals("Las categor�as no fueron ordenadas correctamente", "", ((Categoria)listaCategorias.get(6)).darCodigoCompuesto());
    }
}