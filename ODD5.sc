:ODD5
thread 'ODD5'
gosub @ODD5_CODE
if 
wasted_or_busted
Jf @ODD5_SKIP 
gosub @ODD5_FAIL

:ODD5_SKIP 
gosub @ODD5_CLEANUP
end_thread

:ODD5_CODE

// 79.9721 -955.2438 26.1681 camera pos 1
// 80.1499 -962.3228 26.1681 camera pos 1 pointing

// 79.984 -959.3137 26.1681 player pos in cutscene
// 180.0 player angle in cutscene

// 195.3151 76.395 15.4898 car 1 pos
// 268.90 car 1 angle

// 248.3576 -1172.4127 19.9316 car 2 pos
// 180.0 car 2 angle

// 244.9073 -1187.2256 20.4611 angry 1 pos
// 202.6 angry 1 angle

// 241.6412 -1198.038 20.4585 angry 2 pos
// 200.0 angry 2 angle

// -726.0906 -290.6319 18.4909 car 3 pos   // unused
// 62.96 car 3 angle

// 1053.2086 -209.0803 4.5379 car 4 pos
// 0.0 car 4 angle

const
NULL = 0
NULL_CAR = -1
end

increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
wait 1000
0169: set_fade_color 0 0 0
0055: put_player $PLAYER_CHAR at 79.984 -959.3137 25.0
0171: set_player $PLAYER_CHAR z_angle_to 180.0
fade 1 1500

01B4: set_player $PLAYER_CHAR control 0
TOGGLE_WIDESCREEN TRUE
015F: set_camera_position 79.9 -955.24 26.16 rotation 0.0 0.0 0.0
0160: point_camera 80.14 -962.32 26.16 switchstyle 2

wait 1500
00BC: show_text_highpriority GXT 'MIS10_0' time 2000 flag 1 
wait 2000
00BC: show_text_highpriority GXT 'MIS10_1' time 5000 flag 1 
wait 5000
00BC: show_text_highpriority GXT 'MIS10_2' time 5000 flag 1 
wait 5000

fade 0 1500
wait 1500
01B4: set_player $PLAYER_CHAR control 1
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT

:ODD5_REQUEST_MODELS
REQUEST_MODEL #MALE02
REQUEST_MODEL #GANG11
REQUEST_MODEL #BLISTA
REQUEST_MODEL #CHEETAH
REQUEST_MODEL #SENTINEL
REQUEST_MODEL #SHOTGUN

:ODD5_MODELS_AVAILABLE
wait 0
if and
IS_MODEL_AVAILABLE #MALE02
IS_MODEL_AVAILABLE #GANG11
IS_MODEL_AVAILABLE #INFERNUS
IS_MODEL_AVAILABLE #CHEETAH
IS_MODEL_AVAILABLE #SENTINEL
IS_MODEL_AVAILABLE #SHOTGUN
jf @ODD5_MODELS_AVAILABLE

$CAR1_HEALTH = 0
$CAR2_HEALTH = 0
$CAR3_HEALTH = 0
$MIS_MONEY = 5000  // base money
$MIS_TIMER = 420000  // timer

:ODD5_INIT_CARS_AND_PEDS
// first car
00A5: $MIS_CAR0 = create_car #INFERNUS at 195.3151 76.395 15.4898
SET_CAR_HEADING $MIS_CAR0 268.9
// second car
00A5: $MIS_CAR1 = create_car #CHEETAH at 248.3576 -1172.4127 19.9316
SET_CAR_HEADING $MIS_CAR1 180.0
// third and final car
00A5: $MIS_CAR2 = create_car #SENTINEL at 1053.2086 -209.0803 4.5379
SET_CAR_HEADING $MIS_CAR2 0.0

021B: set_garage $GARAGE_KM2 to_accept_car NULL_CAR
// 018A: $MIS_CHKPNT = create_checkpoint_at 375.7 -506.6 26.0

