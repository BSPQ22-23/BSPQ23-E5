package es.deusto.spq.server.domain;


public class Guest {
	
	
	
    private String dni;
	private String name;
    private String surname;
    private int age;
    private String cityOfProvenance;

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
    
    public boolean equals(Object o) {
    	System.out.println(o instanceof Guest && ((Guest)o).dni.equals(dni));
    	return o instanceof Guest && ((Guest)o).dni.equals(dni);
    }

	@Override
	public String toString() {
		return "Guest [name=" + name + ", surname=" + surname + ", dni="
				+ dni + ", age=" + age + ", cityOfProvenance=" + cityOfProvenance
				+ "]";
	}
}
