package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // img=(ImageView)findViewById(R.id.logo);

    }
public void onclick(View view){
    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
    startActivity(intent);
}

}