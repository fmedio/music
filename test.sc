
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
	\instrument, "pluck",
	\degree, Prand([[0, 1, 4], −1, 2, −3, 4, −3, 7, 11, 4, 2, 0, −3], inf),
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
	\freq, Pwhite(440, 2500),
	\dur, Prand([0.15, 0.25, 0.3], inf),
	\amp, 0.2,
	\legato, 0.3
).trace.play;

{SinOsc.ar(freq: LFNoise0.kr(8).range(500, 1500), mul: 0.1)}.play;

{SinOsc.ar(freq: LFPulse.kr(5, mul: 440, width: 0.2))}.play;

x = {arg freq = 440, amp = 0.1; SinOsc.ar(freq, 0, amp)}.play;
x.set(\freq, 778);
x.set(\freq, 920, \amp, 0.2);
x.free;

// Use explicit bus for routing
f = {Out.ar(0, BPF.ar(in: In.ar(55), freq: MouseY.kr(200, 5000), rq: 0.01))}.play;
n = {Out.ar(55, WhiteNoise.ar(0.5))}.play;


{FreeVerb.ar(SoundIn.ar([0, 1]), mix: 0.5, room: 0.9)}.play;


// Pipe monoBus to left and right out using multichannel expansion
~monoBus = Bus(s, numChannels: 1);
{Out.ar(0, [In.ar(~monoBus), In.ar(~monoBus)])}.play;
{FreeVerb.ar( // Play into bus 55
	BPF.ar(
		in: WhiteNoise.ar(0.5),
		freq: MouseY.kr(200, 5000),
		rq: 0.1),
	mix: 0.5,
	room: 0.9)}.play(outbus: ~monoBus);


{Out.ar(0, Saw.ar(freq: [440, 660], mul: Line.kr(0, 1, 10)))}.play;
// Multichannel expansion
{Out.ar(0, SinOsc.ar(freq: [800, 880], mul: [LFPulse.ar(2), LFPulse.ar(2)]))}.play;

r = {Out.ar(0, FreeVerb.ar(In.ar(55, 2), mix: 0.5, room: 0.9, mul: 0.4))}.play;
a = {Out.ar(55, SinOsc.ar(freq: [800, 880], mul: [LFPulse.ar(2), LFPulse.ar(2)]))}.play;

{Pan2.ar(in: PinkNoise.ar, pos: SinOsc.kr(2), level: 0.1)}.play;

{ Mix.fill(16, {SinOsc.ar(rrand(100, 3000), mul: 0.01)}) }.play;

~cucumber = Buffer.read(s, "/Users/fabrice.medio/Documents/git/music/cucumber.wav");

{PlayBuf.ar(1, ~cucumber, MouseY.kr(-3, 3), loop: 1)}.play(outbus: [0, 1]);

s.plotTree;

{WhiteNoise.ar(Line.kr(0.2, 0, 2), doneAction: 2)}.play;
{PlayBuf.ar(1, ~cucumber, doneAction: 2)}.play;

/////////////////////////////////
// Envelopes
Env.perc(0.5).plot;
Env.perc(attackTime: 0.3, releaseTime: 2, level: 0.4).plot;
{PinkNoise.ar(Env.perc(0.01).kr(doneAction: 2))}.play;

Env.triangle.plot;
{SinOsc.ar([440, 442], mul: Env.triangle.kr(2))}.play;
// Same expression:
{SinOsc.ar([440, 442]) * Env.triangle.kr(2)}.play;

Env.linen.plot;
Env.linen(1, 2, 1, 0.02).plot;
{SinOsc.ar([300, 350], mul: Env.linen(1, 2, 1, 0.2).kr(2))}.play;

({
	var env = Env.pairs([[0, 0], [0.4, 1], [1, 0.2], [1.1, 0.5], [2, 0]], \lin, doneAction: 2);
	env.plot;
	SinOsc.ar([440, 442], mul: env.kr(2));
}.play;)

({
	var freqEnv = Env.pairs([[0, 100], [0.4, 1000], [0.9, 400], [1.1, 555], [2, 220]], \lin);
	freqEnv.plot;
	SinOsc.ar(freqEnv.kr, mul: 0.2);
}.play;)

