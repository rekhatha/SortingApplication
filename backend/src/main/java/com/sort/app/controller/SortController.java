package com.sort.app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sort.app.service.SortService;

@RestController
@CrossOrigin("http://localhost:3000")
@ComponentScan({"com.sort"})
public class SortController {

	private SortService sortService;

    @Autowired
    public SortController(SortService sortService) {

        this.sortService = sortService;
    }
    /**
     * Controller method to find the sorted array and time
     * @param numbers
     * @return
     */
	 @RequestMapping(value="/sortToAscending",method = RequestMethod.GET)
	    public HashMap<String, Object> sortToAscending(@RequestParam (value = "numbers") final String[] numbers) {
		 int[] numbArray = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
		 HashMap<String, Object> resultMap = new HashMap<>();
		 HashMap<String, Object> outputMap = new HashMap<>();;
		 if(numbers.length != 0){
			    long start = System.nanoTime();
			    outputMap = sortService.ascendingSort(numbArray);
			  	long end = System.nanoTime();
				long time = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			    
			       resultMap.put("resultArray", outputMap);
			       resultMap.put("timeConsumned", time);
			       resultMap.put("status",200);
			       
		 }else{
			 resultMap.put("status",400);
		 }
		return resultMap;
	    }
	
}
