package com.mohammed.guidofmaysan.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohammed.guidofmaysan.MapsActivity;
import com.mohammed.guidofmaysan.R;

import java.util.List;

public class InfoRecyclerAdapterOne extends RecyclerView.Adapter<InfoViewHolder> {

    private List<InfoModel> infoModels;
    Context context;
    Dialog dialogItem;
    public InfoRecyclerAdapterOne(List<InfoModel> infoModels, Context context) {
        this.infoModels = infoModels;
        this.context=context;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View personItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new InfoViewHolder(personItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final InfoViewHolder holder, final int position) {

        final InfoModel infoModel = infoModels.get(position);

     //   holder.personId.setText(String.valueOf(infoModel.getTitle()));
     //   holder.personAge.setText(String.valueOf(infoModel.getTitleOne()));
     //   holder.personName.setText(infoModel.getTitleTwe());
      //  new LoadImageAsync(holder).execute(infoModel.getImageBytes());
        holder.name.setText(infoModel.getName());

        new LoadImageAsync(holder).execute(infoModel.getImage());

        holder.buttonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, MapsActivity.class);
               intent.putExtra("val", infoModel.getX());
               intent.putExtra("vale", infoModel.getY());
                context.startActivity(intent);
            }
        });


        dialogItem = new Dialog(context);
        dialogItem.setContentView(R.layout.more_item);
        dialogItem.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      holder.bottonMoreItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           TextView nameItemMore =(TextView)dialogItem.findViewById(R.id.nameItemMore);
               ImageView imageItemMore =(ImageView) dialogItem.findViewById(R.id.imageItemMore);

                nameItemMore.setText(infoModel.getName());
                Bitmap bitmap = BitmapFactory.decodeByteArray(infoModel.getImage(),0, infoModel.getImage().length);
                 imageItemMore.setImageBitmap(bitmap);

              dialogItem.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return infoModels.size();
    }
}
