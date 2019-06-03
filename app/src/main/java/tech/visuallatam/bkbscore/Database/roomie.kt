package tech.visuallatam.bkbscore.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import tech.visuallatam.bkbscore.Database.DAO.partidoDAO
import tech.visuallatam.bkbscore.Database.Entities.partido

@Database(entities = [partido::class],version=2,exportSchema = false)
public abstract  class roomie : RoomDatabase() {
abstract fun partidoDAO():partidoDAO


    companion object{
        @Volatile
        private  var INSTANCE : roomie? = null

        fun getInstance(context : Context):roomie{
            if(INSTANCE!=null){
                return INSTANCE!!
            }else{
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        roomie::class.java,
                        "partidos"
                    ).build()
                    return INSTANCE!!
                }

            }
        }


    }


}