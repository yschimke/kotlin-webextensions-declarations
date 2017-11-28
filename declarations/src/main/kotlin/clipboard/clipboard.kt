package clipboard

import kotlin.js.Promise

class SetImageDataImageData()

external class Clipboard {
  /**
   * Copy an image to the clipboard. The image is re-encoded before it is written to the clipboard. If the image is invalid, the clipboard is not modified.
   */
  fun setImageData(imageData: SetImageDataImageData, imageType: String): Promise<Any>
}
