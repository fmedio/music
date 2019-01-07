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

{
	RLPF.ar(
		Dust.ar([5, 20]), // input signal, 2 channels
		LFNoise1.ar([0.3, 0.2]).range(100, 3000), // cutoff freq
	0.02) // reciprocal of Q
}.play;

Pbind(\degree, 0, \dur, 0.5).play;
Pbind(\degree, Pseq([0, 3, 4, 0, 4, 6], 100), \dur, 0.2).play;
Pbind(\degree, Pseries(-14, 4, 8), \dur, 0.5).play;
 