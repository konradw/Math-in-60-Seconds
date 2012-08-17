package com.mathin60seconds;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Help extends MathMainActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.help);
	    final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
        InputStream iFile = getResources().openRawResource(R.raw.mathhelp);
        try {
        	TextView helpText = (TextView) findViewById(R.id.mathhelp);
        	helpText.setTypeface(marker);
        	String strFile = inputStreamToString(iFile);
        	helpText.setText(strFile);
        }
        catch (Exception e) {
        	String DEBUG_TAG = "Input stream error in Help Activity";
        	Log.e(DEBUG_TAG , "InputStreamToString failure", e);
        }
        
    }
    
    public String inputStreamToString(InputStream is) throws IOException {
    	StringBuffer sBuffer = new StringBuffer();
    	DataInputStream dataIO = new DataInputStream(is);
    	String strLine = null;
    	while ((strLine = dataIO.readLine()) != null){
    		sBuffer.append(strLine + "\n");
    		
    	}
    	dataIO.close();
    	is.close();
    	return sBuffer.toString();
    }
	    // TODO Auto-generated method stub
    public void onBack (View v){
    	try{
    		startActivity(new Intent(Help.this, MainMenu.class));
    		Help.this.finish();
    		}
    		catch (Exception e){
    			Log.e("ERROR",e.toString());
    		}
    	
    	
    }
    
	}

