package music.chordy.parser

import music.chordy.SequencerState
import org.junit.Test
import java.io.InputStream
import javax.sound.midi.*
import kotlin.test.assertEquals


class ParserFacadeTest {
    @Test
    fun testParse() {
        val seqState = SequencerState(StubSeq(), 100f)
        ParserFacade().eval("tempo 420", seqState)
        assertEquals(420f, seqState.tempoBPM)
    }

    @Test
    fun testLoop() {
        val sequencer = StubSeq()
        val seqState = SequencerState(sequencer, 100f)
        ParserFacade().eval("loop C Am F G", seqState)
        assertEquals(0, sequencer.loopStartPoint)
        assertEquals(4, sequencer.loopEndPoint)
    }

    class StubSeq : Sequencer {

        private var loopStart: Long = 0
        private var loopEnd: Long = 0
        private var tempoBPM: Float = 0f
        private var loopCount: Int = 0

        override fun close() {
            TODO("Not yet implemented")
        }

        override fun getDeviceInfo(): MidiDevice.Info {
            TODO("Not yet implemented")
        }

        override fun open() {
            TODO("Not yet implemented")
        }

        override fun isOpen(): Boolean {
            TODO("Not yet implemented")
        }

        override fun getMicrosecondPosition(): Long {
            TODO("Not yet implemented")
        }

        override fun getMaxReceivers(): Int {
            TODO("Not yet implemented")
        }

        override fun getMaxTransmitters(): Int {
            TODO("Not yet implemented")
        }

        override fun getReceiver(): Receiver {
            TODO("Not yet implemented")
        }

        override fun getReceivers(): MutableList<Receiver> {
            TODO("Not yet implemented")
        }

        override fun getTransmitter(): Transmitter {
            TODO("Not yet implemented")
        }

        override fun getTransmitters(): MutableList<Transmitter> {
            TODO("Not yet implemented")
        }

        override fun setSequence(sequence: Sequence?) {

        }

        override fun setSequence(stream: InputStream?) {
            TODO("Not yet implemented")
        }

        override fun getSequence(): Sequence {
            TODO("Not yet implemented")
        }

        override fun start() {
        }

        override fun stop() {
        }

        override fun isRunning(): Boolean {
            TODO("Not yet implemented")
        }

        override fun startRecording() {
            TODO("Not yet implemented")
        }

        override fun stopRecording() {
            TODO("Not yet implemented")
        }

        override fun isRecording(): Boolean {
            TODO("Not yet implemented")
        }

        override fun recordEnable(track: Track?, channel: Int) {
            TODO("Not yet implemented")
        }

        override fun recordDisable(track: Track?) {
            TODO("Not yet implemented")
        }

        override fun getTempoInBPM(): Float {
            return tempoInBPM
        }

        override fun setTempoInBPM(bpm: Float) {
            tempoBPM = bpm
        }

        override fun getTempoInMPQ(): Float {
            TODO("Not yet implemented")
        }

        override fun setTempoInMPQ(mpq: Float) {
            TODO("Not yet implemented")
        }

        override fun setTempoFactor(factor: Float) {
            TODO("Not yet implemented")
        }

        override fun getTempoFactor(): Float {
            TODO("Not yet implemented")
        }

        override fun getTickLength(): Long {
            TODO("Not yet implemented")
        }

        override fun getTickPosition(): Long {
            TODO("Not yet implemented")
        }

        override fun setTickPosition(tick: Long) {
            TODO("Not yet implemented")
        }

        override fun getMicrosecondLength(): Long {
            TODO("Not yet implemented")
        }

        override fun setMicrosecondPosition(microseconds: Long) {
            TODO("Not yet implemented")
        }

        override fun setMasterSyncMode(sync: Sequencer.SyncMode?) {
            TODO("Not yet implemented")
        }

        override fun getMasterSyncMode(): Sequencer.SyncMode {
            TODO("Not yet implemented")
        }

        override fun getMasterSyncModes(): Array<Sequencer.SyncMode> {
            TODO("Not yet implemented")
        }

        override fun setSlaveSyncMode(sync: Sequencer.SyncMode?) {
            TODO("Not yet implemented")
        }

        override fun getSlaveSyncMode(): Sequencer.SyncMode {
            TODO("Not yet implemented")
        }

        override fun getSlaveSyncModes(): Array<Sequencer.SyncMode> {
            TODO("Not yet implemented")
        }

        override fun setTrackMute(track: Int, mute: Boolean) {
            TODO("Not yet implemented")
        }

        override fun getTrackMute(track: Int): Boolean {
            TODO("Not yet implemented")
        }

        override fun setTrackSolo(track: Int, solo: Boolean) {
            TODO("Not yet implemented")
        }

        override fun getTrackSolo(track: Int): Boolean {
            TODO("Not yet implemented")
        }

        override fun addMetaEventListener(listener: MetaEventListener?): Boolean {
            TODO("Not yet implemented")
        }

        override fun removeMetaEventListener(listener: MetaEventListener?) {
            TODO("Not yet implemented")
        }

        override fun addControllerEventListener(listener: ControllerEventListener?, controllers: IntArray?): IntArray {
            TODO("Not yet implemented")
        }

        override fun removeControllerEventListener(
            listener: ControllerEventListener?,
            controllers: IntArray?
        ): IntArray {
            TODO("Not yet implemented")
        }

        override fun setLoopStartPoint(tick: Long) {
            loopStart = tick
        }

        override fun getLoopStartPoint(): Long {
            return loopStart
        }

        override fun setLoopEndPoint(tick: Long) {
            loopEnd = tick
        }

        override fun getLoopEndPoint(): Long {
            return loopEnd
        }

        override fun setLoopCount(count: Int) {
            loopCount = count
        }

        override fun getLoopCount(): Int {
            return loopCount
        }

    }
}