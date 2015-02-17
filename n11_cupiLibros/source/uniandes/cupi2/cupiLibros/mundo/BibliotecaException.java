package uniandes.cupi2.cupiLibros.mundo;

/**
 * Representa una excepción de la biblioteca
 */
public class BibliotecaException extends Exception 
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de la excepción
     * @param mensaje Es el mensaje asociado con la excepción
     */
    public BibliotecaException( String mensaje )
    {
        super( mensaje );
    }	

}
