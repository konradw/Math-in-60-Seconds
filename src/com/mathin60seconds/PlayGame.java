package com.mathin60seconds;

import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class PlayGame extends MathMainActivity {
	
    
    SharedPreferences GameScores;
	
	String strGuess = "";
	int answer = 0;
	int totalQuestions = 0;
	int correctAnswers = 0;
	int wrongAnswers = 0;
	int timer = 60;
	boolean gameover = false;
	Bundle operands = new Bundle();
	int operand;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.playgame);
	    
	    final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
	    final TextView title = (TextView) findViewById(R.id.countdown);
	    title.setTypeface(marker);
	    
	    final TextView number0 = (TextView) findViewById(R.id.number0);
	    number0.setTypeface(marker);
	    final TextView number1 = (TextView) findViewById(R.id.number1);
	    number1.setTypeface(marker);
	    final TextView number2 = (TextView) findViewById(R.id.number2);
	    number2.setTypeface(marker);
	    final TextView number3 = (TextView) findViewById(R.id.number3);
	    number3.setTypeface(marker);
	    final TextView number4 = (TextView) findViewById(R.id.number4);
	    number4.setTypeface(marker);
	    final TextView number5 = (TextView) findViewById(R.id.number5);
	    number5.setTypeface(marker);
	    final TextView number6 = (TextView) findViewById(R.id.number6);
	    number6.setTypeface(marker);
	    final TextView number7 = (TextView) findViewById(R.id.number7);
	    number7.setTypeface(marker);
	    final TextView number8 = (TextView) findViewById(R.id.number8);
	    number8.setTypeface(marker);
	    final TextView number9 = (TextView) findViewById(R.id.number9);
	    number9.setTypeface(marker);
	    final TextView subBtn = (TextView) findViewById(R.id.submit);
	    subBtn.setTypeface(marker);
	    
	    
	   new CountDownTimer(5000, 1000) {
		   public void onTick(long timeTillDone) {
			   title.setText("Game Starts in: " + timeTillDone / 1000);
		   }
		   public void onFinish() {
			   createquasion();
			   new CountDownTimer(60000, 1000) {
				   public void onTick(long timeTillDone) {
					   title.setText("Time Left: " + timeTillDone / 1000);
					   timer --;
					   if (timer < 10){
						   TextView timeLeft = (TextView)findViewById(R.id.countdown);
						   timeLeft.setTextColor(getResources().getColor(R.color.red));
					   }
				   }
				   public void onFinish() {
					 
					 saveScoreData();
					 				 
				   }
				   }.start();
			   }	   
	   }.start();
	   
	}
	
	
	
	public int createquasion(){
		
		final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
		
		int num1 = 0;
		int num2 = 0;
		String strOfNum1;
		String strOfNum2;
		
		//Random randNum = new Random();
		//int difficulty;
		//Bundle operands = getIntent().getExtras();
		//difficulty = operands.getInt("diff");
		
		//switch (difficulty){
		//case 1:
		//	num1 = randNum.nextInt(10);
		//	num2 = randNum.nextInt(10);
		//	break;
		//case 2:
		//	num1 = randNum.nextInt(50);
		//	num2 = randNum.nextInt(50);
		//	break;
		//case 3:
		//	num1 = randNum.nextInt(100);
		//	num2 = randNum.nextInt(100);
		//	break;
		//default:
		//	num1 = randNum.nextInt(1);
		//	num2 = randNum.nextInt(1);
		//	break;
		//}
		
		num1 = generateNumber();
		num2 = generateNumber();
		
		operands = getIntent().getExtras();
		operand = operands.getInt("op");
		
		TextView strOp = (TextView) findViewById(R.id.math);
		strOp.setTypeface(marker);
		
		switch (operand){
		case 1:
			strOp.setText("+");
			answer = num1 + num2;
			break;
		case 2:
			strOp.setText("-");
			answer = num1 - num2;
			while (answer < 0){
				num1 = generateNumber();
				num2 = generateNumber();
				answer = num1 - num2; 
			}
			
			break;
		case 3:
			strOp.setText("x");
			answer = num1 * num2;
			break;
		case 4:
			strOp.setText("Ö");
			//answer = num1 / num2;
			while ((num1 % num2) != 0){
				num1 = generateNumber();
				num2 = generateNumber();
				//answer = num1 / num2;
			}
			answer = num1 / num2;
			break;
		default :
			strOp.setText("Oops");
			break;
		}
		
		TextView strNum1 = (TextView) findViewById(R.id.num1);
		
		strOfNum1 = String.valueOf(num1);
		strNum1.setTypeface(marker);
		strNum1.setText(strOfNum1);
		
		TextView strNum2 = (TextView) findViewById(R.id.num2);
		
		strOfNum2 = String.valueOf(num2);
		strNum2.setTypeface(marker);
		strNum2.setText(strOfNum2);
		
		return answer;
	}
	private int generateNumber(){
		
		Random randNum = new Random();
		int difficulty;
		operands = getIntent().getExtras();
		difficulty = operands.getInt("diff");
		int number;
		switch (difficulty){
		case 1:
			number = randNum.nextInt(10);
			return number;
			
		case 2:
			number = randNum.nextInt(50);
			return number;
			
		case 3:
			number = randNum.nextInt(100);
			return number;
			
		default:
			number = randNum.nextInt(1);
			return number;
			
		}
	}
	public void onOne(View v) {
		strGuess = strGuess + "1";
		updateDisplay();
		 
	}
	public void onTwo(View v) {
		strGuess = strGuess + "2";
		updateDisplay();

	}
	public void onThree(View v) {
		strGuess = strGuess + "3";
		updateDisplay();

	}
	public void onFour(View v) {
		strGuess = strGuess + "4";
		updateDisplay();

	}
	public void onFive(View v) {
		strGuess = strGuess + "5";
		updateDisplay();

	}
	public void onSix(View v) {
		strGuess = strGuess + "6";
		updateDisplay();

	}
	public void onSeven(View v) {
		strGuess = strGuess + "7";
		updateDisplay();

	}
	public void onEight(View v) {
		strGuess = strGuess + "8";
		updateDisplay();

	}
	public void onNine(View v) {
		strGuess = strGuess + "9";
		updateDisplay();

	}
	public void onZero(View v) {
		strGuess = strGuess + "0";
		updateDisplay();

	}
	
	public void updateDisplay() {
		TextView display = (TextView) findViewById(R.id.display);
		final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
	    display.setTypeface(marker);
		display.setText(strGuess);
		
	}
	
	public void onSubmit(View v) {
		
		if (strGuess.isEmpty())
		{
			totalQuestions++;
			wrongAnswers++;
		}
		
		else
		{
		try
		{
		int guess = Integer.parseInt(strGuess);
		
		if (guess == answer){
			totalQuestions++;
			correctAnswers++;
			createquasion();		
		}
		else {
			totalQuestions++;
			wrongAnswers++;
			createquasion();
		}
		
		TextView display = (TextView) findViewById(R.id.display);
		display.setText("");
		strGuess = "";
		}
		catch (Exception e)
		{
			// add toast! 
		}
		}
	}
	
	public void onClear(View v) {
		strGuess = "";
		updateDisplay();
	}
	
	public void saveScoreData(){
		GameScores = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		Editor scoreEdit = GameScores.edit();
		 scoreEdit.putInt(GAME_PREFERENCES_TOTALSCORE, totalQuestions);
		 scoreEdit.putInt(GAME_PREFERENCES_RIGHTSCORE, correctAnswers);
		 scoreEdit.putInt(GAME_PREFERENCES_WRONGSCORE, wrongAnswers);
		 scoreEdit.commit();
		 operands.putInt("op", operand);
		 Intent gameOver = new Intent();
		 gameOver.putExtras(operands);
		 gameOver.setClass(PlayGame.this, GameOver.class);
		 startActivity(gameOver);
		 PlayGame.this.finish();
		
	}
	
}
