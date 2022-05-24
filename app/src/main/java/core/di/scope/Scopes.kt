package core.di.scope

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class ViewModelScope