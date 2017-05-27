package com.example.jdrod.squapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends AppCompatActivity {
    LoginButton facebookLoginButton;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        facebookLoginButton = (LoginButton)findViewById(R.id.login_button);
        facebookLoginButton.setReadPermissions("email");
        facebookLoginConnection();
    }
    void facebookLoginConnection(){
        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast toast = Toast.makeText(getBaseContext(), "Login",Toast.LENGTH_LONG);
                Log.d("Login Act","Login");
            }

            @Override
            public void onCancel() {
                Toast toast = Toast.makeText(getBaseContext(), "Cancel",Toast.LENGTH_LONG);
                Log.d("Login Act","Cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                Toast toast = Toast.makeText(getBaseContext(), "Error",Toast.LENGTH_LONG);
                Log.d("Login Act","Error");
            }
        });
    }
}
