package com.mohammed.guidofmaysan.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.mohammed.guidofmaysan.R;
import java.io.IOException;
import java.io.InputStream;

public class AboutCodeFragment extends Fragment {

    String text;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about_code, container, false);
        final TextView textView = root.findViewById(R.id.textView3);
        text= getResources().getString(R.string.code_about);
        int size;
        InputStream input;
        try {
            input =getResources().getAssets().open(text);
            size = input.available();
            byte[] addtxt = new byte[size];
            input.read(addtxt);
            input.close();
            String txt=new String(addtxt);
            textView.setText(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }


}