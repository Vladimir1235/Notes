package core.db.entity

import androidx.compose.ui.graphics.Color
import androidx.core.net.toUri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import core.db.model.tableName
import dev.vvasiliev.compose.notes.data.Background
import dev.vvasiliev.compose.notes.data.Note
import java.util.*

@Entity(tableName = tableName)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long,
    @ColumnInfo(name = "title")
    override val title: String,
    @ColumnInfo(name = "background")
    override val background: Background.ColorBg,
    @ColumnInfo(name = "modification")
    override val lastModify: Date,
    @ColumnInfo(name = "text")
    override val text: String
): Note

class BgConverter{

    @TypeConverter
    fun convertBackground(colorBg :Background.ColorBg): Int = colorBg.color.hashCode()

    @TypeConverter
    fun convertDate(date: Date): String = date.toString()

    @TypeConverter
    fun convertDate(date: String): Date = Date(date)

    @TypeConverter
    fun convertBackground(picBg: Background.PictureBg): String = picBg.picture.toString()

    @TypeConverter
    fun convertBackground(bg: Int): Background.ColorBg = Background.ColorBg(Color(bg))

    @TypeConverter
    fun convertBackground(bg: String): Background.PictureBg = Background.PictureBg(bg.toUri())
}