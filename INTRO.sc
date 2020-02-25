:INTRO
thread 'INTRO'
$ONMISSION = 1
SET_CAR_DENSITY_MULTIPLIER 0.0
REQUEST_MODEL #BUS

:INTRO_1_LOAD
wait 0
if
IS_PLAYER_PLAYING $PLAYER_CHAR
jf @INTRO_1_LOAD
if
IS_MODEL_AVAILABLE #BUS
jf @INTRO_1_LOAD
TOGGLE_WIDESCREEN TRUE
03F7: load_island_data 2
0055: put_player $PLAYER_CHAR at -651.2341 -39.4804 17.0
SET_PLAYER_HEADING $PLAYER_CHAR 182.77
01B4: set_player $PLAYER_CHAR control 0
015F: set_camera_position -650.0621 -61.6487 18.7114 rotation 0.0 0.0 0.0
0160: point_camera -650.5159 -57.1106 18.7114 switchstyle 2
00A5: $INTRO_CAR = create_car #BUS at -606.0174 -54.8576 17.7
SET_CAR_HEADING $INTRO_CAR 93.30
00A7: car $INTRO_CAR drive_to -646.5207 -55.2726 18.7114
00AD: set_car $INTRO_CAR max_speed_to 40.0
00AF: set_car $INTRO_CAR driver_behaviour_to 8
00AE: unknown_set_car $INTRO_CAR to_ignore_traffic_lights 2

16@ = 0
0@ = 0 
fade 1 1500
00BA: show_text_styled GXT 'INTR_IT' time 4000 style 2  // Text   
00BC: show_text_highpriority GXT 'MP_SKIP' time 10000 flag 1  // Text

:INTRO_1
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
goto @INTRO_END
end

if
    00E1:   player 0 pressed_button 14
then
    goto @INTRO_DEBUG_END
end

if and
    01AD:   car $INTRO_CAR sphere 0 near_point -646.5207 -55.2726 radius 5.0 5.0
    0@ == 0
then
    0@ = 1
    01D4: actor $PLAYER_ACTOR go_to_car $INTRO_CAR and_enter_it_as_a_passenger
end

if and
    1@ == 0
    IS_CHAR_IN_CAR $PLAYER_ACTOR $INTRO_CAR
then
    1@ = 1
    00A7: car $INTRO_CAR drive_to -693.3555 -26.6197 18.7114
    16@ = 0
end

if and
    1@ == 1
    16@ > 5999
then
    fade 0 1500
    wait 1500
    REQUEST_MODEL #MOD_MAN
    REQUEST_MODEL #COLT45
    REQUEST_MODEL #COLUMB
    LOAD_ALL_MODELS_NOW
    00A5: $INTRO_CAR2 = create_car #COLUMB at -891.7151 166.3344 48.7114
    SET_CAR_HEADING $INTRO_CAR2 202.52
    0325: $INTRO_FIRE = create_car $INTRO_CAR2 fire
    009A: $INTRO_MAN1 = create_actor_pedtype 4 model #MOD_MAN at -878.5916 163.3193 48.8614
    009A: $INTRO_MAN2 = create_actor_pedtype 4 model #MOD_MAN at -881.123 169.9009 48.7114
    009A: $INTRO_MAN3 = create_actor_pedtype 4 model #MOD_MAN at -891.9629 159.3902 48.7114
    009A: $INTRO_MAN4 = create_actor_pedtype 4 model #MOD_MAN at -895.8581 164.8952 48.7114
    01B2: give_actor $INTRO_MAN1 weapon 2 ammo 9999
    01B2: give_actor $INTRO_MAN2 weapon 2 ammo 9999
    01B2: give_actor $INTRO_MAN3 weapon 2 ammo 9999
    01B2: give_actor $INTRO_MAN4 weapon 2 ammo 9999
    01C9: actor $INTRO_MAN1 kill_actor $INTRO_MAN2
    01C9: actor $INTRO_MAN2 kill_actor $INTRO_MAN3
    01C9: actor $INTRO_MAN3 kill_actor $INTRO_MAN1
    01C9: actor $INTRO_MAN4 kill_actor $INTRO_MAN2
    0223: set_actor $INTRO_MAN1 health_to 3000
    0223: set_actor $INTRO_MAN2 health_to 3000
    0223: set_actor $INTRO_MAN3 health_to 3000
    0223: set_actor $INTRO_MAN4 health_to 3000
    00AB: put_car $INTRO_CAR at -789.5468 227.6905 48.7114
    SET_CAR_HEADING $INTRO_CAR 116.2
    wait 1000
    015F: set_camera_position -774.0798 240.4008 64.0747 rotation 0.0 0.0 0.0
    0158: camera_on_vehicle $INTRO_CAR 15 switchstyle 2
    02C2: car $INTRO_CAR drive_to_point -1003.4503 121.0505 48.7114
    0@ = 0
    fade 1 1500
    16@ = 0
    goto @INTRO_2
