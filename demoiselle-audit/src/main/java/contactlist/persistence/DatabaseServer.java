package contactlist.persistence;

import javax.inject.Inject;

import org.hsqldb.Server;
import org.slf4j.Logger;

import br.gov.demoiselle.annotation.Destroy;
import br.gov.demoiselle.annotation.Load;

public class DatabaseServer {

	@Inject
	private Logger logger;

	private HsqldbServer server;

	public DatabaseServer() {
		this.server = new HsqldbServer(9001);
	}

	@Load(priority = 0)
	public void start() {
		this.server.start();
		this.logger.info("Databases was loaded");
	}

	@Destroy
	public void stop() {
		this.server.shutdown();
		this.logger.info("Databases was stopped");
	}
}

class HsqldbServer extends Thread {

	private Server server;

	HsqldbServer(final int port) {
		this.server = create(port);
		setDaemon(true);
	}

	private Server create(final int port) {
		Server server = new Server();
		server.setDatabaseName(0, "contactlist");
		server.setDatabasePath(0, "database/contactlist");
		server.setDatabaseName(1, "audit");
		server.setDatabasePath(1, "database/audit");
		server.setPort(port);
		server.setSilent(true);

		return server;
	}

	@Override
	public void run() {
		this.server.start();
	}

	public void shutdown() {
		this.server.stop();
	}
}
