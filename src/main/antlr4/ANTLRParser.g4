

grammar ANTLRParser;

expression: chord+;

chord: DEGREE PITCH? MINOR? interval_spec_list? bass_spec?;

interval_spec_list: interval_spec+;

interval_spec: INTERVAL (AUGMENTED | DIMINISHED)?;

bass_spec: BASS_SEPARATOR DEGREE PITCH?;

BASS_SEPARATOR: '/';

DIMINISHED: '-';

AUGMENTED: '+';

MINOR: 'm';

INTERVAL: '2' | '3' | '4' | '5' | '6' | '7' | '7M' | '8' | '9' | '10' | '11' | '12' | '13' | '14';

PITCH: '#' | 'b';

DEGREE: 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

WS  :   [ \t\n\r]+ -> skip ;