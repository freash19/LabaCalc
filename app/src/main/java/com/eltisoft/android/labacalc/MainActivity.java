package com.eltisoft.android.labacalc;

import android.graphics.Color;
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
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    EditText mainEditText;
    EditText resultEditText;

    RadioButton hexRadioButton;
    RadioButton decRadioButton;
    RadioButton octRadioButton;
    RadioButton binRadioButton;

    RadioGroup notationRadioGroup;

    BigInteger bi;
    int notation = 10;
    Long DecNum;
    String text;
    String text1;
    BigInteger resultInDec;
    String result;

    int[] buttonNumber2to7Array = {
            R.id.twoButton,
            R.id.threeButton,
            R.id.foorButton,
            R.id.fiveButton,
            R.id.sixButton,
            R.id.sevenButton,
    };
    int[] buttonNumber8to9Array = {
            R.id.eightButton,
            R.id.nineButton,
    };

    int[] buttonLettersArray = {
                R.id.aButton,
                R.id.bButton,
                R.id.cButton,
                R.id.dButton,
                R.id.eButton,
                R.id.fButton,
                R.id.pointButton,
    };

    Button[] buttonArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         buttonArray = new Button[] {
                (Button) findViewById(R.id.zeroButton),
                (Button) findViewById(R.id.oneButton),
                (Button) findViewById(R.id.twoButton),
                (Button) findViewById(R.id.threeButton),
                (Button) findViewById(R.id.foorButton),
                (Button) findViewById(R.id.fiveButton),
                (Button) findViewById(R.id.sixButton),
                (Button) findViewById(R.id.sevenButton),
                (Button) findViewById(R.id.eightButton),
                (Button) findViewById(R.id.nineButton),
                (Button) findViewById(R.id.aButton),
                (Button) findViewById(R.id.bButton),
                (Button) findViewById(R.id.cButton),
                (Button) findViewById(R.id.dButton),
                (Button) findViewById(R.id.eButton),
                (Button) findViewById(R.id.fButton),
                (Button) findViewById(R.id.pointButton),
                (Button) findViewById(R.id.bracketOpenButton),
                (Button) findViewById(R.id.bracketCloseButton),
                (Button) findViewById(R.id.plusButton),
                (Button) findViewById(R.id.minusButton),
                (Button) findViewById(R.id.multiplyButton),
                (Button) findViewById(R.id.divisionButton),
                (Button) findViewById(R.id.equalsButton),
                (Button) findViewById(R.id.hexButton),
                (Button) findViewById(R.id.decButton),
                (Button) findViewById(R.id.octButton),
                (Button) findViewById(R.id.binButton),
                (Button) findViewById(R.id.delButton)};
        for (Button button : buttonArray) {
            button.setOnClickListener(this);
        }

        buttonArray[28].setOnLongClickListener(this);

        setDec();

        mainEditText = (EditText) findViewById(R.id.mainEditText);
        resultEditText = (EditText) findViewById(R.id.resultEditText);

