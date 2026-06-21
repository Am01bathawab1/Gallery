package org.fossify.gallery

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.heifdecoder.HeifDecoder
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import java.io.InputStream
import android.graphics.Bitmap

@GlideModule
class MyGlideModule : AppGlideModule() {

    override fun isManifestParsingEnabled(): Boolean = false

    override fun registerComponents(
        context: android.content.Context,
        glide: Glide,
        registry: Registry
    ) {
        registry.prepend(
            InputStream::class.java,
            Bitmap::class.java,
            HeifDecoder(context)
        )
    }
}
