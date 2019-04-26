package org.brnrdz.views.views_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import org.brnrdz.StartApp
import org.brnrdz.data.data_model.Book


class BookDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val BookRepository = getApplication<StartApp>().getBookRepo()
    private val BookId = MutableLiveData<Int>()

    // Maps Book id to Book details
    fun getBookDetails(id: Int): LiveData<Book> {
        BookId.value = id
        val BookDetails = Transformations.switchMap<Int, Book>(BookId) { id ->
            BookRepository.findBook(id)
        }
        return BookDetails
    }

}