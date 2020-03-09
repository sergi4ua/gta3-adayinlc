:FINALE
thread 'FINALE'
gosub @FINALE_CODE
if 
wasted_or_busted
Jf @FINALE_SKIP 
gosub @FINALE_FAIL

:FINALE_SKIP 
gosub @FINALE_CLEANUP
end_thread

:FINALE_CODE
03E7: flash_hud -1
increment_mission_attempts
$ONMISSION = 1
0169: set_fade_color 0 0 0
0110: clear_player $PLAYER_CHAR wanted_level
TOGGLE_WIDESCREEN TRUE
015F: set_camera_position -392.3711 280.2444 62.6584 rotation 0.0 0.0 0.0
0160: point_camera -380.2 299.9 76.6 switchstyle 2
gosub @FINALE_LOAD_MODELS
fade 1 1500
wait 2000
00A5: $MIS_PATRIOT = create_car #PATRIOT at -423.3684 293.491 62.9498
SET_CAR_HEADING $MIS_PATRIOT 220.80
02AC: set_car $MIS_PATRIOT immunities BP 1 FP 1 EP 1 CP 0 MP 0
SET_CAR_HEALTH $MIS_PATRIOT 7500
00BA: show_text_styled GXT 'PROPBUY' time 3000 style 5  // Text
0394: play_music 1
wait 3000
00BA: show_text_styled GXT 'FINALEM' time 3000 style 2 
0239: actor $PLAYER_ACTOR run_to -378.9192 280.174
015F: set_camera_position -362.2395 264.6256 61.4153 rotation 0.0 0.0 0.0
0159: camera_on_ped $PLAYER_ACTOR 15 switchstyle 1
00BC: show_text_highpriority GXT 'FIN_0' time 1500 flag 1  // Text
wait 5000
015F: set_camera_position -373.2858 239.1868 64.7583 rotation 0.0 0.0 0.0
0160: point_camera -362.974 245.2215 60.6685 switchstyle 2
011C: actor $PLAYER_ACTOR clear_objective
00A5: $MIS_CAR1 = create_car #MAFIA at -368.1975 241.8676 60.1807
SET_CAR_HEADING $MIS_CAR1 332.98
00A5: $MIS_CAR2 = create_car #COLUMB at -361.0106 241.0377 60.462
SET_CAR_HEADING $MIS_CAR2 16.2211
00A5: $MIS_CAR3 = create_car #PONY at -364.7596 234.4278 60.6869
SET_CAR_HEADING $MIS_CAR3 0.0
009A: $MIS_ACTOR1 = create_actor_pedtype 12 model #GANG11 at -360.0643 253.2301 60.7887
009A: $MIS_ACTOR2 = create_actor_pedtype 12 model #GANG11 at -365.7058 252.3357 60.696
011A: set_actor $MIS_ACTOR1 search_threat 1
011A: set_actor $MIS_ACTOR2 search_threat 1
0129: $MIS_ACTOR3 = create_actor 12 #GANG01 in_car $MIS_CAR1 driverseat
0129: $MIS_ACTOR4 = create_actor 12 #GANG01 in_car $MIS_CAR2 driverseat
0129: $MIS_ACTOR8 = create_actor 12 #GANG01 in_car $MIS_CAR3 driverseat
01C8: $MIS_ACTOR5 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 0
01C8: $MIS_ACTOR6 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 1
01C8: $MIS_ACTOR7 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 2
01C8: $MIS_ACTOR8 = create_actor_pedtype 12 model #GANG03 in_car $MIS_CAR3 passenger_seat 0
01C8: $MIS_ACTOR9 = create_actor_pedtype 12 model #GANG03 in_car $MIS_CAR3 passenger_seat 1
01D3: actor $MIS_ACTOR3 leave_car $MIS_CAR1
01D3: actor $MIS_ACTOR4 leave_car $MIS_CAR2
01D3: actor $MIS_ACTOR5 leave_car $MIS_CAR1
01D3: actor $MIS_ACTOR6 leave_car $MIS_CAR1
01D3: actor $MIS_ACTOR7 leave_car $MIS_CAR1
01D3: actor $MIS_ACTOR8 leave_car $MIS_CAR3
01D3: actor $MIS_ACTOR9 leave_car $MIS_CAR3
011A: set_actor $MIS_ACTOR3 search_threat 1
011A: set_actor $MIS_ACTOR4 search_threat 1
011A: set_actor $MIS_ACTOR5 search_threat 1
011A: set_actor $MIS_ACTOR6 search_threat 1
011A: set_actor $MIS_ACTOR7 search_threat 1
011A: set_actor $MIS_ACTOR8 search_threat 1
011A: set_actor $MIS_ACTOR9 search_threat 1
01B2: give_actor $MIS_ACTOR1 weapon 3 ammo 999
01B2: give_actor $MIS_ACTOR2 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR3 weapon 3 ammo 999
01B2: give_actor $MIS_ACTOR4 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR5 weapon 3 ammo 999
01B2: give_actor $MIS_ACTOR6 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR7 weapon 3 ammo 999
01B2: give_actor $MIS_ACTOR8 weapon 6 ammo 999
01B2: give_actor $MIS_ACTOR9 weapon 6 ammo 999
01C9: actor $MIS_ACTOR1 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR2 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR3 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR8 kill_actor $PLAYER_ACTOR
01C9: actor $MIS_ACTOR9 kill_actor $PLAYER_ACTOR
wait 1500
00BC: show_text_highpriority GXT 'FIN_1' time 6000 flag 1  // Text
01B4: set_player $PLAYER_CHAR control 1
0373: set_camera_directly_behind_player
RESTORE_CAMERA
TOGGLE_WIDESCREEN FALSE
0213: $MIS_PICKUP = create_pickup #HEALTH type 1 at -383.4642 299.3069 63.9212
0213: $MIS_PICKUP2 = create_pickup #BRIBE type 3 at -426.0421 286.5588 62.956
0213: $MIS_PICKUP3 = create_pickup #BODYARMOUR type 3 at -431.7906 290.9243 62.9023

