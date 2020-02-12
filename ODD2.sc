:ODD2
thread 'ODD2'
gosub @ODD2_CODE
if 
wasted_or_busted
Jf @ODD2_SKIP 
gosub @ODD2_FAIL

:ODD2_SKIP 
gosub @ODD2_CLEANUP
end_thread

:ODD2_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
0247: request_model #GANG01
0247: request_model #GANG02 
0247: request_model #PREDATOR
REQUEST_MODEL #AK47
REQUEST_MODEL #SHOTGUN
$MISKILLED = 0

:ODD2_IF_MODELS
wait 0
if and
IS_MODEL_AVAILABLE #GANG01
IS_MODEL_AVAILABLE #GANG02
IS_MODEL_AVAILABLE #AK47
IS_MODEL_AVAILABLE #SHOTGUN
IS_MODEL_AVAILABLE #PREDATOR
jf @ODD2_IF_MODELS
fade 1 1500
00BC: show_text_highpriority GXT 'MIS3_B' time 7000 flag 1
00A5: $MISSION_BOAT1 = create_car #PREDATOR at 841.1928 -1114.5583 3.0
0175: set_car $MISSION_BOAT1 z_angle_to 180.0
032B: $MISSION_SNIPER = create_weapon_pickup #SNIPER 14 ammo 100 at 835.654 -1091.1638 6.824
03DC: $MISSION_MARKER0 = create_marker_above_pickup $MISSION_SNIPER

:ODD2_OBJ1
wait 0
if
0214:   pickup $MISSION_SNIPER picked_up
jf @ODD2_OBJ1
0164: disable_marker $MISSION_SNIPER
009A: $MIS_ACTOR0 = create_actor_pedtype 7 model #GANG01 at 1485.509 -384.1898 11.4162
0173: set_actor $MIS_ACTOR0 z_angle_to 247.0
009A: $MIS_ACTOR1 = create_actor_pedtype 7 model #GANG02 at 1476.2955 -403.0767 12.7404
0173: set_actor $MIS_ACTOR1 z_angle_to 258.70
009A: $MIS_ACTOR2 = create_actor_pedtype 7 model #GANG01 at 1495.5967 -391.469 9.3656
0173: set_actor $MIS_ACTOR2 z_angle_to 270.0
009A: $MIS_ACTOR3 = create_actor_pedtype 7 model #GANG01 at 1493.5309 -419.5195 9.1892
0173: set_actor $MIS_ACTOR3 z_angle_to 320.11

01B2: give_actor $MIS_ACTOR0 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR1 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR2 weapon 4 ammo 999
01B2: give_actor $MIS_ACTOR3 weapon 5 ammo 999

0187: $MISSION_MARKER1 = create_marker_above_actor $MIS_ACTOR0
0187: $MISSION_MARKER2 = create_marker_above_actor $MIS_ACTOR1
0187: $MISSION_MARKER3 = create_marker_above_actor $MIS_ACTOR2
0187: $MISSION_MARKER4 = create_marker_above_actor $MIS_ACTOR3
0186: $MISSION_MARKER5 = create_marker_above_car $MISSION_BOAT1


$MISSION_FLAG = 0
$MISSION_FLAG1 = 0
$KILL_FLAG0 = 0
$KILL_FLAG1 = 0
$KILL_FLAG2 = 0
$KILL_FLAG3 = 0

00BC: show_text_highpriority GXT 'MIS3_C' time 7000 flag 1

:ODD2_OBJ2
wait 0

if and
$MISSION_FLAG1 == 0
00DB:   actor $PLAYER_ACTOR in_car $MISSION_BOAT1
then
$MISSION_FLAG1 = 1
0164: disable_marker $MISSION_MARKER5
end

if and
$MISSION_FLAG == 0
00FE:   actor $PLAYER_ACTOR 0 1483.01 -376.1544 12.4073 radius 100.5 100.5 10.0
then
$MISSION_FLAG = 1
01C9: actor $MIS_ACTOR0 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR1 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR2 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR3 kill_actor $PLAYER_ACTOR
end

if
00FE:   actor $PLAYER_ACTOR 0 1377.5393 -283.2263 49.823 radius 40.0 40.0 10.0
then
00BC: show_text_highpriority GXT 'MIS3_F' time 4000 flag 1  
goto @ODD2_FAIL
end

if and
IS_ACTOR_DEAD $MIS_ACTOR0 
$KILL_FLAG0 == 0
then
$KILL_FLAG0 = 1
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MISKILLED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
0164: disable_marker $MISSION_MARKER1
end

if and
$KILL_FLAG1 == 0
IS_ACTOR_DEAD $MIS_ACTOR1
then
$KILL_FLAG1 = 1
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MISKILLED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
0164: disable_marker $MISSION_MARKER2
end

if and
IS_ACTOR_DEAD $MIS_ACTOR2 
$KILL_FLAG2 == 0
then
$KILL_FLAG2 = 1
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MISKILLED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
0164: disable_marker $MISSION_MARKER3
end

if and
IS_ACTOR_DEAD $MIS_ACTOR3
$KILL_FLAG3 == 0
then
$KILL_FLAG3 = 1
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MISKILLED += 1
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
0164: disable_marker $MISSION_MARKER4
end

if
$MISKILLED == 4
then
goto @ODD2_OBJ3
end

goto @ODD2_OBJ2

