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
TOGGLE_WIDESCREEN TRUE
03CB: set_camera -581.2186 1043.2014 38.1273
015F: set_camera_position -581.2186 1043.2014 38.1273 rotation 0.0 0.0 0.0
0160: point_camera -560.1236 1024.4412 57.6567 switchstyle 2
fade 1 1500
00BC: show_text_highpriority GXT 'MIS8_E' time 6000 flag 1
wait 6000
03CB: set_camera -529.7905 1061.0991 43.5273
015F: set_camera_position -529.7905 1061.0991 43.5273 rotation 0.0 0.0 0.0
0160: point_camera -540.4661 1053.1562 37.3485 switchstyle 2
00BC: show_text_highpriority GXT 'MIS8_F' time 6000 flag 1
wait 6000
00BC: show_text_highpriority GXT 'MIS8_G' time 4000 flag 1
wait 4000
fade 0 1500
wait 3000
012A: put_player $PLAYER_CHAR at -661.3479 687.7099 105.6733 and_remove_from_car
009B: destroy_actor_instantly $MIS_ACTOR
009A: $MIS_ACTOR_B = create_actor_pedtype 21 model #SPECIAL01 at -661.4793 695.9887 106.6733
01D2: actor $MIS_ACTOR_B follow_player $PLAYER_CHAR
01DF: tie_actor $MIS_ACTOR_B to_player $PLAYER_CHAR

TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
REQUEST_MODEL #SCUM_MAN
REQUEST_MODEL #COLT45

:EIGHT3_OBJ4_IFMODELS_AVAILABLE
wait 0
if and
IS_MODEL_AVAILABLE #COLT45
IS_MODEL_AVAILABLE #SCUM_MAN
jf @EIGHT3_OBJ4_IFMODELS_AVAILABLE
00BC: show_text_highpriority GXT 'MIS8_I' time 5000 flag 1
009A: $MIS_ACTOR2 = create_actor_pedtype 4 model #SCUM_MAN at -655.3859 700.2109 106.6733
0173: set_actor $MIS_ACTOR2 z_angle_to 84.0
009A: $MIS_ACTOR3 = create_actor_pedtype 4 model #SCUM_MAN at -654.4478 705.2538 106.6733
0173: set_actor $MIS_ACTOR3 z_angle_to 169.4
009A: $MIS_ACTOR4 = create_actor_pedtype 4 model #SCUM_MAN at -658.5221 704.7704 106.6733
0173: set_actor $MIS_ACTOR4 z_angle_to 137.77
01B2: give_actor $MIS_ACTOR4 weapon 2 ammo 9999
009A: $MIS_ACTOR4 = create_actor_pedtype 4 model #SCUM_MAN at -658.5221 704.7704 106.6733
0173: set_actor $MIS_ACTOR4 z_angle_to 137.77
01B2: give_actor $MIS_ACTOR4 weapon 2 ammo 9999
009A: $MIS_ACTOR5 = create_actor_pedtype 4 model #SCUM_MAN at -661.5614 705.567 106.6733
0173: set_actor $MIS_ACTOR5 z_angle_to 185.39
01B2: give_actor $MIS_ACTOR5 weapon 2 ammo 9999
009A: $MIS_ACTOR6 = create_actor_pedtype 4 model #SCUM_MAN at -663.4471 727.5629 106.6733
0173: set_actor $MIS_ACTOR6 z_angle_to 201.9
01B2: give_actor $MIS_ACTOR6 weapon 2 ammo 9999

01CA: actor $MIS_ACTOR2 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR3 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR4 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR5 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR6 kill_player $PLAYER_CHAR

0213: $MIS_PICKUP = create_pickup #ADRENALINE type 14 at -655.2202 704.9325 106.6733

03BC: $MIS_SPHERE2 = create_sphere -660.946 731.1166 106.6733 3.0

wait 500
fade 1 1500

