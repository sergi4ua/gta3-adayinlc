:ODD3
thread 'ODD3'
gosub @ODD3_CODE
if 
wasted_or_busted
Jf @ODD3_SKIP 
gosub @ODD3_FAIL

:ODD3_SKIP 
gosub @ODD3_CLEANUP
end_thread

:ODD3_CODE
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
REQUEST_MODEL #P_MAN1
REQUEST_MODEL #CHEETAH
REQUEST_MODEL #INFERNUS

:ODD3_MODELS_AVAILABLE
wait 0
if and
IS_MODEL_AVAILABLE #P_MAN1
IS_MODEL_AVAILABLE #CHEETAH
IS_MODEL_AVAILABLE #INFERNUS
jf @ODD3_MODELS_AVAILABLE
009A: $THE_GUY = create_actor_pedtype 21 model #P_MAN1 at 1163.8075 -453.7257 22.3
0173: set_actor $THE_GUY z_angle_to 90.0
00A5: $THE_GUY_CAR = create_car #CHEETAH at 1190.1752 -466.3766 25.07
0175: set_car $THE_GUY_CAR z_angle_to 180.0
00A5: $MIS_CAR = create_car #INFERNUS at 1190.5138 -439.7458 24.0
0175: set_car $MIS_CAR z_angle_to 180.0

TOGGLE_WIDESCREEN TRUE
015F: set_camera_position 1157.8121 -454.2009 21.5859 rotation 0.0 0.0 0.0
CAMERA_ON_PED $THE_GUY 15 2
01B4: set_player $PLAYER_CHAR control 0
0171: set_player $PLAYER_CHAR z_angle_to 32.0
0173: set_actor $PLAYER_ACTOR z_angle_to 32.0
fade 1 1500
wait 1000
00BB: show_text_lowpriority GXT 'MIS4_A' time 5000 flag 1  // Text
wait 3000
TEXT_CLEAR_ALL
00BB: show_text_lowpriority GXT 'MIS4_B' time 5000 flag 1  // Text
0239: actor $THE_GUY run_to 1174.0404 -465.6848
wait 3000
TEXT_CLEAR_ALL
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
RESTORE_CAMERA_WITH_JUMPCUT
00BC: show_text_highpriority GXT 'MIS4_C' time 1000 flag 1  // Text
036A: put_actor $THE_GUY in_car $THE_GUY_CAR
0187: $MIS_MARKER0 = create_marker_above_actor $THE_GUY
0186: $MIS_MARKER1 = create_marker_above_car $MIS_CAR
01B4: set_player $PLAYER_CHAR control 1
011C: actor $THE_GUY clear_objective
00A8: set_car $THE_GUY_CAR to_psycho_driver
00AD: set_car $THE_GUY_CAR max_speed_to 27.0
00AE: unknown_set_car $THE_GUY_CAR to_ignore_traffic_lights 2
0224: set_car $MIS_CAR health_to 5000
02AC: set_car $THE_GUY_CAR immunities BP 0 FP 1 EP 0 CP 0 MP 0

03F1: pedtype 7 add_threat 1                                    // comment on RELEASE
0237: set_gang 0 primary_weapon_to 2 secondary_weapon_to 4      // comment on RELEASE

$MIS_FLAG0 = 0

:ODD3_OBJ1_LOOP
wait 0

if and
00DB:   actor $PLAYER_ACTOR in_car $MIS_CAR
$MIS_FLAG0 == 0
then
$MIS_FLAG0 = 1
0164: disable_marker $MIS_MARKER1
end

if
0118:   actor $THE_GUY dead
then
goto @ODD3_OBJ2
end

goto @ODD3_OBJ1_LOOP

:ODD3_OBJ2
TEXT_CLEAR_ALL
00BC: show_text_highpriority GXT 'MIS4_D' time 10000 flag 1  // Text
const
SphereRadius = 15.0
BridgeX = 970.9
BridgeY = -919.0
BridgeZ =  19.7
TunnelX = 737.8
TunnelY = 179.2
TunnelZ = -20.6
SubwayX = 982.0
SubwayY = -471.6
SubwayZ = 2.1585
HideoutX = 115.8
HideoutY = -467.0
HideoutZ = 15.4
end

if
0119:   car $MIS_CAR wrecked
then
0000:
else
0224: set_car $MIS_CAR health_to 5000
end

