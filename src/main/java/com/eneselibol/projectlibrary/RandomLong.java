package com.eneselibol.projectlibrary;

import java.util.Random;

public class RandomLong {

    public long numberRandom(){
        Random r=new Random();
        long l = r.nextLong();
        if(l<0){
            l=l*(-1);
        }
        return l;
    }
}
