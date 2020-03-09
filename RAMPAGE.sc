/*

    RAMPAGE SCRIPT
    
    $RAMPAGEXX_COMPLETED:
    0 - normal,
    1 - frenzy completed,
    2 - frenzy failed
    
*/

:RAMPAGE
SET_DEATHARREST_STATE 0 
thread 'RAMPAGE'
0408: set_total_rampages_to 5
$RAMPAGE00_SPAWNED = 0
$RAMPAGE00_COMPLETED = 0
$RAMPAGE01_SPAWNED = 0
$RAMPAGE01_COMPLETED = 0
$RAMPAGE02_SPAWNED = 0
$RAMPAGE02_COMPLETED = 0
$RAMPAGE03_SPAWNED = 0
$RAMPAGE03_COMPLETED = 0
$RAMPAGE04_SPAWNED = 0
$RAMPAGE04_COMPLETED = 0
$RAMPAGE_COUNTER = 0
$RAMPAGE_STATUS = 0
read_kill_frenzy_status $RAMPAGE_STATUS 

:RAMPAGE_LOOP
wait 0
read_kill_frenzy_status $RAMPAGE_STATUS
//03F0: enable_text_draw 1
//045B: draw_text_2numbers 320.0 390.0 GXT 'DBG_NUM' numbers $RAMPAGE00_SPAWNED $RAMPAGE01_SPAWNED  // ~1~:~1~

// remove all rampages if the player is on a mission

if 
    $ONMISSION == 1
then
    if
        $RAMPAGE00_SPAWNED == 1
    then
        REMOVE_PICKUP $RAMPAGE00
        $RAMPAGE00_SPAWNED = 0
    end
    
    if
        $RAMPAGE01_SPAWNED == 1
    then
        REMOVE_PICKUP $RAMPAGE01
        $RAMPAGE01_SPAWNED = 0
    end
    
    if
        $RAMPAGE02_SPAWNED == 1
    then
        REMOVE_PICKUP $RAMPAGE02
        $RAMPAGE02_SPAWNED = 0
    end
    
    if
        $RAMPAGE03_SPAWNED == 1
    then
        REMOVE_PICKUP $RAMPAGE03
        $RAMPAGE03_SPAWNED = 0
    end
    
    if
        $RAMPAGE04_SPAWNED == 1
    then
        REMOVE_PICKUP $RAMPAGE04
        $RAMPAGE04_SPAWNED = 0
    end
end

// spawn RAMPAGE 1

if and
    $RAMPAGE00_COMPLETED == 0
    $ONMISSION == 0
    $RAMPAGE00_SPAWNED == 0
then
    0213: $RAMPAGE00 = create_pickup #KILLFRENZY type 3 at 1010.2549 -239.2666 6.6691
    $RAMPAGE00_SPAWNED = 1
end

// if RAMPAGE 1 pickup collected

if
    $ONMISSION == 0
then
    if and
        $RAMPAGE00_SPAWNED == 1
        has_pickup_been_collected $RAMPAGE00
    then
        gosub @RAMPAGE_TEXT
        gosub @RAMPAGE_REMOVE_PICKUPS
        gosub @RAMPAGE_AUDIO
        goto @RAMPAGE00   // rampage 1
    end
end

// spawn RAMPAGE 2

if and
    $RAMPAGE01_COMPLETED == 0
    $ONMISSION == 0
    $RAMPAGE01_SPAWNED == 0
then
    0213: $RAMPAGE01 = create_pickup #KILLFRENZY type 3 at 1023.3477 -392.4742 14.9728
    $RAMPAGE01_SPAWNED = 1
end

// if RAMPAGE 2 pickup collected

if 
    $ONMISSION == 0
then
    if and
        $RAMPAGE01_SPAWNED == 1
        has_pickup_been_collected $RAMPAGE01
    then
        gosub @RAMPAGE_TEXT
        gosub @RAMPAGE_REMOVE_PICKUPS
        gosub @RAMPAGE_AUDIO
        goto @RAMPAGE01   // rampage 2
    end
end

// spawn RAMPAGE 3

if and
    $RAMPAGE02_COMPLETED == 0
    $ONMISSION == 0
    $RAMPAGE02_SPAWNED == 0
then
    0213: $RAMPAGE02 = create_pickup #KILLFRENZY type 3 at 800.6093 -302.0488 5.6075
    $RAMPAGE02_SPAWNED = 1
end

// if RAMPAGE 3 pickup collected

if 
    $ONMISSION == 0
then
    if and
        $RAMPAGE02_SPAWNED == 1
        has_pickup_been_collected $RAMPAGE02
    then
        gosub @RAMPAGE_TEXT
        gosub @RAMPAGE_REMOVE_PICKUPS
        gosub @RAMPAGE_AUDIO
        goto @RAMPAGE02   // rampage 3
    end
