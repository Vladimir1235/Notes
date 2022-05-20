package core.di

import android.content.Context
import androidx.room.Room
import core.db.NoteDB
import core.db.databaseName
import core.db.entity.BgConverter
import dagger.Module
import dagger.Provides

@Module
class CoreModule {
    @Provides
    fun provideDataBase(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        NoteDB::class.java, databaseName
    ).addTypeConverter(BgConverter()).build()
}