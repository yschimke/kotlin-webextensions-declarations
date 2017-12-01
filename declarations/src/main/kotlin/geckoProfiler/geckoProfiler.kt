package geckoProfiler

import browser.Event
import kotlin.js.Promise

typealias ProfilerFeature = String

class Settings(
        /**
         * The size in bytes of the buffer used to store profiling data. A larger value allows capturing a profile that covers a greater amount of time.
         */
        var bufferSize: Int,
        /**
         * Interval in milliseconds between samples of profiling data. A smaller value will increase the detail of the profiles captured.
         */
        var interval: Int,
        /**
         * A list of active features for the profiler.
         */
        var features: Array<ProfilerFeature>,
        /**
         * A list of thread names for which to capture profiles.
         */
        var threads: Array<String>?
)

external class GeckoProfilerNamespace {
    val onRunning: Event<(isRunning: Boolean) -> Unit>

    /**
     * Starts the profiler with the specified settings.
     */
    fun start(settings: Settings): Promise<Any>

    /**
     * Stops the profiler and discards any captured profile data.
     */
    fun stop(): Promise<Any>

    /**
     * Pauses the profiler, keeping any profile data that is already written.
     */
    fun pause(): Promise<Any>

    /**
     * Resumes the profiler with the settings that were initially used to start it.
     */
    fun resume(): Promise<Any>

    /**
     * Gathers the profile data from the current profiling session.
     */
    fun getProfile(): Promise<Any>

    /**
     * Gathers the profile data from the current profiling session. The returned promise resolves to an array buffer that contains a JSON string.
     */
    fun getProfileAsArrayBuffer(): Promise<Any>

    /**
     * Gets the debug symbols for a particular library.
     */
    fun getSymbols(debugName: String, breakpadId: String): Promise<Any>
}
