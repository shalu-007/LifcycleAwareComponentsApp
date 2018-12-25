package com.circletech.lifcyclecomponentsapp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private MyNameViewModel mViewModel;
    private TextView mTextView;
    private LifecycleRegistry mLifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);

        MyActiivtyLifecycleObserver vMyActiivtyLifecycleObserver=new MyActiivtyLifecycleObserver(getLifecycle(),new Logger());
        getLifecycle().addObserver(vMyActiivtyLifecycleObserver);

        mTextView = findViewById(R.id.myName);
        Button mButton = findViewById(R.id.changeName);
        final EditText mName = findViewById(R.id.setName);

        mViewModel = ViewModelProviders.of(this).get(MyNameViewModel.class);
        mViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String pS) {
                mTextView.setText(pS);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                String s = mName.getText().toString();
                if (!s.isEmpty()) {
                    mViewModel.getName().setValue(s);
                }
            }
        });
    }
    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return  mLifecycleRegistry;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }

}
