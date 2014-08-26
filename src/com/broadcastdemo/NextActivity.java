package com.broadcastdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NextActivity extends Activity {

	private static final String My_TEST = "mytest";
	private static final String STATIC = "staic";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_next);

		Button dynamischeB = (Button) findViewById(R.id.dynamischeSend);
		Button staticSendB = (Button) findViewById(R.id.staticSend);

		dynamischeB.setOnClickListener(new MyOnClickListerner());
		staticSendB.setOnClickListener(new MyOnClickListerner());
	}

	class MyOnClickListerner implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.dynamischeSend:
				inToManiDynamische();
				break;
			case R.id.staticSend:
				inToMainStatic();
				break;
			}

		}

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	public void inToManiDynamische() {
		Intent intent = new Intent();
		intent.setAction(My_TEST);
		intent.putExtra("mge", "动态接收广播");
		sendBroadcast(intent);
		intent.setClass(this, MainActivity.class);
		this.startActivity(intent);
	}

	public void inToMainStatic() {
		Intent intent = new Intent();
		intent.setAction(STATIC);
		intent.putExtra("mge", "静态接收广播");
		sendBroadcast(intent);
		intent.setClass(this, MainActivity.class);
		this.startActivity(intent);
	}
}
