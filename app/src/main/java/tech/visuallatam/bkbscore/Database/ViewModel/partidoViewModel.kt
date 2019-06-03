package tech.visuallatam.bkbscore.Database.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.visuallatam.bkbscore.Database.DAO.partidoDAO
import tech.visuallatam.bkbscore.Database.Entities.partido
import tech.visuallatam.bkbscore.Database.repository.partidoRepository
import tech.visuallatam.bkbscore.Database.roomie

class partidoViewModel(private val app:Application):AndroidViewModel(app){
    private val repo : partidoRepository

    init{
        val dao = roomie.getInstance(app).partidoDAO()
        repo= partidoRepository(dao)

    }

    public suspend fun insert(partido : partido) = repo.insert(partido)

    public suspend fun nuke()  = repo.nuke()

    public fun todos():LiveData<List<partido>> = repo.all()

    fun finished(partido: partido) = viewModelScope.launch {
        this@partidoViewModel.insert(partido)
    }

}