package br.com.carstore.dao;

import br.com.carstore.model.Car;
import br.com.carstore.servlet.config.ConnectionPoolConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDAO {


    public void createCar(Car car){
        String SQL = "INSERT INTO  CAR (NAME) VALUES(?)";

        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getNome());

            preparedStatement.execute();

            System.out.println("Sucesso ao cadastrar o carro no banco de dados");

            connection.close();

        }catch (Exception e){
            System.out.println("Falha ao inserir o carro no banco de dados!");
        }
    }

    public List<Car> findAllCars(){
        String SQL = "SELECT * FROM CAR";

        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()){

                String carId = resultSet.getString("id");
                String carName = resultSet.getString("name");

                Car car = new Car(carId, carName);

                cars.add(car);

            }

            System.out.println("Sucesso ao consultar os dados no DB");
            connection.close();

            return cars;
        }catch(Exception e){
            System.out.println("Erro ao consultar os carros no DB" + e.getMessage());
        }

        return Collections.emptyList();
    }

    public void deleteCarById(String carId){
        String SQL = "DELETE CAR WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carId);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + carId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }
    }

    public void updateCar(Car car) {

        String SQL = "UPDATE CAR SET NAME = ? WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getNome());
            preparedStatement.setString(2, car.getId());
            preparedStatement.execute();

            System.out.println("success in update car");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }

    }
}