03E5: show_text_box 'FIN_AUT'

/* MARKERS */
0187: $MIS_BLIP1 = create_marker_above_actor $MIS_ACTOR1
0187: $MIS_BLIP2 = create_marker_above_actor $MIS_ACTOR2
0187: $MIS_BLIP3 = create_marker_above_actor $MIS_ACTOR3
0187: $MIS_BLIP4 = create_marker_above_actor $MIS_ACTOR4
0187: $MIS_BLIP5 = create_marker_above_actor $MIS_ACTOR5
0187: $MIS_BLIP6 = create_marker_above_actor $MIS_ACTOR6
0187: $MIS_BLIP7 = create_marker_above_actor $MIS_ACTOR7
0187: $MIS_BLIP8 = create_marker_above_actor $MIS_ACTOR8
0187: $MIS_BLIP9 = create_marker_above_actor $MIS_ACTOR9
$MIS_PED1_KILLED = 0
$MIS_PED2_KILLED = 0
$MIS_PED3_KILLED = 0
$MIS_PED4_KILLED = 0
$MIS_PED5_KILLED = 0
$MIS_PED6_KILLED = 0
$MIS_PED7_KILLED = 0
$MIS_PED8_KILLED = 0
$MIS_PED9_KILLED = 0

:FINALE_OBJ1
wait 0

if
    IS_CAR_WRECKED $MIS_PATRIOT
then
    fade 0 1500
    wait 1500
    gosub @FINALE_PLAYER_DESTROYED_CAR_CLEANUP
    fade 1 1500
    wait 1000
    00BC: show_text_highpriority GXT 'WRECKED' time 3000 flag 1
    goto @FINALE_FAIL
end

if and
    $MIS_PED1_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR1
then
    REMOVE_BLIP $MIS_BLIP1
    $MIS_PED1_KILLED = 1
end

if and
    $MIS_PED2_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR2
then
    REMOVE_BLIP $MIS_BLIP2
    $MIS_PED2_KILLED = 1
end

if and
    $MIS_PED3_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR3
then
    REMOVE_BLIP $MIS_BLIP3
    $MIS_PED3_KILLED = 1
end

if and
    $MIS_PED4_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR4
then
    REMOVE_BLIP $MIS_BLIP4
    $MIS_PED4_KILLED = 1
end

if and
    $MIS_PED5_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR5
then
    REMOVE_BLIP $MIS_BLIP5
    $MIS_PED5_KILLED = 1
end

if and
    $MIS_PED6_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR6
then
    REMOVE_BLIP $MIS_BLIP6
    $MIS_PED6_KILLED = 1
end

if and
    $MIS_PED7_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR7
then
    REMOVE_BLIP $MIS_BLIP7
    $MIS_PED7_KILLED = 1
end

if and
    $MIS_PED8_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR8
then
    REMOVE_BLIP $MIS_BLIP8
    $MIS_PED8_KILLED = 1
end

if and
    $MIS_PED9_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR9
then
    REMOVE_BLIP $MIS_BLIP9
    $MIS_PED9_KILLED = 1
end

