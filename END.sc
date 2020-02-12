:CAT1_5482
thread 'END'
023C: load_special_actor 'MARIA' as 1
LOAD_REQUESTED_MODELS
wait 3000

02E4: load_cutscene_data 'END' 
0451: load_end_of_game_audio 
0244: set_cutscene_pos -1031.75 451.75 22.5 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $157 = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $157 'MARIA' 

:CAT1_5568
fade 1 1500 
03AD: set_rubbish 0 
02E7: start_cutscene 
043F: play_cutscene_music 
02E8: $CUT_SCENE_TIME = cutscenetime 

:CAT1_5588
if 
  5507 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5623 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5588 

:CAT1_5623
00BC: text_highpriority 'END_A' 10000 ms 2  // Residents in Cedar Grove have been coming to terms

:CAT1_5638
if 
  7855 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5673 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5638 

:CAT1_5673
00BC: text_highpriority 'END_B' 10000 ms 2  // with the emotional aftermath of a full blown war

:CAT1_5688
if 
  10313 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5723 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5688 

:CAT1_5723
00BC: text_highpriority 'END_C' 10000 ms 2  // that hit the area yesterday.

:CAT1_5738
if 
  13610 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5773 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5738 

:CAT1_5773
00BC: text_highpriority 'END_D' 10000 ms 2  // Local resident, Clive Denver described to police

:CAT1_5788
if 
  16428 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5823 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5788 

:CAT1_5823
00BC: text_highpriority 'END_E' 10000 ms 2  // a single gunman that he saw fleeing the scene, with a dark haired woman.

:CAT1_5838
if 
  20514 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5873 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5838 

:CAT1_5873
00BC: text_highpriority 'END_F' 10000 ms 2  // Oh, you know, we're gonna have such fun, 'cos you know, you know,

:CAT1_5888
if 
  22827 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5923 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5888 

:CAT1_5923
00BC: text_highpriority 'END_G' 10000 ms 2  // I love you, I, I, I, I really do, 'cos you're such a big strong man

:CAT1_5938
if 
  26173 > $CUT_SCENE_TIME // integer values 
jf @CAT1_5973 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5938 

:CAT1_5973
00BC: text_highpriority 'END_H' 10000 ms 2  // and that's just what I need.

:CAT1_5988
if 
  28028 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6023 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_5988 

:CAT1_6023
00BC: text_highpriority 'END_I' 10000 ms 2  // Anyway, what was I saying?

:CAT1_6038
if 
  29276 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6073 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6038 

:CAT1_6073
00BC: text_highpriority 'END_J' 10000 ms 2  // Oh, you know, I forget. But you know what it's like, don't you?

:CAT1_6088
if 
  31901 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6123 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6088 

:CAT1_6123
00BC: text_highpriority 'END_K' 10000 ms 2  // The sound of explosions shook nearby homes as people ran for cover.

:CAT1_6138
if 
  35772 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6175 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6138 

:CAT1_6175
00BC: text_highpriority 'END_L' 10000 ms 2  // Several citizens were injured in the panic as ground fire was exchanged

:CAT1_6190
if 
  38820 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6227 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6190 

:CAT1_6227
00BC: text_highpriority 'END_M' 10000 ms 2  // between ground forces and a helicopter circling the dam.

:CAT1_6242
if 
  42136 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6279 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6242 

:CAT1_6279
00BC: text_highpriority 'END_N' 10000 ms 2  // Yeah, we got a good view from down here in the gardens.

:CAT1_6294
if 
  44646 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6331 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6294 

:CAT1_6331
00BC: text_highpriority 'END_O' 10000 ms 2  // When the 'copter finally got taken out,

:CAT1_6346
if 
  46971 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6383 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6346 

:CAT1_6383
00BC: text_highpriority 'END_P' 10000 ms 2  // better than the fireworks on the 4th of July.

:CAT1_6398
if 
  49254 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6435 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6398 

:CAT1_6435
00BC: text_highpriority 'END_Q' 10000 ms 2  // With the death toll already over twenty,

