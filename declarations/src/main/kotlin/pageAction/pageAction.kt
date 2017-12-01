package pageAction

import browser.Event
import kotlin.js.Promise
import tabs.Tab

/**
 * Pixel data for an image. Must be an ImageData object (for example, from a <code>canvas</code> element). */
typealias ImageDataType = Any

class Details(/**
 * The id of the tab for which you want to modify the page action.
 */
var tabId: Int, /**
 * The tooltip string.
 */
var title: String)

class Details2(/**
 * Specify the tab to get the title from.
 */
var tabId: Int)

/**
 * Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals <code>scale</code>, then image with size <code>scale</code> * 19 will be selected. Initially only scales 1 and 2 will be supported. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'19': foo}' */
typealias ImageData = Any

/**
 * Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals <code>scale</code>, then image with size <code>scale</code> * 19 will be selected. Initially only scales 1 and 2 will be supported. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.imageData = {'19': foo}' */
typealias Path = Any

class Details3(
        /**
         * The id of the tab for which you want to modify the page action.
         */
        var tabId: Int,
        /**
         * Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals <code>scale</code>, then image with size <code>scale</code> * 19 will be selected. Initially only scales 1 and 2 will be supported. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'19': foo}'
         */
        var imageData: ImageData,
        /**
         * Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals <code>scale</code>, then image with size <code>scale</code> * 19 will be selected. Initially only scales 1 and 2 will be supported. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.imageData = {'19': foo}'
         */
        var path: Path
)

class Details4(/**
 * The id of the tab for which you want to modify the page action.
 */
var tabId: Int, /**
 * The html file to show in a popup.  If set to the empty string (''), no popup is shown.
 */
var popup: String)

class Details5(/**
 * Specify the tab to get the popup from.
 */
var tabId: Int)

external class PageActionNamespace {
    val onClicked: Event<(tab: Tab) -> Unit>

    /**
     * Shows the page action. The page action is shown whenever the tab is selected.
     */
    fun show(tabId: Int): Promise<Any>

    /**
     * Hides the page action.
     */
    fun hide(tabId: Int): Promise<Any>

    /**
     * Sets the title of the page action. This is displayed in a tooltip over the page action.
     */
    fun setTitle(details: Details)

    /**
     * Gets the title of the page action.
     */
    fun getTitle(details: Details2): Promise<String>

    /**
     * Sets the icon for the page action. The icon can be specified either as the path to an image file or as the pixel data from a canvas element, or as dictionary of either one of those. Either the <b>path</b> or the <b>imageData</b> property must be specified.
     */
    fun setIcon(details: Details3): Promise<Any>

    /**
     * Sets the html document to be opened as a popup when the user clicks on the page action's icon.
     */
    fun setPopup(details: Details4): Promise<Any>

    /**
     * Gets the html document set as the popup for this page action.
     */
    fun getPopup(details: Details5): Promise<String>

    /**
     * Opens the extension page action in the active window.
     */
    fun openPopup(): Promise<Any>
}
