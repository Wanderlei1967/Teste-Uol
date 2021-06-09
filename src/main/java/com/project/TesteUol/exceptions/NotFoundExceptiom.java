package com.project.TesteUol.exceptions;

import com.project.TesteUol.util.MessageUtils;

public class NotFoundExceptiom extends RuntimeException{

    public NotFoundExceptiom(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}
