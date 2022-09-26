package com.newslineapp.db

import android.content.Context
import androidx.room.*
import com.newslineapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)

abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDatabase? = null   //создаём экземпляр БД
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {     //Возвращаем текущий экзепляр БД при создании экзепляра класса
            instance ?: createDatabase(context).also{ instance = it}                 //устанавливаем результат функции createDatabase
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}