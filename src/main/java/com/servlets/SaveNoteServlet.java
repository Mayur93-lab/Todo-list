package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Save_Note_Servlet", urlPatterns = { "/Save_Note_Servlet" })
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             PrintWriter out = response.getWriter(); 
		try {
			  String title = request.getParameter("title");
			  String content = request.getParameter("content");
			  
			  Note note = new Note(title, content, new Date()); 
			  
			  Session s = FactoryProvider.getFactory().openSession();
			  Transaction trs = s.beginTransaction();
			  s.save(note);
			  response.setContentType("text/html");
			  out.print("<h1 style='text-align:center; color:green'>Note Added Successfully..!</h1>");
			  out.print("<h1 style='text-align:center; color:blue'><a href='all_notes.jsp'>View all Notes</a></h1>");
			  
			  
			  
			  trs.commit();
			  s.close();
			  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
