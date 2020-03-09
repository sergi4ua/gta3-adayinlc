:EIGHT2
thread 'EIGHT2'
gosub @EIGHT2_CODE
if 
wasted_or_busted
Jf @EIGHT2_SKIP 
gosub @EIGHT2_FAIL

:EIGHT2_SKIP 
gosub @EIGHT2_CLEANUP
end_thread

:EIGHT2_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
023C: load_special_actor 'EIGHT2' as 1
REQUEST_MODEL #GANG09
REQUEST_MODEL #GANG01
REQUEST_MODEL #GANG11
REQUEST_MODEL #M16
REQUEST_MODEL #SHOTGUN

:EIGHT2_IF_LOADED
wait 0
if and
023D: 1
IS_MODEL_AVAILABLE #GANG09
IS_MODEL_AVAILABLE #GANG01
IS_MODEL_AVAILABLE #GANG11
IS_MODEL_AVAILABLE #M16
IS_MODEL_AVAILABLE #SHOTGUN
jf @EIGHT2_IF_LOADED
01B4: set_player $PLAYER_CHAR control 0
009A: $MIS_ACTOR = create_actor_pedtype 21 model #SPECIAL01 at 361.0373 -568.2589 25.0
0173: set_actor $MIS_ACTOR z_angle_to 270.0
015F: set_camera_position 366.4979 -568.2222 26.1748 rotation 0.0 0.0 0.0
0160: point_camera 360.8423 -568.2086 26.1 switchstyle 2
TOGGLE_WIDESCREEN TRUE
fade 1 1500

const
GangA1X = 109.26
GangA1Y = -1233.84
GangA1Z = 25.0
GangA2X = 114.2
GangA2Y = -1234.2
GangA2Z = 25.0
GangA3X = 111.7
GangA3Y = -1238.4
GangA3Z = 25.0
GangB1X = 549.44
GangB1Y = -23.8
GangB1Z = 2.0
GangB2X = 545.1
GangB2Y = -22.0
GangB2Z = 2.1
GangC1X = 399.0
GangC1Y = -366.552
GangC1Z = 20.9 
GangC2X = 402.2
GangC2Y = -372.2
GangC2Z = 19.0 
GangC3X = 400.2
GangC3Y = -362.0
GangC3Z = 19.0
GangC4X = 390.42
GangC4Y = -381.0
GangC4Z = 20.0 
GangAngle = 0.0
GangAngle2 = 180.0
GangAngle3 = 66.0
GangAngle4 = 231.0
end

00BC: show_text_highpriority GXT 'MIS6_A' time 5000 flag 1  // Text
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 5000
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
009B: destroy_actor_instantly $MIS_ACTOR
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
fade 1 1500
TEXT_CLEAR_ALL
wait 1000

$TIMER = 330000
014E: start_timer_at $TIMER

00BC: show_text_highpriority GXT 'MIS6_B' time 5000 flag 1  // Text
009A: $MIS_GANGA1 = create_actor_pedtype 5 model #GANG09 at GangA1X GangA1Y GangA1Z
009A: $MIS_GANGA2 = create_actor_pedtype 5 model #GANG09 at GangA2X GangA2Y GangA2Z
009A: $MIS_GANGA3 = create_actor_pedtype 5 model #GANG09 at GangA3X GangA3Y GangA3Z

0173: set_actor $MIS_GANGA1 z_angle_to GangAngle2
0173: set_actor $MIS_GANGA2 z_angle_to GangAngle2
0173: set_actor $MIS_GANGA3 z_angle_to GangAngle

03F9: make_actors $MIS_GANGA1 $MIS_GANGA3 converse_in -1 ms
0187: $MIS_MARKER0 = create_marker_above_actor $MIS_GANGA3

01B2: give_actor $MIS_GANGA1 weapon 6 ammo 9999
01B2: give_actor $MIS_GANGA2 weapon 6 ammo 9999
01B2: give_actor $MIS_GANGA3 weapon 6 ammo 9999

$MIS_FLAG0 = 0


:EIGHT2_OBJ2_LOOP
wait 0

if
$TIMER == 0
then
TEXT_CLEAR_ALL
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1  
goto @EIGHT2_FAIL
end

if or
0123:   actor $MIS_GANGA1 spotted_player $PLAYER_CHAR
0123:   actor $MIS_GANGA2 spotted_player $PLAYER_CHAR
0123:   actor $MIS_GANGA3 spotted_player $PLAYER_CHAR
then
01CA: actor $MIS_GANGA1 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA2 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA3 kill_player $PLAYER_CHAR
end

