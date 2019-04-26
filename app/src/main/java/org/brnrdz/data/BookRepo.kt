package org.brnrdz.data

import android.app.Application
import android.arch.lifecycle.LiveData
import org.brnrdz.data.data_model.Book
import org.brnrdz.data.db_only.BookDAO
import org.brnrdz.data.db_only.BookDb

class BookRepo(application: Application){

    private val bookDao : BookDAO

    init {
        val bookDatabase = BookDb.getInstance(application)
        bookDao = bookDatabase.bookDao()
    }

    fun getAllBook() : LiveData<List<Book>>{

        return bookDao.getAll()
    }
    fun insertBook(book: Book){
        bookDao.insert(book)
    }
    fun findBook(id: Int) : LiveData<Book>{
        return bookDao.find(id)
    }
}