package core.di.scope

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelScope