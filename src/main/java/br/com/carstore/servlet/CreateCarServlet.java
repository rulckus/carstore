package br.com.carstore.servlet;


import br.com.carstore.dao.CarDAO;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String carId = request.getParameter("id");
        String name = request.getParameter("name");
        Car car = new Car(carId,name);

        CarDAO dao = new CarDAO();

        if (carId.isBlank()){
            dao.createCar(car);
        }
        else{
            dao.updateCar(car);
        }

        resp.sendRedirect("/find-all-cars");

    }

}
