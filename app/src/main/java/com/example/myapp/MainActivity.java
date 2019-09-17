package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView out;
    private static String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        out = findViewById(R.id.out);
        out.setText("Hello aaaaaa");

        EditText inp = findViewById(R.id.inp);
        String str = inp.getText().toString();
        inp.setText("123456");

        Button btn = findViewById(R.id.but);
        btn.setOnClickListener(this);


    }
    public void onClick(View v){
        Log.i(TAG,"onClick:................");
        out.setText("AAAAAAAAA");
    }
}
