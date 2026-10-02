package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDAO {


    public void createCar(Car car){
        String SQL = "INSERT INTO  CAR (NAME) VALUES(?)";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucasso ao conectar no banco de dados");

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
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            System.out.println("Sucesso ao conectar no DB");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()){

                Car car = new Car();
                String name = resultSet.getString("name");
                car.setNome(name);
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
}
