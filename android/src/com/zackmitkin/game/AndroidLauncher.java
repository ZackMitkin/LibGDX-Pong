package com.zackmitkin.game;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.zackmitkin.game.main;

import static android.view.WindowManager.*;

public class AndroidLauncher extends AndroidApplication {

	View v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = null;
		config = new AndroidApplicationConfiguration();
		initialize(new main(), config);

		FullScreencall();
	}

	public void FullScreencall() {
		if (Build.VERSION.SDK_INT < 19) {
			v = this.getWindow().getDecorView();
			v.setSystemUiVisibility(View.GONE);
		} else {
			//for lower api versions.
			View decorView = getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}
}
