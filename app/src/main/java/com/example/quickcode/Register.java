package com.example.quickcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.widget.TextView;
import android.widget.Toast;


public class Register extends AppCompatActivity {


    //creating variables

    private EditText firstname,familyname,email,dob,newusername,newuserpassword;
    private Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //assigning values to variables using ids

        firstname= (EditText)findViewById(R.id.firstname);
        familyname= (EditText)findViewById(R.id.familyname);
        email= (EditText)findViewById(R.id.email);
        dob= (EditText)findViewById(R.id.dob);
        newusername= (EditText)findViewById(R.id.newusername);
        newuserpassword= (EditText)findViewById(R.id.newuserpassword);
        submit=(Button)findViewById(R.id.submit);

        //setting onclicklistener to submit

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting validations and error handlers
                final EditText emailValidate = (EditText)findViewById(R.id.email);
                String email = emailValidate.getText().toString().trim();
                String emailPattern = "([a-zA-Z0-9._])+@([a-z])+.+([a-z])";

                //setting validations for firstname
                if(firstname.getText().toString().equals(" ") )
                {
                  firstname.setError("Enter a valid first name");
                }
               if(firstname.length()<3 || firstname.length()>10 ){
                   firstname.setError("name should be between 3 to 10 characters");
                }

                //validating family name
                if(familyname.getText().toString().equals(" ")){
                    familyname.setError("Enter a valid family name");
                }
                if(familyname.length()<3 || familyname.length()>10 ) {
                    familyname.setError("name should be between 3 to 10 characters");
                }

                //validating date of birth

                if(dob.getText().toString().isEmpty()) {
                    dob.setError("DOB field is empty");
                }

                if (!dob.getText().toString().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
                    dob.setError("Please enter the correct date format 'MM/DD/YYYY'");
                }

                //validating newusername
                if(newusername.getText().toString().equals(" ")) {
                    newusername.setError("Enter a valid username");
                }
                if(newusername.length()<3 || newusername.length()>10 ) {
                    newusername.setError("username should be between 3 to 30 characters");
                }

                //validating new user password
                if(newuserpassword.getText().toString().equals(" ")) {
                    newuserpassword.setError("Enter a valid password");
                }
                if(newuserpassword.length()<3 || newusername.length()>10 ) {
                    newuserpassword.setError("username should be between 3 to 30 characters");
                }

                //validating email
                if (!email.matches(emailPattern)){
                    Toast.makeText(getApplicationContext(),"invalid email address. Please enter a valid email id",Toast.LENGTH_SHORT).show();
                    }


               else
               {
                   Toast.makeText(getApplicationContext(), "Registration complete", Toast.LENGTH_SHORT).show();

                   //code for moving back to login page if registration is complete
                   Intent intent = new Intent(Register.this, Login.class);
                   startActivity(intent);
               }

            }
        });



    }
}