end

goto @INTRO_1

:INTRO_2
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
goto @INTRO_END
end

if
    00E1:   player 0 pressed_button 14
then
    goto @INTRO_DEBUG_END
end

if and
    0@ == 0
    16@ > 4999
then
    0@ = 1
    00BA: show_text_styled GXT 'ADAYLC' time 4000 style 4
    015F: set_camera_position -911.7717 127.8728 60.6479 rotation 0.0 0.0 0.0
    0158: camera_on_vehicle $INTRO_CAR 15 switchstyle 2
    16@ = 0
end

if and
  //01AD:   car $INTRO_CAR sphere 0 near_point -1005.8351 120.737 radius 7.0 7.0   obsolete
  0@ == 1
  16@ > 4999 
then
    020B: explode_car $INTRO_CAR2
    fade 0 1500
    wait 1500
    MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN1
    MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN2
    MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN3
    MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN4
    MARK_CAR_AS_NO_LONGER_NEEDED $INTRO_CAR2
    02D1: remove_fire $INTRO_FIRE
    release_model #COLUMB
    release_model #COLT45
    release_model #MOD_MAN
    request_model #GANG01
    request_model #GANG02
    LOAD_ALL_MODELS_NOW
    wait 50
    03CB: set_camera -579.7874 1074.9075 37.0
    009A: $INTRO_MAN1 = create_actor_pedtype 4 model #GANG01 at -587.6288 1074.3063 37.9162
    SET_CHAR_HEADING $INTRO_MAN1 3.0
    009A: $INTRO_MAN2 = create_actor_pedtype 4 model #GANG02 at -587.7251 1078.8727 37.9162
    SET_CHAR_HEADING $INTRO_MAN2 184.90
    015F: set_camera_position -579.7874 1074.9075 37.9162 rotation 0.0 0.0 0.0
    0159: camera_on_ped $INTRO_MAN1 15 switchstyle 2
    wait 1000
    fade 1 1500
    wait 1500
    16@ = 0
    0@ = 0
    goto @INTRO_3
end

goto @INTRO_2

:INTRO_3
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
goto @INTRO_END
end

if
    00E1:   player 0 pressed_button 14
then
    goto @INTRO_DEBUG_END
end

if and
    0@ == 0
    16@ > 1
then
    03F9: make_actors $INTRO_MAN1 $INTRO_MAN2 converse_in 4000 ms
    00BC: show_text_highpriority GXT 'INTR_AA' time 4000 flag 1
    0@ += 1
    16@ = 0
end

if and
    0@ == 1
    16@ > 3999
then
    03F9: make_actors $INTRO_MAN1 $INTRO_MAN2 converse_in 4000 ms
    00BC: show_text_highpriority GXT 'INTR_AB' time 4000 flag 1
    0159: camera_on_ped $INTRO_MAN2 15 switchstyle 1
    0@ += 1
    16@ = 0
end

if and
    0@ == 2
    16@ > 3999
then
    03F9: make_actors $INTRO_MAN1 $INTRO_MAN2 converse_in 4000 ms
    00BC: show_text_highpriority GXT 'INTR_AC' time 4000 flag 1
    0159: camera_on_ped $INTRO_MAN1 15 switchstyle 1
    0@ += 1
    16@ = 0
end

if and
    0@ == 3
    16@ > 3999
then
    fade 0 1500
    wait 2000
    MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN1
    MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN2
    RELEASE_MODEL #GANG01
    RELEASE_MODEL #GANG02
    03CB: set_camera -873.7252 -292.4826 33.2563
    00AB: put_car $INTRO_CAR at -873.7252 -292.4826 33.2563
    SET_CAR_HEADING $INTRO_CAR 271.71
    wait 1000
    00A7: car $INTRO_CAR drive_to -765.6104 -295.2536 19.3345
    015F: set_camera_position -775.2253 -276.2091 36.7752 rotation 0.0 0.0 0.0
    0158: camera_on_vehicle $INTRO_CAR 15 switchstyle 2
    fade 1 1500
    16@ = 0
    0@ = 0
    goto @INTRO_4
