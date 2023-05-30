package es.deusto.spq.server;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;




public class GuestTest {
	private Guest guest1;
    private Guest guest2;

    @Before
    public void setUp() {
        String name1 = "John";
        String surname1 = "Doe";
        String dni1 = "123456789";
        int age1 = 30;
        String cityOfProvenance1 = "New York";

        String name2 = "Jane";
        String surname2 = "Smith";
        String dni2 = "987654321";
        int age2 = 25;
        String cityOfProvenance2 = "Los Angeles";

        guest1 = new Guest(name1, surname1, dni1, age1, cityOfProvenance1);
        guest2 = new Guest(name2, surname2, dni2, age2, cityOfProvenance2);
    }

    @Test
    public void testGetName() {
        assertEquals("John", guest1.getName());
        assertEquals("Jane", guest2.getName());
    }

    @Test
    public void testSetName() {
        guest1.setName("Mike");
        assertEquals("Mike", guest1.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Doe", guest1.getSurname());
        assertEquals("Smith", guest2.getSurname());
    }

    @Test
    public void testSetSurname() {
        guest1.setSurname("Johnson");
        assertEquals("Johnson", guest1.getSurname());
    }

    @Test
    public void testGetDni() {
        assertEquals("123456789", guest1.getDni());
        assertEquals("987654321", guest2.getDni());
    }

    @Test
    public void testSetDni() {
        guest1.setDni("987654321");
        assertEquals("987654321", guest1.getDni());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, guest1.getAge());
        assertEquals(25, guest2.getAge());
    }

    @Test
    public void testSetAge() {
        guest1.setAge(35);
        assertEquals(35, guest1.getAge());
    }

    @Test
    public void testGetCityOfProvenance() {
        assertEquals("New York", guest1.getCityOfProvenance());
        assertEquals("Los Angeles", guest2.getCityOfProvenance());
    }

    @Test
    public void testSetCityOfProvenance() {
        guest1.setCityOfProvenance("Chicago");
        assertEquals("Chicago", guest1.getCityOfProvenance());
    }

    @Test
    public void testEquals() {
        Guest guest3 = new Guest("John", "Doe", "123456789", 30, "New York");
        Guest guest4 = new Guest("John", "Smith", "987654321", 25, "Los Angeles");

        assertTrue(guest1.equals(guest3));
        assertFalse(guest1.equals(guest2));
    }

    @Test
    public void testToString() {
        String expectedString1 = "Guest [name=John, surname=Doe, dni=123456789, age=30, cityOfProvenance=New York]";
        String expectedString2 = "Guest [name=Jane, surname=Smith, dni=987654321, age=25, cityOfProvenance=Los Angeles]";

        assertEquals(expectedString1, guest1.toString());
        assertEquals(expectedString2, guest2.toString());
    }

}
