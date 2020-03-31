package com.mohammed.guidofmaysan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.mohammed.guidofmaysan.Hospital;
import com.mohammed.guidofmaysan.Hotel;
import com.mohammed.guidofmaysan.Marshes;
import com.mohammed.guidofmaysan.Mosque;
import com.mohammed.guidofmaysan.R;
import com.mohammed.guidofmaysan.Resturant;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        CardView first  = root.findViewById(R.id.first);
        CardView first1 = root.findViewById(R.id.first1);
        CardView first2 = root.findViewById(R.id.first2);
        CardView first3 = root.findViewById(R.id.first3);
        CardView first5 = root.findViewById(R.id.first5);

        first.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getContext(), Mosque.class));
        }
        });
        first1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Hotel.class));
            }
        });
        first2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Resturant.class));
            }
        });
        first3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Hospital.class));
            }
        });

        first5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Marshes.class));
            }
        });

        return root;
    }
}