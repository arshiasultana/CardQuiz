package com.example.quickcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    //Creating Variables

    private EditText name;
    private EditText password;
    private Button login;
    private TextView registerlink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //Assigning values to variables using ids
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.userpassword);
        login = (Button) findViewById(R.id.login);
        registerlink = (TextView) findViewById(R.id.linktoregister);


        //setting on click listener to the registration link
        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });


        //setting onclick listener for login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validating inside on click
                validate(name.getText().toString(),password.getText().toString());

            }
        });

    }

           //function for validating the username and password
    private void validate (String username1, String userpassword1){
        if((username1.equals("Admin")) && (userpassword1.equals("1234")))
        {
            Intent intent = new Intent(Login.this, HomeScreen.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Unable to Login. Invalid username or password", Toast.LENGTH_SHORT).show();
        }

        if(name.getText().toString().equals(" "));
        {
            name.setError("Field cannot be empty");

         }
         if(password.getText().toString().equals(""));
         {
             password.setError("Field cannot be empty");
        }

    }


}
