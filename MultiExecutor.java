import java.util.ArrayList;
import java.util.List;

public class MultiExecutor
{
    
    private final List<Runnable> tasks;
    
    public MultiExecutor(List<Runnable> tasks)
    {
        this.tasks = tasks;
    }

    public void executeAll()
    {
        List<Thread> threads = new ArrayList<>();
        
        // Create a thread for each task
        for (Runnable task : tasks)
        {
            Thread thread = new Thread(task);
            threads.add(thread);
        }
        
        // Start all threads
        for (Thread thread : threads)
        {
            thread.start();
        }
    }
    

    public static void main(String[] args)
    {

        List<Runnable> tasks = new ArrayList<>();
        
        // Task 1: Print numbers 1-5
        tasks.add(() ->
        {
            for (int i = 1; i <= 5; i++)
            {
                System.out.println("Task 1 - Number: " + i);
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        // Task 2: Print letters A-E
        tasks.add(() ->
        {
            for (char c = 'A'; c <= 'E'; c++)
            {
                System.out.println("Task 2 - Letter: " + c);
                try
                {
                    Thread.sleep(150);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        // Task 3: Print squares of numbers 1-5
        tasks.add(() ->
        {
            for (int i = 1; i <= 5; i++)
            {
                System.out.println("Task 3 - Square of " + i + " = " + (i * i));
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        MultiExecutor executor = new MultiExecutor(tasks);
        
        System.out.println("Starting parallel execution of all tasks...\n");
        
        executor.executeAll();
        
        System.out.println("\nAll tasks have been started concurrently!");
    }
}