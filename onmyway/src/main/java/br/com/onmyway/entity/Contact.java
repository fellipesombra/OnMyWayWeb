package br.com.onmyway.entity;

public class Contact {
	private int id;
	private int cellphoneNumber;
	private String email;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(int cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
