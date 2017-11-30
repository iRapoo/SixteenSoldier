package xyz.quenix.sixteensoldier;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.quenix.sixteensoldier.script.Go;
import xyz.quenix.sixteensoldier.script.Object;
import xyz.quenix.sixteensoldier.script.Storage;
import xyz.quenix.sixteensoldier.script.Windows;

@SuppressLint("NewApi")
public class ActivityGame extends Activity {

	ImageView START[] = new ImageView[32];
	ImageView Buttons;
	protected static ImageView unit_clear;
	protected static ImageView unit_selected;
	ImageView ImageArr[];
	public static String choice = "1";
	public static String action = choice;
	public static int UnitNum;
	public ImageView UnitObj;
	Context context = this;
	private final int SELECT_SIDE= 0;
	public static int action_bot;
	static int top_score = 0;
	static int bottom_score = 0;
	protected static int two_user = 0;
	
	TextView top_step;
	TextView bottom_step;
	static TextView score_top;
	static TextView score_bottom;
	
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_game);
		//На весь экран//
	  	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | 
	  			WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,	
	  			WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	  	//************//
	  	
	  	top_step = (TextView) findViewById(R.id.top_step);
	  	bottom_step = (TextView) findViewById(R.id.bottom_step);
	  	
	  	/*Выбор за кого играть*/
	  	showDialog(SELECT_SIDE); 
	  	//*********************/

		//Расстановка фигур START (Площадка: 2 игрока)
	  	for(int i = 0; i < 32; i++){
	  			START[i] = (i < 16) ? (ImageView) findViewById(Object.black(i)) : (ImageView) findViewById(Object.white(i-16));
	  		}
	  	Go.start(START);
	  	//********************//

		//Определение на какую кнопку нажали//
		OnClickListener OnTouch = new OnClickListener() {
		       @Override
		       public void onClick(View image) {
		    	   if(action == choice || two_user == 1){

					   UnitObj = (ImageView) findViewById(image.getId());
					   UnitNum = (Integer.parseInt(UnitObj.getContentDescription()+"")-1);
					   ImageArr = new ImageView[Object.unit(UnitNum).length];
					   for(int i = 0; i < Object.unit(UnitNum).length; i++)
						   ImageArr[i] = (ImageView) findViewById(Object.unit(UnitNum)[i]);
					   Go.move(context, (ImageView) findViewById(Object.list(UnitNum)), ImageArr);
		    	   
		    	   //test.setText((CharSequence) findViewById(Object.list(0)).getContentDescription());
		    	   /*Инициализация бота*/
		    	    Handler handler = new Handler(); 
		    	    handler.postDelayed(new Runnable() { 
		    	         public void run() { 
		    	        	 AI();
		    	         } 
		    	    }, 1000);
		    	   /************/
		    		   
		    		   if(action == "2"){
		    			   	top_step.animate().alpha((float) 1);
                       		bottom_step.animate().alpha((float) 0);
		    		   }else{
		    			    top_step.animate().alpha((float) 0);
                      		bottom_step.animate().alpha((float) 1);
		    		   }
		    	  }
		       }
		};
		for(int i = 0; i <= 48; i++){
			Buttons = (ImageView) findViewById(Object.list(i));
			Buttons.setOnClickListener(OnTouch); }
		//**********************************//

	  }

	/*Бот*/
	public void AI(){
		do{
			if(action != choice && two_user != 1){
		action_bot = 0 + (int)(Math.random() * ((48 - 0) + 1));
		UnitNum = action_bot;
		ImageArr = new ImageView[Object.unit(UnitNum).length];
		   for(int i = 0; i < Object.unit(UnitNum).length; i++)
			   	ImageArr[i] = (ImageView) findViewById(Object.unit(UnitNum)[i]);
		   Go.move(context, (ImageView) findViewById(Object.list(UnitNum)), ImageArr);
		   
		   for(int i = 0; i < 49; i++){
	    		unit_clear = (ImageView) findViewById(Object.list(i));
	    		unit_selected = (ImageView) findViewById(Object.list(UnitNum));
	    		if(unit_clear.getTag() == "0" && unit_selected.getTag() == action){
	    			unit_clear.setImageResource(0);
	    			unit_clear.setTag("");
	    		}
	    		if(unit_clear.getTag() == "3" && i != UnitNum){
	    		   ((ImageView) unit_clear).setTag(action);
	    		}
	    	}
		}
		}while(action != choice && two_user != 1);
		
		
	}
	/*****/

	//Счет
  	public static void score(String active, Context context){
  		score_top = (TextView) ((ActivityGame) context).findViewById(R.id.score_top);
	  	score_bottom = (TextView) ((ActivityGame) context).findViewById(R.id.score_bottom);
  		
  		if(active == "2"){
  			top_score = top_score+1;
  			score_top.setText("Счет: "+top_score);
  			if(top_score >= 16)
				Windows.alert(context, "Победа", "Победил СИНИЙ игрок!");
  		}else{
  			bottom_score = bottom_score+1;
  			score_bottom.setText("Счет: "+bottom_score);
  			if(bottom_score >= 16)
				Windows.alert(context, "Победа", "Победил Желтый игрок!");
  		}
  	} 
  	//****//

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(ActivityGame.this);
		builder.setTitle("Выйти из приложения?")
				.setMessage("Вы действительно хотите выйти?")
				//.setIcon(R.drawable.ic_android_cat)
				.setCancelable(false)
				.setNegativeButton("Нет", null)
				.setPositiveButton("Да",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								ActivityGame.super.onBackPressed();
								moveTaskToBack(true);
								ActivityGame.super.onBackPressed();
								//System.runFinalizersOnExit(true);
								System.exit(0);
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}
		
	@Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case SELECT_SIDE:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Какими фигурками хотите играть?")
                    .setCancelable(false)
                    .setPositiveButton("Синие",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                	choice = "2";
                                	action = choice;
                                	top_step.animate().alpha((float) 1);
                                	bottom_step.animate().alpha((float) 0);
                                    dialog.cancel();
                                }
                            })
                    .setNegativeButton("Желтые",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                	choice = "1";
                                	action = choice;
                                	bottom_step.animate().alpha((float) 1);
                                	top_step.animate().alpha((float) 0);
                                    dialog.cancel();
                                }
                            });
            
            return builder.create();
        default:
            return null;
        }
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_start, menu);
        return super.onCreateOptionsMenu(menu);
    }
	
	 @Override
     public boolean onOptionsItemSelected(MenuItem item) {
     	super.onOptionsItemSelected(item);

		 AbsoluteLayout top_layout = (AbsoluteLayout) findViewById(R.id.top_layout);
     	
     	switch (item.getItemId()) {
     	case R.id.two_users:
     			two_user = 1;
				Windows.alert(context, "", "Включен режим игры на двоих");
				top_layout.animate().rotation(180);
 			return true;
     	case R.id.restart:
     			two_user = 0;
     			top_score = 0;
     			bottom_score = 0;
     			Intent intent = new Intent(ActivityGame.this, ActivityStart.class);
     			startActivity(intent);
     		return true;
         default:
             return super.onOptionsItemSelected(item);
     	}
    }
}
