package com.mohammed.guidofmaysan.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.mohammed.guidofmaysan.R;

import static com.mohammed.guidofmaysan.R.drawable.ic_im;

public class AboutDesignerFragment extends Fragment {

    Dialog dialogItem;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about_designer, container, false);
        final CardView cardView = root.findViewById(R.id.cv_designer);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogItem = new Dialog(getContext());
                dialogItem.setContentView(R.layout.more_item);
                dialogItem.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        TextView nameItemMore =(TextView)dialogItem.findViewById(R.id.nameItemMore);
                        ImageView imageItemMore =(ImageView) dialogItem.findViewById(R.id.imageItemMore);
                        nameItemMore.setText(getString(R.string.code_desiger));
                        imageItemMore.setImageDrawable(getResources().getDrawable(ic_im));
                        dialogItem.show();
            }
        });
        return root;
    }
}