package com.mohammed.guidofmaysan;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mohammed.guidofmaysan.RecyclerView.InfoRecyclerAdapterOne;
import com.mohammed.guidofmaysan.SQLitePackage.SQLiteHelper;

public class Hospital extends Hotel {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital);

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle(R.string.hospital);
        setSupportActionBar(toolbar);

        layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.recycler_hospital);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);
        infoModels = sqLiteHelper.getAll(getResources().getString(R.string.tabls_hospital),column);
        personRecyclerAdapter = new InfoRecyclerAdapterOne(infoModels,this);
        personRecycler.setAdapter(personRecyclerAdapter);


    }

}
