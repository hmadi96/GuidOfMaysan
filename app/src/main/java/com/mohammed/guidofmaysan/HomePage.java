package com.mohammed.guidofmaysan;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

public class HomePage extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private SharedPreferences.Editor editores ;
    private   SharedPreferences preferences ;
    ThemeConfigration themeConfigration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkTheme();
        setContentView(R.layout.activity_main);
        editores = getSharedPreferences("settings",MODE_PRIVATE).edit();
        preferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
      //  loadLocale();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about, R.id.nav_about_code,
                R.id.nav_setting, R.id.nav_send, R.id.nav_about_designer)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void checkTheme() {
        themeConfigration = new ThemeConfigration(this);
        int resId = themeConfigration.getThemeId();
        int x = themeConfigration.my();
        if(x==5){
        if (resId == 0) {
            setTheme(R.style.AppTheme);

        } else {
            setTheme(resId);
        }}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit:
                finish();
                break;
         //   case R.id.language:
           //    showLanguage(); break;
            case R.id.theme:
               myTheme();
               break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;  }

   public void myTheme() {
        final String[] list = {getString(R.string.default_theme),getString(R.string.dark_mode)};
        AlertDialog.Builder mBuilderes = new AlertDialog.Builder(HomePage.this);
        mBuilderes.setTitle(getString(R.string.theme));
        mBuilderes.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 0){

                    themeConfigration.saveTheme(R.style.AppTheme);
                    recreate();
                }
                else {
                    themeConfigration.saveTheme(R.style.DarkTheme);
                    recreate();
                }
                editores.putInt("color",i);
                editores.apply();
            }
        });
        AlertDialog mDialog=mBuilderes.create();
        mDialog.show();
    }

// Language
   /* public void showLanguage() {
        final String[] list = {"English","عربي"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(HomePage.this);
        mBuilder.setTitle(R.string.language);
        mBuilder.setIcon(R.drawable.ic_language_black_24dp);
        mBuilder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               if(i == 0){
                   setLocale("en");
                   recreate();
               }
               else {
                   setLocale("ar");
                   recreate();
               }
            }
        });
        AlertDialog mDialog=mBuilder.create();
        mDialog.show();
    }

    public void setLocale(String language) {
        Locale localee = new Locale(language);
        Locale.setDefault(localee);
        Configuration configuration = new Configuration();
        configuration.locale = localee;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        editores.putString("My_language",language);
        editores.apply();
    }
    public void  loadLocale (){

        String lang = preferences.getString("My_language","");
        setLocale(lang);
    }

    */

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
