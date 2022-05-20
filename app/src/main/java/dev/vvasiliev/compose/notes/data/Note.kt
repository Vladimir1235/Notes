package dev.vvasiliev.compose.notes.data

import android.net.Uri
import androidx.compose.ui.graphics.Color
import java.util.Date

/**
 * Note model
 */
interface Note {

    /**
     * Note identifier
     */
    val id: Long

    /**
     * Date note was modified last time
     */
    val lastModify: Date

    /**
     * Note title
     */
    val title: String

    /**
     * Note content
     */
    val text: String

    /**
     * Note background
     */
    val background: Background
}


/**
 * Notification scheduling option
 */
interface SchedulingNoteSection{
    val notifyDate: Date
    val notifyType: NotificationType
}

/**
 * Note background
 */
sealed class Background{
    class ColorBg(val color: Color): Background()
    class PictureBg(val picture: Uri): Background()
}

enum class NotificationType{
    SOUND, BANNER, BOTH
}