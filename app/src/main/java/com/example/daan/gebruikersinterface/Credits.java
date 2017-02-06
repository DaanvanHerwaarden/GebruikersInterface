package com.example.daan.gebruikersinterface;


/**
 * Created by Daan on 2-2-2017.
 */

public class Credits {
    CreditChangedListener creditChangedListener;
    int counter = 0;

    public Credits(CreditChangedListener ccl){
        creditChangedListener = ccl;

    }

    public void up(){
        counter++;
        creditChangedListener.countChanged(counter);
    }
    public void reset(){
        counter = 0;
        creditChangedListener.countChanged(counter);
    }

    public interface CreditChangedListener {
        void countChanged(int counter);
    }



}

