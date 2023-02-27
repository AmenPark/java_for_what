package com.PAM.refgManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ConvInfoAPIController
 */
@WebServlet("/ConvInfoAPIController")
public class ConvInfoAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvInfoAPIController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		ArrayList<ItemConvInfoDTO> dal = UserDAO.getInstance().getRelationInfo(request,response);
		HashMap<String, Integer> hs = new HashMap<>();
		JSONObject oriJO = new JSONObject();
		int i = 0;
		int k = 0;
		JSONObject jo = null;
		JSONArray ja = null;
		if (dal!=null) {
			oriJO.put("status_code", ("200"));
			oriJO.put("text", "200OK");
			JSONArray oriJA = new JSONArray();
			for(ItemConvInfoDTO d:dal) {
				if(hs.containsKey(d.getConvName())) {
					k = hs.get(d.getConvName());
					jo = (JSONObject)oriJA.get(k);
					ja = (JSONArray)jo.get("Items");
					jo = new JSONObject();
					jo.put("ItemName", d.getItemName());
					jo.put("Quantity", d.getQuantities());
					jo.put("Event", d.getEvent());
					ja.add(jo);
					
				}else {
					hs.put(d.getConvName(), i);
					i++;
					jo = new JSONObject();
					jo.put("Name", d.getConvName());
					jo.put("Area", d.getArea());
					ja = new JSONArray();
					jo.put("Items", ja);
					oriJA.add(jo);
					
					jo = new JSONObject();
					jo.put("ItemName", d.getItemName());
					jo.put("Quantity", d.getQuantities());
					jo.put("Event", d.getEvent());
					ja.add(jo);
				}
				oriJO.put("data", oriJA);
			}
		}else {
			oriJO.put("status_code", "400");
			oriJO.put("text", "BAD REQUEST");
		}
		
		response.getWriter().print(oriJO.toJSONString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