// create angry peds
009A: $MIS_ANGRY1 = create_actor_pedtype 12 model #GANG11 at 244.9073 -1187.2256 20.4
SET_CHAR_HEADING $MIS_ANGRY1 202.6

009A: $MIS_ANGRY2 = create_actor_pedtype 12 model #GANG11 at 241.64 -1198.0 20.45
SET_CHAR_HEADING $MIS_ANGRY2 200.00

01B2: give_actor $MIS_ANGRY1 weapon 4 ammo 999
01B2: give_actor $MIS_ANGRY2 weapon 4 ammo 999

$FLAG_CAR1_MARKER = 0
$FLAG_CAR2_MARKER = 0
$FLAG_CAR3_MARKER = 0

0129: $MIS_ACTOR1 = create_actor 4 #MALE02 in_car $MIS_CAR0 driverseat
0129: $MIS_ACTOR2 = create_actor 4 #MALE02 in_car $MIS_CAR2 driverseat

0186: $MIS_MARKER1 = create_marker_above_car $MIS_CAR0
0186: $MIS_MARKER2 = create_marker_above_car $MIS_CAR1
0186: $MIS_MARKER3 = create_marker_above_car $MIS_CAR2

$FLAG_CAR1_MARKER = 1
$FLAG_CAR2_MARKER = 1
$FLAG_CAR3_MARKER = 1

00A5: $MIS_SURPRISE_CAR = create_car #CHEETAH at 70.5 -945.79 25.5
SET_CAR_HEADING $MIS_SURPRISE_CAR 269.0

014E: start_timer_at $MIS_TIMER  // timer

0@ = 0 // surprise car
1@ = 0 // if peds spotted player
2@ = 0 // if car in garage

TOGGLE_WIDESCREEN FALSE
wait 500

//03F0: enable_text_draw 1 // debug

fade 1 1500

// MAIN OBJECTIVE

:ODD5_OBJ1_LOOP
wait 0
{ DEBUG START }
//045B: draw_text_2numbers 10.0 20.0 GXT 'DBG_NUM' numbers $CAR1_HEALTH $CAR2_HEALTH
{ DEBUG END }

// get health of the car

IF
IS_CAR_STILL_ALIVE $MIS_CAR0
THEN
0227: $CAR1_HEALTH = car $MIS_CAR0 health
END

IF
IS_CAR_STILL_ALIVE $MIS_CAR1
THEN
0227: $CAR2_HEALTH = car $MIS_CAR1 health
END

IF
IS_CAR_STILL_ALIVE $MIS_CAR2
THEN
0227: $CAR3_HEALTH = car $MIS_CAR2 health
END

// moon rocket car :D

if and 
    0@ == 0
    IS_PLAYER_IN_CAR $PLAYER_CHAR $MIS_SURPRISE_CAR
then
    0@ = 1
    014D: text_pager 'MIS10_6' 140 2 0 // 10% mlp reference :D 
    16@ = 0   // start TIMERA
end

if and
    0@ == 1
    8119: $MIS_SURPRISE_CAR // not car destroyed
    16@ > 14999
then
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    020B: explode_car $MIS_SURPRISE_CAR
    0@ = 2
    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_SURPRISE_CAR
end

// end of rocket car

if
$MIS_TIMER == 0
then
00BC: show_text_highpriority GXT 'OUTTIME' time 5000 flag 1 
goto @ODD5_FAIL
end

if
1@ == 0
then
    if or
        0123:   actor $MIS_ANGRY1 spotted_player $PLAYER_CHAR
        0123:   actor $MIS_ANGRY2 spotted_player $PLAYER_CHAR
    then
        1@ = 1
        01CA: actor $MIS_ANGRY1 kill_player $PLAYER_CHAR
        01CA: actor $MIS_ANGRY2 kill_player $PLAYER_CHAR
    end
end

