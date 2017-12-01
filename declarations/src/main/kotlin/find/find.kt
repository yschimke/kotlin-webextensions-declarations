package find

import kotlin.js.Promise

/**
 * Search parameters.
 */
class Params(
        /**
         * Tab to query. Defaults to the active tab.
         */
        var tabId: Int?,
        /**
         * Find only ranges with case sensitive match.
         */
        var caseSensitive: Boolean?,
        /**
         * Find only ranges that match entire word.
         */
        var entireWord: Boolean?,
        /**
         * Return rectangle data which describes visual position of search results.
         */
        var includeRectData: Boolean?,
        /**
         * Return range data which provides range data in a serializable form.
         */
        var includeRangeData: Boolean?
)

/**
 * highlightResults parameters
 */
class Params2(
        /**
         * Found range to be highlighted. Default highlights all ranges.
         */
        var rangeIndex: Int?,
        /**
         * Tab to highlight. Defaults to the active tab.
         */
        var tabId: Int?,
        /**
         * Don't scroll to highlighted item.
         */
        var noScroll: Boolean?
)

external class FindNamespace {
    /**
     * Search for text in document and store found ranges in array, in document order.
     */
    fun find(queryphrase: String, params: Params): Promise<Any>

    /**
     * Highlight a range
     */
    fun highlightResults(params: Params2): Promise<Any>

    /**
     * Remove all highlighting from previous searches.
     */
    fun removeHighlighting(tabId: Int?): Promise<Any>
}
