package core.di

import android.content.Context
import androidx.room.Room
import core.db.NoteDB
import core.db.databaseName
import core.db.entity.BgConverter
import core.di.scope.AppScope
import dagger.Module
import dagger.Provides
import dev.vvasiliev.compose.notes.navigation.GlobalNavigator
import javax.inject.Singleton

@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideNavigator() = GlobalNavigator()

    @Provides
    fun provideGreeting(): String = "Hello !"

    @Provides
    fun provideDataBase(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        NoteDB::class.java, databaseName
    ).addTypeConverter(BgConverter()).build()
}