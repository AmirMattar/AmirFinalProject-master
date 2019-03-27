package com.example.user.amir;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    TextView si;
    Button signin, signup;
    EditText username, pass;
    final String TAG = "firebase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        signin = findViewById(R.id.signin);
        signin.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        si = findViewById(R.id.si);

        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SignUp.class);//if clicked on the signup button the user will be sent to the signup page to create an account
                startActivity(intent);
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void signIn(final String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(getApplication(), MainActivity.class);
                            startActivity(i);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignIn.this, "Authentication failed.:"+email+" "+password,
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View v) {//checks if username and password match and if they exist in the database and if the username and password bar are empty a message will be sent to the user that the email and password are empty.
        //createUser
        if (v == signin) {
            String user = username.getText().toString();
            String password = pass.getText().toString();
            if (user.equals("")|| pass.equals("")) {
                Toast.makeText(SignIn.this, "Email  Or Passwrod Is Empty",
                        Toast.LENGTH_SHORT).show();
            } else {
                signIn(user, password);
            }

        }
    }

}

