:MISTRG
thread 'MISTRG'
wait 0
create_thread @P1_MIS
create_thread @P2_MIS
create_thread @S1_MIS
create_thread @S2_MIS
end_thread

:P1_MIS
thread 'P1_MIS'

:P1_IF_ALL_MISSIONS_COMPLETE
if or
$PORTLAND_P1_COMPLETED == 6
$PORTLAND_P1_COMPLETED == 5
$PORTLAND_P1_COMPLETED == 4
$PORTLAND_P1_COMPLETED == 3
then
0164: disable_marker $PORTLAND_MISSION_MARKER1
end_thread
end

:P1_MIS_PHONES
wait 0
if
$ONMISSION == 1
then
024E: disable_phone $PHONE_PORTLAND1
else
0405: enable_phone $PHONE_PORTLAND1
end

:P1_MISSION_CHECKER
if and
$ONMISSION == 0
0256:   player $PLAYER_CHAR defined
0121:   player $PLAYER_CHAR in_zone 'TOWERS'
00F6:   player $PLAYER_CHAR 0 938.4176 -230.3259 4.943 radius 1.0 1.0 2.0  
then
0164: disable_marker $PORTLAND_MISSION_MARKER1
0164: disable_marker $PORTLAND_MISSION_MARKER1
024E: disable_phone $PHONE_PORTLAND1
if
$PORTLAND_P1_COMPLETED == 0
then
0169: set_fade_color 0 0 0
start_mission 0
end

if
$PORTLAND_P1_COMPLETED == 1
then
0169: set_fade_color 0 0 0
start_mission 11
end

if
$PORTLAND_P1_COMPLETED == 2
then
0169: set_fade_color 0 0 0
start_mission 1
end

$ONMISSION = 1
end_thread
end

jump @P1_MIS_PHONES

:P2_MIS
thread 'P2_MIS'

:P2_IF
if or
$PORTLAND_P1_COMPLETED == 3
$PORTLAND_P1_COMPLETED == 4
$PORTLAND_P1_COMPLETED == 5
then
if
$FLAG_P2_BADGER == 0
then
$FLAG_P2_BADGER = 1
014D: text_pager 'MIS2_4' 140 2 0
end
jump @P2_LOOP
else
end_thread
end

:P2_LOOP
wait 0
if and
$ONMISSION == 0
IS_PLAYER_DEFINED $PLAYER_CHAR
then
    if and
    00FF:   actor $PLAYER_ACTOR 0 1150.1812 -454.2873 20.648 radius 1.0 1.0 1.0
    $PORTLAND_P1_COMPLETED == 3
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS2' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission ODD1
    $ONMISSION = 1
    0164: disable_marker $PORTLAND_MISSION_MARKER2
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
    
    if and
    00FF:   actor $PLAYER_ACTOR 0 1150.1812 -454.2873 20.648 radius 1.0 1.0 1.0
    $PORTLAND_P1_COMPLETED == 4
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS3' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission ODD2
    $ONMISSION = 1
    0164: disable_marker $PORTLAND_MISSION_MARKER2
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
    
    if and
    00FF:   actor $PLAYER_ACTOR 0 1150.1812 -454.2873 20.648 radius 1.0 1.0 1.0
    $PORTLAND_P1_COMPLETED == 5
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS4' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission ODD3
    $ONMISSION = 1
    0164: disable_marker $PORTLAND_MISSION_MARKER2
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
end
goto @P2_LOOP

end_thread

:S1_MIS
thread 'S1_MIS'

:S1_LOOP
wait 0

if
$PORTLAND_P1_COMPLETED == 6
then
gosub @S1_PAGER
jump @S1_CHECKER
else
goto @S1_END
end

goto @S1_LOOP

:S1_PAGER
if
$FLAG_8BALL_PAGER == 0
then
$FLAG_8BALL_PAGER = 1
014D: text_pager 'MIS5_PA' 140 2 0
return
else
return
end

:S1_CHECKER
wait 0

