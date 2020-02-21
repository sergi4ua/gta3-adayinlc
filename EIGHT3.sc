:EIGHT3
thread 'EIGHT3'
gosub @EIGHT3_CODE
if 
wasted_or_busted
Jf @EIGHT3_SKIP 
gosub @EIGHT3_FAIL

:EIGHT3_SKIP 
gosub @EIGHT3_CLEANUP
end_thread

// BACK TO THE ROOTS CAMs //
// bank view
// -581.2186 1043.2014 38.1273 // set camera pos
// -560.1236 1024.4412 57.6567 // set camera pointing

// -529.7905 1061.0991 43.5273 // set camera pos 2
// -540.4661 1053.1562 37.3485 // set camera pointing 2
// -661.3479 687.7099 109.6733 loc 2

:EIGHT3_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
023C: load_special_actor 'EIGHT2' as 1

:EIGHT3_IF_LOADED
wait 0
if and
023D: 1
REQUEST_MODEL #BANSHEE
jf @EIGHT3_IF_LOADED
01B4: set_player $PLAYER_CHAR control 0
009A: $MIS_ACTOR = create_actor_pedtype 21 model #SPECIAL01 at 361.0373 -568.2589 25.0
0173: set_actor $MIS_ACTOR z_angle_to 270.0
015F: set_camera_position 366.4979 -568.2222 26.1748 rotation 0.0 0.0 0.0
0160: point_camera 360.8423 -568.2086 26.1 switchstyle 2
TOGGLE_WIDESCREEN TRUE
fade 1 1500
00BC: show_text_highpriority GXT 'MIS8_A' time 5000 flag 1  // Text
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 5000
00BC: show_text_highpriority GXT 'MIS8_B' time 5000 flag 1  // Text
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 5000
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
00A5: $MIS_CAR = create_car #BANSHEE at 371.034 -587.8535 26.1748
0175: set_car $MIS_CAR z_angle_to 5.0
01D2: actor $MIS_ACTOR follow_player $PLAYER_CHAR
01DF: tie_actor $MIS_ACTOR to_player $PLAYER_CHAR
00C0: set_current_time 0 0
fade 1 1500
TEXT_CLEAR_ALL

:EIGHT3_OBJ1
03E5: show_text_box 'MIS8_DE'
00BC: show_text_highpriority GXT 'MIS8_C' time 5000 flag 1 
0186: $MIS_MARKER0 = create_marker_above_car $MIS_CAR
02AC: set_car $MIS_CAR immunities BP 1 FP 1 EP 0 CP 0 MP 0
$TIMER = 200000
START_TIMER_AT $TIMER

:EIGHT3_OBJ1_LOOP
wait 0

if
$TIMER == 0
then
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1 
goto @EIGHT3_FAIL
end

if or
0119:   car $MIS_CAR wrecked
0118:   actor $MIS_ACTOR dead
then
034F: destroy_actor_with_fade $MIS_ACTOR
goto @EIGHT3_FAIL
end

if
00DB:   actor $PLAYER_ACTOR in_car $MIS_CAR
then
0164: disable_marker $MIS_MARKER0
goto @EIGHT3_OBJ2
end

goto @EIGHT3_OBJ1_LOOP

:EIGHT3_OBJ2
0187: $MIS_MARKER1 = create_marker_above_actor $MIS_ACTOR

:EIGHT3_OBJ2_LOOP
wait 0
if
00DB:   actor $MIS_ACTOR in_car $MIS_CAR
then
0164: disable_marker $MIS_MARKER1
goto @EIGHT3_OBJ3
end

if
$TIMER == 0
then
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1 
goto @EIGHT3_FAIL
end

if or
0119:   car $MIS_CAR wrecked
0118:   actor $MIS_ACTOR dead
then
goto @EIGHT3_FAIL
end

goto @EIGHT3_OBJ2_LOOP

:EIGHT3_OBJ3
0164: disable_marker $MIS_MARKER2
00BC: show_text_highpriority GXT 'MIS8_D' time 5000 flag 1  // Text
018A: $MIS_MARKER3 = create_checkpoint_at -280.2426 423.8808 86.479
03BC: $MIS_SPHERE = create_sphere -280.2426 423.8808 86.479 4.5

:EIGHT3_OBJ3_LOOP
wait 0

if
80DC:   not player $PLAYER_CHAR driving $MIS_CAR
then
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_MARKER3
00BC: text_highpriority 'IN_VEH' 5000 ms 1
0186: $MIS_MARKER2 = create_marker_above_car $MIS_CAR
goto @EIGHT3_OBJ1_LOOP 
end

