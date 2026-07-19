package com.ucplayer.app.core.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkClient_Factory implements Factory<NetworkClient> {
  @Override
  public NetworkClient get() {
    return newInstance();
  }

  public static NetworkClient_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NetworkClient newInstance() {
    return new NetworkClient();
  }

  private static final class InstanceHolder {
    private static final NetworkClient_Factory INSTANCE = new NetworkClient_Factory();
  }
}
