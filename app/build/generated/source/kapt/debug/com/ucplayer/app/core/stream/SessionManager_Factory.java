package com.ucplayer.app.core.stream;

import android.content.Context;
import com.ucplayer.app.core.network.NetworkClient;
import com.ucplayer.app.core.torrent.TorrentEngine;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class SessionManager_Factory implements Factory<SessionManager> {
  private final Provider<Context> contextProvider;

  private final Provider<TorrentEngine> torrentEngineProvider;

  private final Provider<NetworkClient> networkClientProvider;

  private final Provider<SourceRegistry> sourceRegistryProvider;

  public SessionManager_Factory(Provider<Context> contextProvider,
      Provider<TorrentEngine> torrentEngineProvider, Provider<NetworkClient> networkClientProvider,
      Provider<SourceRegistry> sourceRegistryProvider) {
    this.contextProvider = contextProvider;
    this.torrentEngineProvider = torrentEngineProvider;
    this.networkClientProvider = networkClientProvider;
    this.sourceRegistryProvider = sourceRegistryProvider;
  }

  @Override
  public SessionManager get() {
    return newInstance(contextProvider.get(), torrentEngineProvider.get(), networkClientProvider.get(), sourceRegistryProvider.get());
  }

  public static SessionManager_Factory create(Provider<Context> contextProvider,
      Provider<TorrentEngine> torrentEngineProvider, Provider<NetworkClient> networkClientProvider,
      Provider<SourceRegistry> sourceRegistryProvider) {
    return new SessionManager_Factory(contextProvider, torrentEngineProvider, networkClientProvider, sourceRegistryProvider);
  }

  public static SessionManager newInstance(Context context, TorrentEngine torrentEngine,
      NetworkClient networkClient, SourceRegistry sourceRegistry) {
    return new SessionManager(context, torrentEngine, networkClient, sourceRegistry);
  }
}
