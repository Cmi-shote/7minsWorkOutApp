package com.example.a7minsworkoutapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase(){


    abstract fun historyDao() : HistoryDao

    //now adding a companion object that will help us add functions to the employee database class

    companion object{

        //this will keep a reference to any database returned by our get instance
        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase{

            synchronized(this){
                var instance = INSTANCE

                if(instance == null ){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HistoryDatabase::class.java,
                        "History_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance

                }
                return instance
            }

        }
    }
}