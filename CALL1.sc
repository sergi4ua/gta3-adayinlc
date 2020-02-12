:CALL1
thread 'CALL1'
gosub @CALL1_CODE
if 
wasted_or_busted
Jf @CALL1_SKIP 
gosub @CALL1_FAIL

:CALL1_SKIP 
gosub @CALL1_CLEANUP
end_thread

:CALL1_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
02A8: $MIS_MARKER_AMMU = create_marker 20 at 1063.3622 -394.9176 -99.9

0217: text_styled 'MIS0' time 3000 style 2 
02A3: toggle_widescreen 1
01B4: set_player $PLAYER_CHAR control 0
0055: put_player $PLAYER_CHAR at 938.4767 -230.188 3.0
0171: set_player $PLAYER_CHAR z_angle_to 360.0
0173: set_actor $PLAYER_ACTOR z_angle_to 360.0
wait 1000
00BB: show_text_lowpriority GXT 'MIS0_1' time 5000 flag 1
wait 6000
02A3: toggle_widescreen 0
TEXT_CLEAR_ALL
01B4: set_player $PLAYER_CHAR control 1
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
REQUEST_MODEL #GANG03
REQUEST_MODEL #UZI

:CALL1_LOAD_MODELS
wait 0
if and
IS_MODEL_AVAILABLE #UZI
0248:   model #GANG03 available
jf @CALL1_LOAD_MODELS
009A: $MIS_CHAR0 = create_actor_pedtype 8 model #GANG03 at 1163.0886 52.5053 -0.2246
0173: set_actor $MIS_CHAR0 z_angle_to 247.80
009A: $MIS_CHAR1 = create_actor_pedtype 8 model #GANG03 at 1162.9243 48.8367 -0.2598
0173: set_actor $MIS_CHAR1 z_angle_to 322.375
009A: $MIS_CHAR2 = create_actor_pedtype 8 model #GANG03 at 1170.2136 56.6609 0.2975
0173: set_actor $MIS_CHAR2 z_angle_to 117.16
0213: $MIS_PICKUP_OBJ = create_pickup #BRIEFCASE type 3 at 1161.2776 59.9469 -0.54
03DC: $MIS_PICKUP_MARK = create_marker_above_pickup $MIS_PICKUP_OBJ
01B2: give_actor $MIS_CHAR0 weapon 3 ammo 999
01B2: give_actor $MIS_CHAR1 weapon 3 ammo 999
01B2: give_actor $MIS_CHAR2 weapon 3 ammo 999
fade 1 1500

wait 1000
00BB: show_text_lowpriority GXT 'MIS0_0' time 9000 flag 1 

:CALL1_OBJ1_LOOP
wait 0
if and
0@ == 0
00A2:   actor $MIS_CHAR0 alive
00A2:   actor $MIS_CHAR1  alive
00A2:   actor $MIS_CHAR2  alive
00FF:   actor $PLAYER_ACTOR 0 1163.0886 52.5053 -0.2246 radius 15.0 15.0 15.0
then
0@ = 1
00BB: show_text_lowpriority GXT 'MIS0_2' time 3000 flag 1  // Text
01C9: actor $MIS_CHAR0 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_CHAR1 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_CHAR2 kill_actor $PLAYER_ACTOR
end

if or
IS_ACTOR_DEAD $MIS_CHAR0
IS_ACTOR_DEAD $MIS_CHAR1
IS_ACTOR_DEAD $MIS_CHAR2
then
01C9: actor $MIS_CHAR0 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_CHAR1 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_CHAR2 kill_actor $PLAYER_ACTOR
end

if
0214:   pickup $MIS_PICKUP_OBJ picked_up
then
jump @CALL1_OBJ2
end
goto @CALL1_OBJ1_LOOP

:CALL1_OBJ2
00BB: show_text_lowpriority GXT 'MIS0_3' time 5000 flag 1
03BC: $MIS_SPHERE = create_sphere 1157.046 -96.6649 7.6461 1.0
018A: $MIS_CHECKPOINT = create_checkpoint_at 1157.046 -96.6649 7.6461

:CALL1_OBJ2_LOOP
wait 0
if
00FF:   actor $PLAYER_ACTOR 0 1157.046 -96.6649 7.6461 radius 1.0 1.0 1.0
then
fade 0 1000
01B4: set_player $PLAYER_CHAR control 0
wait 1000
fade 1 1000
wait 1000
01B4: set_player $PLAYER_CHAR control 1
jump @CALL1_PASS
end
goto @CALL1_OBJ2_LOOP

:CALL1_PASS
wait 0
$PORTLAND_P1_COMPLETED += 1
01E3: text_1number_styled 'M_PASS' 1500 5000 ms 1 
//01E3: text_1number_styled "M_PASS" number 100 time 5000 style 1
0109: player $PLAYER_CHAR money += 1500
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
0318: set_latest_mission_passed 'MIS0'
0110: clear_player $PLAYER_CHAR wanted_level 
030C: set_mission_points += 1
02A7: $PORTLAND_MISSION_MARKER1 = create_icon_marker_and_sphere 8 at 938.4176 -230.3259 4.943
create_thread @P1_MIS
gosub @CALL1_SKIP
return

:CALL1_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
02A7: $PORTLAND_MISSION_MARKER1 = create_icon_marker_and_sphere 8 at 938.4176 -230.3259 4.943
create_thread @P1_MIS
$ONMISSION = 0 
mission_cleanup
return

:CALL1_CLEANUP 
RELEASE_MODEL #GANG03
RELEASE_MODEL #UZI
0164: disable_marker $MIS_CHECKPOINT
0164: disable_marker $MIS_MARKER_AMMU
0164: disable_marker $MIS_PICKUP_MARK
03BD: destroy_sphere $MIS_SPHERE
0215: destroy_pickup $MIS_PICKUP_OBJ
$ONMISSION = 0
mission_cleanup
return