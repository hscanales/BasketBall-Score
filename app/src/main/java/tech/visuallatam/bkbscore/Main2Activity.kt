package tech.visuallatam.bkbscore

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.match.*
import tech.visuallatam.bkbscore.Database.Entities.partido
import tech.visuallatam.bkbscore.Database.ViewModel.partidoViewModel
import java.text.SimpleDateFormat
import java.util.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.match)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        val extras = intent.extras
        if (extras != null) {
            nameTeam1.text= extras.get("team1").toString()
            nameTeam2.text= extras.get("team2").toString()
        }

        bindT1()
        bindT2()
        bind()
    }

    fun bind(){
        endMatch.setOnClickListener {
            var viewModel = ViewModelProviders.of(this).get(partidoViewModel::class.java)
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            val winner = if (scoreT1.text.toString().toInt() > scoreT2.text.toString().toInt()){
                nameTeam1.text.toString()
            }else{
                nameTeam2.text.toString()
            }

            var match = partido(currentDate,nameTeam1.text.toString(),nameTeam2.text.toString(),scoreT1.text.toString().toInt(),scoreT2.text.toString().toInt(),winner)

            viewModel.finished(match)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }

    fun bindT1(){

        scoreT1.text = "0"

        unoT1.setOnClickListener {
            var score = scoreT1.text.toString().toInt()
            score++
            scoreT1.text = score.toString()}
        dosT1.setOnClickListener {
            var score = scoreT1.text.toString().toInt()
            score +=2
            scoreT1.text = score.toString()}
        tresT1.setOnClickListener {
            var score = scoreT1.text.toString().toInt()
            score +=3
            scoreT1.text = score.toString()}

        bt1.setOnClickListener {
            var score = scoreT1.text.toString().toInt()
            score --
            scoreT1.text = score.toString()}
        bt2.setOnClickListener {
            var score = scoreT1.text.toString().toInt()
            score -=2
            scoreT1.text = score.toString()}
        bt3.setOnClickListener {
            var score = scoreT1.text.toString().toInt()
            score -=3
            scoreT1.text = score.toString()}
    }

    fun bindT2(){

        scoreT2.text = "0"
        menos1.setOnClickListener {
            var score = scoreT2.text.toString().toInt()
            score -=3
            scoreT2.text = score.toString()}
        menos2.setOnClickListener {
            var score = scoreT2.text.toString().toInt()
            score -=2
            scoreT2.text = score.toString()}
        menos3.setOnClickListener {
            var score = scoreT2.text.toString().toInt()
            score -=1
            scoreT2.text = score.toString()}
        unoT2.setOnClickListener {
            var score = scoreT2.text.toString().toInt()
            score++
            scoreT2.text = score.toString()}
        dosT2.setOnClickListener {
            var score = scoreT2.text.toString().toInt()
            score +=2
            scoreT2.text = score.toString()}
        tresT2.setOnClickListener {
            var score = scoreT2.text.toString().toInt()
            score +=3
            scoreT2.text = score.toString()}
    }

}
