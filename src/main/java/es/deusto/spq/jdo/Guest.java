package es.deusto.spq.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;




@PersistenceCapable(detachable = "true")
public class Guest implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private String dni;
	private String name;
	private String surname;
	private int age;
	private String cityOfProvenance;

	/**
	 * Creates a new instance of Guest.
	 * 
	 * @param name              the guest's name
	 * @param surname           the guest's surname
	 * @param dni               the guest's DNI
	 * @param age               the guest's age
	 * @param cityOfProvenance  the guest's city of provenance
	 */
	public Guest(String name, String surname, String dni, int age, String cityOfProvenance) {
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.age = age;
		this.cityOfProvenance = cityOfProvenance;
	}

	/**
	 * Returns the guest's name.
	 * 
	 * @return the guest's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the guest's name.
	 * 
	 * @param name the guest's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the guest's surname.
	 * 
	 * @return the guest's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the guest's surname.
	 * 
	 * @param surname the guest's surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Returns the guest's DNI.
	 * 
	 * @return the guest's DNI
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the guest's DNI.
	 * 
	 * @param dni the guest's DNI to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Returns the guest's age.
	 * 
	 * @return the guest's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the guest's age.
	 * 
	 * @param age the guest's age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the guest's city of provenance.
	 * 
	 * @return the guest's city of provenance
	 */
	public String getCityOfProvenance() {
		return cityOfProvenance;
	}

	/**
	 * Sets the guest's city of provenance.
	 * 
	 * @param cityOfProvenance the guest's city of provenance to set
	 */
	public void setCityOfProvenance(String cityOfProvenance) {
		this.cityOfProvenance = cityOfProvenance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Guest)) return false;
		Guest guest = (Guest) o;
		return dni.equals(guest.dni);
	}

	@Override
	public int hashCode() {
		return dni.hashCode();
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", surname=" + surname + ", dni=" + dni + ", age=" + age
				+ ", cityOfProvenance=" + cityOfProvenance + "]";
	}
}