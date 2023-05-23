package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GuestTest {

	private Guest guest;
	private String name;
	private String surname;
	private String dni;
	private int age;
	private String cityOfProvenance;

	@Before
	public void setUp() {
		name = "John";
		surname = "Doe";
		dni = "123456789";
		age = 30;
		cityOfProvenance = "Example City";

		guest = new Guest(name, surname, dni, age, cityOfProvenance);
	}

	@Test
	public void testGetName() {
		assertEquals(name, guest.getName());
	}

	@Test
	public void testSetName() {
		String newName = "Jane";
		guest.setName(newName);
		assertEquals(newName, guest.getName());
	}

	@Test
	public void testGetSurname() {
		assertEquals(surname, guest.getSurname());
	}

	@Test
	public void testSetSurname() {
		String newSurname = "Smith";
		guest.setSurname(newSurname);
		assertEquals(newSurname, guest.getSurname());
	}

	@Test
	public void testGetDni() {
		assertEquals(dni, guest.getDni());
	}

	@Test
	public void testSetDni() {
		String newDni = "987654321";
		guest.setDni(newDni);
		assertEquals(newDni, guest.getDni());
	}

	@Test
	public void testGetAge() {
		assertEquals(age, guest.getAge());
	}

	@Test
	public void testSetAge() {
		int newAge = 35;
		guest.setAge(newAge);
		assertEquals(newAge, guest.getAge());
	}

	@Test
	public void testGetCityOfProvenance() {
		assertEquals(cityOfProvenance, guest.getCityOfProvenance());
	}

	@Test
	public void testSetCityOfProvenance() {
		String newCityOfProvenance = "New City";
		guest.setCityOfProvenance(newCityOfProvenance);
		assertEquals(newCityOfProvenance, guest.getCityOfProvenance());
	}

	@Test
	public void testEquals() {
		Guest sameGuest = new Guest(name, surname, dni, age, cityOfProvenance);
		Guest differentGuest = new Guest("Different", "Guest", "987654321", 25, "Different City");

		assertEquals(true, guest.equals(sameGuest));
		assertEquals(false, guest.equals(differentGuest));
	}

	@Test
	public void testToString() {
		String expectedToString = "Guest [name=" + name + ", surname=" + surname + ", dni=" + dni + ", age=" + age
				+ ", cityOfProvenance=" + cityOfProvenance + "]";
		assertEquals(expectedToString, guest.toString());
	}
}
