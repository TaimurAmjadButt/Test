package com.trainoft.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	 public final static String EXTRA_MESSAGE = "com.trainoft.test.MESSAGE";
	 
	 EditText distance = null;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		distance = (EditText) findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void calculate(View view){
		RadioButton km = (RadioButton) findViewById(R.id.radioButton1);
		RadioButton miles = (RadioButton) findViewById(R.id.radioButton2);
		if(distance.getText().length() == 0){
			 Toast.makeText(this, "enter a valid number", Toast.LENGTH_LONG)  
             .show();
		}
		else{
			double inputValue = Double.parseDouble(distance.getText().toString());
			double result = 0;
			if(km.isChecked()){
				result = inputValue*0.621372;
			}
			else{
				result = inputValue*1.609344;
			}
			Intent displayResult = new Intent(this, SecondActivity.class);
			displayResult.putExtra("result", ""+result );
			startActivity(displayResult);
		}
	}
	/*
	public void sendMessage(View view) {
	    Intent intent = new Intent(this, SecondActivity.class);
	    EditText editText = (EditText) findViewById(R.id.edit_message);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	}
	*/

}
