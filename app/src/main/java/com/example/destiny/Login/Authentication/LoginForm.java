package com.example.destiny.Login.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.destiny.R;

public class LoginForm extends AppCompatActivity {

    private PinView pinView;
    private Button next;
    private TextView topText,textU;
    private EditText userName, userPhone;
    private ConstraintLayout first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);




    }


    public void onClick(View v) {

        if (next.getText().equals("Let's go!")) {
            String name = userName.getText().toString();
            String phone = userPhone.getText().toString();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)) {
                next.setText("Verify");
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                topText.setText("I Still don't trust you.\nTell me something that only two of us know.");
            } else {
                Toast.makeText(LoginForm.this, "Please enter the details", Toast.LENGTH_SHORT).show();
            }
        } else if (next.getText().equals("Verify")) {
            String OTP = pinView.getText().toString();
            if (OTP.equals("3456")) {
                pinView.setLineColor(Color.GREEN);
                textU.setText("OTP Verified");
                textU.setTextColor(Color.GREEN);
                next.setText("Next");
            } else {
                pinView.setLineColor(Color.RED);
                textU.setText("X Incorrect OTP");
                textU.setTextColor(Color.RED);
            }
        }

    }
}
