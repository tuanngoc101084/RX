package com.example.rxjavaandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Edits;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    Disposable disposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<String> observableNames= Observable.just("Teo","Ti","Tun");
        List<String> list= new ArrayList<>();
        list.add("Nguyen Tuan Ngoc");
        list.add("Nguyen Thi Truog Giang");
        Iterator<String> stringIterator= list.iterator();
        while (stringIterator.hasNext())
        {
            Log.d("BBB", stringIterator.next());
        }
        observableNames.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
            }

            @Override
            public void onNext(String s) {
                Log.d("BBB",s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
              disposable.dispose();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("bbb",disposable.isDisposed()+"");
            }
        },1000);
    }
}
