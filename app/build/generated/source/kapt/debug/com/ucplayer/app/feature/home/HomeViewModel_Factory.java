package com.ucplayer.app.feature.home;

import com.ucplayer.app.core.database.HistoryRepository;
import com.ucplayer.app.core.parser.PluginManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<PluginManager> pluginManagerProvider;

  private final Provider<HistoryRepository> historyRepositoryProvider;

  public HomeViewModel_Factory(Provider<PluginManager> pluginManagerProvider,
      Provider<HistoryRepository> historyRepositoryProvider) {
    this.pluginManagerProvider = pluginManagerProvider;
    this.historyRepositoryProvider = historyRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(pluginManagerProvider.get(), historyRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<PluginManager> pluginManagerProvider,
      Provider<HistoryRepository> historyRepositoryProvider) {
    return new HomeViewModel_Factory(pluginManagerProvider, historyRepositoryProvider);
  }

  public static HomeViewModel newInstance(PluginManager pluginManager,
      HistoryRepository historyRepository) {
    return new HomeViewModel(pluginManager, historyRepository);
  }
}
