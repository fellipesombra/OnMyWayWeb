package br.com.onmyway.enums;

public enum RestResponseStatus {

    TRIP_FOUND(0);
    
    private int statusCode;

    private RestResponseStatus(int statusCode) {
	this.statusCode = statusCode;
    }

    public int getStatusCode() {
	return statusCode;
    }    
    
}
