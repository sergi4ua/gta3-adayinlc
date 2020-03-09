:PROP
thread 'PROP'
if
$PROPERTIES_AVAILABLE == 1
jf @PROP_END
// if player have bought any properties, don't spawn the briefcase pickup

if
$PROPERTY0_BOUGHT == 0
then
0213: $PROPERTY_PICKUP0 = create_pickup #BRIEFCASE type 3 at 158.3013 -1011.3917 26.0
end

if
$PROPERTY1_BOUGHT == 0
then
0213: $PROPERTY_PICKUP1 = create_pickup #BRIEFCASE type 3 at 397.4659 -1195.2642 26.1682
end

if
$PROPERTY2_BOUGHT == 0
then
0213: $PROPERTY_PICKUP2 = create_pickup #BRIEFCASE type 3 at 289.8 -432.4 26.0
end

018B: show_on_radar $PROPERTY_ICON0 2
018B: show_on_radar $PROPERTY_ICON1 2


:PROP_LOOP
wait 0

if and
$PROPERTY0_BOUGHT == 0
0214:   pickup $PROPERTY_PICKUP0 picked_up
then
goto @PROP_1CONF
end

if and
$PROPERTY1_BOUGHT == 0
0214:   pickup $PROPERTY_PICKUP1 picked_up
then
goto @PROP_2CONF
end

if and
$PROPERTY2_BOUGHT == 0
0214:   pickup $PROPERTY_PICKUP2 picked_up
then
goto @PROP_3CONF
end


goto @PROP_LOOP

/* FIRST PROPERTY */
                  
:PROP_1CONF
wait 0
    if
        $ONMISSION == 1
    then
        03E5: show_text_box 'PROPWOR'
        goto @PROP_CLEANUP
    else
        if
            010A:   player $PLAYER_CHAR money > 149999
        then 
            01B4: set_player $PLAYER_CHAR control 0
            01E5: show_text_1number_highpriority GXT 'PROP1' number 150000 time 5000 flag 1 
            goto @PROP_1CONF_KEY
        else
            03E5: show_text_box 'PROPNO'
            goto @PROP_CLEANUP
        end
    end

:PROP_1CONF_KEY
wait 0
16@ = 0

if
16@ > 4999
then
01E5: show_text_1number_highpriority GXT 'PROP1' number 150000 time 5000 flag 1 
16@ = 0
end 

if
00E1:   player 0 pressed_button 19
then
0109: player $PLAYER_CHAR money += -150000
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
TOGGLE_WIDESCREEN TRUE
015F: set_camera_position 150.9439 -1015.716 26.0182 rotation 0.0 0.0 0.0
0160: point_camera 159.5077 -991.7161 31.0909 switchstyle 2
fade 1 1500
wait 1500
TEXT_CLEAR_ALL
wait 500
00BA: show_text_styled GXT 'PROPBUY' time 3000 style 5  // Text
0394: play_music 1
wait 3000
01E4: text_1number_lowpriority 'PROP3' 200000 5000 ms 1
wait 5000
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
RESTORE_CAMERA
$PROPERTY0_BOUGHT = 1
goto @PROP_CLEANUP
end

goto @PROP_1CONF_KEY

/* SECOND PROPERTY */

:PROP_2CONF
wait 0
    if
        $ONMISSION == 1
    then
        03E5: show_text_box 'PROPWOR'
        goto @PROP_CLEANUP
    else
        if
            010A:   player $PLAYER_CHAR money > 299999
        then 
            01B4: set_player $PLAYER_CHAR control 0
            01E5: show_text_1number_highpriority GXT 'PROP1' number 300000 time 5000 flag 1 
            goto @PROP_2CONF_KEY
        else
            03E5: show_text_box 'PROPNO'
            goto @PROP_CLEANUP
        end
    end

:PROP_2CONF_KEY
wait 0
16@ = 0

if
16@ > 4999
then
01E5: show_text_1number_highpriority GXT 'PROP1' number 300000 time 5000 flag 1 
16@ = 0
end 

if
00E1:   player 0 pressed_button 19
then
0109: player $PLAYER_CHAR money += -300000
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
TOGGLE_WIDESCREEN TRUE
015F: set_camera_position 420.7668 -1223.8219 31.1652 rotation 0.0 0.0 0.0
0160: point_camera 397.9051 -1160.1255 57.0936 switchstyle 2
fade 1 1500
wait 1500
TEXT_CLEAR_ALL
wait 500
00BA: show_text_styled GXT 'PROPBUY' time 3000 style 5  // Text
0394: play_music 1
wait 3000
01E4: text_1number_lowpriority 'PROP3' 500000 5000 ms 1
wait 5000
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
RESTORE_CAMERA
$PROPERTY1_BOUGHT = 1
goto @PROP_CLEANUP
end

if
00E1:   player 0 pressed_button 15
then
goto @PROP_CLEANUP
end

goto @PROP_2CONF_KEY

// THIRD PROPERTY

:PROP_3CONF
wait 0
    if
        $ONMISSION == 1
    then
        03E5: show_text_box 'PROPWOR'
        goto @PROP_CLEANUP
    else
        if
            010A:   player $PLAYER_CHAR money > 99999
        then 
            01B4: set_player $PLAYER_CHAR control 0
            01E5: show_text_1number_highpriority GXT 'PROP1' number 100000 time 5000 flag 1 
            goto @PROP_3CONF_KEY
        else
            03E5: show_text_box 'PROPNO'
            goto @PROP_CLEANUP
        end
    end

