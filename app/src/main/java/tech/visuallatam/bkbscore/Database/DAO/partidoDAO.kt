package tech.visuallatam.bkbscore.Database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tech.visuallatam.bkbscore.Database.Entities.partido


@Dao
interface partidoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido:partido)

    @Query("SELECT * FROM partido")
    fun getAll():LiveData<List<partido>>

    @Query("DELETE FROM partido")
    suspend fun nuke()


}
