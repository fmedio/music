grammar ANTLRParser;

expression:
    stop_exp |
    append_exp |
    replace_exp;

stop_exp: STOP;

replace_exp: REPLACE? sequence_exp;

append_exp: APPEND sequence_exp;

sequence_exp: loop_exp | chord_list;

loop_exp: LOOP INTEGER chord_list;

chord_list: chord+;

chord: NOTE SIGN? MINOR? interval_spec_list? bass_spec? duration_spec?;

interval_spec_list: interval_spec (INTERVAL_SEPARATOR interval_spec_list)?;

duration_spec: DURATION_SEPARATOR INTEGER;

interval_spec: INTEGER (AUGMENTED | DIMINISHED)?;

bass_spec: BASS_SEPARATOR NOTE SIGN?;

LOOP: 'loop' | 'l';

APPEND: 'append' | 'a' ;

REPLACE: 'replace' | 'r' ;

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