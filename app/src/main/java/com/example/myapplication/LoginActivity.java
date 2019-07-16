package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        if(intent.hasExtra("join")){
            String sJoin = intent.getExtras().getString("join");
            Toast.makeText(LoginActivity.this, "회원가입 완료하였습니다.", Toast.LENGTH_SHORT).show();
        }

        final EditText txtId = findViewById(R.id.txtId);
        final EditText txtPwd = findViewById(R.id.txtPwd);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnJoin = findViewById(R.id.btnJoin);

        btnLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void  onClick(View view){
                String txtIdValue = txtId.getText().toString();
                String txtPwdValue = txtPwd.getText().toString();

                if(txtIdValue.equals("") || txtPwdValue.equals("")){
                    Toast.makeText(LoginActivity.this, "아이디와 패스워드 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnJoin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
    }
}
