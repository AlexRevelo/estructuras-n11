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
package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.cupiLibros.mundo.Biblioteca;
import uniandes.cupi2.cupiLibros.mundo.BibliotecaException;
import uniandes.cupi2.cupiLibros.mundo.Categoria;

/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazCupiLibros extends JFrame
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    
    /**
     * La ruta del archivo donde est� la informaci�n de la biblioteca
     */
    private static final String RUTA_ARCHIVO = "./data/biblioteca.data";
    
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Biblioteca biblioteca;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

	/**
	 * Panel con la imagen encabezado
	 */
	private PanelImagen panelImagen;

	/**
	 * Panel con las opciones de extensi�n
	 */
	private PanelExtension panelExtension;
	
	/**
	 * Panel con la lista de categor�as
	 */
	private PanelListaCategorias panelCategorias;
	
	/**
	 * Panel con la lista de libros
	 */
	private PanelListaLibros panelLibros;
	
	/**
	 * Panel con las opciones de la biblioteca
	 */
	private PanelOpciones panelOpciones;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicaci�n de libros
     * <b>post: </b> Se ha creado la ventana con los respectivos elementos gr�ficos
     */
    public InterfazCupiLibros()
    {
        // Crea la clase principal
        try 
        {
			biblioteca = new Biblioteca(RUTA_ARCHIVO);
			
			// Construye la forma
			setLayout( new BorderLayout( ) );
			setSize( 650, 530 );
			setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
			setTitle(" CupiLibros ");
			setResizable(false);
			
			//Creaci�n de los paneles aqu�
			panelImagen = new PanelImagen();
			add( panelImagen, BorderLayout.NORTH );
			
			JPanel aux = new JPanel();
			aux.setLayout(new GridLayout(1, 2));

			panelCategorias = new PanelListaCategorias(this);
			aux.add(panelCategorias);
			
			panelLibros = new PanelListaLibros();
			aux.add(panelLibros);
			add( aux, BorderLayout.CENTER );

			JPanel aux2 = new JPanel();
			aux2.setLayout(new BorderLayout());
			
			panelExtension = new PanelExtension( this );
			aux2.add( panelExtension, BorderLayout.SOUTH );
			
			panelOpciones = new PanelOpciones(this);
			aux2.add(BorderLayout.CENTER, panelOpciones);	
			add(aux2, BorderLayout.SOUTH);
			
			//Centrar la ventana
	        setLocationRelativeTo(null);
	        
	        actualizarListaCategorias();
			
		} 
        catch (BibliotecaException e) 
        {
        	JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            System.exit( ERROR );
		}
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------
    
    /**
     * Actualiza la lista de categor�as mostradas.
     */
    private void actualizarListaCategorias( )
    {
        panelCategorias.refrescarLista( biblioteca.buscarCategoriasPreorden() );
        panelOpciones.actuallizarNumCategorias(biblioteca.darNumCategorias());
        panelOpciones.actuallizarNumLibros(biblioteca.darNumLibros());
    }
    
    /**
     * Organiza la lista de categor�as mostradas.
     */
    public void organizarCategoriasPreorden( )
    {
    	panelCategorias.refrescarLista( biblioteca.buscarCategoriasPreorden() );
        
    }
    
    /**
     * Organiza la lista de categor�as mostradas.
     */
    public void organizarCategoriasPostorden( )
    {
    	panelCategorias.refrescarLista( biblioteca.buscarCategoriasPostorden() );
        
    }
    
    /**
     * Actualiza la lista de libros con los libros de la categor�a dada
     * @param categoria Categor�a de la biblioteca. categoria != null
     */
	public void actualizarLibros(Categoria categoria) 
	{
		panelLibros.refrescarLista(biblioteca.buscarLibros(categoria.darCodigoCompuesto()));
	}
	
    /**
     * Agrega una categor�a a la biblioteca
     * @param codigo C�digo de la categor�a. Valor num�rico positivo.
     * @param nombre Nombre de la categor�a. nombre != null y nombre != ""
     * @param descripcion Descripci�n de la categor�a. descripcion != null y descripcion != ""
     */
    public void agregarCategoria(String codigo, String nombre, String descripcion) 
    {
    	try
    	{
			biblioteca.agregarCategoria(codigo, nombre, descripcion, codigo);
			actualizarListaCategorias();	
		} 
    	catch (BibliotecaException e) 
    	{
    		JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
    }
    	
	/**
	 * Elimina una categor�a a la biblioteca 
	 */
	public void eliminarCategoria() 
	{
		String codigo = JOptionPane.showInputDialog(this, "C�digo de la categor�a", "Eliminar Categor�a", JOptionPane.QUESTION_MESSAGE);
		if(codigo != null && !codigo.isEmpty())
		{
			try
			{
				int numCodigo = Integer.parseInt(codigo);
				if(numCodigo >= 0)
				{
					biblioteca.eliminarCategoria(codigo);
					actualizarListaCategorias();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "El c�digo de la categor�a debe ser un valor num�rico positivo", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch (NumberFormatException ex) 
			{
				JOptionPane.showMessageDialog(this, "El c�digo de la categor�a debe ser un valor num�rico", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (BibliotecaException e) 
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Agrega un libro a la biblioteca
	 * @param codigo C�digo de la categor�a. Cadena num�rica positiva
	 * @param isbn C�digo ISBN del libro. isbn != null y isbn != ""
	 * @param nombre Nombre del libro. nombre != null y nombre != ""
	 * @param autores Autores del libro. autores != null y autores != ""
	 * @param anioPublicacion A�o de publicaci�n del libro. anioPublicacion > 0
	 * @param editorial Editorial del libro. editorial != null y editorial != ""
	 * @param numPaginas N�mero de p�ginas del libro. numPaginas > 0
	 */
	public void agregarLibro(String codigo, String isbn, String nombre, String autores, 
			int anioPublicacion, String editorial, int numPaginas)
	{
		try
    	{
			biblioteca.agregarLibro(codigo, isbn, nombre, autores, anioPublicacion, editorial, numPaginas);
			actualizarListaCategorias();
		} 
    	catch (BibliotecaException e) 
    	{
    		JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Elimina un libro de  la biblioteca
	 * @param codigo C�digo de la categor�a. Cadena num�rica positiva
	 * @param isbn C�digo ISBN del libro. isbn != null y isbn != ""
	 */
	public void eliminarLibro(String codigo, String isbn)
	{
		try
		{
			biblioteca.eliminarLibro(codigo, isbn);
			actualizarListaCategorias();
		}
		catch (BibliotecaException e) 
    	{
    		JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Retorna el n�mero de categor�as de la biblioteca
	 * @return N�mero de categor�as de la biblioteca
	 */
	public int darNumCategorias()
	{
		return biblioteca.darNumCategorias();
	}
	
	/**
	 * Retorna el n�mero de libros de la biblioteca
	 * @return N�mero de libros de la biblioteca
	 */
	public int darNumLibros()
	{
		return biblioteca.darNumLibros();
	}

    /**
     * Guarda el estado actual de la biblioteca
     */
    public void dispose( ) 
    {
    	try 
    	{
			biblioteca.guardar();
			super.dispose();
		} 
    	catch (BibliotecaException e) 
    	{
    		setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, e.getMessage( ) + "\n �Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );

            }
		}
    }
    
    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = biblioteca.metodo1();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = biblioteca.metodo2();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args Los argumentos de ejecuci�n de la aplicaci�n. args != null
     */
    public static void main( String[] args )
    {
        InterfazCupiLibros interfaz = new InterfazCupiLibros();
        interfaz.setVisible( true );
    }
}
