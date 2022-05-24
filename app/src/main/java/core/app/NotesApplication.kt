package core.app

import core.di.CoreComponent
import core.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

class NotesApplication : DaggerApplication(), HasAndroidInjector {

    var coreComponent: CoreComponent = DaggerCoreComponent.builder().bindApplication(this).build()


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        initDagger()
       return coreComponent
    }

    private fun initDagger(){
        coreComponent.inject(this)
    }
}