if and
$MIS_PED1_KILLED == 1
$MIS_PED2_KILLED == 1
$MIS_PED3_KILLED == 1
$MIS_PED4_KILLED == 1
$MIS_PED5_KILLED == 1
$MIS_PED6_KILLED == 1
$MIS_PED7_KILLED == 1
$MIS_PED8_KILLED == 1
jf @FINALE_OBJ1
if
$MIS_PED9_KILLED == 1
then
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR1
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR2
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR3
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR1
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR2
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR3
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR4
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR5
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR6
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR7
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR8
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR9
00A5: $MIS_CAR1 = create_car #MAFIA at -424.2537 220.1105 66.6363
00A5: $MIS_CAR2 = create_car #COLUMB at -287.6556 355.3937 78.7113
SET_CAR_HEADING $MIS_CAR1 291.564
SET_CAR_HEADING $MIS_CAR2 181.15
00A7: car $MIS_CAR1 drive_to -366.2546 234.8578 59.0
00AF: set_car $MIS_CAR1 driver_behaviour_to 6
00AF: set_car $MIS_CAR2 driver_behaviour_to 6
0129: $MIS_ACTOR1 = create_actor 12 #GANG01 in_car $MIS_CAR1 driverseat
01C8: $MIS_ACTOR2 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 0
01C8: $MIS_ACTOR3 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 1
01C8: $MIS_ACTOR4 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 2
0129: $MIS_ACTOR5 = create_actor 12 #GANG11 in_car $MIS_CAR2 driverseat
01C8: $MIS_ACTOR6 = create_actor_pedtype 12 model #GANG11 in_car $MIS_CAR2 passenger_seat 1
01C8: $MIS_ACTOR7 = create_actor_pedtype 12 model #GANG11 in_car $MIS_CAR2 passenger_seat 2
011A: set_actor $MIS_ACTOR1 search_threat 1
011A: set_actor $MIS_ACTOR2 search_threat 1
011A: set_actor $MIS_ACTOR3 search_threat 1
011A: set_actor $MIS_ACTOR4 search_threat 1
011A: set_actor $MIS_ACTOR5 search_threat 1
011A: set_actor $MIS_ACTOR6 search_threat 1
011A: set_actor $MIS_ACTOR7 search_threat 1
0291: unknown_actor $MIS_ACTOR1 unknown_behavior_flag 1
0291: unknown_actor $MIS_ACTOR2 unknown_behavior_flag 1
0291: unknown_actor $MIS_ACTOR3 unknown_behavior_flag 1
0291: unknown_actor $MIS_ACTOR4 unknown_behavior_flag 1
0291: unknown_actor $MIS_ACTOR5 unknown_behavior_flag 1
0291: unknown_actor $MIS_ACTOR6 unknown_behavior_flag 1
0291: unknown_actor $MIS_ACTOR7 unknown_behavior_flag 1
01CB: actor $MIS_ACTOR1 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_ACTOR2 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_ACTOR3 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_ACTOR4 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_ACTOR5 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_ACTOR6 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_ACTOR7 kill_actor $PLAYER_ACTOR
0187: $MIS_BLIP1 = create_marker_above_actor $MIS_ACTOR1
0187: $MIS_BLIP2 = create_marker_above_actor $MIS_ACTOR2
0187: $MIS_BLIP3 = create_marker_above_actor $MIS_ACTOR3
0187: $MIS_BLIP4 = create_marker_above_actor $MIS_ACTOR4
0187: $MIS_BLIP5 = create_marker_above_actor $MIS_ACTOR5
0187: $MIS_BLIP6 = create_marker_above_actor $MIS_ACTOR6
0187: $MIS_BLIP7 = create_marker_above_actor $MIS_ACTOR7
0224: set_car $MIS_CAR1 health_to 5000
0224: set_car $MIS_CAR2 health_to 5000
00BC: show_text_highpriority GXT 'FIN_2' time 4000 flag 1  // Text
01B2: give_actor $MIS_ACTOR1 weapon 3 ammo 999
01B2: give_actor $MIS_ACTOR2 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR3 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR4 weapon 3 ammo 999
01B2: give_actor $MIS_ACTOR5 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR6 weapon 5 ammo 999
01B2: give_actor $MIS_ACTOR7 weapon 5 ammo 999
$MIS_PED1_KILLED = 0
$MIS_PED2_KILLED = 0
$MIS_PED3_KILLED = 0
$MIS_PED4_KILLED = 0
$MIS_PED5_KILLED = 0
$MIS_PED6_KILLED = 0
$MIS_PED7_KILLED = 0
$MIS_PED8_KILLED = 0
$MIS_PED9_KILLED = 0
goto @FINALE_OBJ2
end

