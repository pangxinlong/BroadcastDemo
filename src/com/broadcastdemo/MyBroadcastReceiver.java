package com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	private static final String STATIC = "staic";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if (action.equals(STATIC)) {
			Log.e("MainActivity", "接收自定义静态注册广播消息");
			Toast.makeText(context, "静态接收", Toast.LENGTH_SHORT).show();
		}
	}
}