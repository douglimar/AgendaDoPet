package br.com.ddmsoftware.agendadopet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public class CadastroPet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // COMENTANDO AGORA -- 25.05.2017
        //Button btnTakeAPicture = (Button) findViewById(R.id.btnGetPicture);
        /*
        btnTakeAPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int SELECT_PICTURE = 1;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent,"SelectPicture"),SELECT_PICTURE);

            }


        });
        FIM DO MEU COMENTARIO TESTE */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                EditText edtName, edtSpecies, edtBreed, edtBirthday, edtSex, edtMoreInfo, edtOwner;
                ImageView imgPicture;

                edtName = (EditText)findViewById(R.id.edtPetName);
                edtSpecies = (EditText)findViewById(R.id.edtSpecies);
                edtBreed = (EditText)findViewById(R.id.edtRaca);
                edtBirthday = (EditText)findViewById(R.id.edtBirthday);
                edtSex = (EditText)findViewById(R.id.edtSex);
                edtMoreInfo = (EditText)findViewById(R.id.edtMoreInfo);
                edtOwner = (EditText)findViewById(R.id.edtOwner);
                //Comentando Agora -- 25.05

                /*imgPicture = (ImageView) findViewById(R.id.imageView);

                // ************** Extract Bytes of ImageView *****************************
                Bitmap mBitmap = ((BitmapDrawable)imgPicture.getDrawable()).getBitmap();
                ByteArrayOutputStream saida = new ByteArrayOutputStream();
                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, saida);
                byte[] myConvertedImage = saida.toByteArray();
                // ***********************************************************************
                Fim do meu comentario
                        */

                PetTableModel petModel = new PetTableModel();

                petModel.setPet_Name(edtName.getText().toString());
                petModel.setPet_Species(edtSpecies.getText().toString());
                petModel.setPet_Breed(edtBreed.getText().toString());
                petModel.setPet_BirthDate(edtBirthday.getText().toString());
                petModel.setPet_Sex(edtSex.getText().toString());
                petModel.setPet_MoreInfo(edtMoreInfo.getText().toString());
                petModel.setPet_Owner(edtOwner.getText().toString());
                //Comentando agora -- 25.5
                //petModel.setPet_Picture(myConvertedImage);

                DatabaseController CRUD = new DatabaseController(CadastroPet.this);

/*                String resultado  = CRUD.insertPetData(petModel.getPet_Name(), petModel.getPet_Species(), petModel.getPet_Breed(),petModel.getPet_Sex(),
                        petModel.getPet_BirthDate(),petModel.getPet_MoreInfo(), petModel.getPet_Owner(),petModel.getPet_Picture());
*/
                String resultado  = CRUD.insertPetData(petModel.getPet_Name(), petModel.getPet_Species(), petModel.getPet_Breed(),petModel.getPet_Sex(),
                        petModel.getPet_BirthDate(),petModel.getPet_MoreInfo(), petModel.getPet_Owner());

                Toast.makeText(CadastroPet.this, resultado, Toast.LENGTH_SHORT).show();



            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        Uri selectedImage = intent.getData();
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //imageView.setImageBitmap(bitmapImage);
        imageView.setImageURI(selectedImage);






        /*

        Bitmap bitmapImage;
        if (resultCode == Activity.RESULT_OK) {
            Uri selectedImage = intent.getData();
            try {
                bitmapImage = decodeBitmap(selectedImage);
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmapImage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // Show the Selected Image on ImageView

        }; */
    }

    public  Bitmap decodeBitmap(Uri selectedImage) throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

        final int REQUIRED_SIZE = 100;

        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);
    }

}
