:EIGHT1
thread 'EIGHT1'
gosub @EIGHT1_CODE
if 
wasted_or_busted
Jf @EIGHT1_SKIP 
gosub @EIGHT1_FAIL

:EIGHT1_SKIP 
gosub @EIGHT1_CLEANUP
end_thread

:EIGHT1_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level

:EIGHT1_MODEL_LOAD
023C: load_special_actor 'EIGHT2' 1

:EIGHT1_MODEL_AVAILABLE
wait 0
if
823D:   not special_actor 1 loaded 
jf @EIGHT1_CONTINUE
jump @EIGHT1_MODEL_AVAILABLE

:EIGHT1_CONTINUE
01B4: set_player $PLAYER_CHAR control 0
//035F: set_actor $PLAYER_ACTOR armour_to 0
009A: $MIS_ACTOR = create_actor_pedtype 21 model #SPECIAL01 at 361.0373 -568.2589 25.0
0173: set_actor $MIS_ACTOR z_angle_to 270.0
015F: set_camera_position 366.4979 -568.2222 26.1748 rotation 0.0 0.0 0.0
0160: point_camera 360.8423 -568.2086 26.1 switchstyle 2
TOGGLE_WIDESCREEN TRUE
fade 1 1500
wait 1000
00BC: show_text_highpriority GXT 'MIS5_A' time 4000 flag 1 
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 4000
00BC: show_text_highpriority GXT 'MIS5_B' time 10000 flag 1 
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 10000
00BC: show_text_highpriority GXT 'MIS5_C' time 10000 flag 1 
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 10000
00BC: show_text_highpriority GXT 'MIS5_D' time 4000 flag 1 
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 4000
00BC: show_text_highpriority GXT 'MIS5_E' time 2000 flag 1 
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 2000
00BC: show_text_highpriority GXT 'MIS5_F' time 9000 flag 1 
03F9: make_actors $MIS_ACTOR $PLAYER_ACTOR converse_in 3000 ms
wait 9000
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
009B: destroy_actor_instantly $MIS_ACTOR
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
fade 1 1500
wait 1000
00BC: show_text_highpriority GXT 'MIS5_G' time 10000 flag 1
02A8: $MIS_MARKER_AMMU2 = create_marker 20 at 348.1362 -705.1622 -99.9
03BC: $MIS_SPHERE = create_sphere 348.1362 -705.1622 26.0181 5.5

:EIGHT1_OBJ1
wait 0

if
00FE:   actor $PLAYER_ACTOR 0 348.1362 -705.1622 26.0181 radius 5.5 5.5 5.5
then
jump @EIGHT1_OBJ2
end

goto @EIGHT1_OBJ1

:EIGHT1_OBJ2
0164: disable_marker $MIS_MARKER_AMMU2
03BD: destroy_sphere $MIS_SPHERE
00BC: show_text_highpriority GXT 'MIS5_H' time 5000 flag 1  // Text
032B: $AMMU_FREE0 = create_weapon_pickup #M16 14 ammo 300 at 342.5959 -719.9329 26.4354
032B: $AMMU_FREE1 = create_weapon_pickup #SHOTGUN 14 ammo 300 at 342.7138 -717.933 26.4367
032B: $AMMU_FREE2 = create_weapon_pickup #ROCKET 14 ammo 10 at 342.9033 -714.3789 26.439
0213: $AMMU_FREE3 = create_pickup #BODYARMOUR type 14 at 346.0468 -713.0922 26.4398
032B: $AMMU_FREE4 = create_weapon_pickup #AK47 14 ammo 250 at 349.1266 -713.6445 26.4395

03DC: $MIS_MARKER0 = create_marker_above_pickup $AMMU_FREE0
03DC: $MIS_MARKER1 = create_marker_above_pickup $AMMU_FREE1
03DC: $MIS_MARKER2 = create_marker_above_pickup $AMMU_FREE2
03DC: $MIS_MARKER3 = create_marker_above_pickup $AMMU_FREE3
03DC: $MIS_MARKER4 = create_marker_above_pickup $AMMU_FREE4

$COUNTER = 0

:EIGHT1_OBJ2_LOOP
wait 0

if
0214:   pickup $AMMU_FREE0 picked_up
then
$COUNTER += 1
end

if
0214:   pickup $AMMU_FREE1 picked_up
then
$COUNTER += 1
end

if
0214:   pickup $AMMU_FREE2 picked_up
then
$COUNTER += 1
end

if
0214:   pickup $AMMU_FREE3 picked_up
then
$COUNTER += 1
end

if
0214:   pickup $AMMU_FREE4 picked_up
then
$COUNTER += 1
end

if
$COUNTER == 5
then
00BC: show_text_highpriority GXT 'MIS5_R' time 10000 flag 1  // Text
032B: $AMMU_PAY0 = create_weapon_pickup #M16 1 ammo 300 at 342.5959 -719.9329 26.4354
032B: $AMMU_PAY1 = create_weapon_pickup #SHOTGUN 1 ammo 300 at 342.7138 -717.933 26.4367
032B: $AMMU_PAY2 = create_weapon_pickup #ROCKET 1 ammo 10 at 342.9033 -714.3789 26.439
0213: $AMMU_PAY3 = create_pickup #BODYARMOUR type 1 at 346.0468 -713.0922 26.4398
032B: $AMMU_PAY4 = create_weapon_pickup #AK47 1 ammo 250 at 349.1266 -713.6445 26.4395
goto @EIGHT1_PASS
end

goto @EIGHT1_OBJ2_LOOP

:EIGHT1_PASS
wait 0
0110: clear_player $PLAYER_CHAR wanted_level
00BA: text_styled 'M_PASS2' 5000 ms 1
0394: play_music 1 
$STAUNTON_P2_COMPLETED += 1
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748
0318: set_latest_mission_passed 'MIS5'
030C: set_mission_points += 1
create_thread @S1_MIS
gosub @EIGHT1_SKIP
return

:EIGHT1_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0 
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748
create_thread @S1_MIS
mission_cleanup
return

:EIGHT1_CLEANUP 
$ONMISSION = 0
009B: destroy_actor_instantly $MIS_ACTOR
03BD: destroy_sphere $MIS_SPHERE
0164: disable_marker $MIS_MARKER_AMMU2
0296: unload_special_actor 1
$COUNTER = 0
$MIS_FLAG0 = 0
$MIS_FLAG1 = 0
$MIS_FLAG2 = 0
$MIS_FLAG3 = 0
$MIS_FLAG4 = 0
0215: destroy_pickup $AMMU_FREE0
0215: destroy_pickup $AMMU_FREE1
0215: destroy_pickup $AMMU_FREE2
0215: destroy_pickup $AMMU_FREE3
0215: destroy_pickup $AMMU_FREE4
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
0164: disable_marker $MIS_MARKER3
0164: disable_marker $MIS_MARKER4
0164: disable_marker $MIS_MARKER_AMMU2
mission_cleanup
return