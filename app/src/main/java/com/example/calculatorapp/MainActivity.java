package com.example.calculatorapp;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //private Button open_paranthesis = (Button) findViewById(R.id.button_openParantheses);
    private TextView display;
    private String textBox_data;
    private final CalculatorLogic logic = new CalculatorLogic();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        display  = (TextView) findViewById(R.id.Display);
        Button open_parantheses = findViewById(R.id.button_openParantheses);
        open_parantheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("(");
                else
                    display.append("(");
            }
        });
        Button close_parantheses = findViewById(R.id.button_closeParantheses);
        close_parantheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText(")");
                else
                    display.append(")");
            }
        });
        Button add = findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("0");
                else
                    display.append("+");
            }
        });
        Button five = findViewById(R.id.button_five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("5");
                else
                    display.append("5");
            }
        });
        Button six = findViewById(R.id.button_six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("6");
                else
                    display.append("6");
            }
        });
        Button seven = findViewById(R.id.button_seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("7");
                else
                    display.append("7");
            }
        });
        Button one = findViewById(R.id.button_one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("1");
                else
                    display.append("1");
            }
        });
        Button two = findViewById(R.id.button_two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("2");
                else
                    display.append("2");
            }
        });
        Button three = findViewById(R.id.button_three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("3");
                else
                    display.append("3");
            }
        });
        Button four = findViewById(R.id.button_four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("4");
                else
                    display.append("4");
            }
        });
        Button eight = findViewById(R.id.button_eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("8");
                else
                    display.append("8");
            }
        });
        Button nine = findViewById(R.id.button_nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("9");
                else
                    display.append("9");
            }
        });
        Button zero = findViewById(R.id.button_zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("0");
                else
                    display.append("0");
            }
        });
        Button punkt = findViewById(R.id.button_punkt);
        punkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText(".");
                else
                    display.append(".");
            }
        });
        Button equal = findViewById(R.id.button_equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(logic.eval(display.getText().toString()));
            }
        });
        Button mul = findViewById(R.id.button_mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("0");
                else
                    display.append("*");
            }
        });
        Button div = findViewById(R.id.button_div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("0");
                else
                    display.append("/");
            }
        });
        Button sub = findViewById(R.id.button_sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText("-");
                else
                    display.append("-");
            }
        });
        Button CE = findViewById(R.id.button_CE);
        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
            }
        });
    }
//    public void open_parantheses(){
//
//        display.setText("(");
//    }

}