package com.ucplayer.app.di;

import com.ucplayer.app.core.parser.ParserPlugin;
import com.ucplayer.app.plugins.tamilmv.TamilMvParser;
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
public final class AppModule_ProvideTamilMvParserFactory implements Factory<ParserPlugin> {
  private final Provider<TamilMvParser> parserProvider;

  public AppModule_ProvideTamilMvParserFactory(Provider<TamilMvParser> parserProvider) {
    this.parserProvider = parserProvider;
  }

  @Override
  public ParserPlugin get() {
    return provideTamilMvParser(parserProvider.get());
  }

  public static AppModule_ProvideTamilMvParserFactory create(
      Provider<TamilMvParser> parserProvider) {
    return new AppModule_ProvideTamilMvParserFactory(parserProvider);
  }

  public static ParserPlugin provideTamilMvParser(TamilMvParser parser) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTamilMvParser(parser));
  }
}
