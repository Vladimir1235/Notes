package core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import core.db.entity.BgConverter
import core.db.entity.NoteEntity
import core.db.model.NoteDao

const val databaseName = "NotesDB"

@Database(
    entities = [NoteEntity::class],
    version = 0
)
@TypeConverters(BgConverter::class)
abstract class NoteDB : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}