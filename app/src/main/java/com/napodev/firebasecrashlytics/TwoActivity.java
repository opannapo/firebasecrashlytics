package com.napodev.firebasecrashlytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

public class TwoActivity extends AppCompatActivity {
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        t2 = findViewById(R.id.t2);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crashlytics.log(1, "TextViewClick", "[" + String.valueOf(t2.getText().toString()) + "]" + " Clicked");
                Crashlytics.getInstance().crash();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //init specific key
        Crashlytics.setString("last_activity", this.getClass().getSimpleName());
        Crashlytics.setBool("is_login", true);
    }
}
