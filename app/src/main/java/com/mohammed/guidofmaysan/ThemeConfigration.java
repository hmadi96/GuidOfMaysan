package com.mohammed.guidofmaysan;

import android.content.Context;
import android.content.SharedPreferences;


import androidx.appcompat.app.AppCompatActivity;

public class ThemeConfigration extends AppCompatActivity {
    private SharedPreferences pref;
    private String RES_ID = "resId";

    public ThemeConfigration(Context context) {

        pref = context.getSharedPreferences("myTheme", Context.MODE_PRIVATE);

    }

    public void saveTheme(int resId) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("my",5).apply();
        editor.putInt(RES_ID, resId).apply();
    }

    public int getThemeId() {
        return pref.getInt(RES_ID, 0);
}
     public int my(){return pref.getInt("my",0);}
  }
