
package org.brnrdz.views.views_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import org.brnrdz.StartApp
import org.brnrdz.data.data_model.Book


class AddBookViewModel(application: Application) : AndroidViewModel(application) {

  private val BookRepository = getApplication<StartApp>().getBookRepo()

  fun addBook(book: Book) {
    BookRepository.insertBook(book)
  }

}