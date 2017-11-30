package xyz.quenix.sixteensoldier.script;

import xyz.quenix.sixteensoldier.R;

public class Object {
	
	public static int list(int value){
		int list[] = {
				R.id.unit_1, R.id.unit_2,R.id.unit_3,R.id.unit_4,R.id.unit_5,R.id.unit_6,R.id.unit_7,R.id.unit_8,
				R.id.unit_9,R.id.unit_10,R.id.unit_11,R.id.unit_12,R.id.unit_13,R.id.unit_14,R.id.unit_15,R.id.unit_16,
				R.id.unit_17,R.id.unit_18,R.id.unit_19,R.id.unit_20,R.id.unit_21,R.id.unit_22,R.id.unit_23,R.id.unit_24,
				R.id.unit_25,R.id.unit_26,R.id.unit_27,R.id.unit_28,R.id.unit_29,R.id.unit_30,R.id.unit_31,R.id.unit_32,
				R.id.unit_33,R.id.unit_34,R.id.unit_35,R.id.unit_36,R.id.unit_37,R.id.unit_38,R.id.unit_39,R.id.unit_40,
				R.id.unit_41,R.id.unit_42,R.id.unit_43,R.id.unit_44,R.id.unit_45,R.id.unit_46,R.id.unit_47,R.id.unit_48,
				R.id.unit_49
			};
		
		return list[value];
	}
	
	public static int black(int value){
		int list[] = {
				R.id.unit_1,R.id.unit_2,R.id.unit_3,R.id.unit_4,R.id.unit_5,R.id.unit_6,R.id.unit_8,R.id.unit_9,
				R.id.unit_10,R.id.unit_11,R.id.unit_12,R.id.unit_15,R.id.unit_16,R.id.unit_17,R.id.unit_18,R.id.unit_19
			};
		
		return list[value];
	}
	
	public static int white(int value){
		int list[] = {
				R.id.unit_31,R.id.unit_32,R.id.unit_33,R.id.unit_34,R.id.unit_35,R.id.unit_38,R.id.unit_39,R.id.unit_40,
				R.id.unit_41,R.id.unit_42,R.id.unit_44,R.id.unit_45,R.id.unit_46,R.id.unit_47,R.id.unit_48,R.id.unit_49
			};
		
		return list[value];
	}
	
