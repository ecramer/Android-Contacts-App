package com.example.cram_a4;


import java.util.UUID;

import android.support.v4.app.Fragment;

public class ContactActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		UUID contactID = (UUID)getIntent().getSerializableExtra(ContactFragment.EXTRA_CONTACT_ID);
		
		return ContactFragment.newInstance(contactID);
	}



}