/*        decRadioButton = (RadioButton) findViewById(R.id.decRadioButton);
        decRadioButton.setOnClickListener(this);*/

 /*       notationRadioGroup = (RadioGroup) findViewById(R.id.notationRadioGroup);
        notationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                text = mainEditText.getText().toString();
                switch (checkedId) {

                    case R.id.binRadioButton:
                        setBin();

                        try {
                           resultInDec = gerResultInDec(text, notation);
                           writeText(resultInDec.toString(2));

                        } catch (Exception e) {

                        }
                        notation = 2;
                        break;
                    case R.id.octRadioButton:
                        setOct();
                        try {
                            resultInDec = gerResultInDec(text, notation);
                            writeText(resultInDec.toString(8));

                        } catch (Exception e) {

                        }
                        notation = 8;
                        break;
                    case R.id.decRadioButton:
                        setDec();
                        try {
                            resultInDec = gerResultInDec(text, notation);
                            writeText(result = resultInDec.toString(10));
                        } catch (Exception e) {

                        }
                        notation = 10;
                        break;
                    case R.id.hexRadioButton:
                        setHex();
                        try {
                            resultInDec = gerResultInDec(text, notation);
                            writeText(resultInDec.toString(16));
                        } catch (Exception e) {

                        }
                        notation = 16;
                        break;
                }


            }

        });*/
    }

    @Override
    public void onClick(View view) {
        text = mainEditText.getText().toString();
        switch (view.getId()) {
            case R.id.oneButton:
                setSymbol("1");
                break;
            case R.id.twoButton:
                setSymbol("2");
                break;
            case R.id.threeButton:
                setSymbol("3");
                break;
            case R.id.foorButton:
                setSymbol("4");
                break;
            case R.id.fiveButton:
                setSymbol("5");
                break;
            case R.id.sixButton:
                setSymbol("6");
                break;
            case R.id.sevenButton:
                setSymbol("7");
                break;
            case R.id.eightButton:
                setSymbol("8");
                break;
            case R.id.nineButton:
                setSymbol("9");
                break;
            case R.id.zeroButton:
                setSymbol("0");
                break;
            case R.id.aButton:
                setSymbol("A");
                break;
            case R.id.bButton:
                setSymbol("B");
                break;
            case R.id.cButton:
                setSymbol("C");
                break;
            case R.id.dButton:
                setSymbol("D");
                break;
            case R.id.eButton:
                setSymbol("E");
                break;
            case R.id.fButton:
                setSymbol("F");
                break;
            case R.id.plusButton:
                setSymbolWithTest("+");
                break;
            case R.id.delButton:
                int length = mainEditText.getText().length();
                if (length > 0) {
                    mainEditText.getText().delete(length - 1, length);
                }
                break;
            case R.id.minusButton:
                setSymbolWithTest("-");
                break;
            case R.id.divisionButton:
                setSymbolWithTest("/");
                break;
            case R.id.multiplyButton:
                setSymbolWithTest("*");
                break;
            case R.id.bracketOpenButton:
                setSymbol("(");
                break;
            case R.id.bracketCloseButton:
                setSymbol(")");
                break;
            case R.id.pointButton:
                mainEditText.setText(mainEditText.getText() + ".");
                break;
            case R.id.equalsButton:
                text = mainEditText.getText().toString();
                resultInDec = gerResultInDec(text, notation);
                writeText(resultInDec.toString(notation));
                /*isCalc();*/
                break;
            case R.id.binButton:
                setBin();

                try {
                    resultInDec = gerResultInDec(text, notation);
                    writeText(resultInDec.toString(2));

                } catch (Exception e) {

                }
                notation = 2;
                break;
            case R.id.octButton:
                setOct();
                try {
                    resultInDec = gerResultInDec(text, notation);
                    writeText(resultInDec.toString(8));

                } catch (Exception e) {

                }
                notation = 8;
                break;
            case R.id.decButton:
                setDec();
                try {
                    resultInDec = gerResultInDec(text, notation);
                    writeText(result = resultInDec.toString(10));
                } catch (Exception e) {

                }
                notation = 10;
                break;
            case R.id.hexButton:
                setHex();
                try {
                    resultInDec = gerResultInDec(text, notation);
                    writeText(resultInDec.toString(16));
                } catch (Exception e) {

                }
                notation = 16;
                break;
        }

    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.delButton:
                mainEditText.setText(null);
                resultEditText.setText(null);
                break;
        }
        return true;
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

    public void writeText (String str){
        mainEditText.setText(str);
        mainEditText.setSelection(mainEditText.getText().length());
    }

    public void setSymbol(String str) {
        mainEditText.setText(mainEditText.getText() + str);
        mainEditText.setSelection(mainEditText.getText().length());
    }

    public void setSymbolWithTest(String str) {
        if (isEditTextEmpty()){
            return;
        }
        String text = mainEditText.getText().toString();

        if (!isOperator(text.charAt(text.length() - 1))){
            setSymbol(str);
        }
    }

    public void isCalc()
    {
        BigInteger big = new BigInteger(mainEditText.getText().toString(), notation);
        String text = big.toString(10);
        Expression e = new Expression(text);
        String textres = "" + e.calculate();
        BigInteger bigInt = new BigInteger(textres);
        String textresult= bigInt.toString(notation);
        resultEditText.setText(textresult);

        if (resultEditText.getText().toString().equals("NaN")) {
            resultEditText.setText("Неверное выражение");
        }
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    boolean isEditTextEmpty() {
        return mainEditText.getText().toString().equals("");
    }

    public void setBin() {

        buttonArray[27].setTextColor(Color.BLACK);
        buttonArray[26].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[25].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[24].setTextColor(getResources().getColor(R.color.colorButtonOp));


        for (int buttonid : buttonLettersArray) {
            ((Button) findViewById(buttonid)).setTextColor(Color.GRAY);
            findViewById(buttonid).setEnabled(false);
        }
        for (int buttonid : buttonNumber2to7Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.GRAY);
            findViewById(buttonid).setEnabled(false);
        }
        for (int buttonid : buttonNumber8to9Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.GRAY);
        findViewById(buttonid).setEnabled(false);
    }

    }


    public void setOct() {

        buttonArray[26].setTextColor(Color.BLACK);
        buttonArray[27].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[25].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[24].setTextColor(getResources().getColor(R.color.colorButtonOp));

        for (int buttonid : buttonLettersArray) {
            ((Button) findViewById(buttonid)).setTextColor(Color.GRAY);
            findViewById(buttonid).setEnabled(false);
        }
        for (int buttonid : buttonNumber2to7Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.WHITE);
            findViewById(buttonid).setEnabled(true);
        }
        for (int buttonid : buttonNumber8to9Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.GRAY);
            findViewById(buttonid).setEnabled(false);
        }

    }

    public void setDec() {

        buttonArray[25].setTextColor(Color.BLACK);
        buttonArray[26].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[27].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[24].setTextColor(getResources().getColor(R.color.colorButtonOp));

        for (int buttonid : buttonLettersArray) {
            findViewById(buttonid).setEnabled(false);
            ((Button) findViewById(buttonid)).setTextColor(Color.GRAY);

        }
        for (int buttonid : buttonNumber2to7Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.WHITE);
            findViewById(buttonid).setEnabled(true);
        }
        for (int buttonid : buttonNumber8to9Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.WHITE);
            findViewById(buttonid).setEnabled(true);
        }

    }

    public void setHex() {

        buttonArray[24].setTextColor(Color.BLACK);
        buttonArray[26].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[25].setTextColor(getResources().getColor(R.color.colorButtonOp));
        buttonArray[27].setTextColor(getResources().getColor(R.color.colorButtonOp));

        for (int buttonid : buttonLettersArray) {
            ((Button) findViewById(buttonid)).setTextColor(Color.WHITE);
            findViewById(buttonid).setEnabled(true);
        }
        for (int buttonid : buttonNumber2to7Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.WHITE);
            findViewById(buttonid).setEnabled(true);
        }
        for (int buttonid : buttonNumber8to9Array) {
            ((Button) findViewById(buttonid)).setTextColor(Color.WHITE);
            findViewById(buttonid).setEnabled(true);
        }

    }

    int priority(char oper) {
        // Если символ * или / - приоритет 1
        if (oper == '*' || oper == '/') {
            return 1;
        }
        // Если символ + или - — приоритет 0
        else if (oper == '+' || oper == '-') {
            return 0;
        }
        // Если ни то, ни другое - приоритет -1
        else {
            return -1;
        }
    }

    boolean calculate(LinkedList<BigInteger> st, char oper) {
        // Инициализируем и объявляем две переменные
        // Первая берет последнее значение из переданного
        // связанного листа в параметре, запоминает и удаляет
        // его из списка
        BigInteger someOne = st.removeLast();

        BigInteger someTwo = st.removeLast();

        switch (oper) {
            case '+':
                st.add(someTwo.add(someOne));
                return true;
            case '-':
                st.add(someTwo.subtract(someOne));
                return true;
            case '*':
                st.add(someTwo.multiply(someOne));
                return true;
            case '/':
                try{
                    st.add(someTwo.divide(someOne));
                    return true;
                }catch(ArithmeticException ex){
                    Log.d("ERROR", "error");
                    return false;
                }
            default:
                System.out.println("Oops");
        }
        return true;
    }

    BigInteger gerResultInDec(String s, int baseFrom) {

        // Создаем два контейнера типа LinkedList
        // Один для чисел, другой для символов
        LinkedList<BigInteger> someNumbers = new LinkedList<>();
        LinkedList<Character> someOpers = new LinkedList<>();

        // Пишем цикл, который бегает по нашей строке
        for (int i = 0; i < s.length(); i++) {

            // Создаем локальную переменную типа символ,
            // чтобы было с чем делать сравнения и работать.
            // Присваиваем ей текущее положение i в строке
            char c = s.charAt(i);

            // Если натыкаемся на открывающуюся скобку
            if (c == '(') {

                // Добавляем открывающуюся скобку в контейнер
                // символов
                someOpers.add('(');

            }

            // Если натыкаемся на закрывающуюся скобку
            else if (c == ')') {

                // Смотрим - пока последний символ контейнера
                // символов не открывающаяся скобка -
                // Выполняем метод, который учит считать
                // программу, передавая ему в параметрах
                // наш контейнер с числами и последний
                // символ в контейнере символов, причем
                // удаляя его опосля
                while (someOpers.getLast() != '(') {
                    boolean isGood = calculate(someNumbers, someOpers.removeLast());
                    if (!isGood) {
                        return new BigInteger("0");
                    }
                }

                // После while - удаляем последний символ
                // из Символьного Контейнера. Если смотреть
                // пример - это открывающаяся скобка
                someOpers.removeLast();
            }

            // Так же, во время цикла мы проверяем каждый символ
            // на предмет - а не оператор ли он часом?
            // Если же да, то
            // ПОКА массив символов непустой и приоритет
            // последнего символа в контейнере символов
            // больше или равен приоритету текущего -
            // "учим" программу считать, передавая в параметрах
            // контейнер с числами и последний символ из
            // контейнера символов, удаляя его опосля
            else if (isOperator(c)) {
                while (!someOpers.isEmpty() &&
                        priority(someOpers.getLast()) >= priority(c)) {

                    boolean isGood = calculate(someNumbers, someOpers.removeLast());
                    if (!isGood) {
                        return new BigInteger("0");
                    }
                }

                // Если while не выполняется - добавляем
                // символ в контейнер символов
                someOpers.add(c);
            }

            // Если же ничего из вышеперечисленного не произошло,
            // то мы ожидаем число
            else if (Character.isDigit(c) || Character.isLetter(s.charAt(i))) {
                String operand = "";

                // После чего, ПОКА
                // текущее i меньше размера строки и
                // позиция от i в строке - число, -
                // мы составляем строку числа из символов,
                // увеличивая i на 1 каждый раз, когда символ
                // записался, чтобы проверять строку дальше

                while ((i < s.length() && Character.isDigit(s.charAt(i))) || Character.isLetter(s.charAt(i))) {
                    operand += s.charAt(i++);
                    if (i == s.length()) {
                        break;
                    }
                }

                // Если while не выполнился или закончился -
                // отнимаем у i единицу (т.к. i++ отработала
                // лишний раз, и добавляем нашу
                // распарсенную в числовой манер строку,
                // которую мы составили из чисел в
                // Числовой Контейнер
                --i;
                Log.d("operand", "" + operand);
                someNumbers.add(new BigInteger(operand, baseFrom));
                Log.d("BigInteger10", "" + new BigInteger(operand, baseFrom));
            }
        }

        // После цикла,
        // ПОКА контейнер символов НЕ пустой, -
        // "учим" считать программу, передавая ей наш контейнер
        // чисел и контейнер символов.
        while (!someOpers.isEmpty()) {
            boolean isGood = calculate(someNumbers, someOpers.removeLast());
            if (!isGood) {
                return new BigInteger("0");
            }
        }

        return someNumbers.get(0);
    }



}