package xyz.quenix.sixteensoldier;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

@SuppressLint("NewApi")
public class ActivityStart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		//На весь экран//
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
						WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		//************//
		//Мигание текста
		final ImageView alert_on_press = (ImageView) findViewById(R.id.alert_on_press);

		Timer myTimer = new Timer(); // Создаем таймер
		final Handler uiHandler = new Handler();
		myTimer.schedule(new TimerTask() { // Определяем задачу
			@Override
			public void run() {
				uiHandler.post(new Runnable() {
					@Override
					public void run() {
						if(alert_on_press.getVisibility() == View.GONE)
							alert_on_press.setVisibility(View.VISIBLE);
						else alert_on_press.setVisibility(View.GONE);
					}
				});
			}
		}, 0L, 1L * 1000); // интервал - 1000 миллисекунд, 0 миллисекунд до первого запуска.
		//**********//
		final Button onTouchToStart = (Button) findViewById(R.id.onTouchToStart);
		onTouchToStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityStart.this, ActivityGame.class);
				startActivity(intent);
			}
		});
	}
}
