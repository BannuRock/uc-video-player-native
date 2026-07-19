package com.ucplayer.app.di;

import com.ucplayer.app.core.parser.DirectStreamParser;
import com.ucplayer.app.core.parser.ParserPlugin;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideDirectStreamParserFactory implements Factory<ParserPlugin> {
  private final Provider<DirectStreamParser> parserProvider;

  public AppModule_ProvideDirectStreamParserFactory(Provider<DirectStreamParser> parserProvider) {
    this.parserProvider = parserProvider;
  }

  @Override
  public ParserPlugin get() {
    return provideDirectStreamParser(parserProvider.get());
  }

  public static AppModule_ProvideDirectStreamParserFactory create(
      Provider<DirectStreamParser> parserProvider) {
    return new AppModule_ProvideDirectStreamParserFactory(parserProvider);
  }

  public static ParserPlugin provideDirectStreamParser(DirectStreamParser parser) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDirectStreamParser(parser));
  }
}
