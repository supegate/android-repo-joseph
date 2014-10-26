package com.choongang.adapter.gallery;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
public class GalleryDemoActivity extends Activity {
	/** Called when the activity is first created. */

	String[] urlStr=
	{
			"http://farm5.static.flickr.com/4126/4965796746_a9b9d6dd37_m.jpg",
			"http://farm5.static.flickr.com/4092/4965791092_040eae65a3_m.jpg",
			"http://farm5.static.flickr.com/4109/4965186539_e313f80ef1_m.jpg",
			"http://farm5.static.flickr.com/4128/4965175117_829514017e_m.jpg",
			"http://farm5.static.flickr.com/4150/4965167731_d1b7b47418_m.jpg",
			"http://farm5.static.flickr.com/4083/4965761742_59b3b9621d_m.jpg",
			"http://farm5.static.flickr.com/4128/4965160273_96f989e0a9_m.jpg",
			"http://farm5.static.flickr.com/4130/4965758684_53d9051d2e_m.jpg",
			"http://farm5.static.flickr.com/4112/4965756408_d600625eb8_m.jpg",
			"http://farm5.static.flickr.com/4145/4965754228_7c5391f312_m.jpg",
			"http://farm5.static.flickr.com/4087/4965750326_3e1f2f6bf4_m.jpg"
	};

	ArrayList<Bitmap> bitmapImages=new ArrayList<Bitmap>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Gallery gallery=(Gallery)findViewById(R.id.gallery1);

		gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				ImageView iv=(ImageView)findViewById(R.id.imageView1);
				iv.setImageBitmap(bitmapImages.get(position));
			}
		});
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		//SDCARD FILE-->Bitmap-->ImageView
		FileInputStream fin=null;
		try {
			fin = new FileInputStream("/sdcard/bt_bg.gif");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bitmap b=BitmapFactory.decodeStream(fin);
		iv.setImageBitmap(b);

		//image decoding
		GetImageThread t=new GetImageThread();
		t.start();
		gallery.setAdapter(new GalleryAdapter());
	}
	Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case UPDATE_IMAGE:
				
				break;

			case IMAGE_LOAD_ERROR:
				
				break;
			}
		};
	};
	public static final int UPDATE_IMAGE=0;
	public static final int IMAGE_LOAD_ERROR=1;
	/*********Thread inner class****************/
	class GetImageThread extends Thread{
		@Override
		public void run() {
			try{
				for(int i=0;i<urlStr.length;i++){
				bitmapImages.add(BitmapFactory.decodeStream
						(new URL(urlStr[i]).openStream()));
				}
				Message msg=new Message();
				msg.what=UPDATE_IMAGE;
				handler.sendMessage(msg);
			}catch (Exception e) {
				Message msg=new Message();
				msg.what=IMAGE_LOAD_ERROR;
				handler.sendMessage(msg);
			}

		}
	} 
	/*******************************************/

	class GalleryAdapter extends BaseAdapter{
		int itemBackground;
		public GalleryAdapter() {
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
			itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return bitmapImages.size();
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView iv=new ImageView(getApplicationContext());
			iv.setImageBitmap(bitmapImages.get(position));
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(100, 80));
			iv.setBackgroundResource(itemBackground);
			return iv;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

	}



}