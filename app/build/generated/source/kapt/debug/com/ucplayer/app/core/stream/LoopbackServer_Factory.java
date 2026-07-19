package com.ucplayer.app.core.stream;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class LoopbackServer_Factory implements Factory<LoopbackServer> {
  private final Provider<SessionManager> sessionManagerProvider;

  public LoopbackServer_Factory(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public LoopbackServer get() {
    return newInstance(sessionManagerProvider.get());
  }

  public static LoopbackServer_Factory create(Provider<SessionManager> sessionManagerProvider) {
    return new LoopbackServer_Factory(sessionManagerProvider);
  }

  public static LoopbackServer newInstance(SessionManager sessionManager) {
    return new LoopbackServer(sessionManager);
  }
}
