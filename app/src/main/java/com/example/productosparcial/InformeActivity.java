package com.example.productosparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class InformeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);

        Bundle ext = this.getIntent().getExtras();
        //Log.d("TTTTAA",ext.toString());
        //ext.get("Prom");
        //Log.d("TTTTAA",);



    }
}