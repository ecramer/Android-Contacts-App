package com.example.cram_a4;

import java.util.UUID;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ContactFragment extends Fragment {
	
	public static final String EXTRA_CONTACT_ID = "com.example.cram_a3.contactIntent.contactID";
	
	private Contact mContact;
	private TextView mContactName;
	private TextView mContactNumber;
	private ImageView mContactPhoto;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		UUID contactID = (UUID)getArguments().getSerializable(EXTRA_CONTACT_ID);
		mContact = ContactList.get(getActivity()).getContact(contactID);
		
	}
	
	public static ContactFragment newInstance(UUID contactID){
		
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CONTACT_ID, contactID);
		ContactFragment fragment = new ContactFragment();
		fragment.setArguments(args);
		
		return fragment;
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		
		View v = inflater.inflate(R.layout.fragment_contact, parent, false);
		getActivity().setTitle(mContact.getFirstName() + " " + mContact.getLastName());
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			
		}
		
		mContactName = (TextView)v.findViewById(R.id.contact_name);
		mContactName.setText(mContact.getFirstName() + " " + mContact.getLastName());
		
		mContactNumber = (TextView)v.findViewById(R.id.contact_number);
		mContactNumber.setText(mContact.getPhoneNumber());
		
		mContactPhoto = (ImageView)v.findViewById(R.id.contact_image);
		
		String packageName = this.getClass().getPackage().getName();
		
		int resID = getResources().getIdentifier(mContact.getPhoto(), "drawable", packageName);
		mContactPhoto.setBackgroundColor(Color.GRAY);
		mContactPhoto.setImageResource(resID);		
		return v;
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(getActivity());
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		
		}
		
	}

}
