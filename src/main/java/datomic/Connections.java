package datomic;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

// you need some sort of root object for
// this to work in a Spring world, though
// the situation improves in the coming Spring 5


public class Connections {

	private final Set<Connection> connections =
			new ConcurrentSkipListSet<>((o1, o2) -> o1.getUri().compareTo(o2.getUri()));

	public Connections(Connection[] connections) {
		if (null != connections) {
			for (Connection c : connections) {
				this.addConnection(c);
			}
		}
	}

	public void addConnection(Connection connection) {
		Objects.requireNonNull(connection);
		this.connections.add(connection);
	}
}
