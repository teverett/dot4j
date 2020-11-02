![CI](https://github.com/teverett/dot4j/workflows/CI/badge.svg)

# DOT4J

A Java library for reading and writing [GraphViz](https://en.wikipedia.org/wiki/Graphviz) [DOT](https://en.wikipedia.org/wiki/DOT_(graph_description_language)) files.

The DOT grammar is from [here](https://github.com/teverett/grammars-v4/tree/master/dot)

A formal description of DOT is available at [graphviz.org](https://graphviz.org/doc/info/lang.html)

# License

kGraphML is licensed under the 3-Clause BSD license.

# Maven Coordinates

```
<groupId>com.khubla.dot4j</groupId>
<artifactId>dot4j</artifactId>
<version>1.1.0</version>
<packaging>jar</packaging>
```

# Usage

Reading and writing of DOT files is done via [DOTMarshaller](https://github.com/teverett/dot4j/blob/master/src/main/java/com/khubla/dot4j/DOTMarshaller.java)

## Reading DOT

`Graph g = DOTMarshaller.importGraph(inputStream);`

## Writing DOT

```
Graph g = new Graph(false, GraphType.digraph, "mygraph");
Node n1 = new Node("n1");
g.addNode(n1);
Node n2 = new Node("node2");
g.addNode(n2);
Edge theEdge = new Edge("n1", "node2");
g.addEdge(theEdge);
DOTMarshaller.exportGraph(g, baos);
```

Creates:
```
digraph mygraph {
   node2;
   n1;
   n1 -> node2;
}

```