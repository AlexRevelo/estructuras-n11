package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Dialogo que permite agregar un nuevo libro
 */
public class DialogoAgregarLibro extends JDialog implements ActionListener
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

	/**
	 * Comando Agregar
	 */
	private final static String AGREGAR = "Agregar";
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCupiLibros principal;
    
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Campo de texto con el código de la categoría del libro
     */
    private JTextField txtCodigoCategoria;

    /**
     * Campo de texto con el código del libro
     */
    private JTextField txtCodigo;
    
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
    
    /**
     * Botón Agregar
     */
    private JButton btnAgregar;
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo para agregar un libro
     * @param ventana Ventana principal de la aplicación. ventana != null
     */
    public DialogoAgregarLibro(InterfazCupiLibros ventana) 
    {
    	principal = ventana;
    	
    	setLayout( new BorderLayout() );
        setSize(280, 320);
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Agregar Libro");
        setResizable(false);
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(0, 75));
        panel1.setBorder( new TitledBorder(" ISBN: ") );
        panel1.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc= new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets( 2, 2, 2, 2 );
        
        txtCodigoCategoria = new JTextField();
        panel1.add(txtCodigoCategoria, gbc);
        
        gbc.weightx = 0.0;
        gbc.gridx = 1;
        panel1.add(new JLabel("."), gbc);
        
        gbc.weightx = 1.0;
        gbc.gridx =2;
        txtCodigo = new JTextField();
        panel1.add(txtCodigo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblCategoria = new JLabel("Categoría");
        lblCategoria.setForeground(Color.GRAY);
        lblCategoria.setFont(new Font("Arial", Font.PLAIN, 11));
        lblCategoria.setVerticalAlignment(JLabel.TOP);
        lblCategoria.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(lblCategoria, gbc);
        
        gbc.gridx = 2;
        
        JLabel lblCodigoL = new JLabel("Código Libro");
        lblCodigoL.setForeground(Color.GRAY);
        lblCodigoL.setFont(new Font("Arial", Font.PLAIN, 11));
        lblCodigoL.setVerticalAlignment(JLabel.TOP);
        lblCodigoL.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(lblCodigoL, gbc);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 2, 5, 0, 5 );
        gbc.weightx = 0.35;
        panel2.add(new JLabel(" Nombre: "), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.65;
        txtNombre = new JTextField();
        panel2.add(txtNombre, gbc);
        
        areaAutores = new JTextArea();
        areaAutores.setLineWrap(true);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        scrollAutores = new JScrollPane( areaAutores );
        scrollAutores.setSize(new Dimension(0, 80));
        scrollAutores.setPreferredSize(new Dimension(0, 80));
        scrollAutores.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAutores.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollAutores.setBorder(new TitledBorder(" Autores: "));
        panel2.add(scrollAutores, gbc);
        
        gbc.weightx = 0.35;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(new JLabel(" Año Publicación: "), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.65;
        txtAnioPublicacion = new JTextField();
        panel2.add(txtAnioPublicacion, gbc);

        gbc.weightx = 0.35;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel2.add(new JLabel(" Editorial: "), gbc);
        
        gbc.weightx = 0.65;
        gbc.gridx = 1;
        txtEditorial = new JTextField();
        panel2.add(txtEditorial, gbc);
        
        gbc.weightx = 0.35;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel2.add(new JLabel(" Número de Páginas: "), gbc);
        
        gbc.weightx = 0.65;
        gbc.gridx = 1;
        txtPaginas = new JTextField();
        panel2.add(txtPaginas, gbc);
        
        add(panel1, BorderLayout.NORTH);        
        add(panel2, BorderLayout.CENTER);
        
        btnAgregar = new JButton(AGREGAR);
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
                
        add(btnAgregar, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento. e != null
     */
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if(comando.equals(AGREGAR))
		{
			String nombre = txtNombre.getText();
			String codigo = txtCodigo.getText();
			String codigoCategoria = txtCodigoCategoria.getText();
			String numPaginasS = txtPaginas.getText();
			String editorial = txtEditorial.getText();
			String anioS = txtAnioPublicacion.getText();
			String autores = areaAutores.getText();
			
			if(nombre != null && !nombre.isEmpty() && codigo != null && !codigo.isEmpty() && 
					autores != null && !autores.isEmpty() && codigoCategoria != null && 
					!codigoCategoria.isEmpty() && numPaginasS != null && !numPaginasS.isEmpty() &&
					editorial != null && !editorial.isEmpty() && anioS != null && !anioS.isEmpty())
			{
				try
				{
					int numCodigo = Integer.parseInt(codigoCategoria);
					int anio = Integer.parseInt(anioS);
					int numPaginas = Integer.parseInt(numPaginasS);
					if(numCodigo >= 0 && anio > 0 && numPaginas > 0)
					{
						String isbn = codigoCategoria + "." + codigo;
						principal.agregarLibro(codigoCategoria, isbn, nombre, autores, anio, editorial, numPaginas);
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "El código de la categoría, el año de publicación y el número de páginas deben ser un valores numéricos positivos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(this, "El código de la categoría, el año de publicación y el número de páginas deben ser un valores numéricos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese la información completa del libro", "Error", JOptionPane.ERROR_MESSAGE);				
			}
		}
	}
}