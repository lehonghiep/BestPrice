package com.honghiep.bestprice.view.manhinhchao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.honghiep.bestprice.R;
import com.honghiep.bestprice.view.trangchu.TrangChuActivity;

public class FlashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen_activity);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (Exception e){

                }finally {

                    Intent intent=new Intent(FlashScreenActivity.this,TrangChuActivity.class);
                    startActivity(intent);
                    FlashScreenActivity.this.finish();
                }
            }
        });
        thread.start();
    }
}
