package br.com.ddmsoftware.agendadopet;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by dmoraes on 14/09/2016.
 */
public class PetTableModel {

    private String _id;
    private String Pet_Name;
    private String Pet_Species;
    private String Pet_Breed;
    private String Pet_Sex;
    private String Pet_BirthDate;
    private String Pet_MoreInfo;
    private String Pet_Owner;

    private byte[] Pet_Picture;

    public byte[] getPet_Picture() {
        return Pet_Picture;
    }

    public void setPet_Picture(byte[] pet_Picture) {
        Pet_Picture = pet_Picture;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPet_Name() {
        return Pet_Name;
    }

    public void setPet_Name(String pet_Name) {
        Pet_Name = pet_Name;
    }

    public String getPet_Species() {
        return Pet_Species;
    }

    public void setPet_Species(String pet_Species) {
        Pet_Species = pet_Species;
    }

    public String getPet_Breed() {
        return Pet_Breed;
    }

    public void setPet_Breed(String pet_Breed) {
        Pet_Breed = pet_Breed;
    }

    public String getPet_Sex() {
        return Pet_Sex;
    }

    public void setPet_Sex(String pet_Sex) {
        Pet_Sex = pet_Sex;
    }

    public String getPet_BirthDate() {
        return Pet_BirthDate;
    }

    public void setPet_BirthDate(String pet_BirthDate) {
        Pet_BirthDate = pet_BirthDate;
    }

    public String getPet_MoreInfo() {
        return Pet_MoreInfo;
    }

    public void setPet_MoreInfo(String pet_MoreInfo) {
        Pet_MoreInfo = pet_MoreInfo;
    }

    public String getPet_Owner() {
        return Pet_Owner;
    }

    public void setPet_Owner(String pet_Owner) {
        Pet_Owner = pet_Owner;
    }



}
