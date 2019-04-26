package org.brnrdz

import android.app.Application
import org.brnrdz.data.BookRepo

class StartApp : Application(){
    fun getBookRepo() = BookRepo(this)
}