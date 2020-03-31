package com.mohammed.guidofmaysan.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mohammed.guidofmaysan.R;

import de.hdodenhof.circleimageview.CircleImageView;


class InfoViewHolder extends RecyclerView.ViewHolder {

    //TextView personId,personAge, personName;
    TextView name;
    ImageView imageItem;
    Button buttonItem,bottonMoreItem;


    InfoViewHolder(@NonNull View itemView) {
        super(itemView);

        name=itemView.findViewById(R.id.name);
        imageItem=itemView.findViewById(R.id.imageItem);
        buttonItem=itemView.findViewById(R.id.bottonItem);
        bottonMoreItem=itemView.findViewById(R.id.bottonMoreItem);

    }
}
