package tech.visuallatam.bkbscore

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.new_match1.*

class new_match : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_match1)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bind()
    }


    fun bind(){
        bt_start.setOnClickListener {
            if (this.NameTeam2.text.isEmpty() || this.NameTeam1.text.isEmpty()){
                Toast.makeText(this,"Please Fill all spaces",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, Main2Activity::class.java)
                intent.putExtra("team1", NameTeam1.text.toString())
                intent.putExtra("team2",NameTeam2.text.toString())
                startActivity(intent)
            }

        }
    }


}
