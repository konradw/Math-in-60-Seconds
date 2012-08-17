package com.mathin60seconds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class GameOver extends MathMainActivity {

	SharedPreferences GameScores;
	
	//TextView roundOver = (TextView)findViewById(R.id.roundOver);
	//TextView totalQuestions = (TextView)findViewById(R.id.totalQuestions);
	//TextView totalCorrect = (TextView)findViewById(R.id.numberCorrect);
	//TextView totalWrong = (TextView)findViewById(R.id.numberWrong);
	//TextView roundScore = (TextView)findViewById(R.id.totalScore);
	//TextView goMenu = (TextView)findViewById(R.id.goToMenu);
	//TextView goPlayAgain = (TextView)findViewById(R.id.goPlayAgain);
	
	String totalScore;
	int numTotalScore;
	int highScore;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gameover);
	    GameScores = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
	    
	    final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
	    
	    TextView roundOver = (TextView)findViewById(R.id.roundOver);
	    roundOver.setText("Round Over!");
	    
	    TextView totalQuestions = (TextView)findViewById(R.id.totalQuestions);
	    TextView totalCorrect = (TextView)findViewById(R.id.numberCorrect);
	    TextView totalWrong = (TextView)findViewById(R.id.numberWrong);
	    TextView roundScore = (TextView)findViewById(R.id.totalScore);
	    TextView goMenu = (TextView)findViewById(R.id.goToMenu);
	    TextView goPlayAgain = (TextView)findViewById(R.id.goPlayAgain);

	    roundOver.setTypeface(marker);
	    totalQuestions.setTypeface(marker);
	    totalCorrect.setTypeface(marker);
	    totalWrong.setTypeface(marker);
	    roundScore.setTypeface(marker);
	    goMenu.setTypeface(marker);
	    goPlayAgain.setTypeface(marker);
	    
	    int numQuestions = GameScores.getInt(GAME_PREFERENCES_TOTALSCORE, MODE_PRIVATE);
	    int numRight = GameScores.getInt(GAME_PREFERENCES_RIGHTSCORE, MODE_PRIVATE);
	    int numWrong = GameScores.getInt(GAME_PREFERENCES_WRONGSCORE, MODE_PRIVATE);
	    int numTotal = (numQuestions * 100) - (numWrong * 25);
	    totalScore = String.valueOf(numTotal);
	    totalQuestions.setText("# of Questions" + String.valueOf(numQuestions));
	    totalCorrect.setText("# Correct " + String.valueOf(numRight));
	    totalWrong.setText("# Wrong " + String.valueOf(numWrong));
	    roundScore.setText("Score " + String.valueOf(numTotal));
	    
	    
	    saveScores();
	    startAnimation();
	    
	    // TODO Auto-generated method stub
	}
	
	public void saveScores()
	{
		GameScores = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		Editor saveScore = GameScores.edit();
		Bundle operands = getIntent().getExtras();
		int operand;
		operand = operands.getInt("op");
		
		switch (operand){
		case 1:
			if (GameScores.contains(GAME_PREFERENCES_ADDSCORE)){
			highScore = Integer.parseInt(GameScores.getString(GAME_PREFERENCES_ADDSCORE, null));
			numTotalScore = Integer.parseInt(totalScore);
			if (numTotalScore > highScore){
			saveScore.putString(GAME_PREFERENCES_ADDSCORE, totalScore);
			saveScore.commit();
			Toast.makeText(GameOver.this, "Added to add", Toast.LENGTH_LONG).show();
				}
			}
			else {
				saveScore.putString(GAME_PREFERENCES_ADDSCORE, totalScore);
				saveScore.commit();
			}
			break;
		case 2:
			if (GameScores.contains(GAME_PREFERENCES_SUBSCORE)){
			highScore = Integer.parseInt(GameScores.getString(GAME_PREFERENCES_SUBSCORE, null));
			numTotalScore = Integer.parseInt(totalScore);
			if (numTotalScore > highScore){
			saveScore.putString(GAME_PREFERENCES_SUBSCORE, totalScore);
			saveScore.commit();
			Toast.makeText(GameOver.this, "Added to sub", Toast.LENGTH_LONG).show();
				}
			}
			else {
				saveScore.putString(GAME_PREFERENCES_SUBSCORE, totalScore);
				saveScore.commit();
			}
			break;
		case 3:
			if (GameScores.contains(GAME_PREFERENCES_MULTSCORE)){
			highScore = Integer.parseInt(GameScores.getString(GAME_PREFERENCES_MULTSCORE, null));
			numTotalScore = Integer.parseInt(totalScore);
			if (numTotalScore > highScore){
			saveScore.putString(GAME_PREFERENCES_MULTSCORE, totalScore);
			saveScore.commit();
			Toast.makeText(GameOver.this, "Added to mult", Toast.LENGTH_LONG).show();
				}
			}
			else {
				saveScore.putString(GAME_PREFERENCES_MULTSCORE, totalScore);
				saveScore.commit();
			}
			break;
		case 4:
			if (GameScores.contains(GAME_PREFERENCES_DIVSCORE)){
			highScore = Integer.parseInt(GameScores.getString(GAME_PREFERENCES_DIVSCORE, null));
			numTotalScore = Integer.parseInt(totalScore);
			if (numTotalScore > highScore){
			saveScore.putString(GAME_PREFERENCES_DIVSCORE, totalScore);
			saveScore.commit();
			Toast.makeText(GameOver.this, "Added to div", Toast.LENGTH_LONG).show();
				}
			}
			else {
				saveScore.putString(GAME_PREFERENCES_DIVSCORE, totalScore);
				saveScore.commit();
			}
			break;
		default:
			Toast.makeText(GameOver.this, "Oooops did not pull operand", Toast.LENGTH_LONG).toString();			
		}
		
		
	}
	
	private void startAnimation()
	{
		TextView roundOver = (TextView)findViewById(R.id.roundOver);
		TextView totalQuestions = (TextView)findViewById(R.id.totalQuestions);
		TextView totalCorrect = (TextView)findViewById(R.id.numberCorrect);
		TextView totalWrong = (TextView)findViewById(R.id.numberWrong);
		TextView roundScore = (TextView)findViewById(R.id.totalScore);
		TextView goMenu = (TextView)findViewById(R.id.goToMenu);
		TextView goPlayAgain = (TextView)findViewById(R.id.goPlayAgain);
		Animation slideRound = AnimationUtils.loadAnimation(this, R.anim.gameover_1_slidein);
		roundOver.setAnimation(slideRound);
		Animation slideTotal = AnimationUtils.loadAnimation(this, R.anim.gameover_2_slidein);
		totalQuestions.startAnimation(slideTotal);
		Animation slideRight = AnimationUtils.loadAnimation(this, R.anim.gameover_3_slidein);
		totalCorrect.startAnimation(slideRight);
		Animation slideWrong = AnimationUtils.loadAnimation(this, R.anim.gameover_4_slidein);
		totalWrong.startAnimation(slideWrong);
		Animation slideScore = AnimationUtils.loadAnimation(this, R.anim.gameover_5_slidein);
		roundScore.startAnimation(slideScore);
		Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.gameover_fadein);
		goMenu.startAnimation(fadeIn);
		goPlayAgain.startAnimation(fadeIn);

	}
	
	public void goToMenu(View v)
	{
		try{
		startActivity(new Intent(GameOver.this, MainMenu.class));
		GameOver.this.finish();
		}
		catch (Exception e){
			Log.e("ERROR",e.toString());
		}
	}
	public void goPlayAgain(View v)
	{
		startActivity(new Intent(GameOver.this, PlayGame_Select.class));
		GameOver.this.finish();
	}

}
