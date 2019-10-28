package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class exchange extends AppCompatActivity{
    Double rate_Dollar;
    Double rate_Euro;
    Double rate_Won;

    private static final String TAG = "BasketActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        rate_Dollar = 7.14;
        rate_Euro = 11.11;
        rate_Won = 0.8;
    }
    public void dollar(View a) {
        exchange(rate_Dollar);

    }
    public void euro(View a) {
        exchange(rate_Euro);

    }
    public void won(View a) {
        exchange(rate_Won);

    }
    public void config(View a) {
        Intent config = new Intent(this,exchange_1.class);
        config.putExtra("dollar_rate_key",rate_Dollar);
        config.putExtra("euro_rate_key",rate_Euro);
        config.putExtra("won_rate_key",rate_Won);
        // startActivity(config);

        startActivityForResult(config,1);

    }


    public void exchange(double rate){
        EditText firsPrice = findViewById(R.id.input);
        TextView finalPrice = findViewById(R.id.result);
        double price = rate* Float.parseFloat((firsPrice.getText().toString()));
        finalPrice.setText(String.format("%.2f",price));

    }

    public boolean onC(Menu menu){
        getMenuInflater().inflate(R.menu.rate,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==2){
            Bundle bundle = data.getExtras();
            rate_Dollar = bundle.getDouble("dollar_key",0.1f);
            rate_Euro = bundle.getDouble("euro_key",0.1f);
            rate_Won = bundle.getDouble("won_key",0.1f);

            Log.i(TAG, "onActivityResult: ");
            Log.i(TAG, "dollar: " + rate_Dollar);
            Log.i(TAG, "euro: "+ rate_Euro);

        }
    }
}
