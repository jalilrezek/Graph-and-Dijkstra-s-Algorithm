**Overview**

The Graph data structure allows us to represent networks with "vertices" or nodes and "edges" connecting them. The Graph implemented here is a directed graph (edges go from one vertex
to another, rather than being directionless). Vertices and edges can both carry labels, which are internally represented as Java Objects.

Dijkstra's Algorithm lets us find the shortest path from one node to another by exhaustively exploring the network starting from the beginning node until, by the logic of the algorithm, 
the shortest path to the destination node is ascertained.

I use a test-first design approach with many design tests for the Graph data structure.

I test Dijkstra's Algorithm on multiple different paths and compare the results on metrics of time expended and memory used up by the algorithm's execution.

**Files**

Graph implementation: main/java/hw8/graph/SparseGraph.java

Graph unit tests: test/java/hw8/GraphTest.java

Dijkstra's Algorithm implementation: main/java/hw8/spp/DijkstraStreetSearcher.java

Testing of Dijkstra's Algorithm and discussion of results: main/java/hw8/README.md
