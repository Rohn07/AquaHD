package com.example.aquahd;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    EditText email, password, phone, name, add;
    Button reg;
    RegObj ro;
    int mCounter;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Signup");

    //firebase authentication
    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);
        add = (EditText) findViewById(R.id.add);
        ro = new RegObj();
        reg = (Button) findViewById(R.id.signup);
        firebaseAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Long phn = Long.parseLong(phone.getText().toString().trim());
                ro.setEmail(email.getText().toString().trim());
                ro.setPass(password.getText().toString().trim());
                ro.setNumber(phn);
                ro.setUname(name.getText().toString().trim());
                ro.setAdd(add.getText().toString().trim());

                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                            email.setText("");
                            password.setText("");
                            phone.setText("");

                        }
                        else{
                            Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //creates unique id in firebase
                myRef.child("User" + mCounter++).setValue(ro);
            }
        });

    }

}
