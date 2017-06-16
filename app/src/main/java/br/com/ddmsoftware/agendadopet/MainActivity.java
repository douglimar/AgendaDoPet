package br.com.ddmsoftware.agendadopet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    DatabaseController CRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button) findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CadastroPet.class);

                startActivity(intent);
                /*
                CRUD = new DatabaseController(MainActivity.this);

                String resultado = CRUD.insertPetData("TED", "Cachorro","Poodle", "Macho", "5/5/2016", "", "Douglimar", "");

                Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_SHORT).show();
*/
            }
        });

        Button btnConsulta = (Button) findViewById(R.id.button2);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Consulta.class);

                startActivity(intent);

            }
        });

    }

}
