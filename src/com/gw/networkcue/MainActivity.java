package com.gw.networkcue;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText edittextEmailAddress = (EditText)findViewById(R.id.etEmail);
		// final EditText edittextEmailSubject = (EditText)findViewById(R.id.email_subject);
		// final EditText edittextEmailText = (EditText)findViewById(R.id.email_text);

		final String edittextEmailSubject = "My Contact Details" ;
		final String edittextEmailText = "Hi, \n\n Great to meet you. \n I've attached my contact details below. You can import this .vcf file into your phone automatically." ;

		Button buttonSendEmail_intent = (Button)findViewById(R.id.btnEmail);

		buttonSendEmail_intent.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String emailAddress = edittextEmailAddress.getText().toString();
				//	String emailSubject = edittextEmailSubject.getText().toString();
				//	String emailText = edittextEmailText.getText().toString();
				String emailSubject = edittextEmailSubject;
				String emailText = edittextEmailText;

				String emailAddressList[] = {emailAddress};

				Intent intent = new Intent(Intent.ACTION_SEND); 
				intent.setType("plain/text");
				intent.putExtra(Intent.EXTRA_EMAIL, emailAddressList);  
				intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject); 
				intent.putExtra(Intent.EXTRA_TEXT, emailText); 
				startActivity(Intent.createChooser(intent, "Choose App to send email:"));

			}});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
