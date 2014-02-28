package com.example.cram_a4;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class ContactList {
	
	private ArrayList<Contact> mContacts;
	private static ContactList sContactList;
	private Context mAppContext;
	
	private ContactList(Context appContext) {
		
		mAppContext = appContext;
		mContacts = new ArrayList<Contact>();
		Contact c = new Contact("Jon", "Snow", "519-333-9999", "jon_snow");
		mContacts.add(c);
		c = new Contact("Arya", "Stark", "519-555-9999", "arya");
		mContacts.add(c);
		c = new Contact("Daenerys", "Targaryen", "519-666-9999", "dany");
		mContacts.add(c);
		
	}
	
	public void addContact(Contact c) {
		
		mContacts.add(c);
		
	}
	
	public static ContactList get(Context c) {
		
		if (sContactList == null) {
			
			sContactList = new ContactList(c.getApplicationContext());
			
		}
		return sContactList;
	}

	public ArrayList<Contact> getContacts() {
		return mContacts;
	}

	public Contact getContact(UUID id) {
		
		for (Contact c : mContacts){
			
			if(c.getID().equals(id)){
				
				return c;
				
			}
			
		}
		return null;
	}

	public Context getAppContext() {
		return mAppContext;
	}

	public void setAppContext(Context appContext) {
		mAppContext = appContext;
	}

}
