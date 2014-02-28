package com.example.cram_a4;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactListFragment extends ListFragment {
	
	private ArrayList<Contact> mContacts;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		getActivity().setTitle(R.string.contact_title);
		mContacts = ContactList.get(getActivity()).getContacts();
		
		ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(getActivity(), android.R.layout.simple_list_item_1,mContacts);
		setListAdapter(adapter);
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Contact c = (Contact)(getListAdapter()).getItem(position);
		Intent i = new Intent(getActivity(),ContactActivity.class);
		i.putExtra(ContactFragment.EXTRA_CONTACT_ID,c.getID());
		startActivity(i);
		
	}
	
	@Override
	public void onResume(){
		
		super.onResume();
		ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(getActivity(), android.R.layout.simple_list_item_1,mContacts);
		setListAdapter(adapter);
		
		
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_contact_list, menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch(item.getItemId()){
		case R.id.menu_item_new_contact:
			Intent i = new Intent(getActivity(),AddNewContactActivity.class);
			startActivity(i);
			
		default:
			return super.onOptionsItemSelected(item);
		}
		
		
	}
	

}
