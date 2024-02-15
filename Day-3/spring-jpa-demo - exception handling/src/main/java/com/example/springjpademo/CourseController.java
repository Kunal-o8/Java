package com.example.springjpademo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/courses")
public class CourseController extends ResponseEntityExceptionHandler {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Could not get course with id " + id));
    }

    @PostMapping("/")
    public Course createCourse(@Valid @RequestBody Course course, BindingResult result)
            throws MethodArgumentNotValidException {
        if (result.hasErrors()) {
            throw new MethodArgumentNotValidException(null, result);
        }
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id " + id);
        }
        course.setId(id);
        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) throws Exception {
        if (!courseRepository.existsById(id)) {
            throw new Exception("Did not found course with id " + id);
        }
        courseRepository.deleteById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleCourseNotFoundException(RuntimeException ex) {
        System.out.println("handleCourseNotFoundException");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<Object>
    // handleValidationExceptions(MethodArgumentNotValidException ex) {
    // return new ResponseEntity<>("Validation error", HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Object> handleAllOtherExceptions(Exception ex,
    // HttpServletRequest req) {
    // logger.error("Request: " + req.getRequestURL() + " raised " + ex);

    // return new ResponseEntity<>("An error occurred",
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }
}