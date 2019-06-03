package tech.visuallatam.bkbscore.GUI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.partido_cardview.view.*
import tech.visuallatam.bkbscore.Database.Entities.partido
import tech.visuallatam.bkbscore.R

class adapter(var lista:List<partido>): RecyclerView.Adapter<adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.partido_cardview,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(lista[position])
    }

    fun updateList(newlista : List<partido>){
        this.lista = newlista
        notifyDataSetChanged()}


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(match:partido) = with(itemView){
            this.team1.text = match.equipo1
            this.team2.text = match.equipo2
            this.score1.text = match.score1.toString()
            this.score2.text = match.score2.toString()
            this.textView.text = match.fecha
            this.textView3.text = "Ganador: "+match.winner
        }
    }

}

