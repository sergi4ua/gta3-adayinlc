:EIGHT4
thread 'EIGHT4'
gosub @EIGHT4_CODE
if 
wasted_or_busted
Jf @EIGHT4_SKIP 
gosub @EIGHT4_FAIL

:EIGHT4_SKIP 
gosub @EIGHT4_CLEANUP
end_thread

:EIGHT4_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
REQUEST_MODEL #FBI
REQUEST_MODEL #FBICAR
REQUEST_MODEL #M16
REQUEST_MODEL #ROCKET
023C: load_special_actor 'EIGHT2' as 1

:EIGHT4_IF_MODELS
wait 0
if and
IS_MODEL_AVAILABLE #FBI
IS_MODEL_AVAILABLE #FBICAR
IS_MODEL_AVAILABLE #M16
IS_MODEL_AVAILABLE #ROCKET
023D: 1
jf @EIGHT4_IF_MODELS
01B4: set_player $PLAYER_CHAR control 0
009A: $MIS_ACTOR = create_actor_pedtype 21 model #SPECIAL01 at 361.0373 -568.2589 25.0
0173: set_actor $MIS_ACTOR z_angle_to 270.0
015F: set_camera_position 366.4979 -568.2222 26.1748 rotation 0.0 0.0 0.0
0160: point_camera 360.8423 -568.2086 26.1 switchstyle 2
TOGGLE_WIDESCREEN TRUE
fade 1 1500
00BC: show_text_highpriority GXT 'MIS9_1' time 5000 flag 1  // Text
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 5000
fade 0 1500
wait 1500
0395: clear_area 1 at 1043.7319 -872.155 range -100.0 5.0
00A5: $MIS_CAR1 = create_car #FBICAR at 1043.7319 -872.155 14.4636
0175: set_car $MIS_CAR1 z_angle_to 180.0
00A5: $MIS_CAR2 = create_car #FBICAR at 1043.9956 -891.3813 14.4667
0175: set_car $MIS_CAR2 z_angle_to 180.0
00A5: $MIS_CAR3 = create_car #FBICAR at 1043.9496 -861.5939 14.4646
0175: set_car $MIS_CAR3 z_angle_to 180.0
0129: $MIS_ACTOR1 = create_actor 6 #FBI in_car $MIS_CAR1 driverseat
0129: $MIS_ACTOR2 = create_actor 6 #FBI in_car $MIS_CAR2 driverseat
0129: $MIS_ACTOR3 = create_actor 6 #FBI in_car $MIS_CAR3 driverseat
03CB: set_camera 1031.6058 -848.2709 19.8734
015F: set_camera_position 1031.6058 -848.2709 19.8734 rotation 0.0 0.0 0.0
0158: camera_on_vehicle $MIS_CAR1 15 switchstyle 2
fade 1 1500
wait 5000
fade 0 1500
wait 1500
0054: store_player $PLAYER_CHAR position_to $TEMP_X $TEMP_Y $TEMP_Z
03CB: set_camera $TEMP_X $TEMP_Y $TEMP_Z
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
TOGGLE_WIDESCREEN FALSE
00A6: destroy_car $MIS_CAR1
00A6: destroy_car $MIS_CAR2
00A6: destroy_car $MIS_CAR3
fade 1 1500
01B4: set_player $PLAYER_CHAR control 1
DESTROY_ACTOR $MIS_ACTOR
$TIMER = 60000
START_TIMER_AT $TIMER
00BC: show_text_highpriority GXT 'MIS9_2' time 5000 flag 1  // Text
03E5: show_text_box 'MIS9_6'
01B1: give_player $PLAYER_CHAR weapon 8 ammo 5
03BC: $MIS_SPHERE = create_sphere 449.3266 -930.6668 38.0 10.0
018A: $MIS_MARKER1 = create_checkpoint_at 449.3266 -930.6668 39.4305
SWITCH_ROADS_OFF 619.5625 -911.5 45.0 834.25 -954.5 32.0 
SWITCH_ROADS_OFF 659.5625 200.0 -20.0 945.75 147.5 5.0 
SWITCH_ROADS_OFF 529.5625 106.5 -30.0 581.375 65.6875 0.0 

:EIGHT4_LOOP
wait 0

if
03C6:   current_island == 1
then
00BC: show_text_highpriority GXT 'MIS9_4' time 4000 flag 1  // Text
goto @EIGHT4_FAIL
end

if
00FE:   actor $PLAYER_ACTOR 0 449.3266 -930.6668 38.0 radius 10.0 10.5 9.0
then
STOP_TIMER $TIMER
01B4: set_player $PLAYER_CHAR control 0
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_MARKER1
fade 0 1500
wait 1500
012A: put_player $PLAYER_CHAR at 448.4579 -931.1363 68.6 and_remove_from_car
0171: set_player $PLAYER_CHAR z_angle_to 270.0
01B4: set_player $PLAYER_CHAR control 1
fade 1 1500
00BC: show_text_highpriority GXT 'MIS9_3' time 1000 flag 1  // Text
goto @EIGHT4_OBJ1
end

if
$TIMER == 0
then
00BC: show_text_highpriority GXT 'OUTTIME' time 4000 flag 1  // Text
goto @EIGHT4_FAIL
end

