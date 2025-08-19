package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CitizenDAO;
import model.Citizen;

@WebServlet("/AddCitizenServlet")
public class AddCitizenServlet extends HttpServlet {
    private CitizenDAO citizenDAO = new CitizenDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String soCCCD = request.getParameter("soCCCD");
        String hoTen = request.getParameter("hoTen");
        String tuoiStr = request.getParameter("tuoi");
        String email = request.getParameter("email");
        if (soCCCD == null || soCCCD.isEmpty() || hoTen == null || hoTen.isEmpty() || tuoiStr == null || tuoiStr.isEmpty()) {
            request.setAttribute("error", "Các trường Số CCCD, Họ Tên, Tuổi là bắt buộc!");
            request.getRequestDispatcher("/views/addCitizen.jsp").forward(request, response);
            return;
        }

        int tuoi;
        try {
            tuoi = Integer.parseInt(tuoiStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Tuổi phải là một số hợp lệ!");
            request.getRequestDispatcher("/views/addCitizen.jsp").forward(request, response);
            return;
        }
        if (tuoi < 0 || tuoi > 120) {
            request.setAttribute("error", "Tuổi phải từ 0 đến 120!");
            request.getRequestDispatcher("/views/addCitizen.jsp").forward(request, response);
            return;
        }

        Citizen citizen = new Citizen();
        citizen.setSoCCCD(soCCCD);
        citizen.setHoTen(hoTen);
        citizen.setTuoi(tuoi);
        citizen.setEmail(email);

        try {
            if (citizenDAO.addCitizen(citizen)) {
                response.sendRedirect(request.getContextPath() + "/ListCitizenServlet");
            } else {
                request.setAttribute("error", "Lỗi khi lưu dữ liệu!");
                request.getRequestDispatcher("/views/addCitizen.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi lưu dữ liệu: " + e.getMessage());
            request.getRequestDispatcher("/views/addCitizen.jsp").forward(request, response);
        }
    }
}