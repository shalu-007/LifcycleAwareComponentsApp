package com.circletech.lifcyclecomponentsapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyNameViewModel mViewModel;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MyNameViewModel.class);
        mTextView = findViewById(R.id.myName);
        mViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String pS) {
                mTextView.setText(pS);
            }
        });
        Button mButton=findViewById(R.id.changeName);
        final EditText mName=findViewById(R.id.setName);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
               String s=mName.getText().toString();
               if(!s.isEmpty()){
                   mViewModel.getName().setValue(s);
               }

            }
        });
    }
}
