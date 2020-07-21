package org.login.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	UserController userController = new UserController();
	BranchController branchController = new BranchController();
	
	private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		
		switch(uri) {
		case "/Login/userController":
			if(req.getMethod().equals("POST")) {
				userController.inputUser(req, resp);
				return;
			}
			if(req.getMethod().equals("GET")) {
				userController.pullUserOrTable(req, resp);
				return;
			}
			if(req.getMethod().equals("PUT")) {
				userController.updateUser(req, resp);
				return;
			}
			if(req.getMethod().equals("DELETE")) {
				userController.deleteUser(req, resp);
				return;
			}
		case "/Login/branchController":
			if(req.getMethod().equals("POST")) {
				branchController.inputBranch(req, resp);
				return;
			}
			if(req.getMethod().equals("GET")) {
				branchController.pullBranchOrTable(req, resp);
				return;
			}
			if(req.getMethod().equals("PUT")) {
				branchController.updateBranch(req, resp);
				return;
			}
			if(req.getMethod().equals("DELETE")) {
				branchController.deleteBranch(req, resp);
				return;
			}
		case "/Login/userController/forwardme":
			req.getRequestDispatcher("/index.html").forward(req, resp);
			break;
		case "/Login/branchController/forwardme":
			req.getRequestDispatcher("/index.html").forward(req, resp);
			break;
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
}
