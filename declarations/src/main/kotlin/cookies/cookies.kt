package cookies

import browser.Event
import kotlin.js.Promise

/**
 * Represents information about an HTTP cookie.
 */
external class Cookie {
    /**
     * The name of the cookie.
     */
    var name: String

    /**
     * The value of the cookie.
     */
    var value: String

    /**
     * The domain of the cookie (e.g. "www.google.com", "example.com").
     */
    var domain: String

    /**
     * True if the cookie is a host-only cookie (i.e. a request's host must exactly match the domain of the cookie).
     */
    var hostOnly: Boolean

    /**
     * The path of the cookie.
     */
    var path: String

    /**
     * True if the cookie is marked as Secure (i.e. its scope is limited to secure channels, typically HTTPS).
     */
    var secure: Boolean

    /**
     * True if the cookie is marked as HttpOnly (i.e. the cookie is inaccessible to client-side scripts).
     */
    var httpOnly: Boolean

    /**
     * True if the cookie is a session cookie, as opposed to a persistent cookie with an expiration date.
     */
    var session: Boolean

    /**
     * The expiration date of the cookie as the number of seconds since the UNIX epoch. Not provided for session cookies.
     */
    var expirationDate: Int?

    /**
     * The ID of the cookie store containing this cookie, as provided in getAllCookieStores().
     */
    var storeId: String
}

/**
 * Represents a cookie store in the browser. An incognito mode window, for instance, uses a separate cookie store from a non-incognito window.
 */
external class CookieStore {
    /**
     * The unique identifier for the cookie store.
     */
    var id: String

    /**
     * Identifiers of all the browser tabs that share this cookie store.
     */
    var tabIds: Array<Int>

    /**
     * Indicates if this is an incognito cookie store
     */
    var incognito: Boolean
}

/**
 * The underlying reason behind the cookie's change. If a cookie was inserted, or removed via an explicit call to $(ref:cookies.remove), "cause" will be "explicit". If a cookie was automatically removed due to expiry, "cause" will be "expired". If a cookie was removed due to being overwritten with an already-expired expiration date, "cause" will be set to "expired_overwrite".  If a cookie was automatically removed due to garbage collection, "cause" will be "evicted".  If a cookie was automatically removed due to a "set" call that overwrote it, "cause" will be "overwrite". Plan your response accordingly. */
typealias OnChangedCause = String

/**
 * Details to identify the cookie being retrieved.
 */
class Details(
        /**
         * The URL with which the cookie to retrieve is associated. This argument may be a full URL, in which case any data following the URL path (e.g. the query string) is simply ignored. If host permissions for this URL are not specified in the manifest file, the API call will fail.
         */
        var url: String,
        /**
         * The name of the cookie to retrieve.
         */
        var name: String,
        /**
         * The ID of the cookie store in which to look for the cookie. By default, the current execution context's cookie store will be used.
         */
        var storeId: String?
)

/**
 * Information to filter the cookies being retrieved.
 */
class Details2(
        /**
         * Restricts the retrieved cookies to those that would match the given URL.
         */
        var url: String?,
        /**
         * Filters the cookies by name.
         */
        var name: String?,
        /**
         * Restricts the retrieved cookies to those whose domains match or are subdomains of this one.
         */
        var domain: String?,
        /**
         * Restricts the retrieved cookies to those whose path exactly matches this string.
         */
        var path: String?,
        /**
         * Filters the cookies by their Secure property.
         */
        var secure: Boolean?,
        /**
         * Filters out session vs. persistent cookies.
         */
        var session: Boolean?,
        /**
         * The cookie store to retrieve cookies from. If omitted, the current execution context's cookie store will be used.
         */
        var storeId: String?
)

/**
 * Details about the cookie being set.
 */
class Details3(
        /**
         * The request-URI to associate with the setting of the cookie. This value can affect the default domain and path values of the created cookie. If host permissions for this URL are not specified in the manifest file, the API call will fail.
         */
        var url: String,
        /**
         * The name of the cookie. Empty by default if omitted.
         */
        var name: String?,
        /**
         * The value of the cookie. Empty by default if omitted.
         */
        var value: String?,
        /**
         * The domain of the cookie. If omitted, the cookie becomes a host-only cookie.
         */
        var domain: String?,
        /**
         * The path of the cookie. Defaults to the path portion of the url parameter.
         */
        var path: String?,
        /**
         * Whether the cookie should be marked as Secure. Defaults to false.
         */
        var secure: Boolean?,
        /**
         * Whether the cookie should be marked as HttpOnly. Defaults to false.
         */
        var httpOnly: Boolean?,
        /**
         * The expiration date of the cookie as the number of seconds since the UNIX epoch. If omitted, the cookie becomes a session cookie.
         */
        var expirationDate: Int?,
        /**
         * The ID of the cookie store in which to set the cookie. By default, the cookie is set in the current execution context's cookie store.
         */
        var storeId: String?
)

/**
 * Information to identify the cookie to remove.
 */
class Details4(
        /**
         * The URL associated with the cookie. If host permissions for this URL are not specified in the manifest file, the API call will fail.
         */
        var url: String,
        /**
         * The name of the cookie to remove.
         */
        var name: String,
        /**
         * The ID of the cookie store to look in for the cookie. If unspecified, the cookie is looked for by default in the current execution context's cookie store.
         */
        var storeId: String?
)

/**
 * Contains details about the cookie that's been removed.  If removal failed for any reason, this will be "null", and $(ref:runtime.lastError) will be set.
 */
external class Details5 {
    /**
     * The URL associated with the cookie that's been removed.
     */
    var url: String

    /**
     * The name of the cookie that's been removed.
     */
    var name: String

    /**
     * The ID of the cookie store from which the cookie was removed.
     */
    var storeId: String
}

external class ChangeInfo {
    /**
     * True if a cookie was removed.
     */
    var removed: Boolean

    /**
     * Information about the cookie that was set or removed.
     */
    var cookie: Cookie

    /**
     * The underlying reason behind the cookie's change.
     */
    var cause: OnChangedCause
}

external class CookiesNamespace {
    val onChanged: Event<(changeInfo: ChangeInfo) -> Unit>

    /**
     * Retrieves information about a single cookie. If more than one cookie of the same name exists for the given URL, the one with the longest path will be returned. For cookies with the same path length, the cookie with the earliest creation time will be returned.
     */
    fun get(details: Details): Promise<Cookie>

    /**
     * Retrieves all cookies from a single cookie store that match the given information.  The cookies returned will be sorted, with those with the longest path first.  If multiple cookies have the same path length, those with the earliest creation time will be first.
     */
    fun getAll(details: Details2): Promise<Array<Cookie>>

    /**
     * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
     */
    fun set(details: Details3): Promise<Cookie>

    /**
     * Deletes a cookie by name.
     */
    fun remove(details: Details4): Promise<Details5>

    /**
     * Lists all existing cookie stores.
     */
    fun getAllCookieStores(): Promise<Array<CookieStore>>
}
