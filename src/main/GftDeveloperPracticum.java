package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GftDeveloperPracticum {
	
	
    static String time = "";
    static boolean isValid = false;
    
    static String enter1 = "";
    static String enter2 = "";
    static String enter3 = "";
    static String enter4 = "";
    
    static int value1 = 5;
    static int value2 = 5;
    static int value3 = 5;
    static int value4 = 5;
    
    
    static String response = "";
    
    static int eggCount = 0;
    static int toastCount = 0;
    static int coffeCount = 0;
    static int errorCount = 0;
    static int steakCount = 0;
    static int potatoCount = 0;
    static int wineCount = 0;
    static int cakeCount = 0;
    
    static String s;

		
	public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              
        HashMap<String, String> hm = new HashMap<String, String>();
        
        hm.put("morning,1", "eggs");
        hm.put("morning,2", "Toast");
        hm.put("morning,3", "coffe");
        hm.put("morning,4", "error");
        
        
        hm.put("night,1", "steak");
        hm.put("night,2", "potato");
        hm.put("night,3", "wine");
        hm.put("night,4", "cake");
        

        
        try{
        
        System.out.print("Enter values:\n");   
        String s = br.readLine().trim().toLowerCase().replace(" ", "");
        
        if(s.contains("morning")) {

        	time = "morning";
        	
    	    if(s.length() > 7 && s.charAt(7) == ',') {
    	    	
    	    	value1 = Integer.parseInt(String.valueOf(s.charAt(8)));
    	    	enter1 = "morning,"+s.charAt(8);
    	    	
    	    	if(s.length() > 9 && s.charAt(9) == ',') {
    	    		
    	    		value2 = Integer.parseInt(String.valueOf(s.charAt(10)));
    	    		enter2 = "morning,"+s.charAt(10);           	    		
    	    		
    	    		if(s.length() > 11 && s.charAt(11) == ',') {
    	    			
    	    			value3 = Integer.parseInt(String.valueOf(s.charAt(12)));
        	    		enter3 = "morning,"+s.charAt(12);             	    		
        	    		
        	    		if(s.length() > 13 && s.charAt(13) == ',') {
        	    			value4 = Integer.parseInt(String.valueOf(s.charAt(14)));
            	    		enter4 = "morning,"+s.charAt(14);                   	    		
            	    		
            	    	}
        	    	}
    	    	}           	    	          	    	        	    	
    	    }
    	    


    	    reorderEnter4(value1,value2,value3,value4);
    	    reorderEnter3(value1,value2,value3);
    	    reorderEnter2(value1,value2);
    	    
    	    
    	                	    
        	
        	
        }else if(s.contains("night")) {
        	
        	time = "night";
        	
        	    if(s.length() > 5 && s.charAt(5) == ',') {
        	    	
        	    	value1 = Integer.parseInt(String.valueOf(s.charAt(6)));
        	    	enter1 = "night,"+s.charAt(6);
        	    	
        	    	if(s.length() > 7 && s.charAt(7) == ',') {
        	    		
        	    		value2 = Integer.parseInt(String.valueOf(s.charAt(8)));
        	    		enter2 = "night,"+s.charAt(8);
        	    		
        	    		if(s.length() > 9 && s.charAt(9) == ',') {
        	    			
        	    			value3 = Integer.parseInt(String.valueOf(s.charAt(10)));
            	    		enter3 = "night,"+s.charAt(10);
            	    		
            	    		if(s.length() > 11 && s.charAt(11) == ',') {
            	    			
            	    			value4 = Integer.parseInt(String.valueOf(s.charAt(12)));
                	    		enter4 = "night,"+s.charAt(12);
                	    		
                	    	}
            	    	}
        	    	}
        	    	
        	    }  	
        	    
        	    reorderEnter4(value1,value2,value3,value4);
        	    reorderEnter3(value1,value2,value3);
        	    reorderEnter2(value1,value2);
        	
        }else {
        	
        	response = "Incorrect input !";
        	
        }
                    
        
        
        
        if(!"".equals(enter1)) {
        	
        	response = response+hm.get(enter1);
        	
        }if(!"".equals(enter2)) {
        	
            if(enter1.replace(",", "").equals(enter2.replace(",", ""))) {
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1)+"(2x)"+",";  
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	       	  	
            }else {
            	if(isValid) {
            		response = response + "," + hm.get(enter2);
            	} else {
            		response = hm.get(enter1) + "," + hm.get(enter2);
            	}
            	
            }
        	
        }if(!"".equals(enter3)) {
        	
        	if(enter1.replace(",", "").equals(enter3.replace(",", "")) && enter2.replace(",", "").equals(enter3.replace(",", ""))) {
            	
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1) + "(3x)";
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter1.replace(",", "").equals(enter3.replace(",", ""))) {
            	    
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1)+"(2x)"+","+hm.get(enter2); 
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter2.replace(",", "").equals(enter3.replace(",", ""))){
            	                 	
            	if(checkMultipleOrders(time,enter2)) {
            		isValid = true;
            		response = hm.get(enter1) + "," + hm.get(enter2) +"(2x)";
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else {
            	if(isValid) {
            		response = response + "," + hm.get(enter3);
            	}else {
            		response = hm.get(enter1) + "," + hm.get(enter2)+ "," + hm.get(enter3);
            		System.out.println(response);
            		return;
            	}
            	
            }
        	
        }if(!"".equals(enter4)) {
        	
        	if(enter1.replace(",", "").equals(enter4.replace(",", "")) && enter2.replace(",", "").equals(enter4.replace(",", "")) && enter3.replace(",", "").equals(enter4.replace(",", ""))) {
        		
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1) + "(4x)";
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
        	}else if(enter1.replace(",", "").equals(enter4.replace(",", "")) && enter2.replace(",", "").equals(enter4.replace(",", ""))) {
            	
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1) + "(3x)" + "," + hm.get(enter3);
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter1.replace(",", "").equals(enter4.replace(",", "")) && enter3.replace(",", "").equals(enter4.replace(",", ""))) {
            	
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1) + "(3x)" + "," + hm.get(enter2);
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter2.replace(",", "").equals(enter4.replace(",", "")) && enter3.replace(",", "").equals(enter4.replace(",", ""))) {
            	
            	if(checkMultipleOrders(time,enter2)) {
            		isValid = true;
            		response = hm.get(enter1) + "," + hm.get(enter2)+ "(3x)" ;
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter1.replace(",", "").equals(enter4.replace(",", ""))) {
            	 
            	if(checkMultipleOrders(time,enter1)) {
            		isValid = true;
            		response = hm.get(enter1)+"(2x)"+"," + hm.get(enter2) + "," + hm.get(enter3); 
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter2.replace(",", "").equals(enter4.replace(",", ""))) {
            	
            	if(checkMultipleOrders(time,enter2)) {
            		isValid = true;
            		response = hm.get(enter1)+"," + hm.get(enter2)+"(2x)" + "," + hm.get(enter3); 
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else if(enter3.replace(",", "").equals(enter4.replace(",", ""))) {
            	 
            	if(checkMultipleOrders(time,enter3)) {
            		isValid = true;
            		response = hm.get(enter1)+"," + hm.get(enter2) + "," + hm.get(enter3)+"(2x)"; 
            	}else {
            		isValid = false;
            		response = "You should order multiple coffe only on morning and multiple potato only on night";
            		System.out.println(response);
            		return;
            	}
            	
            }else {                   
            	if(isValid) {
            		response = response + "," + hm.get(enter4);
            	}else {
            		response = hm.get(enter1) + "," + hm.get(enter2)+ "," + hm.get(enter3)+ "," + hm.get(enter4);
            		System.out.println(response);
            		return;
            	}                    	
            	
            }
        		
        }
        
        
        
        
        System.out.print(response+"\n");
        
            
        }catch(Exception e){
        	
            System.err.println("Invalid input !");
            
        }
    }
	
	
	
public static void reorderEnter2(int val1, int val2) {
		
		int newVal2 = 0;
		String newEnt2 = "";
		
		if(val1 > val2) {
			
			newVal2 = value1;		
			value1 = value2;
			value2 = newVal2;
			
			newEnt2 = enter1;
			enter1 = enter2;
			enter2 = newEnt2;

		}
		
				
	}
	
	public static void reorderEnter3(int val1, int val2, int val3) {
		
		int newVal3 = 0;
		String newEnt3 = "";
		
		
		if(val2 > val3) {
			
			newVal3 = value2;
			value2 = value3;
			value3 = newVal3;
			
			newEnt3 = enter2;
			enter2 = enter3;
			enter3 = newEnt3;
		}	
		
		
		if(val1 > val3) {
			
			newVal3 = value1;
			value1 = value3;
			value3 = newVal3;
			
			newEnt3 = enter1;
			enter1 = enter3;
			enter3 = newEnt3;
		}
		
		
	}
	
	public static void reorderEnter4(int val1, int val2, int val3, int val4) {
		
		int newVal4 = 0;
		String newEnt4 = "";
		
		if(val3 > val4) {
			newVal4 = value3;
			value3 = value4;
			value4 = newVal4;
			
			newEnt4 = enter3;
			enter3 = enter4;
			enter4 = newEnt4;
		}	
		
		
		if(val2 > val4) {
			
			newVal4 = value2;
			value2 = value4;
			value4 = newVal4;
			
			newEnt4 = enter2;
			enter2 = enter4;
			enter4 = newEnt4;
		}
		
		if(val1 > val4) {
			
			newVal4 = value1;
			value1 = value4;
			value4 = newVal4;
			
			newEnt4 = enter1;
			enter1 = enter4;
			enter4 = newEnt4;
		}
		
				
	}
	
	
	
	
	
	
	
	
	public static Boolean checkMultipleOrders(String time, String order) {
		
		if(time.equals("morning") && order.equals("morning,3")) {
			return true;
		}else if(time.equals("night") && order.equals("night,2")){
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	

}
