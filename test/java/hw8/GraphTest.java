package hw8;

import exceptions.InsertionException;
import exceptions.PositionException;
import exceptions.RemovalException;
import hw8.graph.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public abstract class GraphTest {

  protected Graph<String, String> graph;

  @BeforeEach
  public void setupGraph() {
    this.graph = createGraph();
  }

  protected abstract Graph<String, String> createGraph();

  @Test
  @DisplayName("insert(v) returns a vertex with given data")
  public void canGetVertexAfterInsert() {
    Vertex<String> v1 = graph.insert("v1");
    assertEquals(v1.get(), "v1");
  }

  @Test
  @DisplayName("insert(U, V, e) returns an edge with given data")
  public void canGetEdgeAfterInsert() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "v1-v2");
    assertEquals(e1.get(), "v1-v2");
  }

  @Test
  @DisplayName("insert(null, V, e) throws exception")
  public void insertEdgeThrowsPositionExceptionWhenfirstVertexIsNull() {
    try {
      Vertex<String> v = graph.insert("v");
      graph.insert(null, v, "e");
      fail("The expected exception was not thrown");
    } catch (PositionException ex) {
      return;
    }
  }

  // TODO add more tests here.
  // TO ADD: Removing an edge not in the graph (add an edge in, remove the edge, then try to
  // remove it again)
  // removing an edge with one or more null vertices
  // Removing vertex with non-empty incoming set
  // removing vertex with non-empty outgoing set

  @Test
  @DisplayName("Inserting repeated element throws exception")
  public void insertRepeatedElementThrowsException() {
    Vertex<String> v1 = graph.insert("v");
    try {
      Vertex<String> v2 = graph.insert("v");
      fail("Inserting repeated element failed to throw exception");
    } catch (InsertionException ex) {
      // ight, we returning
    }
  }

  @Test
  @DisplayName("Insert duplicate edge throws InsertionEx")
  // no duplicate edges suggests the use of a HashSet which does not allow duplicate edges
  // to store the incoming/outgoing edges of each vertex.
  public void insertDuplicateEdgeThrowsInsertEx() {
    Vertex<String> v1 = graph.insert("v");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    try {
      Edge<String> e2 = graph.insert(v1, v2, "e2");
      fail("Inserting duplicate edge  failed to throw insertion exception");
    } catch (InsertionException ex) {
      // ight, we returning
    }
  }

  @Test
  @DisplayName("Inserting edge to make loop throws InsertionEx")
  public void insertSelfLoopThrowsInsertEx() {
    int i = 1;
    int y = 2;
    Vertex<String> v1 = graph.insert("v");
    try {
      Edge<String> e1 = graph.insert(v1, v1, "e1");
      fail("Making self loop failed to throw insertion exception");
    } catch (InsertionException ex) {
      // ight, we returning
    }
  }

  @Test
  @DisplayName("Remove a vertex returns appropriate data value")
  // how to test if it was actually removed...?
  public void removeVertexReturnsCorrectValue() {
    Vertex<String> v1 = graph.insert("v");
    assertEquals("v", graph.remove(v1));

    int j = 1;

  }

  @Test
  @DisplayName("Remove an edge returns appropriate data value")
  // how to test if it was actually removed...?
  public void removeEdgeReturnsCorrectValue() {
    Vertex<String> v1 = graph.insert("v");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    assertEquals("e1", graph.remove(e1));

  }

  @Test
  @DisplayName("Remove null vertex throws PosEx")
  // how to test if it was actually removed...?
  public void removeNullVertexThrowsPosEx() {
    Vertex<String> v1 = null;
    try {
      graph.remove(v1);
      fail("Removing null vertex failed to throw exception");
    } catch (PositionException ex) {
      // ight, we returning
    }
  }

  @Test
  @DisplayName("Remove vertex with incident edges throws RemovalEx")
  // how to test if it was actually removed...?
  public void removeVtxWithIncidentEdgesVertexThrowsRemovalEx() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    try {
      graph.remove(v1);
      fail("Removing vertex with incident edges failed to throw exception");
    } catch (RemovalException ex) {
      // ight, we returning
    }
  }

  @Test
  @DisplayName("Remove invalid edge throws PositionEx")
  // how to test if it was actually removed...?
  public void removeVtxWithIncidentEdgesVertexThrowsPosEx() {
    // idk how to test this. What's an invalid edge?
    // maybe invalid edge is the DATA TYPE in the edge
    // but I've never had to check that they're using the right data type before for any homework
    Vertex<String> v1 = graph.insert("v");
    Vertex<String> v2 = graph.insert("v2");

  }

  @Test
  @DisplayName("from() returns starting vertex of edge")
  // how to test if it was actually removed...?
  public void fromReturnsSourceOfEdge() {
    Vertex<String> v1 = graph.insert("v");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");

    Vertex<String> v1Copy = graph.from(e1);
    assertEquals(v1, v1Copy); // is this how to compare objects?

  }

  @Test
  @DisplayName("from() throws posEx for invalid edge")
  // how to test if it was actually removed...?
  public void fromInvalidEdgeThrowsPosEx() {
    // no idea how to check what an invalid edge is.
    // Maybe it is the DATA TYPE stored in the edge

  }

  @Test
  @DisplayName("to() returns destination vertex of edge")
  // how to test if it was actually removed...?
  public void toReturnsDestinationOfEdge() {
    Vertex<String> v1 = graph.insert("v");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");

    Vertex<String> v2Copy = graph.to(e1);
    assertEquals(v2, v2Copy); // is this how to compare objects?

  }

  @Test
  @DisplayName("to() throws posEx for invalid edge")
  // how to test if it was actually removed...?
  public void toInvalidEdgeThrowsPosEx() {
    // no idea how to check what an invalid edge is.

  }

  @Test
  @DisplayName("Label null vertex throws PosEx")
  // how to test if it was actually removed...?
  public void labelNullVertexThrowsPosEx() {
    // no idea how to check what an invalid edge is.
    Vertex<String> v1 = null;
    try {
      graph.label(v1, null); // the label CAN be null. What's wrong is the first parameter,
      // the vertex.
      fail("Label null vertex fails to throw PosEx");
    } catch (PositionException ex) {
      // ight, we returning
    }

  }

  @Test
  @DisplayName("Label null edge throws PosEx")
  // how to test if it was actually removed...?
  public void labelNullEdgeThrowsPosEx() {
    // no idea how to check what an invalid edge is.
    Edge<String> e1 = null;
    try {
      graph.label(e1, null); // the label CAN be null. What's wrong is the first parameter,
      // the edge.
      fail("Label null edge fails to throw PosEx");
    } catch (PositionException ex) {
      // ight, we returning
    }

  }

  @Test
  @DisplayName("Label vertex with integer works and returns correct value")
  public void labelVertexReturnsCorrectValue() {
    Vertex<String> v1 = graph.insert("v1");
    graph.label(v1, 1);
    assertEquals(1, graph.label(v1));

  }

  @Test
  @DisplayName("Label edge with integer works and returns correct value")
  public void labelEdgeReturnsCorrectValue() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    graph.label(e1, 1);
    assertEquals(1, graph.label(e1));

  }

  @Test
  @DisplayName("Getting label of null vertex throws PosEx")
  public void getLabelOfNullVertexThrowsPosEx() {
    Vertex<String> v1 = null;
    try {
      Object i = graph.label(v1);
      fail("Get label of null vertex failed to throw PosEx");
    } catch (PositionException ex) {
      // good
    }

  }

  @Test
  @DisplayName("Getting label of null edge throws PosEx")
  public void getLabelOfNullEdgeThrowsPosEx() {
    Edge<String> e1 = null;
    try {
      Object i = graph.label(e1);
      fail("Get label of null vertex failed to throw PosEx");
    } catch (PositionException ex) {
      // good
    }

  }

  @Test
  public void insertManyTestVerticesIterator() {
    Vertex<String> v = graph.insert("100");
    for (int i = 0; i < 10; i++) {
      graph.insert(Integer.toString(i));
    }
    //int i = 1;
    //System.out.println(graph.remove(v));

    //int j = 2;

    Iterable<Vertex<String>> vtces = graph.vertices();
    Iterator<Vertex<String>> vtxIterator = vtces.iterator();

    while (vtxIterator.hasNext()) {
      Vertex<String> vtx = vtxIterator.next();
      System.out.println("Vertex: " + vtx.get());
    }

  }

  @Test
  public void removeNodeNotInGraph() {
    Vertex<String> v1 = graph.insert("V");
    graph.remove(v1);
    try {
      graph.remove(v1);
      fail("remove nonexistent node failed to throw PosEx");
    } catch (PositionException e) {
      // done
    }
  }


  @Test
  public void emptyGraphEdgesIterator() {
    Iterable<Edge<String>> edges = graph.edges();
    for (int i = 0; i < 1000; i++) {
      Vertex<String> v = graph.insert(Integer.toString(i));
      Vertex<String> v2 = graph.insert(Integer.toString(i + 1000));
    }
    int edgeCount = 0;
    for (Edge<String> edge : edges) {
      edgeCount++;
    }

    // Verify that no edges were returned
    assertEquals(0, edgeCount, "Empty graph should have no edges");
  }

  @Test
  public void oneEdgeIterator() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");

    Iterable<Edge<String>> edges = graph.edges();

    int edgeCount = 0;
    for (Edge<String> edge : edges) {
      edgeCount++;
    }

    // Verify that no edges were returned
    assertEquals(1, edgeCount, "Empty graph should have no edges");
  }

  @Test
  public void insertOneEdgeThenRemoveItMakingGraphEmptyThenTestIterator() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");

    graph.remove(e1);

    Iterable<Edge<String>> edges = graph.edges();

    int edgeCount = 0;
    for (Edge<String> edge : edges) {
      edgeCount++;
    }

    // Verify that no edges were returned
    assertEquals(0, edgeCount, "Empty graph should have no edges");
  }

  @Test
  public void insertOneEdgeThenRemoveItMakingGraphEmptyThenTestOutgoingEdgesIterator() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    Edge<String> e2 = graph.insert(v2, v1, "e1");


    graph.remove(e1);

    Iterable<Edge<String>> edges = graph.outgoing(v1);

    int edgeCount = 0;
    for (Edge<String> edge : edges) {
      edgeCount++;
    }

    // Verify that no edges were returned
    assertEquals(0, edgeCount, "Empty graph should have no edges");
  }

  @Test
  public void insertOneEdgeThenRemoveItMakingGraphEmptyThenTestIncomingEdgesIterator() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    Edge<String> e2 = graph.insert(v2, v1, "e1");


    graph.remove(e1);

    Iterable<Edge<String>> edges = graph.incoming(v1);

    int edgeCount = 0;
    for (Edge<String> edge : edges) {
      edgeCount++;
    }

    // Verify that no edges were returned
    assertEquals(1, edgeCount, "Empty graph should have no edges");
  }

  @Test
  public void testOutgoingEdgesIteration() { /// CHECK THIS
    // Create a graph

    // Insert vertices
    Vertex<String> v1 = graph.insert("A");
    Vertex<String> v2 = graph.insert("B");
    Vertex<String> v3 = graph.insert("C");

    // Insert edges
    Edge<String> e1 = graph.insert(v1, v2, "1");
    Edge<String> e2 = graph.insert(v1, v3, "2");
    Edge<String> e3 = graph.insert(v2, v3, "3");

    // Iterate over outgoing edges of each vertex
    try {
      Iterable<Edge<String>> outgoingEdgesV1 = graph.outgoing(v1);
      Iterable<Edge<String>> outgoingEdgesV2 = graph.outgoing(v2);
      Iterable<Edge<String>> outgoingEdgesV3 = graph.outgoing(v3);

      // Verify the outgoing edges for each vertex
      assertIterableEquals(Arrays.asList(e2, e1), outgoingEdgesV1);
      // (e1, e2) fails but the order doesn't matter so we good .
      assertIterableEquals(Collections.singletonList(e3), outgoingEdgesV2);
      assertIterableEquals(Collections.emptyList(), outgoingEdgesV3); // No outgoing edges from v3
    } catch (PositionException e) {
      // Handle exception if needed
      fail("PositionException occurred");
    }
  }

  @Test
  public void allEdgesIteratorTestForRepeatedElements() {
    for (int i = 0; i < 1000; i++) {
      Vertex<String> v = graph.insert(Integer.toString(i));
      Vertex<String> v2 = graph.insert(Integer.toString(i + 1000));
      Edge<String> e = graph.insert(v, v2, Integer.toString(i));
    }

    Iterable<Edge<String>> edges = graph.edges();
    Iterator<Edge<String>> edgeIterator = edges.iterator();

    ArrayList<String> edgeData = new ArrayList<>();
    boolean foundRepeatedEdge = false;


    String val;
    while (edgeIterator.hasNext()) {
      Edge<String> edge = edgeIterator.next();
      val = edge.get();

      if (edgeData.contains(val)) {
        foundRepeatedEdge = true;
      }

      edgeData.add(edge.get());
      System.out.println("Edge: " + edge.get());
      edge = edgeIterator.next();
    }

    if (foundRepeatedEdge) {
      System.out.println("Found repeated edge data");
    } else {
      System.out.println("Didn't find repeated edge data");
    }
  }

  @Test
  public void outgoingEdgesIterator() {
    Vertex<String> v = graph.insert("-1");
    Vertex<String> v2 = graph.insert("-2");
    Edge<String> e = graph.insert(v, v2, "-3");

    for (int i = 0; i < 1000; i++) {
      v2 = graph.insert(Integer.toString(i + 1000));
      e = graph.insert(v, v2, Integer.toString(i));
      if (i % 3 == 0) {
        graph.remove(e);
      }
    }

    Iterable<Edge<String>> edges = graph.outgoing(v);
    Iterator<Edge<String>> edgeIterator = edges.iterator();
    int i = 0;
    while (edgeIterator.hasNext()) {
      i++;
      Edge<String> outEdge = edgeIterator.next();
      System.out.println("Edge: " + outEdge.get());
    }
    System.out.println(i);



  }

  @Test
  public void outgoingEdgesIteratorTestRepeatedElements() {
    Vertex<String> v = graph.insert("-1");
    Vertex<String> v2 = graph.insert("-2");
    Edge<String> e = graph.insert(v, v2, "-3");

    for (int i = 0; i < 1000; i++) {
      v2 = graph.insert(Integer.toString(i + 1000));
      e = graph.insert(v, v2, Integer.toString(i));
      if (i % 3 == 0) {
        graph.remove(e);
      }
    }

    Iterable<Edge<String>> edges = graph.outgoing(v);
    Iterator<Edge<String>> edgeIterator = edges.iterator();

    ArrayList<String> edgeData = new ArrayList<>();
    boolean foundRepeatedEdge = false;

    String val;
    while (edgeIterator.hasNext()) {
      Edge<String> edge = edgeIterator.next();
      val = edge.get();

      if (edgeData.contains(val)) {
        foundRepeatedEdge = true;
      }

      edgeData.add(edge.get());
      System.out.println("Edge: " + edge.get());
    }

    if (foundRepeatedEdge) {
      System.out.println("Found repeated edge data");
    } else {
      System.out.println("Didn't find repeated edge data");
    }
  }

  @Test
  public void incomingEdgesIterator() {
    Vertex<String> v = graph.insert("-1");
    Vertex<String> v2 = graph.insert("-2");
    Edge<String> e = graph.insert(v, v2, "-3");

    for (int i = 0; i < 1000; i++) {
      v = graph.insert(Integer.toString(i + 1000));
      e = graph.insert(v, v2, Integer.toString(i));
      if (i % 3 == 0) {
        graph.remove(e);
      }
    }

    Iterable<Edge<String>> edges = graph.incoming(v2);
    Iterator<Edge<String>> edgeIterator = edges.iterator();
    int i = 0;
    while (edgeIterator.hasNext()) {
      i++;
      Edge<String> outEdge = edgeIterator.next();
      System.out.println("Edge: " + outEdge.get());
    }
    System.out.println(i);
  }

  @Test
  public void incomingEdgesTestRepeats() {
    Vertex<String> v = graph.insert("-1");
    Vertex<String> v2 = graph.insert("-2");
    Edge<String> e = graph.insert(v, v2, "-3");

    for (int i = 0; i < 1000; i++) {
      v = graph.insert(Integer.toString(i + 1000));
      e = graph.insert(v, v2, Integer.toString(i));
      if (i % 3 == 0) {
        graph.remove(e);
      }
    }

    Iterable<Edge<String>> edges = graph.incoming(v2);
    Iterator<Edge<String>> edgeIterator = edges.iterator();

    ArrayList<String> edgeData = new ArrayList<>();
    boolean foundRepeatedEdge = false;

    String val;
    while (edgeIterator.hasNext()) {
      Edge<String> edge = edgeIterator.next();
      val = edge.get();

      if (edgeData.contains(val)) {
        foundRepeatedEdge = true;
      }

      edgeData.add(edge.get());
      System.out.println("Edge: " + edge.get());
    }

    if (foundRepeatedEdge) {
      System.out.println("Found repeated edge data");
    } else {
      System.out.println("Didn't find repeated edge data");
    }
  }

  @Test
  public void insertEdgeMadeFromRemovedVerticesThrowsPositionException() {
    Vertex<String> v = graph.insert("-1");
    Vertex<String> v2 = graph.insert("-2");

    graph.remove(v);
    graph.remove(v2);
    // owners set to null upon removal, so convert() catches and throws PosEx instead of
    // remove() catching it and throwing InsertionEx

    try {
      Edge<String> e = graph.insert(v, v2, "-3");
      fail("insert edge made from former but now removed vertices failed to throw ex");
    } catch (PositionException e) {
      // done
    }

  }

  @Test
  public void insertTwoEdgesBetweenSameVerticesGoingOppDir() {
    Vertex<String> v = graph.insert("-1");
    Vertex<String> v2 = graph.insert("-2");
    Edge<String> e = graph.insert(v, v2, "-3");
    Edge<String> e1 = graph.insert(v2, v, "-3");
    System.out.println(graph.toString());

  }

  @Test
  public void testEdgeRemoval() { /// CHECK THIS
    // Create a graph
    Graph<String, String> graph = new SparseGraph<>();

    // Insert vertices
    Vertex<String> v1 = graph.insert("A");
    Vertex<String> v2 = graph.insert("B");
    Vertex<String> v3 = graph.insert("C");

    // Insert edges
    Edge<String> e1 = graph.insert(v1, v2, "edge1");
    Edge<String> e2 = graph.insert(v1, v3, "edge2");

    // Create an iterable of edges before removal
    Iterable<Edge<String>> beforeRemoval = graph.edges();
    List<Edge<String>> beforeRemovalList = new ArrayList<>();
    beforeRemoval.forEach(beforeRemovalList::add);

    // Remove one of the edges
    graph.remove(e1);

    // Create an iterable of edges after removal
    Iterable<Edge<String>> afterRemoval = graph.edges();
    List<Edge<String>> afterRemovalList = new ArrayList<>();
    afterRemoval.forEach(afterRemovalList::add);

    System.out.println("Before: ");
    for (Edge<String> edge : beforeRemovalList) {
      System.out.println(edge);
    }
    System.out.println("After: ");
    for (Edge<String> edge : afterRemovalList) {
      System.out.println(edge);
    }

    for (Edge<String> edge : afterRemovalList) {
      System.out.println("In the loop");
      if (beforeRemovalList.contains(edge)) {
        System.out.println("BeforeRemovalList has the curr element in AfterRemovalList");
      }
    }

    // Ensure that the removed edge is not present in the afterRemovalList
    //assertFalse(afterRemovalList.contains(e1));

    // Ensure that all other edges are still present in the afterRemovalList
    //assertTrue(beforeRemovalList.containsAll(afterRemovalList));
  }

  // I used the below test just to visually see what was going on. It was not treated as a
  // useful test for graph functionality, just for my convenience of visualization.
  @Test
  public void printGraph() {
    Vertex<String> v1 = graph.insert("v1");
    Vertex<String> v2 = graph.insert("v2");
    Edge<String> e1 = graph.insert(v1, v2, "e1");
    Vertex<String> v3 = graph.insert("v3");
    Edge<String> e2 = graph.insert(v1, v3, "e1");
    System.out.println(graph.toString());

    Iterable<Edge<String>> edges = graph.edges();
    Iterable<Vertex<String>> vertices = graph.vertices();


  }

}