package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiLibros.mundo.Libro;

/**
 * Panel con la lista de libros de la biblioteca
 */
public class PanelListaLibros extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
	/**
	 * Constante que representa el comando de ver en detalle un libro
	 */
    private final static String VER = "Ver detalle";
            
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Lista con los libros
     */
    private JList listaLibros;
    
    /**
     * Panel con un scroll que contiene la lista de Libros
     */
    private JScrollPane scroll;
    
    /**
     * Botón para ver la información de un libro
     */
    private JButton botonVer;
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    
    /**
     * Constructor del panel con la lista de libros
     */
    public PanelListaLibros()
    {   
        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5), new TitledBorder( " Libros " ) ) );
        setPreferredSize(new Dimension(250, 0));
        
        listaLibros = new JList();
        listaLibros.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        scroll = new JScrollPane(listaLibros );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        
        botonVer = new JButton( VER );
        botonVer.setActionCommand( VER );
        botonVer.addActionListener( this );
        
        add( scroll, BorderLayout.CENTER );
        add( botonVer, BorderLayout.SOUTH);
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de libros con la lista recibida por parámetro
     * @param nuevaLista La lista con los libros. nuevaLista != null
     */
    public void refrescarLista(ArrayList nuevaLista)
    {
        listaLibros.setListData( nuevaLista.toArray( ) );
        if(!nuevaLista.isEmpty())
        	listaLibros.setSelectedIndex(0);   
    }
       
    /**
     * Manejo de los eventos de los botones
     * @param evento Acción que generó el evento. evento != null
     */
    public void actionPerformed( ActionEvent evento )
    {
       String comando = evento.getActionCommand();
       if( comando.equals( VER ) )
       {
    	   if(listaLibros.getSelectedValue( ) != null)
           {
               Libro libro = (Libro) listaLibros.getSelectedValue( );
               DialogoVerLibro dialogoLibro = new DialogoVerLibro(libro);
               dialogoLibro.setVisible(true);
           }
    	   else
    	   {
    		   JOptionPane.showMessageDialog(null, "Primero debe crear un libro", "Ver Información Libro", JOptionPane.ERROR_MESSAGE);
    	   }
       } 
    }
}