if
$TIMER == 0
then
034F: destroy_actor_with_fade $MIS_ACTOR
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1 
goto @EIGHT3_FAIL
end

if or
0119:   car $MIS_CAR wrecked
0118:   actor $MIS_ACTOR dead
then
goto @EIGHT3_FAIL
end

if
00FE:   actor $PLAYER_ACTOR 0 -280.2426 423.8808 86.479 radius 4.5 4.5 4.5
then
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_MARKER3
goto @EIGHT3_OBJ4
end

goto @EIGHT3_OBJ3_LOOP

:EIGHT3_OBJ4
0217: text_styled 'MIS8_X' time 3000 style 2
01B4: set_player $PLAYER_CHAR control 0
014F: stop_timer $TIMER
fade 0 1500
wait 1500
REQUEST_MODEL #M16
LOAD_ALL_MODELS_NOW
03AD: set_rubbish 0
00A1: put_actor $PLAYER_ACTOR at -570.2076 1081.123 37.9162 // the player should be in the car already
SET_CAR_HEADING $MIS_CAR 304.0
0224: set_car $MIS_CAR health_to 3000
TEXT_CLEAR_ALL
TOGGLE_WIDESCREEN TRUE
//$MIS_CAR_COLOR_X = 0
//$MIS_CAR_COLOR_Y = 0
03CB: set_camera -572.0724 993.4146 37.9538
015F: set_camera_position -572.589 1074.0392 43.2321 rotation 0.0 0.0 0.0
0160: point_camera -563.1272 1083.5945 37.916 switchstyle 2
fade 1 1500
wait 1000
00BB: show_text_lowpriority GXT 'MIS8_E' time 5000 flag 1  // Text
wait 5000

if
IS_CAR_WRECKED $MIS_CAR
then
jump @EIGHT3_DEBUG_SKIP
end

01D3: actor $PLAYER_ACTOR leave_car $MIS_CAR
01D3: actor $MIS_ACTOR leave_car $MIS_CAR

:EIGHT3_IF_ACTORS_EXIT_CAR
wait 0

if and
00DB:   actor $PLAYER_ACTOR in_car $MIS_CAR
00DB:   actor $MIS_ACTOR in_car $MIS_CAR
then 
jump @EIGHT3_IF_ACTORS_EXIT_CAR
end


0239: actor $MIS_ACTOR run_to -541.3571 1079.3102
wait 500
0239: actor $PLAYER_ACTOR run_to -541.4803 1077.269 
wait 2000

015F: set_camera_position -581.2186 1043.2014 38.1273 rotation 0.0 0.0 0.0
0160: point_camera -560.1236 1024.4412 57.6567 switchstyle 2

00BB: show_text_lowpriority GXT 'MIS8_RT' time 3000 flag 1  // Text
wait 3000
00BB: show_text_lowpriority GXT 'MIS8_RA' time 3000 flag 1  // Text
wait 3000
020C: create_explosion 5 at -554.9506 1061.1753 37.7621
wait 2000

009A: $MIS_CUT1 = create_actor_pedtype 21 model #SPECIAL01 at -555.961 1062.745 37.7621
009A: $MIS_CUT2 = create_actor_pedtype 21 model #SPECIAL01 at -552.9744 1059.5636 37.7621
009A: $MIS_CUT3 = create_actor_pedtype 21 model #SPECIAL01 at -558.1826 1058.4487 37.7621
009A: $MIS_CUT4 = create_actor_pedtype 21 model #SPECIAL01 at -551.5699 1059.0238 37.7621

wait 100

SET_CHAR_HEALTH $MIS_CUT1 3000
SET_CHAR_HEALTH $MIS_CUT2 3000
SET_CHAR_HEALTH $MIS_CUT3 3000
SET_CHAR_HEALTH $MIS_CUT4 3000

01B2: give_actor $MIS_CUT1 weapon 6 ammo 999
01B2: give_actor $MIS_CUT2 weapon 6 ammo 999
01B2: give_actor $MIS_CUT3 weapon 6 ammo 999
01B2: give_actor $MIS_CUT4 weapon 6 ammo 999

01C9: actor $MIS_CUT1 kill_actor $MIS_CUT2
01C9: actor $MIS_CUT3 kill_actor $MIS_CUT4

