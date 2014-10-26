package com.choongang.graphic;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View{

	public MyView(Context context) {
		super(context);

	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.LTGRAY);
		Paint paint=new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		paint.setAntiAlias(true);

		canvas.drawCircle(getWidth()/2,getHeight()/2,50, paint);
		paint.setColor(Color.BLUE);
		canvas.drawRect(10,10,110,110,paint);
		try{
			   //Image ±×¸®±â
			   //#1.resource-->Bitmap

			   //Resources res=getResources();
			   //Bitmap bitmap=BitmapFactory.decodeResource(res, R.drawable.eclair);

			   //#2.SDCARD FILE-->Bitmap
			   //Bitmap bitmap=BitmapFactory.decodeFile("/sdcard/donut.gif");

			   //#3.NETWORK,File(Stream)-->Bitmap
			   URL url=new URL("http://icon.daumcdn.net/w/c/11/02/43507295159546319.jpeg");
			   InputStream in = url.openStream();
			   Bitmap bitmap=BitmapFactory.decodeStream(in);


			   canvas.drawBitmap(bitmap, 10, 120, null);
			   Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 50, 50, false);
			   canvas.drawBitmap(scaledBitmap, 10, 280, null);

			   bitmap.recycle();
			   scaledBitmap.recycle();
			   
			   
			  }catch (Exception e) {
			   
			  }
}
}