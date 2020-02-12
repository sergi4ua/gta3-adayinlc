:CALL2
thread 'CALL2'
gosub @CALL2_CODE
if 
wasted_or_busted
Jf @CALL2_SKIP 
gosub @CALL2_FAIL

:CALL2_SKIP 
gosub @CALL2_CLEANUP
end_thread

:CALL2_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level

0217: text_styled 'MIS1' time 3000 style 2 
02A3: toggle_widescreen 1
01B4: set_player $PLAYER_CHAR control 0
0055: put_player $PLAYER_CHAR at 938.4767 -230.188 3.0
0171: set_player $PLAYER_CHAR z_angle_to 360.0
0173: set_actor $PLAYER_ACTOR z_angle_to 360.0
wait 1000
00BB: show_text_lowpriority GXT 'MIS1_1' time 5000 flag 1
wait 6000
02A3: toggle_widescreen 0
TEXT_CLEAR_ALL
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
01B4: set_player $PLAYER_CHAR control 1
fade 1 1000

wait 1000
00BB: show_text_lowpriority GXT 'MIS1_2' time 7000 flag 1 
03E5: show_text_box 'TIMER'
$TIMER = 240000
014E: start_timer_at $TIMER

0213: $MISPICKUP0 = create_pickup #package1 type 14 at 789.1395 -303.9686 5.729
0213: $MISPICKUP1 = create_pickup #package1 type 14 at 956.6046 -429.7886 15.02
0213: $MISPICKUP2 = create_pickup #package1 type 14 at 974.2656 -686.0172 14.9727
0213: $MISPICKUP3 = create_pickup #package1 type 14 at 908.2411 -754.0483 14.9727
0213: $MISPICKUP4 = create_pickup #package1 type 14 at 905.9521 -918.1071 14.8227
03DC: $MISMARKER0 = create_marker_above_pickup $MISPICKUP0
03DC: $MISMARKER1 = create_marker_above_pickup $MISPICKUP1
03DC: $MISMARKER2 = create_marker_above_pickup $MISPICKUP2
03DC: $MISMARKER3 = create_marker_above_pickup $MISPICKUP3
03DC: $MISMARKER4 = create_marker_above_pickup $MISPICKUP4
$MIS_COLLECTED = 0

:CALL2_OBJ1_LOOP
wait 0

if
$TIMER == 0
then
00BC: text_highpriority 'OUTTIME' 5000 ms 1
goto @CALL2_FAIL
end

if
0214:   pickup $MISPICKUP0 picked_up
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_COLLECTED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
end

if
0214:   pickup $MISPICKUP1 picked_up
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_COLLECTED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
end

if
0214:   pickup $MISPICKUP2 picked_up
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_COLLECTED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
end

if
0214:   pickup $MISPICKUP3 picked_up
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_COLLECTED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
end

if
0214:   pickup $MISPICKUP4 picked_up
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_COLLECTED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
end

if
$MIS_COLLECTED == 5
then
goto @CALL2_OBJ2
end

goto @CALL2_OBJ1_LOOP

:CALL2_OBJ2
014F: stop_timer $TIMER
0215: destroy_pickup $MISPICKUP0
0215: destroy_pickup $MISPICKUP1
0215: destroy_pickup $MISPICKUP2
0215: destroy_pickup $MISPICKUP3
0215: destroy_pickup $MISPICKUP4

00BB: show_text_lowpriority GXT 'MIS0_3' time 5000 flag 1
03BC: $MIS_SPHERE = create_sphere 1157.046 -96.6649 7.6461 1.0
018A: $MIS_CHECKPOINT = create_checkpoint_at 1157.046 -96.6649 7.6461

:CALL2_OBJ2_LOOP
wait 0
if
00FF:   actor $PLAYER_ACTOR 0 1157.046 -96.6649 7.6461 radius 1.0 1.0 1.0
then
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_CHECKPOINT
fade 0 1000
01B4: set_player $PLAYER_CHAR control 0
wait 1000
REQUEST_MODEL #GANG02
REQUEST_MODEL #GANG03
REQUEST_MODEL #SHOTGUN

:CALL2_OBJ2_LOAD_MODELS
wait 0
if and
IS_MODEL_AVAILABLE #GANG02
IS_MODEL_AVAILABLE #GANG03
IS_MODEL_AVAILABLE #SHOTGUN
jf @CALL2_OBJ2_LOAD_MODELS
wait 1000
009A: $MIS_ACTOR1 = create_actor_pedtype 21 model #GANG02 at 1167.9258 -93.4875 7.4726
0173: set_actor $MIS_ACTOR1 z_angle_to 0.0
009A: $MIS_ACTOR2 = create_actor_pedtype 21 model #GANG03 at 1174.6503 -93.4582 7.4726
0173: set_actor $MIS_ACTOR2 z_angle_to 53.27
01B2: give_actor $MIS_ACTOR2 weapon 4 ammo 999
015F: set_camera_position 1172.9078 -85.5308 7.4726 rotation 0.0 0.0 0.0
CAMERA_ON_PED $MIS_ACTOR1 15 2
TOGGLE_WIDESCREEN TRUE
wait 1000
fade 1 1000
wait 3000
CAMERA_ON_PED $MIS_ACTOR2 15 1
01C9: actor $MIS_ACTOR2 kill_actor $MIS_ACTOR1
wait 3000
fade 0 1000
wait 1000
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
fade 1 1000
00BB: show_text_lowpriority GXT 'MIS1_6' time 5000 flag 1
0187: $MIS_MARKER5 = create_marker_above_actor $MIS_ACTOR2
wait 500
01C9: actor $MIS_ACTOR2 kill_actor $PLAYER_ACTOR
goto @CALL2_OBJ3
end
goto @CALL2_OBJ2_LOOP

:CALL2_OBJ3
wait 0
if
0118:   actor $MIS_ACTOR2 dead
then
goto @CALL2_PASS
end
goto @CALL2_OBJ3

:CALL2_PASS
wait 0
$PORTLAND_P1_COMPLETED += 1
01E3: text_1number_styled 'M_PASS' 3000 5000 ms 1 
//01E3: text_1number_styled "M_PASS" number 100 time 5000 style 1
0109: player $PLAYER_CHAR money += 3000
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
0318: set_latest_mission_passed 'MIS1'
0110: clear_player $PLAYER_CHAR wanted_level 
030C: set_mission_points += 1
02A7: $PORTLAND_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 1150.1073 -454.2015 20.648
create_thread @P2_MIS
gosub @CALL2_SKIP
return

:CALL2_FAIL 
00BA: text_styled 'M_FAIL' 5000 ms 1
02A7: $PORTLAND_MISSION_MARKER1 = create_icon_marker_and_sphere 8 at 938.4176 -230.3259 4.943
create_thread @P1_MIS
$ONMISSION = 0 
mission_cleanup
return

:CALL2_CLEANUP 
014F: stop_timer $TIMER
0215: destroy_pickup $MISPICKUP0
0215: destroy_pickup $MISPICKUP1
0215: destroy_pickup $MISPICKUP2
0215: destroy_pickup $MISPICKUP3
0215: destroy_pickup $MISPICKUP4
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_CHECKPOINT
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
0164: disable_marker $MIS_MARKER3
0164: disable_marker $MIS_MARKER4
0164: disable_marker $MIS_MARKER5
release_model #GANG02
release_model #GANG03
release_model #SHOTGUN
$ONMISSION = 0
mission_cleanup
return