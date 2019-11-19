

grammar ANTLRParser;

expression: chord+;

chord: note MINOR? modifier_spec? bass_spec?;

modifier_spec: MODIFIER (AUGMENTED | DIMINISHED)?;

bass_spec: BASS_SEPARATOR note;

BASS_SEPARATOR: '/';

DIMINISHED: '-';

AUGMENTED: '+';

MINOR: 'm';

DIGIT: [0-9];

MODIFIER: '7' | '7M' | '9' | '11';

note: DIGIT? FUNDAMENTAL SIGN?;

SIGN: '#' | 'b';

FUNDAMENTAL: 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';



WS  :   [ \t\n\r]+ -> skip ;