goto @FINALE_OBJ1

:FINALE_OBJ2
wait 0

if
    IS_CAR_WRECKED $MIS_PATRIOT
then
    fade 0 1500
    wait 1500
    gosub @FINALE_PLAYER_DESTROYED_CAR_CLEANUP
    fade 1 1500
    wait 1000
    00BC: show_text_highpriority GXT 'WRECKED' time 3000 flag 1
    goto @FINALE_FAIL
end

if and
    $MIS_PED1_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR1
then
    REMOVE_BLIP $MIS_BLIP1
    $MIS_PED1_KILLED = 1
end

if and
    $MIS_PED2_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR2
then
    REMOVE_BLIP $MIS_BLIP2
    $MIS_PED2_KILLED = 1
end

if and
    $MIS_PED3_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR3
then
    REMOVE_BLIP $MIS_BLIP3
    $MIS_PED3_KILLED = 1
end

if and
    $MIS_PED4_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR4
then
    REMOVE_BLIP $MIS_BLIP4
    $MIS_PED4_KILLED = 1
end

if and
    $MIS_PED5_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR5
then
    REMOVE_BLIP $MIS_BLIP5
    $MIS_PED5_KILLED = 1
end

if and
    $MIS_PED6_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR6
then
    REMOVE_BLIP $MIS_BLIP6
    $MIS_PED6_KILLED = 1
end

if and
    $MIS_PED7_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR7
then
    REMOVE_BLIP $MIS_BLIP7
    $MIS_PED7_KILLED = 1
end

if and
    $MIS_PED1_KILLED == 1
    $MIS_PED2_KILLED == 1
    $MIS_PED3_KILLED == 1
    $MIS_PED4_KILLED == 1
    $MIS_PED5_KILLED == 1
    $MIS_PED6_KILLED == 1
    $MIS_PED7_KILLED == 1
