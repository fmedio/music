

grammar ANTLRParser;

expression: chord+;

chord: NOTE SIGN? MINOR? interval_spec_list? bass_spec?;

interval_spec_list: interval_spec+;

interval_spec: INTERVAL (AUGMENTED | DIMINISHED)?;

bass_spec: BASS_SEPARATOR NOTE SIGN?;

BASS_SEPARATOR: '/';

DIMINISHED: '-';

AUGMENTED: '+';

MINOR: 'm';

INTERVAL: '2' | '3' | '4' | '5' | '6' | '7' | '7M' | '8' | '9' | '10' | '11' | '12' | '13' | '14';

SIGN: '#' | 'b';

NOTE: 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

WS  :   [ \t\n\r]+ -> skip ;