if and
$ONMISSION == 0
IS_PLAYER_DEFINED $PLAYER_CHAR
then
    if and
    00FF:   actor $PLAYER_ACTOR 0 374.3439 -568.5399 26.1748 radius 1.0 1.0 1.0
    $STAUNTON_P2_COMPLETED == 0
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS5' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission EIGHT1
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER1
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
    
    if and
    00FF:   actor $PLAYER_ACTOR 0 374.3439 -568.5399 26.1748 radius 1.0 1.0 1.0
    $STAUNTON_P2_COMPLETED == 1
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS6' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission EIGHT2
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER1
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
    
    if and
    00FF:   actor $PLAYER_ACTOR 0 374.3439 -568.5399 26.1748 radius 1.0 1.0 1.0
    $STAUNTON_P2_COMPLETED == 2
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS8' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission EIGHT3
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER1
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
    
    if and
    00FF:   actor $PLAYER_ACTOR 0 374.3439 -568.5399 26.1748 radius 1.0 1.0 1.0
    $STAUNTON_P2_COMPLETED == 3
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS9' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission EIGHT4
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER1
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
end

goto @S1_CHECKER

:S1_END
end_thread

:S2_MIS
thread 'S2_MIS'

:S2_LOOP
wait 0
//01E5: show_text_1number_highpriority GXT 'NUMBER' number $STAUNTON_P2_COMPLETED time 5000 flag 1  // ~s~You need $~1~ to compete.

if
    $STAUNTON_BONUS_MISSION0 == 1
then
    jump @S2_CHECKER
else
    if
        $STAUNTON_BONUS_MISSION0 == 2
    then
        jump @S2_CHECKER2
    else
        if
        $STAUNTON_BONUS_MISSION0 == 3
        then
            jump @S2_CHECKER3
        else
            goto @S2_END
        end
    end
end

goto @S2_LOOP

:S2_CHECKER
wait 0

//01E5: show_text_1number_highpriority GXT 'M_PASS' number $FLAG_8BALL_PAGER time 5000 flag 1  // ~s~You need $~1~ to compete.

if and
$ONMISSION == 0
IS_PLAYER_DEFINED $PLAYER_CHAR
then
    if and
    00FF:   actor $PLAYER_ACTOR 0 196.9798 -628.9261 26.1674 radius 1.0 1.0 1.0
    $STAUNTON_BONUS_MISSION0 == 1
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS7' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    03BA: clear_cars_from_cube 239.5074 -613.5795 26.1682 144.3333 -627.5867 59.4458
    start_mission ODD4
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER2
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
end

goto @S2_CHECKER

:S2_CHECKER2
wait 0

if and
$ONMISSION == 0
IS_PLAYER_DEFINED $PLAYER_CHAR
then
    if and
    00FF:   actor $PLAYER_ACTOR 0 80.0474 -958.9118 26.1681 radius 1.0 1.0 1.0
    $STAUNTON_BONUS_MISSION0 == 2
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS10' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    03BA: clear_cars_from_cube 239.5074 -613.5795 26.1682 144.3333 -627.5867 59.4458
    start_mission ODD5
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER2
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
end

goto @S2_CHECKER2

:S2_CHECKER3
wait 0

if and
$ONMISSION == 0
IS_PLAYER_DEFINED $PLAYER_CHAR
then
    if and
    00FF:   actor $PLAYER_ACTOR 0 502.5407 -66.3449 4.2155 radius 1.0 1.0 1.0
    $STAUNTON_BONUS_MISSION0 == 3
    then
    01B4: set_player $PLAYER_CHAR control 0
    0217: text_styled 'MIS12' time 3000 style 2
    0169: set_fade_color 0 0 0
    fade 0 1500
    wait 1500
    start_mission ODD6
    $ONMISSION = 1
    0164: disable_marker $STAUNTON_MISSION_MARKER3
    01B4: set_player $PLAYER_CHAR control 1
    end_thread
    end
end

goto @S2_CHECKER3

:S2_END
end_thread