// check if any car destroyed

if
    IS_CAR_WRECKED $MIS_CAR0
then
    if
    not $FLAG_CAR1_MARKER == 2
    then 
        goto @ODD5_FAIL
    end
end

if
    IS_CAR_WRECKED $MIS_CAR1
then
    if
    not $FLAG_CAR2_MARKER == 2
    then 
        goto @ODD5_FAIL
    end
end

if
    IS_CAR_WRECKED $MIS_CAR2
then
    if
    not $FLAG_CAR3_MARKER == 2
    then 
    goto @ODD5_FAIL
    end
end
    

if and
    IS_PLAYER_IN_CAR $PLAYER_CHAR $MIS_CAR0
    $FLAG_CAR1_MARKER == 1
then
    $FLAG_CAR1_MARKER = 0
    021B: set_garage $GARAGE_KM2 to_accept_car $MIS_CAR0
    gosub @ODD5_REMOVE_MARKERS
    018A: $MIS_CHKPNT = create_checkpoint_at 375.7 -506.6 26.0
    goto @ODD5_CAR1
end

if and
    IS_PLAYER_IN_CAR $PLAYER_CHAR $MIS_CAR1
    $FLAG_CAR2_MARKER == 1
then
    $FLAG_CAR2_MARKER = 0
    021B: set_garage $GARAGE_KM2 to_accept_car $MIS_CAR1
    gosub @ODD5_REMOVE_MARKERS
    018A: $MIS_CHKPNT = create_checkpoint_at 375.7 -506.6 26.0
    goto @ODD5_CAR2
end

if and
    IS_PLAYER_IN_CAR $PLAYER_CHAR $MIS_CAR2
    $FLAG_CAR3_MARKER == 1
then
    $FLAG_CAR3_MARKER = 0
    021B: set_garage $GARAGE_KM2 to_accept_car $MIS_CAR2
    gosub @ODD5_REMOVE_MARKERS
    018A: $MIS_CHKPNT = create_checkpoint_at 375.7 -506.6 26.0
    goto @ODD5_CAR3
end

if and
$FLAG_CAR1_MARKER == 2
$FLAG_CAR2_MARKER == 2
$FLAG_CAR3_MARKER == 2
then
goto @ODD5_PASS
end

goto @ODD5_OBJ1_LOOP

:ODD5_CAR1 // first car delivery
wait 0

// if timer == 0 fail the mission
if
$MIS_TIMER == 0
then
00BC: show_text_highpriority GXT 'OUTTIME' time 5000 flag 1 
goto @ODD5_FAIL
end

IF
IS_CAR_STILL_ALIVE $MIS_CAR0
THEN
0227: $CAR1_HEALTH = car $MIS_CAR0 health
END

if and
    is_car_upsidedown $MIS_CAR0
    IS_CAR_STOPPED $MIS_CAR0
then
    PRINT_NOW 'UPSIDE' 5000 1 
    goto @ODD5_FAIL
end

if
    IS_CAR_WRECKED $MIS_CAR0
then
    PRINT_NOW 'WRECKED' 5000 1
    goto @ODD5_FAIL
end

if
    80DC:   not player $PLAYER_CHAR driving $MIS_CAR0
then
    2@ = 0
    gosub @ODD5_REMOVE_MARKERS
    gosub @ODD5_RESTORE_MARKERS
    goto @ODD5_OBJ1_LOOP
end

if and
    0422:   garage_contain_car $GARAGE_KM2 $MIS_CAR0
    2@ == 0
then     
     00BC: show_text_highpriority GXT 'GARAGE1' time 5000 flag 1
     jump @ODD5_CAR1_INGARAGE
end

goto @ODD5_CAR1

:ODD5_CAR1_INGARAGE
wait 0

if and
    80e0: $PLAYER_CHAR
    021C:   car_inside_garage $GARAGE_KM2
