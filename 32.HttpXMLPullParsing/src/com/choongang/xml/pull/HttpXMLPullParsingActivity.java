package com.choongang.xml.pull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

public class HttpXMLPullParsingActivity extends Activity {
    /** Called when the activity is first created. */
    ArrayList<FlickrEntry> flickrEntryList=new ArrayList<FlickrEntry>();
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        updateFlickrEntry();
    }
    /*
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<feed xmlns="http://www.w3.org/2005/Atom">
	  <title>Uploads from perlgurl.org</title>
	  <link rel="self" href="http://api.flickr.com/services/feeds/photos_public.gne?id=26648248@N04&amp;" />
	  <link rel="alternate" type="text/html" href="http://www.flickr.com/photos/perlgurl/"/>
	  <id>tag:flickr.com,2005:/photos/public/26616109</id>
	  <icon>http://farm4.static.flickr.com/3218/buddyicons/26648248@N04.jpg?1210968422#26648248@N04</icon>
	  <subtitle></subtitle>
	  <updated>2010-09-06T23:09:48Z</updated>
	  <generator uri="http://www.flickr.com/">Flickr</generator>
	
	  <entry>
		    <title>Lakes of the Clouds</title>
		    <link rel="alternate" type="text/html" href="http://www.flickr.com/photos/perlgurl/4965796746/"/>
		    <id>tag:flickr.com,2005:/photo/4965796746</id>
		    <published>2010-09-06T23:09:48Z</published>
		    <updated>2010-09-06T23:09:48Z</updated>
		    <dc:date.Taken>2010-09-03T08:05:05-08:00</dc:date.Taken>
		    <content type="html"/>
		    <author/>
		    <link rel="enclosure" type="image/jpeg" href="http://farm5.static.flickr.com/4126/4965796746_a9b9d6dd37_m.jpg" />
		    <category term="mountain" scheme="http://www.flickr.com/photos/tags/" />
	    	.....
	  </entry>
 ....
</feed> 
     */
	private void updateFlickrEntry() {
		try{
			String urlStr=
				"http://api.flickr.com/services/feeds/photos_public.gne?id=26648248@N04&amp";
			URL url=new URL(urlStr);
			InputStream in=url.openStream();
			this.flickrEntryList=buildFlickrEntry(in);
			
		}catch (Exception e) {
			Log.d("PULLLLLLLLLL", e.getMessage());
		}
		
		
	}
	private ArrayList<FlickrEntry> buildFlickrEntry(InputStream in) throws Exception{
		//XML PullParsing
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser=factory.newPullParser();
		parser.setInput(new InputStreamReader(in));
		
		
		
		int eventType=parser.next();
		/*********eventType*********
		XmlPullParser.START_DOCUMENT
		XmlPullParser.START_TAG
		XmlPullParser.END_TAG
		XmlPullParser.TEXT
		XmlPullParser.END_DOCUMENT
		****************************/
		ArrayList<FlickrEntry> flickrEntryList=new ArrayList<FlickrEntry>();
		boolean entryFlag=false;
		FlickrEntry flickrEntry=null;
		String currentText="";
		
		while(eventType!=XmlPullParser.END_DOCUMENT){
			switch (eventType) {
		
			case XmlPullParser.START_TAG:
				if(parser.getName().equals("entry")){
					entryFlag=true;
					flickrEntry=new FlickrEntry();
				}
				if(parser.getName().equals("link")){
					String relStr = parser.getAttributeValue(null, "rel");
					if(relStr==null)relStr="";
					if(relStr.equals("enclosure")){
						String typeStr = parser.getAttributeValue(null, "type");
						if(typeStr==null)typeStr="";
						if(typeStr.startsWith("image/")){
							String imageURL=parser.getAttributeValue(null, "href");
							flickrEntry.imageURL=imageURL;
							Log.d("imageURL:",imageURL);
							//image decoding(bug)
							flickrEntry.imageBitmap = 
								BitmapFactory.decodeStream(new URL(imageURL).openStream());
							
						}
						
					}
				}
				break;
			case XmlPullParser.END_TAG:
				if(parser.getName().equals("entry")){
					entryFlag=false;
					flickrEntryList.add(flickrEntry);
				}
				if(parser.getName().equals("title")&& entryFlag){
					flickrEntry.title=currentText;
					Log.d("TITLE", currentText);
				}
				break;
			case XmlPullParser.TEXT:
				currentText=parser.getText();
				break;
			case XmlPullParser.START_DOCUMENT:
				break;
			case XmlPullParser.END_DOCUMENT:
				break;
			}
			eventType=parser.next();
		}		
		
		
		
		return flickrEntryList;
	}
	class FlickrEntry{
		String title;
		String imageURL;
		Bitmap imageBitmap;
	}
}












