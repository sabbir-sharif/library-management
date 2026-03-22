package com.sabbir.library.app;

import com.sabbir.library.controller.LibraryController;
import com.sabbir.library.models.Book;
import com.sabbir.library.models.Borrow;
import com.sabbir.library.models.Member;
import com.sabbir.library.service.BorrowService;

public class LibraryApplication{

    public static void main(String[] args) {
        new LibraryController().start();
    }
}
