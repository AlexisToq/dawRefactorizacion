/**
 * Sistema de Reservas Deportivas que nos permite gestionar reservas de pistas deportivas.
 * Proporciona funcionalidades para reservar, cancelar reservas y gestionar la iluminación de las pistas.
 * 
 * @author [Cristhian Alexis Garcia Hernandez]
 */
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {
    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Máximo de 10 pistas

    /**
     * Constructor que inicializa la lista de reservas y el estado de iluminación de las pistas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Reserva una pista para una fecha y duración específica.
     * 
     * @param idPista  Identificador de la pista a reservar.
     * @param fecha    Fecha de la reserva.
     * @param duracion Duración de la reserva en horas.
     * @return true si la reserva se realizó con éxito, false si la pista ya estaba reservada.
     */
    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
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
     * Activa la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación se activó correctamente, false si el ID de pista es inválido.
     */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; //Id de pista invalido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Desactiva la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación se desactivó correctamente, false si el ID de pista es inválido.
     */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; //Id de pista invalido
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha y hora específica.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha   Fecha a verificar.
     * @param hora    Hora a verificar (no utilizada en la lógica actual).
     * @return true si la pista está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; //Id de pista invalido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no esta disponible en esa fecha
            }
        }
        return true; // La pista esta disponible
    }
}