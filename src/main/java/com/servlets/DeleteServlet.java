package com.servlets;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteid =Integer.parseInt(request.getParameter("note_id"));
			
			Session session = FactoryProvider.getFactory().openSession();
			Transaction trs = session.beginTransaction();
			Note note = session.get(Note.class, noteid);
			session.delete(note);
			trs.commit();
			session.close();
			response.sendRedirect("all_notes.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occur: "+e.getMessage());
		}
		
		
			}


}
