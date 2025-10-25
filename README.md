# assignment3MST

In this project I implement the Prim's and Kruskal's algorithm to find MST for a city transport system
The goal of the algorithms is to get through the entire city in a minimum number of steps

I implement this algorithms in this way:
Prim:
Builds the MST by growing from a starting vertex and repeatedly adding the smallest edge
Kruskal:
Sorts all edges and adds them to the MST in increasing order of weight, avoiding cycles
Both algorithms are implemented in Java and compared based on:
Total cost of MST;
Execution of time;
Number of operations performed

assignment3MST/

pom.xml                     
data/
  input.json             
  output.json             
src/
   main
     java/
       Main.java       
       Graph.java      
       Prim.java       
       Kruskal.java    
       Edge.java       
README.md 

Input and output formats was given in Task requirements

To run project I:
Wrote it in Intellij IDEA
Synced Maven for gson library
And write a code

Result of project: 
Prim: Cost: 17, Operations 10, Execution time: 0.56 ms
Kruskal: Cost: 17, Operations 9, Execution time: 0.43ms
From this information I compare these 2 algorithms and have this conclusion: Both algorithms have the same BST (according to the concept, this is how it should be), but Kruskal algorithm is slightly faster on sparse graphs

Kyzylov Tamirlan
SE-2433
Teacher: Aidana Aidynkyzy