00BB: show_text_lowpriority GXT 'MIS8_RB' time 2000 flag 1 
wait 2000
00BB: show_text_lowpriority GXT 'MIS8_RY' time 3000 flag 1 
wait 3000

DESTROY_ACTOR $MIS_CUT1
DESTROY_ACTOR $MIS_CUT2
DESTROY_ACTOR $MIS_CUT3
DESTROY_ACTOR $MIS_CUT4 

:EIGHT3_DEBUG_SKIP
fade 0 1500
wait 1500
01B4: set_player $PLAYER_CHAR control 1
011C: actor $PLAYER_ACTOR clear_objective
03CB: set_camera -562.843 1009.7588 25.0561
wait 50
009B: destroy_actor_instantly $MIS_ACTOR
009A: $MIS_ACTOR_B = create_actor_pedtype 21 model #SPECIAL01 at -539.4039 1024.6597 24.3
01D2: actor $MIS_ACTOR_B follow_player $PLAYER_CHAR
01DF: tie_actor $MIS_ACTOR_B to_player $PLAYER_CHAR
02AB: set_actor $MIS_ACTOR_B immunities BP 1 FP 1 EP 1 CP 1 MP 1
GIVE_WEAPON_TO_CHAR $MIS_ACTOR_B 6 999

REQUEST_MODEL #SWAT
REQUEST_MODEL #COLT45
REQUEST_MODEL #SHOTGUN
REQUEST_MODEL #SCUM_MAN
REQUEST_MODEL #MOLOTOV
LOAD_ALL_MODELS_NOW

TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT                                                      

009A: $MIS_GUARD1 = create_actor_pedtype 4 model #SWAT at -542.8428 1015.998 25.3963
009A: $MIS_GUARD2 = create_actor_pedtype 4 model #SWAT at -556.2242 1017.9449 25.3963
009A: $MIS_GUARD3 = create_actor_pedtype 4 model #SWAT at -546.6284 1039.0371 25.0562
009A: $MIS_GUARD4 = create_actor_pedtype 4 model #SWAT at -554.4955 1068.2067 25.0562
009A: $MIS_GUARD5 = create_actor_pedtype 4 model #SWAT at -541.457 1050.8878 25.0562
009A: $MIS_GUARD6 = create_actor_pedtype 4 model #SWAT at -546.2618 1040.2161 25.0562
009A: $MIS_GUARD7 = create_actor_pedtype 4 model #SWAT at -569.058 1033.4165 16.7954
009A: $MIS_GUARD8 = create_actor_pedtype 4 model #SWAT at -568.2372 1015.5281 16.7954
009A: $MIS_BUM = create_actor_pedtype 4 model #SCUM_MAN at -552.567 1041.8464 17.1355
009A: $MIS_GUARD9 = create_actor_pedtype 4 model #SWAT at -531.2916 1033.0305 20.9258


SET_CHAR_HEADING $MIS_GUARD3 180.0
SET_CHAR_HEADING $MIS_GUARD4 180.0
set_char_heading $MIS_GUARD5 82.9
SET_CHAR_HEADING $MIS_GUARD6 180.0
SET_CHAR_HEADING $MIS_GUARD7 180.0
SET_CHAR_HEADING $MIS_GUARD8 14.3
SET_CHAR_HEADING $MIS_BUM 93.69
SET_CHAR_HEADING $MIS_GUARD9 0.0

0192: set_actor $MIS_GUARD1 objective_to_stand_still
0192: set_actor $MIS_GUARD2 objective_to_stand_still
0192: set_actor $MIS_GUARD3 objective_to_stand_still
0192: set_actor $MIS_GUARD4 objective_to_stand_still
0192: set_actor $MIS_GUARD7 objective_to_stand_still
0192: set_actor $MIS_GUARD8 objective_to_stand_still

GIVE_WEAPON_TO_CHAR $MIS_GUARD1 2 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD2 2 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD3 2 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD4 4 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD5 4 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD6 2 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD7 2 9999
GIVE_WEAPON_TO_CHAR $MIS_GUARD8 2 9999
GIVE_WEAPON_TO_CHAR $MIS_BUM 10 999
GIVE_WEAPON_TO_CHAR $MIS_GUARD9 6 9999

SET_CHAR_HEALTH $MIS_ACTOR_B 4500
012A: put_player $PLAYER_CHAR at -539.4771 1021.9314 25.3963 and_remove_from_car
wait 3500

fade 1 1500
wait 1000

01C9: actor $MIS_GUARD1 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_GUARD2 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_GUARD5 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_GUARD9 kill_actor $PLAYER_ACTOR  