	public static int[] unit(int value){
		int unit_1[] = {
				R.id.unit_2,R.id.unit_4
		};
		int unit_2[] = {
				R.id.unit_1,R.id.unit_3,R.id.unit_5
		};
		int unit_3[] = {
				R.id.unit_2,R.id.unit_6
		};
		int unit_4[] = {
				R.id.unit_10,R.id.unit_1,R.id.unit_5
		};
		int unit_5[] = {
				R.id.unit_4,R.id.unit_6,R.id.unit_10,R.id.unit_2
		};
		int unit_6[] = {
				R.id.unit_3,R.id.unit_10,R.id.unit_5
		};
		int unit_7[] = {
				R.id.unit_14,R.id.unit_21
		};
		int unit_8[] = {
				R.id.unit_9,R.id.unit_16,R.id.unit_15
		};
		int unit_9[] = {
				R.id.unit_8,R.id.unit_10,R.id.unit_16
		};
		int unit_10[] = {
				R.id.unit_4,R.id.unit_18,R.id.unit_5,R.id.unit_17,R.id.unit_6,R.id.unit_16,R.id.unit_9,R.id.unit_11
		};
		int unit_11[] = {
				R.id.unit_10,R.id.unit_12,R.id.unit_18
		};
		int unit_12[] = {
				R.id.unit_11,R.id.unit_18,R.id.unit_19
		};
		int unit_13[] = {
				R.id.unit_20,R.id.unit_29
		};
		int unit_14[] = {
				R.id.unit_23,R.id.unit_7,R.id.unit_22
		};
		int unit_15[] = {
				R.id.unit_8,R.id.unit_23,R.id.unit_16
		};
		int unit_16[] = {
				R.id.unit_8,R.id.unit_25,R.id.unit_9,R.id.unit_24,R.id.unit_10,R.id.unit_23,R.id.unit_15,R.id.unit_17 
		};
		int unit_17[] = {
				R.id.unit_10,R.id.unit_25,R.id.unit_16,R.id.unit_18
		};
		int unit_18[] = {
				R.id.unit_10,R.id.unit_27,R.id.unit_25,R.id.unit_12,R.id.unit_17,R.id.unit_19, 
				R.id.unit_26,R.id.unit_11
		};
		int unit_19[] = {
				R.id.unit_12,R.id.unit_27,R.id.unit_18
		};
		int unit_20[] = {
				R.id.unit_13,R.id.unit_27,R.id.unit_28
		};
		int unit_21[] = {
				R.id.unit_7,R.id.unit_37,R.id.unit_22
		};
		int unit_22[] = {
				R.id.unit_21,R.id.unit_23,R.id.unit_30,R.id.unit_14
		};
		int unit_23[] = {
				R.id.unit_14,R.id.unit_32,R.id.unit_15,R.id.unit_31,R.id.unit_16,R.id.unit_30,R.id.unit_22,R.id.unit_24
		};
		int unit_24[] = {
				R.id.unit_16,R.id.unit_32,R.id.unit_23,R.id.unit_25
		};
		int unit_25[] = {
				R.id.unit_16,R.id.unit_34,R.id.unit_17,R.id.unit_33,R.id.unit_18,R.id.unit_32,R.id.unit_24,R.id.unit_26 	
		};
		int unit_26[] = {
				R.id.unit_18,R.id.unit_34,R.id.unit_25,R.id.unit_27
		};
		int unit_27[] = {
				R.id.unit_18,R.id.unit_36,R.id.unit_19,R.id.unit_35,R.id.unit_34,R.id.unit_20,R.id.unit_26,R.id.unit_28
		};
		int unit_28[] = {
				R.id.unit_20,R.id.unit_36,R.id.unit_27,R.id.unit_29
		};
		int unit_29[] = {
				R.id.unit_13,R.id.unit_43,R.id.unit_28
		};
		int unit_30[] = {
				R.id.unit_23,R.id.unit_37,R.id.unit_22
		};
		int unit_31[] = {
				R.id.unit_23,R.id.unit_38,R.id.unit_32
		};
		int unit_32[] = {
				R.id.unit_23,R.id.unit_40,R.id.unit_24,R.id.unit_39,R.id.unit_25,R.id.unit_38,R.id.unit_31,R.id.unit_33
		};
		int unit_33[] = {
				R.id.unit_25,R.id.unit_40,R.id.unit_32,R.id.unit_34
		};
		int unit_34[] = {
				R.id.unit_25,R.id.unit_42,R.id.unit_26,R.id.unit_41,R.id.unit_27,R.id.unit_40,R.id.unit_33,R.id.unit_35
		};
		int unit_35[] = {
				R.id.unit_27,R.id.unit_42,R.id.unit_34
		};
		int unit_36[] = {
				R.id.unit_27,R.id.unit_43,R.id.unit_28
		};
		int unit_37[] = {
				R.id.unit_21,R.id.unit_30
		};
		int unit_38[] = {
				R.id.unit_31,R.id.unit_32,R.id.unit_39
		};
		int unit_39[] = {
				R.id.unit_38,R.id.unit_40,R.id.unit_32
		};
		int unit_40[] = {
				R.id.unit_32,R.id.unit_46,R.id.unit_33,R.id.unit_45,R.id.unit_34,R.id.unit_44,R.id.unit_39,R.id.unit_41
		};
		int unit_41[] = {
				R.id.unit_40,R.id.unit_42,R.id.unit_34
		};
		int unit_42[] = {
				R.id.unit_34,R.id.unit_35,R.id.unit_41
		};
		int unit_43[] = {
				R.id.unit_29,R.id.unit_36
		};
		int unit_44[] = {
				R.id.unit_40,R.id.unit_47,R.id.unit_45
		};
		int unit_45[] = {
				R.id.unit_40,R.id.unit_48,R.id.unit_44,R.id.unit_46
		};
		int unit_46[] = {
				R.id.unit_40,R.id.unit_49,R.id.unit_45
		};
		int unit_47[] = {
				R.id.unit_44,R.id.unit_48
		};
		int unit_48[] = {
				R.id.unit_47,R.id.unit_49,R.id.unit_45
		};
		int unit_49[] = {
				R.id.unit_46,R.id.unit_48
		};

		int[][] arr_list = {
				unit_1, unit_2, unit_3, unit_4, unit_5, unit_6, unit_7, unit_8, unit_9, unit_10, unit_11, unit_12,
				unit_13, unit_14, unit_15, unit_16, unit_17, unit_18, unit_19, unit_20, unit_21, unit_22, unit_23,
				unit_24, unit_25, unit_26, unit_27, unit_28, unit_29, unit_30, unit_31, unit_32, unit_33, unit_34,
				unit_35, unit_36, unit_37, unit_38, unit_39, unit_40, unit_41, unit_42, unit_43, unit_44, unit_45,
				unit_46, unit_47, unit_48, unit_49
		};
		
		int[] result = new int[arr_list[value].length];
		for(int i = 0; i < arr_list[value].length; i++){
			result[i] = arr_list[value][i];
		}
		
		return result;
	}
}
