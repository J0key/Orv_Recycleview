package com.example.testing1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ChapterAdapter(private val chapterlist:ArrayList<chapter>)
    : RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {

    var onItemClick : ((chapter) -> Unit)? = null

    class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.image)
        val textView : TextView = itemView.findViewById(R.id.title)
        val textViewds : TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent,false)
        return ChapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chapterlist.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chap = chapterlist[position]
        holder.imageView.setImageResource(chap.image)
        holder.textView.text = chap.name
        holder.textViewds.text = chap.desc

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(chap)

        }
    }
}