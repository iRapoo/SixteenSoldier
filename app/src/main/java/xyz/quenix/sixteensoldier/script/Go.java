package xyz.quenix.sixteensoldier.script;

import xyz.quenix.sixteensoldier.ActivityGame;
import xyz.quenix.sixteensoldier.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class Go extends ActivityGame {

	public static void start(View[] arr){
		for(int i = 0; i < arr.length; i++){
			if(i < 16){
				((ImageView) arr[i]).setImageResource(R.drawable.black_unit);
				((ImageView) arr[i]).setTag("2");
				}
			if(i > 15){
				((ImageView) arr[i]).setImageResource(R.drawable.white_unit);
				((ImageView) arr[i]).setTag("1");
				}
			}
	}
	
	public static void move(Context context, View id, View[] arr){
		
		int id_num = Integer.valueOf((String) id.getContentDescription());
		
		/*������� �����*/
 	   for(int i = 0; i < 49; i++){
 		   unit_clear = (ImageView) ((ActivityGame) context).findViewById(Object.list(i));
 		   unit_selected = (ImageView) ((ActivityGame) context).findViewById(Object.list(id_num-1));
 		   if((unit_clear.getTag() == "0" || unit_clear.getTag() == "4") && unit_selected.getTag() == action){
 			   unit_clear.setImageResource(0);
 			   unit_clear.setTag("");		    			  
 		   }
 		  if(unit_clear.getTag() == "3"){
 			 unit_clear.animate().alpha((float) 1);
   		 }
 	   }
 	   //--------------*/
		
		if(id.getTag() == action){
			for(int i = 0; i < arr.length; i++){
				if(arr[i].getTag() != "1" && arr[i].getTag() != "2" && arr[i].getTag() != "3"){
					
					if(action == choice  || two_user == 1)
						((ImageView) arr[i]).setImageResource(R.drawable.temp_unit);
					
					((ImageView) arr[i]).setTag("0");
				}
				if(arr[i].getTag() != action && arr[i].getTag() != "0"){
					String unitCont = (String) arr[i].getContentDescription();
					
					int[] new_unit = Object.unit(Integer.valueOf(unitCont)-1);

					ImageView unit_active;
					ImageView unit_active2;
					for(int q = 0; q < new_unit.length; q++){
						unit_active = (ImageView) ((ActivityGame) context).findViewById(new_unit[q]);
						if(new_unit.length != 3 && q != 3)
						if(unit_active == id && new_unit.length > 2 && unit_active.getContentDescription() != "8" && unit_active.getContentDescription() != "12" && unit_active.getContentDescription() != "38" && unit_active.getContentDescription() != "42"){
							int active = (q+1);
							int fight_access = active % 2;
								active = (fight_access == 0) ? active-1 : active+1;
								unit_active2 = (ImageView) ((ActivityGame) context).findViewById(new_unit[active-1]);
									if(unit_active2.getTag() == "" || unit_active2.getTag() == null){
										if(action == choice || two_user == 1)
											((ImageView) unit_active2).setImageResource(R.drawable.fight_unit);
										((ImageView) unit_active2).setTag("4");
											Storage.saveData(context, "active", id.getContentDescription()+"");
											Storage.saveData(context, "fight", arr[i].getContentDescription()+"");
									}
									unit_active2 = null;
						}
						unit_active = null;
					}
				}
			}
			id.setTag("3");
			
				if(action == choice || two_user == 1)
					id.animate().alpha((float) 0.6);				
		}
		if(id.getTag() == "0"){
			for(int i = 0; i < arr.length; i++){
				if(arr[i].getTag() == "3" && arr[i].getTag() != action){
					((ImageView) arr[i]).setImageResource(0);
					((ImageView) arr[i]).setTag("");
					
						if(action == choice || two_user == 1){
							arr[i].setAlpha((float) 1);
							id.setAlpha((float) 0.6);
							id.animate().alpha((float) 1);
						}
					
					((ImageView) id).setImageResource((action == "2") ? R.drawable.black_unit : R.drawable.white_unit );
					((ImageView) id).setTag(action);
						action = (action == "2") ? "1" : "2";
				} 
				if(arr[i].getTag() == "0" && arr[i].getTag() != action){
					((ImageView) arr[i]).setImageResource(0);
					((ImageView) arr[i]).setTag("");
				}
			}
		}
		if(id.getTag() == "4"){
			int active = Integer.valueOf(Storage.loadData(context, "active"));
			int fight = Integer.valueOf(Storage.loadData(context, "fight"));
			
			ImageView active_unit = (ImageView) ((ActivityGame) context).findViewById(Object.list(active-1));
			
			((ImageView) active_unit).setImageResource(0);
			((ImageView) active_unit).setTag("");
			
			ImageView fight_unit = (ImageView) ((ActivityGame) context).findViewById(Object.list(fight-1));
			
			((ImageView) fight_unit).setImageResource(0);
			((ImageView) fight_unit).setTag("");
			
			if(action == choice || two_user == 1){
				((ImageView) active_unit).setAlpha((float) 1);
				id.setAlpha((float) 0.6);
				id.animate().alpha((float) 1);
			}
			
			score(action, context);
			
			((ImageView) id).setImageResource((action == "2") ? R.drawable.black_unit : R.drawable.white_unit );
			((ImageView) id).setTag(action);
				action = (action == "2") ? "1" : "2";
		}
	}
}
