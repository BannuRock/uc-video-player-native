package com.ucplayer.app;

import com.ucplayer.app.core.cache.CacheManager;
import com.ucplayer.app.core.network.NetworkClient;
import com.ucplayer.app.core.stream.LoopbackServer;
import com.ucplayer.app.core.stream.SessionManager;
import com.ucplayer.app.core.torrent.TorrentEngine;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<CacheManager> cacheManagerProvider;

  private final Provider<NetworkClient> networkClientProvider;

  private final Provider<LoopbackServer> loopbackServerProvider;

  private final Provider<SessionManager> sessionManagerProvider;

  private final Provider<TorrentEngine> torrentEngineProvider;

  public MainActivity_MembersInjector(Provider<CacheManager> cacheManagerProvider,
      Provider<NetworkClient> networkClientProvider,
      Provider<LoopbackServer> loopbackServerProvider,
      Provider<SessionManager> sessionManagerProvider,
      Provider<TorrentEngine> torrentEngineProvider) {
    this.cacheManagerProvider = cacheManagerProvider;
    this.networkClientProvider = networkClientProvider;
    this.loopbackServerProvider = loopbackServerProvider;
    this.sessionManagerProvider = sessionManagerProvider;
    this.torrentEngineProvider = torrentEngineProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<CacheManager> cacheManagerProvider,
      Provider<NetworkClient> networkClientProvider,
      Provider<LoopbackServer> loopbackServerProvider,
      Provider<SessionManager> sessionManagerProvider,
      Provider<TorrentEngine> torrentEngineProvider) {
    return new MainActivity_MembersInjector(cacheManagerProvider, networkClientProvider, loopbackServerProvider, sessionManagerProvider, torrentEngineProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectCacheManager(instance, cacheManagerProvider.get());
    injectNetworkClient(instance, networkClientProvider.get());
    injectLoopbackServer(instance, loopbackServerProvider.get());
    injectSessionManager(instance, sessionManagerProvider.get());
    injectTorrentEngine(instance, torrentEngineProvider.get());
  }

  @InjectedFieldSignature("com.ucplayer.app.MainActivity.cacheManager")
  public static void injectCacheManager(MainActivity instance, CacheManager cacheManager) {
    instance.cacheManager = cacheManager;
  }

  @InjectedFieldSignature("com.ucplayer.app.MainActivity.networkClient")
  public static void injectNetworkClient(MainActivity instance, NetworkClient networkClient) {
    instance.networkClient = networkClient;
  }

  @InjectedFieldSignature("com.ucplayer.app.MainActivity.loopbackServer")
  public static void injectLoopbackServer(MainActivity instance, LoopbackServer loopbackServer) {
    instance.loopbackServer = loopbackServer;
  }

  @InjectedFieldSignature("com.ucplayer.app.MainActivity.sessionManager")
  public static void injectSessionManager(MainActivity instance, SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }

  @InjectedFieldSignature("com.ucplayer.app.MainActivity.torrentEngine")
  public static void injectTorrentEngine(MainActivity instance, TorrentEngine torrentEngine) {
    instance.torrentEngine = torrentEngine;
  }
}
