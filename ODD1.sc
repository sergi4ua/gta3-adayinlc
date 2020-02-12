:ODD1
thread 'ODD1'
gosub @ODD1_CODE
if 
wasted_or_busted
Jf @ODD1_SKIP 
gosub @ODD1_FAIL

:ODD1_SKIP 
gosub @ODD1_CLEANUP
end_thread

:ODD1_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
REQUEST_MODEL #RCBANDIT
REQUEST_MODEL #TOYZ
REQUEST_MODEL #CHEETAH
REQUEST_MODEL #COP
LOAD_REQUESTED_MODELS

:ODD1_MODELS_AVAILABLE
wait 0
if and
IS_MODEL_AVAILABLE #RCBANDIT
IS_MODEL_AVAILABLE #TOYZ
IS_MODEL_AVAILABLE #CHEETAH
IS_MODEL_AVAILABLE #COP
jf @ODD1_MODELS_AVAILABLE
00A5: $MIS_CAR_TOYZ = create_car #TOYZ at 1170.1609 -468.607 23.1472
0175: set_car $MIS_CAR_TOYZ z_angle_to 274.2
wait 500
fade 1 1500
00BC: show_text_highpriority GXT 'MIS2_1' time 7000 flag 1
0186: $MIS_MARKER_TOYZ = create_marker_above_car $MIS_CAR_TOYZ

:ODD1_OBJ1_LOOP
wait 0
if
0119:   car $MIS_CAR_TOYZ wrecked
then
00BC: text_highpriority 'WRECKED' 5000 ms 1
goto @ODD1_FAIL
end

if
IS_ACTOR_IN_CAR $PLAYER_ACTOR $MIS_CAR_TOYZ
then
0164: disable_marker $MIS_MARKER_TOYZ
goto @ODD1_OBJ2
end

goto @ODD1_OBJ1_LOOP

:ODD1_OBJ2
03E5: text_box 'RCHELP'
00BC: show_text_highpriority GXT 'MIS2_3' time 7000 flag 1  // Text
010C: change_player_into_rc_buggy $PLAYER_CHAR at 1169.5795 -460.6319 23.0359 280.0
$LIVES = 4
$TIMER = 140000
014E: start_timer_at $TIMER
03C4: $LIVES 0 'MIS2_2'
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1

$MIS_FLAG0 = 0
$MIS_FLAG1 = 0
$MIS_FLAG2 = 0
$COUNTER = 0

00A5: $MIS_CAR0 = create_car #CHEETAH at 1128.2947 -585.4283 14.8227
0175: set_car $MIS_CAR0 z_angle_to 380.0
00A5: $MIS_CAR1 = create_car #CHEETAH at 980.363 -766.4414 14.8227
0175: set_car $MIS_CAR1 z_angle_to 90.0
00A5: $MIS_CAR2 = create_car #CHEETAH at 992.9221 -820.7661 14.8227
0175: set_car $MIS_CAR2 z_angle_to 270.0

0129: $MIS_ACTOR0 = create_actor 4 #COP in_car $MIS_CAR0 driverseat
0129: $MIS_ACTOR1 = create_actor 4 #COP in_car $MIS_CAR1 driverseat
0129: $MIS_ACTOR2 = create_actor 4 #COP in_car $MIS_CAR2 driverseat

02AA: set_car $MIS_CAR0 immune_to_nonplayer 1 
02AA: set_car $MIS_CAR1 immune_to_nonplayer 1 
02AA: set_car $MIS_CAR2 immune_to_nonplayer 1 

0186: $MIS_MARKER0 = create_marker_above_car $MIS_CAR0
0186: $MIS_MARKER1 = create_marker_above_car $MIS_CAR1
0186: $MIS_MARKER2 = create_marker_above_car $MIS_CAR2

03FB: set_car $MIS_CAR0 stays_on_current_island 1
03FB: set_car $MIS_CAR1 stays_on_current_island 1
03FB: set_car $MIS_CAR2 stays_on_current_island 1

00A8: set_car $MIS_CAR0 to_psycho_driver
00A8: set_car $MIS_CAR1 to_psycho_driver
00A8: set_car $MIS_CAR2 to_psycho_driver

:ODD1_OBJ2_LOOP
wait 0

if
    8241:   not player $PLAYER_CHAR in_remote_mode
then
    $LIVES -= 1
    01B4: set_player $PLAYER_CHAR control 0
    010C: change_player_into_rc_buggy $PLAYER_CHAR at 1169.5795 -460.6319 23.0359 280.0
    01B4: set_player $PLAYER_CHAR control 1
end

if
    $TIMER == 0
then
00BC: show_text_highpriority GXT 'OUTTIME' time 5000 flag 1 
0409: blow_up_rc_buggy
goto @ODD1_FAIL
end

if
03C6:   current_island == 2
then
0409: blow_up_rc_buggy
end


if
    $LIVES == 0
then
0409: blow_up_rc_buggy
goto @ODD1_FAIL
end

if and
0119:   car $MIS_CAR0 wrecked
$MIS_FLAG0 == 0
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_FLAG0 = 1
$COUNTER += 1
0164: disable_marker $MIS_MARKER0
end

if and
0119:   car $MIS_CAR1 wrecked
$MIS_FLAG1 == 0
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_FLAG1 = 1
$COUNTER += 1
0164: disable_marker $MIS_MARKER1
end

if and
0119:   car $MIS_CAR2 wrecked
$MIS_FLAG2 == 0
then
00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
$MIS_FLAG2 = 1
$COUNTER += 1
0164: disable_marker $MIS_MARKER2
end

if
$COUNTER == 3
then
fade 0 0
wait 2000
fade 1 1500
wait 1000
goto @ODD1_PASS
end

jump @ODD1_OBJ2_LOOP


:ODD1_PASS
01E3: text_1number_styled 'M_PASS' 10000 5000 ms 1 
0109: player $PLAYER_CHAR money += 10000
0394: play_music 1 
0318: set_latest_mission_passed 'MIS2'
0110: clear_player $PLAYER_CHAR wanted_level 
030C: set_mission_points += 1 
$PORTLAND_P1_COMPLETED += 1
02A7: $PORTLAND_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 1150.1073 -454.2015 20.648
create_thread @P2_MIS
gosub @ODD1_SKIP
return

:ODD1_FAIL 
00BA: text_styled 'M_FAIL' 5000 ms 1
02A7: $PORTLAND_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 1150.1073 -454.2015 20.648
create_thread @P2_MIS
$ONMISSION = 0 
mission_cleanup
return

:ODD1_CLEANUP 
014F: stop_timer $TIMER
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0
0164: disable_marker $MIS_MARKER_TOYZ
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
00A6: destroy_car $MIS_CAR0
00A6: destroy_car $MIS_CAR1
00A6: destroy_car $MIS_CAR2
0151: remove_status_text $LIVES
REMOVE_REFERENCES_TO_CAR $MIS_CAR_TOYZ
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR0
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR1
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR2
RELEASE_MODEL #TOYZ
RELEASE_MODEL #CHEETAH
RELEASE_MODEL #RCBANDIT
RELEASE_MODEL #COP
$ONMISSION = 0
mission_cleanup
return