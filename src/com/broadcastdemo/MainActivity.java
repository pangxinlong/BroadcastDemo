package com.broadcastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView text;

	private static final String My_TEST = "mytest";
	private static final String STATIC="staic";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button send = (Button) findViewById(R.id.next);
		text = (TextView) findViewById(R.id.text);
		// text.setText("This is MainActivity!");

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inToNextActivity();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		IntentFilter intentfilter = new IntentFilter();
		intentfilter.addAction(My_TEST);
		registerReceiver(dynamicReceiver, intentfilter);

	}

	private BroadcastReceiver dynamicReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {	
			if (intent.getAction().equals(My_TEST)) {
				Log.e("MainActivity", "接收自定义动态注册广播消息");
				String msg = intent.getStringExtra("mge");
			//	text.setText("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
			}

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void inToNextActivity() {
		Intent intent = new Intent();
		intent.setClass(this, NextActivity.class);
		this.startActivity(intent);
	}

}
