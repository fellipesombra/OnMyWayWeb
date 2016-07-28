package br.com.onmyway.dom.entity;

import java.io.Serializable;
import java.util.Date;

public class Trip implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private Date endTime;
    private User user;
    private int finished;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Date getEndTime() {
	return endTime;
    }

    public void setEndTime(Date endTime) {
	this.endTime = endTime;
    }

    public int getFinished() {
	return finished;
    }

    public void setFinished(int finished) {
	this.finished = finished;
    }
}
