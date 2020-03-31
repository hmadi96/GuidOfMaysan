package com.mohammed.guidofmaysan;


import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import com.mohammed.guidofmaysan.RecyclerView.InfoModel;
import com.mohammed.guidofmaysan.RecyclerView.InfoRecyclerAdapterOne;
import com.mohammed.guidofmaysan.SQLitePackage.SQLiteHelper;
import java.util.List;


public class Hotel extends HomePage {

    public SQLiteHelper sqLiteHelper;
    public RecyclerView personRecycler;
    public InfoRecyclerAdapterOne personRecyclerAdapter;
    public List<InfoModel> infoModels;
    public RecyclerView.LayoutManager layoutManager;
    int column  ;
    SharedPreferences sharedPreferences;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        themeConfigration = new ThemeConfigration(this);
        checkTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle(R.string.hotel);
        setSupportActionBar(toolbar);
        window = this.getWindow();

        checkColor();
        column = Integer.valueOf(getResources().getString(R.string.number));
        layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.recycler_hotels);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);
        infoModels = sqLiteHelper.getAll(getResources().getString(R.string.table_hotels),column);
        personRecyclerAdapter = new InfoRecyclerAdapterOne(infoModels,this);
        personRecycler.setAdapter(personRecyclerAdapter);
    }

    private void checkColor() {
        int x = themeConfigration.my();
        if(x==5){
            sharedPreferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
            int task = sharedPreferences.getInt("color",1);
        if(task == 0){
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
             }
        else {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkNight));
        }}else {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit2:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;  }
    public void checkTheme() {
        int x = themeConfigration.my();
        if(x==5){
            int resId = themeConfigration.getThemeId();
            if (resId == 0) {
                setTheme(R.style.AppTheme);

            } else {
                setTheme(resId);
            }}
    }

}
