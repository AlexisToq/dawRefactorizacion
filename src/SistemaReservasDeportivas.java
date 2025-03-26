import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema de Reservas Deportivas que permite gestionar reservas de pistas deportivas.
 * Proporciona funcionalidades para reservar, cancelar reservas y gestionar la iluminación de las pistas.
 * 
 * @author [Cristhian Alexis Garcia Hernandez]
 */
public class SistemaReservasDeportivas {
    private List<Reserva> reservas;
    private GestorIluminacion gestorIluminacion;
    private static final int MAX_PISTAS = 10; // Máximo de 10 pistas

    /**
     * Constructor que inicializa la lista de reservas y el gestor de iluminación.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        setGestorIluminacion(new GestorIluminacion(MAX_PISTAS));
    }

    /**
     * Reserva una pista con un objeto Reserva.
     * 
     * @param reserva Objeto Reserva con los datos de la reserva.
     * @return true si la reserva se realizó con éxito, false si la pista ya estaba reservada.
     */
    public boolean reservarPista(Reserva reserva) {
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false; // La pista ya está reservada en esa fecha
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva específica.
     * 
     * @param idReserva Identificador de la reserva a cancelar.
     * @return true si la reserva se canceló con éxito, false si no se encontró la reserva.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha específica.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha   Fecha a verificar.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha) {
        return esFechaDisponible(idPista, fecha);
    }

    /**
     * Método privado para verificar si una fecha está disponible para una pista.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha   Fecha a verificar.
     * @return true si la fecha está disponible, false si ya está reservada.
     */
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }

	public GestorIluminacion getGestorIluminacion() {
		return gestorIluminacion;
	}

	public void setGestorIluminacion(GestorIluminacion gestorIluminacion) {
		this.gestorIluminacion = gestorIluminacion;
	}
}