then
    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR1
    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR2
    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR3
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR1
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR2
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR3
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR4
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR5
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR6
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR7
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR8
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR9
    00A5: $MIS_CAR1 = create_car #MAFIA at -287.3579 355.9279 78.7113
    00A5: $MIS_CAR2 = create_car #MAFIA at -453.4143 219.9729 68.7113
    00A5: $MIS_CAR3 = create_car #COLUMB at -453.525 224.7731 68.7113
    SET_CAR_HEADING $MIS_CAR1 90.1
    SET_CAR_HEADING $MIS_CAR2 272.5
    SET_CAR_HEADING $MIS_CAR3 272.5
    00A7: car $MIS_CAR1 drive_to -366.2546 234.8578 59.0
    00AF: set_car $MIS_CAR1 driver_behaviour_to 6
    00AF: set_car $MIS_CAR2 driver_behaviour_to 6
    00AF: set_car $MIS_CAR3 driver_behaviour_to 6
    0129: $MIS_ACTOR1 = create_actor 12 #GANG01 in_car $MIS_CAR1 driverseat
    01C8: $MIS_ACTOR2 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 0
    01C8: $MIS_ACTOR3 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 1
    01C8: $MIS_ACTOR4 = create_actor_pedtype 12 model #GANG01 in_car $MIS_CAR1 passenger_seat 2
    0129: $MIS_ACTOR5 = create_actor 12 #GANG11 in_car $MIS_CAR2 driverseat
    01C8: $MIS_ACTOR6 = create_actor_pedtype 12 model #GANG11 in_car $MIS_CAR2 passenger_seat 1
    01C8: $MIS_ACTOR7 = create_actor_pedtype 12 model #GANG11 in_car $MIS_CAR2 passenger_seat 2
    0129: $MIS_ACTOR8 = create_actor 12 #GANG11 in_car $MIS_CAR3 driverseat
    01C8: $MIS_ACTOR9 = create_actor_pedtype 12 model #GANG11 in_car $MIS_CAR3 passenger_seat 1
    011A: set_actor $MIS_ACTOR1 search_threat 1
    011A: set_actor $MIS_ACTOR2 search_threat 1
    011A: set_actor $MIS_ACTOR3 search_threat 1
    011A: set_actor $MIS_ACTOR4 search_threat 1
    011A: set_actor $MIS_ACTOR5 search_threat 1
    011A: set_actor $MIS_ACTOR6 search_threat 1
    011A: set_actor $MIS_ACTOR7 search_threat 1
    011A: set_actor $MIS_ACTOR8 search_threat 1
    011A: set_actor $MIS_ACTOR9 search_threat 1
    0291: unknown_actor $MIS_ACTOR1 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR2 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR3 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR4 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR5 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR6 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR7 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR8 unknown_behavior_flag 1
    0291: unknown_actor $MIS_ACTOR9 unknown_behavior_flag 1
    01CB: actor $MIS_ACTOR1 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR2 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR3 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR4 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR5 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR6 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR7 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR8 kill_actor $PLAYER_ACTOR
    01CB: actor $MIS_ACTOR9 kill_actor $PLAYER_ACTOR
    0187: $MIS_BLIP1 = create_marker_above_actor $MIS_ACTOR1
    0187: $MIS_BLIP2 = create_marker_above_actor $MIS_ACTOR2
    0187: $MIS_BLIP3 = create_marker_above_actor $MIS_ACTOR3
    0187: $MIS_BLIP4 = create_marker_above_actor $MIS_ACTOR4
    0187: $MIS_BLIP5 = create_marker_above_actor $MIS_ACTOR5
    0187: $MIS_BLIP6 = create_marker_above_actor $MIS_ACTOR6
    0187: $MIS_BLIP7 = create_marker_above_actor $MIS_ACTOR7
    0187: $MIS_BLIP8 = create_marker_above_actor $MIS_ACTOR8
    0187: $MIS_BLIP9 = create_marker_above_actor $MIS_ACTOR9
    0224: set_car $MIS_CAR1 health_to 3500
    0224: set_car $MIS_CAR2 health_to 3500
    0224: set_car $MIS_CAR2 health_to 5500
    00BC: show_text_highpriority GXT 'FIN_2' time 4000 flag 1  // Text
    01B2: give_actor $MIS_ACTOR1 weapon 3 ammo 999
    01B2: give_actor $MIS_ACTOR2 weapon 5 ammo 999
    01B2: give_actor $MIS_ACTOR3 weapon 5 ammo 999
    01B2: give_actor $MIS_ACTOR4 weapon 3 ammo 999
    01B2: give_actor $MIS_ACTOR5 weapon 5 ammo 999
    01B2: give_actor $MIS_ACTOR6 weapon 5 ammo 999
    01B2: give_actor $MIS_ACTOR7 weapon 5 ammo 999
    01B2: give_actor $MIS_ACTOR8 weapon 5 ammo 999
    01B2: give_actor $MIS_ACTOR9 weapon 8 ammo 999
    $MIS_PED1_KILLED = 0
    $MIS_PED2_KILLED = 0
    $MIS_PED3_KILLED = 0
    $MIS_PED4_KILLED = 0
    $MIS_PED5_KILLED = 0
    $MIS_PED6_KILLED = 0
    $MIS_PED7_KILLED = 0
    $MIS_PED8_KILLED = 0
    $MIS_PED9_KILLED = 0
    goto @FINALE_OBJ3
end

goto @FINALE_OBJ2

:FINALE_OBJ3
wait 0

if
    IS_CAR_WRECKED $MIS_PATRIOT
then
    fade 0 1500
    wait 1500
    gosub @FINALE_PLAYER_DESTROYED_CAR_CLEANUP
    fade 1 1500
    wait 1000
    00BC: show_text_highpriority GXT 'WRECKED' time 3000 flag 1
    goto @FINALE_FAIL
end

if and
    $MIS_PED1_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR1
then
    REMOVE_BLIP $MIS_BLIP1
    $MIS_PED1_KILLED = 1
end

if and
    $MIS_PED2_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR2
then
    REMOVE_BLIP $MIS_BLIP2
    $MIS_PED2_KILLED = 1
end

if and
    $MIS_PED3_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR3
then
    REMOVE_BLIP $MIS_BLIP3
    $MIS_PED3_KILLED = 1
end

if and
    $MIS_PED4_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR4
then
    REMOVE_BLIP $MIS_BLIP4
    $MIS_PED4_KILLED = 1
end

if and
    $MIS_PED5_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR5
then
    REMOVE_BLIP $MIS_BLIP5
    $MIS_PED5_KILLED = 1
end

if and
    $MIS_PED6_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR6
then
    REMOVE_BLIP $MIS_BLIP6
    $MIS_PED6_KILLED = 1
end

if and
    $MIS_PED7_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR7
then
    REMOVE_BLIP $MIS_BLIP7
    $MIS_PED7_KILLED = 1
end

if and
    $MIS_PED8_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR8
then
    REMOVE_BLIP $MIS_BLIP8
    $MIS_PED8_KILLED = 1
end

if and
    $MIS_PED9_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR9
then
    REMOVE_BLIP $MIS_BLIP9
    $MIS_PED9_KILLED = 1
end

