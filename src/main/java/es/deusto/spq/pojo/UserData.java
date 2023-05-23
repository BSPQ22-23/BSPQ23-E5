package es.deusto.spq.pojo;

public class UserData {

	
    private String login;
 
	private String dni;
	private String nickname;
    private String lastname;
	private String city;
	private Boolean isHotelOwner ;
	
	public UserData(String dni, String nickname, String lastname, String city, Integer age,
			String password,Boolean isHotelOwner) {
		super();
		
		
		this.dni = dni;
		this.nickname = nickname;
		this.lastname = lastname;
		this.city = city;
		this.age = age;
		this.password = password;
		this.isHotelOwner = isHotelOwner;
	}




	public UserData(String nickname, String password,Boolean isHotelOwner) {
		super();
		this.nickname =nickname;
		this.password = password;
		this.isHotelOwner = isHotelOwner;
	}




	public Boolean getIsHotelOwner() {
		return isHotelOwner;
	}




	public void setIsHotelOwner(Boolean isHotelOwner) {
		this.isHotelOwner = isHotelOwner;
	}




	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

	private Integer age;
    private String password;

    public UserData() {
        // required by serialization
    }

    
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toStringLogin() {
        return "[nickname=" + nickname + ", password=" + password + "]";
    }



	public String toStringRegister() {
		return "Register: [dni=" + dni + ", nickname=" + nickname
				+ ", lastname=" + lastname + ", city=" + city + ", age=" + age + ", password=" + password + "]";
	}
   
}