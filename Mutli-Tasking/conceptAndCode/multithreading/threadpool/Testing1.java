package multithreading.threadpool;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(false);
        thread.setPriority(Thread.MIN_PRIORITY);
        return thread;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task " + r.toString() + " rejected from " + executor.toString());

        if(r instanceof Future<?>){
            ((Future<?>) r).cancel(false);
        }
    }
}

public class Testing1 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, // core pool size
                4, // maximum pool size
                60, // keep-alive time
                java.util.concurrent.TimeUnit.SECONDS, // time unit for keep-alive
                new ArrayBlockingQueue<>(2), // work queue with capacity of 2
                new CustomThreadFactory(), // custom thread factory
//                new ThreadPoolExecutor.AbortPolicy(),
                new CustomRejectHandler() // custom rejection handler
        );

        for (int i = 0; i < 8; i++) {
            final int taskId = i;
            pool.submit(() -> {
                System.out.println("Executing task " + taskId);
                try {
                    sleep(5000); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

//        if you submit Runnable task then assign it to Future<?>

        Future<Integer> result = pool.submit(()->{
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 42;
        });

        try{
            System.out.println("Result: " + result.get(5, java.util.concurrent.TimeUnit.SECONDS));  // keeps on waiting till it gets value from the FutureTask, so we use Timeout to avoid waiting forever
        }catch(CancellationException e){
            System.out.println("Task was cancelled");
        }
        catch (InterruptedException | ExecutionException | java.util.concurrent.TimeoutException e) {
            e.printStackTrace();
        }

        // _______________________________________________________

        System.out.println("Shutdown : " + pool.isShutdown());
        System.out.println("Terminated : " + pool.isTerminated());

//        pool.shutdown();

        System.out.println("Shutdown : " + pool.isShutdown());
        System.out.println("Terminated : " + pool.isTerminated());

        try{
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Shutdown : " + pool.isShutdown());
        System.out.println("Terminated : " + pool.isTerminated());

        // Task chaining_______________________________________________________

        // when you use CompleteableFuture.supplyAsync() without providing a custom executor, it uses ForkJoinPool.commonPool() by default.

        Future<Integer> ftask2 = CompletableFuture.supplyAsync(()->{

            System.out.println(10);
            return 10;
        },pool).thenApply((num)->{
            System.out.println("Function apply :" + num);
            return num * 2;
        }).thenApplyAsync((num)->{
            System.out.println("Function apply async :" + num);
            return num * 2;
        });

        // .thenApply() -- is synchronous, it will run in the same thread as the previous stage, while .thenApplyAsync() -- is asynchronous, it will run in a different thread, which is provided by the executor (in this case, the custom thread pool).
        // .thenApplyAsync() -- is async - assigns to different thread and is useful when you want to perform a computation that might take some time and you don't want to block the main thread.

        try {
            System.out.println("Result of ftask2: " + ftask2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
*
* threadFactory - functional interface to centralize thread configuration, override newThread()
* Executors.defaultThreadFactory() - default implementation of thread factory, creates new threads with default settings
* rejectedExecutionHandler - functional interface to handle rejected tasks, override rejectedExecution()
* Executors.defaultThreadFactory() - default implementation of rejected execution handler, throws RejectedExecutionException
* ForkJoinWorkerThreadFactory
*  */
