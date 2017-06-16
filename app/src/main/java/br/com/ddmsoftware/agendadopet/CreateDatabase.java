package br.com.ddmsoftware.agendadopet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public class CreateDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "agendapet.db";
    public static final Integer DB_VERSION = 2;

    // PET TABLE
    public static final String PET_TABLE = "Pet";
    public static final String PET_ID = "_id";
    public static final String PET_NAME = "Pet_Name";
    public static final String PET_SPECIES = "Pet_Species";
    public static final String PET_BREED = "Pet_Breed";
    public static final String PET_SEX = "Pet_Sex";
    public static final String PET_BIRTHDATE = "Pet_BirthDate";
    public static final String PET_MOREINFO = "Pet_MoreInfo";
    public static final String PET_OWNER = "Pet_Owner";
    //public static final String PET_PICTURE = "Pet_Picture";

    // PEST_CONTROL TABLE
    public static final String PESTCONTROL_TABLE = "PestControl";
    public static final String PESTCONTROL_ID = "_Id";
    public static final String PESTCONTROL_FK_PET_ID = "Pet_id";
    public static final String PESTCONTROL_MEDICINE_NAME = "PestControl_MedicineName";
    public static final String PESTCONTROL_DATE = "PestControl_Date";
    public static final String PESTCONTROL_RENEWALDATE = "PestControl_RenewalDate";

    // VET TABLE
    public static final String VET_TABLE = "VetTable";
    public static final String VET_ID = "_Id";
    public static final String VET_FK_PET_TABLE = "Pet_id";
    public static final String VET_NAME = "Vet_Name";
    public static final String VET_CLINIC = "Vet_Clinic";
    public static final String VET_ADDRESS = "Vet_Address";
    public static final String VET_PHONE1 = "Vet_Phone1";
    public static final String VET_PHONE2 = "Vet_Phone2";

    // VACCINE_CONTROL TABLE
    public static final String VACCINE_CONTROL_TABLE = "VaccineControl";
    public static final String VACCINE_ID = "_Id";
    public static final String VACCINE_FK_PET_ID = "Pet_id"; // INTEGER NOT NULL,
    public static final String VACCINE_LAB = "Vaccine_Lab"; // VARCHAR NOT NULL,
    public static final String VACCINE_STARTING_NO = "Vaccine_StartingNo"; //  VARCHAR NOT NULL,
    public static final String VACCINE_VETNAME = "Vaccine_VetName"; // VARCHAR NOT NULL,
    public static final String VACCINE_DATE = "Vaccine_Date"; // DATE NOT NULL,
    public static final String VACCINE_RENEWALDATE = "Vaccine_RenewalDate"; // DATE NOT NULL,

    // WORMING_CONTROL TABLE
    public static final String WORMINGCONTROL_TABLE = "WormingControl";
    public static final String WORMINGCONTROL_ID  = "_id";
    public static final String WORMINGCONTROL_FK_PET_ID = "Pet_id";
    public static final String WORMINGCONTROL_MEDICINENAME = "WormingControl_MedicineName";
    public static final String WORMINGCONTROL_DATE = "WormingControl_Date";
    public static final String WORMINGCONTROL_RENEWALDATE = "WormingControl_RenewalDate";

    public CreateDatabase(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String sql;

        sql =   " CREATE TABLE Pet (\n" +
                " _id INTEGER NOT NULL primary key autoincrement,\n" +
                " Pet_Name VARCHAR NOT NULL,\n" +
                " Pet_Species VARCHAR NOT NULL,\n" +
                " Pet_Breed VARCHAR NOT NULL,\n" +
                " Pet_Sex VARCHAR NOT NULL,\n" +
                " Pet_BirthDate VARCHAR NOT NULL,\n" +
                " Pet_MoreInfo VARCHAR NOT NULL,\n" +
                " Pet_Owner VARCHAR NOT NULL \n" +
               // " Pet_Picture BLOB\n" +
                " );\n" +
                "\n" +
                "\n" +
                " CREATE TABLE PestControl (\n" +
                " _id INTEGER NOT NULL primary key autoincrement,\n" +
                " Pet_id INTEGER NOT NULL,\n" +
                " PestControl_MedicineName VARCHAR NOT NULL,\n" +
                " PestControl_Date DATE NOT NULL,\n" +
                " PestControl_RenewalDate DATE\n" +
                " );\n" +
                "\n" +
                "\n" +
                " CREATE TABLE Vet (\n" +
                " _id INTEGER NOT NULL primary key autoincrement,\n" +
                " Pet_id INTEGER NOT NULL,\n" +
                " Vet_Name VARCHAR NOT NULL,\n" +
                " Vet_Clinic VARCHAR NOT NULL,\n" +
                " Vet_Address VARCHAR NOT NULL,\n" +
                " Vet_Phone1 VARCHAR,\n" +
                " Vet_Phone2 VARCHAR\n" +
                " );\n" +
                "\n" +
                "\n" +
                " CREATE TABLE VaccineControl (\n" +
                " _id INTEGER NOT NULL primary key autoincrement,\n" +
                " Pet_id INTEGER NOT NULL,\n" +
                " Vaccine_Lab VARCHAR NOT NULL,\n" +
                " Vaccine_StartingNo VARCHAR NOT NULL,\n" +
                " Vaccine_VetName VARCHAR NOT NULL,\n" +
                " Vaccine_Date DATE NOT NULL,\n" +
                " Vaccine_RenewalDate DATE NOT NULL,\n" +
                " CONSTRAINT VaccineControl_id_pk PRIMARY KEY (Vaccine_Id)\n" +
                " );\n" +
                " COMMENT ON TABLE VaccineControl IS 'Controle de Vacinacao';\n" +
                " COMMENT ON COLUMN VaccineControl.Vaccine_StartingNo IS 'Numero de Partida';\n" +
                "\n" +
                "\n" +
                " CREATE TABLE WormingControl (\n" +
                " WormingControl_id INTEGER NOT NULL,\n" +
                " Pet_id INTEGER NOT NULL,\n" +
                " WormingControl_MedicineName VARCHAR NOT NULL,\n" +
                " WormingControl_Date DATE NOT NULL,\n" +
                " WormingControl_RenewalDate DATE,\n" +
                " CONSTRAINT WormingControl_id_pk PRIMARY KEY (WormingControl_id)\n" +
                " );\n" +
                " COMMENT ON TABLE WormingControl IS 'Controle de Vermifugação';\n" +
                "\n" +
                "\n" +
                " ALTER TABLE WormingControl ADD CONSTRAINT Pet_ControleVermifugacao_fk\n" +
                " FOREIGN KEY (Pet_id)\n" +
                " REFERENCES Pet (Pet_id)\n" +
                " ON DELETE NO ACTION\n" +
                " ON UPDATE NO ACTION\n" +
                " NOT DEFERRABLE;\n" +
                "\n" +
                " ALTER TABLE VaccineControl ADD CONSTRAINT Pet_Vacinacao_fk\n" +
                " FOREIGN KEY (Pet_id)\n" +
                " REFERENCES Pet (Pet_id)\n" +
                " ON DELETE NO ACTION\n" +
                " ON UPDATE NO ACTION\n" +
                " NOT DEFERRABLE;\n" +
                "\n" +
                " ALTER TABLE Vet ADD CONSTRAINT Pet_Veterinario_fk\n" +
                " FOREIGN KEY (Pet_id)\n" +
                " REFERENCES Pet (Pet_id)\n" +
                " ON DELETE NO ACTION\n" +
                " ON UPDATE NO ACTION\n" +
                " NOT DEFERRABLE;\n" +
                "\n" +
                " ALTER TABLE PestControl ADD CONSTRAINT Pet_PestControl_fk\n" +
                " FOREIGN KEY (Pet_id)\n" +
                " REFERENCES Pet (Pet_id)\n" +
                " ON DELETE NO ACTION\n" +
                " ON UPDATE NO ACTION\n" +
                " NOT DEFERRABLE;";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PESTCONTROL_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + VACCINE_CONTROL_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WORMINGCONTROL_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + VET_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PET_TABLE);
        onCreate(sqLiteDatabase);

    }
}

