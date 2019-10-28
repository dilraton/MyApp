package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class changeWD extends AppCompatActivity implements View.OnClickListener{
    TextView out1 = findViewById(R.id.out);
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_wd);

        EditText in = findViewById(R.id.in);
        float input1 = Float.parseFloat(in.getText().toString());

        Button but1 = findViewById(R.id.but1);

        TextView out1 = findViewById(R.id.out);
        out1.setOnClickListener(this);

        output = (input1-32)/1.8;
    }

    public void onClick(View v){

        out1.setText(String.format("%.2f",output));
    }
}
