//package com.coaching.center.repository.impl;
//
//import com.coaching.center.model.Course;
//import com.coaching.center.repository.CourseRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import javax.persistence.EntityManagerFactory;
//import java.util.Optional;
//
//@Repository
//public class CourseRepositoryImpl implements CourseRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Course save(Course course){
//        if (course.getId() == null){
//            entityManager.persist(course);
//        }else {
//            course = entityManager.merge(course);
//        }
//        return course;
//    }
//
//    @Override
//    public Optional<Course> findById(Long id) {
//        return Optional.ofNullable(entityManager.find(Course.class , id));
//    }
//
//    @Override
//    public List<Course> findAll() {
//        String jpql = "SELECT c FROM Course c";
//        return entityManager.createQuery(jpql, Course.class).getResultList();
//    }
//
//    @Override
//    public String createCourse(Course course){
//        entityManager.persist(course);
//        return "Course created successfully with ID: " + course.getId();
//    }
//
////    @Override
////    public Course getCourseById(Long id) {
////        return Course.builder()
////                .name("test")
////                .description("test")
////                .build();
////    }
//
//    @Override
//    public void deleteById(Long id) {
//        Course course = entityManager.find(Course.class , id);
//        if (id != null){
//            entityManager.remove(course);
//        }
//    }
//
//}