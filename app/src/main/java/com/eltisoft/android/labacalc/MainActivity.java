package com.eltisoft.android.labacalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.mariuszgromada.math.mxparser.Expression;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mainEditText;
    EditText resultEditText;

    RadioButton hexRadioButton;
    RadioButton dexRadioButton;
    RadioButton octRadioButton;
    RadioButton binRadioButton;

    RadioGroup notationRadioGroup;

    BigInteger bi;
    int notation = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button[] buttonArray = {
                (Button) findViewById(R.id.oneButton),
                (Button) findViewById(R.id.twoButton),
                (Button) findViewById(R.id.threeButton),
                (Button) findViewById(R.id.foorButton),
                (Button) findViewById(R.id.fiveButton),
                (Button) findViewById(R.id.sixButton),
                (Button) findViewById(R.id.sevenButton),
                (Button) findViewById(R.id.eightButton),
                (Button) findViewById(R.id.nineButton),
                (Button) findViewById(R.id.zeroButton),
                (Button) findViewById(R.id.aButton),
                (Button) findViewById(R.id.bButton),
                (Button) findViewById(R.id.cButton),
                (Button) findViewById(R.id.dButton),
                (Button) findViewById(R.id.eButton),
                (Button) findViewById(R.id.fButton),
                (Button) findViewById(R.id.bracketOpenButton),
                (Button) findViewById(R.id.bracketCloseButton),
                (Button) findViewById(R.id.plusButton),
                (Button) findViewById(R.id.minusButton),
                (Button) findViewById(R.id.multiplyButton),
                (Button) findViewById(R.id.divisionButton),
                (Button) findViewById(R.id.equalsButton),

                
                (Button) findViewById(R.id.pointButton),
                (Button) findViewById(R.id.orButton),
                (Button) findViewById(R.id.xorButton),
                (Button) findViewById(R.id.notButton),
                (Button) findViewById(R.id.andButton),
                (Button) findViewById(R.id.delButton)};
        for (Button button : buttonArray) {
            button.setOnClickListener(this);
        }

        mainEditText = (EditText)findViewById(R.id.mainEditText);
        resultEditText = (EditText)findViewById(R.id.resultEditText);

        notationRadioGroup = (RadioGroup) findViewById(R.id.notationRadioGroup);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.oneButton:
                setSymbols("1");
                break;
            case R.id.twoButton:
                setSymbols("2");
                break;
            case R.id.threeButton:
                setSymbols("3");
                break;
            case R.id.foorButton:
                setSymbols("4");
                break;
            case R.id.fiveButton:
                setSymbols("5");
                break;
            case R.id.sixButton:
                setSymbols("6");
                break;
            case R.id.sevenButton:
                setSymbols("7");
                break;
            case R.id.eightButton:
                setSymbols("8");
                break;
            case R.id.nineButton:
                setSymbols("9");
                break;
            case R.id.aButton:
                setSymbols("A");
                break;
            case R.id.bButton:
                setSymbols("B");
                break;
            case R.id.cButton:
                setSymbols("C");
                break;
            case R.id.dButton:
                setSymbols("D");
                break;
            case R.id.eButton:
                setSymbols("E");
                break;
            case R.id.fButton:
                setSymbols("F");
                break;
            case R.id.plusButton:
                mainEditText.setText(mainEditText.getText()+ "+");
                Expression ep = new Expression(mainEditText.getText().toString());
                break;
            case R.id.equalsButton:
                Expression ee = new Expression(mainEditText.getText().toString());
                resultEditText.setText("" + ee.calculate());
                break;
            case R.id.delButton:
                mainEditText.setText(null);
                resultEditText.setText(null);
                break;
            case R.id.minusButton:
                mainEditText.setText(mainEditText.getText()+ "-");
                Expression em = new Expression(mainEditText.getText().toString());
                break;
            case R.id.divisionButton:
                mainEditText.setText(mainEditText.getText()+ "/");
                Expression ed = new Expression(mainEditText.getText().toString());
                break;
             case R.id.multiplyButton:
                mainEditText.setText(mainEditText.getText()+ "*");
                Expression emp = new Expression(mainEditText.getText().toString());
                break;
            case R.id.bracketOpenButton:
                mainEditText.setText(mainEditText.getText()+ "(");
                Expression ebo = new Expression(mainEditText.getText().toString());
                break;
            case R.id.bracketCloseButton:
                mainEditText.setText(mainEditText.getText()+ ")");
                Expression ebc = new Expression(mainEditText.getText().toString());
                break;
            case R.id.pointButton:
                mainEditText.setText(mainEditText.getText()+ ".");
                Expression epo = new Expression(mainEditText.getText().toString());
                break;
            case R.id.binRadioButton:
                //mainEditText.setText(convert(mainEditText.getText().toString(),10,2));
               // mainEditText.setText(Integer.parseInt(mainEditText.getText().toString(),2));
                try {
                    bi = new BigInteger(mainEditText.getText().toString(), notation);
                    Long DecNum = bi.longValue();
                    String text = Long.toBinaryString(DecNum);
                    mainEditText.setText(text);
                }
                catch (Exception e){

                }
                notation = 2;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setSymbols (String str){
        mainEditText.setText(mainEditText.getText() + str);
        mainEditText.setSelection(mainEditText.getText().length());
    }

    public static String convert(String number, int baseFrom, int baseTo){
        Log.d("CONVERT-LONG10", Long.parseLong(number, baseFrom) + "");
        String result = Long.toString(Long.parseLong(number, baseFrom), baseTo);
        Log.d("CONVERT-RESULT", result + "");
        return result;
    }


}
