package br.com.ddmsoftware.agendadopet;

import android.content.ContentValues;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmoraes on 14/09/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    static List<PetTableModel> dbList;
    static Context context;

    RecyclerAdapter(Context context, List<PetTableModel>dbList){
        this.dbList = new ArrayList<PetTableModel>();
        this.context = context;
        this.dbList = dbList;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.id.setText(dbList.get(position).get_id());
        holder.name.setText(dbList.get(position).getPet_Name());
        holder.sex.setText(dbList.get(position).getPet_Sex());
        holder.birthday.setText(dbList.get(position).getPet_BirthDate());
        holder.breed.setText(dbList.get(position).getPet_Breed());
        holder.species.setText(dbList.get(position).getPet_Species());
        holder.moreInfo.setText(dbList.get(position).getPet_MoreInfo());
        holder.owner.setText(dbList.get(position).getPet_Owner());
        holder.picture.setText(dbList.get(position).getPet_Picture());

    }

    @Override
    public int getItemCount() {

        return dbList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView id, name, species, breed, sex, moreInfo, vet, birthday, owner, picture;

        public ViewHolder(View itemLayoutView){
            super(itemLayoutView);

            id = (TextView)itemLayoutView.findViewById(R.id.tvPetId);
            name = (TextView)itemLayoutView.findViewById(R.id.tvPetName);
            species = (TextView)itemLayoutView.findViewById(R.id.tvPetspecies);
            breed = (TextView)itemLayoutView.findViewById(R.id.tvPetBreed);
            sex = (TextView)itemLayoutView.findViewById(R.id.tvPetSex);
            moreInfo = (TextView)itemLayoutView.findViewById(R.id.tvPetMoreInfo);
            //vet = (TextView)itemLayoutView.findViewById(R.id.tvpet)
            birthday = (TextView)itemLayoutView.findViewById(R.id.tvPetBirthDay);
            owner = (TextView)itemLayoutView.findViewById(R.id.tvPetOwner);
            picture = (TextView)itemLayoutView.findViewById(R.id.tvPetPicture);
        }

        @Override
        public void onClick(View v){

            Intent intent = new Intent(context, Consulta2.class);

            Bundle extras = new Bundle();
            extras.putInt("position",getAdapterPosition());
            intent.putExtras(extras);

            /*
            int i=getAdapterPosition();
            intent.putExtra("position", getAdapterPosition());*/
            context.startActivity(intent);
            Toast.makeText(RecyclerAdapter.context, "you have clicked Row " + getAdapterPosition(), Toast.LENGTH_LONG).show();

            Toast.makeText(RecyclerAdapter.context, "Estoy Aki.", Toast.LENGTH_SHORT).show();
        }

    }
}
