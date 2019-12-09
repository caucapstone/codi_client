package com.example.codi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClosetAddActivity extends AppCompatActivity {

    private String userNickmae;
    private Button top;
    private Button pants;
    private ImageButton clothes;
    private Button save;
    private String kinds;
    private File SelectFile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_closet);

        top = (Button)findViewById(R.id.top_btn);
        pants = (Button)findViewById(R.id.pants_btn);
        clothes = (ImageButton)findViewById(R.id.clothes_btn);
        save = (Button)findViewById(R.id.save_btn);

        save.setEnabled(false);
        clothes.setEnabled(false);

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kinds = "top";
                clothes.setImageResource(android.R.color.transparent);
                clothes.setImageResource(R.drawable.add_top);
                clothes.setEnabled(true);
            }
        });

        pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kinds = "pants";
                clothes.setImageResource(android.R.color.transparent);
                clothes.setImageResource(R.drawable.add_pants);
                clothes.setEnabled(true);
            }
        });

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), SelectFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requstCode, int resultCode, Intent data) {
        if (requstCode != 1 || resultCode != RESULT_OK) {
            return;
        }

        Uri dataUri = data.getData();
        clothes.setImageURI(dataUri);

        try {
            InputStream in = getContentResolver().openInputStream(dataUri);
            Bitmap image = BitmapFactory.decodeStream(in);
            clothes.setImageBitmap(image);
            in.close();

            String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
            SelectFile = new File(getCacheDir(), "temp_" + date + ".jpg");
            OutputStream out = new FileOutputStream(SelectFile);
            image.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        save.setEnabled(true);
    }

    public void setUserNickmae(String userNickmae) {
        this.userNickmae = userNickmae;
    }

    public String getUserNickmae() {
        return userNickmae;
    }
}
