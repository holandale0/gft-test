package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GftDeveloperPracticumTest {
	
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
        
        String enter1 = "";
        String enter2 = "";
        String enter3 = "";
        String enter4 = "";
        String response = "";
        
        int eggCount = 0;
        int toastCount = 0;
        int coffeCount = 0;
        int errorCount = 0;
        int steakCount = 0;
        int potatoCount = 0;
        int wineCount = 0;
        int cakeCount = 0;
        
        String[] tests = {
        		//ADD YOUR TESTS HERE
        		"morning,1,2,1,3"
        		,"morning,1,4"
        		,"morning,1,2,3,4"
        		,"morning,1,1,1,2"
        		,"night,3,2,2,2"
        		,"night,4"
        		,"night,1,2,3,5"
        		,"night,7,8,9,11,12"
        		
        };
        
        System.out.print("Enter values:\n");  
        
        for(int i = 0 ; i < tests.length ; i++) {
        	
        	try{
                
                 
                
                String s = tests[i].trim().toLowerCase().replace(" ", "");
                
                if(s.contains("morning")) {       	
                	
            	    if(s.length() > 7 && s.charAt(7) == ',') {
            	    	enter1 = "morning,"+s.charAt(8);
            	    	if(s.length() > 9 && s.charAt(9) == ',') {
            	    		enter2 = "morning,"+s.charAt(10);
            	    		if(s.length() > 11 && s.charAt(11) == ',') {
                	    		enter3 = "morning,"+s.charAt(12);
                	    		if(s.length() > 13 && s.charAt(13) == ',') {
                    	    		enter4 = "morning,"+s.charAt(14);
                    	    	}
                	    	}
            	    	}
            	    	
            	    }
                	
                	
                }else if(s.contains("night")) {
                	
                	
                	    if(s.length() > 5 && s.charAt(5) == ',') {
                	    	enter1 = "night,"+s.charAt(6);
                	    	if(s.length() > 7 && s.charAt(7) == ',') {
                	    		enter2 = "night,"+s.charAt(8);
                	    		if(s.length() > 9 && s.charAt(9) == ',') {
                    	    		enter3 = "night,"+s.charAt(10);
                    	    		if(s.length() > 11 && s.charAt(11) == ',') {
                        	    		enter4 = "night,"+s.charAt(12);
                        	    	}
                    	    	}
                	    	}
                	    	
                	    }  	
                	
                }else {
                	
                	response = "Incorrect input !";
                	
                }
                            
                
                
                
                if(!"".equals(enter1)) {
                	
                	response = response+hm.get(enter1);
                	
                }if(!"".equals(enter2)) {
                	
                    if(enter1.replace(",", "").equals(enter2.replace(",", ""))) {
                    	response = hm.get(enter1)+"(2x)"+",";         	  	
                    }else {
                    	response = response + "," + hm.get(enter2);
                    }
                	
                }if(!"".equals(enter3)) {
                	
                	if(enter1.replace(",", "").equals(enter3.replace(",", "")) && enter2.replace(",", "").equals(enter3.replace(",", ""))) {
                    	response = hm.get(enter1) + "(3x)";
                    }else if(enter1.replace(",", "").equals(enter3.replace(",", ""))) {
                    	response = hm.get(enter1)+"(2x)"+","+hm.get(enter2);         	  	
                    }else if(enter2.replace(",", "").equals(enter3.replace(",", ""))){
                    	response = hm.get(enter1) + "," + hm.get(enter2) +"(2x)";
                    }else {
                    	response = response + "," + hm.get(enter3);
                    }
                	
                }if(!"".equals(enter4)) {
                	
                	if(enter1.replace(",", "").equals(enter4.replace(",", "")) && enter2.replace(",", "").equals(enter4.replace(",", "")) && enter3.replace(",", "").equals(enter4.replace(",", ""))) {
                		response = hm.get(enter1) + "(4x)";
                	}else if(enter1.replace(",", "").equals(enter4.replace(",", "")) && enter2.replace(",", "").equals(enter4.replace(",", ""))) {
                    	response = hm.get(enter1) + "(3x)" + "," + hm.get(enter3);
                    }else if(enter1.replace(",", "").equals(enter4.replace(",", "")) && enter3.replace(",", "").equals(enter4.replace(",", ""))) {
                    	response = hm.get(enter1) + "(3x)" + "," + hm.get(enter2);
                    }else if(enter2.replace(",", "").equals(enter4.replace(",", "")) && enter3.replace(",", "").equals(enter4.replace(",", ""))) {
                    	response = hm.get(enter1) + "," + hm.get(enter2)+ "(3x)" ;
                    }else if(enter1.replace(",", "").equals(enter4.replace(",", ""))) {
                    	response = hm.get(enter1)+"(2x)"+"," + hm.get(enter2) + "," + hm.get(enter3);          	  	
                    }else if(enter2.replace(",", "").equals(enter4.replace(",", ""))) {
                    	response = hm.get(enter1)+"," + hm.get(enter2)+"(2x)" + "," + hm.get(enter3);         	  	
                    }else if(enter3.replace(",", "").equals(enter4.replace(",", ""))) {
                    	response = hm.get(enter1)+"," + hm.get(enter2) + "," + hm.get(enter3)+"(2x)";         	  	
                    }else {
                    	response = response + "," + hm.get(enter4);
                    }
                		
                }
                
                
                
                
                System.out.print(response+"\n");
                
                s = "";
                response = "";
                enter1 = "";
                enter2 = "";
                enter3 = "";
                enter4 = "";
                eggCount = 0;
                toastCount = 0;
                coffeCount = 0;
                errorCount = 0;
                steakCount = 0;
                potatoCount = 0;
                wineCount = 0;
                cakeCount = 0;
                
                
                    
                }catch(Exception e){
                	
                    System.err.println("Invalid input !");
                    
                }
        	
        }
              

        
        
    }

}
