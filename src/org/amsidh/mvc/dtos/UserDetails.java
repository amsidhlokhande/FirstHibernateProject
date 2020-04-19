/**
 * 
 */
package org.amsidh.mvc.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author VIRU
 * 
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	//@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	/*
	 * GenerationType.TABLE will create a HIBERNATE_SEQUENCES table first in the database for storing primary key 
	 */
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="USER_NAME")
	private String userName;
    @Column(name="JOINED_DATE")
    @Temporal(TemporalType.DATE)
    //@Temporal(TemporalType.TIME)
    //@Temporal(TemporalType.TIMESTAMP)
    private Date joinedDate;
    /*
     * if you declared a field as @Transient or static then it will not persist to the database 
     * */
    @Transient
    @Column(name="ADDRESS")
	private String address;
    @Column(name="DESCRIPTION")
    @Lob
    private String description;
	
	
	/**
	 * 
	 */
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param userId
	 * @param userName
	 * @param joinedDate
	 * @param address
	 * @param description
	 */
	public UserDetails(String userName, Date joinedDate,
			String address, String description) {
		super();
		//this.userId = userId;
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.address = address;
		this.description = description;
	}


	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the joinedDate
	 */
	public Date getJoinedDate() {
		return joinedDate;
	}


	/**
	 * @param joinedDate the joinedDate to set
	 */
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
