package com.example.user.amir;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class

CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {
    Button gallery, camera;
    ImageView cameraimage;

    Bitmap bitmap;/*A bitmap is a type of memory organization or image file
format used to store digital images.
The term bitmap comes from the computer programming
terminology, meaning just a map of bits,
a spatially mapped array of bits. */

    public static final int CAMERA_REQUEST = 0;
    public static final int SELECT_IMAGE = 1;//premmision to access gallery

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        gallery = findViewById(R.id.gallery);
        gallery.setOnClickListener(this);


        camera = findViewById(R.id.camera);
        camera.setOnClickListener(this);

        cameraimage = findViewById(R.id.cameraimage);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            //if you dont have required permissions ask for it (only required for API 23+)
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

        }
    }

    @Override
    public void onClick(View v) {
        if (v == camera) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        } else {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
            //chooses an image from the gallery
        }

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            cameraimage.setImageBitmap(photo);
            String filePath = saveImage(bitmap);

            SharedPreferences prof = getSharedPreferences("myprof",MODE_PRIVATE);
            SharedPreferences.Editor editor= prof.edit();
            editor.putString("image",filePath);
            editor.commit();


        } else {//choose an image from the gallery and preview it on the imageview
            if (requestCode == SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
                Uri targetUri = data.getData();
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                    cameraimage.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public String saveImage(Bitmap bitmap) {//saves the image in the gallery
        File root = Environment.getExternalStorageDirectory();

        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());

        String filePath=root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);

        try
        {
            file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,ostream);
            ostream.close();
        }
        catch (Exception e)
        {
           e.printStackTrace();
            Toast.makeText(this,"Failed to save image",Toast.LENGTH_SHORT).show();//sends a message of the images fails to save
        }
        return filePath;
    }
    @Override // android recommended class to handle permissions
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d("","granted");
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.uujm
                    Toast.makeText(CameraGalleryActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();

                    //app cannot function without this permission for now so close it...
                    onDestroy();
                }
                return;
            }

            // other 'case' line to check for other
            // permissions this app might request
        }
    }
}



