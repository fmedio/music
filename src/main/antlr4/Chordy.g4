grammar Chordy;

expression:
    tempo_exp |
    stop_exp |
    play_exp |
    loop_exp;

tempo_exp: TEMPO INTEGER;

stop_exp: STOP;

play_exp: PLAY chord_list;

loop_exp: LOOP chord_list;

chord_list: chord+;

chord: DEGREE SIGN? (MINOR | DIM)? interval_spec_list? bass_spec? duration_spec?;

interval_spec_list: interval_spec (INTERVAL_SEPARATOR interval_spec_list)?;

duration_spec: DURATION_SEPARATOR INTEGER;

interval_spec: INTEGER (PLUS | MINUS)?;

PLAY: 'play' | 'p' ;

STOP: 'stop' | 's' ;

LOOP: 'loop' | 'l';

TEMPO: 'tempo' | 't';

INTERVAL_SEPARATOR: ',';

DURATION_SEPARATOR: ':';

PLUS: '+';

MINUS: '-';

MINOR: 'm';

DIM: 'dim';

SIGN: '#' | 'b';

DEGREE: I | II | III | IV | V | VI | VII;

I: 'i' | 'I';
II: 'ii' | 'II';
III: 'iii' | 'III';
IV: 'iv' | 'IV';
V: 'v' | 'V';
VI: 'vi' | 'VI';
VII: 'vii' | 'VII';

INTEGER: [0-9]+;

WS  :   [ \t\n\r]+ -> skip ;