/**
 * Created by dmoraes on 12/09/2016.
 *
 *
 CREATE TABLE Pet (
 Pet_id INTEGER NOT NULL,
 Pet_Name VARCHAR NOT NULL,
 Pet_Species VARCHAR NOT NULL,
 Pet_Breed VARCHAR NOT NULL,
 Pet_Sex VARCHAR NOT NULL,
 Pet_BirthDate VARCHAR NOT NULL,
 Pet_MoreInfo VARCHAR NOT NULL,
 Pet_Owner VARCHAR NOT NULL,
 Pet_Picture BLOB,
 CONSTRAINT Pet_pk PRIMARY KEY (Pet_id)
 );


 CREATE TABLE PestControl (
 PestControl_Id INTEGER NOT NULL,
 Pet_id INTEGER NOT NULL,
 PestControl_MedicineName VARCHAR NOT NULL,
 PestControl_Date DATE NOT NULL,
 PestControl_RenewalDate DATE,
 CONSTRAINT controle_pragas_id_pk PRIMARY KEY (PestControl_Id)
 );


 CREATE TABLE Vet (
 Vet_Id INTEGER NOT NULL,
 Pet_id INTEGER NOT NULL,
 Vet_Name VARCHAR NOT NULL,
 Vet_Clinic VARCHAR NOT NULL,
 Vet_Address VARCHAR NOT NULL,
 Vet_Phone1 VARCHAR,
 Vet_Phone2 VARCHAR,
 CONSTRAINT veterinario_id_pk PRIMARY KEY (Vet_Id)
 );


 CREATE TABLE VaccineControl (
 Vaccine_Id INTEGER NOT NULL,
 Pet_id INTEGER NOT NULL,
 Vaccine_Lab VARCHAR NOT NULL,
 Vaccine_StartingNo VARCHAR NOT NULL,
 Vaccine_VetName VARCHAR NOT NULL,
 Vaccine_Date DATE NOT NULL,
 Vaccine_RenewalDate DATE NOT NULL,
 CONSTRAINT VaccineControl_id_pk PRIMARY KEY (Vaccine_Id)
 );
 COMMENT ON TABLE VaccineControl IS 'Controle de Vacinacao';
 COMMENT ON COLUMN VaccineControl.Vaccine_StartingNo IS 'Numero de Partida';


 CREATE TABLE WormingControl (
 WormingControl_id INTEGER NOT NULL,
 Pet_id INTEGER NOT NULL,
 WormingControl_MedicineName VARCHAR NOT NULL,
 WormingControl_Date DATE NOT NULL,
 WormingControl_RenewalDate DATE,
 CONSTRAINT WormingControl_id_pk PRIMARY KEY (WormingControl_id)
 );
 COMMENT ON TABLE WormingControl IS 'Controle de Vermifugação';


 ALTER TABLE WormingControl ADD CONSTRAINT Pet_ControleVermifugacao_fk
 FOREIGN KEY (Pet_id)
 REFERENCES Pet (Pet_id)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION
 NOT DEFERRABLE;

 ALTER TABLE VaccineControl ADD CONSTRAINT Pet_Vacinacao_fk
 FOREIGN KEY (Pet_id)
 REFERENCES Pet (Pet_id)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION
 NOT DEFERRABLE;

 ALTER TABLE Vet ADD CONSTRAINT Pet_Veterinario_fk
 FOREIGN KEY (Pet_id)
 REFERENCES Pet (Pet_id)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION
 NOT DEFERRABLE;

 ALTER TABLE PestControl ADD CONSTRAINT Pet_PestControl_fk
 FOREIGN KEY (Pet_id)
 REFERENCES Pet (Pet_id)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION
 NOT DEFERRABLE;

 */
