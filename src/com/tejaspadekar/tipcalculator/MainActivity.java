package com.tejaspadekar.tipcalculator;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void calculateTip(View view) {
    	EditText userEntry = (EditText) findViewById(R.id.amount);
    	double amount = 0;
    	
    	try {
    		amount = Double.parseDouble(userEntry.getText().toString());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	double tipPerc = Double.parseDouble(view.getTag().toString());
    	
    	TextView result = (TextView) findViewById(R.id.result);
    	
    	BigDecimal tip = new BigDecimal(amount*tipPerc/100);
    	tip = tip.setScale(2,BigDecimal.ROUND_UP);
    	
    	result.setText("Tip: $" + tip);
    	
    }
}
