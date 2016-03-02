package com.example.createsubpic;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
		Options opts =new Options();
		Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tomcat);
		iv_src.setImageBitmap(srcBitmap);
		
		Bitmap coptBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
		Paint paint =new Paint();
		Canvas canvas =new Canvas(coptBitmap);
		canvas.drawBitmap(srcBitmap, new Matrix(), paint);
		for(int x=0;x<10;x++){
			for (int y=0;y<10;y++) {
				coptBitmap.setPixel(10+x, 20+y, Color.RED);
			}
		}
		iv_copy.setImageBitmap(coptBitmap);
		
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
