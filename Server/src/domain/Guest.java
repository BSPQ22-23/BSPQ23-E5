package domain;

public class Guest {

	private String name;
    private String surname;
	private String nick;
	private String password;
    private String dni;
    private int age;
    private String cityOfProvenance;
    private boolean isHotelOwner;

    public Guest(String name, String surname,String nick, String password, String dni, int age, String cityOfProvenance, boolean isHotelOwner) {
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.password = password;
        this.dni = dni;
        this.age = age;
        this.cityOfProvenance = cityOfProvenance;
        this.isHotelOwner = isHotelOwner;
    }

    public boolean isHotelOwner() {
		return isHotelOwner;
	}

	public void setHotelOwner(boolean isHotelOwner) {
		this.isHotelOwner = isHotelOwner;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}
