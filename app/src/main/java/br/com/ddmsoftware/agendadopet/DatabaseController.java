package br.com.ddmsoftware.agendadopet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dmoraes on 12/09/2016.
 */
public class DatabaseController {

    private CreateDatabase database;
    private SQLiteDatabase db;

    public DatabaseController(Context context) {

        database = new CreateDatabase(context);

    }

    public String insertPetData(String pPetName, String pPetSpecies, String pPetBreed, String pPetSex, String pPetBirthDate, String pMoreInfo, String pPetOwner, String pPetPicture) {

        ContentValues contentValues;

        long resultado;
        // Abre o banco de Dados para Escrita
        db = database.getWritableDatabase();

        contentValues = new ContentValues();

        contentValues.put(CreateDatabase.PET_NAME, pPetName);
        contentValues.put(CreateDatabase.PET_SPECIES, pPetSpecies);
        contentValues.put(CreateDatabase.PET_BREED, pPetBreed);
        contentValues.put(CreateDatabase.PET_SEX, pPetSex);
        contentValues.put(CreateDatabase.PET_BIRTHDATE, pPetBirthDate);
        contentValues.put(CreateDatabase.PET_MOREINFO, pMoreInfo);
        contentValues.put(CreateDatabase.PET_OWNER, pPetOwner);
        contentValues.put(CreateDatabase.PET_PICTURE, pPetPicture);

        resultado = db.insert(CreateDatabase.PET_TABLE, null, contentValues);

        if (resultado==-1){
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso.";
        }

    }

    public Cursor loadPetData() {
        Cursor resultSet;

        // Define os campos que serão retornados na consulta
        String[] fields = {database.PET_ID, database.PET_NAME, database.PET_SPECIES, database.PET_BREED, database.PET_BIRTHDATE, database.PET_SEX, database.PET_MOREINFO, database.PET_OWNER, database.PET_PICTURE};

        // Abre o Banco de Dados no formato Read-Only
        db = database.getReadableDatabase();

        // Faz a Consulta no Banco -- Modo Query
        resultSet = db.query(database.PET_TABLE, fields, null,null, null, null, null);


        // Faz a Consulta no Banco -- Modo rawQery -- ANSI-SQL
        //resultSet = db.rawQuery("SELECT * FROM PET_TABLE",null);

        if (resultSet!=null) {
            resultSet.moveToFirst();
        }

        db.close();
        return resultSet;


    }
}
