package com.mathin60seconds;


import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class SplashScreen extends MathMainActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        startAnimating();
    }

    /**
     * Helper method to start the animation on the splash screen
     */
    private void startAnimating() {
    	// scale down "math"
        ImageView logoMath = (ImageView) findViewById(R.id.imageMath);
        Animation dropIn = AnimationUtils.loadAnimation(this, R.anim.dropin);
        logoMath.startAnimation(dropIn);
        
        ImageView logoIn60 = (ImageView) findViewById(R.id.imageIn60);
        Animation dropIn2 = AnimationUtils.loadAnimation(this, R.anim.dropin2);
        logoIn60.startAnimation(dropIn2);
        
        ImageView logoSeconds = (ImageView) findViewById(R.id.imageSeconds);
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slidein);
        logoSeconds.startAnimation(slideIn);
        
        slideIn.setAnimationListener(new AnimationListener() {
            @Override
			public void onAnimationEnd(Animation animation) {
                // The animation has ended, transition to the Main Menu screen
                startActivity(new Intent(SplashScreen.this, MainMenu.class));
                SplashScreen.this.finish();
            }

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Stop the animation
        ImageView logoMath = (ImageView) findViewById(R.id.imageMath);
        logoMath.clearAnimation();
        ImageView logoIn60 = (ImageView) findViewById(R.id.imageIn60);
        logoIn60.clearAnimation();
        ImageView logoSeconds = (ImageView) findViewById(R.id.imageSeconds);
        logoSeconds.clearAnimation();
        
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Start animating at the beginning so we get the full splash screen experience
        startAnimating();
    }
}


