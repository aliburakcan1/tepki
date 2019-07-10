package com.tepki.tepki3;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by x on 12.09.2017.
 */

public class DownloadFile extends AsyncTask<String, String, String> {

    Context context;
    String name;
    File file;
    public DownloadFile(Context context,String name){
        this.context=context;
        this.name=name;
    }

    final int DIALOG_DOWNLOAD_PROGRESS = 0;
    ProgressDialog mProgressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        onCreateDialog(DIALOG_DOWNLOAD_PROGRESS);

        }

    @Override
    protected String doInBackground(String... aurl) {
        int count;

        try {

            URL url = new URL(aurl[0]);
            URLConnection conexion = url.openConnection();
            conexion.connect();

            int lenghtOfFile = conexion.getContentLength();

            InputStream input = new BufferedInputStream(url.openStream());
            String externalDirectory= Environment.getExternalStorageDirectory().toString();
            File folder= new File(externalDirectory + "/Tepki");
            folder.mkdir();
            file = new File(folder,name+".mp4");
            MediaScannerConnection.scanFile(context, new String[] { file.getPath() }, new String[] { "video/*" }, null);
            OutputStream output = new FileOutputStream(file); //save file in SD Card

            byte data[] = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {}
        return null;

    }
    protected void onProgressUpdate(String... progress) {
        Log.d("ANDRO_ASYNC",progress[0]);
        mProgressDialog.setProgress(Integer.parseInt(progress[0]));
    }

    @Override
    protected void onPostExecute(String unused) {
        mProgressDialog.dismiss();
        Toast.makeText(context,"Tepki klasörünün altına indirildi.",Toast.LENGTH_SHORT).show();
    }
    public void share(){

        File file = new File(context.getCacheDir(),"sample.mp4");
        Uri uri = FileProvider.getUriForFile(context, "com.tepki.tepki3.tepki3.fileprovider", file);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("video/*");
        context.startActivity(Intent.createChooser(shareIntent, "Paylaşacağın ortamı seç"));
    }
    public Dialog onCreateDialog(int id) {

        switch (id) {
            case DIALOG_DOWNLOAD_PROGRESS:
                mProgressDialog = new ProgressDialog(context);
                mProgressDialog.setMessage("Tepkin indiriliyor...");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
                return mProgressDialog;
            default:
                return null;
        }
    }
}