end

goto @INTRO_3

:INTRO_4
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
goto @INTRO_END
end

if
    00E1:   player 0 pressed_button 14
then
    goto @INTRO_DEBUG_END
end

if and
    0@ == 0
    16@ > 8999
then
    fade 0 1500
    wait 1500
    00AB: put_car $INTRO_CAR at 45.0531 -1138.6775 26.0181
    SET_CAR_HEADING $INTRO_CAR 0.0
    wait 1000
    00A7: car $INTRO_CAR drive_to 44.1307 -988.6642 26.0181
    015F: set_camera_position 45.0531 -1138.6775 36.0181 rotation 0.0 0.0 0.0
    0158: camera_on_vehicle $INTRO_CAR 15 switchstyle 2
    fade 1 1500
    0@ = 0
    16@ = 0
    goto @INTRO_5
end

goto @INTRO_4

:INTRO_5
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
goto @INTRO_END
end

if
    00E1:   player 0 pressed_button 14
then
    goto @INTRO_DEBUG_END
end

if and
    0@ == 0
    16@ > 9999
then
    fade 0 1500
    wait 1500
    00AB: put_car $INTRO_CAR at 838.2258 -333.3436 8.7747
    SET_CAR_HEADING $INTRO_CAR 0.0
    wait 1000
    00A7: car $INTRO_CAR drive_to 837.4774 -300.9877 5.4686
    015F: set_camera_position 838.2258 -333.3436 18.7747 rotation 0.0 0.0 0.0
    0158: camera_on_vehicle $INTRO_CAR 15 switchstyle 2
    fade 1 1500
    0@ = 0
    16@ = 0
    goto @INTRO_6
end

goto @INTRO_5

:INTRO_6
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
goto @INTRO_END
end

if and
0@ == 0
16@ > 5999
then
0@ = 1
16@ = 0
01D3: actor $PLAYER_ACTOR leave_car $INTRO_CAR
goto @INTRO_7
end

goto @INTRO_6

:INTRO_7
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
goto @INTRO_END
end

if
8448:   NOT actor $PLAYER_ACTOR in_car $INTRO_CAR
then
goto @INTRO_8
end

:INTRO_8
0239: actor $PLAYER_ACTOR run_to 862.5598 -301.5593
015F: set_camera_position 882.6191 -307.3973 15.6198 rotation 0.0 0.0 0.0
CAMERA_ON_PED $PLAYER_ACTOR 15 2

:INTRO_9
wait 0

if
8256:   NOT player $PLAYER_CHAR defined
then
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
01B4: set_player $PLAYER_CHAR control 1
goto @INTRO_END
end

if
00FF:   actor $PLAYER_ACTOR 0 862.5598 -301.5593 8.186 radius 4.0 4.0 4.0
then
03CB: set_camera 862.5598 -301.5593 8.0
MARK_CAR_AS_NO_LONGER_NEEDED $INTRO_CAR
TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
SET_CAR_DENSITY_MULTIPLIER 1.0
0373: set_camera_directly_behind_player
RESTORE_CAMERA
014D: text_pager 'MPINTR' 140 2 0
goto @INTRO_END
end

goto @INTRO_9

:INTRO_DEBUG_END
fade 0 1500
TEXT_CLEAR_ALL
wait 1500
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
02EB: restore_camera_with_jumpcut
0055: put_player $PLAYER_CHAR at 862.5598 -301.5593 7.186
0171: set_player $PLAYER_CHAR z_angle_to 280.0
01B4: set_player $PLAYER_CHAR control 1
SET_CAR_DENSITY_MULTIPLIER 1.0
fade 1 1500
014D: text_pager 'MPINTR' 140 2 0

:INTRO_END
$ONMISSION = 0
SET_CAR_DENSITY_MULTIPLIER 1.0
RELEASE_MODEL #BUS
RELEASE_MODEL #COLUMB
RELEASE_MODEL #GANG01
RELEASE_MODEL #GANG02
RELEASE_MODEL #COLT45
RELEASE_MODEL #MOD_MAN
02D1: remove_fire $INTRO_FIRE
MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN1
MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN2
MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN3
MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN4
MARK_CAR_AS_NO_LONGER_NEEDED $INTRO_CAR
MARK_CAR_AS_NO_LONGER_NEEDED $INTRO_CAR2
MISSION_HAS_FINISHED
end_thread
