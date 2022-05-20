package core.di

import core.app.NotesApplication
import core.di.scope.AppScope
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [CoreModule::class, InjectorContribution::class])
interface CoreComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun bindApplication(app: NotesApplication): Builder

        fun build(): CoreComponent
    }


}