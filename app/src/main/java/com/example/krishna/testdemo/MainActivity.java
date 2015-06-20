package com.example.krishna.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        Log.i("inside on create ", "inside on create ");
       // capturePhotoForRecordUpload();
    }

    public void capturePhotoForRecordUpload() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File storageDir = new File(Environment.getExternalStorageDirectory().getPath() + "/MyApp");
            if (!storageDir.exists())
                storageDir.mkdirs();
            if (!storageDir.exists())
                storageDir.mkdir();

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath() + "/MyApp" + "/sample.jpg")));
            startActivityForResult(takePictureIntent, 7);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Log.d("MainActivity", "onActivityResult (Line:44) :");

        }
    }
}