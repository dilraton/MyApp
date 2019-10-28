package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class exchange_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_1);

        Intent intent = getIntent();
        double dollar = intent.getDoubleExtra("dollar_rate_key",0.0f);
        double euro = intent.getDoubleExtra("euro_rate_key",0.0f);
        double won= intent.getDoubleExtra("won_rate_key",0.0f);


        EditText t1 = findViewById(R.id.show_dollar);
        t1.setText(String.format("%.2f",dollar));
        EditText t2 = findViewById(R.id.show_euro);
        t2.setText(String.format("%.2f",euro));
        EditText t3 = findViewById(R.id.show_won);
        t3.setText(String.format("%.2f",won));
    }
    public  void submit(View btn){
        EditText t1 = findViewById(R.id.show_dollar);
        EditText t2 = findViewById(R.id.show_euro);
        EditText t3 = findViewById(R.id.show_won);
        double newdollar = Double.parseDouble(t1.getText().toString());
        double neweuro = Double.parseDouble(t2.getText().toString());
        double newwon= Double.parseDouble(t3.getText().toString());

        Intent intent = getIntent();
        Bundle bdl = new Bundle();
        bdl.putDouble("dollar_key",newdollar);
        bdl.putDouble("euro_key",neweuro);
        bdl.putDouble("won_key",newwon);

        intent.putExtras(bdl);
        setResult(2,intent);

        finish();

    }
}
