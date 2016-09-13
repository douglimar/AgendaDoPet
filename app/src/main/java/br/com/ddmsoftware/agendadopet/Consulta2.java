package br.com.ddmsoftware.agendadopet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Consulta2 extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseController CRUD = new DatabaseController(this);

        final Cursor resultSet = CRUD.loadPetData();

        String[] fieldNames = new String[] {CreateDatabase.PET_ID, CreateDatabase.PET_NAME, CreateDatabase.PET_SPECIES, CreateDatabase.PET_BREED, CreateDatabase.PET_BIRTHDATE,
                CreateDatabase.PET_SEX, CreateDatabase.PET_MOREINFO, CreateDatabase.PET_OWNER, CreateDatabase.PET_PICTURE};

        int[] idViews  = new int[]{R.id.tvPetId, R.id.tvPetName, R.id.tvPetspecies, R.id.tvPetBreed, R.id.tvPetBirthDay, R.id.tvPetSex, R.id.tvPetMoreInfo, R.id.tvPetOwner, R.id.tvPetPicture};


        // Campo Chave para Carregar os dados na tela
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_consulta2, resultSet, fieldNames, idViews, 0);

        lista = (ListView) findViewById(R.id.listView);

        lista.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