end

// spawn RAMPAGE 4

if and
    $RAMPAGE03_COMPLETED == 0
    $ONMISSION == 0
    $RAMPAGE03_SPAWNED == 0
then
    0213: $RAMPAGE03 = create_pickup #KILLFRENZY type 3 at 924.9133 -403.5043 29.1318
    $RAMPAGE03_SPAWNED = 1
end

// if RAMPAGE 4 pickup collected

if 
    $ONMISSION == 0
then
    if and
        $RAMPAGE03_SPAWNED == 1
        has_pickup_been_collected $RAMPAGE03
    then
        gosub @RAMPAGE_TEXT
        gosub @RAMPAGE_REMOVE_PICKUPS
        gosub @RAMPAGE_AUDIO
        goto @RAMPAGE03   // rampage 3
    end
end

// spawn RAMPAGE 5

if and
    $RAMPAGE04_COMPLETED == 0
    $ONMISSION == 0
    $RAMPAGE04_SPAWNED == 0
then
    0213: $RAMPAGE04 = create_pickup #KILLFRENZY type 3 at 39.4998 -724.0555 22.7562
    $RAMPAGE04_SPAWNED = 1
end

// if RAMPAGE 5 pickup collected

if 
    $ONMISSION == 0
then
    if and
        $RAMPAGE04_SPAWNED == 1
        has_pickup_been_collected $RAMPAGE04
    then
        gosub @RAMPAGE_TEXT
        gosub @RAMPAGE_REMOVE_PICKUPS
        gosub @RAMPAGE_AUDIO
        goto @RAMPAGE04   // rampage 5
    end
end

goto @RAMPAGE_LOOP

// RAMPAGE 1

:RAMPAGE00
$ONMISSION = 1
start_kill_frenzy 'PAGE_00' 6 120000 30 #GANG01 #GANG02 #PLAYERSDOOR #PLAYERSDOOR 0  
print_with_number_big 'PAGE_03' 30 6000 6  // Kill ~1~ Mafia in 120 seconds!
REQUEST_MODEL #GANG01 
REQUEST_MODEL #GANG02 
03DF: all_random_peds #MALE01 
read_kill_frenzy_status $RAMPAGE_STATUS 

:RAMPAGE00_LOOP // rampage 1 loop
wait 0
read_kill_frenzy_status $RAMPAGE_STATUS 

if
    $RAMPAGE_STATUS == 2
then
    $RAMPAGE00_COMPLETED = 1
    RELEASE_MODEL #GANG01
    RELEASE_MODEL #GANG02
    $RAMPAGE_COUNTER += 1
    goto @RAMPAGE_PASSED
end

if
    $RAMPAGE_STATUS == 3
then
    $RAMPAGE00_COMPLETED = 2
    RELEASE_MODEL #GANG01
    RELEASE_MODEL #GANG02
    goto @RAMPAGE_FAILED
end

goto @RAMPAGE00_LOOP

// RAMPAGE 2

:RAMPAGE01
$ONMISSION = 1
REMOVE_PICKUP $RAMPAGE01
start_kill_frenzy 'PAGE_00' 8 120000 15 -2 -2 #PLAYERSDOOR #PLAYERSDOOR 0  
print_with_number_big 'PAGE_16' 15 6000 6  
03DF: all_random_peds #MALE01 
read_kill_frenzy_status $RAMPAGE_STATUS 

:RAMPAGE01_LOOP // rampage 1 loop
wait 0
read_kill_frenzy_status $RAMPAGE_STATUS 

if
    $RAMPAGE_STATUS == 2
then
    $RAMPAGE01_COMPLETED = 1
    $RAMPAGE_COUNTER += 1
    goto @RAMPAGE_PASSED
end

if
    $RAMPAGE_STATUS == 3
then
    $RAMPAGE01_COMPLETED = 2
    goto @RAMPAGE_FAILED
end

goto @RAMPAGE01_LOOP

// RAMPAGE 3

:RAMPAGE02
$ONMISSION = 1
REMOVE_PICKUP $RAMPAGE02
start_kill_frenzy 'PAGE_00' 5 120000 15 #GANG05 #GANG06 #PLAYERSDOOR #PLAYERSDOOR 0  
REQUEST_MODEL #GANG05 
REQUEST_MODEL #GANG06
03DF: all_random_peds #PIMP 
print_with_number_big 'PAGE_01' 15 6000 6  
read_kill_frenzy_status $RAMPAGE_STATUS 

:RAMPAGE02_LOOP // rampage 1 loop
wait 0
read_kill_frenzy_status $RAMPAGE_STATUS 

if
    $RAMPAGE_STATUS == 2
