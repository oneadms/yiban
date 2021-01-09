package com.builder.yiban;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Random;


public class ShowActivity extends AppCompatActivity {

    private TextView head;
    private TextView div1;
    private TextView name;
    private TextView bianhao;
    private TextView reason;
    private TextView outtime;
    private TextView backtime;
    private TextView oktime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        initView();
        ImageDetails imageDetails = BuildImageManager.getImageDetails();
        if (imageDetails !=null) {
            head.setText(imageDetails.getName()+"的进出校门申请");
            div1.setText(imageDetails.getName()+"的进出校门申请");
            name.setText(imageDetails.getName()+"("+imageDetails.getStudnetID()+")");
            MyCalendar myCalendar = new MyCalendar();
            bianhao.setText(generateRandomNumber(myCalendar.getNowTimesByString()));
            reason.setText(imageDetails.getReason());
            outtime.setText(imageDetails.getDate());
            backtime.setText(imageDetails.getDate());
            oktime.setText(String.format("%2d",myCalendar.get(Calendar.HOUR)).replace(" ","0")+":"+String.format("%2d",myCalendar.get(Calendar.MINUTE)).replace(" ","0"));
        }


    }
    private static String generateRandomNumber(String time){
        Random r=new Random();
        StringBuilder temp=new StringBuilder(time.replace("-",""));

        for (int i = 0; i < 13; i++) {
            temp.append(r.nextInt(10));
        }
        return temp.toString();
    }
    private void initView() {
        head = (TextView) findViewById(R.id.head);
        div1 = (TextView) findViewById(R.id.div1);
        name = (TextView) findViewById(R.id.name);
        bianhao = (TextView) findViewById(R.id.binahao);
        reason = (TextView) findViewById(R.id.reason);
        outtime = (TextView) findViewById(R.id.outtime);
        backtime = (TextView) findViewById(R.id.blacktime);
        oktime = (TextView) findViewById(R.id.tgsj);
    }
}