:CAT1_6450
if 
  51621 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6487 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6450 

:CAT1_6487
00BC: text_highpriority 'END_R' 10000 ms 2  // police are still finding bodies.

:CAT1_6502
if 
  54000 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6539 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6502 

:CAT1_6539
00BC: text_highpriority 'END_S' 10000 ms 2  // There have been no official denials concerning rumours

:CAT1_6554
if 
  56584 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6591 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6554 

:CAT1_6591
00BC: text_highpriority 'END_T' 10000 ms 2  // that the dead were members of the Colombian Cartel,

:CAT1_6606
if 
  59278 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6643 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6606 

:CAT1_6643
00BC: text_highpriority 'END_U' 4000 ms 2  // and still no leads as to the cause of the massacre.

:CAT1_6658
if 
  66666 > $CUT_SCENE_TIME // integer values 
jf @CAT1_6695 
wait 0 
02E8: $CUT_SCENE_TIME = cutscenetime 
jump @CAT1_6658 

:CAT1_6695
043C: unknown_set_game_sounds 0 
0169: set_fade_color 1 1 1 
fade 0 2000 

:CAT1_6714
if 
fading 
jf @CAT1_6738 
wait 0 
jump @CAT1_6714 

:CAT1_6738
if 
82E9:   not cutscene_reached_end 
jf @CAT1_6762 
wait 0 
jump @CAT1_6738 

:CAT1_6762
00BE: text_clear_all 
02EA: end_cutscene 

:CAT1_7115
wait 0 
01B4: set_player $PLAYER_CHAR frozen_state 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0336:  $PLAYER_CHAR 0 
03AD: set_rubbish 0 
02A3: toggle_widescreen 1 
0109: player $PLAYER_CHAR money += 1000000 
0434: show_credits 
16@ = 0 // integer values 
00C0: set_current_time 2 40 
jump @CAT1_7291 

:CAT1_7180
if 
8436:   not reached_end_of_credits 
jf @CAT1_9167 
wait 0 
if 
  $4306 == 0 // integer values 
jf @CAT1_7556 
fade 0 1500 

:CAT1_7222
if 
fading 
jf @CAT1_7291 
wait 0 
if 
  16@ > 40000 // integer values 
jf @CAT1_7284 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7284 
jump @CAT1_9167 

:CAT1_7284
jump @CAT1_7222 

:CAT1_7291
0055: put_player $PLAYER_CHAR at -361.875 248.0 -100.0 
015F: set_camera_position -364.375 265.0625 82.8125 0.0 0.0 0.0 
0160: point_camera -363.9375 264.1875 82.625 2 
17@ = 0 // integer values 

:CAT1_7345
if 
  20000 > 17@ // integer values 
jf @CAT1_7440 
wait 0 
if 
  16@ > 40000 // integer values 
jf @CAT1_7413 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7413 
jump @CAT1_9167 

:CAT1_7413
if 
0436:   reached_end_of_credits 
jf @CAT1_7433 
jump @CAT1_9167 

:CAT1_7433
jump @CAT1_7345 

:CAT1_7440
fade 1 1500 
17@ = 0 // integer values 

:CAT1_7454
if 
  30000 > 17@ // integer values 
jf @CAT1_7549 
wait 0 
if 
  16@ > 40000 // integer values 
jf @CAT1_7522 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7522 
jump @CAT1_9167 

:CAT1_7522
if 
0436:   reached_end_of_credits 
jf @CAT1_7542 
jump @CAT1_9167 

:CAT1_7542
jump @CAT1_7454 

:CAT1_7549
$4306 = 1 // integer values 

:CAT1_7556
if 
  $4306 == 1 // integer values 
jf @CAT1_7878 
fade 0 1500 

:CAT1_7581
if 
fading 
jf @CAT1_7649 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7622 
jump @CAT1_9167 

:CAT1_7622
if 
0436:   reached_end_of_credits 
jf @CAT1_7642 
jump @CAT1_9167 

:CAT1_7642
jump @CAT1_7581 

