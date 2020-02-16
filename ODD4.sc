:ODD4
thread 'ODD4'
gosub @ODD4_CODE
if 
wasted_or_busted
Jf @ODD4_SKIP 
gosub @ODD4_FAIL

:ODD4_SKIP 
gosub @ODD4_CLEANUP
end_thread

:ODD4_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
REQUEST_MODEL #CHEETAH
REQUEST_MODEL #FEMALE02

:ODD4_MODEL_AVAILABLE
wait 0
if and
IS_MODEL_AVAILABLE #CHEETAH
IS_MODEL_AVAILABLE #FEMALE02
jf @ODD4_MODEL_AVAILABLE
01B4: set_player $PLAYER_CHAR control 0
TOGGLE_WIDESCREEN TRUE
03BA: clear_cars_from_cube 239.5074 -613.5795 26.1682 144.3333 -627.5867 59.4458
0395: clear_area 1 at 189.1489 -621.3373 range -999.99 100.0 
00A5: $MIS_CAR = create_car #CHEETAH at 239.6569 -621.7064 26.0182
0175: set_car $MIS_CAR z_angle_to 90.0
0129: $MIS_ACTOR = create_actor 4 #FEMALE02 in_car $MIS_CAR driverseat
02C2: car $MIS_CAR drive_to_point 190.8472 -621.2958 26.0172
015F: set_camera_position 222.6253 -629.1842 35.0 rotation 0.0 0.0 0.0
0158: camera_on_vehicle $MIS_CAR 15 switchstyle 2
fade 1 1500

:ODD4_CUTSCENE_LOOP
wait 0
if
01AF:   car $MIS_CAR 0 190.8472 -621.2958 26.0172 radius 2.0 2.0 2.0
then
wait 1000
01D3: actor $MIS_ACTOR leave_car $MIS_CAR
009C: set_actor $MIS_ACTOR wander_direction 0
goto @ODD4_CONTINUE
end

if
0119:   car $MIS_CAR wrecked
then
goto @ODD4_CUTSCENE_FUCKED
end

goto @ODD4_CUTSCENE_LOOP

:ODD4_CONTINUE
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
01B4: set_player $PLAYER_CHAR control 1
00BC: show_text_highpriority GXT 'MIS7_A' time 5000 flag 1  // Text
0186: $MIS_MARKER0 = create_marker_above_car $MIS_CAR

$MIS_FLAG_MARKER_CREATED = 0
$MIS_CHECKPOINT = 0

:ODD4_OBJ1
wait 0
if
00DB:   actor $PLAYER_ACTOR in_car $MIS_CAR
then
00BC: show_text_highpriority GXT 'MIS7_B' time 5000 flag 1  // Text
0164: disable_marker $MIS_MARKER0
$TIMER = 120000
014E: start_timer_at $TIMER
02A8: $MIS_MARKER2 = create_marker 5 at 214.8619 -1590.4972 25.6257
jump @ODD4_OBJ2
end

if
0119:   car $MIS_CAR wrecked
then
00BB: show_text_lowpriority GXT 'MIS7_C' time 4000 flag 1 
goto @ODD4_FAIL
end

goto @ODD4_OBJ1

:ODD4_OBJ2
wait 0

