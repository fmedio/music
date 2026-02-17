// Imagine I have three WAV samples, "Kick Basic.wav", "Hihat.wav", and "Snare Low.wav". Let's call them A, B, and C. I want to play them in a loop where each step is 1/8th note, with the repeating pattern "ABCB". Write a piece of SuperCollider code that does this.
(
// IMPORTANT:
// 1. Replace "/path/to/your/samples/" with the actual directory where your .wav files are.
//    Example: "/Users/yourname/Music/Samples/"
//    Or, if using common SuperCollider sample packs (often in platform app support dir):
//    var sampleDir = Platform.userAppSupportDir +/+ "sc-sample-pack";
var sampleDir = "/home/fabrice/Downloads/tr808/";

// 2. Load samples into buffers (run this after booting the server: Cmd+B)
~kickBuf = Buffer.read(s, sampleDir +/+ "Kick Basic.wav");
~hihatBuf = Buffer.read(s, sampleDir +/+ "Hihat.wav");
~snareBuf = Buffer.read(s, sampleDir +/+ "Snare Low.wav");

// 3. Define a SynthDef to play samples
SynthDef(\playsample, { arg out=0, buf, amp=1, rate=1, pan=0, attack=0.005, sustain=0.05, release=0.1;
    var env = EnvGen.kr(Env.linen(attack, sustain, release), gate:1, doneAction:2);
    var sig = PlayBuf.ar(1, buf, BufRateScale.ir(buf) * rate, loop:0);
    Out.ar(out, Pan2.ar(sig * env * amp, pan));
}).add;

//s.boot;
//s.quit;

// 4. Set up tempo (e.g., 120 BPM)
var bpm = 120;
var tempo = TempoClock.new(bpm/60); // 1 beat = 1 quarter note at this BPM

// 5. Create and play the pattern "ABCB" with each step as an 8th note
~pattern = Pbind(
    \instrument, \playsample,
    \buf, Pseq([~kickBuf, ~hihatBuf, ~snareBuf, ~hihatBuf], inf), // A B C B repeating indefinitely
    \amp, 0.7, // Overall amplitude for the samples
    \dur, 0.5, // Duration of each step in beats (0.5 beats = an 8th note at 120 BPM)
    \attack, 0.005, // Short attack for percussive sounds
    \sustain, 0.05,
    \release, 0.1
).play(tempo);



// b   b   b   b   b   b



// To stop the pattern:
// ~pattern.stop;

// To free the buffers (after stopping the pattern):
// ~kickBuf.free; ~hihatBuf.free; ~snareBuf.free;