00BE: text_clear_all
00BB: show_text_lowpriority GXT 'MIS8_H' time 5000 flag 1

03BC: $MIS_SEWER_SPHERE1 = create_sphere -563.8296 1010.3253 25.0561 2.5
018A: $MIS_SEWER_CHECKPOINT1 = create_checkpoint_at -563.8296 1010.3253 25.0561

0213: $MIS_PICKUP1 = create_pickup #HEALTH type 3 at -566.1525 1021.9376 25.3963
0213: $MIS_PICKUP2 = create_pickup #BODYARMOUR type 3 at -555.0901 1041.6926 17.1355
032B: $MIS_PICKUP3 = create_weapon_pickup #AK47 3 ammo 120 at -554.1382 1080.9449 25.0562
0213: $MIS_PICKUP4 = create_pickup #HEALTH type 3 at -550.8564 1032.4469 25.3963

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1

0@ = 0
1@ = 0
2@ = 0
3@ = 0

:EIGHT3_SEWERS
wait 0

if and
    0@ == 0
    00FF:   actor $PLAYER_ACTOR 0 -545.4323 1027.558 25.3963 radius 3.0 3.0 3.0
then
    0@ = 1
    01C9: actor $MIS_GUARD3 kill_actor $PLAYER_ACTOR
    01C9: actor $MIS_GUARD6 kill_actor $PLAYER_ACTOR
    00BC: show_text_highpriority GXT 'MIS8_RH' time 5000 flag 1  // Text
end 

if and
    2@ == 0
    00FF:   actor $PLAYER_ACTOR 0 -572.84 1023.2643 16.7954 radius 3.0 3.0 3.0
then
    2@ = 1
    01C9: actor $MIS_GUARD7 kill_actor $PLAYER_ACTOR
    01C9: actor $MIS_GUARD8 kill_actor $PLAYER_ACTOR
end 

if and   
    1@ == 0
    00FF:   actor $PLAYER_ACTOR 0 -554.4869 1062.2271 25.3386 radius 3.0 3.0 3.0
then
    1@ = 1
    01C9: actor $MIS_GUARD4 kill_actor $PLAYER_ACTOR
end    

if and   
    3@ == 0
    00FF:   actor $PLAYER_ACTOR 0 -546.5009 1042.0046 21.2659 radius 3.0 3.0 3.0
then
    3@ = 1
    01C9: actor $MIS_BUM kill_actor $PLAYER_ACTOR
end 

if 
    00FF:   actor $PLAYER_ACTOR 0 -563.7634 1010.265 25.0561 radius 2.5 2.5 2.5
then
    goto @EIGHT3_TREASURE
end

goto @EIGHT3_SEWERS

:EIGHT3_TREASURE
DESTROY_ACTOR $MIS_BUM
DESTROY_ACTOR $MIS_GUARD1
DESTROY_ACTOR $MIS_GUARD2
DESTROY_ACTOR $MIS_GUARD3
DESTROY_ACTOR $MIS_GUARD4
DESTROY_ACTOR $MIS_GUARD5
DESTROY_ACTOR $MIS_GUARD6
DESTROY_ACTOR $MIS_GUARD7
DESTROY_ACTOR $MIS_GUARD8
DESTROY_ACTOR $MIS_GUARD9
00A1: put_actor $MIS_ACTOR_B at -559.532 1010.9498 24.0
00BC: show_text_highpriority GXT 'MIS8_RO' time 5000 flag 1

0213: $MIS_CASH1 = create_pickup #MONEY type 3 at -557.5724 999.4696 25.3963
0213: $MIS_CASH2 = create_pickup #MONEY type 3 at -561.1464 994.1232 25.3963
0213: $MIS_CASH3 = create_pickup #MONEY type 3 at -565.2912 989.9343 25.3963
0213: $MIS_CASH4 = create_pickup #MONEY type 3 at -557.6561 994.9032 25.3963

add_blip_for_pickup $MIS_CASH_MARKER1 $MIS_CASH1
add_blip_for_pickup $MIS_CASH_MARKER2 $MIS_CASH2
add_blip_for_pickup $MIS_CASH_MARKER3 $MIS_CASH3
add_blip_for_pickup $MIS_CASH_MARKER4 $MIS_CASH4

REMOVE_SPHERE $MIS_SEWER_SPHERE1
REMOVE_BLIP $MIS_SEWER_CHECKPOINT1

:EIGHT3_TREASURE_LOOP
wait 0

