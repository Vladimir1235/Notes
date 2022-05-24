package core.di

import core.di.scope.AppScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.vvasiliev.compose.notes.NoteAppActivity
import javax.inject.Singleton

@Module
abstract class InjectorContribution{
    @ContributesAndroidInjector
    abstract fun injectMainActivity(): NoteAppActivity
}