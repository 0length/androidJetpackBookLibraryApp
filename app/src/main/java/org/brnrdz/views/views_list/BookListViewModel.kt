package org.brnrdz.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import org.brnrdz.StartApp
import org.brnrdz.data.data_model.Book

class BookListViewModel(application : Application) : AndroidViewModel(application) {
    private val BookRepo = getApplication<StartApp>().getBookRepo()
    private val BookList = MediatorLiveData<List<Book>>()

    init {
        getAllBook()
    }

    fun getBookList() : LiveData<List<Book>> {
        return BookList
    }

    fun getAllBook(){
        BookList.addSource(BookRepo.getAllBook()){
                books -> BookList.postValue(books)
        }
    }


}