if and
    4@ == 0
    0214:   pickup $MIS_CASH1 picked_up
then
    4@ = 1
    REMOVE_BLIP $MIS_CASH_MARKER1
end

if and
    5@ == 0
    0214:   pickup $MIS_CASH2 picked_up
then
    5@ = 1
    REMOVE_BLIP $MIS_CASH_MARKER2
end

if and
    6@ == 0
    0214:   pickup $MIS_CASH3 picked_up
then
    6@ = 1
    REMOVE_BLIP $MIS_CASH_MARKER3
end

if and
   7@ == 0
    0214:   pickup $MIS_CASH4 picked_up
then
    7@ = 1
    REMOVE_BLIP $MIS_CASH_MARKER4
end

if and
4@ == 1
5@ == 1
6@ == 1
7@ == 1
then
goto @EIGHT3_ESCAPE
end

jump @EIGHT3_TREASURE_LOOP

:EIGHT3_ESCAPE
00BC: show_text_highpriority GXT 'MIS8_OP' time 5000 flag 1
03BC: $MIS_SEWER_SPHERE2 = create_sphere -539.6014 1021.8962 25.3963 2.5
018A: $MIS_SEWER_CHECKPOINT2 = create_checkpoint_at -539.6014 1021.8962 25.3963

009A: $MIS_GUARD1 = create_actor_pedtype 4 model #SWAT at -545.4301 1027.369 25.3963
01B2: give_actor $MIS_GUARD1 weapon 2 ammo 999  // pistol

SET_CHAR_HEADING $MIS_GUARD1 0.0
$MIS_EVENT = 0

:EIGHT3_ESCAPE_LOOP
wait 0

if and
$MIS_EVENT == 0
00FF:   actor $PLAYER_ACTOR 0 -545.5356 1026.9237 25.3963 radius 6.0 6.0 6.0
then
$MIS_EVENT = 1
01C9: actor $MIS_GUARD1 kill_actor $PLAYER_ACTOR
end

if
00FF:   actor $PLAYER_ACTOR 0 -539.6014 1021.8962 25.3963 radius 2.0 2.0 2.0
then
03BD: destroy_sphere $MIS_SEWER_SPHERE2
SET_PLAYER_CONTROL $PLAYER_CHAR FALSE
REMOVE_BLIP $MIS_SEWER_CHECKPOINT2
goto @EIGHT3_GETOUT
end

goto @EIGHT3_ESCAPE_LOOP

:EIGHT3_GETOUT
fade 0 1500
wait 1500
03CB: set_camera -572.0724 993.4146 37.9538
015F: set_camera_position -572.589 1074.0392 43.2321 rotation 0.0 0.0 0.0
0160: point_camera -563.1272 1083.5945 37.916 switchstyle 2
TOGGLE_WIDESCREEN TRUE
00A1: put_actor $MIS_ACTOR_B at -550.4691 1080.5481 37.7621 
00A1: put_actor $PLAYER_ACTOR at -550.5402 1077.6823 37.7621
fade 1 1500
0239: actor $MIS_ACTOR_B run_to -561.2574 1077.8844
wait 2000
01D4: actor $MIS_ACTOR_B go_to_car $MIS_CAR and_enter_it_as_a_passenger
01D5: actor $PLAYER_ACTOR go_to_and_drive_car $MIS_CAR

:EIGHT3_GETOUT_LOOP
wait 0

if and
    IS_CHAR_IN_CAR $MIS_ACTOR_B $MIS_CAR
    IS_CHAR_IN_CAR $PLAYER_ACTOR $MIS_CAR
then
    goto @EIGHT3_WARP_SHORESIDE
end

goto @EIGHT3_GETOUT_LOOP

:EIGHT3_WARP_SHORESIDE
fade 0 1500
wait 1500
SET_CAR_HEADING $MIS_CAR 120.0
TOGGLE_WIDESCREEN FALSE
011C: actor $PLAYER_ACTOR clear_objective
00A1: put_actor $PLAYER_ACTOR at -282.5282 415.5645 87.2353
wait 1000
SET_CAR_HEADING $MIS_CAR 120.0
SET_PLAYER_CONTROL $PLAYER_CHAR TRUE
set_camera_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
wait 1000
fade 1 1500
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0
02AB: set_actor $MIS_ACTOR_B immunities BP 0 FP 0 EP 0 CP 0 MP 0

