package org.brnrdz.data.data_net

import org.brnrdz.data.data_model.Book

class BookListInfo {
    companion object{
        var bookList = initBookList()
        
        private fun initBookList() : MutableList<Book>{
            var po_books = mutableListOf<Book>()
            po_books.add(
                Book(
                    "Lucu Sumpah",
                    "Fajar",
                    "Komedi",
                    1))
            po_books.add(Book(
                "Suamiku ternyata Istriku",
                "Fajar juga",
                "Drama",
                2))
            po_books.add(Book(
                "Ini Buku Dao",
                "Si Dao",
                "Programming",
                3))
            return po_books
        }
    }
}