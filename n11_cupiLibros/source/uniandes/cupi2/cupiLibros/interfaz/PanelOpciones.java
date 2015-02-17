package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de agregar y eliminar categor�as y libros
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando Agregar Categor�a
     */
    private static final String AGREGAR_CATEG = "Agregar Categor�a";

    /**
     * Comando Eliminar Categor�a
     */
    private static final String ELIMINAR_CATEG = "Eliminar Categor�a";
    
    /**
     * Comando Agregar Libro
     */
    private final static String AGREGAR_LIBRO = "Agregar Libro";
    
    /**
     * Comando Eliminar Libro
     */
    private final static String ELIMINAR_LIBRO = "Eliminar Libro";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazCupiLibros principal;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Bot�n Agregar Categor�a
     */
    private JButton btnAgregarCateg;

    /**
     * Bot�n Eliminar Categor�a
     */
    private JButton btnEliminarCateg;
    
    /**
     * Bot�n Agregar Libro
     */
    private JButton btnAgregarLibro;

    /**
     * Bot�n Eliminar Libro
     */
    private JButton btnEliminarLibro;
    
    /**
     * Campo de texto con el n�mero de categor�as
     */
    private JTextField txtCategorias;
    
    /**
     * Campo de texto con el n�mero de libros
     */
    private JTextField txtLibros;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel de las opciones de la biblioteca
     * @param ventana Ventana principal de la interfaz. ventana != null
     */
    public PanelOpciones( InterfazCupiLibros ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder("Opciones Biblioteca") );
        setLayout( new GridLayout( 2, 4 ) );

        JLabel lblCategorias = new JLabel("N�mero de categor�as: ");
        lblCategorias.setHorizontalAlignment(JLabel.CENTER);
        add(lblCategorias);
        
        txtCategorias = new JTextField("0");
        txtCategorias.setEditable(false);
        txtCategorias.setHorizontalAlignment(JTextField.CENTER);
        add(txtCategorias);
        
        JLabel lblLibros = new JLabel("N�mero de libros: ");
        lblLibros.setHorizontalAlignment(JLabel.CENTER);
        add(lblLibros);
        
        txtLibros = new JTextField("0");
        txtLibros.setEditable(false);
        txtLibros.setHorizontalAlignment(JTextField.CENTER);
        add(txtLibros);
        
        btnAgregarCateg = new JButton( AGREGAR_CATEG );
        btnAgregarCateg.setActionCommand( AGREGAR_CATEG );
        btnAgregarCateg.addActionListener( this );
        add( btnAgregarCateg );
        
        btnEliminarCateg = new JButton( ELIMINAR_CATEG );
        btnEliminarCateg.setActionCommand( ELIMINAR_CATEG );
        btnEliminarCateg.addActionListener( this );
        add( btnEliminarCateg );
        
        btnAgregarLibro = new JButton( AGREGAR_LIBRO );
        btnAgregarLibro.setActionCommand( AGREGAR_LIBRO );
        btnAgregarLibro.addActionListener( this );
        add( btnAgregarLibro );
        
        btnEliminarLibro = new JButton( ELIMINAR_LIBRO );
        btnEliminarLibro.setActionCommand( ELIMINAR_LIBRO );
        btnEliminarLibro.addActionListener( this );
        add( btnEliminarLibro );   
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento. e != null
     */
    public void actionPerformed( ActionEvent e )
    {
    	String comando = e.getActionCommand();
    	
        if(comando.equals( AGREGAR_CATEG ))
        {
            DialogoAgregarCategoria dialogo = new DialogoAgregarCategoria(principal);
            dialogo.setVisible(true);
        }
        else if(comando.equals( ELIMINAR_CATEG ))
        {
            principal.eliminarCategoria();
        }
        else if(comando.equals( AGREGAR_LIBRO ))
        {
            DialogoAgregarLibro dialogo = new DialogoAgregarLibro(principal);
            dialogo.setVisible(true);
        }
        else if(comando.equals( ELIMINAR_LIBRO ))
        {
            DialogoEliminarLibro dialogo = new DialogoEliminarLibro(principal);
            dialogo.setVisible(true);
        }
    }
    
    /**
     * Actualiza el n�mero de categor�as de la biblioteca
     * @param num N�mero de categor�as. num >= 0
     */
    public void actuallizarNumCategorias(int num)
    {
    	txtCategorias.setText("" + num);
    }
    
    /**
     * Actualiza el n�mero de libros de la biblioteca
     * @param num N�mero de libros. num >= 0
     */
    public void actuallizarNumLibros(int num)
    {
    	txtLibros.setText("" + num);
    }
}