package com.ucplayer.app.core.parser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
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
public final class PluginManager_Factory implements Factory<PluginManager> {
  private final Provider<Set<ParserPlugin>> pluginsProvider;

  public PluginManager_Factory(Provider<Set<ParserPlugin>> pluginsProvider) {
    this.pluginsProvider = pluginsProvider;
  }

  @Override
  public PluginManager get() {
    return newInstance(pluginsProvider.get());
  }

  public static PluginManager_Factory create(Provider<Set<ParserPlugin>> pluginsProvider) {
    return new PluginManager_Factory(pluginsProvider);
  }

  public static PluginManager newInstance(Set<ParserPlugin> plugins) {
    return new PluginManager(plugins);
  }
}
