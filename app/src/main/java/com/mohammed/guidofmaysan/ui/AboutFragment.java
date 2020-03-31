package com.mohammed.guidofmaysan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mohammed.guidofmaysan.MapsActivity;
import com.mohammed.guidofmaysan.R;

import java.io.IOException;
import java.io.InputStream;

public class AboutFragment extends Fragment {


    String text;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about, container, false);
        final TextView textView = root.findViewById(R.id.text_about);
        final ImageView  imageView= root.findViewById(R.id.image_about);

            text = getResources().getString(R.string.text_about);
        int size=0;
        InputStream input=null;
        try {
            input =getResources().getAssets().open(text);
            size = input.available();
            byte[] addtxt = new byte[size];
            input.read(addtxt);
            input.close();
            String txt=new String(addtxt);
            //  textView.setText(txt);
            textView.setText(txt);

        } catch (IOException e) {
            e.printStackTrace();
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //للانتقال الى اكتفي العرض
             Intent intent=new Intent(getContext(), MapsActivity.class) ;
                //ارسال معلومات الى اكتفتي العرض يتضمن اسم روت الفاير بيس واسم الانتقال الى اكتفتي اخرى
                intent.putExtra("val",31.852205);
                intent.putExtra("vale",47.150539);
                startActivity(intent);
            }
        });

        return root;
    }
}