package com.example.krishna.testdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class ImageZoomActivity extends ActionBarActivity {

    private TouchImageView touchImageView;
    private int angle;
    private Bitmap bitmap;
    private ImageView ivCropped;
    private LinearLayout llCropped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_sample);
        llCropped = (LinearLayout) findViewById(R.id.ll_cropped);
        touchImageView = (TouchImageView) findViewById(R.id.iv_detail_item);
        ivCropped = (ImageView) findViewById(R.id.iv_cropped);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wall_bird);

        ivCropped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCropped.setDrawingCacheEnabled(true);
                Bitmap bitmap1=llCropped.getDrawingCache();
                ivCropped.setImageBitmap(bitmap1);
                Log.d("ImageZoomActivity", "onClick (Line:36) :"+"rotateed changed bitmap");
            }
        });
    }

    public void rotateView(View view){
        angle=(angle+=90)%360;
        touchImageView.setImageBitmap(rotateImage(bitmap, angle));
        Log.d("ImageZoomActivity", "rotateView (Line:41) :"+angle);
    }

    private Bitmap rotateImage(Bitmap source, float angle) {

        Matrix matrix = new Matrix();

        matrix.postRotate(angle);

        Bitmap rotatedBitmap = Bitmap.createBitmap(source , 0, 0, source .getWidth(), source .getHeight(), matrix, true);

        return rotatedBitmap;
    }
}
