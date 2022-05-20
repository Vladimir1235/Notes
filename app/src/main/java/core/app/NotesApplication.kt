package core.app

import android.app.Application
import core.di.CoreComponent
import core.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class NotesApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        coreComponent = DaggerCoreComponent.builder().bindApplication(this).build()
    }

    override fun androidInjector(): AndroidInjector<Any> = injector
}