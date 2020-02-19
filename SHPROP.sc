{
    Newport Safehouse
    
    teleport pos: 325.2 -421.4 35.76
    exit sphere pos: 327.43 -421.4 35.7
    
    entrace sphere pos: 332.30 -433.12 23.4
    entrace teleport pos: 332.2 -434.1 23.4
}

:SHPROP
thread 'SHPROP'

:SHPROP_INIT
if
$PROPERTY2_BOUGHT == 0
then
goto @SHPROP_END
end

0@ = 0 // not player entered interior
1@ = 0 // marker flag
2@ = 0 // spheres created

:SHPROP_MARKER
wait 0

// despawn everything if player is on a mission

if
    $ONMISSION == 1
then
    gosub @SHPROP_DISABLEMARKERSANDSPHERES
    0@ = 0
    1@ = 0
    2@ = 0
    jump @SHPROP_MARKER
end

if
    0121:  player $PLAYER_CHAR in_zone 'COM_EAS'
then
    if and
    $ONMISSION == 0
    1@ == 0
    0@ == 0
    then
    02A7: $NEWPORT_SAVE_MARKER = create_icon_marker_and_sphere 17 at 332.2 -432.19 23.4 
    018B: show_on_radar $NEWPORT_SAVE_MARKER 2
    1@ = 1
    end 
else
    goto @SHPROP_NOT_IN_ZONE
end

if and
0@ == 0
1@ == 1
2@ == 0
then
03BC: $NEWPORT_ENTRANCE_SPHERE = create_sphere 332.2 -432.19 23.4 1.5
2@ = 1
end

if and
0@ == 0
1@ == 1
2@ == 1
//00FF:   player $PLAYER_CHAR 0 332.2 -432.19 23.4 radius 1.0 1.0 2.0
00FF:   actor $PLAYER_ACTOR 0 332.2 -432.19 23.4 radius 1.0 1.0 1.5
then
$ONMISSION = 1
01B4: set_player $PLAYER_CHAR control 0
gosub @SHPROP_DISABLEMARKERSANDSPHERES
0@ = 1
1@ = 0
2@ = 0
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
0055: put_player $PLAYER_CHAR at 325.2 -421.4 35.76
fade 1 1500
01B4: set_player $PLAYER_CHAR control 1
03AD: set_rubbish 0
$ONMISSION = 0
end

// create exit sphere and save INFO pickup

if and
0@ == 1
2@ == 0
then
03BC: $NEWPORT_EXIT_SPHERE = create_sphere 327.43 -421.4 35.7 1.5
0213: $NEWPORT_SAVE_PICKUP = create_pickup #INFO type 3 at 321.5 -414.31 35.7
0213: $NEWPORT_HEALTH_PICKUP = create_pickup #HEALTH type 2 at 324.0 -428.65 35.7
032B: $NEWPORT_WEAPON_PICKUP = create_weapon_pickup #UZI 14 ammo 15 at 335.6306 -416.595 35.7612
2@ = 1
0@ = 1
end 

// if player is inside and pickup the info pickup
if and
0@ == 1
0214:   pickup $NEWPORT_SAVE_PICKUP picked_up
then
$ONMISSION = 1
goto @SHPROP_HANDLE_SAVES
end

// if the player is inside the interior make the exit sphere work

if and
    0@ == 1
    2@ == 1
    00FF:   actor $PLAYER_ACTOR 0 327.43 -421.4 35.7 radius 1.0 1.0 1.5
then
    $ONMISSION = 1
    01B4: set_player $PLAYER_CHAR control 0
    gosub @SHPROP_DISABLEMARKERSANDSPHERES
    fade 0 1500
    wait 1500
    0@ = 0
    2@ = 0
    1@ = 0
    0055: put_player $PLAYER_CHAR at 332.2815 -435.28 23.459
    fade 1 1500
    $ONMISSION = 0
    01B4: set_player $PLAYER_CHAR control 1
    03AD: set_rubbish 1
    goto @SHPROP_MARKER
end

goto @SHPROP_MARKER

// if the player exit the zone disable the marker and sphere
:SHPROP_NOT_IN_ZONE
if and
    2@ == 1
    1@ == 1
    0@ == 0
then
    0164: disable_marker $NEWPORT_SAVE_MARKER
    03BD: destroy_sphere $NEWPORT_ENTRANCE_SPHERE
    0215: destroy_pickup $NEWPORT_SAVE_PICKUP
    0215: destroy_pickup $NEWPORT_HEALTH_PICKUP
    0215: destroy_pickup $NEWPORT_WEAPON_PICKUP
    0@ = 0
    1@ = 0
    2@ = 0
end

if and
   2@ == 1
   1@ == 0
   0@ == 1
then
   03BD: destroy_sphere $NEWPORT_EXIT_SPHERE
   0@ = 0
   2@ = 0 
end

jump @SHPROP_MARKER 

:SHPROP_DISABLEMARKERSANDSPHERES
0164: disable_marker $NEWPORT_SAVE_MARKER
03BD: destroy_sphere $NEWPORT_ENTRANCE_SPHERE
03BD: destroy_sphere $NEWPORT_EXIT_SPHERE
0215: destroy_pickup $NEWPORT_SAVE_PICKUP
0215: destroy_pickup $NEWPORT_HEALTH_PICKUP
0215: destroy_pickup $NEWPORT_WEAPON_PICKUP
return

:SHPROP_HANDLE_SAVES
01B4: set_player $PLAYER_CHAR control 0
03D8: show_save_screen

:SHPROP_HANDLE_SAVES_DONE
wait 0
0215: destroy_pickup $NEWPORT_SAVE_PICKUP
0169: set_fade_color 0 0 0
fade 0 0

if
03D9:   save_done
then
GOSUB @SHPROP_HANDLE_SAVES_SUCCESS
else
jump @SHPROP_HANDLE_SAVES_DONE
end
jump @SHPROP_MARKER

:SHPROP_HANDLE_SAVES_SUCCESS
$ONMISSION = 0
2@ = 0
01B4: set_player $PLAYER_CHAR control 1
wait 500
00A1: put_actor $PLAYER_ACTOR at 324.2199 -415.7384 34.0
fade 1 1500
0215: destroy_pickup $NEWPORT_HEALTH_PICKUP
0215: destroy_pickup $NEWPORT_WEAPON_PICKUP
03BD: destroy_sphere $NEWPORT_EXIT_SPHERE
return

:SHPROP_END
end_thread