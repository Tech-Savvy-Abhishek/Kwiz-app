package com.abhishek.kwizx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistarScreen extends AppCompatActivity {
    //ra
    public static String username_public;

    TextInputLayout layout_fullname, layout_email, layout_password, layout_username;
    TextView textViewLogin;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ProgressDialog progressDialog;
    CardView cardView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_screen);

        hooks();
    }

    public void hooks() {
        layout_fullname = findViewById(R.id.layout_fullname);
        layout_username = findViewById(R.id.layout_username);
        layout_password = findViewById(R.id.layout_password);
        layout_email = findViewById(R.id.layout_email);
        textViewLogin=findViewById(R.id.textViewLogin);
        textViewLogin.setTextColor(getResources().getColor(R.color.secondary_quizx));
        progressDialog=new ProgressDialog(this);
        cardView=findViewById(R.id.cardView);
        checkBox=findViewById(R.id.checkBox2);

    }


    public void createNewAccount(View view) {
        String fullname = layout_fullname.getEditText().getText().toString();
        String username = layout_username.getEditText().getText().toString();
        String email = layout_email.getEditText().getText().toString();
        String password = layout_password.getEditText().getText().toString();



        if (!username.isEmpty()) {
            layout_username.setError(null);
            layout_username.setErrorEnabled(false);
            if (!fullname.isEmpty()) {
                layout_fullname.setError(null);
                layout_fullname.setErrorEnabled(false);
                if (!email.isEmpty()) {
                    layout_email.setError(null);
                    layout_email.setErrorEnabled(false);
                    if (!password.isEmpty()) {
                        layout_password.setError(null);
                        layout_password.setErrorEnabled(false);
                        if(email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
                        {
                            progressDialog.setMessage("Creating new account. Please Wait...");
                            progressDialog.setTitle("Registration");
                            progressDialog.setCanceledOnTouchOutside(false);
                            progressDialog.show();
                            cardView.setCardBackgroundColor(getResources().getColor(R.color.green));

                            firebaseDatabase=FirebaseDatabase.getInstance();
                            reference=firebaseDatabase.getReference("appusers");

                            storingdata storingdataobj=new storingdata(username,fullname,email,password);
                            reference.child(username).setValue(storingdataobj);
                            Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show();

                            progressDialog.dismiss();
                            //ra
                            username_public=username;

                            check();


                            Intent i=new Intent(RegistarScreen.this, MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {

                            layout_email.setError("Please enter valid Email");
                        }
                    } else {
                        layout_password.setError("Please enter Password");
                    }
                } else {
                    layout_email.setError("Please enter an Email");
                }
            } else {
                layout_fullname.setError("Full name can't be empty");
            }
        } else {
            layout_username.setError("Username name can't be empty");
        }


    }

    public void goToLoginScreen(View view)
    {
        textViewLogin.setTextColor(getResources().getColor(R.color.black));
        Intent i=new Intent(this,LoginScreen.class);
        startActivity(i);
        finish();

    }


    public void check()
    {

        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        if(checkBox.isChecked())
        {
            editor.putString("remember",RegistarScreen.username_public);
        }
        else
        {
            editor.putString("remember","NULL");
        }

        editor.apply();


    }

}