then
    $FLAG_CAR1_MARKER = 2
    021B: set_garage $GARAGE_KM2 to_accept_car NULL_CAR
    00BC: show_text_highpriority GXT 'MIS10_3' time 5000 flag 1
    add_one_off_sound 94 380.25 -506.75 26.0625
    $CAR1_HEALTH *= 2
    0058: $MIS_MONEY += $CAR1_HEALTH
    gosub @ODD5_REMOVE_MARKERS
    gosub @ODD5_RESTORE_MARKERS
    goto @ODD5_OBJ1_LOOP
end

if
    IS_CAR_STOPPED_IN_AREA_3D $MIS_CAR0 0 377.25 -511.375 25.0625 383.6875 -502.0 30.0 
then
    0000: NOP
else
    goto @ODD5_CAR1
end

goto @ODD5_CAR1_INGARAGE

:ODD5_CAR2 // second car delivery
wait 0

// if timer == 0 fail the mission
if
$MIS_TIMER == 0
then
00BC: show_text_highpriority GXT 'OUTTIME' time 5000 flag 1 
goto @ODD5_FAIL
end

IF
IS_CAR_STILL_ALIVE $MIS_CAR1
THEN
0227: $CAR2_HEALTH = car $MIS_CAR1 health
END

if and
    is_car_upsidedown $MIS_CAR1
    IS_CAR_STOPPED $MIS_CAR1
then
    PRINT_NOW 'UPSIDE' 5000 1 
    goto @ODD5_FAIL
end

if
    IS_CAR_WRECKED $MIS_CAR1
then
    PRINT_NOW 'WRECKED' 5000 1
    goto @ODD5_FAIL
end

if
    80DC:   not player $PLAYER_CHAR driving $MIS_CAR1
then
    2@ = 0
    gosub @ODD5_REMOVE_MARKERS
    gosub @ODD5_RESTORE_MARKERS
    goto @ODD5_OBJ1_LOOP
end

if and
    0422:   garage_contain_car $GARAGE_KM2 $MIS_CAR1
    2@ == 0
then     
     00BC: show_text_highpriority GXT 'GARAGE1' time 5000 flag 1
     jump @ODD5_CAR2_INGARAGE
end

goto @ODD5_CAR2

:ODD5_CAR2_INGARAGE
wait 0

if and
    80e0: $PLAYER_CHAR
    021C:   car_inside_garage $GARAGE_KM2
then
    $FLAG_CAR2_MARKER = 2
    021B: set_garage $GARAGE_KM2 to_accept_car NULL_CAR
    00BC: show_text_highpriority GXT 'MIS10_3' time 5000 flag 1
    add_one_off_sound 94 380.25 -506.75 26.0625
    $CAR2_HEALTH *= 3
    0058: $MIS_MONEY += $CAR2_HEALTH
    gosub @ODD5_REMOVE_MARKERS
    gosub @ODD5_RESTORE_MARKERS
    goto @ODD5_OBJ1_LOOP
end

if
    IS_CAR_STOPPED_IN_AREA_3D $MIS_CAR1 0 377.25 -511.375 25.0625 383.6875 -502.0 30.0 
then
    0000: NOP
else
    goto @ODD5_CAR2
end

goto @ODD5_CAR2_INGARAGE

:ODD5_CAR3 // first car delivery
wait 0

// if timer == 0 fail the mission
if
$MIS_TIMER == 0
then
00BC: show_text_highpriority GXT 'OUTTIME' time 5000 flag 1 
goto @ODD5_FAIL
end

IF
IS_CAR_STILL_ALIVE $MIS_CAR2
THEN
0227: $CAR3_HEALTH = car $MIS_CAR2 health
END

if and
    is_car_upsidedown $MIS_CAR2
    IS_CAR_STOPPED $MIS_CAR2
then
    PRINT_NOW 'UPSIDE' 5000 1 
    goto @ODD5_FAIL
end

