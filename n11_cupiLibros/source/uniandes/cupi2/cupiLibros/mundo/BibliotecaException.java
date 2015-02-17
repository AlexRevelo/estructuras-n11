package uniandes.cupi2.cupiLibros.mundo;

/**
 * Representa una excepci�n de la biblioteca
 */
public class BibliotecaException extends Exception 
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de la excepci�n
     * @param mensaje Es el mensaje asociado con la excepci�n
     */
    public BibliotecaException( String mensaje )
    {
        super( mensaje );
    }	

}
