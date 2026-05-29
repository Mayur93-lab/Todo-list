package com.servlets;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int note_Id = Integer.parseInt(request.getParameter("note_id"));

			Session s = FactoryProvider.getFactory().openSession();
			Transaction trs = s.beginTransaction();

			Note note = s.get(Note.class, note_Id);

			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());

			trs.commit();
			s.close();
			
			response.sendRedirect("all_notes.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occurs :" + e.getMessage());
		}
	}

}
