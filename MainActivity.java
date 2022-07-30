package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero;
    Button btnmul,btndiv,btnsub,btnadd,btndot,btneq,btncl;
    EditText Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnone=(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);

        btntwo=(Button) findViewById(R.id.btn_2);
        btntwo.setOnClickListener(this);

        btnthree=(Button) findViewById(R.id.btn_3);
        btnthree.setOnClickListener(this);

        btnfour=(Button) findViewById(R.id.btn_4);
        btnfour.setOnClickListener(this);

        btnfive=(Button) findViewById(R.id.btn_5);
        btnfive.setOnClickListener(this);

        btnsix=(Button) findViewById(R.id.btn_6);
        btnsix.setOnClickListener(this);

        btnseven=(Button) findViewById(R.id.btn_7);
        btnseven.setOnClickListener(this);

        btneight=(Button) findViewById(R.id.btn_8);
        btneight.setOnClickListener(this);

        btnnine=(Button) findViewById(R.id.btn_9);
        btnnine.setOnClickListener(this);

        btnzero=(Button) findViewById(R.id.btn_0);
        btnzero.setOnClickListener(this);

        btndiv=(Button) findViewById(R.id.btn_div);
        btndiv.setOnClickListener(this);

        btnmul=(Button) findViewById(R.id.btn_mul);
        btnmul.setOnClickListener(this);

        btnsub=(Button) findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);

        btnadd=(Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);

        btndot=(Button) findViewById(R.id.btn_dot);
        btndot.setOnClickListener(this);

        btneq=(Button) findViewById(R.id.btn_eq);
        btneq.setOnClickListener(this);

        btncl=(Button) findViewById(R.id.btn_cl);
        btncl.setOnClickListener(this);

        Text=(EditText) findViewById(R.id.res);
        Text.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnone))
            Text.append("1");
        else if(v.equals(btntwo))
            Text.append("2");
        else if(v.equals(btnthree))
            Text.append("3");
        else if(v.equals(btnfour))
            Text.append("4");
        else if(v.equals(btnfive))
            Text.append("5");
        else if(v.equals(btnsix))
            Text.append("6");
        else if(v.equals(btnseven))
            Text.append("7");
        else if(v.equals(btneight))
            Text.append("8");
        else if(v.equals(btnnine))
            Text.append("9");
        else if(v.equals(btnzero))
            Text.append("0");
        else if(v.equals(btnadd))
            Text.append("+");
        else if(v.equals(btnsub))
            Text.append("-");
        else if(v.equals(btnmul))
            Text.append("*");
        else if(v.equals(btndiv))
            Text.append("/");
        else if(v.equals(btndot))
            Text.append(".");
        else if(v.equals(btncl))
            Text.setText("");
        else if(v.equals(btneq))
            try{
                String data=Text.getText().toString();
                if(data.contains("+"))
                    add(data);
                else if(data.contains("-"))
                    sub(data);
                else if(data.contains("*"))
                    mul(data);
                else if(data.contains("/"))
                    div(data);

            }catch(Exception e){
                display("invalid Input");
            }

    }

    private void add(String data) {
        String[] op=data.split(Pattern.quote("+"));
        if(op.length==2){
            double op1=Double.parseDouble(op[0]);
            double op2=Double.parseDouble(op[1]);
            double res1=op1+op2;
            Text.setText(String.valueOf(res1));
        }else
            display("invalid");
    }
    private void sub(String data) {
        String[] op=data.split("-");
        if(op.length==2){
            double op1=Double.parseDouble(op[0]);
            double op2=Double.parseDouble(op[1]);
            double res1=op1-op2;
            Text.setText(String.valueOf(res1));
        }else
            display("invalid");
    }
    private void mul(String data) {
        String[] op=data.split(Pattern.quote("*"));
        if(op.length==2){
            double op1=Double.parseDouble(op[0]);
            double op2=Double.parseDouble(op[1]);
            double res1=op1*op2;
            Text.setText(String.valueOf(res1));
        }else
            display("invalid");
    }
    private void div(String data) {
        String[] op=data.split(Pattern.quote("/"));
        if(op.length==2){
            double op1=Double.parseDouble(op[0]);
            double op2=Double.parseDouble(op[1]);
            double res1=op1/op2;
            Text.setText(String.valueOf(res1));
        }else
            display("invalid");
    }
    private void display(String msg) {
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}