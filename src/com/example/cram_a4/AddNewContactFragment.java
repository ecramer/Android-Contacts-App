package com.example.cram_a4;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class AddNewContactFragment extends Fragment {
	
	private Button mAddNewContact;
	private EditText mPhoneNumberField;
	private EditText mFirstNameField;
	private EditText mLastNameField;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		
		View v = inflater.inflate(R.layout.fragment_new_contact, parent, false);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			
		}

		mPhoneNumberField = (EditText)v.findViewById(R.id.phone_number);
		mFirstNameField = (EditText)v.findViewById(R.id.first_name);
		mLastNameField = (EditText)v.findViewById(R.id.last_name);
		
		mAddNewContact = (Button)v.findViewById(R.id.add_new_button);
		mAddNewContact.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String phoneNumber = mPhoneNumberField.getText().toString();
				String firstName = mFirstNameField.getText().toString();
				String lastName = mLastNameField.getText().toString();
				Contact c = new Contact(firstName, lastName, phoneNumber, "ic_launcher");
				ContactList.get(getActivity()).addContact(c);
				NavUtils.navigateUpFromSameTask(getActivity());
			}
		});
		
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
