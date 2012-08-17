package com.mathin60seconds;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class Scores extends MathMainActivity {
	
	SharedPreferences GameScores;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.scores);
	    
	    TextView scoreTitle = (TextView) findViewById(R.id.scores_title);
	    final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
	    scoreTitle.setTypeface(marker);
	    scoreTitle.setText("Scores");
	    

	    TabHost host = (TabHost) findViewById(R.id.TabHost1);
	    
	    host.setup();
	    
	    TabSpec easyScoresTab = host.newTabSpec("EasyTab");
        
        easyScoresTab.setIndicator("easy", getResources().getDrawable(android.R.drawable.star_big_on));
        
        easyScoresTab.setContent(R.id.easyScores);
        host.addTab(easyScoresTab);
        
        TabSpec medScoresTab = host.newTabSpec("MedTab");
        
        medScoresTab.setIndicator("medium", getResources().getDrawable(android.R.drawable.star_big_on));
        
        medScoresTab.setContent(R.id.medScores);
        host.addTab(medScoresTab);
        
        TabSpec hardScoresTab = host.newTabSpec("HardTab");
        
        hardScoresTab.setIndicator("hard", getResources().getDrawable(android.R.drawable.star_big_on));
        
        hardScoresTab.setContent(R.id.hardScores);
        host.addTab(hardScoresTab);
        
        setScorestoEasy();
        
	}
	
	public void setScorestoEasy(){
		GameScores = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		TextView add = (TextView) findViewById(R.id.addScore);
		add.setText(GameScores.getString(GAME_PREFERENCES_ADDSCORE, null) + " "  + GameScores.getString(GAME_PREFERENCES_NICKNAME, null));
		TextView sub = (TextView) findViewById(R.id.subScore);
		sub.setText(GameScores.getString(GAME_PREFERENCES_SUBSCORE, null) + " "  + GameScores.getString(GAME_PREFERENCES_NICKNAME, null));
		TextView mult = (TextView) findViewById(R.id.multScore);
		mult.setText(GameScores.getString(GAME_PREFERENCES_MULTSCORE, null) + " "  + GameScores.getString(GAME_PREFERENCES_NICKNAME, null));
		TextView div = (TextView) findViewById(R.id.divScore);
		div.setText(GameScores.getString(GAME_PREFERENCES_DIVSCORE, null) + " "  + GameScores.getString(GAME_PREFERENCES_NICKNAME, null));
		
		
	}
}