:EIGHT3_OBJ4_LOOP
wait 0

if
0118:   actor $MIS_ACTOR_B dead
then
fade 0 1500
wait 1500
03CB: set_camera -280.2426 423.8808 86.479
0055: put_player $PLAYER_CHAR at -280.2426 423.8808 86.479
wait 1000
fade 1 1500
wait 1000
goto @EIGHT3_FAIL
end

if
00FF:   actor $PLAYER_ACTOR 0 -660.946 731.1166 106.6733 radius 3.0 3.0 3.0
then
03BD: destroy_sphere $MIS_SPHERE2
011C: actor $MIS_ACTOR2 clear_objective
011C: actor $MIS_ACTOR3 clear_objective
011C: actor $MIS_ACTOR4 clear_objective
011C: actor $MIS_ACTOR5 clear_objective
011C: actor $MIS_ACTOR6 clear_objective
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1
01B4: set_player $PLAYER_CHAR control 0
00BC: show_text_highpriority GXT 'MIS8_H' time 2000 flag 1 
wait 2000
fade 0 1500
wait 1500
00AB: put_car $MIS_CAR at -279.878 415.0732 87.6207
0175: set_car $MIS_CAR z_angle_to 180.0
goto @EIGHT3_OBJ5
end

goto @EIGHT3_OBJ4_LOOP

:EIGHT3_OBJ5
009B: destroy_actor_instantly $MIS_ACTOR_B
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1
0224: set_car $MIS_CAR health_to 5000
01B4: set_player $PLAYER_CHAR control 1
01C8: $MIS_ACTOR_C = create_actor_pedtype 4 model #SPECIAL01 in_car $MIS_CAR passenger_seat 0
wait 1000
03CB: set_camera -280.2426 423.8808 86.479
0055: put_player $PLAYER_CHAR at -280.2426 423.8808 86.479
wait 500
0369: put_player $PLAYER_CHAR in_car $MIS_CAR
00BC: show_text_highpriority GXT 'MIS8_U' time 7000 flag 1  // Text
03BC: $MIS_SPHERE3 = create_sphere -646.332 -38.4075 18.3328 10.0
018A: $MIS_MARKER4 = create_checkpoint_at -646.332 -38.4075 18.3328
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0
fade 1 1500
wait 1000
010D: set_player $PLAYER_CHAR wanted_level_to 3

:EIGHT3_OBJ5_LOOP
wait 0

if
00FE:   actor $PLAYER_ACTOR 0 -646.332 -38.4075 18.3328 radius 10.0 10.0 10.0
then
0110: clear_player $PLAYER_CHAR wanted_level
00BC: show_text_highpriority GXT 'MIS8_Y' time 4000 flag 1  // Text
goto @EIGHT3_PASS
end

if or
0119:   car $MIS_CAR wrecked
0118:   actor $MIS_ACTOR_C dead
then
goto @EIGHT3_FAIL
end

goto @EIGHT3_OBJ5_LOOP

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
REMOVE_REFERENCES_TO_CAR $MIS_CAR
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
03BD: destroy_sphere $MIS_SPHERE
03BD: destroy_sphere $MIS_SPHERE2
0164: disable_marker $MIS_MARKER3
0164: disable_marker $MIS_MARKER4
03BD: destroy_sphere $MIS_SPHERE3
009B: destroy_actor_instantly $MIS_ACTOR2
009B: destroy_actor_instantly $MIS_ACTOR3
009B: destroy_actor_instantly $MIS_ACTOR4
009B: destroy_actor_instantly $MIS_ACTOR5
009B: destroy_actor_instantly $MIS_ACTOR6
009B: destroy_actor_instantly $MIS_ACTOR_B
009B: destroy_actor_instantly $MIS_ACTOR_C
0215: destroy_pickup $MIS_PICKUP
STOP_TIMER $TIMER
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0
$ONMISSION = 0
mission_cleanup
return