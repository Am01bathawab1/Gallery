package org.fossify.gallery.helpers

import com.squareup.picasso.Picasso
import com.squareup.picasso.Request
import com.squareup.picasso.RequestHandler
import java.io.File

class HeifRequestHandler : RequestHandler() {

    override fun canHandleRequest(data: Request): Boolean {
        val uri = data.uri ?: return false
        if (uri.scheme != "file") return false
        val path = uri.path ?: return false
        return path.endsWith(".heic", ignoreCase = true) ||
                path.endsWith(".heif", ignoreCase = true)
    }

    override fun load(request: Request, networkPolicy: Int): Result {
        val uri = request.uri ?: throw IllegalStateException("Uri missing")
        val file = File(uri.path!!)
        val inputStream = file.inputStream()
        val bitmap = HeifDecoderWrapper.decode(inputStream)
        return Result(bitmap, Picasso.LoadedFrom.DISK)
    }
}
