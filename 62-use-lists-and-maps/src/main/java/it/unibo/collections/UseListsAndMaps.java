package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> list= new ArrayList<>();
        for(int i =1000; i<2000; i++){
            list.add(i);
        }
        
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> linkedList= new LinkedList<>(list);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int firstElement= list.get(0);
        final int lastElement= list.get(list.size()-1);
        list.set(0,lastElement);
        list.set(list.size()-1,firstElement);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final Integer elem: list){
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int elemsToAdd=100_000;

        long startTimeAL= System.nanoTime();
        for (int i = 0; i < elemsToAdd; i++) {
            list.add(i);
        }
        startTimeAL= System.nanoTime() - startTimeAL;
        final var milliAL = TimeUnit.NANOSECONDS.toMillis(startTimeAL);
        System.out.println("Time for ArrayList list: "+startTimeAL+ " ns ("+milliAL+").");

        long startTimeLL = System.nanoTime();
        for (int i = 0; i < elemsToAdd; i++) {
            linkedList.add(0, i); 
        }
        startTimeLL = System.nanoTime() - startTimeLL;
        final var milliLL = TimeUnit.NANOSECONDS.toMillis(startTimeLL);
        System.out.println("Time for ArrayList list: "+startTimeLL+ " ns ("+milliLL+").");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         final int elemsToRead=1_000;

        long readTimeAL= System.nanoTime();
        for (int i = 0; i < elemsToRead; i++) {
            list.add(i);
        }
        readTimeAL= System.nanoTime() - readTimeAL;
        final var milliRAL = TimeUnit.NANOSECONDS.toMillis(readTimeAL);
        System.out.println("Time to read ArrayList list: "+readTimeAL+ " ns ("+milliRAL+").");

        long readTimeLL = System.nanoTime();
        for (int i = 0; i < elemsToRead; i++) {
            linkedList.add(0, i); 
        }
        readTimeLL = System.nanoTime() - readTimeLL;
        final var milliRLL = TimeUnit.NANOSECONDS.toMillis(readTimeLL);
        System.out.println("Time to read ArrayList list: "+readTimeLL+ " ns ("+milliRLL+").");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> worldPopulation =new HashMap<>();
        worldPopulation.put("Africa", 1_110_635_000L);
        worldPopulation.put("Americas", 972_005_000L);
        worldPopulation.put("Antarctica", 0L);
        worldPopulation.put("Asia", 4_298_723_000L);
        worldPopulation.put("Europe", 742_452_000L);
        worldPopulation.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long totalPopulation=0;
        for(final long population:worldPopulation.values() ){
            totalPopulation += population;
        }
        System.out.println("Total world population: " + totalPopulation);

        
    }
}
