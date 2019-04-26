package org.brnrdz.views.views_list


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.layout_list_item.view.textViewBookName
import kotlinx.android.synthetic.main.layout_list_item.view.textViewWritter
import org.brnrdz.R
import org.brnrdz.data.data_model.Book

class ListBookAdapter (
    private val items : List<Book>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    interface OnItemClickListener{
        fun onItemClick(book: Book, itemView : View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(book: Book, listener: OnItemClickListener) = with(itemView) {
            textViewBookName.text = book.name
            textViewWritter.text = book.writter
            textViewGenre.text = book.genre



            setOnClickListener {
                listener.onItemClick(book, it)
            }
        }
    }

}