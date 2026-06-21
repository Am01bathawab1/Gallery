package org.fossify.gallery.helpers

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import java.io.File

object HeifDecoderWrapper {

    /**
     * Decodes HEIC/HEIF from a file using Android's ImageDecoder (API 28+).
     * Returns null on failure.
     */
    fun decode(file: File): Bitmap? {
        return try {
            val source = ImageDecoder.createSource(file)
            ImageDecoder.decodeBitmap(source)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
