package com.sort.app.service;


import java.util.HashMap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
/**
 * Service methos to find the result sorted array
 * along with the position chage for each element
 * @author Rekhatha
 *
 */
@Service
@ComponentScan({"com.sort"})
public class SortService {

	public HashMap<String, Object> ascendingSort(int[] randomArray) {
		HashMap<String, Object> sortResult = new HashMap<>();
		HashMap<Integer, Integer> positionMap = new HashMap<Integer, Integer>();

		int swap;
		  for(int i=0;i<randomArray.length-1;i++){
			  Integer count = positionMap.get(randomArray[i]);
				positionMap.put(randomArray[i], (count == null) ? 1 : count + 1);
		   for(int j=0;j<randomArray.length-1-i;j++){
		    if(randomArray[j]>randomArray[j+1]){
		     swap=randomArray[j];
		     randomArray[j]=randomArray[j+1];
		     randomArray[j+1]=swap;
		    }
		   } 
		  }
		  sortResult.put("sortedArray", randomArray);
		  sortResult.put("positionMap", positionMap);
		  return sortResult;
	}
		

}
