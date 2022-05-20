package core.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.vvasiliev.compose.notes.NoteAppActivity

@Module
interface InjectorContribution {

    @ContributesAndroidInjector(modules = [CoreModule::class])
    fun injectMainActivity(): NoteAppActivity
}