if and
0118:   actor $MIS_GANGA3 dead
$MIS_FLAG0 == 0
then
$MIS_FLAG0 = 1
0164: disable_marker $MIS_MARKER0
00A0: store_actor $MIS_GANGA3 position_to $TEMP_X $TEMP_Y $TEMP_Z
0213: $MIS_BRIEFCASE0 = create_pickup #BRIEFCASE type 3 at $TEMP_X $TEMP_Y $TEMP_Z
00BC: show_text_highpriority GXT 'MIS6_E' time 5000 flag 1 
03DC: $MIS_MARKER1 = create_marker_above_pickup $MIS_BRIEFCASE0 
018C: play_sound 94 at $TEMP_X $TEMP_Y $TEMP_Z
end

if and
$MIS_FLAG0 == 1
0214:   pickup $MIS_BRIEFCASE0 picked_up
then
0164: disable_marker $MIS_MARKER1
goto @EIGHT2_OBJ3
end

if or
0118:   actor $MIS_GANGA1 dead
0118:   actor $MIS_GANGA2 dead
0118:   actor $MIS_GANGA3 dead
then
01CA: actor $MIS_GANGA1 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA2 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA3 kill_player $PLAYER_CHAR
end

goto @EIGHT2_OBJ2_LOOP

/* SECOND GANG DEAL */

:EIGHT2_OBJ3
$TEMP_X = 0.0
$TEMP_Y = 0.0
$TEMP_Z = 0.0
00BC: show_text_highpriority GXT 'MIS6_C' time 5000 flag 1  // Text

009A: $MIS_GANGA4 = create_actor_pedtype 7 model #GANG01 at GangB1X GangB1Y GangB1Z
009A: $MIS_GANGA5 = create_actor_pedtype 7 model #GANG01 at GangB2X GangB2Y GangB2Z

0173: set_actor $MIS_GANGA4 z_angle_to GangAngle3
0173: set_actor $MIS_GANGA5 z_angle_to GangAngle4

03F9: make_actors $MIS_GANGA4 $MIS_GANGA5 converse_in -1 ms
01B2: give_actor $MIS_GANGA4 weapon 4 ammo 9999
01B2: give_actor $MIS_GANGA5 weapon 4 ammo 9999
0187: $MIS_MARKER2 = create_marker_above_actor $MIS_GANGA4

$MIS_FLAG1 = 0    // flag is the guy killed

:EIGHT2_OBJ3_LOOP
wait 0

if
$TIMER == 0
then
TEXT_CLEAR_ALL
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1  
goto @EIGHT2_FAIL
end

if or
0123:   actor $MIS_GANGA4 spotted_player $PLAYER_CHAR
0123:   actor $MIS_GANGA5 spotted_player $PLAYER_CHAR
then
01CA: actor $MIS_GANGA4 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA5 kill_player $PLAYER_CHAR
end

if and
0118:   actor $MIS_GANGA4 dead
$MIS_FLAG1 == 0
then
$MIS_FLAG1 = 1
0164: disable_marker $MIS_MARKER2
00A0: store_actor $MIS_GANGA4 position_to $TEMP_X $TEMP_Y $TEMP_Z
0213: $MIS_BRIEFCASE1 = create_pickup #BRIEFCASE type 3 at $TEMP_X $TEMP_Y $TEMP_Z
00BC: show_text_highpriority GXT 'MIS6_E' time 5000 flag 1 
03DC: $MIS_MARKER3 = create_marker_above_pickup $MIS_BRIEFCASE1 
018C: play_sound 94 at $TEMP_X $TEMP_Y $TEMP_Z
end

if and
$MIS_FLAG1 == 1
0214:   pickup $MIS_BRIEFCASE1 picked_up
then
0164: disable_marker $MIS_MARKER3
goto @EIGHT2_OBJ4
end

if or
0118:   actor $MIS_GANGA4 dead
0118:   actor $MIS_GANGA5 dead
then
01CA: actor $MIS_GANGA4 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA5 kill_player $PLAYER_CHAR
end

goto @EIGHT2_OBJ3_LOOP

/* THIRD GANG DEAL */

:EIGHT2_OBJ4
$TEMP_X = 0.0
$TEMP_Y = 0.0
$TEMP_Z = 0.0
00BC: show_text_highpriority GXT 'MIS6_D' time 5000 flag 1  // Text

009A: $MIS_GANGA6 = create_actor_pedtype 12 model #GANG11 at GangC1X GangC1Y GangC1Z
009A: $MIS_GANGA7 = create_actor_pedtype 12 model #GANG11 at GangC2X GangC2Y GangC2Z
009A: $MIS_GANGA8 = create_actor_pedtype 12 model #GANG11 at GangC3X GangC3Y GangC3Z
009A: $MIS_GANGA9 = create_actor_pedtype 12 model #GANG11 at GangC4X GangC4Y GangC4Z

0173: set_actor $MIS_GANGA6 z_angle_to GangAngle
0173: set_actor $MIS_GANGA7 z_angle_to GangAngle4
0173: set_actor $MIS_GANGA8 z_angle_to GangAngle
0173: set_actor $MIS_GANGA9 z_angle_to GangAngle2

