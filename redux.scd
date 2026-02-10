42
"Hello World!".postln;
// s is server
// s.boot; (or Server.default.boot;)
s.quit;
s.boot;

// Had to use QjackCtl to select the right audio interface
{ [SinOsc.ar(440, 0, 0.2), SinOsc.ar(442, 0, 0.2)] }.play;

SCLOrkSynths.directory
SCLOrkSynths.load;
SCLOrkSynths.gui;

(
// 1. Boot Server
s.waitForBoot({
    var moogNotes = Array.newClear(128); // Track active notes for monophonic play
var freq;
    // 2. Initialize MIDI
    MIDIClient.init;
    MIDIIn.connectAll;

    // 3. Define MIDI Note On (Key Down)
    MIDIdef.noteOn(\moogOn, { |vel, note|
        // If a note is already playing, stop it (monophonic behavior)
        if(moogNotes[note].notNil) { moogNotes[note].release; };

		freq = (note - 24).midicps;

		Post << "MIDI note: " << note << ", vel: " << vel << "\n";
        // Play the SCLOrkSynth moogBass
        moogNotes[note] = Synth(\bassWarsaw, [
			\freq, freq,
            \amp, 1, //vel.linlin(0, 127, 0, 1),
            \gate, 1
        ]);
    });

    // 4. Define MIDI Note Off (Key Up)
    MIDIdef.noteOff(\moogOff, { |vel, note|
        moogNotes[note].release;
        moogNotes[note] = nil;
    });

    "MIDI MoogBass Loaded. Play your keyboard!".postln;
});
)

// Run this to stop all sound
(
MIDIdef.freeAll;
s.freeAll;
)