then
    $RAMPAGE02_COMPLETED = 1
    RELEASE_MODEL #GANG05
    RELEASE_MODEL #GANG06
    $RAMPAGE_COUNTER += 1
    goto @RAMPAGE_PASSED
end

if
    $RAMPAGE_STATUS == 3
then
    $RAMPAGE02_COMPLETED = 2
    RELEASE_MODEL #GANG05
    RELEASE_MODEL #GANG06
    goto @RAMPAGE_FAILED
end

goto @RAMPAGE02_LOOP

// RAMPAGE 4

:RAMPAGE03
$ONMISSION = 1
REMOVE_PICKUP $RAMPAGE03
start_kill_frenzy 'PAGE_00' 7 120000 15 #GANG01 #GANG02 #PLAYERSDOOR #PLAYERSDOOR 0  
REQUEST_MODEL #GANG01 
REQUEST_MODEL #GANG02
03DF: all_random_peds #MALE01 
print_with_number_big 'PAGE_03' 15 6000 6  
read_kill_frenzy_status $RAMPAGE_STATUS 

:RAMPAGE03_LOOP // rampage 1 loop
wait 0
read_kill_frenzy_status $RAMPAGE_STATUS 

if
    $RAMPAGE_STATUS == 2
then
    $RAMPAGE03_COMPLETED = 1
    RELEASE_MODEL #GANG01
    RELEASE_MODEL #GANG02
    $RAMPAGE_COUNTER += 1
    goto @RAMPAGE_PASSED
end

if
    $RAMPAGE_STATUS == 3
then
    $RAMPAGE03_COMPLETED = 2
    RELEASE_MODEL #GANG01
    RELEASE_MODEL #GANG02
    goto @RAMPAGE_FAILED
end

goto @RAMPAGE03_LOOP

// RAMPAGE 5

:RAMPAGE04
$ONMISSION = 1
REMOVE_PICKUP $RAMPAGE04
start_kill_frenzy 'PAGE_00' 8 220000 15 -2 -2 #PLAYERSDOOR #PLAYERSDOOR 0  
print_with_number_big 'PAGE_16' 25 6000 6  
03DF: all_random_peds #MALE01 
read_kill_frenzy_status $RAMPAGE_STATUS 

:RAMPAGE04_LOOP // rampage 1 loop
wait 0
read_kill_frenzy_status $RAMPAGE_STATUS 

if
    $RAMPAGE_STATUS == 2
then
    $RAMPAGE04_COMPLETED = 1
    $RAMPAGE_COUNTER += 1
    goto @RAMPAGE_PASSED
end

if
    $RAMPAGE_STATUS == 3
then
    $RAMPAGE04_COMPLETED = 2
    goto @RAMPAGE_FAILED
end

goto @RAMPAGE04_LOOP

// RAMPAGE PASSED
:RAMPAGE_PASSED
add_score $PLAYER_CHAR 5000 
PRINT_BIG 'RAMP_P' 5000 5  // RAMPAGE COMPLETE!
print_with_number_big 'REWARD' 5000 6000 6  // REWARD $~1~
$ONMISSION = 0
read_kill_frenzy_status $RAMPAGE_STATUS
03DF: all_random_peds #PLAYERSDOOR

if
$RAMPAGE_COUNTER == 5
then
0394: play_music 1
00BE: text_clear_all
print_with_number_big 'RAMPASS' 5000 6000 6  // REWARD $~1~
ADD_SCORE $PLAYER_CHAR 75000
goto @RAMPAGE_END
end

goto @RAMPAGE_LOOP

// RAMPAGE FAILED
:RAMPAGE_FAILED
PRINT_BIG 'RAMP_F' 5000 5  // RAMPAGE FAILED
$ONMISSION = 0
read_kill_frenzy_status $RAMPAGE_STATUS
03DF: all_random_peds #PLAYERSDOOR
goto @RAMPAGE_LOOP

:RAMPAGE_TEXT
PRINT_BIG 'RAMPAGE' 5000 5  // RAMPAGE!!
return

:RAMPAGE_REMOVE_PICKUPS
REMOVE_PICKUP $RAMPAGE00
REMOVE_PICKUP $RAMPAGE01
REMOVE_PICKUP $RAMPAGE02
REMOVE_PICKUP $RAMPAGE03
REMOVE_PICKUP $RAMPAGE04
$RAMPAGE00_SPAWNED = 0
$RAMPAGE01_SPAWNED = 0
$RAMPAGE02_SPAWNED = 0
$RAMPAGE03_SPAWNED = 0
$RAMPAGE04_SPAWNED = 0
return

:RAMPAGE_AUDIO
7AAC: play_audio_stream_2channel "MODLOADER\ADAYINLIBERTY\FRENZY.OGG" loop 0 volume 0.5
return

:RAMPAGE_END
end_thread