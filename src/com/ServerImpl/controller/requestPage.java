package com.ServerImpl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServerImpl.model.ClientSide;



@WebServlet("/requestPage")
public class requestPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String nextviewpage = null;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Request ID
		String req_ID = request.getSession().getId();
		System.out.println("Request ID:"+req_ID);
		
		//Get random string
		String r_string = "11";

		//Get difficulty
		int difficulty = 2;
		
		 ServletContext sc = request.getServletContext().getContext("/ClientImpl");
		 
		 request.setAttribute("req_ID", req_ID);
		 request.setAttribute("r_string", r_string);
		 request.setAttribute("difficulty", Integer.toString(difficulty));

		 RequestDispatcher rd = sc.getRequestDispatcher("/solvePuzzle");
	     rd.forward(request, response);
		
		
	}

}