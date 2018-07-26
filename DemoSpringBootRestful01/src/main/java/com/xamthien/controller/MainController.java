package com.xamthien.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.DAO.EmployeeDAO;
import com.xamthien.model.Employee;
import com.xamthien.model.Post;

 
@RestController
public class MainController {
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    @RequestMapping("/")
    @ResponseBody
    public String welcome(Model model) {
    	List<Employee> list = employeeDAO.getAllEmployees();
    	model.addAttribute("list", list);
    	model.addAttribute("emp", new Employee());
        return "index1.html";
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employees
    // http://localhost:8080/SomeContextPath/employees.json
    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE}) //Thuộc tính produces được sử dụng để quy định một URL sẽ chỉ tạo ra (trả về cho người dùng) các dữ liệu với các định dạng nào. 
                    //MediaType.APPLICATION_XML_VALUE })		//Chẳng hạn "application/json", "application/xml".
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }
    
    
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empNo}
    // http://localhost:8080/SomeContextPath/employee/{empNo}.json
    @RequestMapping(value = "/employee/{empNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE}) //
                    //MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employeeDAO.getEmployee(empNo);
    }
 
 
    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE}) //
                    //MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
//    	String id= req.getParameter("empNo");
//    	String name= req.getParameter("empName"); ,HttpServletRequest req,HttpServletResponse response
//    	String pos= req.getParameter("position");  throws IOException
//    	Employee emp = new Employee(id,name,pos);
        
        //employeeDAO.addEmployee(emp);
        //response.getWriter().println(emp.getEmpName()); 
    	return(emp);
    }

    
    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE}) //
                    //MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp) {
 
        System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
 
        return employeeDAO.updateEmployee(emp);
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empNo}
    @RequestMapping(value = "/employee/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})//, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") String empNo) {
 
        System.out.println("(Service Side) Deleting employee: " + empNo);
 
        employeeDAO.deleteEmployee(empNo);
    }
    //==================================================================================
    // demo get json from URL https://www.youtube.com/watch?reload=9&v=_3_3VEpd5bQ
    @RequestMapping(value = "/getJson", method = RequestMethod.GET) 
    @ResponseBody
    public String loadJsonEmployees(Model model) {
    	List<Employee> list = null;
    	JSONParser parser = new JSONParser();
        try {         
            URL url = new URL("/employees"); // URL to Parse
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {               
                JSONArray a = (JSONArray) parser.parse(inputLine);
                // Loop through each item
                for (Object o : a) {
                    JSONObject item = (JSONObject) o;
                    String id = (String) item.get("empNo");
                    String name = (String) item.get("empName");
                    String pos = (String) item.get("position");
                    list.add(new Employee(id,name,pos));
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    	//===================================================
    	// đây là đọc 1 phần tử
//    	ObjectMapper mapper = new ObjectMapper();
//        try {
//            Post usrPost = mapper.readValue(new URL("http://jsonplaceholder.typicode.com/posts/7"), Post.class);
//            System.out.println(usrPost);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        model.addAttribute("list", list);
        return "index1";
    }
}