:CAT1_7649
0055: put_player $PLAYER_CHAR at -1174.25 -7.0 -100.0 
015F: set_camera_position -1176.438 -17.6875 75.9375 0.0 0.0 0.0 
0160: point_camera -1175.688 -17.0 75.8125 2 
00C0: set_current_time 5 40 
17@ = 0 // integer values 

:CAT1_7709
if 
  20000 > 17@ // integer values 
jf @CAT1_7783 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7756 
jump @CAT1_9167 

:CAT1_7756
if 
0436:   reached_end_of_credits 
jf @CAT1_7776 
jump @CAT1_9167 

:CAT1_7776
jump @CAT1_7709 

:CAT1_7783
fade 1 1500 
17@ = 0 // integer values 

:CAT1_7797
if 
  30000 > 17@ // integer values 
jf @CAT1_7871 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7844 
jump @CAT1_9167 

:CAT1_7844
if 
0436:   reached_end_of_credits 
jf @CAT1_7864 
jump @CAT1_9167 

:CAT1_7864
jump @CAT1_7797 

:CAT1_7871
$4306 = 2 // integer values 

:CAT1_7878
if 
  $4306 == 2 // integer values 
jf @CAT1_8194 
fade 0 1500 

:CAT1_7903
if 
fading 
jf @CAT1_7971 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_7944 
jump @CAT1_9167 

:CAT1_7944
if 
0436:   reached_end_of_credits 
jf @CAT1_7964 
jump @CAT1_9167 

:CAT1_7964
jump @CAT1_7903 

:CAT1_7971
0055: put_player $PLAYER_CHAR at -468.6875 -3.25 -100.0 
015F: set_camera_position -413.0625 19.25 54.375 0.0 0.0 0.0 
0160: point_camera -413.9375 18.9375 54.0 2 
17@ = 0 // integer values 

:CAT1_8025
if 
  20000 > 17@ // integer values 
jf @CAT1_8099 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8072 
jump @CAT1_9167 

:CAT1_8072
if 
0436:   reached_end_of_credits 
jf @CAT1_8092 
jump @CAT1_9167 

:CAT1_8092
jump @CAT1_8025 

:CAT1_8099
fade 1 1500 
17@ = 0 // integer values 

:CAT1_8113
if 
  30000 > 17@ // integer values 
jf @CAT1_8187 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8160 
jump @CAT1_9167 

:CAT1_8160
if 
0436:   reached_end_of_credits 
jf @CAT1_8180 
jump @CAT1_9167 

:CAT1_8180
jump @CAT1_8113 

:CAT1_8187
$4306 = 3 // integer values 

:CAT1_8194
if 
  $4306 == 3 // integer values 
jf @CAT1_8516 
fade 0 1500 

:CAT1_8219
if 
fading 
jf @CAT1_8287 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8260 
jump @CAT1_9167 

:CAT1_8260
if 
0436:   reached_end_of_credits 
jf @CAT1_8280 
jump @CAT1_9167 

:CAT1_8280
jump @CAT1_8219 

:CAT1_8287
0055: put_player $PLAYER_CHAR at -855.6875 -717.25 -100.0 
015F: set_camera_position -959.5 -656.375 55.4375 0.0 0.0 0.0 
0160: point_camera -958.625 -656.875 55.25 2 
00C0: set_current_time 22 0 
17@ = 0 // integer values 

:CAT1_8347
if 
  20000 > 17@ // integer values 
jf @CAT1_8421 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8394 
jump @CAT1_9167 

:CAT1_8394
if 
0436:   reached_end_of_credits 
jf @CAT1_8414 
jump @CAT1_9167 

:CAT1_8414
jump @CAT1_8347 

:CAT1_8421
fade 1 1500 
17@ = 0 // integer values 

:CAT1_8435
if 
  30000 > 17@ // integer values 
jf @CAT1_8509 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8482 
jump @CAT1_9167 

:CAT1_8482
if 
0436:   reached_end_of_credits 
jf @CAT1_8502 
jump @CAT1_9167 

:CAT1_8502
jump @CAT1_8435 

