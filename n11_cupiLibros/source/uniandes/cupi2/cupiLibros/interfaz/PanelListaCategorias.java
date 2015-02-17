package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.cupiLibros.mundo.Categoria;

/**
 * Panel con las lista de categor�as de la biblioteca
 */
public class PanelListaCategorias extends JPanel implements ListSelectionListener, ActionListener
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
	/**
	 * Constante que representa el comando de ver en detalle una categor�a
	 */
    private final static String VER = "Ver detalle";
    
    /**
	 * Comando Preorden
	 */
    private final static String PREORDEN = "Preorden";
    
    /**
	 * Comando Postorden
	 */
    private final static String POSTORDEN = "Postorden";    
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazCupiLibros interfaz;
        
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Lista con las categor�as
     */
    private JList listaCategorias;
    
    /**
     * Panel con un scroll que contiene a listaCategorias
     */
    private JScrollPane scroll;
    
    /**
     * Bot�n para ver la informaci�n de una categor�a
     */
    private JButton botonVer;
    
    /**
     * Opci�n Preorden
     */
    private JRadioButton opcionPreorden;
    
    /**
     * Opci�n Postorden
     */
    private JRadioButton opcionPostorden;
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    
    /**
     * Constructor del panel de la lista de categor�as
     * @param ventanaPrincipal La ventana principal de la aplicaci�n. ventanPrincipal != null
     */
    public PanelListaCategorias(InterfazCupiLibros ventanaPrincipal)
    {   
        interfaz = ventanaPrincipal;
        
        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5), new TitledBorder( " Categor�as " ) ) );
        setPreferredSize(new Dimension(250, 0));
        
        listaCategorias = new JList();
        listaCategorias.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaCategorias.addListSelectionListener( this );
        
        scroll = new JScrollPane(listaCategorias );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        
        botonVer = new JButton( VER );
        botonVer.setActionCommand( VER );
        botonVer.addActionListener( this );
        
        JPanel aux = new JPanel();
        aux.setLayout(new GridLayout(1, 2));
        
        opcionPreorden = new JRadioButton(PREORDEN);
        opcionPreorden.setActionCommand(PREORDEN);
        opcionPreorden.setSelected(true);
        opcionPreorden.addActionListener(this);
        
        opcionPostorden = new JRadioButton(POSTORDEN);
        opcionPostorden.setActionCommand(POSTORDEN);
        opcionPostorden.addActionListener(this);
        
        aux.add(opcionPreorden);
        aux.add(opcionPostorden);
                
        ButtonGroup bg = new ButtonGroup();
        bg.add(opcionPreorden);
        bg.add(opcionPostorden);
        
        add( aux, BorderLayout.NORTH);
        add( scroll, BorderLayout.CENTER );
        add( botonVer, BorderLayout.SOUTH);
    }
    
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de categor�as con la lista recibida por par�metro
     * @param nuevaLista La lista con las categor�as. nuevaLista != null
     */
    public void refrescarLista(ArrayList nuevaLista)
    {
        listaCategorias.setListData( nuevaLista.toArray( ) );
        if(!nuevaLista.isEmpty())
        	listaCategorias.setSelectedIndex(0);   
    }
       
    /**
     * M�todo para atender el evento cuando un usuario selecciona una categor�a de la lista
     * @param evento El evento de selecci�n de un elemento de la lista de categor�as. evento != null
     */
    public void valueChanged( ListSelectionEvent evento )
    {
        if(listaCategorias.getSelectedValue( ) != null)
        {
            Categoria categoria = (Categoria) listaCategorias.getSelectedValue( );
            interfaz.actualizarLibros(categoria);
        }    
    }

    /**
     * Manejo de los eventos de los botones
     * @param evento Acci�n que gener� el evento. evento != null
     */
    public void actionPerformed( ActionEvent evento )
    {
       String comando = evento.getActionCommand();
       if( comando.equals( VER ) )
       {
    	   if(listaCategorias.getSelectedValue( ) != null)
           {
               Categoria categoria = (Categoria) listaCategorias.getSelectedValue( );
               if(!categoria.darCodigoCompuesto().isEmpty())
               {
            	   DialogoVerCategoria dialogoCategoria = new DialogoVerCategoria(categoria);
    	    	   dialogoCategoria.setVisible(true);
               }
               else
               {
            	   JOptionPane.showMessageDialog(null, "Por favor seleccione una categor�a", "Ver Categor�a", JOptionPane.ERROR_MESSAGE);
               }
           }
       } 
       else if(comando.equals( PREORDEN ))
       {
    	   interfaz.organizarCategoriasPreorden();
       }
       else if(comando.equals( POSTORDEN ))
       {
    	   interfaz.organizarCategoriasPostorden();
       }
    }   
}
