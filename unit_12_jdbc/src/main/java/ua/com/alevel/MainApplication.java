package ua.com.alevel;

import ua.com.alevel.dao.impl.LocationDAOImpl;
import ua.com.alevel.dao.impl.ProblemDAOImpl;
import ua.com.alevel.dao.impl.RouteDAOImpl;
import ua.com.alevel.dao.impl.SolutionDAOImpl;
import ua.com.alevel.util.ConnectionManager;
import ua.com.alevel.model.Location;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Route;
import ua.com.alevel.model.Solution;
import ua.com.alevel.util.PathInGraph;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.getConnection()) {

            LocationDAOImpl locationDAOImpl = new LocationDAOImpl(connection);
            RouteDAOImpl routeDAOImpl = new RouteDAOImpl(connection);
            ProblemDAOImpl problemDAOImpl = new ProblemDAOImpl(connection);
            SolutionDAOImpl solutionDAOimpl = new SolutionDAOImpl(connection);

            List<Location> locations = locationDAOImpl.read();
            List<Route> routes = routeDAOImpl.read();
            List<Problem> problems = problemDAOImpl.read();

            PathInGraph pathInGraph = new PathInGraph(locations, routes);
            for (Problem problem : problems) {
                int cost = pathInGraph.determineShortestPath(problem.getIdFrom(), problem.getIdTo());
                Solution solution = new Solution(cost);
                solutionDAOimpl.update(problem.getId(), solution);
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
