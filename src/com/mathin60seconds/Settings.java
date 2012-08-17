package com.mathin60seconds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Settings extends MathMainActivity {

	SharedPreferences GameScores;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.settings);
	    
	    initNicknameEntry();
	   	
	    // TODO Auto-generated method stub
	}
	
	public void initNicknameEntry() {
		GameScores = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		EditText nicknameText = (EditText) findViewById(R.id.edittext_nickname);
		if (GameScores.contains(GAME_PREFERENCES_NICKNAME)) {
			nicknameText.setText(GameScores.getString(
					GAME_PREFERENCES_NICKNAME, ""));
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		GameScores = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		
		EditText nicknameText = (EditText) findViewById(R.id.edittext_nickname);

		String strNickname = nicknameText.getText().toString();
				
		Editor editor = GameScores.edit();
		editor.putString(GAME_PREFERENCES_NICKNAME, strNickname);
		editor.commit();
	}
	
	   public void onBack (View v){
	    	try{
	    		startActivity(new Intent(Settings.this, MainMenu.class));
	    		Settings.this.finish();
	    		}
	    		catch (Exception e){
	    			Log.e("ERROR",e.toString());
	    		}
	    	
	    	
	    }


}
