package com.example.yappingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText username, password;
	Button signin , createaccount;
	TextView t1,t2 ; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.etUsername);
		password = (EditText) findViewById(R.id.etPassword);
		signin = (Button) findViewById(R.id.bSignIn);
		createaccount = (Button)findViewById(R.id.createaccount) ;
		t1 = (TextView)findViewById(R.id.createanaccount) ;
		t2 = (TextView)findViewById(R.id.forgotpassword) ;
		createaccount.setOnClickListener(this) ;
		signin.setOnClickListener(this);

		

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String x = username.getText().toString();
		String y = password.getText().toString();
		if (x.equals("")) {
           Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT).show() ;
		} 
		
		else if (y.equals("")) {
	           Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show() ;
			} 
		
		else {
			startActivity(new Intent(getApplicationContext(), Home.class));
		}
	}

}
