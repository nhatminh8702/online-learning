package vn.edu.fpt.onlinelearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import vn.edu.fpt.onlinelearning.entity.Course;
import vn.edu.fpt.onlinelearning.entity.Lesson;
import vn.edu.fpt.onlinelearning.entity.Quiz;
import vn.edu.fpt.onlinelearning.repository.CourseRepository;
import vn.edu.fpt.onlinelearning.repository.LessonRepository;
import vn.edu.fpt.onlinelearning.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		CourseRepository courseRepository = context.getBean(CourseRepository.class);
		QuizRepository quizRepository = context.getBean(QuizRepository.class);
		LessonRepository lessonRepository = context.getBean(LessonRepository.class);

//		// Uncomment to add data to database
//
//		// Course
//		List<Course> courses = new ArrayList<>();
//		courses.add(new Course("Java fundamental", "Basic knowledge you need to know about Java", 80));
//		courses.add(new Course("C# programming", "Easy to medium C# programming", 60));
//		courses.add(new Course("Design pattern", "About some of the most popular design patterns", 70));
//		courses.add(new Course("Software design", "Designing architecture for software", 100));
//		courseRepository.saveAll(courses);
//
//		// Quiz
//		List<Quiz> quizzes = new ArrayList<>();
//		quizzes.add(new Quiz(courses.get(0), "Java Collections", "", 100));
//		quizzes.add(new Quiz(courses.get(1), "C# basic syntax", "", 100));
//		quizzes.add(new Quiz(courses.get(0), "Java Multi-threading", "", 95));
//		quizzes.add(new Quiz(courses.get(0), "Java exception handling", "", 100));
//		quizRepository.saveAll(quizzes);
//
//		// Lesson
//		List<Lesson> lessons = new ArrayList<>();
//		lessons.add(new Lesson(courses.get(0), "Variables in Java", "A variable is a container which holds the value while the Java program is executed. A variable is assigned with a data type.\n\nVariable is a name of memory location. There are three types of variables in java: local, instance and static.\n\nThere are two types of data types in Java: primitive and non-primitive."));
//		lessons.add(new Lesson(courses.get(0), "Operator in Java", "Operator in Java is a symbol that is used to perform operations. For example: +, -, *, / etc.\n\nThere are many types of operators in Java which are given below:\n\n- Unary Operator,\n- Arithmetic Operator,\n- Shift Operator,\n- Relational Operator,\n- Bitwise Operator,\n- Logical Operator,\n- Ternary Operator and\n- Assignment Operator."));
//		lessons.add(new Lesson(courses.get(0), "Array in Java", "Normally, an array is a collection of similar type of elements which has contiguous memory location.\n\nJava array is an object which contains elements of a similar data type. Additionally, The elements of an array are stored in a contiguous memory location. It is a data structure where we store similar elements. We can store only a fixed set of elements in a Java array.\nArray in Java is index-based, the first element of the array is stored at the 0th index, 2nd element is stored on 1st index and so on.\n\nUnlike C/C++, we can get the length of the array using the length member. In C/C++, we need to use the sizeof operator.\n\nIn Java, array is an object of a dynamically generated class. Java array inherits the Object class, and implements the Serializable as well as Cloneable interfaces. We can store primitive values or objects in an array in Java. Like C/C++, we can also create single dimentional or multidimentional arrays in Java.\n\nMoreover, Java provides the feature of anonymous arrays which is not available in C/C++."));
//		lessonRepository.saveAll(lessons);
	}

}
