package com.krkeco.portfolio;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import javax.xml.datatype.*;
import java.util.*;
import android.graphics.*;
import android.widget.TableLayout.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		startup();
    }

	public void startup(){

		LinearLayout main = (LinearLayout) findViewById(R.id.main);
		//main.set

		Context context = getApplicationContext();
		
		for(int x = 0;x<appQ;x++){
			Button appButton = new Button(context);
			appButton.setText(appNames[x]);
			appButton.setOnClickListener(buttonListener);
						
			LinearLayout.LayoutParams param= new LayoutParams(
			LayoutParams.WRAP_CONTENT,
			LayoutParams.WRAP_CONTENT);
			param.setMargins(50,5,50,5);
			appButton.setLayoutParams(param);
			
			Random rand = new Random();
			int colorz = Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
			appButton.setBackgroundColor(colorz);
			main.addView(appButton);

		}
	}

	private OnClickListener buttonListener = new OnClickListener(){
		public void onClick(View view) {
			int index = ((ViewGroup) view.getParent()).indexOfChild(view);
			toast("opening application: "+appNames[index]);
		}
	};
	
	//when adding more apps to portfolio this makes it easier
	// just don't forget to add the name in appNames!
	public static int appQ = 6;

	public static String[] appNames = new String[appQ];{

		appNames[0] = "Popular Movies";
		appNames[1] = "Stock Hawk";
		appNames[2] = "Build it Bigger";
		appNames[3] = "Make Your App Material";
		appNames[4] = "Go Ubiquitous";
		appNames[5] = "Capstone";

	}
	

	public void toast(String string) {
		Context context = getApplicationContext();
		CharSequence text = string;
		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		toast.show();
	}
	
}
