package com.example.pinch;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.*;

public class MainActivity extends ActionBarActivity {
	ImageView img;
	Matrix m = new Matrix();
	float scale = 1f;
	ScaleGestureDetector s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img = (ImageView)findViewById(R.id.imageView1);
		s = new ScaleGestureDetector(this,new demogesture());
	}
	
	
	private class demogesture extends ScaleGestureDetector.SimpleOnScaleGestureListener
	{
		@Override
		public boolean onScale(ScaleGestureDetector d)
		{
			scale*=d.getScaleFactor();
			scale=Math.max(0.1f, Math.min(scale, 5.0f));
			m.setScale(scale, scale);
			img.setImageMatrix(m);
			return true;
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent me)
	{
		s.onTouchEvent(me);
		return true;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
