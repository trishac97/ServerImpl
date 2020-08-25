package com.ServerImpl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.StringUtil;


@WebServlet("/verifyPuzzle")
public class verifyPuzzle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Verification Module");
		
		String req_ID = (String)request.getAttribute("req_ID");
		String nonce = (String) request.getAttribute("nonce");
		String hashSol = (String) request.getAttribute("hashSol");
		String r_string = (String) request.getAttribute("r_string");
		
		//Server module verifying solution
				String correctHash = null;
				try {
					correctHash = StringUtil.SHA256(nonce + req_ID + r_string);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		       
				String nextviewpage = null;
				if(correctHash.equals(hashSol)) {
					System.out.println("SHA Verified!!!!!!!!!");
					System.out.println("Server SHA value:"+correctHash);
					nextviewpage = "Requested_Page.jsp";
				}
				else {
					System.out.println("Something went wrong");
				}
				
				RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
				rd.forward(request, response);
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
