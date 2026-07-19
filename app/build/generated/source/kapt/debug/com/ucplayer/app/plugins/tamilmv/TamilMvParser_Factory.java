package com.ucplayer.app.plugins.tamilmv;

import com.ucplayer.app.core.network.NetworkClient;
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
public final class TamilMvParser_Factory implements Factory<TamilMvParser> {
  private final Provider<NetworkClient> networkClientProvider;

  public TamilMvParser_Factory(Provider<NetworkClient> networkClientProvider) {
    this.networkClientProvider = networkClientProvider;
  }

  @Override
  public TamilMvParser get() {
    return newInstance(networkClientProvider.get());
  }

  public static TamilMvParser_Factory create(Provider<NetworkClient> networkClientProvider) {
    return new TamilMvParser_Factory(networkClientProvider);
  }

  public static TamilMvParser newInstance(NetworkClient networkClient) {
    return new TamilMvParser(networkClient);
  }
}
