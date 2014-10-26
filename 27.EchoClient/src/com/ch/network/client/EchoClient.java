package com.ch.network.client;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EchoClient extends Activity {
    /** Called when the activity is first created. */
    TextView resultTV;
    EditText sendET;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_socket);
        Button sendB=(Button)findViewById(R.id.socket_button);
        resultTV=(TextView)findViewById(R.id.socket_output);
        sendET=(EditText)findViewById(R.id.socket_input);
        sendB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				resultTV.setText("");
				String sendData=sendET.getText().toString();
				String output=callSocket(sendData);
				resultTV.setText(output);
			}

			
		});
        
    }
	private String callSocket(String sendData) {
		Socket socket=null;
		BufferedReader reader=null;
		BufferedWriter writer=null;
		String readLine="";
		try{
			socket=new Socket("211.183.3.121",8889);
			writer = 
				new BufferedWriter(
						new OutputStreamWriter(
								socket.getOutputStream()));
			reader=
				new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
			writer.write(sendData+"\n",0,sendData.length()+1);
			writer.flush();
			readLine=reader.readLine();
			writer.write("EXIT\n",0,5);
			writer.flush();
		}catch(Exception e){
		}finally{
			try {
				writer.close();
				reader.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return readLine;
		
	}
}