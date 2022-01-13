//package com.example.restaurant.service;
//
//import com.webservice.train.dao.BookTrainRepositories;
//import com.webservice.train.dao.TrainRepositories;
//import com.webservice.train.entities.BookTrain;
//import com.webservice.train.entities.Train;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookTrainService {
//
//    @Autowired
//    private BookTrainRepositories repository;
//    @Autowired
//    private TrainRepositories trainRepository;
//
//    public BookTrain addBookTrain(BookTrain bookTrain){
//        return repository.save(bookTrain);
//
//    }
//
//    public List<BookTrain> addBookTrains(List<BookTrain> bookTrainsList){
//        return repository.saveAll(bookTrainsList);
//    }
//
//    public BookTrain getBookTrainById(int id){
//        return repository.findById(id).orElse(null);
//    }
//
//    public List<BookTrain> getBookTrains(){
//        return repository.findAll();
//    }
//
//    public String deleteBookTrain(int id){
//
//        if ( repository.existsById(id) ) {
//            repository.deleteById(id);
//            return "success";
//        }
//        else {
//            return "not exists";
//        }
//
//    }
//
//    public BookTrain updateBookTrain(BookTrain bookTrain){
///*
//        JdbcTemplate jdbc = new JdbcTemplate();
//        String sqlQuery = "UPDATE bookTrain SET numberPlaces = ?  WHERE id = ? ";
//        jdbc.update( sqlQuery, bookTrain.getNumberPlaces(), bookTrain.getId());
//
//        return getBookTrainById(bookTrain.getId());
//
// */
//
//        BookTrain booktrainToUpdate = repository.findById(bookTrain.getId()).orElse(null);
//        if ( booktrainToUpdate != null ) {
//            booktrainToUpdate.setId(bookTrain.getId());
//            booktrainToUpdate.setNumberPlaces(bookTrain.getNumberPlaces());
//            Train trainOfBookTrain = trainRepository.findById(booktrainToUpdate.getTrain().getId()).orElse(null);
//            if ( trainOfBookTrain != null ) {
//                booktrainToUpdate.setTrain(trainOfBookTrain);
//            }
//            return repository.save(booktrainToUpdate);
//        } else {
//            return null;
//        }
//
//
//    }
//
//}
