package com.mohammed.guidofmaysan;


import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mohammed.guidofmaysan.RecyclerView.InfoRecyclerAdapterOne;
import com.mohammed.guidofmaysan.SQLitePackage.SQLiteHelper;


public class Mosque extends Hotel {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mosque);
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle(R.string.mosque);
        setSupportActionBar(toolbar);

        layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.recycler_mosque);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);
        infoModels = sqLiteHelper.getAll(getResources().getString(R.string.table_mosque),column);
        personRecyclerAdapter = new InfoRecyclerAdapterOne(infoModels,this);
        personRecycler.setAdapter(personRecyclerAdapter);
    }

}
