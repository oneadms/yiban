package com.builder.yiban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "status";
    private Button build_btn;
    private Button today_btn;
    private EditText name_edit;
    private EditText studentID_edit;
    private EditText reason_edit;
    private EditText date_edit;
    static final int permission = 1;
    private boolean isAllGranted;

    public void readData(){
        try {


            FileInputStream fileInputStream = null;
            try {
                 fileInputStream = openFileInput("data.ser");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (null == fileInputStream) {
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            final ImageDetails imageDetails = (ImageDetails)ois.readObject();
            List<EditText> editTexts = Arrays.asList(name_edit, studentID_edit, reason_edit, date_edit);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                editTexts.forEach(x -> x.setText(imageDetails.next()));
            }else{
                for (EditText editText : editTexts) {
                    editText.setText(imageDetails.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public long firstTime = 0;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 1200) {//如果两次按键时间间隔大于1200毫秒，则不退出
                Toast.makeText(MainActivity.this, "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                firstTime = secondTime;//更新firstTime
                return true;
            } else {
                System.exit(0);//否则退出程序
            }
        }
        return super.onKeyUp(keyCode, event);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        readData();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, permission);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case permission:
                isAllGranted = true;
                for (int grantResult : grantResults) {
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        isAllGranted = false;
                    }
                }
            break;
        }
    }

    private void initView() {
        name_edit = (EditText) findViewById(R.id.name);
        studentID_edit = (EditText) findViewById(R.id.studentID);
        reason_edit = (EditText) findViewById(R.id.reason);
        date_edit = (EditText) findViewById(R.id.date);

        build_btn = (Button) findViewById(R.id.build_btn);
        today_btn = (Button) findViewById(R.id.today_btn);
        today_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                StringBuffer now = new StringBuffer();

                MyCalendar calendar = new MyCalendar();

                date_edit.setText(calendar.getNowTimesByString());
            }
        });
        build_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageDetails imageDetails = new ImageDetails(name_edit.getText().toString(),
                        studentID_edit.getText().toString(),
                        reason_edit.getText().toString(), date_edit.getText().toString());

                saveData(imageDetails);
                BuildImageManager.build(MainActivity.this, imageDetails);
                Intent it = new Intent(MainActivity.this, ShowActivity.class);

                startActivity(it);

            }
        });

    }
    private void saveData(ImageDetails imageDetails) {
        try {
            FileOutputStream fos = openFileOutput("data.ser", MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(imageDetails);
            os.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
