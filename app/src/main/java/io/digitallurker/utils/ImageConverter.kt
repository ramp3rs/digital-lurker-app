package io.digitallurker.utils

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

object ImageConverter {
    fun uriToFile(context: Context, uri: Uri): File? {
        var inputStream: InputStream? = null
        var fileOutputStream: FileOutputStream? = null
        var outputFile: File? = null
        try {
            inputStream = context.contentResolver.openInputStream(uri)
            if (inputStream != null) {
                val file = File(context.cacheDir, "temp_image_file")
                fileOutputStream = FileOutputStream(file)
                val buffer = ByteArray(4 * 1024) // 4K buffer
                var read: Int
                while (inputStream.read(buffer).also { read = it } != -1) {
                    fileOutputStream.write(buffer, 0, read)
                }
                fileOutputStream.flush()
                outputFile = file
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream?.close()
                fileOutputStream?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return outputFile
    }

}