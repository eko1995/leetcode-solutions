package leetcode;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<> grah = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            grah[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(grah, visited, i)) return false;
        }

        return true;
    }

    public boolean dfs(ArrayList[] grah, boolean[] visited, int i) {
        if (visited[i]) {
            return false;
        } else {
            visited[i] = true;
        }

        for (int j = 0; j < grah[i].size(); j++) {
            int target = (int) grah[i].get(j);
            if (!dfs(grah, visited, target)) {
                return false;
            }
        }

        visited[i] = false;

        return true;
    }
}
