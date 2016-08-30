package com.findme.domain;

public enum ProfessionalType {
	DOCTOR(0), 
	LAYER(1), 
	BARBER(2), 
	MUSIC_TEACHER(3), 
	TM_TEACHER(4);
	
	private int type;
	
	ProfessionalType(int type){
		this.type = type;
	}
	
	public static ProfessionalType valueOf(int type) throws IllegalArgumentException{
		for(ProfessionalType t : ProfessionalType.values()) {
			if(t.type == type) {
				return t;	
			}
		}
		
		throw new IllegalArgumentException("Invalid professional types " + type);
	}
}