if
    IS_CAR_WRECKED $MIS_CAR2
then
    PRINT_NOW 'WRECKED' 5000 1
    goto @ODD5_FAIL
end

if
    80DC:   not player $PLAYER_CHAR driving $MIS_CAR2
then
    2@ = 0
    gosub @ODD5_REMOVE_MARKERS
    gosub @ODD5_RESTORE_MARKERS
    goto @ODD5_OBJ1_LOOP
end

if and
    0422:   garage_contain_car $GARAGE_KM2 $MIS_CAR2
    2@ == 0
then     
     00BC: show_text_highpriority GXT 'GARAGE1' time 5000 flag 1
     jump @ODD5_CAR3_INGARAGE
end

goto @ODD5_CAR3

:ODD5_CAR3_INGARAGE
wait 0

if and
    80e0: $PLAYER_CHAR
    021C:   car_inside_garage $GARAGE_KM2
then
    $FLAG_CAR3_MARKER = 2
    021B: set_garage $GARAGE_KM2 to_accept_car NULL_CAR
    00BC: show_text_highpriority GXT 'MIS10_3' time 5000 flag 1
    add_one_off_sound 94 380.25 -506.75 26.0625
    $CAR3_HEALTH *= 2
    0058: $MIS_MONEY += $CAR3_HEALTH
    gosub @ODD5_REMOVE_MARKERS
    gosub @ODD5_RESTORE_MARKERS
    goto @ODD5_OBJ1_LOOP
end

if
    IS_CAR_STOPPED_IN_AREA_3D $MIS_CAR2 0 377.25 -511.375 25.0625 383.6875 -502.0 30.0 
then
    0000: NOP
else
    goto @ODD5_CAR3
end

goto @ODD5_CAR3_INGARAGE

:ODD5_REMOVE_MARKERS
REMOVE_BLIP $MIS_CHKPNT
REMOVE_BLIP $MIS_MARKER1
REMOVE_BLIP $MIS_MARKER2
REMOVE_BLIP $MIS_MARKER3
return

:ODD5_RESTORE_MARKERS   // only gosub
if
not $FLAG_CAR1_MARKER == 2
then
0186: $MIS_MARKER1 = create_marker_above_car $MIS_CAR0
$FLAG_CAR1_MARKER = 1
end

if
not $FLAG_CAR2_MARKER == 2
then
0186: $MIS_MARKER2 = create_marker_above_car $MIS_CAR1
$FLAG_CAR2_MARKER = 1
end

if 
not $FLAG_CAR3_MARKER == 2
then
0186: $MIS_MARKER3 = create_marker_above_car $MIS_CAR2
$FLAG_CAR3_MARKER = 1
end
return

:ODD5_PASS
wait 0
01E3: text_1number_styled 'M_PASS' $MIS_MONEY 5000 ms 1 
0109: player $PLAYER_CHAR money += $MIS_MONEY
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
REMOVE_BLIP $STAUNTON_MISSION_MARKER3
0318: set_latest_mission_passed 'MIS10'
gosub @ODD5_SKIP
return

:ODD5_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0 
create_thread @S2_MIS
mission_cleanup
return

:ODD5_CLEANUP 
021B: set_garage $GARAGE_KM2 to_accept_car -1
STOP_TIMER $MIS_TIMER
REMOVE_BLIP $MIS_CHKPNT
REMOVE_BLIP $MIS_MARKER1
REMOVE_BLIP $MIS_MARKER2
REMOVE_BLIP $MIS_MARKER3
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR0
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR1
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR2
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ANGRY1
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ANGRY2
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR1
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR2
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_SURPRISE_CAR
$FLAG_CAR1_MARKER = 0
$FLAG_CAR2_MARKER = 0
$FLAG_CAR3_MARKER = 0
$MIS_MONEY = 0
$MIS_TIMER = 0
$ONMISSION = 0
mission_cleanup
return