:EIGHT3_SAFEHOUSE
00BC: show_text_highpriority GXT 'MIS8_S' time 5000 flag 1 
03BC: $MIS_SPHERE2 = create_sphere -653.821 -33.1151 18.3319 3.5
018A: $MIS_CHECKPOINT2 = create_checkpoint_at -653.821 -33.1151 18.3319
010D: set_player $PLAYER_CHAR wanted_level_to 3
03AD: set_rubbish 1

:EIGHT3_SAFEHOUSE_LOOP
wait 0
if
IS_CHAR_DEAD $MIS_ACTOR_B
then
PRINT_NOW 'EBAL_4' 5000 1 
goto @EIGHT3_FAIL
end

if
00FE:   actor $PLAYER_ACTOR 0 -653.821 -33.1151 18.3319 radius 3.5 3.5 3.5
then
REMOVE_BLIP $MIS_CHECKPOINT2
REMOVE_SPHERE $MIS_SPHERE2
TOGGLE_WIDESCREEN TRUE
SET_PLAYER_CONTROL $PLAYER_CHAR FALSE
SET_PLAYER_WANTED_LEVEL $PLAYER_CHAR 0
00BC: show_text_highpriority GXT 'MIS8_Y' time 3000 flag 1 
wait 3000
01D3: actor $MIS_ACTOR_B leave_car $MIS_CAR
16@ = 0
goto @EIGHT3_FINAL_CUT
end

goto @EIGHT3_SAFEHOUSE_LOOP

:EIGHT3_FINAL_CUT
wait 0
if
IS_CHAR_IN_CAR $MIS_ACTOR_B $MIS_ACTOR_B
then
goto @EIGHT3_FINAL_CUT
end

009C: set_actor $MIS_ACTOR_B wander_direction 0
wait 3000
TOGGLE_WIDESCREEN FALSE
SET_PLAYER_CONTROL $PLAYER_CHAR TRUE
DESTROY_ACTOR_WITH_FADE $MIS_ACTOR_B

:EIGHT3_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 500000 5000 ms 1 
0109: player $PLAYER_CHAR money += 500000
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
0318: set_latest_mission_passed 'MIS8'
030C: set_mission_points += 1
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748  
$STAUNTON_P2_COMPLETED += 1
create_thread @S1_MIS
gosub @EIGHT3_SKIP
return

:EIGHT3_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0 
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748
create_thread @S1_MIS 
mission_cleanup
return

:EIGHT3_CLEANUP 
009B: destroy_actor_instantly $MIS_ACTOR
0296: unload_special_actor 1
RELEASE_MODEL #BANSHEE
RELEASE_MODEL #COLT45
RELEASE_MODEL #SCUM_MAN
RELEASE_MODEL #SWAT
RELEASE_MODEL #M16
RELEASE_MODEL #SHOTGUN
RELEASE_MODEL #MOLOTOV
REMOVE_REFERENCES_TO_CAR $MIS_CAR
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
03BD: destroy_sphere $MIS_SPHERE
03BD: destroy_sphere $MIS_SPHERE2
0164: disable_marker $MIS_MARKER3
0164: disable_marker $MIS_MARKER4
0164: disable_marker $MIS_SEWER_CHECKPOINT1
03BD: destroy_sphere $MIS_SPHERE3
03BD: destroy_sphere $MIS_SEWER_SPHERE1
009B: destroy_actor_instantly $MIS_ACTOR_B
0215: destroy_pickup $MIS_PICKUP1
0215: destroy_pickup $MIS_PICKUP2
0215: destroy_pickup $MIS_PICKUP3
0215: destroy_pickup $MIS_PICKUP4
0215: destroy_pickup $MIS_CASH1
0215: destroy_pickup $MIS_CASH2
0215: destroy_pickup $MIS_CASH3
0215: destroy_pickup $MIS_CASH4
REMOVE_BLIP $MIS_CASH_MARKER1
REMOVE_BLIP $MIS_CASH_MARKER2
REMOVE_BLIP $MIS_CASH_MARKER3
REMOVE_BLIP $MIS_CASH_MARKER4
03BD: destroy_sphere $MIS_SEWER_SPHERE2
REMOVE_BLIP $MIS_SEWER_CHECKPOINT2
STOP_TIMER $TIMER
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0
03AD: set_rubbish 0
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_BUM
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD1
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD2
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD3
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD4
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD5
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD6
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD7
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD8
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_GUARD9
REMOVE_BLIP $MIS_CHECKPOINT2
$ONMISSION = 0
$MIS_EVENT = 0
mission_cleanup
return