03F9: make_actors $MIS_GANGA6 $MIS_GANGA7 converse_in -1 ms
01B2: give_actor $MIS_GANGA6 weapon 6 ammo 9999
01B2: give_actor $MIS_GANGA7 weapon 6 ammo 9999
01B2: give_actor $MIS_GANGA8 weapon 6 ammo 9999
01B2: give_actor $MIS_GANGA9 weapon 6 ammo 9999
0187: $MIS_MARKER4 = create_marker_above_actor $MIS_GANGA6

$MIS_FLAG2 = 0

:EIGHT2_OBJ4_LOOP
wait 0

if
$TIMER == 0
then
TEXT_CLEAR_ALL
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1  
goto @EIGHT2_FAIL
end

if or
0123:   actor $MIS_GANGA6 spotted_player $PLAYER_CHAR
0123:   actor $MIS_GANGA7 spotted_player $PLAYER_CHAR
0123:   actor $MIS_GANGA8 spotted_player $PLAYER_CHAR
0123:   actor $MIS_GANGA9 spotted_player $PLAYER_CHAR
then
01CA: actor $MIS_GANGA6 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA7 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA8 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA9 kill_player $PLAYER_CHAR
end

if and
0118:   actor $MIS_GANGA6 dead
$MIS_FLAG2 == 0
then
$MIS_FLAG2 = 1
0164: disable_marker $MIS_MARKER4
00A0: store_actor $MIS_GANGA6 position_to $TEMP_X $TEMP_Y $TEMP_Z
0213: $MIS_BRIEFCASE2 = create_pickup #BRIEFCASE type 3 at $TEMP_X $TEMP_Y $TEMP_Z
00BC: show_text_highpriority GXT 'MIS6_E' time 5000 flag 1 
03DC: $MIS_MARKER5 = create_marker_above_pickup $MIS_BRIEFCASE2 
018C: play_sound 94 at $TEMP_X $TEMP_Y $TEMP_Z
end

if and
$MIS_FLAG2 == 1
0214:   pickup $MIS_BRIEFCASE2 picked_up
then
0164: disable_marker $MIS_MARKER5
TEXT_CLEAR_ALL
goto @EIGHT2_PASS
end

if or
0118:   actor $MIS_GANGA6 dead
0118:   actor $MIS_GANGA7 dead
0118:   actor $MIS_GANGA8 dead
0118:   actor $MIS_GANGA9 dead
then
01CA: actor $MIS_GANGA6 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA7 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA8 kill_player $PLAYER_CHAR
01CA: actor $MIS_GANGA9 kill_player $PLAYER_CHAR
end

goto @EIGHT2_OBJ4_LOOP

:EIGHT2_PASS
0110: clear_player $PLAYER_CHAR wanted_level
01E3: text_1number_styled 'M_PASS' 50000 5000 ms 1 
0109: player $PLAYER_CHAR money += 50000
0394: play_music 1 
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748     
0318: set_latest_mission_passed 'MIS6'
030C: set_mission_points += 1
$STAUNTON_P2_COMPLETED += 1
create_thread @S1_MIS
create_thread @PROP
$PROPERTIES_AVAILABLE = 1
00BC: show_text_highpriority GXT 'MIS6_P' time 4000 flag 1  // Text
02A7: $STAUNTON_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 196.8638 -628.8686 25.1673 
$STAUNTON_BONUS_MISSION0 = 1
03E5: show_text_box 'HELPDLC'
create_thread @S2_MIS
gosub @EIGHT2_SKIP
return

:EIGHT2_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748
create_thread @S1_MIS  
mission_cleanup
return

:EIGHT2_CLEANUP 
0296: unload_special_actor 1
RELEASE_MODEL #GANG09
RELEASE_MODEL #GANG01
RELEASE_MODEL #GANG11
RELEASE_MODEL #M16
RELEASE_MODEL #SHOTGUN
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA1
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA2
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA3
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA4
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA5
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA6
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA7
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA8
REMOVE_REFERENCES_TO_ACTOR $MIS_GANGA9
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
0164: disable_marker $MIS_MARKER3
0164: disable_marker $MIS_MARKER4
0164: disable_marker $MIS_MARKER5
0215: destroy_pickup $MIS_BRIEFCASE0
0215: destroy_pickup $MIS_BRIEFCASE1
0215: destroy_pickup $MIS_BRIEFCASE2
STOP_TIMER $TIMER
$TEMP_X = 0.0
$TEMP_Y = 0.0
$TEMP_Z = 0.0
$MIS_FLAG0 = 0
$MIS_FLAG1 = 0
$MIS_FLAG2 = 0
$ONMISSION = 0
mission_cleanup
return