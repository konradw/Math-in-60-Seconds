package com.mathin60seconds;

//import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class PlayGame_Select extends MathMainActivity {
	int mathSelection;
	int diffSelection = 1;
	final Bundle operand = new Bundle();
	//public TextView diffSelEasy = (TextView) findViewById(R.id.diffEasy);
	//public TextView diffSelMed = (TextView) findViewById(R.id.diffMed);
	//public TextView diffSelHard = (TextView) findViewById(R.id.diffHard);
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    try {
	    setContentView(R.layout.playgame_select);
	    }
	    catch (Exception e){
	    	Log.e("ERROR" , e.toString());
	    }
        startAnimating();
        
        
        // put default Easy incase user does not select
	    operand.putInt("diff", diffSelection);
		
        
	    final Typeface marker;
	    marker = Typeface.createFromAsset(getAssets(), "fonts/MarkerFelt.ttc");
	    TextView title = (TextView) findViewById(R.id.select_math);
	    title.setTypeface(marker);
	    title = (TextView)findViewById(R.id.diffEasy);
	    title.setTypeface(marker);
	    title = (TextView)findViewById(R.id.diffMed);
	    title.setTypeface(marker);
	    title = (TextView)findViewById(R.id.diffHard);
	    title.setTypeface(marker);
	    
	    //TextView diffSel = (TextView) findViewById(R.id.diffEasy);
	    //diffSelEasy.setTextColor(R.color.purple);
	    
	    
	    // TODO Auto-generated method stub
	}

	private void startAnimating() {
    	// scale down "math"
        ImageView logoMath = (ImageView) findViewById(R.id.plus);
        Animation slideRight = AnimationUtils.loadAnimation(this, R.anim.slidein_2);
        logoMath.startAnimation(slideRight);
        logoMath = (ImageView)findViewById(R.id.minus);
        logoMath.startAnimation(slideRight);
        logoMath = (ImageView)findViewById(R.id.times);
        logoMath.startAnimation(slideRight);
        logoMath = (ImageView)findViewById(R.id.divide);
        logoMath.startAnimation(slideRight);
        TextView diffText = (TextView) findViewById(R.id.diffEasy);
        Animation dropIn = AnimationUtils.loadAnimation(this, R.anim.dropin);
        diffText.startAnimation(dropIn);
        diffText = (TextView) findViewById(R.id.diffHard);
        diffText.startAnimation(dropIn);
        diffText = (TextView) findViewById(R.id.diffMed);
        diffText.startAnimation(dropIn);
        
	}
	
	public void startGame (){
		Intent startGame = new Intent();
		startGame.setClass(PlayGame_Select.this, PlayGame.class);
		startGame.putExtras(operand);
		startActivity(startGame);
	}
	
	public void onPlus (View v){
		mathSelection = 1;
		operand.putInt("op", mathSelection);
		startGame();
	}
	public void onMinus (View v){
		mathSelection = 2;
		operand.putInt("op", mathSelection);
		startGame();
	}
	public void onTimes (View v){
		mathSelection = 3;
		operand.putInt("op", mathSelection);
		startGame();
	}
	public void onDivide (View v){
		mathSelection = 4;
		operand.putInt("op", mathSelection);
		startGame();
	}
	
	public void onEasy (View v){
		diffSelection = 1;
		operand.putInt("diff", diffSelection);
		TextView diffSelEasy = (TextView) findViewById(R.id.diffEasy);
		TextView diffSelMed = (TextView) findViewById(R.id.diffMed);
		TextView diffSelHard = (TextView) findViewById(R.id.diffHard);
		diffSelEasy.setTextColor(getResources().getColor(R.color.purple));
		diffSelMed.setTextColor(getResources().getColor(R.color.green));
		diffSelHard.setTextColor(getResources().getColor(R.color.green));
		
	}
	public void onMed (View v){
		diffSelection = 2;
		operand.putInt("diff", diffSelection);
		TextView diffSelEasy = (TextView) findViewById(R.id.diffEasy);
		TextView diffSelMed = (TextView) findViewById(R.id.diffMed);
		TextView diffSelHard = (TextView) findViewById(R.id.diffHard);
		diffSelEasy.setTextColor(getResources().getColor(R.color.green));
		diffSelMed.setTextColor(getResources().getColor(R.color.purple));
		diffSelHard.setTextColor(getResources().getColor(R.color.green));
	}
	public void onHard (View v){
		diffSelection = 3;
		operand.putInt("diff", diffSelection);
		TextView diffSelEasy = (TextView) findViewById(R.id.diffEasy);
		TextView diffSelMed = (TextView) findViewById(R.id.diffMed);
		TextView diffSelHard = (TextView) findViewById(R.id.diffHard);
		diffSelEasy.setTextColor(getResources().getColor(R.color.green));
		diffSelMed.setTextColor(getResources().getColor(R.color.green));
		diffSelHard.setTextColor(getResources().getColor(R.color.purple));
	}
}

