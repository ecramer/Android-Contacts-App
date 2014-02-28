package com.example.cram_a4;

import java.util.UUID;

public class Contact {
	
	private UUID mID;
	private String mFirstName;
	private String mLastName;
	private String mPhoneNumber;
	private String mPhoto;
	
	public Contact(String firstName, String lastName, String phoneNumber, String photo) {
		
		mID = UUID.randomUUID();
		mFirstName = firstName;
		mLastName = lastName;
		mPhoneNumber = phoneNumber;
		mPhoto = photo;
		
	}
	
	public Contact(){
		
		
	}

	public String getFirstName() {
		return mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public String getPhoto() {
		return mPhoto;
	}
	
	public UUID getID(){
		
		return mID;
		
	}
	
	@Override
	public String toString(){
		
		return mFirstName + " " + mLastName;
		
	}


}
