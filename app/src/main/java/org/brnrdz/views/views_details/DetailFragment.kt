package org.brnrdz.views.views_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*
import org.brnrdz.R
import org.brnrdz.data.data_model.Book

class DetailFragment : Fragment() {
    private lateinit var viewModel: BookDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookDetailsViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val BookId = arguments?.getInt(getString(R.string.book_id))
        BookId?.let{
            viewModel.getBookDetails(BookId).observe(this, Observer { BookDetails ->
                populateBookDetails(BookDetails)
            })
        }
    }

    private fun populateBookDetails(Book: Book?){
        textViewBookName.text = Book?.name
        textViewWritter.text = Book?.writter
        textViewGenre.text = Book?.genre

    }
}