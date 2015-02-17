package uniandes.cupi2.cupiLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiLibros.mundo.Categoria;

/**
 * Dialogo que permite ver la información de una categoría
 */
public class DialogoVerCategoria extends JDialog 
{ 
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Campo de texto con el código de la categoría
     */
    private JTextField txtCodigo;

    /**
     * Campo de texto con el nombre de la categoría
     */
    private JTextField txtNombre;
    
   /**
     * Área de texto con descripción de la categoría
     */
    private JTextArea areaDescripcion;
    
    /**
     * Panel con un scroll que contiene a areaDescripcion
     */
    private JScrollPane scrollDescripcion;
        
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo que muestra la información de una categoría
     * @param categoria Categoría cuya información va a ser mostrada. categoria != null
     */
    public DialogoVerCategoria(Categoria categoria) 
    {
    	setLayout( new BorderLayout( ) );
        setSize(280, 170);
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Ver Categoría");
        setResizable(false);
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(0, 50));
        panel1.setLayout(new GridLayout(2, 2));
        
        panel1.add(new JLabel(" Código: "));
        txtCodigo = new JTextField(categoria.darCodigoCompuesto());
        txtCodigo.setEditable(false);
        panel1.add(txtCodigo);

        panel1.add(new JLabel(" Nombre: "));
        txtNombre = new JTextField(categoria.darNombre());
        txtNombre.setEditable(false);
        panel1.add(txtNombre);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        
        areaDescripcion = new JTextArea(categoria.darDescripcion());
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setEditable(false);
        
        scrollDescripcion = new JScrollPane( areaDescripcion );
        scrollDescripcion.setPreferredSize(new Dimension(0, 80));
        scrollDescripcion.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDescripcion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDescripcion.setBorder(new TitledBorder(" Descripción: "));
        panel2.add(scrollDescripcion, BorderLayout.NORTH);
        
        add(panel1, BorderLayout.NORTH);        
        add(panel2, BorderLayout.CENTER);
    }
}