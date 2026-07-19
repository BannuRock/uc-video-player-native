package com.ucplayer.app.core.parser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class DirectStreamParser_Factory implements Factory<DirectStreamParser> {
  @Override
  public DirectStreamParser get() {
    return newInstance();
  }

  public static DirectStreamParser_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DirectStreamParser newInstance() {
    return new DirectStreamParser();
  }

  private static final class InstanceHolder {
    private static final DirectStreamParser_Factory INSTANCE = new DirectStreamParser_Factory();
  }
}
