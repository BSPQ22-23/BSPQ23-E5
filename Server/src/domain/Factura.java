package domain;

import java.util.Date;
import java.util.List;

public class Factura {
	 private int numero;
	    private Date fechaEmision;
	    private List<Servicio> servicios;
	    private double totalAPagar;
	    private Reserva reserva;

	    public Factura(int numero, Date fechaEmision, List<Servicio> servicios, double totalAPagar, Reserva reserva) {
	        this.numero = numero;
	        this.fechaEmision = fechaEmision;
	        this.servicios = servicios;
	        this.totalAPagar = totalAPagar;
	        this.reserva = reserva;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public void setNumero(int numero) {
	        this.numero = numero;
	    }

	    public Date getFechaEmision() {
	        return fechaEmision;
	    }

	    public void setFechaEmision(Date fechaEmision) {
	        this.fechaEmision = fechaEmision;
	    }

	    public List<Servicio> getServicios() {
	        return servicios;
	    }

	    public void setServicios(List<Servicio> servicios) {
	        this.servicios = servicios;
	    }

	    public double getTotalAPagar() {
	        return totalAPagar;
	    }

	    public void setTotalAPagar(double totalAPagar) {
	        this.totalAPagar = totalAPagar;
	    }

	    public Reserva getReserva() {
	        return reserva;
	    }

	    public void setReserva(Reserva reserva) {
	        this.reserva = reserva;
	    }

	    public void agregarServicio(Servicio servicio) {
	        servicios.add(servicio);
	    }

	    public void quitarServicio(Servicio servicio) {
	        servicios.remove(servicio);
	    }
}
