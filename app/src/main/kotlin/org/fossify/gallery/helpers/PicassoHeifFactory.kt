package org.fossify.gallery.helpers

import android.content.Context
import com.squareup.picasso.Picasso

object PicassoHeifFactory {

    fun create(context: Context): Picasso {
        return Picasso.Builder(context)
            .addRequestHandler(HeifRequestHandler())
            .build()
    }
}
