package domain;

public class Habitacion {
	private int numero;
    private String tipo;
    private int numMaxHuespedes;
    private int metros;

    public Habitacion(int numero, String tipo, int numMaxHuespedes, int metros) {
        this.numero = numero;
        this.tipo = tipo;
        this.numMaxHuespedes = numMaxHuespedes;
        this.metros = metros;
    }

    public int getNumero() {
        return numero;
    }

    public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}

	public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumMaxHuespedes() {
        return numMaxHuespedes;
    }

    public void setNumMaxHuespedes(int numMaxHuespedes) {
        this.numMaxHuespedes = numMaxHuespedes;
    }

}
