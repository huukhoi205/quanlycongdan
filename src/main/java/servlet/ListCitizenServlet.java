package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CitizenDAO;
import model.Citizen;

@WebServlet("/ListCitizenServlet")
public class ListCitizenServlet extends HttpServlet {
    private CitizenDAO citizenDAO = new CitizenDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            ArrayList<Citizen> citizens = citizenDAO.getAllCitizens();
            request.setAttribute("citizens", citizens);
            request.getRequestDispatcher("/views/listCitizens.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi lấy danh sách: " + e.getMessage());
            request.getRequestDispatcher("/views/listCitizens.jsp").forward(request, response);
        }
    }
}