package com.ucplayer.app.core.parser;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001a\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004\u00a2\u0006\u0002\b\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0019\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004\u00a2\u0006\u0002\b\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/ucplayer/app/core/parser/PluginManager;", "", "plugins", "", "Lcom/ucplayer/app/core/parser/ParserPlugin;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Set;)V", "getParserFor", "url", "", "app_debug"})
public final class PluginManager {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<com.ucplayer.app.core.parser.ParserPlugin> plugins = null;
    
    @javax.inject.Inject()
    public PluginManager(@org.jetbrains.annotations.NotNull()
    java.util.Set<com.ucplayer.app.core.parser.ParserPlugin> plugins) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ucplayer.app.core.parser.ParserPlugin getParserFor(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
}