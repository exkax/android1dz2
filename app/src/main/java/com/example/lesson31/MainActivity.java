package com.example.lesson31;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private Button go_buttom;
    private ImageView image;
    private TextInputEditText Username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_buttom = findViewById(R.id.go);
        Username = findViewById(R.id.f1);
        password = findViewById(R.id.f2);
        image = findViewById(R.id.image);
        initListeners();




        Username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {


                if (Username.getText().toString().length()>0){
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
}