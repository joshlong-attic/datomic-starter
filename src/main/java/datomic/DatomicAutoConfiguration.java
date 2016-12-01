package datomic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ConnectionsProperties.class)
public class DatomicAutoConfiguration {

	@Autowired(required = false)
	private Connection[] connections;

	@Bean
	public Connections connections(ConnectionsProperties properties) {
		Connections connections = new Connections(this.connections);
		properties.getConnections()
				.values()
				.stream()
				.map(this::from)
				.forEach(connections::addConnection);
		return connections;
	}

	private Connection from(ConnectionsProperties.ConnectionProperties p) {
		// do all the conditional logic to
		// build a Connection based on uri
		// or port or databaseName etc
		return new Connection(p.deriveUri());
	}
}