010D: set_player $PLAYER_CHAR wanted_level_to 4
018A: $MIS_CHECKPOINT0 = create_checkpoint_at BridgeX BridgeY BridgeZ
018A: $MIS_CHECKPOINT1 = create_checkpoint_at TunnelX TunnelY TunnelZ
018A: $MIS_CHECKPOINT2 = create_checkpoint_at SubwayX SubwayY SubwayZ

03BC: $MIS_SPHERE0 = create_sphere BridgeX BridgeY BridgeZ SphereRadius
03BC: $MIS_SPHERE1 = create_sphere TunnelX TunnelY TunnelZ SphereRadius
03BC: $MIS_SPHERE2 = create_sphere SubwayX SubwayY SubwayZ SphereRadius

:ODD3_OBJ2_LOOP
wait 0
010D: set_player $PLAYER_CHAR wanted_level_to 4

if
00FE:   actor $PLAYER_ACTOR 0 BridgeX BridgeY BridgeZ radius SphereRadius SphereRadius 5.0
then
goto @ODD3_OBJ3
end

if
00FE:   actor $PLAYER_ACTOR 0 TunnelX TunnelY TunnelZ radius SphereRadius SphereRadius 5.0
then
goto @ODD3_OBJ3
end

if
00FE:   actor $PLAYER_ACTOR 0 SubwayX SubwayY SubwayZ radius SphereRadius SphereRadius 5.0
then
goto @ODD3_OBJ3
end

goto @ODD3_OBJ2_LOOP

:ODD3_OBJ3
010D: set_player $PLAYER_CHAR wanted_level_to 3
0164: disable_marker $MIS_CHECKPOINT0
0164: disable_marker $MIS_CHECKPOINT1
0164: disable_marker $MIS_CHECKPOINT2
03BD: destroy_sphere $MIS_SPHERE0
03BD: destroy_sphere $MIS_SPHERE1
03BD: destroy_sphere $MIS_SPHERE2

018A: $MIS_CHECKPOINT3 = create_checkpoint_at HideoutX HideoutY HideoutZ
03BC: $MIS_SPHERE3 = create_sphere HideoutX HideoutY HideoutZ SphereRadius

:ODD3_OBJ3_LOOP
wait 0

if
00FE:   actor $PLAYER_ACTOR 0 HideoutX HideoutY HideoutZ radius SphereRadius SphereRadius 5.0
then
0164: disable_marker $MIS_CHECKPOINT3
03BD: destroy_sphere $MIS_SPHERE3
goto @ODD3_PASS
end

goto @ODD3_OBJ3_LOOP


:ODD3_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 10000 5000 ms 1 
0109: player $PLAYER_CHAR money += 10000
00BC: show_text_highpriority GXT 'MIS4_E' time 10000 flag 1
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1 
$PORTLAND_P1_COMPLETED += 1
0318: set_latest_mission_passed 'MIS4'
030C: set_mission_points += 1
$PORTLAND_PLAYER_HAUNT = 1
032B: $STAUNTON_SAFEHOUSE_UZI = create_weapon_pickup #UZI 14 ammo 200 at 99.0775 -475.4378 15.94
02A7: $STAUNTON_MISSION_MARKER1 = create_icon_marker_and_sphere 7 at 374.3439 -568.5399 25.1748
create_thread @PCOPS
create_thread @S1_MIS
gosub @ODD3_SKIP
return

:ODD3_FAIL 
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0
02A7: $PORTLAND_MISSION_MARKER2 = create_icon_marker_and_sphere 5 at 1150.1073 -454.2015 20.648
create_thread @P2_MIS 
mission_cleanup
return

:ODD3_CLEANUP 
$ONMISSION = 0
0164: disable_marker $MIS_MARKER0
0164: disable_marker $MIS_MARKER1
RELEASE_MODEL #P_MAN1
RELEASE_MODEL #CHEETAH
RELEASE_MODEL #INFERNUS
REMOVE_REFERENCES_TO_CAR $MIS_CAR
REMOVE_REFERENCES_TO_CAR $THE_GUY_CAR
REMOVE_REFERENCES_TO_ACTOR $THE_GUY
0164: disable_marker $MIS_CHECKPOINT0
0164: disable_marker $MIS_CHECKPOINT1
0164: disable_marker $MIS_CHECKPOINT2
03BD: destroy_sphere $MIS_SPHERE0
03BD: destroy_sphere $MIS_SPHERE1
03BD: destroy_sphere $MIS_SPHERE2
0164: disable_marker $MIS_CHECKPOINT3
03BD: destroy_sphere $MIS_SPHERE3
mission_cleanup
return