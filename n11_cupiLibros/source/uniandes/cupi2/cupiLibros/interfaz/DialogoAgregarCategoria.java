package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
 * Dialogo que permite agregar una nueva categor�a
 */
public class DialogoAgregarCategoria extends JDialog implements ActionListener
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
     * Ventana principal de la aplicaci�n
     */
    private InterfazCupiLibros principal;
    
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Campo de texto con el c�digo de la categor�a
     */
    private JTextField txtCodigo;

    /**
     * Campo de texto con el nombre de la categor�a
     */
    private JTextField txtNombre;
    
   /**
     * �rea de texto con descripci�n de la categor�a
     */
    private JTextArea areaDescripcion;
    
    /**
     * Panel con un scroll que contiene a areaDescripcion
     */
    private JScrollPane scrollDescripcion;
    
    /**
     * Bot�n Agregar
     */
    private JButton btnAgregar;
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo para agregar una categor�a
     * @param ventana Ventana principal de la aplicaci�n. ventana != null
     */
    public DialogoAgregarCategoria(InterfazCupiLibros ventana) 
    {
    	principal = ventana;
    	
    	setLayout( new BorderLayout( ) );
        setSize(280, 200);
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Agregar Categor�a");
        setResizable(false);
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(0, 50));
        panel1.setLayout(new GridLayout(2, 2));
        
        panel1.add(new JLabel(" C�digo: "));
        txtCodigo = new JTextField();
        panel1.add(txtCodigo);

        panel1.add(new JLabel(" Nombre: "));
        txtNombre = new JTextField();
        panel1.add(txtNombre);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        
        areaDescripcion = new JTextArea();
        areaDescripcion.setLineWrap(true);
        
        scrollDescripcion = new JScrollPane( areaDescripcion );
        scrollDescripcion.setPreferredSize(new Dimension(0, 80));
        scrollDescripcion.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDescripcion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDescripcion.setBorder(new TitledBorder(" Descripci�n: "));
        panel2.add(scrollDescripcion, BorderLayout.NORTH);
        
        add(panel1, BorderLayout.NORTH);        
        add(panel2, BorderLayout.CENTER);
        
        btnAgregar = new JButton(AGREGAR);
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
                
        add(btnAgregar, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    
    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
     */
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if(comando.equals(AGREGAR))
		{
			String nombre = txtNombre.getText();
			String codigo = txtCodigo.getText();
			String descripcion = areaDescripcion.getText();
			
			if(nombre != null && !nombre.isEmpty() && codigo != null && !codigo.isEmpty() && 
					descripcion != null && !descripcion.isEmpty())
			{
				try
				{
					int numCodigo = Integer.parseInt(codigo);
					if(numCodigo >= 0)
					{
						principal.agregarCategoria(codigo, nombre, descripcion);
						this.dispose();
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
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese la informaci�n completa de la categor�a", "Error", JOptionPane.ERROR_MESSAGE);				
			}
		}
	}
}