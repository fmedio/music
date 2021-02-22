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

    class StubSeq : Sequencer {
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
            TODO("Not yet implemented")
        }

        override fun setSequence(stream: InputStream?) {
            TODO("Not yet implemented")
        }

        override fun getSequence(): Sequence {
            TODO("Not yet implemented")
        }

        override fun start() {
            TODO("Not yet implemented")
        }

        override fun stop() {
            TODO("Not yet implemented")
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
            TODO("Not yet implemented")
        }

        override fun setTempoInBPM(bpm: Float) {
            TODO("Not yet implemented")
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
            TODO("Not yet implemented")
        }

        override fun getLoopStartPoint(): Long {
            TODO("Not yet implemented")
        }

        override fun setLoopEndPoint(tick: Long) {
            TODO("Not yet implemented")
        }

        override fun getLoopEndPoint(): Long {
            TODO("Not yet implemented")
        }

        override fun setLoopCount(count: Int) {
            TODO("Not yet implemented")
        }

        override fun getLoopCount(): Int {
            TODO("Not yet implemented")
        }

    }
}