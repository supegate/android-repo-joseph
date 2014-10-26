package com.choongang.view.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDemoActivity extends Activity {
	/** Called when the activity is first created. */
	WebView webview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		webview=(WebView)findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);
		//        String HTMLDATA="<HTML>" +
		//        		"<BODY>" +
		//        		"<A HREF='HTTP://WWW.CHOONGANG.CO.KR'>" +
		//        		"<IMG SRC='HTTP://STATIC.NAVER.COM/WWW/U/2010/0611/NMMS_215646753.GIF'/>" +
		//        		"</A><BR/>" +
		//        		"<A HREF='HTTP://WWW.DAUM.NET'>¥Ÿ¿Ωø°∫¡ø‰</A></B>"+
		//        		"</BODY></HTML>";
		//webview.loadDataWithBaseURL("",htmlData, "text/html", "utf-8",null);
		webview.loadUrl("http://m.aladin.co.kr");
		webview.setWebViewClient(new SubwebClient());
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode ==KeyEvent.KEYCODE_BACK && webview.canGoBack());
		return super.onKeyDown(keyCode, event);
	}
	private class SubwebClient extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}
	}



}
