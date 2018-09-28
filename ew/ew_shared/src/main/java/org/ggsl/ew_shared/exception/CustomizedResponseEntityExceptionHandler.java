package org.ggsl.ew_shared.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.yaml.snakeyaml.Yaml;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @SuppressWarnings("unchecked")
	@ExceptionHandler(GenericCustomException.class)
  public final ResponseEntity<ErrorDetails> handleCustomException(GenericCustomException ex, WebRequest request) throws FileNotFoundException,IOException {
	        //read http status code and message code from yml file
	   		String messageDetails=null;
	   		HttpStatus httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;//default value used if message code does not match with yaml file
	   		Integer status=0;
	   		Yaml yaml = new Yaml();
	        InputStream ios = new FileInputStream(new File("D:/test/http_status_and_messages.yml"));
	        //HttpStatusAndMessagesModel httpStatusAndMessagesModelObj= yaml.loadAs(ios, HttpStatusAndMessagesModel.class);
	        ArrayList<Map<String,Object>> statusMapList=(ArrayList<Map<String,Object>>) yaml.load(ios);
	        for(Map<String,Object> map:statusMapList) {
	        	if(map.get("message-code-id").toString().equals(ex.getMessage())){
	        	    httpStatusCode=HttpStatus.valueOf(Integer.valueOf((Integer)map.get("http-status")));
	        	    messageDetails=(String)map.get("message-details");
	        	    break;
	        		
	        	}
	        }
	        	
	      //return the response entity corresponding to message code id provided in exception
         ErrorDetails errorDetails = new ErrorDetails(new Date(), messageDetails,request.getDescription(false),status);
         return new ResponseEntity<ErrorDetails>(errorDetails, httpStatusCode);
    }

}