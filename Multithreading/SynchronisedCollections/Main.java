package Multithreading.SynchronisedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        NameList nameList = new NameList();
        nameList.add("first");
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeList());
            }
        }
        new MyThread().start();
        new MyThread().start();
    }

    static class NameList {
        private final List<String> list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name) {
            list.add(name);
        }

        public synchronized String removeList() {                                   //if you don't use synchronized - IndexOutOfBoundsException
            if (!list.isEmpty()) {                                                  // because the second thread can also start checking at the same time as the first
                return (String) list.removeFirst();
            }
            return null;
        }
    }
}
