package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView loginLabel;
    TextView userNameLabel;
    TextView passwordLabel;
    EditText username;
    EditText password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginLabel = (TextView) findViewById(R.id.loginLable);
        userNameLabel = (TextView) findViewById(R.id.userNameLabel);
        passwordLabel = (TextView) findViewById(R.id.passwordLabel);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("password")){
                    Toast.makeText(MainActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else if(username.getText().toString() != "admin" && password.getText().toString().equals("password")){
                    Toast.makeText(MainActivity.this,"Invalid Username!",Toast.LENGTH_SHORT).show();
                }
                else if(username.getText().toString().equals("admin") && password.getText().toString() != "password"){
                    Toast.makeText(MainActivity.this,"Invalid Password!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Invalid Username & Password!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}