/**
 * Clase encargada de gestionar la iluminación de las pistas.
 * 
 * @author [Cristhian Alexis Garcia Hernandez]
 */
class GestorIluminacion {
    private boolean[] iluminacion;

    /**
     * Constructor que inicializa la iluminación de las pistas.
     * 
     * @param maxPistas Número máximo de pistas.
     */
    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    /**
     * Enciende las luces de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación se activó correctamente, false si el ID de pista es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga las luces de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación se desactivó correctamente, false si el ID de pista es inválido.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }
}
