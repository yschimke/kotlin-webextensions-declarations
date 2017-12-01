package windows

import browser.Event
import kotlin.js.Promise

/**
 * The type of browser window this is. Under some circumstances a Window may not be assigned type property, for example when querying closed windows from the $(ref:sessions) API. */
typealias WindowType = String

/**
 * The state of this browser window. Under some circumstances a Window may not be assigned state property, for example when querying closed windows from the $(ref:sessions) API. */
typealias WindowState = String

external class Window {
    /**
     * The ID of the window. Window IDs are unique within a browser session. Under some circumstances a Window may not be assigned an ID, for example when querying windows using the $(ref:sessions) API, in which case a session ID may be present.
     */
    var id: Int?

    /**
     * Whether the window is currently the focused window.
     */
    var focused: Boolean

    /**
     * The offset of the window from the top edge of the screen in pixels. Under some circumstances a Window may not be assigned top property, for example when querying closed windows from the $(ref:sessions) API.
     */
    var top: Int?

    /**
     * The offset of the window from the left edge of the screen in pixels. Under some circumstances a Window may not be assigned left property, for example when querying closed windows from the $(ref:sessions) API.
     */
    var left: Int?

    /**
     * The width of the window, including the frame, in pixels. Under some circumstances a Window may not be assigned width property, for example when querying closed windows from the $(ref:sessions) API.
     */
    var width: Int?

    /**
     * The height of the window, including the frame, in pixels. Under some circumstances a Window may not be assigned height property, for example when querying closed windows from the $(ref:sessions) API.
     */
    var height: Int?

    /**
     * Array of $(ref:tabs.Tab) objects representing the current tabs in the window.
     */
    var tabs: Array<tabs.Tab>?

    /**
     * Whether the window is incognito.
     */
    var incognito: Boolean

    /**
     * The type of browser window this is.
     */
    var type: WindowType

    /**
     * The state of this browser window.
     */
    var state: WindowState

    /**
     * Whether the window is set to be always on top.
     */
    var alwaysOnTop: Boolean

    /**
     * The session ID used to uniquely identify a Window obtained from the $(ref:sessions) API.
     */
    var sessionId: String?

    /**
     * The title of the window. Read-only.
     */
    var title: String?
}

/**
 * Specifies what type of browser window to create. The 'panel' and 'detached_panel' types create a popup unless the '--enable-panels' flag is set. */
typealias CreateType = String

/**
 *
 */
class GetInfo(/**
 * If true, the $(ref:windows.Window) object will have a <var>tabs</var> property that contains a list of the $(ref:tabs.Tab) objects. The <code>Tab</code> objects only contain the <code>url</code>, <code>title</code> and <code>favIconUrl</code> properties if the extension's manifest file includes the <code>"tabs"</code> permission.
 */
var populate: Boolean?, /**
 * If set, the $(ref:windows.Window) returned will be filtered based on its type. If unset the default filter is set to <code>['app', 'normal', 'panel', 'popup']</code>, with <code>'app'</code> and <code>'panel'</code> window types limited to the extension's own windows.
 */
var windowTypes: Array<WindowType>?)

/**
 *
 */
class GetInfo2(/**
 * If true, the $(ref:windows.Window) object will have a <var>tabs</var> property that contains a list of the $(ref:tabs.Tab) objects. The <code>Tab</code> objects only contain the <code>url</code>, <code>title</code> and <code>favIconUrl</code> properties if the extension's manifest file includes the <code>"tabs"</code> permission.
 */
var populate: Boolean?, /**
 * If set, the $(ref:windows.Window) returned will be filtered based on its type. If unset the default filter is set to <code>['app', 'normal', 'panel', 'popup']</code>, with <code>'app'</code> and <code>'panel'</code> window types limited to the extension's own windows.
 */
var windowTypes: Array<WindowType>?)

/**
 *
 */
class GetInfo3(/**
 * If true, the $(ref:windows.Window) object will have a <var>tabs</var> property that contains a list of the $(ref:tabs.Tab) objects. The <code>Tab</code> objects only contain the <code>url</code>, <code>title</code> and <code>favIconUrl</code> properties if the extension's manifest file includes the <code>"tabs"</code> permission.
 */
var populate: Boolean?, /**
 * If set, the $(ref:windows.Window) returned will be filtered based on its type. If unset the default filter is set to <code>['app', 'normal', 'panel', 'popup']</code>, with <code>'app'</code> and <code>'panel'</code> window types limited to the extension's own windows.
 */
var windowTypes: Array<WindowType>?)

/**
 *
 */
