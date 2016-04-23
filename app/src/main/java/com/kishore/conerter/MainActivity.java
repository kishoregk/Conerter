package com.kishore.conerter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;


public class    MainActivity extends ActionBarActivity  {

    Spinner spinner;
    Spinner  spinner1;
    Button convert;
    EditText input;
    EditText output;
    private String spinnerValueOne;
    private String spinner1ValueTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this spinner is to select the measurement from
        spinner = (Spinner) findViewById(R.id.spinnerUserSelectFrom);
        ArrayAdapter adapter= ArrayAdapter.createFromResource(this, R.array.converter, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerValueOne=(String)adapterView.getAdapter().getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
// this spinner is to select to measure
        spinner1 = (Spinner) findViewById(R.id.spinnerUserWantTO);
        ArrayAdapter adapter1=  ArrayAdapter .createFromResource(this, R.array.convertTo, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner1ValueTwo = (String) adapterView.getAdapter().getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        convert = (Button) findViewById(R.id.buttonConvert);
        input=(EditText) findViewById(R.id.editUserenter);
        output=(EditText) findViewById(R.id.et_output);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    double value=Double.parseDouble(input.getText().toString());
                    displayResult(value);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Enter proper value",Toast.LENGTH_SHORT).show();
                }



            }
        });





    }

                public void displayResult(double value) {
                    double result = 0;

                 //   if (spinnerValueOne.equalsIgnoreCase(spinner1ValueTwo)) {
                      //  Toast.makeText(getApplicationContext(), " please select different options..", Toast.LENGTH_LONG).show();
                      //  return;
                 //   }

                    if (spinnerValueOne.equals("mm") && spinner1ValueTwo.equalsIgnoreCase("cm")) {
                        result = 0.1 * value;

                    }else if(spinnerValueOne.equals("mm")&& spinner1ValueTwo.equalsIgnoreCase("mm")){
                        result=1*value;
                    } else if (spinnerValueOne.equals("cm") && spinner1ValueTwo.equalsIgnoreCase("mm")) {
                        result = 10* value;
                    }else if(spinnerValueOne.equals("mm")&& spinner1ValueTwo.equalsIgnoreCase("M")){
                        result= 0.001*value;
                    }else if(spinnerValueOne.equals("mm")&& spinner1ValueTwo.equalsIgnoreCase("km")){
                        result= 0.000001*value;
                    } else if(spinnerValueOne.equals("cm")&& spinner1ValueTwo.equalsIgnoreCase("M")){
                        result= 0.01*value;
                    }else if(spinnerValueOne.equals("cm")&& spinner1ValueTwo.equalsIgnoreCase("cm")){
                        result=1*value;
                    } else if(spinnerValueOne.equals("cm")&& spinner1ValueTwo.equalsIgnoreCase("km")){
                        result=0.00001*value;
                    } else if(spinnerValueOne.equals("M")&& spinner1ValueTwo.equalsIgnoreCase("cm")){
                        result= 100*value;
                    }else if(spinnerValueOne.equals("M")&& spinner1ValueTwo.equalsIgnoreCase("mm")){
                        result=1000*value;
                    }else if(spinnerValueOne.equals("M")&& spinner1ValueTwo.equalsIgnoreCase("M")){
                        result=1*value;
                    } else if(spinnerValueOne.equals("M")&& spinner1ValueTwo.equalsIgnoreCase("km")){
                        result= 0.001*value;
                    }else if(spinnerValueOne.equals("km")&& spinner1ValueTwo.equalsIgnoreCase("M")){
                        result= 1000*value;
                    }else if(spinnerValueOne.equals("km")&& spinner1ValueTwo.equalsIgnoreCase("cm")){
                        result=100000*value;
                    }else if(spinnerValueOne.equals("km")&& spinner1ValueTwo.equalsIgnoreCase("mm")){
                        result=1000000*value;
                    }else if(spinnerValueOne.equals("km")&& spinner1ValueTwo.equalsIgnoreCase("km")){
                        result=1*value;
                    }

                    output.setText(""+result);
                }


}
