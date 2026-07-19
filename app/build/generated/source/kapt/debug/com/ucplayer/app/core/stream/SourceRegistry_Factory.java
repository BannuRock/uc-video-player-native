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
public final class SourceRegistry_Factory implements Factory<SourceRegistry> {
  private final Provider<Context> contextProvider;

  private final Provider<TorrentEngine> torrentEngineProvider;

  private final Provider<NetworkClient> networkClientProvider;

  public SourceRegistry_Factory(Provider<Context> contextProvider,
      Provider<TorrentEngine> torrentEngineProvider,
      Provider<NetworkClient> networkClientProvider) {
    this.contextProvider = contextProvider;
    this.torrentEngineProvider = torrentEngineProvider;
    this.networkClientProvider = networkClientProvider;
  }

  @Override
  public SourceRegistry get() {
    return newInstance(contextProvider.get(), torrentEngineProvider.get(), networkClientProvider.get());
  }

  public static SourceRegistry_Factory create(Provider<Context> contextProvider,
      Provider<TorrentEngine> torrentEngineProvider,
      Provider<NetworkClient> networkClientProvider) {
    return new SourceRegistry_Factory(contextProvider, torrentEngineProvider, networkClientProvider);
  }

  public static SourceRegistry newInstance(Context context, TorrentEngine torrentEngine,
      NetworkClient networkClient) {
    return new SourceRegistry(context, torrentEngine, networkClient);
  }
}
