package com.example.pitts.schoolproject2;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CActivity extends AppCompatActivity {

    private LinearLayout mLMLLayout;
    private LinearLayout mASLayout;
    private Button mStartA;
    private Button mStartB;
    private Button mFinishC;
    private Button mDialog;
    private MyDialogFragment mDialogView;
    private TextView mAStatus;
    private TextView mBStatus;
    private TextView mCStatus;
    private boolean run = false;
    private final Handler mHandler = new Handler();
    private int StringNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        mLMLLayout = (LinearLayout)findViewById(R.id.LML);
        mASLayout = (LinearLayout)findViewById(R.id.AS);
        mStartA = (Button)findViewById(R.id.startA);
        mStartB = (Button)findViewById(R.id.startB);
        mFinishC = (Button)findViewById(R.id.finishC);
        mDialog = (Button)findViewById(R.id.Dialog);
        mDialogView = new MyDialogFragment();
        mAStatus = (TextView)findViewById(R.id.AStatus);
        mBStatus = (TextView)findViewById(R.id.BStatus);
        mCStatus = (TextView)findViewById(R.id.CStatus);
        run = true;
        StringNumber = 0;

        intLML();
        LMLStrings.add("Activity C.onCreate()");
        LMLStrings.setCStatus("Activity C:Created");

        mStartA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CActivity.this,AActivity.class));
            }
        });

        mStartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CActivity.this,BActivity.class));
            }
        });

        mFinishC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialogView.show(getSupportFragmentManager());
            }
        });

        mHandler.postDelayed(task,0);
    }

    @Override
    public void onStart(){
        LMLStrings.add("Activity C.onStart()");
        setLifecycleMethodList("Activity C.onStart()");
        super.onStart();
        LMLStrings.setCStatus("Activity C:Started");
    }

    @Override
    public void onResume(){
        LMLStrings.add("Activity C.onResume()");
        setLifecycleMethodList("Activity C.onResume()");
        super.onResume();
        LMLStrings.setCStatus("Activity C:Resumed");
    }

    @Override
    public void onPause(){
        LMLStrings.add("Activity C.onPause()");
        setLifecycleMethodList("Activity C.onPause()");
        super.onPause();
        LMLStrings.setCStatus("Activity C:Paused");
    }

    @Override
    public void onStop(){
        LMLStrings.add("Activity C.onStop()");
        setLifecycleMethodList("Activity C.onStop()");
        super.onStop();
        LMLStrings.setCStatus("Activity C:Stopped");
    }

    public void setLifecycleMethodList(String LifecycleMethod){
        TextView temp = new TextView(this);
        temp.setText(LifecycleMethod);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        temp.setLayoutParams(lp);
        mLMLLayout.addView(temp);
        StringNumber++;
    }

    public void intLML(){
        mLMLLayout.removeAllViews();
        for (int i=0;i<LMLStrings.getStrings().size();i++){
            setLifecycleMethodList(LMLStrings.getStrings().get(i));
        }
        setLifecycleMethodList("Activity C.onCreate()");
    }

    private final Runnable task = new Runnable() {
        @Override public void run() {
            if(LMLStrings.getStrings().size()>StringNumber){
                int number = LMLStrings.getStrings().size() - StringNumber;
                int temp = StringNumber;
                for(int i=0;i<number;i++){
                    setLifecycleMethodList(LMLStrings.getStrings().get(temp+i));
                }
            }
            if(LMLStrings.getAStatus()!=null){
                mAStatus.setVisibility(View.VISIBLE);
                mAStatus.setText(LMLStrings.getAStatus());
            } else {
                mAStatus.setVisibility(View.GONE);
            }
            if(LMLStrings.getBStatus()!=null){
                mBStatus.setVisibility(View.VISIBLE);
                mBStatus.setText(LMLStrings.getBStatus());
            } else {
                mBStatus.setVisibility(View.GONE);
            }
            if(LMLStrings.getCStatus()!=null){
                mCStatus.setVisibility(View.VISIBLE);
                mCStatus.setText(LMLStrings.getCStatus());
            } else {
                mCStatus.setVisibility(View.GONE);
            }
            if (run) {
                mHandler.postDelayed(this,1);
            }
        }
    };
}
