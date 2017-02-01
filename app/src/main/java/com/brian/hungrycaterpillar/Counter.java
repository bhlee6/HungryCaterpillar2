package com.brian.hungrycaterpillar;

/**
 * Counter class helps keep track of a changing counter within the application,
 * primarily used as the method of tracking the page number for navigating between
 * different page data.
 */
class Counter{

    private static Counter instance;
    private static int currentCount = 0;

    private Counter(){}

    int getCurrentCount() {
        return Counter.currentCount;
    }

    void setCurrentCount(int i) {
        Counter.currentCount = i;
    }

    static synchronized Counter getInstance(){
        if(instance == null) {
            instance=new Counter();
        }
            return instance;
    }
}

