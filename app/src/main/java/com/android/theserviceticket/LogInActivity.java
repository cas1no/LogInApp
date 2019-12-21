// 411.428571429
// 731.428571429

package com.android.theserviceticket;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import java.util.ArrayList;
import android.content.Intent;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

	EditText getLoginData;
	EditText getPasswordData;

	public static ArrayList<String> loginData = new ArrayList<String>();
	public static ArrayList<String> passwordData = new ArrayList<String>();
	public static int number = 0;

	int countNumber = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getLoginData = findViewById(R.id.textLogin);
		getPasswordData = findViewById(R.id.textPassword);

		findViewById(R.id.buttonSignUp).setOnClickListener(this);
		findViewById(R.id.buttonLogIn).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.buttonSignUp:
				signUp();
				break;

			case R.id.buttonLogIn:
				logIn();
				break;
		}
	}

	public void signUp() {

		if (getLoginData.getText().length() != 0 && getPasswordData.getText().length() != 0) {

			if (!loginData.contains(getLoginData.getText().toString())) {

				loginData.add(getLoginData.getText().toString());
				passwordData.add(getPasswordData.getText().toString());

				number = loginData.size() - 1;

				findViewById(R.id.buttonLogIn).setClickable(true);
				countNumber = 5;

				startMainActivity();
			}
		}
	}

	public void logIn() {

		if (getLoginData.getText().length() != 0 && getPasswordData.getText().length() != 0) {

			String tempLoginData = getLoginData.getText().toString();
			String tempPasswordData = getPasswordData.getText().toString();

			if (loginData.contains(tempLoginData)) {

				int position = loginData.indexOf(tempLoginData);

				if (tempPasswordData.equals(passwordData.get(position))) {

					number = position;
					countNumber = 5;

					startMainActivity();
				} else
					countNumber--;

			} else
				countNumber--;

			if (countNumber == 0)
				findViewById(R.id.buttonLogIn).setClickable(false);

		}
	}

	public void startMainActivity() {
		Intent action = new Intent(this,MainActivity.class);
		startActivity(action);
	}

}
