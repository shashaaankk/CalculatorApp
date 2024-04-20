package com.example.calculatorapp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //private Button open_paranthesis = (Button) findViewById(R.id.button_openParantheses);
    private Context context;
    private Boolean MemFlag = Boolean.FALSE;
    private Boolean resultFlag = Boolean.FALSE;
    private TextView display;
    private historyHandler HistoryHandler = new historyHandler();
    private Queue<String> history = new LinkedList<>();
    private final CalculatorLogic logic = new CalculatorLogic();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        display  = (TextView) findViewById(R.id.Display);
        Button open_parantheses = findViewById(R.id.button_openParantheses);
        Button close_parantheses = findViewById(R.id.button_closeParantheses);
        Button add = findViewById(R.id.button_add);
        Button mul = findViewById(R.id.button_mul);
        Button sub = findViewById(R.id.button_sub);
        Button div = findViewById(R.id.button_div);
        Button CE = findViewById(R.id.button_CE);
        Button Mem = findViewById(R.id.button_mem);
        Button equal = findViewById(R.id.button_equal);
        Button one = findViewById(R.id.button_one);
        Button two = findViewById(R.id.button_two);
        Button three = findViewById(R.id.button_three);
        Button four = findViewById(R.id.button_four);
        Button five = findViewById(R.id.button_five);
        Button six = findViewById(R.id.button_six);
        Button seven = findViewById(R.id.button_seven);
        Button eight = findViewById(R.id.button_eight);
        Button nine = findViewById(R.id.button_nine);
        Button zero = findViewById(R.id.button_zero);
        Button punkt = findViewById(R.id.button_punkt);
        open_parantheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("(");
                    resultFlag = false;
                }
                else
                    display.append("(");
            }
        });
        close_parantheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0"))
                    display.setText(")");
                else if(resultFlag==Boolean.TRUE){
                    display.setText("0");
                    resultFlag = false;
                }
                else
                    display.append(")");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("0");
                    resultFlag = false;
                }
                else
                    display.append("+");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("5");
                    resultFlag = false;
                }
                else
                    display.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().toString().equals("0") || resultFlag == Boolean.TRUE){
                    display.setText("6");
                    resultFlag = false;
                }
                else
                    display.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("7");
                    resultFlag = false;
                }
                else
                    display.append("7");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("1");
                    resultFlag = false;
                }
                else
                    display.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("2");
                    resultFlag = false;
                }
                else
                    display.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("3");
                    resultFlag = false;
                }
                else
                    display.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().toString().equals("0") || resultFlag == Boolean.TRUE){
                    display.setText("4");
                    resultFlag = false;
                }
                else
                    display.append("4");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE){
                    display.setText("8");
                    resultFlag = false;
                }
                else
                    display.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("9");
                    resultFlag = false;
                }
                else
                    display.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("0");
                    resultFlag = false;
                }
                else
                    display.append("0");
            }
        });
        punkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0") || resultFlag==Boolean.TRUE) {
                    display.setText(".");
                    resultFlag = Boolean.FALSE;
                }
                else
                    display.append(".");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = logic.eval(display.getText().toString(),context);
                history.add(display.getText()+"="+result);
                if (history.size()>5)
                    history.remove();
                HistoryHandler.append(display.getText()+"="+result + "\n");
                display.setText(result);
                resultFlag = Boolean.TRUE;
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("0");
                    resultFlag = false;
                }
                else
                    display.append("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("0");
                    resultFlag = false;
                }
                else
                    display.append("/");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().toString().equals("0")|| resultFlag==Boolean.TRUE) {
                    display.setText("-");
                    resultFlag = false;
                }
                else
                    display.append("-");
            }
        });
        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
            }
        });
        Button Exp = findViewById(R.id.button_exp);
        Exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    HistoryHandler.write(context);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Mem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tstyt", "onClick: "+display.getTextSize());;
                if(!MemFlag) {
                    MemFlag = Boolean.TRUE;
                    CE.setEnabled(false);
                    sub.setEnabled(false);
                    add.setEnabled(false);
                    div.setEnabled(false);
                    mul.setEnabled(false);
                    equal.setEnabled(false);
                    punkt.setEnabled(false);
                    zero.setEnabled(false);
                    one.setEnabled(false);
                    two.setEnabled(false);
                    three.setEnabled(false);
                    four.setEnabled(false);
                    five.setEnabled(false);
                    six.setEnabled(false);
                    seven.setEnabled(false);
                    eight.setEnabled(false);
                    nine.setEnabled(false);
                    close_parantheses.setEnabled(false);
                    open_parantheses.setEnabled(false);
                    StringBuilder hist = new StringBuilder();
                    history.forEach(elem -> hist.append(elem).append("\n"));
                    display.setTextSize(30);
                    display.setText(hist.toString());
                }
                else{
                    CE.setEnabled(true);
                    sub.setEnabled(true);
                    add.setEnabled(true);
                    div.setEnabled(true);
                    mul.setEnabled(true);
                    equal.setEnabled(true);
                    punkt.setEnabled(true);
                    zero.setEnabled(true);
                    one.setEnabled(true);
                    two.setEnabled(true);
                    three.setEnabled(true);
                    four.setEnabled(true);
                    five.setEnabled(true);
                    six.setEnabled(true);
                    seven.setEnabled(true);
                    eight.setEnabled(true);
                    nine.setEnabled(true);
                    close_parantheses.setEnabled(true);
                    open_parantheses.setEnabled(true);
                    display.setTextSize(60);
                    display.setText("0");
                }
            }
        });
    }
//    public void open_parantheses(){
//
//        display.setText("(");
//    }

}