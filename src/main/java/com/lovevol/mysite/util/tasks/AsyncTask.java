package com.lovevol.mysite.util.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    @Async
    public Future<Boolean> doSomething(){
        return new AsyncResult<>(true);
    }
}
