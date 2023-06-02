package es.deusto.spq.server.domain;


/**
 * Represents a guest in the hotel management system.
 */
public class Guest {
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String cityOfProvenance;

    /**
     * Constructs a Guest object with the specified details.
     *
     * @param name              The name of the guest.
     * @param surname           The surname of the guest.
     * @param dni               The DNI (identification) of the guest.
     * @param age               The age of the guest.
     * @param cityOfProvenance  The city of provenance of the guest.
     */
    public Guest(String name, String surname, String dni, int age, String cityOfProvenance) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
        this.cityOfProvenance = cityOfProvenance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCityOfProvenance() {
        return cityOfProvenance;
    }

    public void setCityOfProvenance(String cityOfProvenance) {
        this.cityOfProvenance = cityOfProvenance;
    }

    /**
     * Compares the guest object with another object for equality.
     *
     * @param o The object to compare with.
     * @return  True if the guest object is equal to the specified object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Guest && ((Guest) o).dni.equals(dni);
    }

    /**
     * Returns a string representation of the guest.
     *
     * @return A string representation of the guest object.
     */
    @Override
    public String toString() {
        return "Guest [name=" + name + ", surname=" + surname + ", dni=" + dni + ", age=" + age +
                ", cityOfProvenance=" + cityOfProvenance + "]";
    }
}
