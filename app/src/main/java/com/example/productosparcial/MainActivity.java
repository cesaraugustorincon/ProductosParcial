package com.example.productosparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    ListView LVProduct;
    List<Producto> lstPt;

    Button btnSave,btnInfo,btnConIva,btnSinIva;
    EditText etNombre,etCodigo,etValor,etIsExcento,etCategoria,etDescripcion;
    CheckBox ChExcento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPt =  new ArrayList<>();



        LVProduct = findViewById(R.id.ListVProducto);

        btnSave = findViewById(R.id.btnSave);
        btnInfo = findViewById(R.id.btnInfo);
        btnConIva = findViewById(R.id.btnInIva);
        btnSinIva = findViewById(R.id.btnOutIva);

        etNombre = findViewById(R.id.etName);
        etCodigo = findViewById(R.id.etCodigo);
        etValor = findViewById(R.id.etValor);
        ChExcento = findViewById(R.id.etExcent);
        etDescripcion = findViewById(R.id.etDesc);
        etCategoria = findViewById(R.id.etCateg);


        ProductoAdapter adapter = new ProductoAdapter(this,lstPt);
        LVProduct.setAdapter(adapter);


        //lstPt.add(new Producto("alcohol","a",1000,false,"alcohol para limpiar","limpiador"));
        /*lstPt.add(new Producto("alcohol","a",1200,false,"alcohol para limpiar","limpiador"));
        lstPt.add(new Producto("alcohol","a",1300,false,"alcohol para limpiar","limpiador"));
        lstPt.add(new Producto("alcohol","a",1400,true,"alcohol para limpiar","limpiador"));
        lstPt.add(new Producto("alcohol","a",1500,true,"alcohol para limpiar","limpiador"));*/
        /*lstPt.add(new Producto("alcohol","a",1000,false,"alcohol para limpiar","limpiador"));
        lstPt.add(new Producto("alcohol","a",1000,false,"alcohol para limpiar","limpiador"));*/


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MAINaCTIVITY", "Promedio");
                int media = getPomedioProducto();
                Log.d("MAINaCTIVITY", Integer.toString(media));

                getProductosCostosos();


            }
        });

        btnConIva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProductsConIva();
            }


        });

        btnSinIva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getProductsSinIva();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = false;
                if (ChExcento.isChecked()){
                    check=true;
                }
                Log.d("LIST",Boolean.toString(check));
                lstPt.add(new Producto(etNombre.getText().toString()
                        ,etCodigo.getText().toString(),Integer.parseInt(etValor.getText().toString()),
                        check,etDescripcion.getText().toString(),etCategoria.getText().toString()));
                

                adapter.notifyDataSetChanged();

                clear();
            }
        });
    }

    private void getProductsConIva() {
        Producto k ;

        for (int i =0; i<lstPt.size();i++){
            k = lstPt.get(i);
            if (k.isExcento == false) {
                Log.d("MAINaCTIVITY", "Paga iva");
                Log.d("MAINaCTIVITY", k.toString());
            }

        }
    }

    private void getProductsSinIva() {
        Producto k ;

        for (int i =0; i<lstPt.size();i++){
            k = lstPt.get(i);
            if (k.isExcento ) {
                Log.d("MAINaCTIVITY", "No Paga iva");
                Log.d("MAINaCTIVITY", k.toString());
            }

        }
    }

    private void getProductosCostosos() {
        Stack stack = new Stack();
        Producto q;
        int valor = 0;
        for (int i =0; i<lstPt.size();i++){
            q = lstPt.get(i);
            if (q.getValor()>valor){
                valor = q.getValor();
                stack.push(q.getValor());
            }
        }

        Log.d("MAINaCTIVITY", stack.toString());
    }

    private int getPomedioProducto() {
        Producto prod;
        int prom=0,cont=0;
        for (int i = 0; i< lstPt.size();i++){
            prod = lstPt.get(i);
            prom+=prod.getValor();
            cont++;
        }
        prom = (prom/cont);
        Log.d("TTR",Integer.toString(prom));
        return prom;
    }

    private void clear() {
        etNombre.setText("");
        etCodigo.setText("");
        etValor.setText("");
        ChExcento.setText("");
        etDescripcion.setText("");
        etCategoria.setText("");
    }
}