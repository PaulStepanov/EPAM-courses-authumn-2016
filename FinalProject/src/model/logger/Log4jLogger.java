package model.logger;

import org.apache.log4j.Logger;

/**
 * Simple singleton logger implementation
 */
public class Log4jLogger {
    private static final Log4jLogger log4jLogger = new Log4jLogger();
    private final Logger logger = Logger.getLogger(this.getClass());

    public static void log(String message) {
        log4jLogger.logger.info(message);
    }
}
