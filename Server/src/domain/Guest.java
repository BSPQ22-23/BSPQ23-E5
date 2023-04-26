package domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import org.json.JSONObject;

import api.APIUtils;

@PersistenceCapable(detachable="true")
public class Guest {
	
	public static Guest fromJSON(JSONObject obj) {
		return new Guest(
				APIUtils.decode(obj.getString("name")),
				APIUtils.decode(obj.getString("surname")),
				APIUtils.decode(obj.getString("dni")),
				obj.getInt("age"),
				APIUtils.decode(obj.getString("cityOfProvenance"))
			);
	}
	
	@PrimaryKey
	@Persistent
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

	@Override
	public String toString() {
		return "Guest [name=" + name + ", surname=" + surname + ", dni="
				+ dni + ", age=" + age + ", cityOfProvenance=" + cityOfProvenance
				+ "]";
	}
}
