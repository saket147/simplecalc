package com.example.saket.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    Spinner sp;
    EditText et1,et2;
    TextView tv1;
    int result=0,num1=0,num2=0,s=0;
    SeekBar sbar;
    ToggleButton tbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            et2 = (EditText) findViewById(R.id.etext1);
            sp = (Spinner) findViewById(R.id.spin);
            tv1 = (TextView) findViewById(R.id.txtv1);
            sbar=(SeekBar)findViewById(R.id.sbar1);
            tbtn= (ToggleButton)findViewById(R.id.tgbtn);

            sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b)
                {
                    if(s<=0)
                    {
                        s=30;
                    }
                    else
                    {
                        s=i;
                        tv1.setTextSize(s);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar)
                {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar)
                {

                }
            });
            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override


                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (!et1.getText().toString().trim().equals("")) {
                        num1 = Integer.parseInt(et1.getText().toString());
                    }
                    if (!et2.getText().toString().trim().equals("")) {
                        num2 = Integer.parseInt(et2.getText().toString());
                    }


                    switch (i) {
                        case 0:
                            result = num1 + num2;
                            break;
                        case 1:
                            result = num1 - num2;
                            break;
                        case 2:
                            result = num1 * num2;
                            break;
                        case 3:
                            result = num1 / num2;
                            break;
                    }
                    tv1.setText(String.valueOf(result));
                }


                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        catch (Exception ex)
        {

        }



    }


}
