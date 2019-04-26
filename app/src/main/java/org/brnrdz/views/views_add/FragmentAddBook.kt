package org.brnrdz.views.views_add

import android.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add_book.*
import org.brnrdz.R
import org.brnrdz.data.data_model.Book


class FragmentAddBook : android.support.v4.app.Fragment() {
    lateinit var btn_ : Button
    private lateinit var viewModel: AddBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddBookViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View = inflater.inflate(
            R.layout.fragment_add_book,
            container, false)
        btn_ = view.findViewById(R.id.btn_)
        return view
    }

    private fun saveBookInfo(){
        val book = Book(textInputBookName.editText?.text.toString(), textInputWritter.editText?.text.toString(), textInputGenre.editText?.text.toString())

        viewModel.addBook(book)
        Navigation.findNavController(view!!).navigateUp()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            saveBookInfo()
        }
    }
}