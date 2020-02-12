mission_start_credits:
 
WAIT 0
SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_PLAYER_VISIBLE player FALSE
SWITCH_RUBBISH OFF
SWITCH_WIDESCREEN ON
ADD_SCORE player 1000000
 
START_CREDITS
TIMERA = 0
SET_TIME_OF_DAY 2 40
GOTO first_credits_loop
 
WHILE NOT ARE_CREDITS_FINISHED 
	WAIT 0
 
	IF camera_cut = 0
 
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
 
			IF TIMERA > 40000
				IF IS_BUTTON_PRESSED PAD1 CROSS
					GOTO final_final_scene
				ENDIF
			ENDIF
 
		ENDWHILE
 
		first_credits_loop:
 
		SET_PLAYER_COORDINATES player -361.9 248.0 -100.0 // Colubian mansion
		SET_FIXED_CAMERA_POSITION -364.393 265.064 82.87 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -363.973 264.189 82.632 JUMP_CUT
 
		TIMERB = 0
 
		WHILE TIMERB < 20000
			WAIT 0
 
			IF TIMERA > 40000
				IF IS_BUTTON_PRESSED PAD1 CROSS
					GOTO final_final_scene
				ENDIF
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		DO_FADE 1500 FADE_IN
		TIMERB = 0
 
		WHILE TIMERB < 30000
			WAIT 0
 
			IF TIMERA > 40000
				IF IS_BUTTON_PRESSED PAD1 CROSS
					GOTO final_final_scene
				ENDIF
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		camera_cut = 1	
	ENDIF
 
	IF camera_cut = 1
 
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		SET_PLAYER_COORDINATES player -1174.25 -7.017 -100.0 // Industrial bit
		SET_FIXED_CAMERA_POSITION -1176.481 -17.694 75.992 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -1175.726 -17.055 75.847 JUMP_CUT
		SET_TIME_OF_DAY 5 40
 
		TIMERB = 0
 
		WHILE TIMERB < 20000
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		DO_FADE 1500 FADE_IN
		TIMERB = 0
 
		WHILE TIMERB < 30000
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		camera_cut = 2	
	ENDIF
 
	IF camera_cut = 2
 
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		SET_PLAYER_COORDINATES player -468.7 -3.3 -100.0 // Projects
		SET_FIXED_CAMERA_POSITION -413.07 19.261 54.403 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -413.942 18.976 54.006 JUMP_CUT
 
		TIMERB = 0
 
		WHILE TIMERB < 20000
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		DO_FADE 1500 FADE_IN
		TIMERB = 0
 
		WHILE TIMERB < 30000
			WAIT 0 
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		camera_cut = 3	
	ENDIF
 
	IF camera_cut = 3
 
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		SET_PLAYER_COORDINATES player -855.7 -717.3 -100.0 // Airport
		SET_FIXED_CAMERA_POSITION -959.517 -656.414 55.464 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -958.668 -656.912 55.288 JUMP_CUT
		SET_TIME_OF_DAY 22 0
 
		TIMERB = 0
 
		WHILE TIMERB < 20000
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		DO_FADE 1500 FADE_IN
		TIMERB = 0
 
		WHILE TIMERB < 30000
			WAIT 0 
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		camera_cut = 4	
	ENDIF
 
	IF camera_cut = 4
 
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		SET_PLAYER_COORDINATES player -532.7 -611.7 43.3 // Bridge
		SET_FIXED_CAMERA_POSITION -571.592 -611.137 67.566 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -570.697 -611.579 67.493 JUMP_CUT
 
		TIMERB = 0
 
		WHILE TIMERB < 20000
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		DO_FADE 1500 FADE_IN
		TIMERB = 0
 
		WHILE TIMERB < 30000
			WAIT 0 
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		camera_cut = 5	
	ENDIF
 
	IF camera_cut = 5
 
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		SET_PLAYER_COORDINATES player -671.6 -155.9 -100.0 // Twisted Bridge
		SET_FIXED_CAMERA_POSITION -706.590 -219.085 25.797 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -706.155 -218.190 25.696 JUMP_CUT
		SET_TIME_OF_DAY 1 20
		FORCE_WEATHER_NOW WEATHER_RAINY
 
		TIMERB = 0
 
		WHILE TIMERB < 20000
			WAIT 0
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		DO_FADE 1500 FADE_IN
		TIMERB = 0
 
		WHILE TIMERB < 40000
			WAIT 0 
 
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
 
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
 
		ENDWHILE
 
		camera_cut = 0	
	ENDIF
 
ENDWHILE