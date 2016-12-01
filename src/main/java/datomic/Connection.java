package datomic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


// this is the connection that you have from your Java client API
public class Connection {

	private final Log log = LogFactory.getLog(getClass());
	private String uri;

	public Log getLog() {
		return log;
	}

	public String getUri() {
		return uri;
	}

	public Connection(String uri) {
		this.uri = uri;
		this.log.info("uri: " + this.uri);
	}
}
