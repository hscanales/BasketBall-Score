package tech.visuallatam.bkbscore.Database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="partido")
data class partido(
    @PrimaryKey
    val fecha : String,
    val equipo1: String,
    val equipo2 : String,
    val score1: Int,
    val score2: Int,
    val winner: String
)