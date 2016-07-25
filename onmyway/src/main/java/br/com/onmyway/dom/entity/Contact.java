package br.com.onmyway.dom.entity;

public class Contact {
    private int id;
    private String cellphoneNumber;
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

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public String getCellphoneNumber() {
	return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
	this.cellphoneNumber = cellphoneNumber;
    }
}
