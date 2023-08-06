package co.com.sofka.certification.challenge.exceptions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceConsumptionException extends Throwable {
  private static final Logger LOGGER = LogManager.getLogger(ServiceConsumptionException.class.getName());
    public ServiceConsumptionException(String message, Exception e){
        super(message,e);
          LOGGER.error(message + ": "+ e);
    }
}
