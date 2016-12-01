package datomic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


@ConfigurationProperties(prefix = "datomic")
public class ConnectionsProperties {

	public static class ConnectionProperties {

		public String deriveUri() {
			return StringUtils.hasText(this.uri) ? uri : "datomic:" + databaseName + ":" + port;
		}

		private String uri;
		private int port;
		private String databaseName;

		@Override
		public String toString() {
			return "ConnectionProperties{" +
					"uri='" + uri + '\'' +
					", port=" + port +
					", databaseName='" + databaseName + '\'' +
					'}';
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public String getDatabaseName() {
			return databaseName;
		}

		public void setDatabaseName(String databaseName) {
			this.databaseName = databaseName;
		}
	}

	private Map<String, ConnectionProperties> connections = new HashMap<>();

	public Map<String, ConnectionProperties> getConnections() {
		return connections;
	}

	public void setConnections(Map<String, ConnectionProperties> connections) {
		this.connections = connections;
	}
}