if and
$MIS_PED1_KILLED == 1
$MIS_PED2_KILLED == 1
$MIS_PED3_KILLED == 1
$MIS_PED4_KILLED == 1
$MIS_PED5_KILLED == 1
$MIS_PED6_KILLED == 1
$MIS_PED7_KILLED == 1
$MIS_PED8_KILLED == 1
jf @FINALE_OBJ3
if
$MIS_PED9_KILLED == 1
then
goto @FINALE_FLASHBACK
end

goto @FINALE_OBJ3

:FINALE_FLASHBACK
0169: set_fade_color 255 255 255
fade 0 500
wait 500
TOGGLE_WIDESCREEN TRUE
01B4: set_player $PLAYER_CHAR control 0
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1
03CB: set_camera -579.7874 1074.9075 37.0
009A: $INTRO_MAN1 = create_actor_pedtype 4 model #GANG01 at -587.6288 1074.3063 37.9162
SET_CHAR_HEADING $INTRO_MAN1 3.0
009A: $INTRO_MAN2 = create_actor_pedtype 4 model #GANG01 at -587.7251 1078.8727 37.9162
SET_CHAR_HEADING $INTRO_MAN2 184.90
015F: set_camera_position -579.7874 1074.9075 37.9162 rotation 0.0 0.0 0.0
0159: camera_on_ped $INTRO_MAN1 15 switchstyle 2
fade 1 1000
wait 1500
fade 0 500
wait 500
TOGGLE_WIDESCREEN FALSE
01B4: set_player $PLAYER_CHAR control 1
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0
set_camera_behind_player
RESTORE_CAMERA_JUMPCUT
MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN1
MARK_CHAR_AS_NO_LONGER_NEEDED $INTRO_MAN2
fade 1 1500
wait 1500
0169: set_fade_color 0 0 0
0054: store_player $PLAYER_CHAR position_to 5@ 6@ 7@
03CB: set_camera 5@ 6@ 7@

014D: text_pager 'FIN_3' 140 2 0
00BC: show_text_highpriority GXT 'FIN_4' time 5000 flag 1 

    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR1
    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR2
    MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR3
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR1
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR2
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR3
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR4
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR5
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR6
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR7
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR8
    MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR9
    
0@ = 0

$MIS_FLAG = 0
00A5: $MIS_ANTAGONIST_CAR = create_car #MAFIA at -85.4853 -720.2296 26.0181
SET_CAR_HEADING $MIS_ANTAGONIST_CAR 181.1
0129: $MIS_ACTOR1 = create_actor 11 #GANG01 in_car $MIS_ANTAGONIST_CAR driverseat
01C8: $MIS_ACTOR2 = create_actor_pedtype 11 model #GANG01 in_car $MIS_ANTAGONIST_CAR passenger_seat 0
00AE: unknown_set_car $MIS_ANTAGONIST_CAR to_ignore_traffic_lights 2
00A8: set_car $MIS_ANTAGONIST_CAR to_psycho_driver
00AD: set_car $MIS_ANTAGONIST_CAR max_speed_to 34.0

01B2: give_actor $MIS_ACTOR1 weapon 6 ammo 999
01B2: give_actor $MIS_ACTOR2 weapon 6 ammo 999

$MIS_PED1_KILLED = 0
    $MIS_PED2_KILLED = 0
    $MIS_PED3_KILLED = 0
    $MIS_PED4_KILLED = 0
    $MIS_PED5_KILLED = 0
    $MIS_PED6_KILLED = 0
    $MIS_PED7_KILLED = 0
    $MIS_PED8_KILLED = 0
    $MIS_PED9_KILLED = 0
    
0224: set_car $MIS_PATRIOT health_to 7000
0227: $MIS_HEALTH = car $MIS_PATRIOT health
DISPLAY_ONSCREEN_COUNTER_WITH_STRING $MIS_HEALTH 0 'HEALTH'  // DAMAGE:

if
    IS_CAR_WRECKED $MIS_PATRIOT
then
    fade 0 1500
    wait 1500
    gosub @FINALE_PLAYER_DESTROYED_CAR_CLEANUP
    fade 1 1500
    wait 1000
    00BC: show_text_highpriority GXT 'WRECKED' time 3000 flag 1
    goto @FINALE_FAIL
end

0186: $MIS_BLIP10 = create_marker_above_car $MIS_PATRIOT

:FINALE_OBJ4
wait 0
0227: $MIS_HEALTH = car $MIS_PATRIOT health

if
    IS_CAR_WRECKED $MIS_PATRIOT
