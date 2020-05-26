package com.laptop.laptopbag.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.laptopbag.exception.ErrorMessage;
import com.laptop.laptopbag.exception.InvalIdException;
import com.laptop.laptopbag.exception.LaptopDetailNotFoundException;
import com.laptop.laptopbag.interfaces.Ioperation;
import com.laptop.laptopbag.interfaces.LaptopOperation;
import com.laptop.laptopbag.model.LaptopDetails;

import io.swagger.annotations.Api;

@Api(value = "Laptop Bag Delay", description = "End Point for Laptop Bag Application with delay (15sec)")
@RestController
@RequestMapping(path = { "/laptop-bag/webapi/delay" })
public class LaptopDetailDelayController {
	private Ioperation operation = new LaptopOperation();
	
	private void generateDelay(int sec){
		try{
			Thread.sleep((sec * 1000));
		}catch (Exception e) {
			// Ignore
		}
	}

	@RequestMapping(path = { "/all" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<LaptopDetails>> getIt() {
		generateDelay(15);
		List<LaptopDetails> data = operation.getAllLaptops();
		if (!data.isEmpty()) {
			return new ResponseEntity<List<LaptopDetails>>(data, HttpStatus.OK);
		}
		return new ResponseEntity<List<LaptopDetails>>(data, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(path = { "/find/{id}" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getUsingId(@PathVariable("id") int id) {
		generateDelay(15);
		LaptopDetails data = operation.searchLaptop(id);
		if (data != null) {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
		throw new LaptopDetailNotFoundException(String.format("Laptop Detail with id %s Not found", id));
	}

	@RequestMapping(path = { "/add" }, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> postIt(@RequestBody LaptopDetails detail) {
		generateDelay(15);
		LaptopDetails data = operation.addLaptopDetail(detail);
		if (data.getId() < Integer.MIN_VALUE || data.getId() > Integer.MAX_VALUE) {
			throw new InvalIdException(String.format("Invalid id %s ", detail.getId()));
		}
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	}

	@RequestMapping(path = { "/delete/{id}" }, method = RequestMethod.DELETE, produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> deleteIt(@PathVariable("id") int id) {
		generateDelay(15);
		int data = operation.deleteLaptopBag(id);
		if (data != -1) {
			return new ResponseEntity<String>((new Integer(data)).toString(), HttpStatus.OK);
		}
		throw new LaptopDetailNotFoundException(String.format("Laptop Detail with %s Not found", id));
	}

	@RequestMapping(path = { "/update" }, method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> putIt(LaptopDetails detail) {
		generateDelay(15);
		LaptopDetails data = operation.updateLaptopDetail(detail);
		if (data != null) {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
		throw new LaptopDetailNotFoundException(String.format("Laptop Detail with %s Not found", detail.getId()));
	}

	@RequestMapping(path = { "/ping/{message}" }, method = RequestMethod.GET, produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Object> pingAlive(@PathVariable("message") String text) {
		generateDelay(15);
		return new ResponseEntity<Object>(String.format("%1s %2s", "Hi!", text), HttpStatus.OK);
	}

	@RequestMapping(path = { "/query" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> queryParam(@RequestParam(value = "id") int id,
			@RequestParam(value = "laptopName") String name) {
		generateDelay(15);
		LaptopDetails data;
		try {
			data = operation.searchLaptop(id, name);
			if (data == null) {
				return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception exp) {
			ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exp.getMessage());
			return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
