package hw8;

import hw8.graph.Graph;
import hw8.graph.SparseGraph;
import hw8.spp.DijkstraStreetSearcher;
import hw8.spp.StreetSearcher;
import java.io.File;

public final class Config {
  public String from;
  public String to;
  public File data;

  private Config(String data, String from, String to) {
    this.from = from;
    this.to = to;
    this.data = new File(Config.class.getResource("/" + data).getFile());
  }

  public static Config getConfig() {
    /* Sample valid endpoints */
    //return new Config("broken.txt", "1", "4");
    //return new Config("baseball.txt", "Home", "Third");
    // Inner Harbor to JHU:
    //return new Config("baltimore.streets.txt", "-76.6107,39.2866", "-76.6175,39.3296");
    // JHU to Druid Lake:
    return new Config("baltimore.streets.txt", "-76.6175,39.3296", "-76.6383,39.3206");
    //return new Config("campus.paths.txt", "-76.620883,39.326204", "-76.620647,39.331158");
  }

  /**
   * Change this to experiment with different implementations of Graph ADT.
   *
   * @param <V> Vertex element type.
   * @param <E> Edge element type.
   * @return an implementation of the Graph ADT.
   */
  public static <V, E> Graph<V, E> getGraph() {
    return new SparseGraph<>();
  }

  /**
   * Change this to experiment with different implementations of StreetSearcher.
   *
   * @param graph an implementation of the Graph ADT.
   * @return an implementation of StreetSearcher.
   */
  public static StreetSearcher getStreetSearcher(Graph<String, String> graph) {
    return new DijkstraStreetSearcher(graph);
  }

  @Override
  public String toString() {
    return String.format("Config: %s from %s to %s", data.getName(), from, to);
  }
}