then
    fade 0 1500
    wait 1500
    gosub @FINALE_PLAYER_DESTROYED_CAR_CLEANUP
    fade 1 1500
    wait 1000
    00BC: show_text_highpriority GXT 'WRECKED' time 3000 flag 1
    goto @FINALE_FAIL
end

if
    $MIS_FLAG == 1
then
    $MIS_FLAG = 0
    REMOVE_BLIP $MIS_BLIP1
    REMOVE_BLIP $MIS_BLIP2
end 

if
    IS_CHAR_IN_CAR $PLAYER_ACTOR $MIS_PATRIOT
then
    REMOVE_BLIP $MIS_BLIP10
    goto @FINALE_OBJ5
end

goto @FINALE_OBJ4

:FINALE_OBJ5
wait 0
0227: $MIS_HEALTH = car $MIS_PATRIOT health

if
    IS_CAR_WRECKED $MIS_PATRIOT
then
    fade 0 1500
    wait 1500
    gosub @FINALE_PLAYER_DESTROYED_CAR_CLEANUP
    fade 1 1500
    wait 1000
    00BC: show_text_highpriority GXT 'WRECKED' time 3000 flag 1
    goto @FINALE_FAIL
end

if
    $MIS_FLAG == 0
then
    if
        00A2:   actor $MIS_ACTOR1 alive
    then
        0187: $MIS_BLIP1 = create_marker_above_actor $MIS_ACTOR1
    end
    
    if
        00A2:   actor $MIS_ACTOR2 alive
    then
        0187: $MIS_BLIP2 = create_marker_above_actor $MIS_ACTOR2
    end
    
    $MIS_FLAG = 1
end

if
    0@ == 0
then
    if or
        0123:   actor $MIS_ACTOR1 spotted_player $PLAYER_CHAR
        0123:   actor $MIS_ACTOR2 spotted_player $PLAYER_CHAR
    then
        01CA: actor $MIS_ACTOR1 kill_player $PLAYER_CHAR
        01CA: actor $MIS_ACTOR2 kill_player $PLAYER_CHAR
        0@ = 1
    end
end

if
    80DC:   NOT player $PLAYER_CHAR driving $MIS_PATRIOT
then
    0186: $MIS_BLIP10 = create_marker_above_car $MIS_PATRIOT
    goto @FINALE_OBJ4
end

if and
    $MIS_PED1_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR1
then
    $MIS_PED1_KILLED = 1
    REMOVE_BLIP $MIS_BLIP1
end

if and
    $MIS_PED2_KILLED == 0
    IS_CHAR_DEAD $MIS_ACTOR2
then
    $MIS_PED2_KILLED = 1
    REMOVE_BLIP $MIS_BLIP2
end

if and
    $MIS_PED1_KILLED == 1
    $MIS_PED2_KILLED == 1
then
    goto @FINALE_OBJ6
end

goto @FINALE_OBJ5

:FINALE_OBJ6
018A: $MIS_BLIP9 = create_checkpoint_at -280.1086 367.9306 78.7114
010D: set_player $PLAYER_CHAR wanted_level_to 6
0151: remove_status_text $MIS_HEALTH
00BC: show_text_highpriority GXT 'FIN_5' time 5000 flag 1

:FINALE_OBJ6_LOOP
wait 0

if or
00FF:   actor $PLAYER_ACTOR 0 -280.1086 367.9306 78.7114 radius 50.0 50.0 50.0
00FE:   actor $PLAYER_ACTOR 0 -280.1086 367.9306 78.7114 radius 50.0 50.0 50.0
then
REMOVE_BLIP $MIS_BLIP9
CLEAR_WANTED_LEVEL $PLAYER_CHAR
01B4: set_player $PLAYER_CHAR control 0
fade 0 1500
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1
wait 1500
TOGGLE_WIDESCREEN TRUE
012A: put_player $PLAYER_CHAR at -267.0613 380.477 78.8614 and_remove_from_car
wait 1000
0395: clear_area 1 at -280.1086 367.9306 78.7114 range 150.0 1.0
goto @FINALE_FINAL_CUT
end

goto @FINALE_OBJ6_LOOP

:FINALE_FINAL_CUT
015F: set_camera_position -279.0972 419.6067 90.8681 rotation 0.0 0.0 0.0
0160: point_camera -281.644 447.4607 90.963 switchstyle 2
fade 1 1500
wait 1000
00BC: show_text_highpriority GXT 'FIN_6' time 4000 flag 1
SWITCH_RUBBISH FALSE
wait 4000
0AAC: play_audio_stream "MODLOADER\ADAYINLIBERTY\FINALE.OGG" loop 0 volume 0.5
0434: show_credits