:PROP_3CONF_KEY
wait 0
16@ = 0

if
16@ > 4999
then
01E5: show_text_1number_highpriority GXT 'PROP1' number 300000 time 5000 flag 1 
16@ = 0
end 

if
00E1:   player 0 pressed_button 19
then
0109: player $PLAYER_CHAR money += -100000
0169: set_fade_color 0 0 0
fade 0 1500
wait 1500
TOGGLE_WIDESCREEN TRUE
0055: put_player $PLAYER_CHAR at 289.873 -436.3943 26.0248
015F: set_camera_position 295.0234 -446.0459 26.0248 rotation 0.0 0.0 0.0
0160: point_camera 293.3395 -431.3837 26.0248 switchstyle 2
fade 1 1500
wait 1500
TEXT_CLEAR_ALL
wait 500
00BA: show_text_styled GXT 'PROPBUY' time 3000 style 5  // Text
0394: play_music 1
wait 3000
01E4: text_1number_lowpriority 'PROP4' 0 5000 ms 1
wait 5000
TOGGLE_WIDESCREEN FALSE
0373: set_camera_directly_behind_player
RESTORE_CAMERA
$PROPERTY2_BOUGHT = 1
create_thread @SHPROP
goto @PROP_CLEANUP
end

if
00E1:   player 0 pressed_button 15
then
goto @PROP_CLEANUP
end

goto @PROP_3CONF_KEY

:PROP_CLEANUP
TEXT_CLEAR_ALL
01B4: set_player $PLAYER_CHAR control 1
0215: destroy_pickup $PROPERTY_PICKUP0
wait 3000
goto @PROP

:PROP_END
018B: show_on_radar $PROPERTY_ICON0 0
018B: show_on_radar $PROPERTY_ICON1 0
end_thread

:PROPM
thread 'PROPM'
$PROPERTY0_MONEY = 0
$PROPERTY1_MONEY = 0
$FLAG_PROPERTY0_MONEYPICKUP = 0
$FLAG_PROPERTY1_MONEYPICKUP = 0
$PROP_TIME = 0
$PROP2_TIME = 0

:PROPM_LOOP
wait 0

if and
$PROPERTIES_AVAILABLE == 1
$PROPERTY0_BOUGHT == 1
$FLAG_PROPERTY0_MONEYPICKUP == 0
then
$FLAG_PROPERTY0_MONEYPICKUP = 1
0213: 0@ = create_pickup #MONEY type 3 at 158.4647 -1016.8173 26.1682
end

if and
$PROPERTIES_AVAILABLE == 1
$PROPERTY1_BOUGHT == 1
$FLAG_PROPERTY1_MONEYPICKUP == 0
then
$FLAG_PROPERTY1_MONEYPICKUP = 1
0213: 1@ = create_pickup #MONEY type 3 at 395.5382 -1198.8009 26.1827
end

if
$PROPERTY0_BOUGHT == 1
then
//01E5: show_text_1number_highpriority GXT 'NUMBER' number $PROP_TIME time 5000 flag 1
$PROP_TIME += 5
end

if
$PROPERTY1_BOUGHT == 1
then
//01E5: show_text_1number_highpriority GXT 'NUMBER' number $PROP_TIME time 5000 flag 1
$PROP2_TIME += 5
end

if and
$PROPERTY0_BOUGHT == 1
$PROP_TIME > 1000
then
    if
        $PROPERTY0_MONEY < 200000
    then
        $PROPERTY0_MONEY += 10000
    end
    
    $PROP_TIME = 0
end

if and
$PROPERTY1_BOUGHT == 1
$PROP2_TIME > 1000
then
    if
        $PROPERTY1_MONEY < 500000
    then
        $PROPERTY1_MONEY += 20000
    end
    
    $PROP2_TIME = 0
end

if
$PROPERTIES_AVAILABLE == 1
then
    if
        0214:   pickup 0@ picked_up
    then
        if and
            $PROPERTY0_BOUGHT == 1
            $FLAG_PROPERTY0_MONEYPICKUP == 1
        then
            0109: player $PLAYER_CHAR money += $PROPERTY0_MONEY
            $FLAG_PROPERTY0_MONEYPICKUP = 0
            01E5: show_text_1number_highpriority GXT 'PROP5' number $PROPERTY0_MONEY time 5000 flag 1  
            wait 5000
            goto @PROPM
        end
    end 
    
    if
        0214:   pickup 1@ picked_up
    then
        if and
            $PROPERTY1_BOUGHT == 1
            $FLAG_PROPERTY1_MONEYPICKUP == 1
        then
            0109: player $PLAYER_CHAR money += $PROPERTY1_MONEY
            $FLAG_PROPERTY1_MONEYPICKUP = 0
            01E5: show_text_1number_highpriority GXT 'PROP5' number $PROPERTY1_MONEY time 5000 flag 1  
            wait 5000
            goto @PROPM
        end
    end 
end 

goto @PROPM_LOOP
end_thread