:ODD2_OBJ3
$TIMER = 20000
014E: start_timer_at $TIMER
00BC: show_text_highpriority GXT 'MIS3_R' time 10000 flag 1  // Text

:ODD2_OBJ3_LOOP
wait 0

if
$TIMER == 0
then
020B: explode_car $MISSION_BOAT1
jump @ODD2_OBJ4
end

if or
0203:   actor $PLAYER_ACTOR near_car_on_foot $MISSION_BOAT1 radius 10.0 10.0 unknown 0
00DB:   actor $PLAYER_ACTOR in_car $MISSION_BOAT1
then
0000:
else
020B: explode_car $MISSION_BOAT1
jump @ODD2_OBJ4
end

goto @ODD2_OBJ3_LOOP

:ODD2_OBJ4
if
0256:   player $PLAYER_CHAR defined
jf @ODD2_FAIL
STOP_TIMER $TIMER
009A: $MIS_ACTOR4 = create_actor_pedtype 7 model #GANG01 at 1466.8235 -214.6724 16.1324
0173: set_actor $MIS_ACTOR4 z_angle_to 180.0
009A: $MIS_ACTOR5 = create_actor_pedtype 7 model #GANG01 at 1485.509 -384.1898 11.4162
0173: set_actor $MIS_ACTOR5 z_angle_to 216.0
009A: $MIS_ACTOR6 = create_actor_pedtype 7 model #GANG02 at 1420.7386 -200.7594 50.2831
0173: set_actor $MIS_ACTOR6 z_angle_to 220.0
009A: $MIS_ACTOR6 = create_actor_pedtype 7 model #GANG02 at 1442.1714 -198.5705 55.6457
0173: set_actor $MIS_ACTOR6 z_angle_to 156.8
009A: $MIS_ACTOR7 = create_actor_pedtype 7 model #GANG02 at 1407.1797 -232.7691 51.3998
0173: set_actor $MIS_ACTOR7 z_angle_to 300.0
009A: $MIS_ACTOR8 = create_actor_pedtype 7 model #GANG01 at 1402.5658 -244.4485 50.5147
0173: set_actor $MIS_ACTOR8 z_angle_to 10.0

01B2: give_actor $MIS_ACTOR4 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR5 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR6 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR7 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR8 weapon 5 ammo 999

02E2: set_actor $MIS_ACTOR6 weapon_accuracy_to 70
02E2: set_actor $MIS_ACTOR7 weapon_accuracy_to 70

:ODD2_OBJ4_B
if
0256:   player $PLAYER_CHAR defined
jf @ODD2_FAIL
TOGGLE_WIDESCREEN TRUE
015F: set_camera_position 1404.0372 -220.0314 60.0 rotation 0.0 0.0 0.0
0160: point_camera 1444.5682 -193.2518 55.7 switchstyle 2
00BC: show_text_highpriority GXT 'MIS3_T' time 5000 flag 1  // Text
wait 5000
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
TOGGLE_WIDESCREEN FALSE

TEXT_CLEAR_ALL
00BC: show_text_highpriority GXT 'MIS3_U' time 7000 flag 1  // Text

01CA: actor $MIS_ACTOR4 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR5 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR6 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR7 kill_player $PLAYER_CHAR
01CA: actor $MIS_ACTOR8 kill_player $PLAYER_CHAR

:ODD2_OBJ4_LOOP
wait 0
if
0121:  player $PLAYER_CHAR in_zone 'EASTBAY'
jf @ODD2_PASS
jump @ODD2_OBJ4_LOOP

:ODD2_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 7500 5000 ms 1 
0109: player $PLAYER_CHAR money += 7500
0394: play_music 1 
0318: set_latest_mission_passed 'MIS3'
0110: clear_player $PLAYER_CHAR wanted_level 
030C: set_mission_points += 1 
$PORTLAND_P1_COMPLETED += 1
03F1: pedtype 7 add_threat 1 
0237: set_gang 0 primary_weapon_to 2 secondary_weapon_to 4 
00BC: show_text_highpriority GXT 'MIS3_D' time 7000 flag 1 
02A7: $PORTLAND_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 1150.1073 -454.2015 20.648
create_thread @P2_MIS
gosub @ODD2_SKIP
return

:ODD2_FAIL 
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0 
02A7: $PORTLAND_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 1150.1073 -454.2015 20.648
create_thread @P2_MIS
mission_cleanup
return

:ODD2_CLEANUP 
$ONMISSION = 0
$MISSION_FLAG = 0
$KILL_FLAG0 = 0
$KILL_FLAG1 = 0
$KILL_FLAG2 = 0
$KILL_FLAG3 = 0
0215: destroy_pickup $MISSION_SNIPER
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR0
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR1
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR2
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR3
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR4
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR5
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR6
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR7
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR8
REMOVE_REFERENCES_TO_CAR $MISSION_BOAT1
RELEASE_MODEL #GANG01
RELEASE_MODEL #GANG02 
RELEASE_MODEL #PREDATOR
RELEASE_MODEL #AK47
RELEASE_MODEL #SHOTGUN
0164: disable_marker $MISSION_MARKER0
0164: disable_marker $MISSION_MARKER1
0164: disable_marker $MISSION_MARKER2
0164: disable_marker $MISSION_MARKER3
0164: disable_marker $MISSION_MARKER4
0164: disable_marker $MISSION_MARKER5
014F: stop_timer $TIMER
$TIMER = 0
mission_cleanup
return