grammar ANTLRParser;

expression:
    stop_exp |
    play_exp;

stop_exp: STOP;

play_exp: PLAY chord_list;

chord_list: chord+;

chord: NOTE SIGN? MINOR? interval_spec_list? bass_spec? duration_spec?;

interval_spec_list: interval_spec (INTERVAL_SEPARATOR interval_spec_list)?;

duration_spec: DURATION_SEPARATOR INTEGER;

interval_spec: INTEGER (AUGMENTED | DIMINISHED)?;

bass_spec: BASS_SEPARATOR NOTE SIGN?;

PLAY: 'play' | 'p' ;

STOP: 'stop' | 's' ;

BASS_SEPARATOR: '/';

INTERVAL_SEPARATOR: ',';

DURATION_SEPARATOR: ':';

DIMINISHED: '-';

AUGMENTED: '+';

MINOR: 'm';



SIGN: '#' | 'b';

NOTE: 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

INTEGER: [0-9]+;

WS  :   [ \t\n\r]+ -> skip ;