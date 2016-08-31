package com.findme.exception;

public enum BusinessError {

	PROFESSIONAL_NOT_FOUND(99, "Professional not found"),
	APPOINTMENT_NOT_FOUND(100, "Appointment not found"),
    VISITOR_HAS_NO_CONNECTION_WITH_OWNER_OF_THE_APPOINTMENT(101, "Visitor has no connection with the owner of the Appointment"),
    VISITOR_ALREADY_CONNECTED_TO_PROFESSIONAL(103, "Visitor has already connect to the professional"),
    APPOINTMENT_REACH_LIMIT(102, "No more capacity for this appointment");

    private int code;
    private String message;

    BusinessError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    public void throwException() throws BusinessException {
        throw new BusinessException(message, code);
    }
}