// Marc's problem: program a single sinewave that does glissandoes of constant length to random frequencies
// Luc wants to record stuff

// These are equivalent:
{ SinOsc.ar * Env.perc.kr(doneAction: 2) }.play;
{ SinOsc.ar * EnvGen.kr(Env.perc, doneAction: 2) }.play;

x = {arg gate = 1, freq = 440; SinOsc.ar(freq: freq, mul: Env.asr(0.5, 0.8, 3).kr(
      doneAction: 2, gate: gate))}.play;
x.set(\gate, 0);

(
d = { arg gate = 1;
	var snd, env;
	env = Env.adsr(0.01, 0.4, 0.7, 2);
	snd = Splay.ar(BPF.ar(Saw.ar((32.1, 32.2..33)), LFNoise2.kr(12).range(100,
		1000), 0.05, 10));
	Out.ar(0, snd * env.kr(doneAction: 2, gate: gate));
}.play;
)
d.release;

SynthDef("mySine1", {Out.ar(0, SinOsc.ar(770, 0, 0.1))}).add;
x = Synth("mySine1");
x.free;

SynthDef("mySine2", {arg freq = 440, amp = 0.1;
	var env = Env.perc(level: amp).kr(2);
	var snd = SinOsc.ar(freq, 0, env); Out.ar(0, snd);
}).add;

Synth("mySine2");
Synth("mySine2", [\freq, 770, \amp, 0.2]);

(
SynthDef("wow", {arg freq = 60, amp = 0.1, gate = 1, wowrelease = 3;
	var chorus, source, filtermod, env, snd;
	chorus = Lag.kr(freq, 2) * LFNoise2.kr([0.4, 0.5, 0.7, 1, 2, 5, 10]).range(1, 1.02);
	source = LFSaw.ar(chorus) * 0.5;
	filtermod = SinOsc.kr(1/16).range(1, 10);
	env = Env.asr(1, amp, wowrelease).kr(2, gate);
	snd = LPF.ar(in: source, freq: freq * filtermod, mul: env);
	Out.ar(0, Splay.ar(snd))
}).add;
)

s.plotTree;
a = Array.fill(6, {Synth("wow", [\freq, rrand(40, 70).midicps, \amp, rrand(0.1, 0.5)])});
a[0].set(\gate, 0);
a[1].set(\gate, 0);
a[2].set(\gate, 0);
a[3].set(\gate, 0);
a[4].set(\gate, 0);
a[5].set(\gate, 0);
SystemClock.sched(0, {a[5.rand].set(\freq, rrand(40, 70).midicps); rrand(3, 10)});

(
Pbind(
	\instrument, "wow",
	\degree, Pwhite(−7, 7),
	\dur, Prand([0.125, 0.25], inf),
	\amp, Pwhite(0.5, 1),
	\wowrelease, 1
).play;
)

(
Pbind(
	\instrument, "pluck",
	\scale,
	Pstutter(8, Pseq([
		Scale.lydian,
		Scale.major,
		Scale.mixolydian,
		Scale.minor,
		Scale.phrygian
	], inf)),
	\degree, Pseq([0, 1, 2, 3, 4, 5, 6, 7], inf),
	\dur, 0.2,
	\amp, Pwhite(0.5, 1),
	\wowrelease, 4,
	\legato, 0.1
).play;
)

(
SynthDef("pluck", {arg amp = 0.1, freq = 440, decay = 5, mutedString = 0.1; var env, snd;
	env = Env.linen(0, decay, 0).kr(doneAction: 2);
	snd = Pluck.ar(
		in: WhiteNoise.ar(amp),
		trig: Impulse.kr(1),
		maxdelaytime: 0.1,
		delaytime: freq.reciprocal,
		decaytime: decay,
		coef: mutedString);
	Out.ar(0, [snd, snd]);
}).add;
)

// From https://rhoadley.net/courses/tech_resources/supercollider/tutorials/cottle/CMSC7105.pdf
(
{
var harmonics = 12, fund = 30;
Mix.fill(harmonics,
		{arg count;
			Pan2.ar(
				SinOsc.ar(fund * (count+1),
					mul: max(0.1, FSinOsc.kr(count/5))
				),
				0.5
			)
		}
)*0.07}.play
)