goto @EIGHT4_LOOP

:EIGHT4_OBJ1
0395: clear_area 1 at 1043.7319 -872.155 range -100.0 5.0
00A5: $MIS_CAR1 = create_car #FBICAR at 643.2964 -918.5239 42.5134
0175: set_car $MIS_CAR1 z_angle_to 180.0
00A5: $MIS_CAR2 = create_car #FBICAR at 633.2095 -917.9684 42.5716
0175: set_car $MIS_CAR2 z_angle_to 180.0
00A5: $MIS_CAR3 = create_car #FBICAR at 616.9814 -917.9164 42.6
0175: set_car $MIS_CAR3 z_angle_to 180.0
0129: $MIS_ACTOR1 = create_actor 6 #FBI in_car $MIS_CAR1 driverseat
0129: $MIS_ACTOR2 = create_actor 6 #FBI in_car $MIS_CAR2 driverseat
0129: $MIS_ACTOR3 = create_actor 6 #FBI in_car $MIS_CAR3 driverseat
0187: $MIS_MARKER2 = create_marker_above_actor $MIS_ACTOR2
$MIS_COUNTER = 0
$MIS_FLAG0 = 0
01B2: give_actor $MIS_ACTOR1 weapon 6 ammo 999
01B2: give_actor $MIS_ACTOR2 weapon 6 ammo 999
01B2: give_actor $MIS_ACTOR3 weapon 6 ammo 999
00A9: set_car $MIS_CAR1 to_normal_driver
00A9: set_car $MIS_CAR2 to_normal_driver
00A9: set_car $MIS_CAR3 to_normal_driver
00AD: set_car $MIS_CAR1 max_speed_to 20.0
00AD: set_car $MIS_CAR2 max_speed_to 20.0
00AD: set_car $MIS_CAR3 max_speed_to 20.0
00A7: car $MIS_CAR1 drive_to 180.5678 -922.0455 25.6595
00A7: car $MIS_CAR2 drive_to 180.5678 -922.0455 25.6595
00A7: car $MIS_CAR3 drive_to 180.5678 -922.0455 25.6595

:EIGHT4_OBJ1_LOOP
wait 0

if or
    01AF:   car $MIS_CAR1 0 180.5678 -922.0455 25.6595 radius 2.0 2.0 2.0
    01AF:   car $MIS_CAR2 0 180.5678 -922.0455 25.6595 radius 2.0 2.0 2.0
    01AF:   car $MIS_CAR3 0 180.5678 -922.0455 25.6595 radius 2.0 2.0 2.0
then
    00BC: show_text_highpriority GXT 'MIS9_4' time 5000 flag 1  // Text
    goto @EIGHT4_FAIL
end

if
10@ == 0
then
    if or
    0123:   actor $MIS_ACTOR1 spotted_player $PLAYER_CHAR
    0123:   actor $MIS_ACTOR2 spotted_player $PLAYER_CHAR
    0123:   actor $MIS_ACTOR3 spotted_player $PLAYER_CHAR
    then
        010D: set_player $PLAYER_CHAR wanted_level_to 5
        01CA: actor $MIS_ACTOR1 kill_player $PLAYER_CHAR
        01CA: actor $MIS_ACTOR2 kill_player $PLAYER_CHAR
        01CA: actor $MIS_ACTOR3 kill_player $PLAYER_CHAR
        10@ = 1
    end
end

if
0118:   actor $MIS_ACTOR2 dead
then
00BC: show_text_highpriority GXT 'MIS9_5' time 5000 flag 1  // Text
fade 0 1500
wait 1500
00A1: put_actor $PLAYER_ACTOR at 449.3266 -930.6668 38.0
fade 1 1500
goto @EIGHT4_PASS
end
goto @EIGHT4_OBJ1_LOOP


:EIGHT4_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 25000 5000 ms 1 
0109: player $PLAYER_CHAR money += 25000
0394: play_music 1 
0318: set_latest_mission_passed 'MIS9'
030C: set_mission_points += 1
$PORTLAND_PLAYER_HAUNT = 0
$STAUNTON_P2_COMPLETED += 1
create_thread @S1_MIS
gosub @EIGHT4_SKIP
return

:EIGHT4_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0    
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748
create_thread @S1_MIS 
mission_cleanup
return

:EIGHT4_CLEANUP 
0296: unload_special_actor 1
RELEASE_MODEL #FBI
RELEASE_MODEL #FBICAR
RELEASE_MODEL #M16
RELEASE_MODEL #ROCKET
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR1
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR2
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR3
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR
REMOVE_REFERENCES_TO_CAR $MIS_CAR1
REMOVE_REFERENCES_TO_CAR $MIS_CAR2
REMOVE_REFERENCES_TO_CAR $MIS_CAR3
STOP_TIMER $TIMER
$ONMISSION = 0
SWITCH_ROADS_ON 619.5625 -911.5 45.0 834.25 -954.5 32.0 
SWITCH_ROADS_ON 659.5625 200.0 -20.0 945.75 147.5 5.0 
SWITCH_ROADS_ON 529.5625 106.5 -30.0 581.375 65.6875 0.0 
mission_cleanup
return