:FINALE_FINAL_CUT_LOOP
wait 0

if
    0AB0: key_pressed 0x20
then
    goto @FINALE_FINISHED
end

if 
    0436:   reached_end_of_credits
then
    goto @FINALE_FINISHED
end

goto @FINALE_FINAL_CUT_LOOP

:FINALE_FINISHED
0435: end_credits
0AAD: stop_audio_stream
fade 0 1500
wait 1500
0055: put_player $PLAYER_CHAR at -667.362 -3.0259 18.8614
SET_PLAYER_HEADING $PLAYER_CHAR 178.50
01B4: set_player $PLAYER_CHAR control 1
TOGGLE_WIDESCREEN FALSE
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
set_camera_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
fade 1 1500
goto @FINALE_PASS

:FINALE_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 750000 5000 ms 1 
0109: player $PLAYER_CHAR money += 750000
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
030C: set_mission_points += 1
030C: progress_made += 100
0318: set_latest_mission_passed 'FINALEM'
gosub @FINALE_SKIP
return

:FINALE_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
0109: player $PLAYER_CHAR money += 1001000
create_thread @FIN
$ONMISSION = 0 
mission_cleanup
return

:FINALE_CLEANUP 
0151: remove_status_text $MIS_HEALTH
REMOVE_BLIP $MIS_BLIP1
REMOVE_BLIP $MIS_BLIP2
REMOVE_BLIP $MIS_BLIP3
REMOVE_BLIP $MIS_BLIP4
REMOVE_BLIP $MIS_BLIP5
REMOVE_BLIP $MIS_BLIP6
REMOVE_BLIP $MIS_BLIP7
REMOVE_BLIP $MIS_BLIP8
REMOVE_BLIP $MIS_BLIP9
REMOVE_BLIP $MIS_BLIP10
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR1
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR2
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_CAR3
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR1
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR2
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR3
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR4
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR5
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR6
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR7
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR8
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR9
MARK_CAR_AS_NO_LONGER_NEEDED $MIS_PATRIOT
RELEASE_MODEL #COLUMB
RELEASE_MODEL #UZI
RELEASE_MODEL #SHOTGUN
RELEASE_MODEL #AK47
RELEASE_MODEL #PONY
RELEASE_MODEL #GANG01
RELEASE_MODEL #GANG03
RELEASE_MODEL #GANG11
RELEASE_MODEL #ROCKET
SWITCH_RUBBISH TRUE
$ONMISSION = 0
mission_cleanup
return

:FINALE_LOAD_MODELS
REQUEST_MODEL #COLUMB
REQUEST_MODEL #MAFIA
REQUEST_MODEL #AK47
REQUEST_MODEL #SHOTGUN
REQUEST_MODEL #UZI
REQUEST_MODEL #PONY
REQUEST_MODEL #GANG01
REQUEST_MODEL #GANG03
REQUEST_MODEL #GANG11
REQUEST_MODEL #PATRIOT
REQUEST_MODEL #ROCKET

:FINALE_LOAD_MODELS_AVAILABLE
wait 0
if and
IS_MODEL_AVAILABLE #COLUMB
IS_MODEL_AVAILABLE #MAFIA
IS_MODEL_AVAILABLE #AK47
IS_MODEL_AVAILABLE #SHOTGUN
IS_MODEL_AVAILABLE #UZI
IS_MODEL_AVAILABLE #PONY
IS_MODEL_AVAILABLE #GANG01
jf @FINALE_LOAD_MODELS_AVAILABLE
if and
IS_MODEL_AVAILABLE #GANG03
IS_MODEL_AVAILABLE #GANG11
IS_MODEL_AVAILABLE #PATRIOT
IS_MODEL_AVAILABLE #ROCKET
jf @FINALE_LOAD_MODELS_AVAILABLE
return

:FINALE_PLAYER_DESTROYED_CAR_CLEANUP
00A6: destroy_car $MIS_CAR1
00A6: destroy_car $MIS_CAR2
00A6: destroy_car $MIS_CAR3
009B: destroy_actor_instantly $MIS_ACTOR1
009B: destroy_actor_instantly $MIS_ACTOR2
009B: destroy_actor_instantly $MIS_ACTOR3
009B: destroy_actor_instantly $MIS_ACTOR4
009B: destroy_actor_instantly $MIS_ACTOR5
009B: destroy_actor_instantly $MIS_ACTOR6
009B: destroy_actor_instantly $MIS_ACTOR7
009B: destroy_actor_instantly $MIS_ACTOR8
009B: destroy_actor_instantly $MIS_ACTOR9
return