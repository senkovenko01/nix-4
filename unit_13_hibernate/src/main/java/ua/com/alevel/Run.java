package ua.com.alevel;


import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.dao.TeacherDAO;
import ua.com.alevel.exeption.ResourceWasNotFoundException;
import ua.com.alevel.init.SyncTeachersAndGroups;
import ua.com.alevel.model.dto.NearLesson;
import ua.com.alevel.model.entity.Group;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class Run {
    private final static Logger logger = LoggerFactory.getLogger(Run.class);
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            EntityManager entityManager = sessionFactory.createEntityManager();

            logger.info("Creating database and start linking teachers and groups");
            var init = new SyncTeachersAndGroups();
            init.initLinks(entityManager);
            logger.info("Create links between teachers and groups");

            TeacherDAO teacherDAO = new TeacherDAO(entityManager);
            StudentDAO studentDAO = new StudentDAO(entityManager);

            Long id = Long.valueOf("1");
            try {
                logger.info("Start finding the nearest lesson group for student with id: " + id);
                NearLesson nearLesson = studentDAO.getNearLesson(id);
                System.out.println("\n\n NEAREST LESSON \n" + nearLesson.toString());
                logger.info("The nearest lesson group for student with id: " + id +" is\n" + nearLesson);
            }catch (ResourceWasNotFoundException | RuntimeException e){
                logger.error("The error was occurred ", e);
            }

           try {
                logger.info("Start finding the best group of teacher with id: " + id);
                Group bestGroupOfTeacher = teacherDAO.getTheBestGroupByTeacherId(id);
                teacherDAO.getTheBestGroupByTeacherId(id);
                System.out.println("\n\n BEST GROUP = " + bestGroupOfTeacher.getGroupName());
                logger.info("The best group of teacher with id: " + id +" is " + bestGroupOfTeacher.getGroupName());
            }catch (ResourceWasNotFoundException | RuntimeException e){
                logger.error("The error was occurred ", e);
            }finally {
                entityManager.close();
            }

        }
    }
}
