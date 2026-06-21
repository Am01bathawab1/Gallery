package org.fossify.gallery.helpers

import android.graphics.Bitmap
import com.bumptech.glide.integration.heifdecoder.HeifDecoder
import java.io.InputStream

object HeifDecoderWrapper {

    private val decoder = HeifDecoder(null) // null context is fine

    /**
     * Decodes HEIC/HEIF from the stream.
     * Returns null on failure.
     */
    fun decode(stream: InputStream): Bitmap? {
        return try {
            decoder.decode(stream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            try {
                stream.close()
            } catch (_: Exception) {}
        }
    }
}