:CAT1_8509
$4306 = 4 // integer values 

:CAT1_8516
if 
  $4306 == 4 // integer values 
jf @CAT1_8832 
fade 0 1500 

:CAT1_8541
if 
fading 
jf @CAT1_8609 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8582 
jump @CAT1_9167 

:CAT1_8582
if 
0436:   reached_end_of_credits 
jf @CAT1_8602 
jump @CAT1_9167 

:CAT1_8602
jump @CAT1_8541 

:CAT1_8609
0055: put_player $PLAYER_CHAR at -532.6875 -611.6875 43.25 
015F: set_camera_position -571.5625 -611.125 67.5625 0.0 0.0 0.0 
0160: point_camera -570.6875 -611.5625 67.4375 2 
17@ = 0 // integer values 

:CAT1_8663
if 
  20000 > 17@ // integer values 
jf @CAT1_8737 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8710 
jump @CAT1_9167 

:CAT1_8710
if 
0436:   reached_end_of_credits 
jf @CAT1_8730 
jump @CAT1_9167 

:CAT1_8730
jump @CAT1_8663 

:CAT1_8737
fade 1 1500 
17@ = 0 // integer values 

:CAT1_8751
if 
  30000 > 17@ // integer values 
jf @CAT1_8825 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8798 
jump @CAT1_9167 

:CAT1_8798
if 
0436:   reached_end_of_credits 
jf @CAT1_8818 
jump @CAT1_9167 

:CAT1_8818
jump @CAT1_8751 

:CAT1_8825
$4306 = 5 // integer values 

:CAT1_8832
if 
  $4306 == 5 // integer values 
jf @CAT1_9160 
fade 0 1500 

:CAT1_8857
if 
fading 
jf @CAT1_8925 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_8898 
jump @CAT1_9167 

:CAT1_8898
if 
0436:   reached_end_of_credits 
jf @CAT1_8918 
jump @CAT1_9167 

:CAT1_8918
jump @CAT1_8857 

:CAT1_8925
0055: put_player $PLAYER_CHAR at -671.5625 -155.875 -100.0 
015F: set_camera_position -706.5625 -219.0625 25.75 0.0 0.0 0.0 
0160: point_camera -706.125 -218.1875 25.6875 2 
00C0: set_current_time 1 20 
set_weather 2 
17@ = 0 // integer values 

:CAT1_8989
if 
  20000 > 17@ // integer values 
jf @CAT1_9063 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_9036 
jump @CAT1_9167 

:CAT1_9036
if 
0436:   reached_end_of_credits 
jf @CAT1_9056 
jump @CAT1_9167 

:CAT1_9056
jump @CAT1_8989 

:CAT1_9063
fade 1 1500 
17@ = 0 // integer values 

:CAT1_9077
if 
  40000 > 17@ // integer values 
jf @CAT1_9153 
wait 0 
if 
00E1:   pad 0 key_pressed 16 
jf @CAT1_9126 
jump @CAT1_9167 

:CAT1_9126
if 
0436:   reached_end_of_credits 
jf @CAT1_9146 
jump @CAT1_9167 

:CAT1_9146
jump @CAT1_9077 

:CAT1_9153
$4306 = 0 // integer values 

:CAT1_9160
jump @CAT1_7180 

:CAT1_9167
0435: end_credits 
00C0: set_current_time 7 0 
043C: unknown_set_game_sounds 1  

:CAT1_9210
0336:  $PLAYER_CHAR 1 
0222: set_player $PLAYER_CHAR health_to 100 
0395: clear_area 1 at -666.75 -1.75 range 18.75 2.0 
0055: put_player $PLAYER_CHAR at -666.75 -1.75 -100.0 
03CB: set_camera -666.75 -1.75 19.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
02EB: restore_camera_with_jumpcut 
03C8: rotate_player-180-degrees 
02A3: toggle_widescreen 0 
17@ = 0 // integer values 
$ONMISSION = 0 // integer values 
$367 = 0 // integer values 
17@ = 0 // integer values 
0296: unload_special_actor 1
mission_cleanup
end_thread