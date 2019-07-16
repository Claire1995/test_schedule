package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button btnJoin = findViewById(R.id.button2);

        btnJoin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void  onClick(View view){

                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);

                intent.putExtra("join", "Y");

                startActivity(intent);


            }
        });
    }
}
