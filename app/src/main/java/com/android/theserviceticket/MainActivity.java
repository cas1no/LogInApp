package com.android.theserviceticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	TextView textLoginData;
	TextView textPasswordData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		Button button = (Button) findViewById(R.id.buttonBack);

		textLoginData = findViewById(R.id.text_loginData);
		textPasswordData = findViewById(R.id.text_passwordData);

		textLoginData.setText(LogInActivity.loginData.get(LogInActivity.number));
		textPasswordData.setText(LogInActivity.passwordData.get(LogInActivity.number));

		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
}