package management

import kotlin.js.Promise
import manifest.ExtensionID

class UninstallSelfOptions(/**
 * Whether or not a confirm-uninstall dialog should prompt the user. Defaults to false.
 */
val showConfirmDialog: Boolean?, /**
 * The message to display to a user when being asked to confirm removal of the extension.
 */
val dialogMessage: String?)

/**
 * Information about an icon belonging to an extension.
 */
external class IconInfo {
  /**
   * A number representing the width and height of the icon. Likely values include (but are not limited to) 128, 48, 24, and 16.
   */
  val size: Int

  /**
   * The URL for this icon image. To display a grayscale version of the icon (to indicate that an extension is disabled, for example), append <code>?grayscale=true</code> to the URL.
   */
  val url: String
}

typealias ExtensionDisabledReason = String

typealias ExtensionType = String

typealias ExtensionInstallType = String

/**
 * Information about an installed extension.
 */
external class ExtensionInfo {
  /**
   * The extension's unique identifier.
   */
  val id: String

  /**
   * The name of this extension.
   */
  val name: String

  /**
   * A short version of the name of this extension.
   */
  val shortName: String?

  /**
   * The description of this extension.
   */
  val description: String

  /**
   * The <a href='manifest/version'>version</a> of this extension.
   */
  val version: String

  /**
   * The <a href='manifest/version#version_name'>version name</a> of this extension if the manifest specified one.
   */
  val versionName: String?

  /**
   * Whether this extension can be disabled or uninstalled by the user.
   */
  val mayDisable: Boolean

  /**
   * Whether it is currently enabled or disabled.
   */
  val enabled: Boolean

  /**
   * A reason the item is disabled.
   */
  val disabledReason: ExtensionDisabledReason

  /**
   * The type of this extension. Will always return 'extension'.
   */
  val type: ExtensionType

  /**
   * The URL of the homepage of this extension.
   */
  val homepageUrl: String?

  /**
   * The update URL of this extension.
   */
  val updateUrl: String?

  /**
   * The url for the item's options page, if it has one.
   */
  val optionsUrl: String

  /**
   * A list of icon information. Note that this just reflects what was declared in the manifest, and the actual image at that url may be larger or smaller than what was declared, so you might consider using explicit width and height attributes on img tags referencing these images. See the <a href='manifest/icons'>manifest documentation on icons</a> for more details.
   */
  val icons: Array<IconInfo>?

  /**
   * Returns a list of API based permissions.
   */
  val permissions: Array<String>?

  /**
   * Returns a list of host based permissions.
   */
  val hostPermissions: Array<String>?

  /**
   * How the extension was installed.
   */
  val installType: ExtensionInstallType
}

external class Management {
  /**
   * Returns a list of information about installed extensions.
   */
  fun getAll(): Promise<Array<ExtensionInfo>>

  /**
   * Returns information about the installed extension that has the given ID.
   */
  fun get(id: ExtensionID): Promise<ExtensionInfo>

  /**
   * Returns information about the calling extension. Note: This function can be used without requesting the 'management' permission in the manifest.
   */
  fun getSelf(): Promise<ExtensionInfo>

  /**
   * Uninstalls the calling extension. Note: This function can be used without requesting the 'management' permission in the manifest.
   */
  fun uninstallSelf(options: UninstallSelfOptions?): Promise<Any>

  /**
   * Enables or disables the given add-on.
   */
  fun setEnabled(id: String, enabled: Boolean): Promise<Any>
}