package com.example.lesson31;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private Button go_buttom;
    private ImageView image;
    private TextInputEditText pass_btn, user_btn;
    private TextInputLayout user,pass;
    private String login;
    private int lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_buttom = findViewById(R.id.go);
        pass_btn = findViewById(R.id.f2);
        user_btn = findViewById(R.id.f1);
       user = findViewById(R.id.Username);
        pass = findViewById(R.id.Password);
        image = findViewById(R.id.image);
        initListeners();
        go_buttom.setOnClickListener(view -> go_j());


        pass_btn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {


                if (pass_btn.getText().toString().length()>0){
                    go_buttom.setBackgroundColor(getColor(R.color.black));
                } else {
                    go_buttom.setBackgroundColor(getColor(R.color.gray));

                }
            }
        });
    }


    private void initListeners() {
        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(image);
    }


    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }


    }

    private boolean validate_name() {
        if (user_btn.getText().toString().trim().isEmpty()) {
            user.setError("EnterName");
            requestFocus(user_btn);
            return false;
        }
        return true;


    }private boolean validate_pass() {
        if (pass_btn.getText().toString().trim().isEmpty()) {
            pass.setError("Введите пароль!");
            requestFocus(pass_btn);
            return false;
        } else {
            if (pass_btn.getText().toString().trim().length() < 6) {
                pass.setError("Пароль не должен быть меньше 6 ");
                requestFocus(pass_btn);
                return false;
            }
        }
        return true;


    }

    private void go_j() {
        if (!validate_name()){
            return;
        }
        if (!validate_pass())
        {
            return;
        }


        String sname = user_btn.getText().toString().trim() + "";
        String snam = pass_btn.getText().toString().trim() + "";
        go_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDate();
            }
        });
    }
    public void sendDate()
    {
        login = user_btn.getText().toString().trim();
        lock = Integer.parseInt(pass_btn.getText().toString().trim());
        Intent i = new Intent(MainActivity.this,MainActivity2.class);


        i.putExtra(MainActivity2.NAME,login);
        i.putExtra(MainActivity2.AGE,lock);


        startActivity(i);





    }


}