package com.mathin60seconds;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends MathMainActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mainmenu);
	
	    // TODO Auto-generated method stub
	    final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
	    TextView title = (TextView) findViewById(R.id.title);
	    title.setTypeface(marker);
	    title = (TextView) findViewById(R.id.menuhelp);
	    title.setTypeface(marker);
	    title = (TextView) findViewById(R.id.menuplay);
	    title.setTypeface(marker);
	    title = (TextView) findViewById(R.id.menusettings);
	    title.setTypeface(marker);
	    title = (TextView) findViewById(R.id.menuscores);
	    title.setTypeface(marker);
	    
	 
	}

	public void onPlayText (View v){
		try{
		startActivity(new Intent(MainMenu.this, PlayGame_Select.class));
		MainMenu.this.finish();
		}
		catch (Exception e){
			Log.e("ERROR", e.toString());
		}
		
	}
	
	public void onSettingsText (View v){
		startActivity(new Intent(MainMenu.this, Settings.class));
		MainMenu.this.finish();
	}
	
	public void onScoresText (View v){
		startActivity(new Intent(MainMenu.this, Scores.class));
	}
	public void onHelpText (View v){
		startActivity(new Intent(MainMenu.this, Help.class));
	}
}
