package com.ucplayer.app.di

import android.content.Context
import androidx.room.Room
import com.ucplayer.app.core.database.AppDatabase
import com.ucplayer.app.core.database.HistoryDao
import com.ucplayer.app.core.parser.DirectStreamParser
import com.ucplayer.app.core.parser.ParserPlugin
import com.ucplayer.app.plugins.tamilmv.TamilMvParser
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ucplayer.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideHistoryDao(db: AppDatabase): HistoryDao {
        return db.historyDao()
    }

    @Provides
    @IntoSet
    fun provideTamilMvParser(parser: TamilMvParser): ParserPlugin {
        return parser
    }

    @Provides
    @IntoSet
    fun provideDirectStreamParser(parser: DirectStreamParser): ParserPlugin {
        return parser
    }
}
