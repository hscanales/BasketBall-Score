package tech.visuallatam.bkbscore.Database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import tech.visuallatam.bkbscore.Database.DAO.partidoDAO
import tech.visuallatam.bkbscore.Database.Entities.partido

class partidoRepository(val dao: partidoDAO){

    @WorkerThread
    suspend  fun insert(match : partido)= dao.insert(match)

    fun all():LiveData<List<partido>> = dao.getAll()

    @WorkerThread
    suspend  fun nuke()=dao.nuke()


}