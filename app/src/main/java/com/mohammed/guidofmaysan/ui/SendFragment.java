package com.mohammed.guidofmaysan.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.mohammed.guidofmaysan.R;

public class SendFragment extends Fragment {

    TextView mEditTextTo;
    EditText mEditTextSubject, mEditTextMessage;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_send, container, false);
        mEditTextTo =root.findViewById(R.id.edit_text_to);
        mEditTextSubject =root.findViewById(R.id.edit_text_subject);
        mEditTextMessage =root.findViewById(R.id.edit_text_message);
        Button buttonSend =root.findViewById(R.id.button_send);
        //عند الضغط على زر الارسال
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        return root;
    }
    private void sendMail() {
        //لجلب المعلومات من الاكتفدي
        String recipientList = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();
        //لنقل المعلومات بواسطه الانتينت
        Uri uri = Uri.parse("mailto:" + recipientList);
        Intent intent = new Intent(Intent.ACTION_SEND,uri);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        // startActivity(Intent.createChooser(intent,"Chooser Title"));
        //نوع المعلومات
        //intent.setData(Uri.parse("mailto:"));
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "اختر تطبيق GMAIL"));
    }
}