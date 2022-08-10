package com.example.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView,CurrentOP,CurrentValue;
    Button B1,B2,B3,B4,B5,B6,B7,B8,B9,Bq,B0,BC,B_P,B_M,B_MULT,B_Div,B_Equal;
    Double oldValue=0.0;
    char LastOperation;
    Boolean FirstOperation=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"1");
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"2");
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"3");
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"4");
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"5");
            }
        });
        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"6");
            }
        });
        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"7");
            }
        });
        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"8");
            }
        });
        B9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"9");
            }
        });
        B0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"0");
            }
        });
        Bq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+".");
            }
        });
        BC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                oldValue=0.0;
                CurrentOP.setText("");
                FirstOperation=true;
            }
        });
        B_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiddenOperation();
                LastOperation='/';
                CurrentOP.setText("/");
            }
        });
        B_MULT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiddenOperation();
                LastOperation='*';
                CurrentOP.setText("*");
            }
        });
        B_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiddenOperation();
                LastOperation='-';
                CurrentOP.setText("-");
            }
        });
        B_P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiddenOperation();
                LastOperation='+';
                CurrentOP.setText("+");
            }
        });
        B_Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiddenOperation();
                FirstOperation=true;
                CurrentOP.setText("");
                textView.setText(oldValue+"");
            }
        });


    }
    private void setViews() {
        B1 =(Button)findViewById(R.id.BTN1);
        B2 =(Button)findViewById(R.id.BTN2);
        B3 =(Button)findViewById(R.id.BTN3);
        B4 =(Button)findViewById(R.id.BTN4);
        B5 =(Button)findViewById(R.id.BTN5);
        B6 =(Button)findViewById(R.id.BTN6);
        B7 =(Button)findViewById(R.id.BTN7);
        B8 =(Button)findViewById(R.id.BTN8);
        B9 =(Button)findViewById(R.id.BTN9);
        B0 =(Button)findViewById(R.id.BTN0);
        Bq =(Button)findViewById(R.id.BTN_Q);
        BC =(Button)findViewById(R.id.BTN_Clear);
        B_P =(Button)findViewById(R.id.BTN_Plus);
        B_M =(Button)findViewById(R.id.BTN_Minus);
        B_MULT =(Button)findViewById(R.id.BTNMLT);
        B_Div =(Button)findViewById(R.id.BTN_DIV);
        B_Equal =(Button)findViewById(R.id.BTN_Eql);
        textView=(TextView)findViewById(R.id.TXT);
        CurrentOP=(TextView)findViewById(R.id.TXT_CurrentOperation);
        CurrentValue=(TextView) findViewById(R.id.CurrentValue);
    }
    private void hiddenOperation() {
        if(FirstOperation){
            oldValue=Double.parseDouble(textView.getText().toString());
            FirstOperation=false;
        }else{
        try {
            switch (LastOperation) {
                case '/':
                    oldValue = oldValue / Double.parseDouble(textView.getText().toString());
                    break;
                case '+':
                    oldValue = oldValue + Double.parseDouble(textView.getText().toString());
                    break;
                case '-':
                    oldValue = oldValue - Double.parseDouble(textView.getText().toString());
                    break;
                case '*':
                    oldValue = oldValue * Double.parseDouble(textView.getText().toString());
                    break;
            }
        }catch (Exception e){}
    }
        CurrentValue.setText(oldValue+"");
        textView.setText("");

    }
}