package com.findme.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
   name="recordType",
   discriminatorType=DiscriminatorType.STRING
)
public abstract class User {
	@Id @GeneratedValue
	private Long Id;
	
	private String firstName;
    private String lastName;
	private String profilePicture;
	private String emailAddress;
	private String phoneNumber;
	
	@Embedded
    private Address address;
	
	/**F|M*/
    private Character gender;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	private String otherInfo;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	private UserAccount userAccount;
}
