package com.ibm.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BugController {
	 @PostMapping("/bug")
     String createOrder()
            {return "Bug Created";}
@GetMapping("/bug")
  String getOrder()
  {return "Order Status:Open";}
@PutMapping("/bug/{id}")
String Updateorder(@PathVariable("id")int BugId)
{System.out.println(BugId);
 return "Bug Status Changed to:Completed";
 }
@DeleteMapping("/bug/{id}")
String DeleteOrder(@PathVariable("id")int deleteId)
{
 //System.out.println(httpRequest.getHeaders());
 System.out.println(deleteId);
 return "Success and Bug has been closed";
 
}
}
