package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiLibros.mundo.Libro;

/**
 * Dialogo que permite ver la información de un libro
 */
public class DialogoVerLibro extends JDialog 
{
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Campo de texto con el código ISBN del libro
     */
    private JTextField txtIsbn;

    /**
     * Campo de texto con el nombre del libro
     */
    private JTextField txtNombre;
    
	/**
	 * Área de texto con los autores del libro
	 */
	private JTextArea areaAutores; 
	
    /**
     * Panel con un scroll que contiene a areaAutores
     */
    private JScrollPane scrollAutores;
	
	/**
	 * Campo de texto con el año de publicación del libro
	 */
	private JTextField txtAnioPublicacion; 
	
	/**
	 * Campo de texto con la editorial del libro
	 */
	private JTextField txtEditorial; 
	
	/**
	 * Campo de texto con el número de páginas del libro
	 */
	private JTextField txtPaginas; 
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo que muestra la información de un libro
     * @param libro Libro cuya información va a ser mostrada. libro != null
     */
    public DialogoVerLibro(Libro libro) 
    {
    	setLayout( new GridBagLayout() );
        setSize(320, 260);
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Ver Libro");
        setResizable(false);
        
        GridBagConstraints gbc= new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets( 2, 2, 2, 2 );
        
        add(new JLabel(" ISBN: "), gbc);
        
        gbc.gridx = 1;
        txtIsbn = new JTextField(libro.darIsbn());
        txtIsbn.setEditable(false);
        add(txtIsbn, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel(" Nombre: "), gbc);
        
        gbc.gridx = 1;
        txtNombre = new JTextField(libro.darNombre());
        txtNombre.setEditable(false);
        add(txtNombre, gbc);
        
        areaAutores = new JTextArea(libro.darAutores());
        areaAutores.setLineWrap(true);
        areaAutores.setEditable(false);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        scrollAutores = new JScrollPane( areaAutores );
        scrollAutores.setPreferredSize(new Dimension(0, 80));
        scrollAutores.setSize(new Dimension(0, 80));
        scrollAutores.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAutores.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollAutores.setBorder(new TitledBorder(" Autores: "));
        add(scrollAutores, gbc);
        
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel(" Año Publicación: "), gbc);
        
        gbc.gridx = 1;
        txtAnioPublicacion = new JTextField("" + libro.darAnioPublicacion());
        txtAnioPublicacion.setEditable(false);
        add(txtAnioPublicacion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel(" Editorial: "), gbc);
        
        gbc.gridx = 1;
        txtEditorial = new JTextField(libro.darEditorial());
        txtEditorial.setEditable(false);
        add(txtEditorial, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel(" Número de Páginas: "), gbc);
        
        gbc.gridx = 1;
        txtPaginas = new JTextField("" + libro.darNumPaginas());
        txtPaginas.setEditable(false);
        add(txtPaginas, gbc);
    }
}