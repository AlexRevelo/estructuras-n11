package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Dialogo que permite eliminar un libro de la biblioteca
 */
public class DialogoEliminarLibro extends JDialog implements ActionListener
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

	/**
	 * Comando Eliminar
	 */
	private final static String ELIMINAR = "Eliminar";
	
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
     * Botón Eliminar
     */
    private JButton btnEliminar;
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo para eliminar un libro
     * @param ventana Ventana principal de la aplicación. ventana != null
     */
    public DialogoEliminarLibro(InterfazCupiLibros ventana) 
    {
    	principal = ventana;
    	
    	setLayout( new BorderLayout() );
        setSize(280, 130);
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Eliminar Libro");
        setResizable(false);
        
        JPanel panel1 = new JPanel();
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
        
        add(panel1, BorderLayout.CENTER);        
        
        btnEliminar = new JButton(ELIMINAR);
        btnEliminar.setActionCommand(ELIMINAR);
        btnEliminar.addActionListener(this);
                
        add(btnEliminar, BorderLayout.SOUTH);
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
		if(comando.equals(ELIMINAR))
		{
			String codigo = txtCodigo.getText();
			String codigoCategoria = txtCodigoCategoria.getText();
			
			if(codigo != null && !codigo.isEmpty() && codigoCategoria != null && !codigoCategoria.isEmpty())
			{
				try
				{
					int numCodigo = Integer.parseInt(codigoCategoria);
					if(numCodigo >= 0)
					{
						String isbn = codigoCategoria + "." + codigo;
						principal.eliminarLibro(codigoCategoria, isbn);
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "El código de la categoría debe ser un valor numérico positivo", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(this, "El código de la categoría debe ser un valor numérico", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese la información completa del código ISBN del libro", "Error", JOptionPane.ERROR_MESSAGE);				
			}
		}
	}
}