if 
$MIS_CHECKPOINT == 0
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 121.8303 -622.0559 25.4891
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 121.8303 -622.0559 25.4891
    end
    
    if
       01AF:   car $MIS_CAR 0 121.8303 -622.0559 25.4891 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 1
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 121.3313 -923.8566 25.4771
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 121.3313 -923.8566 25.4771
    end
    
    if
       01AF:   car $MIS_CAR 0 121.3313 -923.8566 25.4771 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 2
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point -71.8259 -933.2885 25.6381
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at -71.8259 -933.2885 25.6381
    end
    
    if
       01AF:   car $MIS_CAR 0 -71.8259 -933.2885 25.6381 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 3
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point -135.5665 -1367.437 25.4771
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at -135.5665 -1367.437 25.4771
    end
    
    if
       01AF:   car $MIS_CAR 0 -135.5665 -1367.437 25.4771 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 4
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 43.0641 -1362.4424 25.4773
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 43.0641 -1362.4424 25.4773
    end
    
    if
       01AF:   car $MIS_CAR 0 43.0641 -1362.4424 25.4773 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 5
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 42.7588 -1474.097 25.4773
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 42.7588 -1474.097 25.4773
    end
    
    if
       01AF:   car $MIS_CAR 0 42.7588 -1474.097 25.4773 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 6
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 146.2165 -1451.4484 25.4749
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 146.2165 -1451.4484 25.4749
    end
    
    if
       01AF:   car $MIS_CAR 0 146.2165 -1451.4484 25.4749 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 7
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 148.7974 -933.4683 25.6354
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 148.7974 -933.4683 25.6354
    end
    
    if
       01AF:   car $MIS_CAR 0 148.7974 -933.4683 25.6354 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 8
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point -17.7298 -863.5958 25.6038
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at -17.7298 -863.5958 25.6038
    end
    
    if
       01AF:   car $MIS_CAR 0 -17.7298 -863.5958 25.6038 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 9
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point -91.6888 -866.4098 15.3961
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at -91.6888 -866.4098 15.3961
    end
    
    if
       01AF:   car $MIS_CAR 0 -91.6888 -866.4098 15.3961 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if 
$MIS_CHECKPOINT == 10
then
024F: create_corona 7.0 6 0 with_color 0 0 100 at_point 214.8619 -1590.4972 25.6257
    if
        $MIS_FLAG_MARKER_CREATED == 0
    then
        $MIS_FLAG_MARKER_CREATED = 1
        018A: $MIS_MARKER1 = create_checkpoint_at 214.8619 -1590.4972 25.6257
    end
    
    if
       01AF:   car $MIS_CAR 0 214.8619 -1590.4972 25.6257 radius 8.0 8.0 5.0
    then
        00A0: store_actor $PLAYER_ACTOR position_to $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        018C: play_sound 94 at $MIS_TEMPX $MIS_TEMPY $MIS_TEMPZ
        $MIS_CHECKPOINT += 1
        $MIS_FLAG_MARKER_CREATED = 0
        0164: disable_marker $MIS_MARKER1
    end 
    
    if
        8442:   not player $PLAYER_CHAR in_car $MIS_CAR
    then
        goto @ODD4_FAIL
    end
end

if
$MIS_CHECKPOINT == 11
then
TEXT_CLEAR_ALL
goto @ODD4_PASS
end

if
$TIMER == 0
then
00BB: show_text_lowpriority GXT 'OUTTIME' time 4000 flag 1  // Text
goto @ODD4_FAIL
end

goto @ODD4_OBJ2

:ODD4_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 10000 5000 ms 1 
0109: player $PLAYER_CHAR money += 10000
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
030C: set_mission_points += 1
0318: set_latest_mission_passed 'MIS7'
$STAUNTON_BONUS_MISSION0 += 1
02A7: $STAUNTON_MISSION_MARKER3 = create_icon_marker_and_sphere 9 at 79.9823 -958.9354 25.1681
create_thread @S2_MIS
gosub @ODD4_SKIP
return

:ODD4_CUTSCENE_FUCKED
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
01B4: set_player $PLAYER_CHAR control 1

:ODD4_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0 
02A7: $STAUNTON_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 196.8638 -628.8686 25.1673 
create_thread @S2_MIS
mission_cleanup
return

:ODD4_CLEANUP 
RELEASE_MODEL #FEMALE02
RELEASE_MODEL #CHEETAH
REMOVE_REFERENCES_TO_ACTOR $MIS_ACTOR
REMOVE_REFERENCES_TO_CAR $MIS_CAR
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
0164: disable_marker $MIS_MARKER2
STOP_TIMER $TIMER
$ONMISSION = 0
mission_cleanup
return