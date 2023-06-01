package es.deusto.spq.pojo;




public class UserData {

	
	
	private String nickname;
    private String lastname;
	private String password;
	
	public UserData( String nickname, String lastname, String password) {
		super();
		
		
		this.nickname = nickname;
		this.lastname = lastname;
		this.password = password;
		
	}

	public UserData(String nickname, String password) {
		super();
		this.nickname =nickname;
		this.password = password;
		
	}


	public UserData() {
		
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
		return "Register: nickname=" + nickname
				+ ", lastname=" + lastname +  ", password=" + password + "]";
	}
   
}