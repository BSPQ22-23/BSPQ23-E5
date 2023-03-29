package domain;

import java.sql.Date;
import java.util.List;

public class Reserva {
	private int id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Habitacion habitacion;
    private List<Huesped> huespedes;

    public Reserva(int id, Date fechaEntrada, Date fechaSalida, Habitacion habitacion, List<Huesped> huespedes) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
        this.huespedes = huespedes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public void agregarHuesped(Huesped huesped) {
        huespedes.add(huesped);
    }

    public void quitarHuesped(Huesped huesped) {
        huespedes.remove(huesped);
    }
}
