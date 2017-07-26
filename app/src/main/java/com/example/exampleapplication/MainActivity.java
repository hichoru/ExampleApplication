package com.example.exampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text_view);

        // 匿名クラス
        final Button button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (flag) {
                    textView.setText("Hello");
                    flag = false;
                }
                else {
                    textView.setText("World");
                    flag = true;
                }
            }
        });
        // 変数でまとめる
        final Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(buttonClick);

        // OnClickListener を implementsして onClick を定義
        final Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        // カスタムクラス
        final Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new buttonClick());

    }


    // 変数でまとめる
    private View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_1:
                    if (flag) {
                        textView.setText("flase");
                        flag = false;
                    }
                    else {
                        textView.setText("true");
                        flag = true;
                    }
                    break;
            }
        }
    };

    // OnClickListener を implementsして onClick を定義
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button_2:
                if (flag) {
                    textView.setText("off");
                    flag = false;
                }
                else {
                    textView.setText("on");
                    flag = true;
                }
                break;
        }
    }

    // カスタムクラス
    class buttonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_3:
                    if (flag) {
                        textView.setText("AAA");
                        flag = false;
                    } else {
                        textView.setText("あああ");
                        flag = true;
                    }
                    break;
            }
        }
    }

    // android:onClick
    public void selfDestruct(View view) {
        switch (view.getId()) {
            case R.id.button_4:
                if (flag) {
                    textView.setText("テスト");
                    flag = false;
                } else {
                    textView.setText("TEST");
                    flag = true;
                }
                break;
        }
    }
}