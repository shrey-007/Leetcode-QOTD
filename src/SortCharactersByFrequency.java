import java.util.*;

/*
* Question=
* Given a string s, sort it in decreasing order based on the frequency of the characters.
* The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
* */
class Pair implements Comparable<Pair>{
    //character
    char c;
    //frequency
    int f;
    Pair(char c,int f){
        this.c=c;
        this.f=f;
    }
    public int compareTo(Pair p){return this.f-p.f;}
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", f=" + f +
                '}';
    }
}
public class SortCharactersByFrequency {
    /*
    * method1
    * Iterate through the input string 's' and count the frequency of each character using an Hashmap 'hm'.
      Use a priority queue 'pq' to store pairs of characters and their frequencies, sorted in decreasing order of frequency.
      Define a Comparator (of a class pair) to compare pairs based on the second element (frequency).
      Iterate through the hashmap entries and push each pair into the priority queue.
      Pop elements from the priority queue and append characters to the result string according to their frequency.*/

    public String frequencySort(String s) {
        //create a hashmap to store frequency
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(hm.containsKey(curr)){hm.put(curr,hm.get(curr)+1);}
            else{hm.put(curr,1);}
        }
        System.out.println(hm);

        //put the hashmap in heap
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            Pair p=new Pair(entry.getKey(),entry.getValue());
            pq.add(p);
        }
        System.out.println(pq);

        String ans="";
        while(pq.size()>0){
            Pair p=pq.poll();
            while (p.f>0){
                ans=ans+p.c;
                p.f--;
            }
        }

        return ans;
    }


    /*
    method2=
    Frequency Counting: Iterate through the input string s and count the frequency of each character using an hashmap mp.

Mapping Frequency to Characters: Use a treemap r to associate each character with its frequency. The treemap allows multiple elements with the same key (frequency) and automatically sorts them in ascending order based on the key(frequency).

Sorting by Frequency: Iterate through the entries in the frequency map mp and insert them into the treemap r with the frequency as the key and the character as the value. This ensures that characters with the same frequency are grouped together and sorted based on their frequency.

Building the Result String: Traverse the treemap r in reverse order (using reverse iterators) to access elements with higher frequencies first. Concatenate characters to the string ss based on their frequency, ensuring characters with higher frequencies appear first.(or you can do Comparator.reverseOrder() while creating treemap)

Returning the Result: Return the final string ss, which contains characters sorted by frequency in descending order.

    * */



        public String frequencySort2(String s) {
            Map<Character, Integer> mp = new HashMap<>();
            TreeMap<Integer, List<Character>> r = new TreeMap<>(Collections.reverseOrder());
            StringBuilder ss = new StringBuilder();

            for (char a : s.toCharArray())
                mp.put(a, mp.getOrDefault(a, 0) + 1);

            for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
                if (!r.containsKey(entry.getValue())) {
                    r.put(entry.getValue(), new ArrayList<>());
                }
                r.get(entry.getValue()).add(entry.getKey());
            }

            for (Map.Entry<Integer, List<Character>> entry : r.entrySet()) {
                int freq = entry.getKey();
                List<Character> chars = entry.getValue();
                for (char c : chars) {
                    for (int i = 0; i < freq; i++) {
                        ss.append(c);
                    }
                }
            }

            return ss.toString();
        }




}
