package com.choongang.xml.dom;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HttpXMLDOMParsingActivity extends Activity {
	/** Called when the activity is first created. */
	ArrayList<Forecast> forecastList=new ArrayList<Forecast>();
	WeatherListAdapter adapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ListView weatherList=(ListView)findViewById(R.id.weatherList);
		adapter=new WeatherListAdapter();
		weatherList.setAdapter(adapter);
		new Thread(){
			@Override
			public void run() {
				updateForecast();
			}
		}.start();
		showProgressBar();

	}
	private void showProgressBar(){
		RelativeLayout progress_layout=(RelativeLayout)findViewById(R.id.rlayout_progress);
		ListView list_view=(ListView)findViewById(R.id.weatherList);
		
		progress_layout.setVisibility(View.VISIBLE);
		list_view.setVisibility(View.GONE);
		
	}
	private void showListView(){
		RelativeLayout progress_layout=(RelativeLayout)findViewById(R.id.rlayout_progress);
		ListView list_view=(ListView)findViewById(R.id.weatherList);
		
		progress_layout.setVisibility(View.GONE);
		list_view.setVisibility(View.VISIBLE);
	}
	
	
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case SUCCESS_UPDATE:
				Forecast forecast=(Forecast)msg.obj;
				forecastList.add(forecast);
				adapter.notifyDataSetChanged();
				if(forecastList.size()==1){
					showListView();
				}
				break;

			case FAIL_UPDATE:
				Exception e=(Exception)msg.obj;
				Toast.makeText(getApplicationContext(),
						"DOM Parsing Error!!"+e.getMessage(),
						5000).show();	
				break;
			}
		};
	};
	public static final int SUCCESS_UPDATE=0;
	public static final int FAIL_UPDATE=1;
	private void updateForecast() {
		try {
			String urlStr="http://www.google.com/ig/api?hl=ko&weather=jeju";
			URL url=new URL(urlStr);
			InputStream in=url.openStream();
/*************CASE1 ForecastList*******************/			
//			forecastList=buildForecast(in);
//			Message msg=new Message();
//			msg.what=SUCCESS_UPDATE;
//			handler.sendMessage(msg);
/*************CASE2 Forecast**********************/			
			buildForecast(in);
			
			
		} catch (Exception e) {
			Message msg=new Message();
			msg.what=FAIL_UPDATE;
			msg.obj=e;
			handler.sendMessage(msg);


		}


	}
	/*
<?xml version="1.0"  encoding="euc-kr"?> 
<xml_api_reply version="1">
	 <weather module_id="0" tab_id="0" mobile_row="0" mobile_zipped="1" row="0" section="0">
		 <forecast_information/>
		 <current_conditions/>
	     <forecast_conditions>
			  <day_of_week data="목" /> 
			  <low data="-12" /> 
			  <high data="-4" /> 
			  <icon data="/ig/images/weather/partly_cloudy.gif" /> 
			  <condition data="부분적으로 흐림" /> 
		 </forecast_conditions>
		 <forecast_conditions/>
		 <forecast_conditions/>
		 <forecast_conditions/>

	  </weather>
</xml_api_reply> 
	 */
	//DOM Parsing
	private ArrayList<Forecast> buildForecast(InputStream in) throws Exception {
		ArrayList<Forecast> forecastList=new ArrayList<Forecast>();

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder domParser=factory.newDocumentBuilder();
		//DOM TREE
		InputStreamReader isr=new InputStreamReader(in,"euc-kr");
		InputSource source=new InputSource(isr);
		Document doc=domParser.parse(source);

		NodeList forecast_conditionsNL= 
			doc.getElementsByTagName("forecast_conditions");
		for(int i=0;i<forecast_conditionsNL.getLength();i++){

			Element forecast_conditionsE=
				(Element)forecast_conditionsNL.item(i);
			/*
			<forecast_conditions>
				  <day_of_week data="목" /> 
				  <low data="-12" /> 
				  <high data="-4" /> 
				  <icon data="/ig/images/weather/partly_cloudy.gif" /> 
				  <condition data="부분적으로 흐림" /> 
		     </forecast_conditions> 
			 */
			Element day_of_weekE=
				(Element)forecast_conditionsE.getElementsByTagName("day_of_week").item(0);
			Element lowE=
				(Element)forecast_conditionsE.getElementsByTagName("low").item(0);
			Element highE=
				(Element)forecast_conditionsE.getElementsByTagName("high").item(0);
			Element iconE=
				(Element)forecast_conditionsE.getElementsByTagName("icon").item(0);
			Element conditionE=
				(Element)forecast_conditionsE.getElementsByTagName("condition").item(0);

			String day_of_weekStr=day_of_weekE.getAttribute("data");
			String lowStr=lowE.getAttribute("data");
			String highStr=highE.getAttribute("data");
			String iconStr=iconE.getAttribute("data");
			String conditionStr=conditionE.getAttribute("data");

			Forecast forecast=new Forecast();
			forecast.condition=conditionStr;
			forecast.day_of_week=day_of_weekStr;
			forecast.high=highStr;
			forecast.low=lowStr;
			forecast.icon=iconStr;
			/////////image  decoding////////////
			URL imageURL=new URL("http://www.google.com/"+forecast.icon);
			InputStream imageIn=imageURL.openStream();
			Bitmap iconBitmap=BitmapFactory.decodeStream(imageIn);
			forecast.iconBitmap=iconBitmap;
			//////////////////////////////////
			/*************CASE2 Forecast**********************/	
			Message msg=new Message();
			msg.what=SUCCESS_UPDATE;
			msg.obj=forecast;
			handler.sendMessage(msg);
			
			forecastList.add(forecast);
		}//end for
		return forecastList;
	}//end method
	/********Forecast inner class***********/
	class Forecast{
		String day_of_week;
		String low;
		String high;
		String icon;
		String condition;
		Bitmap iconBitmap;
	}
	/***************************************/
	/************WeatherListAdapter*********/
	class WeatherListAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return forecastList.size();
		}

		@Override
		public Forecast getItem(int position) {
			// TODO Auto-generated method stub
			return forecastList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = getLayoutInflater();
			View view=inflater.inflate(R.layout.list_item, null);

			Forecast forecast=getItem(position);

			ImageView iconIV=(ImageView)view.findViewById(R.id.icon);
			TextView lowTV=(TextView)view.findViewById(R.id.low);
			TextView highTV=(TextView)view.findViewById(R.id.high);
			TextView day_of_weekTV=(TextView)view.findViewById(R.id.day_of_week);
			TextView conditionTV=(TextView)view.findViewById(R.id.condition);

			//icon set
			iconIV.setImageBitmap(forecast.iconBitmap);
			lowTV.setText(forecast.low);
			highTV.setText(forecast.high);
			conditionTV.setText(forecast.condition);
			day_of_weekTV.setText(forecast.day_of_week);

			return view;
		}

	}
	/***************************************/
}




