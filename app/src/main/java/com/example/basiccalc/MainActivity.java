package com.example.basiccalc;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText field1;
    EditText field2;
    Button mode;
    Button calculate;
    TextView result;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1 = findViewById(R.id.editText1);
        field2 = findViewById(R.id.editText2);
        result = findViewById(R.id.result);
        mode = findViewById(R.id.button_mode);
        mode.setText("MODE_ADDITION");
        mode.setTag(1);
        count=0;

        calculate = findViewById(R.id.button_calc);

    }

    public void onModeChanged(View view)
    {
        //int m = Integer.parseInt(view.getTag().toString());
        count=(count+1)%4;
        switch (count)
        {
            case 1: //mode.setTag(2);
                mode.setText("MODE_SUBTRACTION");
                break;
            case 2:// mode.setTag(3);
                mode.setText("MODE_MULTIPLICATION");
                break;
            case 3: //mode.setTag(4);
                mode.setText("MODE_DIVISION");
                break;
            case 0: //mode.setTag(1);
                mode.setText("MODE_ADDITION");
                break;
        }
    }

    public void onCalculate(View view)
    {
        String s = mode.getText().toString();

        String s1, s2;
        //double sum=0,c=0,d=0;
        float a,b,sum=0;

        s1 = field1.getText().toString();
        s2 = field2.getText().toString();

        a = Float.parseFloat(s1);
        b = Float.parseFloat(s2);

        if(s.equals("MODE_ADDITION"))
            sum = a+b;
        else if(s.equals("MODE_SUBTRACTION"))
            sum = a-b;
        else if(s.equals("MODE_MULTIPLICATION"))
            sum = a*b;
        else if(s.equals("MODE_DIVISION"))
            sum = a/b;

        result.setText(sum+"");

    }
}
