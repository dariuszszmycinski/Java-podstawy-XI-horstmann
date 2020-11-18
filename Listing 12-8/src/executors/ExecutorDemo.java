package executors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//program demonstrujący interfejs Callable i egzekutory
public class ExecutorDemo {

    //liczy wystąpienia danego słowa w pliku
    public static long occurrences(String word, Path path){
        try (var in = new Scanner(path)){
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count++;
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //zwraca wszystkie podkatalogi danego katalogu
    public static Set<Path> descendants(Path rootDir) throws IOException{
        try (Stream<Path> entries = Files.walk(rootDir)){
            return entries.filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        }
    }

    //tworzy zadanie szukając słowa w pliku
    public static Callable<Path> searchForTask(String word, Path path){
        return () -> {
            try (var in = new Scanner(path)){
                while (in.hasNext()){
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Szukanie w "+path+" anulowano.");
                        return null;
                    }
                } throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        try (var in = new Scanner(System.in)){
            System.out.print("Wpisz ścieżkę do katalogu podstawowego (np. /opt/jdk-9-src): ");
            String start = in.nextLine();
            System.out.print("Wpisz słowo kluczowe (np. volatile): ");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));
            var tasks = new ArrayList<Callable<Long>>();
            for (Path file: files){
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }
            ExecutorService executor = Executors.newCachedThreadPool();
            //użyj egzekutora wątku, aby sprawdzić, czy większa liczba wątków przyspiesza wyszukiwanie

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for (Future<Long> result : results)
                total += result.get();
            Instant endTime = Instant.now();
            System.out.println("Liczba wystąpień słowa "+word+": "+total);
            System.out.println("Czas: "+ Duration.between(startTime, endTime).toMillis()+ " ms");

            var searchTask = new ArrayList<Callable<Path>>();
            for (Path file:files)
                searchTask.add(searchForTask(word,file));
            Path found = executor.invokeAny(searchTask);
            System.out.println(word+ " występuje w: "+found);

            if (executor instanceof  ThreadPoolExecutor) //egzekutor jednowątkowy nie jest
                System.out.println("Największy rozmiar puli: "+ ((ThreadPoolExecutor) executor).getLargestPoolSize());
                executor.shutdown();
        }
    }
}
