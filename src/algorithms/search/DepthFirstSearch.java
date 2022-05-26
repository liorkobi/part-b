package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithms{
    Stack<AState> stack;

    public DepthFirstSearch(){
         stack = new Stack<>();
    }
    public ISearchable DFS(ISearchable problemC){
        ISearchable problem=problemC.clone();
        AState c= problem.getStart();
        // push the source node into the stack
        stack.push(c);

        // loop till stack is empty
        while (!stack.empty())
        {
            // Pop a vertex from the stack
            c = stack.pop();

            // if the vertex is already discovered yet, ignore it
            if (c.getColor() == AState.color.gray) {
                continue;
            }
            ArrayList<AState> uAdj=problem.getAllPossibleStates(c);

            // we will reach here if the popped vertex `v` is not discovered yet;
            // print `v` and process its undiscovered adjacent nodes into the stack
            c.setColor(AState.color.gray);
            counter++;


            // do for every edge (v, u)
            for (int i = uAdj.size() - 1; i >= 0; i--)
            {
                AState u = uAdj.get(i);
                if (u.getColor() == AState.color.white) {
                    u.setParent(c);

                    stack.push(u);

                }
            }
            c.setColor(AState.color.black);
            if (c.equals(problem.getGoal())){break;}
        }
        return problem;}






    @Override
    public Solution solve(ISearchable domain) {
        ISearchable p = DFS(domain);
        Solution S = new Solution();
        TheShortestPath(p, S, p.getGoal());
        return S;
    }

    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return counter;
    }

}