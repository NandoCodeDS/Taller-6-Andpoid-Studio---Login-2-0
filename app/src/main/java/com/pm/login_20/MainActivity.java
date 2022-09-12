package com.pm.login_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Bienvenidos a Sci High";
    EditText userTV,passTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userTV = findViewById(R.id.editTextTextPersonName);
        passTV = findViewById(R.id.editTextTextPassword);
    }
    public void sendMessage(View view) {
        String us = userTV.getText().toString();
        String ps = passTV.getText().toString();
        if(us.equals("Orlando") && ps.equals("123")){
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) userTV;
            String message = editText.getText().toString()+" Bienvenido";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Usuario/Contraseña Incorrecto",Toast.LENGTH_LONG).show();
        }
        userTV.setText("");
        passTV.setText("");
    }
}