class GetInfo4(/**
 * If true, each $(ref:windows.Window) object will have a <var>tabs</var> property that contains a list of the $(ref:tabs.Tab) objects for that window. The <code>Tab</code> objects only contain the <code>url</code>, <code>title</code> and <code>favIconUrl</code> properties if the extension's manifest file includes the <code>"tabs"</code> permission.
 */
var populate: Boolean?, /**
 * If set, the $(ref:windows.Window) returned will be filtered based on its type. If unset the default filter is set to <code>['app', 'normal', 'panel', 'popup']</code>, with <code>'app'</code> and <code>'panel'</code> window types limited to the extension's own windows.
 */
var windowTypes: Array<WindowType>?)

/**
 * A URL or array of URLs to open as tabs in the window. Fully-qualified URLs must include a scheme (i.e. 'http://www.google.com', not 'www.google.com'). Relative URLs will be relative to the current page within the extension. Defaults to the New Tab Page. */
typealias Url = Any

class CreateData(
        /**
         * A URL or array of URLs to open as tabs in the window. Fully-qualified URLs must include a scheme (i.e. 'http://www.google.com', not 'www.google.com'). Relative URLs will be relative to the current page within the extension. Defaults to the New Tab Page.
         */
        var url: Url,
        /**
         * The id of the tab for which you want to adopt to the new window.
         */
        var tabId: Int?,
        /**
         * The number of pixels to position the new window from the left edge of the screen. If not specified, the new window is offset naturally from the last focused window. This value is ignored for panels.
         */
        var left: Int?,
        /**
         * The number of pixels to position the new window from the top edge of the screen. If not specified, the new window is offset naturally from the last focused window. This value is ignored for panels.
         */
        var top: Int?,
        /**
         * The width in pixels of the new window, including the frame. If not specified defaults to a natural width.
         */
        var width: Int?,
        /**
         * The height in pixels of the new window, including the frame. If not specified defaults to a natural height.
         */
        var height: Int?,
        /**
         * Whether the new window should be an incognito window.
         */
        var incognito: Boolean?,
        /**
         * Specifies what type of browser window to create. The 'panel' and 'detached_panel' types create a popup unless the '--enable-panels' flag is set.
         */
        var type: CreateType,
        /**
         * The initial state of the window. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined with 'left', 'top', 'width' or 'height'.
         */
        var state: WindowState,
        /**
         * Allow scripts to close the window.
         */
        var allowScriptsToClose: Boolean?,
        /**
         * A string to add to the beginning of the window title.
         */
        var titlePreface: String?
)

class UpdateInfo(
        /**
         * The offset from the left edge of the screen to move the window to in pixels. This value is ignored for panels.
         */
        var left: Int?,
        /**
         * The offset from the top edge of the screen to move the window to in pixels. This value is ignored for panels.
         */
        var top: Int?,
        /**
         * The width to resize the window to in pixels. This value is ignored for panels.
         */
        var width: Int?,
        /**
         * The height to resize the window to in pixels. This value is ignored for panels.
         */
        var height: Int?,
        /**
         * If true, brings the window to the front. If false, brings the next window in the z-order to the front.
         */
        var focused: Boolean?,
        /**
         * If true, causes the window to be displayed in a manner that draws the user's attention to the window, without changing the focused window. The effect lasts until the user changes focus to the window. This option has no effect if the window already has focus. Set to false to cancel a previous draw attention request.
         */
        var drawAttention: Boolean?,
        /**
         * The new state of the window. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined with 'left', 'top', 'width' or 'height'.
         */
        var state: WindowState,
        /**
         * A string to add to the beginning of the window title.
         */
        var titlePreface: String?
)

external class WindowsNamespace {
    val onCreated: Event<(window: Window) -> Unit>

    val onRemoved: Event<(windowId: Int) -> Unit>

    val onFocusChanged: Event<(windowId: Int) -> Unit>

    /**
     * Gets details about a window.
     */
    fun get(windowId: Int, getInfo: GetInfo): Promise<Window>

    /**
     * Gets the $(topic:current-window)[current window].
     */
    fun getCurrent(getInfo: GetInfo2): Promise<Window>

    /**
     * Gets the window that was most recently focused &mdash; typically the window 'on top'.
     */
    fun getLastFocused(getInfo: GetInfo3): Promise<Window>

    /**
     * Gets all windows.
     */
    fun getAll(getInfo: GetInfo4): Promise<Array<Window>>

    /**
     * Creates (opens) a new browser with any optional sizing, position or default URL provided.
     */
    fun create(createData: CreateData): Promise<Window>

    /**
     * Updates the properties of a window. Specify only the properties that you want to change; unspecified properties will be left unchanged.
     */
    fun update(windowId: Int, updateInfo: UpdateInfo): Promise<Window>

    /**
     * Removes (closes) a window, and all the tabs inside it.
     */
    fun remove(windowId: Int): Promise<Any>
}
