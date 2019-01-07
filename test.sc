[1, 2, 3, "wow"].reverse;

"hello".dup(4);

100.rand;
dup("hello", 10)

{100.rand;}.dup(2)

if (100.rand % 2 == 0,
	{"true".postln; },
	{"false".postln ;})


if(100 > 50, { "very true".postln }, { "very false".postln });

"foo".postln

if (100.rand % 2 == 0, {"very true".postln}, {"false".postln} )

[1, 2, 3].do({|a| a + 3;})

{Saw.ar(freq: MouseX.kr(300, 2500), mul: MouseY.kr(0, 1))}.play;

s.boot;
s.quit;

{SinOsc.kr(1).poll}.play;