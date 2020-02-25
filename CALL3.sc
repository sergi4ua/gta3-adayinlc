:CALL3
thread 'CALL3'
gosub @CALL3_CODE
if 
wasted_or_busted
Jf @CALL3_SKIP 
gosub @CALL3_FAIL

:CALL3_SKIP 
gosub @CALL3_CLEANUP
end_thread

:CALL3_CODE
00BA: show_text_styled GXT 'MIS11' time 3000 style 2  // Text
increment_mission_attempts
$ONMISSION = 1
0110: clear_player $PLAYER_CHAR wanted_level
SET_PLAYER_CONTROL $PLAYER_CHAR FALSE
TOGGLE_WIDESCREEN TRUE
00A1: put_actor $PLAYER_ACTOR at 938.4684 -230.1898 3.9431
SET_CHAR_HEADING $PLAYER_ACTOR 0.0
00BC: show_text_highpriority GXT 'MIS11_0' time 5000 flag 1
wait 5000
fade 0 1500
wait 1500
TOGGLE_WIDESCREEN FALSE
SET_PLAYER_CONTROL $PLAYER_CHAR TRUE

REQUEST_MODEL #GANG03
request_model #GANG04
REQUEST_MODEL #COLT45

fade 1 1500

:CALL3_OBJ1
00BC: show_text_highpriority GXT 'MIS11_1' time 5000 flag 1 
0213: $MIS_PICKUP = create_pickup #BRIEFCASE type 3 at 989.8823 -443.0477 15.1238
03DC: $MIS_MARKER1 = create_marker_above_pickup $MIS_PICKUP

:CALL3_OBJ1_LOOP
wait 0

if
has_pickup_been_collected $MIS_PICKUP
then
00BC: show_text_highpriority GXT 'MIS11_2' time 5000 flag 1
009A: $MIS_BADGUY1 = create_actor_pedtype 8 model #GANG03 at 979.55 -441.6981 14.9509
009A: $MIS_BADGUY2 = create_actor_pedtype 8 model #GANG04 at 977.1899 -441.8779 14.9753
009A: $MIS_BADGUY3 = create_actor_pedtype 8 model #GANG04 at 947.9592 -441.1775 14.9015
SET_CHAR_HEADING $MIS_BADGUY1 184.0
SET_CHAR_HEADING $MIS_BADGUY2 184.0
SET_CHAR_HEADING $MIS_BADGUY3 208.5
01CB: actor $MIS_BADGUY1 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_BADGUY2 kill_actor $PLAYER_ACTOR
01CB: actor $MIS_BADGUY3 kill_actor $PLAYER_ACTOR
01B2: give_actor $MIS_BADGUY1 weapon 2 ammo 999
01B2: give_actor $MIS_BADGUY2 weapon 2 ammo 999
01B2: give_actor $MIS_BADGUY3 weapon 2 ammo 999
goto @CALL3_OBJ2
end

goto @CALL3_OBJ1_LOOP

:CALL3_OBJ2
03BC: $MIS_SPHERE = create_sphere 1157.0001 -96.4248 7.6461 1.5
018A: $MIS_MARKER2 = create_checkpoint_at 1157.0001 -96.4248 7.6461

:CALL3_OBJ2_LOOP
wait 0

if
00FF:   actor $PLAYER_ACTOR 0 1157.0001 -96.4248 7.6461 radius 1.5 1.5 1.5
then
goto @CALL3_PASS
end

goto @CALL3_OBJ2_LOOP

:CALL3_OBJ_LOOP

:CALL3_PASS
wait 0
01E3: text_1number_styled 'M_PASS' 1000 5000 ms 1 
0109: player $PLAYER_CHAR money += 1000
0110: clear_player $PLAYER_CHAR wanted_level
0394: play_music 1
030C: set_mission_points += 1
$PORTLAND_P1_COMPLETED += 1
0318: set_latest_mission_passed 'MIS11'
02A7: $PORTLAND_MISSION_MARKER1 = create_icon_marker_and_sphere 8 at 938.4176 -230.3259 4.943
create_thread @P1_MIS
gosub @CALL3_SKIP
return

:CALL3_FAIL
00BA: text_styled 'M_FAIL' 5000 ms 1
$ONMISSION = 0 
02A7: $PORTLAND_MISSION_MARKER1 = create_icon_marker_and_sphere 8 at 938.4176 -230.3259 4.943
create_thread @P1_MIS
mission_cleanup
return

:CALL3_CLEANUP 
REMOVE_BLIP $MIS_MARKER1
REMOVE_BLIP $MIS_MARKER2
REMOVE_SPHERE $MIS_SPHERE
REMOVE_PICKUP $MIS_PICKUP
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR1
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR2
MARK_CHAR_AS_NO_LONGER_NEEDED $MIS_ACTOR3
$ONMISSION = 0
mission_cleanup
return