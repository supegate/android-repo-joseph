package com.choongang.xml.sax;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HttpXMLSAXParsingActivity extends Activity {
    /** Called when the activity is first created. */
    ArrayList<Rank> rankList=new ArrayList<Rank>();
    RankAdapter adapter;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        updateRanking();
        adapter=new RankAdapter();
        ListView listView=(ListView)findViewById(R.id.rankList);
        listView.setAdapter(adapter);
    }
	private void updateRanking() {
		try{
			String urlStr="http://openapi.naver.com/search?key=38d29197789e1b4ee30924dfedec02e6&target=rank&query=nexearch";
			URL url=new URL(urlStr);
			InputStream in=url.openStream();
			buildRanking(in);
			
		}catch (Exception e) {
			
		}
		
	}
	/*
<?xml version="1.0" encoding="UTF-8" ?> 
<result>
	<item>
		<R1>
			<K>예금보험공사</K> 
			<S>+</S> 
			<V>138</V> 
		</R1>
		...
		<R10>
			<K>로열패밀리</K> 
			<S>+</S> 
			<V>99</V> 
		</R10>
	</item>
</result>
	*/
	private void buildRanking(InputStream in)throws Exception {
		//SAX Parsing
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		RankHandler dh=new RankHandler();
		parser.parse(in, dh);
		rankList = dh.rankList;
//		Toast.makeText(getApplicationContext(),
//				dh.rankList+"", 3000).show();
		
	}
	/*********SAX Handler inner class*************/
	class RankHandler extends DefaultHandler{
		ArrayList<Rank> rankList;
		Rank  rank;
		boolean Kflag=false;
		boolean Sflag=false;
		boolean Vflag=false;
		public RankHandler() {
			rankList=new ArrayList<Rank>();
		}
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if(localName.equals("K")){
				Kflag=true;
				rank=new Rank();
			}else if(localName.equals("S")){
				Sflag=true;
			}else if(localName.equals("V")){
				Vflag=true;
			}
		}
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if(Kflag){
				rank.K=new String(ch,start,length);
			}else if(Sflag){
				rank.S=new String(ch,start,length);
			}else if(Vflag){
				rank.V=new String(ch,start,length);
			}
		}
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if(localName.equals("K")){
				Kflag=false;
			}else if(localName.equals("S")){
				Sflag=false;
			}else if(localName.equals("V")){
				rankList.add(rank);
				Vflag=false;
			}
		}
		public void endDocument() throws SAXException {}
		public void startDocument() throws SAXException {}
	}
	/*********************************************/
	/***********Rank inner class******************/
	class Rank{
		String K;
		String S;
		String V;
	}
	/*********************************************/
	/***********RankAdapter inner class***********/
	class RankAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return rankList.size();
		}

		@Override
		public Rank getItem(int position) {
			// TODO Auto-generated method stub
			return rankList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();
			View view=inflater.inflate(R.layout.row, null);
			
			TextView noTV=(TextView)view.findViewById(R.id.no);
			TextView kTV=(TextView)view.findViewById(R.id.k);
			TextView sTV=(TextView)view.findViewById(R.id.s);
			TextView vTV=(TextView)view.findViewById(R.id.v);
			
			Rank rank=getItem(position);
			
			noTV.setText((position+1)+"");
			kTV.setText(rank.K);
			sTV.setText(rank.S);
			vTV.setText(rank.V);
			return view;
		}
		
	}
	/*********************************************/
}








