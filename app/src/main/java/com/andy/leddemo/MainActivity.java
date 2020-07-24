package com.andy.leddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.andy.hardlibrary.*;
public class MainActivity extends AppCompatActivity {

    private boolean ledon = false;
    private Button mBtn;
    private CheckBox led1;
    private CheckBox led2;
    private CheckBox led3;
    private CheckBox led4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn);


        HardControl.ledOpen();
        led1 = findViewById(R.id.led1);
        led2 = findViewById(R.id.led2);
        led3 = findViewById(R.id.led3);
        led4 = findViewById(R.id.led4);
    }

    public void clickall(View view) {
        ledon = !ledon;
        if(ledon){
            mBtn.setText("ALL OFF");
            led1.setChecked(true);
            led2.setChecked(true);
            led3.setChecked(true);
            led4.setChecked(true);
            for (int i = 0; i < 4; i++) {
                HardControl.ledCtrl(i,1);
            }
        }else{
            mBtn.setText("ALL ON");
            led1.setChecked(false);
            led2.setChecked(false);
            led3.setChecked(false);
            led4.setChecked(false);
            for (int i = 0; i < 4; i++) {
                HardControl.ledCtrl(i,0);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.led1:
                if (checked){
                    Toast.makeText(this, "led1 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0,1);
                }else{
                    Toast.makeText(this, "led1 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0,0);
                }
                break;

            case R.id.led2:
                if (checked){
                    Toast.makeText(this, "led2 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1,1);
                }else{
                    Toast.makeText(this, "led2 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1,0);
                }
                break;

            case R.id.led3:
                if (checked){
                    Toast.makeText(this, "led3 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2,1);
                }else{
                    Toast.makeText(this, "led3 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2,0);
                }
                break;

            case R.id.led4:
                if (checked){
                    Toast.makeText(this, "led4 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3,1);
                }else{
                    Toast.makeText(this, "led4 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3,0);
                }
                break;
        }
    }
}
