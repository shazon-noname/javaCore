package Multithreading.exercise.exercise7;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing.
The read lock may be held simultaneously by multiple reader threads, so long as there are no writers. The write lock is exclusive.

All ReadWriteLock implementations must guarantee that the memory synchronization effects of writeLock operations (as specified in the Lock interface) also hold with respect to the associated readLock.
That is, a thread successfully acquiring the read lock will see all updates made upon previous release of the write lock.

A read-write lock allows for a greater level of concurrency in accessing shared data than that permitted by a mutual exclusion lock.
It exploits the fact that while only a single thread at a time (a writer thread) can modify the shared data, in many cases any number of threads can concurrently read the data (hence reader threads).
In theory, the increase in concurrency permitted by the use of a read-write lock will lead to performance improvements over the use of a mutual exclusion lock.
In practice this increase in concurrency will only be fully realized on a multiprocessor, and then only if the access patterns for the shared data are suitable.

Write a Java program to illustrate the usage of the ReadWriteLock interface for concurrent read-write access to a shared resource.
 */

public class ReadWriteLockExercise {
    private static final int NUM_READERS = 3;
    private static final int NUM_WRITERS = 2;

    public static void main(String[] args) {
        ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        SharedResource sharedResource = new SharedResource();

        // Create and start the reader threads
        for (int i = 0; i < NUM_READERS; i++) {
            Thread readerThread = new Thread(new Reader(reentrantReadWriteLock, sharedResource));
            readerThread.start();
        }

        // Create and start the writer threads
        for (int i = 0; i < NUM_WRITERS; i++) {
            Thread writerThread = new Thread(new Writer(reentrantReadWriteLock, sharedResource));
            writerThread.start();
        }
    }

    static class Reader implements Runnable {
        private ReadWriteLock readWriteLock;
        private SharedResource sharedResource;

        public Reader(ReadWriteLock readWriteLock, SharedResource sharedResource) {
            this.readWriteLock = readWriteLock;
            this.sharedResource = sharedResource;
        }

        public void run() {
            while (true) {
                readWriteLock.readLock().lock();

                // Read from the shared resource
                System.out.println("Reader " + Thread.currentThread().getName() + " reads: " + sharedResource.read());

                readWriteLock.readLock().unlock();

                // Delay between consecutive reads
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Writer implements Runnable {
        private ReadWriteLock readWriteLock;
        private SharedResource sharedResource;
        private int counter = 0;

        public Writer(ReadWriteLock readWriteLock, SharedResource sharedResource) {
            this.readWriteLock = readWriteLock;
            this.sharedResource = sharedResource;
        }

        public void run() {
            while (true) {
                readWriteLock.writeLock().lock();

                // Write to the shared resource
                sharedResource.write("Writer " + Thread.currentThread().getName() + " writes: " + counter++);

                readWriteLock.writeLock().unlock();

                // Delay between consecutive writing
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SharedResource {
        private String data;

        public String read() {
            return data;
        }

        public void write(String data) {
            this.data = data;
        }
    }
}
