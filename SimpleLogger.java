package fi.luotocompany.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple and secure logger by Kimmo Wikman, Luoto Company
 * Get most recent version of this file from: https://github.com/kimmowikman/simple-logger/
 */
public class SimpleLogger {

  public enum LogLevel { DEBUG, INFO, WARN, ERROR }

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

  private final LogLevel level;
  private final String sourceName;

  public SimpleLogger(final LogLevel level, final Class source) {
    this.level = level;
    this.sourceName = source.getName();
  }

  public void log(final LogLevel logLevel, final String message) {
    if (this.level.ordinal() <= logLevel.ordinal()) {
      final StringBuilder sb = new StringBuilder();
      sb.append(LocalDateTime.now().format(DATE_FORMAT))
          .append(" [")
          .append(logLevel.toString())
          .append("] ")
          .append(sourceName)
          .append(" - ")
          .append(message);
      System.out.println(sb.toString());
    }
  }
}
