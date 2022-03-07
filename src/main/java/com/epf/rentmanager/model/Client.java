package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Client {
	private String name;
	private String lastname;
	private LocalDate birthdate;
	private String mail;
	private long id;
	
	public Client(String name, String lastname, LocalDate birthdate, String mail,  long id) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.mail = mail;
		this.id =id;
		
	
	}
	  public Client(long id) {
	        this.id = id;
	    }
	
	public Client(String name, String lastname, LocalDate birthdate, String mail ) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getlastname() {
		return lastname;
	}

	public LocalDate getbirthdate() {
		return birthdate;
	}


	public String getMail() {
		return mail;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public void setbirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public long id() {
		return id;
	}
	@Override
	public String toString() {
		return "Client [name=" + name + ", lastname=" + lastname + ", birthdate=" + birthdate + ", mail=" + mail
				+ ", id=" + id + "]";
	}

	
	
}
