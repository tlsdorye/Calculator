package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView mTextDisplay;
    private CheckBox mBtnMode;
    private StringBuilder mMathExpr;
    private Button BtnDel;
    private Button BtnPer;
    private Button BtnPow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextDisplay = (TextView)findViewById(R.id.textDisplay);
        mBtnMode = (CheckBox)findViewById(R.id.btnMode);
        mMathExpr = new StringBuilder(256);
        BtnDel = (Button)findViewById(R.id.btnDel);
        BtnPer = (Button)findViewById(R.id.btnPer);
        BtnPow = (Button)findViewById(R.id.btnPow);

        BtnDel.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                mMathExpr.delete(0, mMathExpr.length());
                mTextDisplay.setText(mMathExpr);
                return true;
            }
        });

    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnMode:
                if(mBtnMode.isChecked()){
                    BtnPer.setVisibility(View.VISIBLE);
                    BtnPow.setVisibility(View.VISIBLE);
                }
                else {
                    BtnPer.setVisibility(View.INVISIBLE);
                    BtnPow.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btn0:
                mMathExpr.append("0"); break;
            case R.id.btn1:
                mMathExpr.append("1"); break;
            case R.id.btn2:
                mMathExpr.append("2"); break;
            case R.id.btn3:
                mMathExpr.append("3"); break;
            case R.id.btn4:
                mMathExpr.append("4"); break;
            case R.id.btn5:
                mMathExpr.append("5"); break;
            case R.id.btn6:
                mMathExpr.append("6"); break;
            case R.id.btn7:
                mMathExpr.append("7"); break;
            case R.id.btn8:
                mMathExpr.append("8"); break;
            case R.id.btn9:
                mMathExpr.append("9"); break;
            case R.id.btnDot:
                mMathExpr.append("."); break;
            case R.id.btnAdd:
                mMathExpr.append("+"); break;
            case R.id.btnSub:
                mMathExpr.append("-"); break;
            case R.id.btnMul:
                mMathExpr.append("*"); break;
            case R.id.btnDiv:
                mMathExpr.append("/"); break;
            case R.id.btnPer:
                mMathExpr.append("%"); break;
            case R.id.btnPow:
                mMathExpr.append("^"); break;
            case R.id.btnEql:
                if(mMathExpr.length() > 0)
                    mMathExpr.deleteCharAt(mMathExpr.length() - 1);
                break;
            case R.id.btnDel:
                if(mMathExpr.length() == 0)
                    return;
                String result = NumCalc.calc(mMathExpr.toString());
                if(result != null){
                    mMathExpr.delete(0, mMathExpr.length());
                    mMathExpr.append(result);
                }
                break;
        }
        mTextDisplay.setText(mMathExpr);
    }
}