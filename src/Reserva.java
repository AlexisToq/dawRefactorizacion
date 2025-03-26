/**
 * Representa una reserva en el sistema.
 * Contiene información sobre la pista reservada, la fecha y la duración de la reserva.
 * 
 * @author [Cristhian Alexis Garcia Hernandez]
 */
public class Reserva {
    private int idPista;
    private String fecha;
    private int duracion;

    /**
     * Constructor de la clase Reserva.
     * 
     * @param idPista  Identificador de la pista reservada.
     * @param fecha    Fecha de la reserva.
     * @param duracion Duración de la reserva en horas.
     */
    public Reserva(int idPista, String fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * Obtiene el identificador de la pista reservada.
     * 
     * @return El ID de la pista.
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * Obtiene la fecha de la reserva.
     * 
     * @return La fecha de la reserva en formato String.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la reserva.
     * 
     * @return La duración en horas.
     */
    public int getDuracion() {
        return duracion;
    }
}

