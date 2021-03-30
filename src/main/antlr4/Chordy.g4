grammar Chordy;

expression:
    tempo_exp |
    stop_exp |
    play_exp;

tempo_exp: TEMPO INTEGER;

stop_exp: STOP;

play_exp: PLAY chord_list;

chord_list: chord+;

chord: NOTE SIGN? (MINOR | DIM)? interval_spec_list? bass_spec? duration_spec?;

interval_spec_list: interval_spec (INTERVAL_SEPARATOR interval_spec_list)?;

duration_spec: DURATION_SEPARATOR INTEGER;

interval_spec: INTEGER (PLUS | MINUS)?;

bass_spec: BASS_SEPARATOR NOTE SIGN? INTEGER?;

PLAY: 'play' | 'p' ;

STOP: 'stop' | 's' ;

TEMPO: 'tempo' | 't';

BASS_SEPARATOR: '/';

INTERVAL_SEPARATOR: ',';

DURATION_SEPARATOR: ':';


PLUS: '+';

MINUS: '-';

MINOR: 'm';

DIM: 'dim';

SIGN: '#' | 'b';

NOTE: 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

INTEGER: [0-9]+;

WS  :   [ \t\n\r]+ -> skip ;