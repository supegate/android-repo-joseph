package com.choongang.http.image;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HttpGetImageActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button getB=(Button)findViewById(R.id.getB);
        getB.setOnClickListener(this);
    
    }

	@Override
	public void onClick(View arg0) {
		try {
			String urlStr="http://tv01.search.naver.net/thumbnails?q=http://cafefiles.naver.net/20101230_89/ejtkfk123_129370415897673LQH_jpg/eca084ed9aa8ec84b11_ejtkfk123.jpg";
			URL url=new URL(urlStr);
			InputStream in=url.openStream();
			Bitmap bitmap=BitmapFactory.decodeStream(in);
			ImageView iv=(ImageView)findViewById(R.id.imageView1);
			iv.setImageBitmap(bitmap);
			FileOutputStream fout=new FileOutputStream("/sdcard/kkh_"+System.currentTimeMillis()+".jpg");
			bitmap.compress(CompressFormat.JPEG,100,fout);		
		
		
		} catch (Exception e) {
		Toast.makeText(getApplicationContext(),"error"+e.getMessage(),3000).show();
		
		}
		
	}
}