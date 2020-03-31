package com.mohammed.guidofmaysan.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class LoadImageAsync extends AsyncTask<byte[], String, Bitmap> {

    private InfoViewHolder infoViewHolder;
    LoadImageAsync(InfoViewHolder infoViewHolder) {
        this.infoViewHolder = infoViewHolder;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(byte[]... bytes) {
        return BitmapFactory.decodeByteArray(bytes[0], 0, bytes[0].length);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        infoViewHolder.imageItem.setImageBitmap(bitmap);
        super.onPostExecute(bitmap);
    }
}