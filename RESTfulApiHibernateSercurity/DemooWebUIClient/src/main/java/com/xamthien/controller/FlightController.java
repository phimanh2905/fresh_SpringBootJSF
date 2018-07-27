package com.xamthien.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.model.*;
import com.xamthien.service.*;
import com.xamthien.utils.WebUtils;

@Controller
public class FlightController {
	
//	@Autowired
//	private FlightSchedulesService flightSchedulesService;
//	
//	@Autowired
//	private PaymentMethodService paymentMethodService;
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private ReservationStatusService statusService;
//	
//	@Autowired
//	private ReservationService reservationService;
//	
//	@RequestMapping("/")
//	public String listSach(Model model) {	
//		model.addAttribute("list", flightSchedulesService.getAllFlight());
//		return "trangchu";
//	}
	//=========================================================================================================================================
	@RequestMapping("/saveFlightBooking")
	public String doSaveCustomer(HttpServletRequest req, Model model) throws IOException {
		String msg = "";
		try
		{
			String flightID = req.getParameter("flightID");
			String cusname = req.getParameter("cusname");
			String cusphone = req.getParameter("cusphone");
			String cusemail = req.getParameter("cusemail");
			String paymethodID = req.getParameter("paymethod");
			String stk = req.getParameter("stk");
			
//			if(flightID.trim().equals("") || cusname.trim().equals("") || cusphone.trim().equals("") )
//			{
				Customer cus = new Customer(cusname,cusphone,cusemail);
				boolean check = saveCustomer(cus);
				
				FlightSchedules flight = getFlightByID(Integer.parseInt(flightID));
				
				PaymnetMethod pm = getpaymentMethodByID(Integer.parseInt(paymethodID));
				
				
//				if(check==false)
//				{
//					msg = "Đặt vé không thành công.";
//				}
//				else
//				{
//					ReservationStatus stt= new ReservationStatus();
//					if(stk==null || stk.trim().equals(""))
//					{
//						stt = getStatusByID(1);
//					}
//					else
//					{
//						stt = getStatusByID(2);
//					}
//					System.out.println(stt.getRsName());
//					
//					Date now = new Date();
//					
//					Reservation res = new Reservation(cus,flight,pm,stt,now);
//					check = saveReservation(res);
//					if(check)
//					{
//						msg = "Đặt vé thành công.";
//					}
//					else
//					{
//						msg = "Đặt vé không thành công.";
//					}
//				}
//				model.addAttribute("msg", msg);
//				model.addAttribute("list", getLstFlight(model));
//			}
//			else
//			{
//				throw new Exception();
//			}
		}
		catch (Exception e)
		{
			msg = "Đặt vé không thành công."+e;
//			model.addAttribute("msg", msg);
//			model.addAttribute("list", getLstFlight(model));
		}
		return "redirect:/index"; 
	}
	//===================
	public PaymnetMethod getpaymentMethodByID(int id) throws IOException
    {
		URL website = new URL("http://192.188.88.119:8090/api/paymentmethod/"+id);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        PaymnetMethod pm =null;
        try
        {
        	inputStream = website.openStream();
        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
        	
        	StringBuilder stringBuilder = new StringBuilder();
        	int cp;
        	while ((cp = bufferedReader.read())!=-1)
        	{
        		stringBuilder.append((char)cp);
        	}
        	ObjectMapper mapper = new ObjectMapper();
        	pm = mapper.readValue(stringBuilder.toString(), PaymnetMethod.class);
    		
        }
        catch(Exception e)
        {
        	inputStream.close();
        	bufferedReader.close();
        	
        }
        return pm;
    }
	//======================
	public ReservationStatus getStatusByID(int id) throws IOException
    {
		URL website = new URL("http://192.188.88.119:8090/api/reservation_status/"+id);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        ReservationStatus stt =null;
        try
        {
        	inputStream = website.openStream();
        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
        	
        	StringBuilder stringBuilder = new StringBuilder();
        	int cp;
        	while ((cp = bufferedReader.read())!=-1)
        	{
        		stringBuilder.append((char)cp);
        	}
        	ObjectMapper mapper = new ObjectMapper();
        	stt = mapper.readValue(stringBuilder.toString(), ReservationStatus.class);
    		
        }
        catch(Exception e)
        {
        	inputStream.close();
        	bufferedReader.close();
        	
        }
        return stt;
    }
	//==========================================
	public boolean saveCustomer(Customer cus) throws IOException
    {
		boolean ckeck = true;
		JSONObject json = new JSONObject();
		json.put("cname", cus.getCName());  
    	json.put("phone", cus.getPhone());    
    	json.put("email", cus.getEmail());    
    	  

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    HttpPost request = new HttpPost("http://192.188.88.119:8090/api/customer");
    	    StringEntity params = new StringEntity(json.toString());
    	    request.addHeader("content-type", "application/json");
    	    request.setEntity(params);
    	    httpClient.execute(request);
    	    ckeck = true;
    	} catch (Exception ex) {
    		ckeck = false;
    	} finally {
    	    httpClient.close();
    	}
    	return ckeck;
    }
	public boolean saveReservation(Reservation res) throws IOException
    {
		boolean ckeck = true;
		JSONObject json = new JSONObject();
    	 
    	json.put("customer", res.getCustomer());    
    	json.put("flightSchedules", res.getFlightSchedules());    
    	json.put("paymnetMethod", res.getPaymnetMethod());   
    	json.put("reservationStatus", res.getReservationStatus());
    	json.put("dateOfReservation", res.getDateOfReservation());

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    HttpPost request = new HttpPost("http://192.188.88.119:8090/api/reservation");
    	    StringEntity params = new StringEntity(json.toString());
    	    request.addHeader("content-type", "application/json");
    	    request.setEntity(params);
    	    httpClient.execute(request);
    	    ckeck = true;
    	} catch (Exception ex) {
    		ckeck = false;
    	} finally {
    	    httpClient.close();
    	}
    	return ckeck;
    }
	
    //============================================================================================================================================
	@RequestMapping("/searchx")
	public String search() {
		return "search";
	}
	@RequestMapping("/search")
	public void searchFlightBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String phone = request.getParameter("txtsearch");
		response.setCharacterEncoding("utf-8");
		try {
            List<Reservation> rs = searchReservationByPhone(phone);
            
            String strtext = "";
            if(rs != null)
            {
            	int stt =1;
                for (Reservation hh : rs) 
                {
                	strtext+= "<tr> "
                			+ "<td>"+stt+"</td> "
                			+ "<td>"+hh.getFlightSchedules().getFFrom()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getFTo()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getDepartureTime()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getArrivalTime()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getAirline().getAName()+"</td>"
                			+ "<td>"+"99K"+"</td>"
                			+ "<td>"+hh.getReservationStatus().getRsName()+"</td>"
                			+ "</tr>";
                	stt++;
                }
            }
            else
            {
            	strtext="Không có dữ liệu hiển thị.";
            }
            response.getWriter().print(strtext);
        } catch (Exception ex) {
            response.getWriter().print("Lỗi truy vấn dữ liệu : " + ex.getMessage());
        }
		
	}
	public List<Reservation> searchReservationByPhone(String phone) throws IOException
    {
		URL website = new URL("http://192.188.88.119:8090/api/reservation_p/"+phone);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<Reservation> lst = null;
        try
        {
        	inputStream = website.openStream();
        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
        	
        	StringBuilder stringBuilder = new StringBuilder();
        	int cp;
        	while ((cp = bufferedReader.read())!=-1)
        	{
        		stringBuilder.append((char)cp);
        	}
        	ObjectMapper mapper = new ObjectMapper();
        	JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Reservation.class);
        	lst = mapper.readValue(stringBuilder.toString(), type);
        }
        catch(Exception e)
        {
        	inputStream.close();
        	bufferedReader.close();
        	
        }
		//resp.getWriter().println("xxx");
        return lst;
    }
	//============================================================================================================================================
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(Model model) {
//    	
//        return "loginPage";
//    }
//	@RequestMapping(value = "/manager/flight", method = RequestMethod.GET)
//    public String xxx(Model model,Principal principal,HttpSession session) {
//		String userName = principal.getName();
//        session.setAttribute("userName", userName);
//
//		model.addAttribute("list", flightSchedulesService.getAllFlight());
//		model.addAttribute("newflight", new FlightSchedules());
//        return "chuyenbay";
//    }
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal,HttpSession session) {
 
        if (principal != null) {
        	String userName = principal.getName();
            session.setAttribute("userName", userName);
 
            String message = "Hi " + principal.getName() //
                    + "<br> Bạn không có quyền truy cập vào đây!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
//	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//		model.addAttribute("list", flightSchedulesService.getAllFlight());
//		return "trangchu";
//    }
	
	@RequestMapping("/testpost")
    public void post(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {//var obj= {'empNo':id,'empName':name,'position':pos};
		resp.setCharacterEncoding("utf-8");
    	String id = req.getParameter("idx");
    	String name = req.getParameter("namex");
    	String pos = req.getParameter("posx");
    	JSONObject json = new JSONObject();
    	json.put("empNo", id);    
    	json.put("empName", name);    
    	json.put("position", pos);    

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    HttpPost request = new HttpPost("http://192.188.88.119:8080/employee");
    	    StringEntity params = new StringEntity(json.toString());
    	    request.addHeader("content-type", "application/json");
    	    request.setEntity(params);
    	    httpClient.execute(request);
    	    resp.getWriter().println("Thêm thành công");
    	} catch (Exception ex) {
    	    // handle exception here
    	} finally {
    	    httpClient.close();
    	}
    }
	@RequestMapping("/testput")
    public void put(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {//var obj= {'empNo':id,'empName':name,'position':pos};
		resp.setCharacterEncoding("utf-8");
    	String id = req.getParameter("idx");
    	String name = req.getParameter("namex");
    	String pos = req.getParameter("posx");
    	JSONObject json = new JSONObject();
    	json.put("empNo", id);    
    	json.put("empName", name);    
    	json.put("position", pos);    

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    HttpPut request = new HttpPut("http://192.188.88.119:8080/employee/"+id);
    	    StringEntity params = new StringEntity(json.toString());
    	    request.addHeader("content-type", "application/json");
    	    request.setEntity(params);
    	    httpClient.execute(request);
    	    resp.getWriter().println("Sửa thành công");
    	} catch (Exception ex) {
    	    // handle exception here
    	} finally {
    	    httpClient.close();
    	}
    }
	@RequestMapping("/testdelete")
    public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {//var obj= {'empNo':id,'empName':name,'position':pos};
    	resp.setCharacterEncoding("utf-8");
    	String id = req.getParameter("idx");   

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    HttpDelete request = new HttpDelete("http://192.188.88.119:8080/employee/"+id);

    	    request.addHeader("content-type", "application/json");
    	    httpClient.execute(request);
    	    resp.getWriter().println("Xóa thành công");
    	} catch (Exception ex) {
    		resp.getWriter().println("Xóa không thành công");
    	} finally {
    	    httpClient.close();
    	}
    }
	//=======================================================================================================================================
	@RequestMapping(value = {"/","/index"})
    public String getLstFlight(Model model,String msg) throws IOException
    {//var obj= {'empNo':id,'empName':name,'position':pos};
		URL website = new URL("http://192.188.88.119:8090/api/flights");
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try
        {
        	inputStream = website.openStream();
        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
        	
        	StringBuilder stringBuilder = new StringBuilder();
        	int cp;
        	while ((cp = bufferedReader.read())!=-1)
        	{
        		stringBuilder.append((char)cp);
        	}
        	ObjectMapper mapper = new ObjectMapper();
        	JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, FlightSchedules.class);
        	List<FlightSchedules> lst = mapper.readValue(stringBuilder.toString(), type);
        	model.addAttribute("msg", msg);
        	model.addAttribute("list", lst);
    		return "trangchu";
        }
        catch(Exception e)
        {
        	inputStream.close();
        	bufferedReader.close();
        	
        }
		//resp.getWriter().println("xxx");
        return "trangchu";
    }
	//========================================================================================================================================
	@RequestMapping("/chitiet/id={id}")
	public String doFlightBooking(@PathVariable int id, Model model) throws IOException {
		FlightSchedules fl = getFlightByID(id);
		model.addAttribute("flight", fl);	
		model.addAttribute("flightID", String.valueOf(id));
		model.addAttribute("listpayment", getLstPaymentMethod());
		return "datve";
	}
	public FlightSchedules getFlightByID(int id) throws IOException
    {
		URL website = new URL("http://192.188.88.119:8090/api/flight/"+id);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        FlightSchedules flight =null;
        try
        {
        	inputStream = website.openStream();
        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
        	
        	StringBuilder stringBuilder = new StringBuilder();
        	int cp;
        	while ((cp = bufferedReader.read())!=-1)
        	{
        		stringBuilder.append((char)cp);
        	}
        	ObjectMapper mapper = new ObjectMapper();
        	flight = mapper.readValue(stringBuilder.toString(), FlightSchedules.class);
    		
        }
        catch(Exception e)
        {
        	inputStream.close();
        	bufferedReader.close();
        	
        }
        return flight;
    }
	public List<PaymnetMethod> getLstPaymentMethod() throws IOException
    {//var obj= {'empNo':id,'empName':name,'position':pos};
		URL website = new URL("http://192.188.88.119:8090/api/paymentmethods");
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<PaymnetMethod> lst = null;
        try
        {
        	inputStream = website.openStream();
        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
        	
        	StringBuilder stringBuilder = new StringBuilder();
        	int cp;
        	while ((cp = bufferedReader.read())!=-1)
        	{
        		stringBuilder.append((char)cp);
        	}
        	ObjectMapper mapper = new ObjectMapper();
        	JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, PaymnetMethod.class);
        	lst = mapper.readValue(stringBuilder.toString(), type);
        }
        catch(Exception e)
        {
        	inputStream.close();
        	bufferedReader.close();
        	
        }
		
        return lst;
    }
	//=======================================================================================================================================
}
