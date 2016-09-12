package br.com.ddmsoftware.agendadopet;

import android.content.ContentValues;
import android.content.Context;
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
}
