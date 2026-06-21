package org.fossify.gallery

import android.app.Application
import com.squareup.picasso.Picasso
import org.fossify.gallery.helpers.PicassoHeifFactory

class GalleryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val heifPicasso = PicassoHeifFactory.create(this)
        Picasso.setSingletonInstance(heifPicasso)
    }
}
