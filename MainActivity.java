package com.example.apirest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText TxtCodigo;
    TextView TxtNombre, TxtDescripcion, TxtPrecio;
    ImageView ImgProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, RetrofitAct.class);
        startActivity(intent);
        finish();

        TxtCodigo = findViewById(R.id.edtCodigo);
        TxtNombre = findViewById(R.id.tvNombre);
        TxtDescripcion = findViewById(R.id.tvDescripcion);
        TxtPrecio = findViewById(R.id.tvPrecio);
        ImgProducto = findViewById(R.id.imgProducto);
    }

    public void buscarProducto(View view){

    }
}