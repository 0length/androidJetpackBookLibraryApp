package org.brnrdz.views.views_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_for_list_book.*
import org.brnrdz.R
import org.brnrdz.data.data_model.Book

class ListBookFragment :android.support.v4.app.Fragment(), ListBookAdapter.OnItemClickListener {

    private lateinit var viewModel: BookListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_for_list_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
            view.findNavController().navigate(R.id.action1)
        }

        viewModel.getBookList().observe(this, Observer<List<Book>> {
                books -> books?.let {
            populateBookList(books)
        }
        })

    }

    override fun onItemClick(book: Book, itemView: View) {

        val detailBundle = Bundle().apply{
            putInt(getString(R.string.book_id), book.id)
        }
        view?.findNavController()?.navigate(R.id.action2, detailBundle)
    }

    private fun populateBookList(booklist : List<Book>){
        bookRecyclerView.adapter = ListBookAdapter(booklist, this)
    }
}