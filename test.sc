
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


~pattern = Pbind(
	\degree, Pseq([[0, 1, 4], −1, 2, −3, 4, −3, 7, 11, 4, 2, 0, −3], inf),
//	\scale, Scale.nairuz,
	\ctranspose, 3,
	\dur, Pseq([0.2, 0.1, 0.1], inf),
	\amp, Pseq([0.7, 0.5, 0.3, 0.2], inf),
	\legato, 0.4,
	\strum, 0.01
);

~pattern.play;

Pbind(
	\degree, Prand([2, 3, 4, 5, 6], inf),
	\dur, 0.15,
	\amp, 0.2,
	\legato, 0.1
).play;

Pbind(
	\freq, Pwhite(100, 500),
	\dur, Prand([0.15, 0.25, 0.3], inf),
	\amp, 0.2,
	\legato, 0.3
).trace.play;

{SinOsc.ar(freq: LFNoise0.kr(8).range(500, 1500), mul: 0.1)}.play;

{SinOsc.ar(freq: LFPulse.kr(5, mul: 440, width: 0.2))}.play;

x = {arg freq = 440, amp = 0.1; SinOsc.ar(freq, 0, amp)}.play
x.set(\freq, 778);
x.set(\freq, 920, \amp, 0.2);
x.free;

// Use explicit bus for routing
f = {Out.ar(0, BPF.ar(in: In.ar(55), freq: MouseY.kr(200, 5000), rq: 0.01))}.play;
n = {Out.ar(55, WhiteNoise.ar(0.5))}.play;

{FreeVerb.ar(SoundIn.ar([0, 1]), mix: 0.5, room: 0.9)}.play;

{Out.ar(0, Saw.ar(freq: [440, 660], mul: Line.kr(0, 1, 10)))}.play;
// Multichannel expansion
{Out.ar(0, SinOsc.ar(freq: [800, 880], mul: [LFPulse.ar(2), LFPulse.ar(2)]))}.play;

r = {Out.ar(0, FreeVerb.ar(In.ar(55, 2), mix: 0.5, room: 0.9, mul: 0.4))}.play;
a = {Out.ar(55, SinOsc.ar(freq: [800, 880], mul: [LFPulse.ar(2), LFPulse.ar(3)]))}.play;